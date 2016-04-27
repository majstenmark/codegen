package codegen;

import java.util.ArrayList;

import jgrafchart.LabCommConnection;

public class Communication {
	private final static String robotIp = "192.168.125.1";
	private final static int robotPort = 8888;
	
	private static LabCommConnection robot;
	public static String getNativeCondition(){
		return "1";
	}

	public static String getFunctionCall(String cmd){
		String s = "S robot.proc.command = \"" + cmd + "\";\n" + 
		"S robot.proc.status = 0;\n" +
		"S robot.proc.extCntr = 0;\n" + 
		"S lcSend(robot, \"proc\");\n";
		return s;
	}
	
	public static String getFunctionCallAck(){
		return "robot.proc.status == 1";
	}
	
	public static LabCommConnection getRobotConnection(){
		if(robot == null){
			LabCommConnection lc = new LabCommConnection("robot", "proc.lc");
			lc.setServer(robotIp);
			lc.setPort(robotPort);
			lc.setInput(true);
			lc.setOutput(true);
			robot = lc;
		}
		return robot;
	}
	
	public String transitionCondition(ArrayList<FinalConstraint> finalConstraints){
		throw new UnsupportedOperationException();
	}
	
	public String setUpKinematicChains(){
		throw new UnsupportedOperationException();
	}
	
	public String createLC(GuardedMotionSpecification g){
		throw new UnsupportedOperationException();
	}
}


