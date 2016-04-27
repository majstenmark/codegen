package generate;


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
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
//import org.apache.juli.logging.LogFactory;






import org.apache.catalina.tribes.util.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList; 
import org.xml.sax.InputSource;

/**
 * Servlet implementation class GenerateCode
 */
@WebServlet("/GenerateCode")
public class GenerateCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static RobotType robotType;
	private HashSet<String> workobjectNames = new HashSet<String>();
	private int currentYValue, currentLinkX, transitionX, linkY;
	private int currentXValue;
	public static ServletContext context;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GenerateCode() {
		super();
		// TODO Auto-generated constructor stub
	}

	enum Controller{RAPID, ExtCntr};

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		workobjectNames = new HashSet<String>();
		PrintWriter out = response.getWriter();

		context = getServletContext();
		String xml = request.getParameter("xml");
		if (xml != null) {
			//  String output = URLEncoder.encode(res, "UTF-8");
			//	
			GenerateCode generator = new GenerateCode();
			String input = URLDecoder.decode(xml, "UTF-8");
			String output = generator.readXML(input);
			//String fullPath = "/Users/maj/git/codegen/codeGenerationServlet/WebContent/WEB-INF/";
			String fullPath = "/WebContent/WEB-INF/";

			ReadWriteTextFile rwtf = new ReadWriteTextFile();
			String templateXml = rwtf.getContents(new File(fullPath +"/Template.txt"));
			templateXml = templateXml.replace("TASKDECLARATION", output);
			
			
			//

			out.println(URLEncoder.encode(templateXml, "UTF-8"));
		} else {
			out.println("No input");
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	public static void main(String[] args){

		System.out.println("WTF0 ");
		GenerateCode generator = new GenerateCode();
		ReadWriteTextFile rwtf = new ReadWriteTextFile();
		File pwd = new File(".");

		String testInput = rwtf.getContents(new File("/Users/maj/git/codegen/codeGenerationServlet/WebContent/WEB-INF/TestInput3.txt"));
		String test = generator.readXML(testInput);
		//String fullPath = "/Users/maj/git/codegen/codeGenerationServlet/WebContent/WEB-INF/";
		String fullPath = context.getRealPath("/WEB-INF") + "/";
		String templateXml = rwtf.getContents(new File(fullPath +"/Template.txt"));
		templateXml = templateXml.replace("TASKDECLARATION", test);
		
		
		File f = new File(fullPath + "/WebContent/mynewtestFile2.xml");

		try {
 
			f.createNewFile();
			rwtf.setContents(f, templateXml);
		}catch(Exception e){}
/*
//	    String host = "http://vm25.cs.lth.se";
		String host = "http://localhost:8080";
	        String narrative;
			try {
				narrative = URLEncoder.encode(testInput, "UTF-8");
				System.out.println("Start test!");
			//	System.out.println(host + "/codeGeneration/GenerateCode?xml=" + narrative);
				 URL codegen = new URL(host + "/codeGenerationServlet/GenerateCode?xml=" + narrative);
			        InputStream is = codegen.openStream();
			        BufferedReader bReader =
			                new BufferedReader(new InputStreamReader(is));
			       // System.out.println("HELOsasfasda");
			        String line;
//String test = "";
			    //    System.out.println("Got answer!");
			        while ((line = bReader.readLine()) != null) {
			        	String str = URLDecoder.decode(line, "UTF-8");
			            System.out.println(str);
			            test += str;
			            
			}
			        
			        File f = new File("./mynewtestFile.xml");

					try {

						f.createNewFile();
						rwtf.setContents(f, test);
					}catch(Exception e){}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
	       
	        

	}

	public String readXML(String xml) {

		String output = ""; //"HEjsan!" + xml;

		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			InputSource is = new InputSource(new StringReader(xml));
			Document doc = dBuilder.parse(is);


			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();


			Element rootElement = doc.getDocumentElement();
			NodeList nodes = rootElement.getChildNodes();

			for (int temp = 0; temp < nodes.getLength(); temp++) {

				Node node = nodes.item(temp);
				int xpos = 450;
				int xoffset = 450;
				if( node.getNodeName().equals("Task") ){
					Task t = createTask(node);
				
				//	output += "inuti task";
					// TODO add to list of tasks!!!
					//System.out.println(t.toString());
					String outputFileXml = createFile(t, xpos);
					xpos += xoffset;
					output += outputFileXml;


				} 

			}



		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;


	}

	private  Task createTask(Node taskNode){

		String task_name = ((Element)taskNode).getAttribute("name");

		String labcomm_ip = ((Element)taskNode).getAttribute("labcomm_ip");
		String labcomm_port = ((Element)taskNode).getAttribute("labcomm_port");
		String robotTypeName = ((Element)taskNode).getAttribute("robot");
		RobotType robotType = GenerateJGrafchartXML.getRobotType(robotTypeName);
		this.robotType = robotType;
		Task task = new Task(task_name, labcomm_ip, labcomm_port);

		NodeList nodes = taskNode.getChildNodes();
		for (int temp = 0; temp < nodes.getLength(); temp++) {
			Node node = nodes.item(temp);
			ProgramElement e = parseNode(node);
			task.addSkill(e);

		}

		return task;		

	}

	private UUID endLoop(UUID connectedTransition, int counter, UUID startLoop, int oldX, int oldY, int limit){
		UUID stepId = generateUniqueId();
		UUID tmpTrans = generateUniqueId(); 
		String stepTmp = endLoop.replaceFirst("ID1", stepId.toString());
		stepTmp = stepTmp.replace("ID2", tmpTrans.toString());
		stepTmp = stepTmp.replace("ID3", startLoop.toString());
		
		String linkTmp = linkXml.replace("ID1", connectedTransition.toString());
		linkTmp = linkTmp.replace("ID2", stepId.toString());
		linkTmp = linkTmp.replace("X3", ""+currentLinkX);
		linkTmp = linkTmp.replace("Y3", ""+linkY);
		linkTmp = linkTmp.replace("X4", ""+currentLinkX);
		linkTmp = linkTmp.replace("Y4", ""+currentYValue);

		links.append(linkTmp);
		stepTmp = stepTmp.replaceAll("X1",""+currentXValue );
		stepTmp = stepTmp.replaceAll("Y1", ""+currentYValue);

		//stepTmp = stepTmp.replaceAll("X2",""+oldX );
		//stepTmp = stepTmp.replaceAll("Y2", ""+oldY);
		stepTmp = stepTmp.replace("X3", ""+currentLinkX);
		stepTmp = stepTmp.replace("Y3", ""+linkY);
		stepTmp = stepTmp.replace("X4", ""+(currentLinkX+ 100));
		stepTmp = stepTmp.replace("Y4", ""+linkY);
		stepTmp = stepTmp.replace("X5", ""+(currentLinkX+ 100));
		stepTmp = stepTmp.replace("Y5", ""+oldY);
		stepTmp = stepTmp.replace("X6", ""+oldX);
		stepTmp = stepTmp.replace("Y6", ""+oldY);
		
		linkY = currentYValue + 70;
		currentYValue+=90;
		// attach it to the previous transition
		stepTmp = stepTmp.replace("LOOP_COUNTER", "loop_counter_" + counter);

		stepTmp = stepTmp.replace("LIMIT", ""+limit);
		
		steps.append(stepTmp);

			UUID newTransId = generateUniqueId();
			String transTmp = transXml.replace("ID", newTransId.toString());
			String cond = "loop_counter_" + counter + " &gt;= " + limit;
			transTmp = transTmp.replace("LC.proc.status == 1", cond);
			transTmp = transTmp.replace("X1", ""+transitionX);
			transTmp = transTmp.replace("Y1", ""+currentYValue);
			String link2Tmp = linkXml.replace("ID2", newTransId.toString());
			link2Tmp = link2Tmp.replace("ID1", stepId.toString());
			link2Tmp = link2Tmp.replace("X3", ""+currentLinkX);
			link2Tmp = link2Tmp.replace("Y3", ""+linkY);
			link2Tmp = link2Tmp.replace("X4", ""+currentLinkX);
			link2Tmp = link2Tmp.replace("Y4", ""+currentYValue);
			links.append(link2Tmp);

			transitions.append(transTmp);

			UUID oldConnection = generateUniqueId();
			String oldTrans = transXml.replace("ID", oldConnection.toString());
			cond = "loop_counter_" + counter + " &lt; " + limit;
			oldTrans = oldTrans.replace("LC.proc.status == 1", cond);
			oldTrans = oldTrans.replace("X1", ""+transitionX);
			oldTrans = oldTrans.replace("Y1", ""+currentYValue);
			link2Tmp = linkXml.replace("ID2", oldConnection.toString());
			link2Tmp = link2Tmp.replace("ID1", stepId.toString());
			link2Tmp = link2Tmp.replace("X3", ""+currentLinkX);
			link2Tmp = link2Tmp.replace("Y3", ""+linkY);
			link2Tmp = link2Tmp.replace("X4", ""+currentLinkX);
			link2Tmp = link2Tmp.replace("Y4", ""+currentYValue);
			String link3Tmp = linkXml.replace("ID2",startLoop.toString());
			link3Tmp = link3Tmp.replace("ID1", oldConnection.toString());
			link3Tmp = link3Tmp.replace("X3", ""+currentLinkX);
			link3Tmp = link3Tmp.replace("Y3", ""+linkY);
			link3Tmp = link3Tmp.replace("X4", ""+oldX);
			link3Tmp = link3Tmp.replace("Y4", ""+oldY);
			links.append(link2Tmp);
			links.append(link3Tmp);
			
			
			linkY = currentYValue + 25;
			currentYValue+=45;
			
			transitions.append(oldTrans);

			connectedTransition = newTransId;
			
		return connectedTransition;
		
	}
	
	private UUID startLoop(UUID connectedTransition, int counter, LoopStep step){
		UUID stepId = generateUniqueId();
		
		String stepTmp = startLoop.replaceFirst("ID", stepId.toString());

		String linkTmp = linkXml.replace("ID1", connectedTransition.toString());
		linkTmp = linkTmp.replace("ID2", stepId.toString());
		linkTmp = linkTmp.replace("X3", ""+currentLinkX);
		linkTmp = linkTmp.replace("Y3", ""+linkY);
		linkTmp = linkTmp.replace("X4", ""+currentLinkX);
		linkTmp = linkTmp.replace("Y4", ""+currentYValue);

		links.append(linkTmp);
		stepTmp = stepTmp.replaceAll("X1",""+currentXValue );
		stepTmp = stepTmp.replaceAll("Y1", ""+currentYValue);
		linkY = currentYValue + 70;
		currentYValue+=90;
		// attach it to the previous transition
		stepTmp = stepTmp.replace("LOOP_COUNTER", "loop_counter_" + counter);
		stepTmp = stepTmp.replace("PICK_LIST_NAME", "pick_list_"+counter);
		stepTmp = stepTmp.replace("PLACE_LIST_NAME", "place_list_"+counter);

		stepTmp = stepTmp.replace("VALUES1", step.values1());

		stepTmp = stepTmp.replace("VALUES2", step.values2());
		steps.append(stepTmp);

			UUID newTransId = generateUniqueId();
			String transTmp = emptyTrans.replace("ID", newTransId.toString());
			transTmp = transTmp.replace("X1", ""+transitionX);
			transTmp = transTmp.replace("Y1", ""+currentYValue);
			String link2Tmp = linkXml.replace("ID2", newTransId.toString());
			link2Tmp = link2Tmp.replace("ID1", stepId.toString());
			link2Tmp = link2Tmp.replace("X3", ""+currentLinkX);
			link2Tmp = link2Tmp.replace("Y3", ""+linkY);
			link2Tmp = link2Tmp.replace("X4", ""+currentLinkX);
			link2Tmp = link2Tmp.replace("Y4", ""+currentYValue);
			links.append(link2Tmp);
			linkY = currentYValue + 25;
			currentYValue+=45;
			transitions.append(transTmp);

			connectedTransition = newTransId;
			
		return connectedTransition;
		
	}
	
	private UUID[] turnOffExtCtrl(UUID connectedTransition){
		UUID turnOffId = generateUniqueId();
		UUID transition = generateUniqueId();
		int armNbr = robotType.equals(RobotType.FridaLeftArm)? 2:1;
		String link2Tmp = linkXml.replace("ID2", turnOffId.toString());
		link2Tmp = link2Tmp.replace("ID1", connectedTransition.toString());
		link2Tmp = link2Tmp.replace("X3", ""+currentLinkX);
		link2Tmp = link2Tmp.replace("Y3", ""+linkY);
		link2Tmp = link2Tmp.replace("X4", ""+currentLinkX);
		link2Tmp = link2Tmp.replace("Y4", ""+currentYValue);

		links.append(link2Tmp);

		String turnOff = turnOffEx.replaceAll("ID1", turnOffId.toString());
		turnOff = turnOff.replaceAll("ARMNBR", ""+armNbr);

		turnOff = turnOff.replaceAll("ID2", transition.toString());
		turnOff = turnOff.replaceAll("X1", ""+currentXValue);
		turnOff = turnOff.replaceAll("Y1", ""+currentYValue);
		linkY = currentYValue + 70;
		currentYValue+=90;
		turnOff = turnOff.replaceAll("X2", ""+transitionX);
		turnOff = turnOff.replaceAll("Y2", ""+currentYValue);
		turnOff = turnOff.replaceAll("X3", ""+currentLinkX);
		turnOff = turnOff.replaceAll("Y3", ""+linkY);
		turnOff = turnOff.replaceAll("X4", ""+currentLinkX);
		turnOff = turnOff.replaceAll("Y4", ""+currentYValue);
		linkY = currentYValue + 25;
		currentYValue+=45;
		connectedTransition = transition;
		steps.append(turnOff);

		UUID[] r = {connectedTransition, turnOffId};
		return r;
		
	}
	
	private UUID[] createPrimitiveJGc(String taskname, Controller activeController, UUID connectedTransition, boolean notlast, String procedurename, boolean rem){
		if(activeController==Controller.ExtCntr){
			// turn off extcontrol!
			UUID[] ans = turnOffExtCtrl(connectedTransition);
			connectedTransition = ans[0];
			activeController = Controller.RAPID;
		}
		UUID stepId = generateUniqueId();
		String stepTmp = stepXml.replaceFirst("ID", stepId.toString());

		String linkTmp = linkXml.replace("ID1", connectedTransition.toString());
		linkTmp = linkTmp.replace("ID2", stepId.toString());
		linkTmp = linkTmp.replace("X3", ""+currentLinkX);
		linkTmp = linkTmp.replace("Y3", ""+linkY);
		linkTmp = linkTmp.replace("X4", ""+currentLinkX);
		linkTmp = linkTmp.replace("Y4", ""+currentYValue);

		links.append(linkTmp);
		stepTmp = stepTmp.replaceAll("LC",taskname);
		stepTmp = stepTmp.replaceAll("X1",""+currentXValue );
		stepTmp = stepTmp.replaceAll("Y1", ""+currentYValue);
		linkY = currentYValue + 70;
		currentYValue+=90;
		// attach it to the previous transition
		if(!rem)stepTmp = stepTmp.replace("PROCEDURENAME", procedurename);
		else{
			stepTmp = stepTmp.replace("PROCEDURENAME&quot;", procedurename);
		}
		steps.append(stepTmp);

		if(notlast){
			UUID newTransId = generateUniqueId();
			String transTmp = transXml.replace("ID", newTransId.toString());
			transTmp = transTmp.replace("X1", ""+transitionX);
			transTmp = transTmp.replace("Y1", ""+currentYValue);
			transTmp = transTmp.replaceAll("LC", taskname);

			String link2Tmp = linkXml.replace("ID2", newTransId.toString());
			link2Tmp = link2Tmp.replace("ID1", stepId.toString());
			link2Tmp = link2Tmp.replace("X3", ""+currentLinkX);
			link2Tmp = link2Tmp.replace("Y3", ""+linkY);
			link2Tmp = link2Tmp.replace("X4", ""+currentLinkX);
			link2Tmp = link2Tmp.replace("Y4", ""+currentYValue);
			links.append(link2Tmp);
			linkY = currentYValue + 25;
			currentYValue+=45;
			transitions.append(transTmp);

			connectedTransition = newTransId;
		}	
		UUID[] r = {connectedTransition, stepId};
		return r;
	}
	
	private UUID[] createGuardedMotion(String taskname, Controller activeController, UUID connectedTransition, boolean notlast, GuardedMotion motion, int skillNbr){
		if(activeController!=Controller.ExtCntr){
			UUID[] ans = turnOnExtCtrl(taskname, connectedTransition);
			connectedTransition = ans[0];
			// turn on extcontrol!
		/*	UUID turnOnId = generateUniqueId();
			UUID transition = generateUniqueId();
			int armNbr = robotType.equals(RobotType.FridaLeftArm)? 2:1;
			String link2Tmp = linkXml.replace("ID2", turnOnId.toString());
			link2Tmp = link2Tmp.replace("ID1", connectedTransition.toString());

			link2Tmp = link2Tmp.replace("X3", ""+currentLinkX);
			link2Tmp = link2Tmp.replace("Y3", ""+linkY);
			link2Tmp = link2Tmp.replace("X4", ""+currentLinkX);
			link2Tmp = link2Tmp.replace("Y4", ""+currentYValue);
			links.append(link2Tmp);
			String turnOn = turnOnEx.replaceAll("ARMNBR", ""+armNbr);
			turnOn = turnOn.replaceAll("ID1", turnOnId.toString());
			turnOn = turnOn.replaceAll("ID2", transition.toString());
			turnOn = turnOn.replaceAll("X1", ""+currentXValue);
			turnOn = turnOn.replaceAll("Y1", ""+currentYValue);
			linkY = currentYValue + 70;
			currentYValue+=90;
			turnOn = turnOn.replaceAll("X2", ""+transitionX);
			turnOn = turnOn.replaceAll("Y2", ""+currentYValue);
			turnOn = turnOn.replaceAll("X3", ""+currentLinkX);
			turnOn = turnOn.replaceAll("Y3", ""+linkY);
			turnOn = turnOn.replaceAll("X4", ""+currentLinkX);
			turnOn = turnOn.replaceAll("Y4", ""+currentYValue);
			linkY = currentYValue + 70;
			currentYValue+=90;
			connectedTransition = transition;
			steps.append(turnOn);
			activeController = Controller.ExtCntr;
			*/
		}
		UUID firstStepId = generateUniqueId();

		UUID outputStepId = generateUniqueId();

		UUID macroStepId = generateUniqueId();
		String macroStep = motion.stepCode("skill" + skillNbr++, firstStepId, macroStepId, outputStepId, currentXValue, currentYValue);
		linkY = currentYValue+270+70;
		currentYValue +=270+90;
		String linkTmp = linkXml.replace("ID1", connectedTransition.toString());
		linkTmp = linkTmp.replace("ID2", firstStepId.toString());
		linkTmp = linkTmp.replace("X3", ""+currentLinkX);
		linkTmp = linkTmp.replace("Y3", ""+linkY);
		linkTmp = linkTmp.replace("X4", ""+currentLinkX);
		linkTmp = linkTmp.replace("Y4", ""+currentYValue);
		steps.append(macroStep);

		links.append(linkTmp);
		if(notlast){
			UUID newTransId = generateUniqueId();
			String transTmp = emptyTrans.replace("ID", newTransId.toString());
			transTmp = transTmp.replace("X1", ""+transitionX);
			transTmp = transTmp.replace("Y1", ""+currentYValue);

			transitions.append(transTmp);
			String link2Tmp = linkXml.replace("ID2", newTransId.toString());
			link2Tmp = link2Tmp.replace("ID1", macroStepId.toString());
			link2Tmp = link2Tmp.replace("ID1", macroStep.toString());
			link2Tmp = link2Tmp.replace("X3", ""+currentLinkX);
			link2Tmp = link2Tmp.replace("Y3", ""+linkY);
			link2Tmp = link2Tmp.replace("X4", ""+currentLinkX);
			link2Tmp = link2Tmp.replace("Y4", ""+currentYValue);
			links.append(link2Tmp);
			linkY = currentYValue + 25;
			currentYValue+=45;
			connectedTransition = newTransId;
		}

		UUID[] r = {connectedTransition, macroStepId};
		return r;
	}
	
	private UUID[] turnOnExtCtrl(String taskName, UUID connectedTransition){
		UUID turnOnId = generateUniqueId();
		UUID transition = generateUniqueId();
		int armNbr = robotType.equals(RobotType.FridaLeftArm)? 2:1;

		String link2Tmp = linkXml.replace("ID2", turnOnId.toString());
		link2Tmp = link2Tmp.replace("ID1", connectedTransition.toString());

		link2Tmp = link2Tmp.replace("X3", ""+currentLinkX);
		link2Tmp = link2Tmp.replace("Y3", ""+linkY);
		link2Tmp = link2Tmp.replace("X4", ""+currentLinkX);
		link2Tmp = link2Tmp.replace("Y4", ""+currentYValue);
		links.append(link2Tmp);
		String turnOn = turnOnEx.replaceAll("ARMNBR", ""+armNbr);
		turnOn = turnOn.replaceAll("LC", taskName);
		turnOn = turnOn.replaceAll("ID1", turnOnId.toString());
		turnOn = turnOn.replaceAll("ID2", transition.toString());
		turnOn = turnOn.replaceAll("X1", ""+currentXValue);
		turnOn = turnOn.replaceAll("Y1", ""+currentYValue);
		linkY = currentYValue + 70;
		currentYValue+=90;
		turnOn = turnOn.replaceAll("X2", ""+transitionX);
		turnOn = turnOn.replaceAll("Y2", ""+currentYValue);
		turnOn = turnOn.replaceAll("X3", ""+currentLinkX);
		turnOn = turnOn.replaceAll("Y3", ""+linkY);
		turnOn = turnOn.replaceAll("X4", ""+currentLinkX);
		turnOn = turnOn.replaceAll("Y4", ""+currentYValue);
		linkY = currentYValue + 70;
		currentYValue+=90;
		connectedTransition = transition;
		steps.append(turnOn);
		UUID[] r = {connectedTransition, turnOnId};
		return r;
		
	}
	
	private UUID[] createSkill(String taskname, Controller activeController, UUID connectedTransition, boolean notlast, Skill e, String skillName){
		if(activeController!=Controller.ExtCntr){
			// turn on extcontrol!
			UUID[] ans = turnOnExtCtrl(taskname, connectedTransition);
			connectedTransition = ans[0];
		}
		UUID macroStep = generateUniqueId();
		String str = e.generateXml(macroStep);
		str = str.replace("MACROY", ""+currentYValue);
		str = str.replace("SKILLNAME", skillName);
		linkY = currentYValue + 70;
		currentYValue+=90;
		steps.append(str);
		String linkTmp = linkXml.replace("ID1", connectedTransition.toString());
		linkTmp = linkTmp.replace("ID2", macroStep.toString());
		linkTmp = linkTmp.replace("X3", ""+currentLinkX);
		linkTmp = linkTmp.replace("Y3", ""+linkY);
		linkTmp = linkTmp.replace("X4", ""+currentLinkX);
		linkTmp = linkTmp.replace("Y4", ""+currentYValue);
		linkY = currentYValue + 70;
		currentYValue+=90;
		links.append(linkTmp);
		if(notlast){
			UUID newTransId = generateUniqueId();
			String transTmp = emptyTrans.replace("ID", newTransId.toString());
			transTmp = transTmp.replace("X1", ""+transitionX);
			transTmp = transTmp.replace("Y1", ""+currentYValue);
			transitions.append(transTmp);
			String link2Tmp = linkXml.replace("ID2", newTransId.toString());
			link2Tmp = link2Tmp.replace("ID1", macroStep.toString());
			link2Tmp = link2Tmp.replace("ID1", macroStep.toString());
			link2Tmp = link2Tmp.replace("X3", ""+currentLinkX);
			link2Tmp = link2Tmp.replace("Y3", ""+linkY);
			link2Tmp = link2Tmp.replace("X4", ""+currentLinkX);
			link2Tmp = link2Tmp.replace("Y4", ""+currentYValue);
			links.append(link2Tmp);
			linkY = currentYValue + 25;
			currentYValue+=45;
			links.append(link2Tmp);
			connectedTransition = newTransId;
		}

		UUID[] r = {connectedTransition, macroStep};
		return r;
	}


	String stepXml  = "";
	String transXml = "";
	String linkXml ="";
	String turnOnEx = "";
	String turnOffEx ="";
	String startLoop = "";
	String endLoop = "";
	String emptyTrans = "";
	StringBuilder steps, links, transitions; 

	private String createFile(Task t, int xpos){

		currentXValue = xpos;
		currentYValue = 15;
		transitionX = xpos+15;
		currentLinkX = xpos+30;

		
		ProgramElement[] sequence = t.sequence();
		ReadWriteTextFile rwtf = new ReadWriteTextFile();
		String fullPath = context.getRealPath("/WEB-INF") + "/";
		//System.out.println("path" + fullPath);
		// DEBUG!!
		//String fullPath = "/Users/maj/git/codegen/codeGenerationServlet/WebContent/WEB-INF/";
		String initialStepXml = rwtf.getContents(new File(fullPath +"/InitialStep.txt"));
		String initialStepIDString = "b232dc99-11cc-3fc6-b812-42cdea2d5694";//generateUniqueId();
		UUID initialTransitionID = generateUniqueId();
		//initialStepXml = initialStepXml.replaceFirst("ID", initialStepID.toString());
		initialStepXml = initialStepXml.replaceFirst("IDTrans", initialTransitionID.toString());

		initialStepXml = initialStepXml.replaceFirst("X1", ""+currentXValue);
		initialStepXml = initialStepXml.replaceFirst("Y1", ""+currentYValue);

		linkY = currentYValue+70;
		currentYValue +=90;
		initialStepXml = initialStepXml.replaceFirst("X2", ""+transitionX);
		initialStepXml = initialStepXml.replaceFirst("Y2", ""+currentYValue);


		String templateXml = rwtf.getContents(new File(fullPath +"/TaskTemplate.txt"));

		/*String labcommobject = "<LabCommObject height=\"60\" isSocketServer=\"0\""+
				 "name=\""+ t.taskName()+"\" socketHost=\"192.168.125.1\""+
						"socketPort=\"" +t.port()+"\" specification="+
				"\"sample struct {&#10;&#9;string command;&#10;&#9;int status;"+
						 "&#10;int extCntr;&#10;&#9;&#10;int sensor1;&#10;"+
						 "int sensor2;&#10;int sensor3;&#10;int sensor4;&#10;"+
						 "int sensor5;&#10;int sensor6;&#10;}proc;\" width=\"60\""+
						 " x=\"250\" y=\"10\"/>";*/
		String labcommobject = "<LabCommObject height=\"60\" input=\"1\" isSocketServer=\"0\""+
					" name=\""+ t.taskName() +"\" orca=\"0\" output=\"1\" socketHost=\"192.168.125.1\" socketPort=\""+ t.port() + "\""+
						" specification=\"sample struct {&#10;"+
						"string command;&#10;        int status;&#10;int extCntr;&#10;&#10;"+
		"int sensor1;&#10;int sensor2;&#10;int sensor3;&#10;int sensor4;&#10;"+
		"int sensor5;&#10;int sensor6;&#10;}proc;\" version=\"2013\" width=\"60\" x=\"-10\" y=\"80\"/>";
				
		templateXml = labcommobject + templateXml;
		
		
		UUID connectedTransition = initialTransitionID;

		stepXml = rwtf.getContents(new File(fullPath +"/Step.txt"));
		transXml = rwtf.getContents(new File(fullPath +"/Transition.txt"));
		linkXml = rwtf.getContents(new File(fullPath +"/Link.txt"));
		turnOnEx = rwtf.getContents(new File(fullPath +"/turnOnExCntr.txt"));
		turnOffEx = rwtf.getContents(new File(fullPath +"/turnOffExCntr.txt"));
		startLoop = rwtf.getContents(new File(fullPath +"/LoopStartStep.txt"));
		endLoop = rwtf.getContents(new File(fullPath +"/LoopEndStep.txt"));

		 emptyTrans = rwtf.getContents(new File(fullPath +"/EmptyTransition.txt"));
		Controller activeController = Controller.RAPID;

		steps = new StringBuilder();

		links = new StringBuilder();
		transitions = new StringBuilder();
		steps.append(initialStepXml);
		UUID firstLink = generateUniqueId();


		String firstLinkTmp = linkXml.replace("ID1", initialStepIDString);
		firstLinkTmp = firstLinkTmp.replace("ID2", initialTransitionID.toString());
		firstLinkTmp = firstLinkTmp.replace("X3", ""+currentLinkX);
		firstLinkTmp = firstLinkTmp.replace("Y3", ""+linkY);
		firstLinkTmp = firstLinkTmp.replace("X4", ""+currentLinkX);
		firstLinkTmp = firstLinkTmp.replace("Y4", ""+currentYValue);
		linkY= currentYValue+25;

		currentYValue+=45;

		boolean extCntrIsOn = false;
		links.append(firstLinkTmp);

		int skillNbr = 1;
		int loops = 0;
		for(ProgramElement e: sequence){
			if(e instanceof LoopStep){

				UUID startLoop = generateUniqueId();
				UUID transition = generateUniqueId();

				UUID endLoop = generateUniqueId();
				connectedTransition = startLoop(connectedTransition, loops, (LoopStep)e);
				LoopStep l = (LoopStep) e;
				Controller startController = activeController;
				UUID startStep = null;
				int oldX = 0, oldY = 0;
				for(ProgramElement element: l.nestedStatements){
				//	System.out.println("HEj " + element);
					if(element instanceof Primitive){
						//System.out.println("True " + element);
						String procCall = element.toString();
						if(element.toString().contains("pick_")) procCall +=" &quot; + pick_list_"+loops + ".get(loop_counter_"+loops+")"; 
						if(element.toString().contains("place_")) procCall += " &quot;  + place_list_"+loops + ".get(loop_counter_"+loops+")"; 
						if(startStep == null){
							oldX = currentXValue;
							oldY = currentYValue;
						}
						UUID[] ans = createPrimitiveJGc(t.taskName(), activeController, connectedTransition, true,procCall, true);
						connectedTransition = ans[0];
						if(startStep == null) startStep = ans[1];
						activeController = Controller.RAPID;
						
					}else if(element instanceof GuardedMotion){

					///	System.out.println("ff " + element);
						if(startStep == null){
							oldX = currentXValue;
							oldY = currentYValue;
						}
						UUID[] ans = createGuardedMotion(t.taskName(), activeController, connectedTransition, true, (GuardedMotion)element, skillNbr ++);
						connectedTransition = ans[0];

						if(startStep == null) startStep = ans[1];
						activeController = Controller.ExtCntr;

					}else if(element instanceof Skill){

					//	System.out.println("vvv " + element);
						if(startStep == null){
							oldX = currentXValue;
							oldY = currentYValue;
						}
						String skillName = "Skill" + skillNbr++;
						UUID[] ans = createSkill(t.taskName(), activeController, connectedTransition, true, (Skill)element, skillName);
						
						connectedTransition = ans[0];
						if(startStep == null) startStep = ans[1];
						activeController = Controller.ExtCntr;
					}
					
				}
				if(activeController != startController){
					if(startController == Controller.ExtCntr){
						UUID[] ans = turnOnExtCtrl(t.taskName(), connectedTransition);
						connectedTransition = ans[0];
						activeController = Controller.ExtCntr;
					}else{
						UUID[] ans = turnOffExtCtrl(connectedTransition);
						connectedTransition = ans[0];
						activeController = Controller.RAPID;
					}
					// change controller!!!
				}
				int limit = ((LoopStep)e).limit();
				connectedTransition = endLoop(connectedTransition, loops, startStep, oldX, oldY, limit);
				
				

			}
		if(e instanceof Primitive){
			UUID[] ans = createPrimitiveJGc(t.taskName(), activeController, connectedTransition, !e.equals(sequence[sequence.length-1]),e.toString(), false);
			connectedTransition = ans[0];
			activeController = Controller.RAPID;
			
		}else if(e instanceof GuardedMotion){
			UUID[] ans = createGuardedMotion(t.taskName(), activeController, connectedTransition, !e.equals(sequence[sequence.length-1]), (GuardedMotion)e, skillNbr ++);
			connectedTransition = ans[0];

			activeController = Controller.ExtCntr;

		}else if(e instanceof Skill){
			String skillName = "Skill" + skillNbr++;
			UUID[] ans = createSkill(t.taskName(), activeController, connectedTransition, !e.equals(sequence[sequence.length-1]), (Skill)e, skillName);
			connectedTransition = ans[0];
			activeController = Controller.ExtCntr;


		}
		}
		// add last step
		// add last transition.
		UUID lastStepID = generateUniqueId();
		UUID lastTransitionID = generateUniqueId();
		linkY = currentYValue+270+70;
		currentYValue +=270+90;
		String laststepXml = rwtf.getContents(new File(fullPath +"/LastStep.txt"));
		String lastStep = laststepXml.replaceFirst("ID", lastStepID.toString());
		String linkTmp = linkXml.replace("ID1", connectedTransition.toString());
		linkTmp = linkTmp.replace("ID2", lastStepID.toString());
		linkTmp = linkTmp.replace("X3", ""+currentLinkX);
		linkTmp = linkTmp.replace("Y3", ""+linkY);
		linkTmp = linkTmp.replace("X4", ""+currentLinkX);
		linkTmp = linkTmp.replace("Y4", ""+currentYValue);
		linkY = currentYValue+270+70;
		currentYValue +=270+90;
		String link2Tmp = linkXml.replace("ID2", lastTransitionID.toString());
		link2Tmp = link2Tmp.replace("ID1", lastStepID.toString());
		link2Tmp = link2Tmp.replace("X3", ""+currentLinkX);
		link2Tmp = link2Tmp.replace("Y3", ""+linkY);
		link2Tmp = link2Tmp.replace("X4", ""+currentLinkX);
		link2Tmp = link2Tmp.replace("Y4", ""+currentYValue);
		links.append(linkTmp);
		links.append(link2Tmp);
		//steps.append(laststepXml);
		
		//links.append(linkTmp);
		lastStep = laststepXml.replaceFirst("IdTRANS", lastTransitionID.toString());

		templateXml = templateXml.replace("STEPS", steps.toString());

		templateXml = templateXml.replace("TRANSITIONS", transitions.toString());

		templateXml = templateXml.replace("LINKS", links.toString());
		//System.out.println(templateXml);
		//File f = new File(fullPath +"/testFile.xml");
		//templateXml += "whsatafacl";
		/*
		try {

		//	f.createNewFile();
		//	rwtf.setContents(f, templateXml);

			return templateXml;

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		return templateXml;



	}

	public static ProgramElement parseNode(Node node){
		if( node.getNodeName().equals("Primitive") ){
			//System.out.println("Found primitive!");
			Element primitiveElement = (Element) node;
			String f = primitiveElement.getAttribute("function_call");
			Primitive prim = new Primitive(f);

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
			return new Skill(skillUrl);

			//TODO what to read from the xml...
		}
		if( node.getNodeName().equals("SkillSpecification") ){
			GuardedMotion guardedMotion = new GuardedMotion(node, robotType);
			return guardedMotion;
			//task.addSkill(guardedMotion);

		}
		if( node.getNodeName().equals("PalletizingStep") ){
		
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
					ProgramElement e = parseNode(p);
					if(e!= null)loop.addProgramElement(e);
				}
			}
			return loop;
		}
		return null;


	}




	public synchronized static UUID generateUniqueId() {

		byte[] bytes = UUIDGenerator.randomUUID(true);
		UUID uuid = UUID.nameUUIDFromBytes(bytes);
		return uuid;

	}

}
