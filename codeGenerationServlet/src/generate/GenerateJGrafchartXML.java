package generate;

import java.io.*;

import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.HashMap;

public class GenerateJGrafchartXML{

	ArrayList<State> stateList = new ArrayList<State>();

	ArrayList<State> errorstateList = new ArrayList<State>();
	
	ArrayList<Frame> frameList = new ArrayList<Frame>();
	ArrayList<ImpedanceController> controllerList = new ArrayList<ImpedanceController>();
	ArrayList<ToolTransform> toolList = new ArrayList<ToolTransform>();
	ArrayList<FrameTool> ft = new ArrayList<FrameTool>();
	static String[] dirs = {"x","y","z","xRot","yRot","zRot"};

//  public static int nInputs = 0;
//  public static int nOutputs = 0;
//  public static LCSignal inputSignals[] = new LCSignal[100];
//  public static LCSignal outputSignals[] = new LCSignal[100];

  /*
    Command line arguments:
    1. skill description xml
    2. output filename
  */
	private void run22(String[] aArguments){

		System.out.println("WTF2 ");
		RobotType robot = RobotType.IRB120; //Standard if no other robot is selected
		if(aArguments.length < 2){
			System.out.println("Use the program as:");
			System.out.println("java GenerateJGrafchartXML <skill-description-xml> <output-file-xml> [robot type]");
			System.out.println();
			System.out.println("The robot type argument is optional. The default is IRB120.");
			System.out.println("Available robots: IRB120, IRB140, FridaLeft, FridaRight");
			System.out.println();
			System.out.println("An example:");
			System.out.println("java GenerateJGrafchartXML skill.xml skill_JG.xml IRB140");
			System.exit(0);
		}
		String skillXML_file = aArguments[0];
		File skillFile = new File(skillXML_file);
		ReadWriteTextFile rwtf = new ReadWriteTextFile();

		String outputFileName = aArguments[1];

		if(aArguments.length == 3){
			robot = getRobotType(aArguments[2]);
		
		}

		System.out.println("The robot is: "+robot);
		
	//	readXMLFile(skillFile);
		System.out.println("Number of states: "+stateList.size());
		System.out.println("Number of frames: "+frameList.size());
		System.out.println("Number of controllers: "+controllerList.size());
		System.out.println("Number of tooltransforms: "+toolList.size());


		int stateNumber = 101;
		String newLine = "\n";//"&#10;";

		System.out.println("WTF3 ");
		for(int i=0;i<stateList.size();i++){
			String tool = stateList.get(i).getTool();
			for(int j=0;j<stateList.get(i).getNumberOfConstraints();j++){
				String frame = stateList.get(i).getConstraint(j).getFrame();
				boolean insert=true;
				for( int k=0; k<ft.size();k++){
					FrameTool tmp = ft.get(k);
					if( tmp.getFrame().equals(frame) && tmp.getTool().equals(tool) ){
						insert=false;
						break;
					}
				}
				if(insert){
					ft.add(new FrameTool(frame,tool));
				}
			}
			String frame = stateList.get(i).getDirection().getFrame();
			boolean insert=true;
			for( int k=0; k<ft.size();k++){
				FrameTool tmp = ft.get(k);
				if( tmp.getFrame().equals(frame) && tmp.getTool().equals(tool) ){
					insert=false;
					break;
				}
			}
			if(insert){
				ft.add(new FrameTool(frame,tool));
			}			
		}
	
		if( ft.size()>2 ){
			System.out.println("No more than two combinations of frames and tools supported in the current version");
			System.out.println("The loaded file wants to use "+ft.size()+" combinations.");
			System.exit(1);
		}
		

		//System.out.println(enterStateAction(101,newLine));
		//System.out.println(exitStateAction(102,newLine));
		//System.out.println(stateAction(103,newLine,1));
		//System.out.println(macroStepXML(skillXML_file));

		File outputFile = new File(outputFileName);
		if(!outputFile.exists()){
			try {
				outputFile.createNewFile();
				HashMap<String,State> errorHandling = new HashMap<String, State>();
				for(State e: errorstateList){
					errorHandling.put(e.getName(), e);
				}
			//	rwtf.setContents(outputFile, buildXMLFile(rwtf,macroStepXML(skillXML_file,robot, errorHandling),robot));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	//public static void main (String[] aArguments) throws IOException {

		//System.out.println("WTF ");
		//GenerateJGrafchartXML test = new GenerateJGrafchartXML();
		//test.run(aArguments);
	//}

	
	public void readInput(Node node){
		readXML(node);
		readInput2();
	}

	public void readInput2(File skillFile){
		readXMLFile2(skillFile);
		readInput2();
	}



	
	private void readInput2(){
		System.out.println("Number of states: "+stateList.size());
		System.out.println("Number of frames: "+frameList.size());
		System.out.println("Number of controllers: "+controllerList.size());
		System.out.println("Number of tooltransforms: "+toolList.size());


		int stateNumber = 101;
		String newLine = "\n";//"&#10;";

		for(int i=0;i<stateList.size();i++){
			String tool = stateList.get(i).getTool();
			for(int j=0;j<stateList.get(i).getNumberOfConstraints();j++){
				String frame = stateList.get(i).getConstraint(j).getFrame();
				boolean insert=true;
				for( int k=0; k<ft.size();k++){
					FrameTool tmp = ft.get(k);
					if( tmp.getFrame().equals(frame) && tmp.getTool().equals(tool) ){
						insert=false;
						break;
					}
				}
				if(insert){
					ft.add(new FrameTool(frame,tool));
				}
			}
			String frame = stateList.get(i).getDirection().getFrame();
			boolean insert=true;
			for( int k=0; k<ft.size();k++){
				FrameTool tmp = ft.get(k);
				if( tmp.getFrame().equals(frame) && tmp.getTool().equals(tool) ){
					insert=false;
					break;
				}
			}
			if(insert){
				ft.add(new FrameTool(frame,tool));
			}			
		}

		if( ft.size()>2 ){
			System.out.println("No more than two combinations of frames and tools supported in the current version");
			System.out.println("The loaded file wants to use "+ft.size()+" combinations.");
			System.exit(1);
		}
		
	}
	

	
	public void readXML(Node definitionNode ) {
		 
		try {

		NodeList nodes = definitionNode.getChildNodes();
	 
		
	
		for (int temp = 0; temp < nodes.getLength(); temp++) {
	 
			Node node = nodes.item(temp);
			if( node instanceof Element ){
				if( node.getNodeName().equals("Action") ){
					ArrayList<State> s = handleActionNode(node);
					stateList.addAll(s);
				}else if( node.getNodeName().equals("ErrorStep") ){
					System.out.println("Found error step");
							ArrayList<State> e_handling = handleErrorNode(node);
							errorstateList.addAll(e_handling);
						}
				else if( node.getNodeName().equals("Frame") ){
					Frame f = handleFrameNode(node);
					frameList.add(f);
					double[] d = f.getYZXEulerAngles();
				} else if( node.getNodeName().equals("ImpedanceControlParams") ){
					ImpedanceController i = handleImpedanceControllerNode(node);
					controllerList.add(i);
				} else if( node.getNodeName().equals("ToolTransform") ){
					ToolTransform t = handleToolTransformNode(node);
					toolList.add(t);	
				}
			}
	
		}
		

	} catch (Exception e) {
		e.printStackTrace();
	}
		
		
}
	
		private ArrayList<State> handleErrorNode(Node inputNode) {
			NodeList nodes = inputNode.getChildNodes();
			ArrayList<State> es = new ArrayList<State>();
			for (int temp = 0; temp < nodes.getLength(); temp++) {

				Node node = nodes.item(temp);
				if( node instanceof Element ){
					if( node.getNodeName().equals("Action") ){
						ArrayList<State> s = handleActionNode(node);
						es.addAll(s);
					}else if( node.getNodeName().equals("ErrorStep") ){
								ArrayList<State> e_handling = handleErrorNode(node);
								es.addAll(e_handling);
							}
				 
			}
			}
		 
				return es;
	}


		public String macroStepXML333(String skillXML_file, String id, RobotType rob){
			
			String newLine = System.getProperty("line.separator");
			StringBuilder macroStep = new StringBuilder();
			macroStep.append("  <MacroStep actionText=\";\" fileName=\"\" height=\"70\" id=\""+id+"\" name=\""+skillXML_file +"\" useIcon=\"0\" width=\"60\" x=\"450\" y=\"MACROY\">"+newLine);
			macroStep.append("    <GCDocument color=\"-1\" height=\"832\" scale=\"1.0\" viewPositionX=\"0\" viewPositionY=\"0\" width=\"1155\" x=\"0\" y=\"0\">"+newLine);
			String enterStateActions = enterStateAction(101,"&#10;",rob);
			macroStep.append("      <EnterStep actionBlockVisible=\"1\" actionText=\""+enterStateActions+"\" fileName=\"\" height=\"55\" id=\"EnterState-"+skillXML_file+"\" name=\"Set kinematic chains\" useIcon=\"0\" width=\"147\" x=\"244\" y=\"36\"/>"+newLine);
			String exitStateActions = exitStateAction(101+stateList.size()+1,"&#10;",rob);
			macroStep.append("      <ExitStep actionBlockVisible=\"1\" actionText=\""+exitStateActions+"\" fileName=\"\" height=\"55\" id=\"ExitState-"+skillXML_file+"\" name=\"Skill finished\" useIcon=\"0\" width=\"147\" x=\"244\" y=\""+(120*(stateList.size()+1)+36)+"\"/>"+newLine);
			int kinConvergedNumber = 1;
			if(rob == RobotType.FridaLeftArm){
				kinConvergedNumber = 2;
			}
			macroStep.append("      <GCTransition CGURI=\"\" actionText=\"i.kinematicsConverged.get("+(kinConvergedNumber-1)+") &gt; 0.5\" conditionVisible=\"0\" height=\"25\" id=\"kinematicsConvergedTransition\" width=\"30\" x=\"255\" y=\"110\"/>"+newLine);

			for(int i=0;i<stateList.size();i++){
				String stateActions = stateAction(101+i+1,"&#10;",i,rob);
				String transitionCondition = "0";

				String stateTool = stateList.get(i).getTool();
				String stateFrame = stateList.get(i).getDirection().getFrame();
				int ftToUse = -1;
				for(int j=0;j<ft.size();j++){
					if(stateTool.equals(ft.get(j).getTool()) && stateFrame.equals(ft.get(j).getFrame()) ){
						ftToUse = j;
					}
				} 
				String searchDirection = stateList.get(i).getDirection().getMotionDir();
				//double signOfSearchVelocity = Math.sign(stateList.get(i).getDirection().getSearchVelocity());
				double signOfSearchVelocity = 0;
				if( stateList.get(i).getDirection().getSearchVelocity() > 0 ){
					signOfSearchVelocity = 1;
				} else if( stateList.get(i).getDirection().getSearchVelocity() < 0 ){
					signOfSearchVelocity = -1;
				}
				int coordNumber = -1;
				for(int j=0;j<6;j++){
					if(searchDirection.equals(dirs[j])){
						coordNumber = j;
						break;
					}
				}
				int yVecNumber = coordNumber+1+ftToUse*6;
				//double threshold = 0.0;
				/*
				String thresUnit = stateList.get(i).getDirection().getThresholdUnit();
				if(coordNumber<3){				
					if( thresUnit.equals("N") ){
						threshold = stateList.get(i).getDirection().getThreshold();
					} else if( thresUnit.equals("mN") ){
						threshold = stateList.get(i).getDirection().getThreshold()*0.001;
					} else {
						System.out.println("The following unit is not supported: "+thresUnit);
						System.exit(1);
					}
				} else {
					if( thresUnit.equals("Nmm") || thresUnit.equals("mNm") ){
						threshold = stateList.get(i).getDirection().getThreshold();
					} else if( thresUnit.equals("Nm") ){
						threshold = stateList.get(i).getDirection().getThreshold()*1000;
					} else {
						System.out.println("The following unit is not supported: "+thresUnit);
						System.exit(1);
					}
				}
				*/
				
				int offsetDueToRob2 = 0;
				if(rob == RobotType.FridaLeftArm){
					offsetDueToRob2 = 48;
				}
				transitionCondition = createTransitionCondition(stateList.get(i), signOfSearchVelocity < 0 , rob == RobotType.FridaLeftArm);
				

				macroStep.append("      <GCStep actionBlockVisible=\"1\" actionText=\""+stateActions+"\" fileName=\"\" height=\"55\" id=\""+stateList.get(i).getName()+"\" name=\""+stateList.get(i).getName()+"\" useIcon=\"0\" width=\"147\" x=\"248\" y=\""+(36+120*(i+1))+"\"/>"+newLine);
				macroStep.append("      <GCTransition CGURI=\"\" actionText=\""+transitionCondition+"\" conditionVisible=\"0\" height=\"25\" id=\"transition-"+stateList.get(i).getName()+"\" width=\"30\" x=\"255\" y=\""+(110+(i+1)*120)+"\"/>"+newLine);
			}

			//Add links
			macroStep.append("      <GCLink fromObject=\"EnterState-"+skillXML_file+"\" manAdj=\"0\" toObject=\"kinematicsConvergedTransition\">"+newLine);
			macroStep.append("        <Stroke x=\"270\" y=\"92\"/>"+newLine);
			macroStep.append("        <Stroke x=\"270\" y=\"92\"/>"+newLine);
			macroStep.append("        <Stroke x=\"270\" y=\"92\"/>"+newLine);
			macroStep.append("        <Stroke x=\"270\" y=\"92\"/>"+newLine);
			macroStep.append("        <Stroke x=\"270\" y=\"92\"/>"+newLine);
			macroStep.append("        <Stroke x=\"270\" y=\"109\"/>"+newLine);
			macroStep.append("      </GCLink>"+newLine);

			macroStep.append("      <GCLink fromObject=\"kinematicsConvergedTransition\" manAdj=\"0\" toObject=\""+stateList.get(0).getName()+"\">"+newLine);
			macroStep.append("        <Stroke x=\"270\" y=\"136\"/>"+newLine);
			macroStep.append("        <Stroke x=\"270\" y=\"136\"/>"+newLine);
			macroStep.append("        <Stroke x=\"270\" y=\"136\"/>"+newLine);
			macroStep.append("        <Stroke x=\"270\" y=\"136\"/>"+newLine);
			macroStep.append("        <Stroke x=\"270\" y=\"136\"/>"+newLine);
			macroStep.append("        <Stroke x=\"270\" y=\"155\"/>"+newLine);
			macroStep.append("      </GCLink>"+newLine);
			
			for(int i=0;i<stateList.size();i++){
				macroStep.append("      <GCLink fromObject=\""+stateList.get(i).getName()+"\" manAdj=\"0\" toObject=\"transition-"+stateList.get(i).getName()+"\">"+newLine);
				macroStep.append("        <Stroke x=\"270\" y=\""+(92+120*(i+1))+"\"/>"+newLine);
				macroStep.append("        <Stroke x=\"270\" y=\""+(92+120*(i+1))+"\"/>"+newLine);
				macroStep.append("        <Stroke x=\"270\" y=\""+(92+120*(i+1))+"\"/>"+newLine);
				macroStep.append("        <Stroke x=\"270\" y=\""+(92+120*(i+1))+"\"/>"+newLine);
				macroStep.append("        <Stroke x=\"270\" y=\""+(92+120*(i+1))+"\"/>"+newLine);
				macroStep.append("        <Stroke x=\"270\" y=\""+(109+120*(i+1))+"\"/>"+newLine);
				macroStep.append("      </GCLink>"+newLine);

				String toObject = "ExitState-"+skillXML_file;
				if( (i+1)<stateList.size() ){
					toObject = stateList.get(i+1).getName();
				}
				macroStep.append("      <GCLink fromObject=\"transition-"+stateList.get(i).getName()+"\" manAdj=\"0\" toObject=\""+toObject+"\">"+newLine);
				macroStep.append("        <Stroke x=\"270\" y=\""+(136+120*(i+1))+"\"/>"+newLine);
				macroStep.append("        <Stroke x=\"270\" y=\""+(136+120*(i+1))+"\"/>"+newLine);
				macroStep.append("        <Stroke x=\"270\" y=\""+(136+120*(i+1))+"\"/>"+newLine);
				macroStep.append("        <Stroke x=\"270\" y=\""+(136+120*(i+1))+"\"/>"+newLine);
				macroStep.append("        <Stroke x=\"270\" y=\""+(136+120*(i+1))+"\"/>"+newLine);
				macroStep.append("        <Stroke x=\"270\" y=\""+(155+120*(i+1))+"\"/>"+newLine);
				macroStep.append("      </GCLink>"+newLine);			
			}

			macroStep.append("    </GCDocument>"+newLine);
			macroStep.append("  </MacroStep>");

			return macroStep.toString();
			
		}
		
		private static String sensorNameR = "i.y_meas.get";//"i.y_meas_extR.get";//"i.ifkAnalogOut.get";//"i.y_meas";
		private static String sensorNameL = "i.y_meas.get";//"i.y_meas_extL.get";//"i.ifkAnalogOut.get";//"i.y_meas";
		private static int  sensorIndexR = 0;
		private static int  sensorIndexL = 48;
		
		private static String distance = "i.y_meas.get";//"i.y_meas";
		

		private String createErrorTransitionCondition(ErrorConstraint ec, boolean sign, boolean left){
			String cond = "";
			String sensorName = left? sensorNameL: sensorNameR;
			int leftOffset = left? 48:0;
			double threshold = ec.getThreshold();
			if(ec.type().equals("forcecontrolled")){
				
				int sensorDirection = ec.getMotionDir().toLowerCase().charAt(0)-'x'; // different sensors for left and right!
				
				String ltgt = "";
				if(sign && ec.sign() || !sign && !ec.sign()){
					ltgt = " &gt; ";
				}else{
					ltgt = " &lt; ";
				}
				cond += sensorName +  "("+ sensorDirection +")" + ltgt + threshold;
				}
				else if (ec.type().equals("distancecontrolled")){
					
					int dir = ec.getMotionDir().toLowerCase().charAt(0)-'x';
					int sensorDirection = dir + 12 + leftOffset; // uses ref values!
					int refIndex = 25+dir-1;
					String ltgt = "";
					if(sign && ec.sign() || !sign && !ec.sign()){
						ltgt = " &gt; ";
					}else{
						ltgt = " &lt; ";
					}
					// 
					//String transitionCondition = "((o.refs.get("+refIndex+")-i.y_meas.get("+dirRef+")) < 0.5)";
					cond += "((o.refs.get("+refIndex+")-"+distance+"("+sensorDirection+")) "+ltgt+ "" +threshold+")"; //distance +  "("+ sensorDirection +")" + ltgt + threshold;
				}
		
		return cond;
			
			
			
		}

			
		
		
		private String createTransitionCondition(State state, boolean sign, boolean left){
			String cond = "";
			int nbrOfFinals = state.nbrOfFinalConditions();
			if(nbrOfFinals == 0) return "1";
			String sensorName = left? sensorNameL: sensorNameR;
			int leftOffset = left? 48:0;
			if(nbrOfFinals>1){
				for(int i = 0; i < nbrOfFinals-1; i++){
					FinalConstraint c = state.getFinalConstraint(i);
					System.out.println("DISTance=??+" + c.type());
					if(c.type().equals("forcecontrolled")){
					double threshold = c.getThreshold();
					
					int sensorDirection = c.getMotionDir().toLowerCase().charAt(0)-'x'; // different sensors for left and right!
					
					String ltgt = "";
					if(sign && c.sign() || !sign && !c.sign()){
						ltgt = " &gt; ";
					}else{
						ltgt = " &lt; ";
					}
					cond += sensorName +  "("+ sensorDirection +")" + ltgt + threshold;
					}
					else if (c.type().equals("distancecontrolled")){
						
						double threshold = c.getThreshold();
						int dir = c.getMotionDir().toLowerCase().charAt(0)-'x';
						int sensorDirection = dir + 12 + leftOffset; // uses ref values!
						int refIndex = 25+dir-1;
						String ltgt = "";
						if(sign && c.sign() || !sign && !c.sign()){
							ltgt = " &gt; ";
						}else{
							ltgt = " &lt; ";
						}
						// 
						//String transitionCondition = "((o.refs.get("+refIndex+")-i.y_meas.get("+dirRef+")) < 0.5)";
						cond += "((o.refs.get("+refIndex+")-"+distance+"("+sensorDirection+")) "+ltgt+ "" +threshold+")"; //distance +  "("+ sensorDirection +")" + ltgt + threshold;
					}
					cond += " | ";
				}
			}
			FinalConstraint c = state.getFinalConstraint(nbrOfFinals-1);
			double threshold = c.getThreshold();
			if(c.type().equals("forcecontrolled")){
				
				int sensorDirection = c.getMotionDir().toLowerCase().charAt(0)-'x'; // different sensors for left and right!
				
				String ltgt = "";
				if(sign && c.sign() || !sign && !c.sign()){
					ltgt = " &gt; ";
				}else{
					ltgt = " &lt; ";
				}
				cond += sensorName +  "("+ sensorDirection +")" + ltgt + threshold;
				}
				else if (c.type().equals("distancecontrolled")){
					
					int dir = c.getMotionDir().toLowerCase().charAt(0)-'x';
					int sensorDirection = dir + 12 + leftOffset; // uses ref values!
					int refIndex = 25+dir-1;
					String ltgt = "";
					if(sign && c.sign() || !sign && !c.sign()){
						ltgt = " &gt; ";
					}else{
						ltgt = " &lt; ";
					}
					// 
					//String transitionCondition = "((o.refs.get("+refIndex+")-i.y_meas.get("+dirRef+")) < 0.5)";
					cond += "((o.refs.get("+refIndex+")-"+distance+"("+sensorDirection+")) "+ltgt+ "" +threshold+")"; //distance +  "("+ sensorDirection +")" + ltgt + threshold;
				}
		
		return cond;
			
			
			
		}

		public String stateAction(int stateNumber, String newLine, int actionNumber){
			StringBuilder refActions = new StringBuilder();
			refActions.append("//set references"+newLine);
			
			StringBuilder ctrlparActions = new StringBuilder();
			ctrlparActions.append("//Set control of all outputs"+newLine);
			ctrlparActions.append("//          coord              type              active                 K/M                  D          Sampling period             max(u)"+newLine);
					
			StringBuilder cfActions = new StringBuilder();
			cfActions.append("// Set outputs, i.e, the Cf-matrix"+newLine);

			StringBuilder redundWeightActions = new StringBuilder();
			redundWeightActions.append("// Set redund_weight, i.e, the Mq-matrix"+newLine);
			for(int i=0;i<7;i++){
				for(int j=0;j<7;j++){
					int toInsert = 0;
					if(i==j){
						toInsert = 1;
					}
					redundWeightActions.append("S o.redund_weight.set("+(1+j+i*14-1)+","+toInsert+"); ");
				}
				redundWeightActions.append(newLine);
			}
			
			int i=actionNumber;
			for(int k=0;k<6;k++){

				int dirDefined = -1;

				if( stateList.get(i).getDirection().getMotionDir().equals(dirs[k]) ){
					dirDefined = 100;
				} else {
					for(int j=0;j<stateList.get(i).getNumberOfConstraints();j++){
						if( stateList.get(i).getConstraint(j).getMotionDir().equals(dirs[k]) ){
							dirDefined = j;
						}
					}
				}

				if(dirDefined<0){
					refActions.append("S o.refs"+(25+k)+" = 0; // zero velocity, "+ft.get(0).getFrame()+"-"+ft.get(0).getTool()+"-"+dirs[k]+newLine);
					if( k<3 ){
						ctrlparActions.append("S o.ctrlpar.set("+(10*k)+" , "+(k+1)+");  S o.ctrlpar.set("+(2+10*k-1)+" , 2);  S o.ctrlpar.set("+(3+10*k-1)+" , 1);  S o.ctrlpar.set("+(4+10*k-1)+" , 0);  S o.ctrlpar.set("+(5+10*k-1)+" , 0);  S o.ctrlpar.set("+(6+10*k-1)+" , 0.004);  S o.ctrlpar.set("+(7+10*k-1)+" , 10);  //"+ft.get(0).getFrame()+"-"+ft.get(0).getTool()+"-"+dirs[k]+newLine);
					} else {
						ctrlparActions.append("S o.ctrlpar.set("+(10*k)+" , "+(k+1)+");  S o.ctrlpar.set("+(2+10*k-1)+" , 2);  S o.ctrlpar.set("+(3+10*k-1)+" , 1);  S o.ctrlpar.set("+(4+10*k-1)+" , 0);  S o.ctrlpar.set("+(5+10*k-1)+" , 0);  S o.ctrlpar.set("+(6+10*k-1)+" , 0.004);  S o.ctrlpar.set("+(7+10*k-1)+" , 0.1);  //"+ft.get(0).getFrame()+"-"+ft.get(0).getTool()+"-"+dirs[k]+newLine);
					}
					for(int j=0;j<12;j++){
						int toInsert=0;
						if(j==k){
							toInsert = 1;
						}
						cfActions.append("S o.Cf"+(12*k+j+1)+"="+toInsert+"; ");
					}
					cfActions.append(newLine);
				} else if(dirDefined==100){
					String stateTool = stateList.get(i).getTool();
					String stateFrame = stateList.get(i).getDirection().getFrame();
					int ftToUse = -1;
					for(int j=0;j<ft.size();j++){
						if(stateTool.equals(ft.get(j).getTool()) && stateFrame.equals(ft.get(j).getFrame()) ){
							ftToUse = j;
						}
					}
					double searchVelocity = 0.0;
					if(k<3){
						if( stateList.get(i).getDirection().getUnit().equals("mm/s") ){
							searchVelocity = stateList.get(i).getDirection().getSearchVelocity();
						} else if( stateList.get(i).getDirection().getUnit().equals("m/s") ){
							searchVelocity = stateList.get(i).getDirection().getSearchVelocity()*1000;
						} else {
							System.out.println("The following unit is not supported: "+stateList.get(i).getDirection().getUnit());
							System.exit(1);
						}
						refActions.append("S o.refs.set("+(25+k+ftToUse*6-1)+", "+searchVelocity+"); // search velocity (mm/s), "+stateFrame+"-"+stateTool+"-"+dirs[k]+newLine);
					} else {
						if( stateList.get(i).getDirection().getUnit().equals("rad/s") ){
							searchVelocity = stateList.get(i).getDirection().getSearchVelocity();
						} else if( stateList.get(i).getDirection().getUnit().equals("deg/s") || stateList.get(i).getDirection().getUnit().equals("degrees/s") ){
							searchVelocity = stateList.get(i).getDirection().getSearchVelocity()*Math.PI/180;
						} else {
							System.out.println("The following unit is not supported: "+stateList.get(i).getDirection().getUnit());
							System.exit(1);
						}
						refActions.append("S o.refs.set("+(25+k+ftToUse*6-1)+", "+searchVelocity+"); // search velocity (rad/s), "+stateFrame+"-"+stateTool+"-"+dirs[k]+newLine);
					}
					ctrlparActions.append("S o.ctrlpar.set("+(1+10*(k+ftToUse*6)-1)+" , "+(k+1)+");  S o.ctrlpar.set("+(2+10*(k+ftToUse*6)-1)+" , 2);  S o.ctrlpar.set("+(3+10*(k+ftToUse*6)-1)+" , 1);  S o.ctrlpar.set("+(4+10*(k+ftToUse*6)-1)+" , 0);  S o.ctrlpar.set("+(5+10*(k+ftToUse*6)-1)+" , 0);  S o.ctrlpar.set("+(6+10*(k+ftToUse*6)-1)+" , 0.004);  S o.ctrlpar.set("+(7+10*(k+ftToUse*6)-1)+" , "+Math.abs(searchVelocity*1.5)+");  //"+ft.get(0).getFrame()+"-"+ft.get(0).getTool()+"-"+dirs[k]+newLine);

					for(int j=0;j<12;j++){
						int toInsert=0;
						if(j==(k+ftToUse*6)){
							toInsert = 1;
						}
						cfActions.append("S o.Cf.set("+(12*k+j)+","+toInsert+"); ");
					}
					cfActions.append(newLine);
				} else {
					String stateTool = stateList.get(i).getTool();
					String stateFrame = stateList.get(i).getConstraint(dirDefined).getFrame();
					int ftToUse = -1;
					for(int j=0;j<ft.size();j++){
						if(stateTool.equals(ft.get(j).getTool()) && stateFrame.equals(ft.get(j).getFrame()) ){
							ftToUse = j;
						}
					}
					double forceRef = 0.0;
					if(k<3){
						if( stateList.get(i).getConstraint(dirDefined).getUnit().equals("N") ){
							forceRef = stateList.get(i).getConstraint(dirDefined).getReference();
						} else if( stateList.get(i).getConstraint(dirDefined).getUnit().equals("mN") ){
							forceRef = stateList.get(i).getConstraint(dirDefined).getReference()*0.001;
						} else {
							System.out.println("The following unit is not supported: "+stateList.get(i).getConstraint(dirDefined).getUnit());
							System.exit(1);
						}
						refActions.append("S o.refs.set("+(25+k+ftToUse*6-1)+", "+forceRef+"); // force control (N), "+stateFrame+"-"+stateTool+"-"+dirs[k]+newLine);
					} else {
						if( stateList.get(i).getConstraint(dirDefined).getUnit().equals("Nmm") || stateList.get(i).getConstraint(dirDefined).getUnit().equals("mNm")){
							forceRef = stateList.get(i).getConstraint(dirDefined).getReference();
						} else if( stateList.get(i).getConstraint(dirDefined).getUnit().equals("Nm") ){
							forceRef = stateList.get(i).getConstraint(dirDefined).getReference()*1000;
						} else {
							System.out.println("The following unit is not supported: "+stateList.get(i).getConstraint(dirDefined).getUnit());
							System.exit(1);
						}
						refActions.append("S o.refs.set("+(25+k+ftToUse*6-1)+" , "+forceRef+"); // torque control (Nmm), "+stateFrame+"-"+stateTool+"-"+dirs[k]+newLine);	
					}
					String cId = stateList.get(i).getConstraint(dirDefined).getControllerId();
					int cNumber = -1;
					for(int n=0;n<controllerList.size();n++){
						if(controllerList.get(n).getName().equals(cId)){
							cNumber = n;
							break;
						}
					}
					double M = controllerList.get(cNumber).getM();
					double D = controllerList.get(cNumber).getD();
					double maxVel = 20;
					if( k>=3 ){
						maxVel = 0.1;
					}
					ctrlparActions.append("S o.ctrlpar.set("+(1+10*(k+ftToUse*6)-1)+" , "+(k+1)+");  S o.ctrlpar.set("+(2+10*(k+ftToUse*6)-1)+" , 1);  S o.ctrlpar.set("+(3+10*(k+ftToUse*6)-1)+" , 1);  S o.ctrlpar.set("+(4+10*(k+ftToUse*6)-1)+" , "+M+");  S o.ctrlpar.set("+(5+10*(k+ftToUse*6)-1)+" , "+D+");  S o.ctrlpar.set("+(6+10*(k+ftToUse*6)-1)+" , 0.004);  S o.ctrlpar.set("+(7+10*(k+ftToUse*6)-1)+" , "+maxVel+");  //"+ft.get(0).getFrame()+"-"+ft.get(0).getTool()+"-"+dirs[k]+newLine);

					for(int j=0;j<12;j++){
						int toInsert=0;
						if(j==(k+ftToUse*6)){
							toInsert = 1;
						}
						cfActions.append("S o.Cf"+(12*k+j+1)+"="+toInsert+"; ");
					}
					cfActions.append(newLine);
				}
			}
			String returnString = refActions.toString()+newLine+ctrlparActions.toString()+newLine+cfActions.toString()+newLine+redundWeightActions.toString()+newLine+"S o.state1 = "+stateNumber+";";
			
			return returnString;
		}




  public static String buildXMLFile(ReadWriteTextFile rwtf, String macroStep, RobotType rob){

	// DEBUG!!
	String fullPath = "/Users/maj/git/codegen/codeGenerationServlet/WebContent/WEB-INF/";//GenerateCode.context.getRealPath("/WEB-INF") + "/";
    String beforeMacro = fullPath+"beforeMacrostep.txt";
    String afterMacro = fullPath+"afterMacrostep.txt";
    if( rob==RobotType.FridaLeftArm ){
	beforeMacro = fullPath+"beforeMacrostepFridaLeft.txt";
	afterMacro = fullPath+"afterMacrostepFridaLeft.txt";
    }

    XMLconstants x = new XMLconstants();
    x.xmlStart = rwtf.getContents(new File(beforeMacro));
    x.xmlEnd = rwtf.getContents(new File(afterMacro));
    StringBuilder contents = new StringBuilder();
    contents.append(x.xmlStart);

    contents.append(macroStep);

    contents.append(x.xmlEnd);

    return contents.toString();
  }

  private enum STATE_TYPE{SEARCH, FORCE_CONTROLLED, BOUNCE};
  
  public STATE_TYPE state_type(State state){
	  if(state instanceof BounceState) return STATE_TYPE.BOUNCE;
	 // if(state.bouncy()) return STATE_TYPE.BOUNCE;
	  
	  if(state.nbrOfFinalConditions() == 0) return STATE_TYPE.FORCE_CONTROLLED;
	  return STATE_TYPE.SEARCH;
	  
  }

  private void addBounceSteptoMacro(State state,  RobotType rob, StringBuilder macroStep, int i){
		String searchDirection =state.getDirection().getMotionDir();
		String newLine = System.getProperty("line.separator");
		// ((o.refs.get(26 - 1)-i.y_meas.get(14 - 1)) < 0.5)
		/*
		 * S o.refs.set(26 - 1, i.y_meas.get(14 - 1)+8); // y-ref = y-pos
S o.ctrlpar.set(11 - 1, 2); S o.ctrlpar.set(12 - 1, 4); S o.ctrlpar.set(13 - 1, 1); S o.ctrlpar.set(14 - 1, 4);  S o.ctrlpar.set(15 - 1, 1000);  S o.ctrlpar.set(16 - 1, 0.004);  S o.ctrlpar.set(17 - 1, 10); S o.ctrlpar.set(18 - 1, 50); //y

S o.state = 135.10;
/// X riktining!		
S o.refs.set(25 - 1, i.y_meas.get(13 - 1)+2); // x-ref = x-pos
S o.ctrlpar.set(2 - 1, 4); S o.ctrlpar.set(3 - 1, 1); S o.ctrlpar.set(4 - 1, 5); S o.ctrlpar.set(5 - 1, 1000); S o.ctrlpar.set(6 - 1, 0.004); S o.ctrlpar.set(7 - 1, 10); S o.ctrlpar.set(8 - 1, 50); //x

		ctrlparActions.append("S o.ctrlpar.set("+(1+10*(k+12*rob2)-1)+" , "+(k+1)+");  
		S o.ctrlpar.set("+(2+10*(k+12*rob2)-1)+" , 2);  S o.ctrlpar.set("+(3+10*(k+12*rob2)-1)+" , 1);  S o.ctrlpar.set("+(4+10*(k+12*rob2)-1)+" , 0);  S o.ctrlpar.set("+(5+10*(k+12*rob2)-1)+" , 0);  S o.ctrlpar.set("+(6+10*(k+12*rob2)-1)+" , 0.004);  S o.ctrlpar.set("+(7+10*(k+12*rob2)-1)+" , 10);  //"+ft.get(0).getFrame()+"-"+ft.get(0).getTool()+"-"+dirs[k]+newLine);
			
			
			Z search
			 S o.ctrlpar.set(22 - 1, 2); S o.ctrlpar.set(23 - 1, 1); S o.ctrlpar.set(24 - 1, 0); S o.ctrlpar.set(25 - 1, 1);  S o.ctrlpar.set(27 - 1, 60); S o.ctrlpar.set(28 - 1, 3000); //z

		 */
		
		Direction d = state.getDirection();
		int dir = d.getMotionDir().toLowerCase().charAt(0) - 'x';
		int dirRef = dir + 12;
		double bounceValue = d.getBounce();
		int refIndex = 25+dir-1;
		int rob2 = 0;
		int k = dir;
		if(rob == RobotType.FridaLeftArm){
			refIndex += 48;
			dirRef += 48;
			rob2 = 120;
		}
		String stateActions = "S o.refs.set("+refIndex + ", i.y_meas.get(" + dirRef + ")+ "+bounceValue + "); " + newLine;
		String cntrParamerers = "S o.ctrlpar.set("+(10*k+ rob2)+" , "+(k+1)+");";//+
	/*		"	S o.ctrlpar.set("+(1+ 10*k+ rob2)+" , "+?+");"+
			"	S o.ctrlpar.set("+(2+ 10*k+ rob2)+" , "+1+");"+
			"	S o.ctrlpar.set("+(3+ 10*k+ rob2)+" , "+?+");"+
			"	S o.ctrlpar.set("+(3+ 10*k+ rob2)+" , "+?+");"+
			"	S o.ctrlpar.set("+(4+ 10*k+ rob2)+" , "+?+");"+
			"	S o.ctrlpar.set("+(5+ 10*k+ rob2)+" , "+0.004+");"+
			"	S o.ctrlpar.set("+(6 +10*k+ rob2)+" , "+?+");"+
			"	S o.ctrlpar.set("+(7 + 10*k+ rob2)+" , "+?+");";*/
			
			
			//double signOfSearchVelocity = Math.sign(stateList.get(i).getDirection().getSearchVelocity());
		double signOfSearchVelocity = 0;
		if( state.getDirection().getSearchVelocity() > 0 ){
			signOfSearchVelocity = 1;
		} else if( state.getDirection().getSearchVelocity() < 0 ){
			signOfSearchVelocity = -1;
		}
		int coordNumber = -1;
		for(int j=0;j<6;j++){
			if(searchDirection.equals(dirs[j])){
				coordNumber = j;
				break;
			}
		}
		//int yVecNumber = coordNumber+1+ftToUse*6;
		/*double threshold = 0.0;
		String thresUnit = stateList.get(i).getDirection().getThresholdUnit();
		if(coordNumber<3){				
			if( thresUnit.equals("N") ){
				threshold = stateList.get(i).getDirection().getThreshold();
			} else if( thresUnit.equals("mN") ){
				threshold = stateList.get(i).getDirection().getThreshold()*0.001;
			} else {
				System.out.println("The following unit is not supported: "+thresUnit);
				System.exit(1);
			}
		} else {
			if( thresUnit.equals("Nmm") || thresUnit.equals("mNm") ){
				threshold = stateList.get(i).getDirection().getThreshold();
			} else if( thresUnit.equals("Nm") ){
				threshold = stateList.get(i).getDirection().getThreshold()*1000;
			} else {
				System.out.println("The following unit is not supported: "+thresUnit);
				System.exit(1);
			}
		}
		*/
		int offsetDueToRob2 = 0;
		if(rob == RobotType.FridaLeftArm){
			offsetDueToRob2 = 48;
		}

		String transitionCondition = "((o.refs.get("+refIndex+")-i.y_meas.get("+dirRef+")) &lt; 0.5)";
		macroStep.append("      <GCStep actionBlockVisible=\"1\" actionText=\""+stateActions+"\" fileName=\"\" height=\"55\" id=\""+state.getName()+"\" name=\""+state.getName()+"\" useIcon=\"0\" width=\"147\" x=\"248\" y=\""+(36+120*(i+1))+"\"/>"+newLine);
		macroStep.append("      <GCTransition CGURI=\"\" actionText=\""+transitionCondition+"\" conditionVisible=\"0\" height=\"25\" id=\"transition-"+state.getName()+"\" width=\"30\" x=\"255\" y=\""+(110+(i+1)*120)+"\"/>"+newLine);
	
	  
	  
}

  private void addErrorHandlingProcedure(State state, ErrorConstraint ec, RobotType rob, StringBuilder macroStep,  int i, State errorState)
  {
		String newLine = System.getProperty("line.separator");
		int x = state.getNextTransPos().x+50;
		int nbrOfErrorCond = state.nbrOfErrorConditions();
		for(int index = 0; index < nbrOfErrorCond; index++){
			ErrorConstraint e = state.getErrorConstraint(index);
			
				String toObject = errorState.getName();
				double signOfSearchVelocity = 0;
				if( state.getDirection().getSearchVelocity() > 0 ){
					signOfSearchVelocity = 1;
				} else if( state.getDirection().getSearchVelocity() < 0 ){
					signOfSearchVelocity = -1;
				}
	
	  String transitionCondition = createErrorTransitionCondition(ec, signOfSearchVelocity < 0,rob == RobotType.FridaLeftArm );
		macroStep.append("      <GCTransition CGURI=\"\" actionText=\""+transitionCondition+"\" conditionVisible=\"0\" height=\"25\" id=\"errortransition-"+state.getName()+"\" width=\"30\" x=\""+x+"\" y=\""+state.getNextTransPos().y+"\"/>"+newLine);
		macroStep.append("      <GCLink fromObject=\""+state.getName()+"\" manAdj=\"0\" toObject=\"errortransition-"+state.getName()+"\">"+newLine);
		macroStep.append("        <Stroke x=\""+state.getNextStrokePos().x+"\" y=\""+state.getNextStrokePos().y+"\"/>"+newLine);
		macroStep.append("        <Stroke x=\""+x+"\" y=\""+state.getNextStrokePos().y+"\"/>"+newLine);
		//macroStep.append("        <Stroke x=\""+x+"\" y=\""+(92+120*(i+1))+"\"/>"+newLine);
		//macroStep.append("        <Stroke x=\""+x+"\" y=\""+(92+120*(i+1))+"\"/>"+newLine);
	//	macroStep.append("        <Stroke x=\""+x+"\" y=\""+state.getNextStrokePos().y+"\"/>"+newLine);
		macroStep.append("        <Stroke x=\""+x+"\" y=\""+state.getLastStrokePos().y+"\"/>"+newLine);
		macroStep.append("      </GCLink>"+newLine);
		int errorLine = 600;
		macroStep.append("      <GCLink fromObject=\"errortransition-"+state.getName()+"\" manAdj=\"0\" toObject=\""+toObject+"\">"+newLine);
		macroStep.append("        <Stroke x=\""+state.getNextTransStrokePos().x+"\" y=\""+state.getNextTransStrokePos().y+"\"/>"+newLine);
		macroStep.append("        <Stroke x=\""+errorLine+"\" y=\""+state.getNextTransStrokePos().y+"\"/>"+newLine);
		macroStep.append("        <Stroke x=\""+errorLine+"\" y=\""+errorState.getAboveStatePos().y+"\"/>"+newLine);
		macroStep.append("        <Stroke x=\""+errorState.getAboveStatePos().x+"\" y=\""+errorState.getAboveStatePos().y+"\"/>"+newLine);
		
		//macroStep.append("        <Stroke x=\"270\" y=\""+(136+120*(i+1))+"\"/>"+newLine);
		//macroStep.append("        <Stroke x=\"270\" y=\""+(136+120*(i+1))+"\"/>"+newLine);
		//macroStep.append("        <Stroke x=\"270\" y=\""+(136+120*(i+1))+"\"/>"+newLine);
		//macroStep.append("        <Stroke x=\"270\" y=\""+(136+120*(i+1))+"\"/>"+newLine);
	//	macroStep.append("        <Stroke x=\""+state.getLastTransStrokePos().x+"\" y=\""+state.getLastTransStrokePos().y+"\"/>"+newLine);
		
		macroStep.append("      </GCLink>"+newLine);			
	
	
		
		}

  }
  
  private void addSearchSteptoMacro(State state, int ftToUse,  RobotType rob, StringBuilder macroStep, String stateActions, int i){
		String searchDirection =state.getDirection().getMotionDir();
		String newLine = System.getProperty("line.separator");
		//double signOfSearchVelocity = Math.sign(stateList.get(i).getDirection().getSearchVelocity());
		double signOfSearchVelocity = 0;
		if( state.getDirection().getSearchVelocity() > 0 ){
			signOfSearchVelocity = 1;
		} else if( state.getDirection().getSearchVelocity() < 0 ){
			signOfSearchVelocity = -1;
		}
		int coordNumber = -1;
		for(int j=0;j<6;j++){
			if(searchDirection.equals(dirs[j])){
				coordNumber = j;
				break;
			}
		}
		int yVecNumber = coordNumber+1+ftToUse*6;
		/*double threshold = 0.0;
		String thresUnit = stateList.get(i).getDirection().getThresholdUnit();
		if(coordNumber<3){				
			if( thresUnit.equals("N") ){
				threshold = stateList.get(i).getDirection().getThreshold();
			} else if( thresUnit.equals("mN") ){
				threshold = stateList.get(i).getDirection().getThreshold()*0.001;
			} else {
				System.out.println("The following unit is not supported: "+thresUnit);
				System.exit(1);
			}
		} else {
			if( thresUnit.equals("Nmm") || thresUnit.equals("mNm") ){
				threshold = stateList.get(i).getDirection().getThreshold();
			} else if( thresUnit.equals("Nm") ){
				threshold = stateList.get(i).getDirection().getThreshold()*1000;
			} else {
				System.out.println("The following unit is not supported: "+thresUnit);
				System.exit(1);
			}
		}
		*/
		int offsetDueToRob2 = 0;
		if(rob == RobotType.FridaLeftArm){
			offsetDueToRob2 = 48;
		}
/*
		if( signOfSearchVelocity < 0 ){
			transitionCondition = "i.y_meas"+(yVecNumber+offsetDueToRob2)+" &gt; "+threshold;
		} else if( signOfSearchVelocity > 0 ){
			transitionCondition = "i.y_meas"+(yVecNumber+offsetDueToRob2)+" &lt; "+threshold;
		}*/
		String transitionCondition = createTransitionCondition(state, signOfSearchVelocity < 0 ,rob == RobotType.FridaLeftArm);
		macroStep.append("      <GCStep actionBlockVisible=\"1\" actionText=\""+stateActions+"\" fileName=\"\" height=\"55\" id=\""+state.getName()+"\" name=\""+state.getName()+"\" useIcon=\"0\" width=\"147\" x=\""+state.getStatePos().x+"\" y=\""+state.getStatePos().y+"\"/>"+newLine);
		macroStep.append("      <GCTransition CGURI=\"\" actionText=\""+transitionCondition+"\" conditionVisible=\"0\" height=\"25\" id=\"transition-"+state.getName()+"\" width=\"30\" x=\""+state.getNextTransPos().x+"\" y=\""+state.getNextTransPos().y+"\"/>"+newLine);
	
		String connect_back_id = state.jumpToId();
		if(connect_back_id != null){
			State back_state = findState(connect_back_id);
			if(back_state!= null){
			System.out.println("Supposed to retirn to " + connect_back_id);
			// if error state
		//	transitionCondition = "1";
		//	macroStep.append("      <GCTransition CGURI=\"\" actionText=\""+transitionCondition+"\" conditionVisible=\"1\" height=\"25\" id=\"back-transition-"+state.getName()+"\" width=\"30\" x=\""+state.getNextTransPos().x+"\" y=\""+state.getNextTransPos().y+"\"/>"+newLine);
		//	macroStep.append("      <GCLink fromObject=\"transition-"+state.getName()+"\" manAdj=\"0\" toObject=\""+back_state.getName()+"\">"+newLine);
		//	macroStep.append("        <Stroke x=\""+state.getNextStrokePos().x+"\" y=\""+state.getNextStrokePos().y+"\"/>"+newLine);
		//	macroStep.append("        <Stroke x=\""+x+"\" y=\""+state.getNextStrokePos().y+"\"/>"+newLine);
			//macroStep.append("        <Stroke x=\""+x+"\" y=\""+(92+120*(i+1))+"\"/>"+newLine);
			//macroStep.append("        <Stroke x=\""+x+"\" y=\""+(92+120*(i+1))+"\"/>"+newLine);
		//	macroStep.append("        <Stroke x=\""+x+"\" y=\""+state.getNextStrokePos().y+"\"/>"+newLine);
		//	macroStep.append("        <Stroke x=\""+x+"\" y=\""+state.getLastStrokePos().y+"\"/>"+newLine);
		//	macroStep.append("      </GCLink>"+newLine);
		//	int errorLine = 600;
			macroStep.append("      <GCLink fromObject=\"transition-"+state.getName()+"\" manAdj=\"0\" toObject=\""+back_state.getName()+"\">"+newLine);
			macroStep.append("        <Stroke x=\""+state.getNextTransStrokePos().x+"\" y=\""+state.getNextTransStrokePos().y+"\"/>"+newLine);
			macroStep.append("        <Stroke x=\""+back_state.getAboveStatePos().x+"\" y=\""+state.getNextTransStrokePos().y+"\"/>"+newLine);
			macroStep.append("        <Stroke x=\""+back_state.getAboveStatePos().x+"\" y=\""+back_state.getAboveStatePos().y+"\"/>"+newLine);
			
			//macroStep.append("        <Stroke x=\"270\" y=\""+(136+120*(i+1))+"\"/>"+newLine);
			//macroStep.append("        <Stroke x=\"270\" y=\""+(136+120*(i+1))+"\"/>"+newLine);
			//macroStep.append("        <Stroke x=\"270\" y=\""+(136+120*(i+1))+"\"/>"+newLine);
			//macroStep.append("        <Stroke x=\"270\" y=\""+(136+120*(i+1))+"\"/>"+newLine);
		//	macroStep.append("        <Stroke x=\""+state.getLastTransStrokePos().x+"\" y=\""+state.getLastTransStrokePos().y+"\"/>"+newLine);
			
			macroStep.append("      </GCLink>"+newLine);			
			}
		
		}
	  
	  
  }
  
  	public State findErrorState(String id){
  		for(State s: errorstateList){
  			if(id.equals(s.getName())) return s;
  		}
  		return null;
  		
  	}
  	public State findState(String id){
  		for(State s: stateList){
  			if(id.equals(s.getName())) return s;
  		}
  		return null;
  		
  	}
  
	public String macroStepXML(String skillXML_file, String id, RobotType rob, int initialX, int initialY){
		
		String newLine = System.getProperty("line.separator");
		StringBuilder macroStep = new StringBuilder();
		macroStep.append("  <MacroStep actionText=\";\" fileName=\"\" height=\"70\" id=\""+id+"\" name=\""+skillXML_file+"\" useIcon=\"0\" width=\"60\" x=\""+initialX+"\" y=\""+initialY+"\">"+newLine); // 460 765
		macroStep.append("    <GCDocument color=\"-1\" height=\"832\" scale=\"1.0\" viewPositionX=\"0\" viewPositionY=\"0\" width=\"1155\" x=\"0\" y=\"0\">"+newLine);
		String enterStateActions = enterStateAction(101,"&#10;",rob);
		macroStep.append("      <EnterStep actionBlockVisible=\"1\" actionText=\""+enterStateActions+"\" fileName=\"\" height=\"55\" id=\"EnterState-"+skillXML_file+"\" name=\"Set kinematic chains\" useIcon=\"0\" width=\"147\" x=\"244\" y=\"36\"/>"+newLine);
		String exitStateActions = exitStateAction(101+stateList.size()+1,"&#10;",rob);
		macroStep.append("      <ExitStep actionBlockVisible=\"1\" actionText=\""+exitStateActions+"\" fileName=\"\" height=\"55\" id=\"ExitState-"+skillXML_file+"\" name=\"Skill finished\" useIcon=\"0\" width=\"147\" x=\"244\" y=\""+(120*(stateList.size()+1)+36)+"\"/>"+newLine);
		int kinConvergedNumber = 1;
		if(rob == RobotType.FridaLeftArm){
			kinConvergedNumber = 2;
		}
		macroStep.append("      <GCTransition CGURI=\"\" actionText=\"i.kinematicsConverged.get("+(kinConvergedNumber-1)+") &gt; 0.5\" conditionVisible=\"0\" height=\"25\" id=\"kinematicsConvergedTransition\" width=\"30\" x=\"255\" y=\"110\"/>"+newLine);

		for(int i=0;i<stateList.size();i++){
			State state = stateList.get(i);
			state.setNbr(i, true);
		}
		for(int i=0;i<errorstateList.size();i++){
			State state = errorstateList.get(i);
			state.setNbr(i, false);
		}
		
		for(int i=0;i<errorstateList.size();i++){
			State state = errorstateList.get(i);

			System.out.println("is error state "+ state.getName());
			
			String stateActions = stateAction(101+i+1,"&#10;",i,rob);
			String transitionCondition = "0";

			String stateTool = state.getTool();
			String stateFrame = state.getDirection().getFrame();
			int ftToUse = -1;
			for(int j=0;j<ft.size();j++){
				if(stateTool.equals(ft.get(j).getTool()) && stateFrame.equals(ft.get(j).getFrame()) ){
					ftToUse = j;
				}
			}
			System.out.println("HAndling "+ state.getName());
			switch(state_type(state)){

			case SEARCH: addSearchSteptoMacro(state,ftToUse, rob, macroStep, stateActions, i);

			System.out.println("HAndling  search"+ state.getName());
			break;
			case FORCE_CONTROLLED: 
				//addForceControlledStepToMacro();

				System.out.println("HAndling "+ state.getName());
				break;
			case BOUNCE:

				System.out.println("HAndling bounce "+ state.getName());
				addBounceSteptoMacro(state, rob, macroStep, i);
				break;
			
			
			}
			if(state.hasErrorHandling()){
				for(int k = 0; k < state.nbrOfErrorConditions(); k++){
				State errorState = findErrorState(state.getErrorConstraint(k).getStateId());
				if(errorState != null){
				addErrorHandlingProcedure(state,state.getErrorConstraint(k), rob, macroStep,i, errorState);
				}
				}
			}
			}
		
		
		for(int i=0;i<stateList.size();i++){
			State state = stateList.get(i);
			state.setNbr(i, true);
			String stateActions = stateAction(101+i+1,"&#10;",i,rob);
			String transitionCondition = "0";

			String stateTool = state.getTool();
			String stateFrame = state.getDirection().getFrame();
			int ftToUse = -1;
			for(int j=0;j<ft.size();j++){
				if(stateTool.equals(ft.get(j).getTool()) && stateFrame.equals(ft.get(j).getFrame()) ){
					ftToUse = j;
				}
			}
			System.out.println("HAndling "+ state.getName());
			switch(state_type(state)){
			case SEARCH: addSearchSteptoMacro(state,ftToUse, rob, macroStep, stateActions, i);
			break;
			case FORCE_CONTROLLED: 
				//addForceControlledStepToMacro();
				
				break;
			case BOUNCE:

				addBounceSteptoMacro(state, rob, macroStep, i);
				break;
			
			
			}
			if(state.hasErrorHandling()){
				for(int k = 0; k < state.nbrOfErrorConditions(); k++){
				State errorState = findErrorState(state.getErrorConstraint(k).getStateId());

				System.out.println("Looking for error state " + state.getErrorConstraint(k).getStateId() );
				if(errorState != null){

					System.out.println("FOUND  error state " + state.getErrorConstraint(k).getStateId() );					
					addErrorHandlingProcedure(state,state.getErrorConstraint(k), rob, macroStep,i, errorState);
					}
				}
			}
			}
		
			

		//Add links
		macroStep.append("      <GCLink fromObject=\"EnterState-"+skillXML_file+"\" manAdj=\"0\" toObject=\"kinematicsConvergedTransition\">"+newLine);
		macroStep.append("        <Stroke x=\"270\" y=\"92\"/>"+newLine);
	//	macroStep.append("        <Stroke x=\"270\" y=\"92\"/>"+newLine);
	//	macroStep.append("        <Stroke x=\"270\" y=\"92\"/>"+newLine);
	//	macroStep.append("        <Stroke x=\"270\" y=\"92\"/>"+newLine);
	//	macroStep.append("        <Stroke x=\"270\" y=\"92\"/>"+newLine);
		macroStep.append("        <Stroke x=\"270\" y=\"109\"/>"+newLine);
		macroStep.append("      </GCLink>"+newLine);

		macroStep.append("      <GCLink fromObject=\"kinematicsConvergedTransition\" manAdj=\"0\" toObject=\""+stateList.get(0).getName()+"\">"+newLine);
		macroStep.append("        <Stroke x=\"270\" y=\"136\"/>"+newLine);
	//	macroStep.append("        <Stroke x=\"270\" y=\"136\"/>"+newLine);
	//	macroStep.append("        <Stroke x=\"270\" y=\"136\"/>"+newLine);
	//	macroStep.append("        <Stroke x=\"270\" y=\"136\"/>"+newLine);
	//	macroStep.append("        <Stroke x=\"270\" y=\"136\"/>"+newLine);
		macroStep.append("        <Stroke x=\"270\" y=\"155\"/>"+newLine);
		macroStep.append("      </GCLink>"+newLine);
		
		for(int i=0;i<stateList.size();i++){
			State state= stateList.get(i);
			macroStep.append("      <GCLink fromObject=\""+state.getName()+"\" manAdj=\"0\" toObject=\"transition-"+state.getName()+"\">"+newLine);
			macroStep.append("        <Stroke x=\""+state.getNextStrokePos().x+"\" y=\""+state.getNextStrokePos().y+"\"/>"+newLine);
		//	macroStep.append("        <Stroke x=\"270\" y=\""+(92+120*(i+1))+"\"/>"+newLine);
		//	macroStep.append("        <Stroke x=\"270\" y=\""+(92+120*(i+1))+"\"/>"+newLine);
		//	macroStep.append("        <Stroke x=\"270\" y=\""+(92+120*(i+1))+"\"/>"+newLine);
		//	macroStep.append("        <Stroke x=\"270\" y=\""+(92+120*(i+1))+"\"/>"+newLine);
			macroStep.append("        <Stroke x=\""+state.getLastStrokePos().x+"\" y=\""+state.getLastStrokePos().y+"\"/>"+newLine);
			macroStep.append("      </GCLink>"+newLine);

			String toObject = "ExitState-"+skillXML_file;
			if( (i+1)<stateList.size() ){
				toObject = stateList.get(i+1).getName();
			}
			macroStep.append("      <GCLink fromObject=\"transition-"+state.getName()+"\" manAdj=\"0\" toObject=\""+toObject+"\">"+newLine);
			macroStep.append("        <Stroke x=\""+state.getNextTransStrokePos().x+"\" y=\""+state.getNextTransStrokePos().y+"\"/>"+newLine);
		//	macroStep.append("        <Stroke x=\"270\" y=\""+(136+120*(i+1))+"\"/>"+newLine);
		//	macroStep.append("        <Stroke x=\"270\" y=\""+(136+120*(i+1))+"\"/>"+newLine);
		//	macroStep.append("        <Stroke x=\"270\" y=\""+(136+120*(i+1))+"\"/>"+newLine);
		//	macroStep.append("        <Stroke x=\"270\" y=\""+(136+120*(i+1))+"\"/>"+newLine);
			macroStep.append("        <Stroke x=\""+state.getLastTransStrokePos().x+"\" y=\""+state.getLastTransStrokePos().y+"\"/>"+newLine);
			macroStep.append("      </GCLink>"+newLine);			
		}

		
		for(int i=0;i<errorstateList.size();i++){
			State state= errorstateList.get(i);
			macroStep.append("      <GCLink fromObject=\""+state.getName()+"\" manAdj=\"0\" toObject=\"transition-"+state.getName()+"\">"+newLine);
			macroStep.append("        <Stroke x=\""+state.getNextStrokePos().x+"\" y=\""+state.getNextStrokePos().y+"\"/>"+newLine);
		//	macroStep.append("        <Stroke x=\"270\" y=\""+(92+120*(i+1))+"\"/>"+newLine);
		//	macroStep.append("        <Stroke x=\"270\" y=\""+(92+120*(i+1))+"\"/>"+newLine);
		//	macroStep.append("        <Stroke x=\"270\" y=\""+(92+120*(i+1))+"\"/>"+newLine);
		//	macroStep.append("        <Stroke x=\"270\" y=\""+(92+120*(i+1))+"\"/>"+newLine);
			macroStep.append("        <Stroke x=\""+state.getLastStrokePos().x+"\" y=\""+state.getLastStrokePos().y+"\"/>"+newLine);
			macroStep.append("      </GCLink>"+newLine);

			if(state.jumpToId() == null || state.jumpToId().length()==0 ){

			String toObject = "ExitState-"+skillXML_file;
			if( (i+1)<errorstateList.size() ){
				toObject = errorstateList.get(i+1).getName();
			}
			macroStep.append("      <GCLink fromObject=\"transition-"+state.getName()+"\" manAdj=\"0\" toObject=\""+toObject+"\">"+newLine);
			macroStep.append("        <Stroke x=\""+state.getNextTransStrokePos().x+"\" y=\""+state.getNextTransStrokePos().y+"\"/>"+newLine);
		//	macroStep.append("        <Stroke x=\"270\" y=\""+(136+120*(i+1))+"\"/>"+newLine);
		//	macroStep.append("        <Stroke x=\"270\" y=\""+(136+120*(i+1))+"\"/>"+newLine);
		//	macroStep.append("        <Stroke x=\"270\" y=\""+(136+120*(i+1))+"\"/>"+newLine);
		//	macroStep.append("        <Stroke x=\"270\" y=\""+(136+120*(i+1))+"\"/>"+newLine);
			macroStep.append("        <Stroke x=\""+state.getLastTransStrokePos().x+"\" y=\""+state.getLastTransStrokePos().y+"\"/>"+newLine);
			macroStep.append("      </GCLink>"+newLine);		
			}
		}
		
		macroStep.append("    </GCDocument>"+newLine);
		macroStep.append("  </MacroStep>");

		return macroStep.toString();
	}

	


	public String stateAction(int stateNumber, String newLine, int actionNumber, RobotType rob){
		int rob2 = 0;
		if( rob == RobotType.FridaLeftArm ){
			rob2 = 1;
		}		
	
		StringBuilder refActions = new StringBuilder();
		refActions.append("//set references"+newLine);
		
		StringBuilder ctrlparActions = new StringBuilder();
		ctrlparActions.append("//Set control of all outputs"+newLine);
		ctrlparActions.append("//          coord              type              active                 K/M                  D          Sampling period             max(u)"+newLine);
				
		StringBuilder cfActions = new StringBuilder();
		cfActions.append("// Set outputs, i.e, the Cf-matrix"+newLine);

		StringBuilder redundWeightActions = new StringBuilder();
		redundWeightActions.append("// Set redund_weight, i.e, the Mq-matrix"+newLine);
		for(int i=0;i<7;i++){
			for(int j=0;j<7;j++){
				int toInsert = 0;
				if(i==j){
					toInsert = 1;
				}
				redundWeightActions.append("S o.redund_weight.set("+(1+j+i*14+rob2*105-1)+","+toInsert+"); ");
			}
			redundWeightActions.append(newLine);
		}
		
		int i=actionNumber;
		for(int k=0;k<6;k++){

			int dirDefined = -1;

			if( stateList.get(i).getDirection().getMotionDir().equals(dirs[k]) ){
				dirDefined = 100;
			} else {
				for(int j=0;j<stateList.get(i).getNumberOfConstraints();j++){
					if( stateList.get(i).getConstraint(j).getMotionDir().equals(dirs[k]) ){
						dirDefined = j;
					}
				}
			}

			if(dirDefined<0){
				refActions.append("S o.refs.set("+(25+k+12*rob2-1)+" , 0); // zero velocity, "+ft.get(0).getFrame()+"-"+ft.get(0).getTool()+"-"+dirs[k]+newLine);
				if( k<3 ){
					ctrlparActions.append("S o.ctrlpar.set("+(1+10*(k+12*rob2)-1)+" , "+(k+1)+");  S o.ctrlpar.set("+(2+10*(k+12*rob2)-1)+" , 2);  S o.ctrlpar.set("+(3+10*(k+12*rob2)-1)+" , 1);  S o.ctrlpar.set("+(4+10*(k+12*rob2)-1)+" , 0);  S o.ctrlpar.set("+(5+10*(k+12*rob2)-1)+" , 0);  S o.ctrlpar.set("+(6+10*(k+12*rob2)-1)+" , 0.004);  S o.ctrlpar.set("+(7+10*(k+12*rob2)-1)+" , 10);  //"+ft.get(0).getFrame()+"-"+ft.get(0).getTool()+"-"+dirs[k]+newLine);
				} else {
					ctrlparActions.append("S o.ctrlpar.set("+(1+10*(k+12*rob2)-1)+" , "+(k+1)+");  S o.ctrlpar.set("+(2+10*(k+12*rob2)-1)+" , 2);  S o.ctrlpar.set("+(3+10*(k+12*rob2)-1)+" , 1);  S o.ctrlpar.set("+(4+10*(k+12*rob2)-1)+" , 0);  S o.ctrlpar.set("+(5+10*(k+12*rob2)-1)+" , 0);  S o.ctrlpar.set("+(6+10*(k+12*rob2)-1)+" , 0.004);  S o.ctrlpar.set("+(7+10*(k+12*rob2)-1)+" , 0.1);  //"+ft.get(0).getFrame()+"-"+ft.get(0).getTool()+"-"+dirs[k]+newLine);
				}
				for(int j=0;j<12;j++){
					int toInsert=0;
					if(j==k){
						toInsert = 1;
					}
					cfActions.append("S o.Cf.set("+(12*k+j+1+72*rob2-1)+","+toInsert+"); ");
				}
				cfActions.append(newLine);
			} else if(dirDefined==100){
				String stateTool = stateList.get(i).getTool();
				String stateFrame = stateList.get(i).getDirection().getFrame();
				int ftToUse = -1;
				for(int j=0;j<ft.size();j++){
					if(stateTool.equals(ft.get(j).getTool()) && stateFrame.equals(ft.get(j).getFrame()) ){
						ftToUse = j;
					}
				}
				double searchVelocity = 0.0;
				if(k<3){
					if( stateList.get(i).getDirection().getUnit().equals("mm/s") ){
						searchVelocity = stateList.get(i).getDirection().getSearchVelocity();
					} else if( stateList.get(i).getDirection().getUnit().equals("m/s") ){
						searchVelocity = stateList.get(i).getDirection().getSearchVelocity()*1000;
					} else {
						System.out.println("The following unit is not supported: "+stateList.get(i).getDirection().getUnit());
						System.exit(1);
					}
					refActions.append("S o.refs.set("+(25+k+ftToUse*6+12*rob2-1)+" , "+searchVelocity+"); // search velocity (mm/s), "+stateFrame+"-"+stateTool+"-"+dirs[k]+newLine);
				} else {
					if( stateList.get(i).getDirection().getUnit().equals("rad/s") ){
						searchVelocity = stateList.get(i).getDirection().getSearchVelocity();
					} else if( stateList.get(i).getDirection().getUnit().equals("deg/s") || stateList.get(i).getDirection().getUnit().equals("degrees/s") ){
						searchVelocity = stateList.get(i).getDirection().getSearchVelocity()*Math.PI/180;
					} else {
						System.out.println("The following unit is not supported: "+stateList.get(i).getDirection().getUnit());
						System.exit(1);
					}
					refActions.append("S o.refs.set("+(25+k+ftToUse*6+12*rob2-1)+" , "+searchVelocity+"); // search velocity (rad/s), "+stateFrame+"-"+stateTool+"-"+dirs[k]+newLine);
				}
				ctrlparActions.append("S o.ctrlpar.set("+(1+10*((k+12*rob2)+ftToUse*6)-1)+" , "+(k+1)+");  S o.ctrlpar.set("+(2+10*((k+12*rob2)+ftToUse*6)-1)+" , 2);  S o.ctrlpar.set("+(3+10*((k+12*rob2)+ftToUse*6)-1)+" , 1);  S o.ctrlpar.set("+(4+10*((k+12*rob2)+ftToUse*6)-1)+" , 0);  S o.ctrlpar.set("+(5+10*((k+12*rob2)+ftToUse*6)-1)+" , 0);  S o.ctrlpar.set("+(6+10*((k+12*rob2)+ftToUse*6)-1)+" , 0.004);  S o.ctrlpar.set("+(7+10*((k+12*rob2)+ftToUse*6)-1)+" , "+Math.abs(searchVelocity*1.5)+");  //"+ft.get(0).getFrame()+"-"+ft.get(0).getTool()+"-"+dirs[k]+newLine);

				for(int j=0;j<12;j++){
					int toInsert=0;
					if(j==(k+ftToUse*6)){
						toInsert = 1;
					}
					cfActions.append("S o.Cf.set("+(12*k+j+1+72*rob2-1)+","+toInsert+"); ");
				}
				cfActions.append(newLine);
			} else {
				String stateTool = stateList.get(i).getTool();
				String stateFrame = stateList.get(i).getConstraint(dirDefined).getFrame();
				int ftToUse = -1;
				for(int j=0;j<ft.size();j++){
					if(stateTool.equals(ft.get(j).getTool()) && stateFrame.equals(ft.get(j).getFrame()) ){
						ftToUse = j;
					}
				}
				double forceRef = 0.0;
				if(k<3){
					if( stateList.get(i).getConstraint(dirDefined).getUnit().equals("N") ){
						forceRef = stateList.get(i).getConstraint(dirDefined).getReference();
					} else if( stateList.get(i).getConstraint(dirDefined).getUnit().equals("mN") ){
						forceRef = stateList.get(i).getConstraint(dirDefined).getReference()*0.001;
					} else {
						System.out.println("The following unit is not supported: "+stateList.get(i).getConstraint(dirDefined).getUnit());
						System.exit(1);
					}
					refActions.append("S o.refs.set("+(25+k+ftToUse*6+12*rob2-1)+", "+forceRef+"); // force control (N), "+stateFrame+"-"+stateTool+"-"+dirs[k]+newLine);
				} else {
					if( stateList.get(i).getConstraint(dirDefined).getUnit().equals("Nmm") || stateList.get(i).getConstraint(dirDefined).getUnit().equals("mNm")){
						forceRef = stateList.get(i).getConstraint(dirDefined).getReference();
					} else if( stateList.get(i).getConstraint(dirDefined).getUnit().equals("Nm") ){
						forceRef = stateList.get(i).getConstraint(dirDefined).getReference()*1000;
					} else {
						System.out.println("The following unit is not supported: "+stateList.get(i).getConstraint(dirDefined).getUnit());
						System.exit(1);
					}
					refActions.append("S o.refs.set("+(25+k+ftToUse*6+12*rob2-1)+" , "+forceRef+"); // torque control (Nmm), "+stateFrame+"-"+stateTool+"-"+dirs[k]+newLine);	
				}
				String cId = stateList.get(i).getConstraint(dirDefined).getControllerId();
				int cNumber = -1;
				for(int n=0;n<controllerList.size();n++){
					if(controllerList.get(n).getName().equals(cId)){
						cNumber = n;
						break;
					}
				}
				double M = controllerList.get(cNumber).getM();
				double D = controllerList.get(cNumber).getD();
				double maxVel = 20;
				if( k>=3 ){
					maxVel = 0.1;
				}
				ctrlparActions.append("S o.ctrlpar.set("+(1+10*((k+12*rob2)+ftToUse*6)-1)+" , "+(k+1)+");  S o.ctrlpar.set("+(2+10*((k+12*rob2)+ftToUse*6)-1)+" , 1);  S o.ctrlpar.set("+(3+10*((k+12*rob2)+ftToUse*6)-1)+" , 1);  S o.ctrlpar.set("+(4+10*((k+12*rob2)+ftToUse*6)-1)+" , "+M+");  S o.ctrlpar.set("+(5+10*((k+12*rob2)+ftToUse*6)-1)+" , "+D+");  S o.ctrlpar.set("+(6+10*((k+12*rob2)+ftToUse*6)-1)+" , 0.004);  S o.ctrlpar.set("+(7+10*((k+12*rob2)+ftToUse*6)-1)+" , "+maxVel+");  //"+ft.get(0).getFrame()+"-"+ft.get(0).getTool()+"-"+dirs[k]+newLine);

				for(int j=0;j<12;j++){
					int toInsert=0;
					if(j==(k+ftToUse*6)){
						toInsert = 1;
					}
					cfActions.append("S o.Cf.set("+(12*k+j+1+72*rob2-1)+","+toInsert+"); ");
				}
				cfActions.append(newLine);
			}
		}
		String returnString = refActions.toString()+newLine+ctrlparActions.toString()+newLine+cfActions.toString()+newLine+redundWeightActions.toString()+newLine+"//S o.state1 = "+stateNumber+";";
		
		return returnString;
	}

	public String exitStateAction(int stateNumber, String newLine, RobotType rob){
		int robotNumber = 1;
		if( rob == RobotType.FridaLeftArm ){
			robotNumber = 2;
		}
		StringBuilder exitStateActions = new StringBuilder();
		exitStateActions.append("//signal that skill is finished"+newLine);
		//exitStateActions.append("S o.skillFinished"+robotNumber+" = 1;"+newLine+newLine);
		exitStateActions.append("//S o.state1 = "+stateNumber+";"+newLine+newLine);
		for(int i=1;i<=60;i++){
			exitStateActions.append("S o.chains.set("+(i+(robotNumber-1)*60-1)+",0);    S o.chains_params.set("+(i+(robotNumber-1)*60-1)+",0);"+newLine);
		}
		return exitStateActions.toString();

	}

	public String enterStateAction(int stateNumber, String newLine, RobotType rob){
		int rob2 = 0;
		if( rob == RobotType.FridaLeftArm ){
			rob2 = 1;
		}

		StringBuilder defineKinChains = new StringBuilder();
		defineKinChains.append("//define chains and constant params"+newLine);
		
		for(int j=0;j<ft.size();j++){
			int frameNumber = -1;
			int toolNumber = -1;
			for(int i=0;i<frameList.size();i++){
				if( frameList.get(i).getName().equals(ft.get(j).getFrame()) ){
					frameNumber = i;
				}
			}
			for(int i=0;i<toolList.size();i++){
				if( toolList.get(i).getName().equals(ft.get(j).getTool()) ){
					toolNumber = i;
				}
			}
			//System.out.println("Frame: "+frameNumber+"   Tool: "+toolNumber);		

			int start = 1+j*30+60*rob2-1;
			
			double[] frameOrigin = frameList.get(frameNumber).getOrigin();
			defineKinChains.append("S o.chains.set("+start+",11);    S o.chains_params.set("+start+","+frameOrigin[0]+");"+newLine);
			defineKinChains.append("S o.chains.set("+(start+1)+",12);    S o.chains_params.set("+(start+1)+" , "+frameOrigin[1]+");"+newLine);
			defineKinChains.append("S o.chains.set("+(start+2)+",13);    S o.chains_params.set("+(start+2)+" , "+frameOrigin[2]+");"+newLine);
			double[] frameEulerAngles = frameList.get(frameNumber).getYZXEulerAngles();
			defineKinChains.append("S o.chains.set("+(start+3)+" ,15);    S o.chains_params.set("+(start+3)+" , "+frameEulerAngles[0]+");"+newLine);
			defineKinChains.append("S o.chains.set("+(start+4)+" , 16);    S o.chains_params.set("+(start+4)+" , "+frameEulerAngles[1]+");"+newLine);
			defineKinChains.append("S o.chains.set("+(start+5)+" , 14);    S o.chains_params.set("+(start+5)+" , "+frameEulerAngles[2]+");"+newLine);
			defineKinChains.append("S o.chains.set("+(start+6)+" , 1);     S o.chains_params.set("+(start+6)+" , 0);"+newLine);
			defineKinChains.append("S o.chains.set("+(start+7)+" , 2);     S o.chains_params.set("+(start+7)+" , 0);"+newLine);
			defineKinChains.append("S o.chains.set("+(start+8)+" , 3);     S o.chains_params.set("+(start+8)+" , 0);"+newLine);
			defineKinChains.append("S o.chains.set("+(start+9)+" , 44);   S o.chains_params.set("+(start+9)+" , 0);"+newLine);
			defineKinChains.append("S o.chains.set("+(start+10)+" , 45);   S o.chains_params.set("+(start+10)+" , 0);"+newLine);
			defineKinChains.append("S o.chains.set("+(start+11)+" , 46);   S o.chains_params.set("+(start+11)+" , 0);"+newLine);
			double[] toolEulerAngles = toolList.get(toolNumber).getInvYZXEulerAngles();
			defineKinChains.append("S o.chains.set("+(start+12)+" , 15);   S o.chains_params.set("+(start+12)+" , "+toolEulerAngles[0]+");"+newLine);
			defineKinChains.append("S o.chains.set("+(start+13)+" , 16);   S o.chains_params.set("+(start+13)+" , "+toolEulerAngles[1]+");"+newLine);
			defineKinChains.append("S o.chains.set("+(start+14)+" , 14);   S o.chains_params.set("+(start+14)+" , "+toolEulerAngles[2]+");"+newLine);
			double[] toolTrans = toolList.get(toolNumber).getTrans();
			defineKinChains.append("S o.chains.set("+(start+15)+" , 11);   S o.chains_params.set("+(start+15)+" , "+(-toolTrans[0])+");"+newLine);
			defineKinChains.append("S o.chains.set("+(start+16)+" , 12);   S o.chains_params.set("+(start+16)+" , "+(-toolTrans[1])+");"+newLine);
			defineKinChains.append("S o.chains.set("+(start+17)+" , 13);   S o.chains_params.set("+(start+17)+" , "+(-toolTrans[2])+");"+newLine);
			defineKinChains.append("S o.chains.set("+(start+18)+" , -3"+(1+rob2)+");  S o.chains_params.set("+(start+18)+" , 0);"+newLine);
			for(int i=19;i<=29;i++){
				defineKinChains.append("S o.chains.set("+(start+i)+" , 0);    S o.chains_params.set("+(start+i)+" , 0);"+newLine);
			}
		}
		if(ft.size()==1){
			for(int i=(31+rob2*60);i<=(60+rob2*60);i++){
				defineKinChains.append("S o.chains.set("+(i-1)+",0);    S o.chains_params.set("+(i-1)+", 0);"+newLine);
			}			
		}
		//defineKinChains.append(newLine+"S o.state1 = "+stateNumber+";");

		return defineKinChains.toString();

	}

	public void readXMLFile2(File fXmlFile) {
 
    		try {
 
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
 		
			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();
 	
	
			Element rootElement = doc.getDocumentElement();
			NodeList nodes = rootElement.getChildNodes();
		 
			
 	
			for (int temp = 0; temp < nodes.getLength(); temp++) {
		 
				Node node = nodes.item(temp);
				if( node instanceof Element ){
					if( node.getNodeName().equals("Action") ){
						ArrayList<State> s = handleActionNode(node);
						stateList.addAll(s);
						}
						else if( node.getNodeName().equals("ErrorStep") ){
							System.out.println("Found error step");
									ArrayList<State> e_handling = handleErrorNode(node);
									errorstateList.addAll(e_handling);
								
						
					} else if( node.getNodeName().equals("Frame") ){
						Frame f = handleFrameNode(node);
						frameList.add(f);
						double[] d = f.getYZXEulerAngles();
					} else if( node.getNodeName().equals("ImpedanceControlParams") ){
						ImpedanceController i = handleImpedanceControllerNode(node);
						controllerList.add(i);
					} else if( node.getNodeName().equals("ToolTransform") ){
						ToolTransform t = handleToolTransformNode(node);
						toolList.add(t);	
					}
				}
 	
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static  RobotType getRobotType(String arg){
	if(arg.compareToIgnoreCase("IRB120")==0){
		return RobotType.IRB120;
	} else if(arg.compareToIgnoreCase("IRB140")==0){
		return  RobotType.IRB140;
	} else if(arg.compareToIgnoreCase("FridaLeft")==0){
		return RobotType.FridaLeftArm;
	} else if(arg.compareToIgnoreCase("FridaRight")==0){
		return RobotType.FridaRightArm;
	}
	return null;
	}
	
	public static ArrayList<State> handleActionNode(Node actionNode){

		ArrayList<State> s = new ArrayList<State>();
		String stateName = ((Element)actionNode).getAttribute("id");
		String tool = ((Element)actionNode).getAttribute("tool");
		String jump = ((Element)actionNode).getAttribute("jump_to");

		State state = new State(stateName,tool, jump);
		s.add(state);
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
				state.addConstraint(c);
			} else if( node.getNodeName().equals("Direction") ){
				Element directionElement = (Element) node;
				double searchVelocity = Double.parseDouble(directionElement.getElementsByTagName("searchVelocity").item(0).getTextContent());
				String unit = ((Element)directionElement.getElementsByTagName("searchVelocity").item(0)).getAttribute("unit");
				String motionFrame = directionElement.getElementsByTagName("motionframe").item(0).getTextContent();
				String motionDir = directionElement.getElementsByTagName("motiondir").item(0).getTextContent();
				//double threshold = Double.parseDouble(directionElement.getElementsByTagName("threshold").item(0).getTextContent());
				//String thresholdUnit = ((Element)directionElement.getElementsByTagName("threshold").item(0)).getAttribute("unit");
				NodeList bounce_e = directionElement.getElementsByTagName("bounce");
				if(bounce_e.getLength() > 0){
				String bounce_string = bounce_e.item(0).getTextContent();
				double bounce = 0;
					bounce = Double.parseDouble(bounce_string);
					Direction d = new Direction(motionFrame,motionDir,searchVelocity,unit, bounce);
					state.setDirection(d);
					BounceState bounceState = new BounceState(stateName+ "bounce",tool, null);
					bounceState.setDirection(d);
					s.add(bounceState);
				}else{
				Direction d = new Direction(motionFrame,motionDir,searchVelocity,unit);
				state.setDirection(d);
				}
			} 
			else if(node.getNodeName().equals("Final")){
				Element constraintElement = (Element) node;
				String type = constraintElement.getElementsByTagName("type").item(0).getTextContent();
				
				String motionFrame = constraintElement.getElementsByTagName("motionframe").item(0).getTextContent();
				String motionDir = constraintElement.getElementsByTagName("motiondir").item(0).getTextContent();
				double threshold = Double.parseDouble(constraintElement.getElementsByTagName("threshold").item(0).getTextContent());
				String thresholdUnit = ((Element)constraintElement.getElementsByTagName("threshold").item(0)).getAttribute("unit");

				FinalConstraint d = new FinalConstraint(type, motionFrame,motionDir,threshold,thresholdUnit);
				state.setFinalConstraint(d);
				
			}
			else if(node.getNodeName().equals("Error")){
				Element constraintElement = (Element) node;
				String type = constraintElement.getElementsByTagName("type").item(0).getTextContent();
				
				String motionFrame = constraintElement.getElementsByTagName("motionframe").item(0).getTextContent();
				String motionDir = constraintElement.getElementsByTagName("motiondir").item(0).getTextContent();
				double threshold = Double.parseDouble(constraintElement.getElementsByTagName("threshold").item(0).getTextContent());
				String thresholdUnit = ((Element)constraintElement.getElementsByTagName("threshold").item(0)).getAttribute("unit");
				String error_handling = constraintElement.getElementsByTagName("handling").item(0).getTextContent();
				
				ErrorConstraint d = new ErrorConstraint(type, motionFrame,motionDir,threshold,thresholdUnit, error_handling);
				state.setErrorConstraint(d);
				
			}
		} 
		return s;
	}

	public static Frame handleFrameNode(Node frameNode){
		
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

	public static ImpedanceController handleImpedanceControllerNode(Node impNode){
		
		Element impElement = (Element) impNode;

		String impName = impElement.getAttribute("id");

		double M = Double.parseDouble(impElement.getElementsByTagName("M").item(0).getTextContent());
		double D = Double.parseDouble(impElement.getElementsByTagName("D").item(0).getTextContent());

		ImpedanceController i = new ImpedanceController(impName,M,D);

		return i;		
	}

	public static ToolTransform handleToolTransformNode(Node toolNode){
		
		Element toolElement = (Element) toolNode;

		String toolName = toolElement.getAttribute("id");

		String trans = toolElement.getElementsByTagName("trans").item(0).getTextContent();
		double[] transCoords = new double[3];		
		int start = trans.indexOf("[");
		int stop = trans.indexOf(",",start+1);
		transCoords[0] = Double.parseDouble(trans.substring(start+1,stop));
		start = stop;
		stop = trans.indexOf(",",start+1);
		transCoords[1] = Double.parseDouble(trans.substring(start+1,stop));
		start = stop;
		stop = trans.indexOf("]",start+1);
		transCoords[2] = Double.parseDouble(trans.substring(start+1,stop));


		String quaternion = toolElement.getElementsByTagName("quaternion").item(0).getTextContent();
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

		ToolTransform t = new ToolTransform(toolName,transCoords,quatCoords);

		return t;		
	}


}

class ReadWriteTextFile {

  /**
  * Fetch the entire contents of a text file, and return it in a String.
  * This style of implementation does not throw Exceptions to the caller.
  *
  * @param aFile is a file which already exists and can be read.
  */
  public String getContents(File aFile) {
    //...checks on aFile are elided
    StringBuilder contents = new StringBuilder();
    
    try {
      //use buffering, reading one line at a time
      //FileReader always assumes default encoding is OK!
      BufferedReader input =  new BufferedReader(new FileReader(aFile));
      try {
        String line = null; //not declared within while loop
        /*
        * readLine is a bit quirky :
        * it returns the content of a line MINUS the newline.
        * it returns null only for the END of the stream.
        * it returns an empty String if two newlines appear in a row.
        */
        while (( line = input.readLine()) != null){
          contents.append(line);
          //contents.append("#");
          contents.append(System.getProperty("line.separator"));
        }
      }
      finally {
        input.close();
      }
    }
    catch (IOException ex){
      ex.printStackTrace();
    }
    
    return contents.toString();
  }

  /**
  * Change the contents of text file in its entirety, overwriting any
  * existing text.
  *
  * This style of implementation throws all exceptions to the caller.
  *
  * @param aFile is an existing file which can be written to.
  * @throws IllegalArgumentException if param does not comply.
  * @throws FileNotFoundException if the file does not exist.
  * @throws IOException if problem encountered during write.
  */
  public void setContents(File aFile, String aContents)
                                 throws FileNotFoundException, IOException {
    if (aFile == null) {
      throw new IllegalArgumentException("File should not be null.");
    }
    if (!aFile.exists()) {
      throw new FileNotFoundException ("File does not exist: " + aFile);
    }
    if (!aFile.isFile()) {
      throw new IllegalArgumentException("Should not be a directory: " + aFile);
    }
    if (!aFile.canWrite()) {
      throw new IllegalArgumentException("File cannot be written: " + aFile);
    }

    //use buffering
    Writer output = new BufferedWriter(new FileWriter(aFile));
    try {
      //FileWriter always assumes default encoding is OK!
      output.write( aContents );
    }
    finally {
      output.close();
    }
  }
} 



class JGrafchartElement {

private String type;

public JGrafchartElement(String t){
  type = t;
}

public String getType(){
  return type;
}

protected void setType(String type){
	this.type = type;
}

}

class Link extends JGrafchartElement {

private JGrafchartElement fromObject;
private JGrafchartElement toObject;

public Link(JGrafchartElement fromObject, JGrafchartElement toObject){
	super("Link");
	this.fromObject = fromObject;
	this.toObject = toObject;
}

public JGrafchartElement getFromObject(){
	return fromObject;
}

public JGrafchartElement getToObject(){
	return toObject;
}

}

class StepTrans extends JGrafchartElement {

private int x;
private int y;
private int width;
private int height;
private String actionText;
private String id;

public StepTrans(String type, int x, int y, int width, int height, String actionText, String id){
	super(type);
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	this.actionText = actionText;
	this.id = id;
}

public int getX(){
	return x;
}

public int getY(){
	return y;
}

public int getWidth(){
	return width;
}

public int getHeight(){
	return height;
}	

public String getActionText(){
	return actionText;
}

public String getId(){
	return id;
}

}

class Step extends StepTrans{

private String name;

public Step(int x, int y, int width, int height, String actionText, String id, String name){
	super("Step", x, y, width, height, actionText, id);
	this.name = name;
}

public String getName(){
	return name;
}

}

class EnterStep extends Step{

public EnterStep(int x, int y, int width, int height, String actionText, String id, String name){
	super(x, y, width, height, actionText, id, name);
	super.setType("EnterStep");
}

}

class ExitStep extends Step{

public ExitStep(int x, int y, int width, int height, String actionText, String id, String name){
	super(x, y, width, height, actionText, id, name);
	super.setType("ExitStep");
}

}

class Transition extends StepTrans{

public Transition(String type, int x, int y, int width, int height, String actionText, String id){
	super("Transition", x, y, width, height, actionText, id);
}

}

class XMLconstants{
public String xmlStart;
public String xmlEnd;
}














enum RobotType {
    IRB140, IRB120, FridaLeftArm, FridaRightArm 
}
