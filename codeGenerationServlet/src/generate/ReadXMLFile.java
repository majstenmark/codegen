package generate;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
 
public class ReadXMLFile {
 
	public static void readXMLFile() {
		ReadXMLFile obj = new ReadXMLFile();
		obj.run();
    		
	}

	public State handleActionNode(Node actionNode){

		String stateName = ((Element)actionNode).getAttribute("id");

		State s = new State(stateName);
		
		NodeList nodes = actionNode.getChildNodes();
		for (int temp = 0; temp < nodes.getLength(); temp++) {
			Node node = nodes.item(temp);
			if( node.getNodeName().equals("Constraint") ){
				Element constraintElement = (Element) node;
				String type = constraintElement.getElementsByTagName("type").item(0).getTextContent();
				String controllerId = constraintElement.getElementsByTagName("controllerId").item(0).getTextContent();
				String motionFrame = constraintElement.getElementsByTagName("motionframe").item(0).getTextContent();
				String motionDir = constraintElement.getElementsByTagName("motiondir").item(0).getTextContent();
				double reference = Double.parseDouble(constraintElement.getElementsByTagName("value").item(0).getTextContent());
				String referenceUnit = ((Element)constraintElement.getElementsByTagName("value").item(0)).getAttribute("unit");

				Constraint c = new Constraint(type,controllerId,motionFrame,motionDir,reference,referenceUnit);
				s.addConstraint(c);
			} else if( node.getNodeName().equals("Direction") ){
				Element directionElement = (Element) node;
				double searchVelocity = Double.parseDouble(directionElement.getElementsByTagName("searchVelocity").item(0).getTextContent());
				String unit = ((Element)directionElement.getElementsByTagName("searchVelocity").item(0)).getAttribute("unit");
				String motionFrame = directionElement.getElementsByTagName("motionframe").item(0).getTextContent();
				String motionDir = directionElement.getElementsByTagName("motiondir").item(0).getTextContent();
				double threshold = Double.parseDouble(directionElement.getElementsByTagName("threshold").item(0).getTextContent());
				String thresholdUnit = ((Element)directionElement.getElementsByTagName("threshold").item(0)).getAttribute("unit");

				Direction d = new Direction(motionFrame,motionDir,searchVelocity,unit,threshold,thresholdUnit);
				s.setDirection(d);
			} 
		} 
		return s;
	}
	
