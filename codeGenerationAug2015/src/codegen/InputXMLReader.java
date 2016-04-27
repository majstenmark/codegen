package codegen;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.catalina.tribes.util.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList; 
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class InputXMLReader {

	public static List<TaskSpecification> readXML(String xml) {

		try {

			File fXmlFile = new File(xml);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
 		
			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();


			Element rootElement = doc.getDocumentElement();
			NodeList nodes = rootElement.getChildNodes();
			List<TaskSpecification> tasks = new ArrayList<TaskSpecification>();
			for (int temp = 0; temp < nodes.getLength(); temp++) {

				Node node = nodes.item(temp);

				if( node.getNodeName().equals("Task") ){
					TaskSpecification t = createTask(node);
					tasks.add(t);
					//	output += "inuti task";
					// TODO add to list of tasks!!!
					//System.out.println(t.toString());
					//	String outputFileXml = createFile(t);


				} 

			}

			return tasks;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}


	private static  TaskSpecification createTask(Node taskNode){

		String task_name = ((Element)taskNode).getAttribute("name");

		String labcomm_ip = ((Element)taskNode).getAttribute("labcomm_ip");
		String labcomm_port = ((Element)taskNode).getAttribute("labcomm_port");
		String robotTypeName = ((Element)taskNode).getAttribute("robot");
		RobotType robotType = GenerateJGrafchartXML.getRobotType(robotTypeName);
		TaskSpecification task = new TaskSpecification(robotType, task_name, labcomm_ip, labcomm_port);

		NodeList nodes = taskNode.getChildNodes();
		for (int temp = 0; temp < nodes.getLength(); temp++) {
			Node node = nodes.item(temp);
			Specification e = parseNode(node, task);
			if(e != null)task.addSkill(e);

		}

		return task;		

	}
	
	public static Specification parseNode(Node node, TaskSpecification task){
		if( node.getNodeName().equals("Primitive") ){
			//System.out.println("Found primitive!");
			Element primitiveElement = (Element) node;
			String f = primitiveElement.getAttribute("function_call");

			String name = primitiveElement.getAttribute("name");
			PrimitiveSpecification prim = new PrimitiveSpecification(name, f);

			NodeList params = node.getChildNodes();
			for(int k = 0; k < params.getLength(); k++){

				Node p = params.item(k);
				if(p.getNodeName().equals("Parameter") )
				{
					Element pe = (Element) p;
					String type = pe.getAttribute("type");
					String v = pe.getAttribute("value");
					if(type == null){
						Parameter param = new Parameter(v);
						prim.addParam(param);
					}else{
						Parameter param = new Parameter(type, v);
						prim.addParam(param);

					}
				}
			}
			return prim;
		}
		if( node.getNodeName().equals("Skill") ){
			Element skillElement = (Element) node;
			String skillUrl = skillElement.getAttribute("url");
			return new SkillSpecification(skillUrl);

			//TODO what to read from the xml...
		}
		if( node.getNodeName().equals("SkillSpecification") ){

			Element guardedNode = (Element) node;
			String name = guardedNode.getAttribute("id");
			HashMap<String, Frame> frames = new HashMap<>();
			HashMap<String, ToolTransform> toolTransforms = new HashMap<>();
			
			NodeList frameNodes = guardedNode.getElementsByTagName("Frame");
			for(int i = 0; i < frameNodes.getLength(); i++){
				Node n = frameNodes.item(i);
				Frame f = readFrame(n);
				frames.put(f.getName(), f);
			}
			NodeList toolTransformNodes = guardedNode.getElementsByTagName("ToolTransform");
			for(int i = 0; i < toolTransformNodes.getLength(); i++){
				Node n = toolTransformNodes.item(i);
				ToolTransform f = readToolTransform(n);
				toolTransforms.put(f.getName(), f);
			}
			NodeList actionNodes = guardedNode.getElementsByTagName("Action");
			NestedStateMachineSpecification nested = new NestedStateMachineSpecification();
			
			for(int i = 0; i < actionNodes.getLength(); i++){
				
				GuardedMotionSpecification guardedMotion = new GuardedMotionSpecification(name, task.robotType);
				NodeList directionNodes = guardedNode.getElementsByTagName("Direction");
				for(int dir = 0; dir < directionNodes.getLength(); dir++){
					Direction d = getDirection(directionNodes.item(dir));
					FinalConstraint finalC = getFinalConstraint(directionNodes.item(dir));
					guardedMotion.addFinalConstraint(finalC);
					guardedMotion.addDirection(d);
					// do something with the direction!
				}
				NodeList constraintNodes = guardedNode.getElementsByTagName("Constraint");
				for(int c = 0; c < constraintNodes.getLength(); c++){
					Constraint constraint = getConstraint(constraintNodes.item(c));
					guardedMotion.addMotionConstraint(constraint);
				}
				nested.addSpecification(guardedMotion);
				
			}
			return nested;
			
			//return guardedMotion;
			//task.addSkill(guardedMotion);
			
		}
		/*if( node.getNodeName().equals("PalletizingStep") ){
		
			//Element primitiveElement = (Element) node;
			LoopStep loop = new LoopStep();
			//	task.addSkill(loop);
			NodeList params = node.getChildNodes();
			for(int k = 0; k < params.getLength(); k++){
				Node p = params.item(k);

				if(p.getNodeName().equals("Order1") )
				{

					Element e = (Element) node;
					String item1 = e.getAttribute("item1");
					String item2 = e.getAttribute("item2");
					loop.addOrder(1,  item1,  item2);
				}
				else if(p.getNodeName().equals("Order2") )
				{

					Element e = (Element) node;
					String item1 = e.getAttribute("item1");
					String item2 = e.getAttribute("item2");
					loop.addOrder(2,  item1,  item2);
				}else
				{
				//	System.out.println(p.getNodeName());
					Specification e = parseNode(p);
					if(e!= null)loop.addProgramElement(e);
				}
			}
			return loop;*/
		//}
		return null;


	}
	

	private static Constraint getConstraint(Node n){
		// public Constraint(String type, String ctrlId, String motionFrame, String motionDir, double ref, String unit){
		throw new UnsupportedOperationException();
	}
	
	private static FinalConstraint getFinalConstraint(Node n){
		// public FinalConstraint(String type, String motionFrame, String motionDir, double threshold, String thresholdUnit){

		String threUnit = null;
		double thresVal = 0;
		String frameName = null;
		String motionDir = null;
		NodeList l = n.getChildNodes();
		for(int i = 0; i < l.getLength(); i++){
			Node p = l.item(i);
			if(p.getNodeName().equals("motionframe")){
				
				frameName = p.getChildNodes().item(0).getNodeValue();
			}
			if(p.getNodeName().equals("motiondir")){
				
				motionDir = p.getChildNodes().item(0).getNodeValue();
			}
			if(p.getNodeName().equals("threshold")){
				Element e = (Element) p;
				threUnit = e.getAttribute("unit");
				String val = p.getChildNodes().item(0).getNodeValue();
				thresVal = Double.parseDouble(val);
			}
			
		}
		Controller type = Controller.FORCE;
		FinalConstraint finalC = new FinalConstraint(type, frameName, motionDir, thresVal, threUnit);
		return finalC;
	}
	
	
	private static Direction getDirection(Node n){
		
		/* <Direction>
		<searchVelocity unit="mm/s">20</searchVelocity>
		<motionframe>forcesensorframe</motionframe>
		<motiondir>z</motiondir>
		<threshold unit="N">2</threshold>
		</Direction> */
		// 
		//public Direction(String motionFrame, String motionDir, double searchVelocity, String unit){
		
		String frameName = null;
		double velocity = 0;
		String velUnit = null;
		String motionDir = null;
		
		NodeList l = n.getChildNodes();
		for(int i = 0; i < l.getLength(); i++){
			Node p = l.item(i);
			if(p.getNodeName().equals("searchVelocity")){
				Element e = (Element) p;
				velUnit = e.getAttribute("unit");
				String velVal = p.getChildNodes().item(0).getNodeValue();
				velocity = Double.parseDouble(velVal);
			}
			if(p.getNodeName().equals("motionframe")){
				
				frameName = p.getChildNodes().item(0).getNodeValue();
			}
			if(p.getNodeName().equals("motiondir")){
				
				motionDir = p.getChildNodes().item(0).getNodeValue();
			}
			
			
		}
		Direction d = new Direction(frameName, motionDir, velocity, velUnit);
		
		return d;
	}
	
	private static ToolTransform readToolTransform(Node n) {
		
		Element e = (Element) n;
		String name = e.getAttribute("id");
		double[] origin = null;
		double[] q = null;
		NodeList l = n.getChildNodes();
		for(int i = 0; i < l.getLength(); i++){
			Node p = l.item(i);
			if(p.getNodeName().equals("trans")){
				String oStr = p.getChildNodes().item(0).getNodeValue();
				origin = readDoubleArray(oStr);
				
			}
			if(p.getNodeName().equals("quaternion")){
				String qStr = p.getChildNodes().item(0).getNodeValue();
				q = readDoubleArray(qStr);
				
			}
		}
		ToolTransform frame= new ToolTransform(name, origin, q);
		return frame;
	}


	private static Frame readFrame(Node n){
	
		Element e = (Element) n;
		String name = e.getAttribute("id");
		double[] origin = null;
		double[] q = null;
		NodeList l = n.getChildNodes();
		for(int i = 0; i < l.getLength(); i++){
			Node p = l.item(i);
			if(p.getNodeName().equals("origin")){
				String oStr = p.getChildNodes().item(0).getNodeValue();
				origin = readDoubleArray(oStr);
				
			}
			if(p.getNodeName().equals("quaternion")){
				String qStr = p.getChildNodes().item(0).getNodeValue();
				q = readDoubleArray(qStr);
				
			}
		}
		Frame frame= new Frame(name, origin, q);
		return frame;
	}

	private static double[] readDoubleArray(String s){
		s = s.replace("[", "");
		s = s.replace("]", "");
		String[] valueStr = s.split(",");
		double[] values = new double[valueStr.length];
		for(int i = 0; i < values.length; i++){
			values[i] = Double.parseDouble(valueStr[i]);
		}
		return values;
	}








/*
	public void run(){
		try {

			File fXmlFile = new File("skill.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			org.w3c.dom.Document doc = dBuilder.parse(fXmlFile);

			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();


			Element rootElement = (Element) doc.getDocumentElement();
			NodeList nodes = ((Node) rootElement).getChildNodes();

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
 */

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
			FinalConstraint finalC = new FinalConstraint(Controller.FORCE, motionFrame, motionDir, threshold, thresholdUnit);
			Direction d = new Direction(motionFrame,motionDir,searchVelocity,unit);
			s.setFinalConstraint(finalC);
			s.setDirection(d);
		} 
	} 
	return s;
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






}
/*
 * package generate;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;






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
/*
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

 * 
 */

