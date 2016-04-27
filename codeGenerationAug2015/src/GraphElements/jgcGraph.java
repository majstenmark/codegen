package GraphElements;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import jgrafchart.LabCommConnection;
import statemachine.*;
import statemachine.SmConditionElement;
import statemachine.SmState;
import statemachine.SmTransition;
import statemachine.StateMachine;

public class jgcGraph {
	private StateMachine sm;
	
	public jgcGraph(StateMachine sm){
		this.sm = sm;
	}
	


	public void generateJgcCode(String outputFile){
		sm.spreadOut();


		try{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			Document doc = dBuilder.newDocument();
			Element rootElement = createDocument(doc);
			doc.appendChild(rootElement);
			for(LabCommConnection lc: sm.getIo()){
				Element e = createLabCommObjectXml(lc, doc);
				rootElement.appendChild(e);
			}
			for(SmState state: sm.getAllStates()){
				Element e = createStateXml(state, doc);
				rootElement.appendChild(e);
			}
			for(SmTransition t: sm.getAllTransitions()){
				Element e = createTransitionXml(t, doc);
				rootElement.appendChild(e);
			}
			// add links!
			for(SmState state: sm.getAllStates()){
				for(SmTransition t: state.getOutgoingTransitions()){
					Element e = createLinkXml(state,t, doc);
					rootElement.appendChild(e);
				}
			}
			for(SmTransition t: sm.getAllTransitions()){


				for(SmState s: t.getOutgoingStates()){
					Element e = createLinkXml(t,s, doc);
					rootElement.appendChild(e);
				}
			}

			// add things in beginning
			// add things in the end

			DOMSource source = new DOMSource(doc);
		    StringWriter writer1 = new StringWriter();
		       StreamResult result = new StreamResult(writer1);
		       TransformerFactory tf = TransformerFactory.newInstance();
		       Transformer transformer = tf.newTransformer();
		       transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		       transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		       transformer.transform(source, result);

			   String test =  writer1.toString();
		
			PrintWriter writer = new PrintWriter(outputFile, "UTF-8");
			
			writer.println(test);
			writer.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	protected Element createLinkXml(SmState state, SmTransition t, Document doc){
		// < manAdj="0" toObject="kinematicsConvergedTransition">
		//<Stroke x="270" y="92"/>
		//<Stroke x="270" y="109"/>
		Element element = doc.createElement("GCLink");
		element.setAttribute("fromObject", "" + state.getId());
		element.setAttribute("manAdj", "" + 0);
		element.setAttribute("toObject", "" + t.getId());
		Element stroke1 = doc.createElement("Stroke");
		int state_x = state.getX() + Positions.STATEWIDTH/2;
		int link_x = t.getX() + Positions.TRANSWIDTH/2;
		int halfWay = (state.getY() + Positions.STATEHEIGHT + t.getY()) /2;
		stroke1.setAttribute("x", ""+ state_x);
		stroke1.setAttribute("y", ""+ (state.getY() + Positions.STATEHEIGHT + 1));

		Element stroke2 = doc.createElement("Stroke");
		stroke2.setAttribute("x", "" + state_x);
		stroke2.setAttribute("y", "" + halfWay);
		Element stroke3 = doc.createElement("Stroke");
		stroke3.setAttribute("x", "" + link_x);
		stroke3.setAttribute("y", "" + halfWay);
		Element stroke4 = doc.createElement("Stroke");
		stroke4.setAttribute("x", "" + link_x);
		stroke4.setAttribute("y", "" + (t.getY() -1));

		element.appendChild(stroke1);
		element.appendChild(stroke2);
		element.appendChild(stroke3);
		element.appendChild(stroke4);


		return element;
	}	
	protected Element createLinkXml(SmTransition t, SmState state, Document doc){
		// < manAdj="0" toObject="kinematicsConvergedTransition">
		//<Stroke x="270" y="92"/>
		//<Stroke x="270" y="109"/>
		Element element = doc.createElement("GCLink");
		element.setAttribute("fromObject", "" + t.getId());
		element.setAttribute("manAdj", "" + 0);
		element.setAttribute("toObject", "" + state.getId());
		Element stroke1 = doc.createElement("Stroke");
		int link_x = t.getX() + Positions.TRANSWIDTH/2;
		int state_x = state.getX() + Positions.STATEWIDTH/2;
		int halfWay = (state.getY() + Positions.TRANSHEIGHT + t.getY()) /2;
		
		stroke1.setAttribute("x", ""+ link_x);
		stroke1.setAttribute("y", ""+ (t.getY() + Positions.TRANSHEIGHT + 1));

		element.appendChild(stroke1);
		if(state.getY() > t.getY()){
		Element stroke2 = doc.createElement("Stroke");
		stroke2.setAttribute("x", "" + link_x);
		stroke2.setAttribute("y", "" + halfWay);

		element.appendChild(stroke2);
		Element stroke3 = doc.createElement("Stroke");
		stroke3.setAttribute("x", "" + state_x);
		stroke3.setAttribute("y", "" + halfWay);

		element.appendChild(stroke3);
		}else{
			int halfWayX = (state.getX()+ t.getX()) /2;
			
			Element stroke2 = doc.createElement("Stroke");
			stroke2.setAttribute("x", "" + halfWayX);
			stroke2.setAttribute("y", "" + (t.getY() + Positions.TRANSHEIGHT + 1));

			element.appendChild(stroke2);
			Element stroke3 = doc.createElement("Stroke");
			stroke3.setAttribute("x", "" + halfWayX);
			stroke3.setAttribute("y", "" + (state.getY() -1));

			element.appendChild(stroke3);
		}
		Element stroke4 = doc.createElement("Stroke");
		stroke4.setAttribute("x", "" + state_x);
		stroke4.setAttribute("y", "" + (state.getY() -1));


		element.appendChild(stroke4);

		return element;
	}

	protected Element createInitialStateXml(SmState state, Document doc){

		Element element = doc.createElement("GCInitialStep");
		element.setAttribute("actionBlockVisible", "" + 0);

		element.setAttribute("actionText", "");
		element.setAttribute("conditionVisible", ""+ 1);
		element.setAttribute("height", ""+Positions.STATEHEIGHT);

		element.setAttribute("id", ""+state.getId().toString());
		element.setAttribute("width", ""+ Positions.STATEWIDTH);
		element.setAttribute("x", ""+state.getX());
		element.setAttribute("y", ""+state.getY());
		element.setAttribute("fileName", "");
		element.setAttribute("name", ""+state.getName());
		element.setAttribute("useIcon", ""+0);


		return element;
	}


	protected Element createDocument(Document doc){ 
		
		Element element = doc.createElement("GCDocument");
		element.setAttribute("color", "" + -1);
		element.setAttribute("dimTicks", ""+ 25);
		element.setAttribute("dpwsInterface", "");

		element.setAttribute("dpwsPort", ""+ (-1));
		element.setAttribute("height", ""+ 607);
		element.setAttribute("horizontalScrollBar", ""+1);
		element.setAttribute("modifiable", ""+1);
		element.setAttribute("name", "J1");
		element.setAttribute("saveVersion", ""+8);
		element.setAttribute("scale", ""+0.73);
		element.setAttribute("simulationMode", ""+0);
		element.setAttribute("socketHost", "");
		element.setAttribute("socketIsServer", ""+0);
		element.setAttribute("socketPort", ""+(-1));
		element.setAttribute("socketSendMode", "Changed");
		element.setAttribute("threadSpeed", ""+4);
		element.setAttribute("tokenLuminance", "0");
		element.setAttribute("verticalScrollBar", "1");
		element.setAttribute("viewPositionX", "-70");
		element.setAttribute("viewPositionY", "-45");
		element.setAttribute("width", ""+978);
		element.setAttribute("x", ""+0);
		element.setAttribute("y", ""+0);


		return element;
	}
	protected Element createNestedStateXml(SmNestedState state, Document doc){
		Element rootElement = createDocument(doc);
		StateMachine sm = state.getStateMachine();
		SmState enter = state.getEnter();
		SmState exit = state.getExit();
		Element enterXml = createEnterStepXml(enter, doc);
		rootElement.appendChild(enterXml);
		
		for(LabCommConnection lc: sm.getIo()){
			Element e = createLabCommObjectXml(lc, doc);
			rootElement.appendChild(e);
		}
		
		for(SmState s: sm.getAllStates()){
			if(! s.isInitial() && s != enter && s != exit){
			Element e = createStateXml(s, doc);
		
			rootElement.appendChild(e);
			}
			
		}
		
		
		for(SmTransition t: sm.getAllTransitions()){
			Element e = createTransitionXml(t, doc);
			rootElement.appendChild(e);
		}
		// add links!
		for(SmState s: sm.getAllStates()){
			for(SmTransition t: state.getOutgoingTransitions()){
				Element e = createLinkXml(state,t, doc);
				rootElement.appendChild(e);
			}
		}
		for(SmTransition t: sm.getAllTransitions()){
			for(SmState s: t.getOutgoingStates()){
				Element e = createLinkXml(t,s, doc);
				rootElement.appendChild(e);
			}
		}
		Element exitXml = createExitStepXml(exit, doc);
		rootElement.appendChild(exitXml);
		
		// foreach initialstep.
		//Element exit =createExitStepXml();
			 // createEnterStepXml
		return rootElement;
	}
		

	protected Element createExitStepXml(SmState state, Document doc){
		
		Element element = doc.createElement("ExitStep");
		element.setAttribute("actionText", "" + actionString(state));
		element.setAttribute("actionBlockVisible", ""+ 0);
		element.setAttribute("height", ""+Positions.STATEHEIGHT);

		element.setAttribute("id", ""+state.getId().toString());
		element.setAttribute("width", ""+ Positions.STATEWIDTH);
		element.setAttribute("x", ""+state.getX());
		element.setAttribute("y", ""+state.getY());
		element.setAttribute("fileName", "");
		element.setAttribute("name", ""+state.getName());
		element.setAttribute("useIcon", ""+0);

		return element;
	}

	protected Element createEnterStepXml(SmState state, Document doc){
		Element element = doc.createElement("EnterStep");
		element.setAttribute("actionText", "" + actionString(state));
		element.setAttribute("actionBlockVisible", ""+ 0);
		element.setAttribute("height", ""+Positions.STATEHEIGHT);

		element.setAttribute("id", ""+state.getId().toString());
		element.setAttribute("width", ""+ Positions.STATEWIDTH);
		element.setAttribute("x", ""+state.getX());
		element.setAttribute("y", ""+state.getY());
		element.setAttribute("fileName", "");
		element.setAttribute("name", ""+state.getName());
		element.setAttribute("useIcon", ""+0);

		return element;
	}
	
	protected Element createStateXml(SmState state, Document doc){
		if(state.isInitial()) return createInitialStateXml(state, doc);
		if(state instanceof SmNestedState){
		 
		 
			Element element = doc.createElement("MacroStep");
			element.setAttribute("actionText", "" + actionString(state));
			element.setAttribute("fileName", "");
			element.setAttribute("height", "" + Positions.STATEHEIGHT);
			element.setAttribute("id", "" + state.getId());
			element.setAttribute("name", "" + state.getName());
			element.setAttribute("resumeMode", "Default");
			element.setAttribute("useIcon", "" + 0);
			element.setAttribute("width", "" + Positions.STATEWIDTH);
			element.setAttribute("x", "" + state.getX());
			element.setAttribute("y", "" + state.getY());
			SmNestedState nested = (SmNestedState) state;
			Element innerXml = createNestedStateXml(nested, doc);
			element.appendChild(innerXml);
			return element;
			
		}else{
		Element element = doc.createElement("GCStep");
		element.setAttribute("actionText", "" + actionString(state));
		element.setAttribute("conditionVisible", ""+ 1);
		element.setAttribute("height", ""+Positions.STATEHEIGHT);

		element.setAttribute("id", ""+state.getId().toString());
		element.setAttribute("width", ""+ Positions.STATEWIDTH);
		element.setAttribute("x", ""+state.getX());
		element.setAttribute("y", ""+state.getY());
		element.setAttribute("fileName", "");
		element.setAttribute("name", ""+state.getName());
		element.setAttribute("useIcon", ""+0);

		return element;
		}

	}

	private String actionString(SmState state){
		return state.getAction();
	}

	protected Element createTransitionXml(SmTransition t,  Document doc){

		Element element = doc.createElement("GCTransition");
		element.setAttribute("actionText", "" + conditionString(t));
		element.setAttribute("conditionVisible", ""+ 1);
		element.setAttribute("height", ""+Positions.TRANSHEIGHT);

		element.setAttribute("id", ""+t.getId().toString());
		element.setAttribute("width", ""+ Positions.TRANSWIDTH);
		element.setAttribute("x", ""+t.getX());
		element.setAttribute("y", ""+t.getY());
		return element;
	}

	private String conditionString(SmTransition t){
		// "i.y_meas_extR.get(0) &lt; -3.0"
		ArrayList<SmConditionElement> conditions =  t.getConditions();
		if(conditions.size() > 0 ){
		SmConditionElement cond = conditions.get(0);
		return conditionString(cond);
		}
		
		return t.getConditionString();
		

	}

	private String conditionString(SmConditionElement cond){
		if(cond instanceof AndCondition){
			AndCondition aCond = (AndCondition) cond;
			String a = conditionString(aCond.c1);
			String b = conditionString(aCond.c2);
			return a + " "+ StringConstants.AND + " "+ b;

		}
		if(cond instanceof OrCondition){
			OrCondition oCond = (OrCondition) cond;
			String a = conditionString(oCond.c1);
			String b = conditionString(oCond.c2);
			return a + " "+ StringConstants.OR + " "+ b;

		}
		if(cond instanceof SmCondition){
			SmCondition c = (SmCondition) cond;
			String s = c.sensor.getName();
			String v = ""+c.value;
			String t = "";
			switch(c.type){
			case GREATER: 
				t = StringConstants.GT;
				break;
			case GREATEREQ: 
				t = StringConstants.GTEQ;
				break;
			case LESS:

				t = StringConstants.LT;
				break;

			case LESSEQ: 

				t = StringConstants.LTEQ;
				break;

			case EQ: 

				t = StringConstants.EQ;
				break;

			}

			return s +" " + t + " "+ v;

		}
		return "1";
	}


	protected Element createLabCommObjectXml(LabCommConnection lc, Document doc){
		Element element = doc.createElement("LabCommObject");
		element.setAttribute("height", ""+Positions.OBJECTHEIGHT);
		element.setAttribute("input", ""+ lc.getInput());
		element.setAttribute("isSocketServer", ""+lc.isServer());
		element.setAttribute("name", ""+lc.getName());
		int orca = lc.isOrca()? 1:0;
		element.setAttribute("orca", ""+orca);
		int i = lc.getInput()? 1:0;
		int o = lc.getOutput()? 1:0;
		element.setAttribute("input", ""+i);
		element.setAttribute("output", ""+o);
		
		element.setAttribute("socketHost", ""+lc.getServer());
		element.setAttribute("socketPort", ""+lc.getPort());
		element.setAttribute("specification", ""+lc.getLC());
		element.setAttribute("version", ""+lc.getVersion());
		element.setAttribute("width", ""+ Positions.OBJECTWIDTH);
		element.setAttribute("x", ""+lc.getX());
		element.setAttribute("y", ""+lc.getY());
		return element;
	}

	/*
	public void addLabCommConnection(jgcLabCommConnection lc){
		labcommConnections.add(lc);
	}

	public void addInitialStates(JgcState s){
		initialStates.add(s);
	}
	 */


}