	public void run(){
		try {
			 
			File fXmlFile = new File("skill.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
 		
			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();
 	
	
			Element rootElement = doc.getDocumentElement();
			NodeList nodes = rootElement.getChildNodes();
		 
			ArrayList<State> stateList = new ArrayList<State>();
			ArrayList<Frame> frameList = new ArrayList<Frame>();
			ArrayList<ImpedanceController> controllerList = new ArrayList<ImpedanceController>();
 	
			for (int temp = 0; temp < nodes.getLength(); temp++) {
		 
				Node node = nodes.item(temp);
				if( node instanceof Element ){
					System.out.println("\nCurrent Element is element:" + node.getNodeName());
					if( node.getNodeName().equals("Action") ){
						State s = handleActionNode(node);
						stateList.add(s);
					} else if( node.getNodeName().equals("Frame") ){
						Frame f = handleFrameNode(node);
						frameList.add(f);
						double[] d = f.getYZXEulerAngles();
						System.out.println("Phi: "+d[0]+"  Theta: "+d[1]+"   Psi: "+d[2]);
					} else if( node.getNodeName().equals("ImpedanceControlParams") ){
						ImpedanceController i = handleImpedanceControllerNode(node);
						controllerList.add(i);
					}
				}
 	
			}
			System.out.println("Number of states: "+stateList.size());
			System.out.println("Number of frames: "+frameList.size());
			System.out.println("Number of controllers: "+controllerList.size());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public Frame handleFrameNode(Node frameNode){
		
		Element frameElement = (Element) frameNode;

		String frameName = frameElement.getAttribute("id");

		String origin = frameElement.getElementsByTagName("origin").item(0).getTextContent();
		double[] originCoords = new double[3];		
		int start = origin.indexOf("[");
		int stop = origin.indexOf(",",start+1);
		originCoords[0] = Double.parseDouble(origin.substring(start+1,stop));
		start = stop;
		stop = origin.indexOf(",",start+1);
		originCoords[1] = Double.parseDouble(origin.substring(start+1,stop));
		start = stop;
		stop = origin.indexOf("]",start+1);
		originCoords[2] = Double.parseDouble(origin.substring(start+1,stop));


		String quaternion = frameElement.getElementsByTagName("quaternion").item(0).getTextContent();
		double[] quatCoords = new double[4];		
		start = quaternion.indexOf("[");
		stop = quaternion.indexOf(",",start+1);
		quatCoords[0] = Double.parseDouble(quaternion.substring(start+1,stop));
		start = stop;
		stop = quaternion.indexOf(",",start+1);
		quatCoords[1] = Double.parseDouble(quaternion.substring(start+1,stop));
		start = stop;
		stop = quaternion.indexOf(",",start+1);
		quatCoords[2] = Double.parseDouble(quaternion.substring(start+1,stop));
		start = stop;
		stop = quaternion.indexOf("]",start+1);
		quatCoords[3] = Double.parseDouble(quaternion.substring(start+1,stop));

		Frame f = new Frame(frameName,originCoords,quatCoords);
		
		return f;
		
	}

	public ImpedanceController handleImpedanceControllerNode(Node impNode){
		
		Element impElement = (Element) impNode;

		String impName = impElement.getAttribute("id");

		double M = Double.parseDouble(impElement.getElementsByTagName("M").item(0).getTextContent());
		double D = Double.parseDouble(impElement.getElementsByTagName("D").item(0).getTextContent());

		ImpedanceController i = new ImpedanceController(impName,M,D);

		return i;		
	}
 


class State{
	private Direction d;
	private ArrayList<Constraint> constraintList;
	private String name;

	public State(String name){
		constraintList = new ArrayList<Constraint>();
		this.name = name;
	}

	public void setDirection(Direction dir){
		d = dir;
	}

	public void addConstraint(Constraint con){
		constraintList.add(con);
	}
}

class Constraint{
	private String type;
	private String controllerId;
	private String motionFrame;
	private String motionDir;
	private double reference;
	private String referenceUnit;

	public Constraint(String type, String ctrlId, String motionFrame, String motionDir, double ref, String unit){
		this.type = type;
		this.controllerId = ctrlId;
		this.motionFrame = motionFrame;
		this.motionDir = motionDir;
		this.reference = ref;
		this.referenceUnit = unit;
	}
}

class Direction{
	private String motionFrame;
	private String motionDir;
	private double searchVelocity;
	private String unit;
	private double threshold;
	private String thresholdUnit;

	public Direction(String motionFrame, String motionDir, double searchVelocity, String unit, double threshold, String thresholdUnit){
		this.motionFrame = motionFrame;
		this.motionDir = motionDir;
		this.searchVelocity = searchVelocity;
		this.unit = unit;
		this.threshold = threshold;
		this.thresholdUnit = thresholdUnit;
	}
}

public class Frame{
	private String name;
	private double[] origin = {0.0,0.0,0.0};
	private double[] quaternion = {1.0,0.0,0.0,0.0};

	public Frame(String name, double[] o, double[] q){
		this.name = name;
		origin[0] = o[0];
		origin[1] = o[1];
		origin[2] = o[2];
		quaternion[0] = q[0];
		quaternion[1] = q[1];
		quaternion[2] = q[2];
		quaternion[3] = q[3];		
	}

	/** quaternion can be non-normalised */
	public double[] getYZXEulerAngles() {
		double phi = 0;
		double theta = 0;
		double psi = 0;
		double qw = quaternion[0];
		double qx = quaternion[1];
		double qy = quaternion[2];
		double qz = quaternion[3];
		double sqw = qw*qw;
		double sqx = qx*qx;
		double sqy = qy*qy;
		double sqz = qz*qz;
		double unit = sqx + sqy + sqz + sqw; // if normalised is one, otherwise is correction factor
		double test = qx*qy + qz*qw;
		if (test > 0.499*unit) { // singularity at north pole
			phi = 2*Math.atan2(qx,qw);
			theta = Math.PI/2;
			psi = 0;
		} else if (test < -0.499*unit) { // singularity at south pole
			phi = -2*Math.atan2(qx,qw);
			theta = -Math.PI/2;
			psi = 0;
		} else {
			phi = Math.atan2(2*qy*qw-2*qx*qz , sqx - sqy - sqz + sqw);
			theta = Math.asin(2*test/unit);
			psi = Math.atan2(2*qx*qw-2*qy*qz , -sqx + sqy - sqz + sqw);
		}

		double[] d = {phi,theta,psi};
		return d;
	}
}

class ImpedanceController {
	private double D;
	private double M;
	private String name;

	public ImpedanceController(String name, double M, double D){
		this.name = name;
		this.M = M;
		this.D = D;
	}
}
}
