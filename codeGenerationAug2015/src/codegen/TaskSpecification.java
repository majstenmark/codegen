package codegen;

import java.util.ArrayList;
import java.util.List;

import jgrafchart.LabCommConnection;
import statemachine.SmElement;
import statemachine.SmState;
import statemachine.SmTransition;
import statemachine.StateMachine;

public class TaskSpecification {
	private String ip, port, name;
	RobotType robotType;
	private ArrayList<Specification> sequence = new ArrayList<Specification>();
	
	public TaskSpecification(RobotType type, String name, String ip, String port){
		this.robotType = type;
		this.ip = ip;
		this.name = name;
		this.port = port;
		
	}
	
	public void addSkill(Specification skill){
		sequence.add(skill);
		
	}
	
	public String toString(){
		
		String str = "";
		for(Specification s: sequence){
			str += s.toString() + "\n";
			
		}
		
		return str;
		
	}
	
	public String ip(){
		return ip;
	}
	
	public String port(){
		return port;
	}
	
	public String taskName(){
		return this.name;
	}
	
	public Specification[] sequence(){
		return sequence.toArray(new Specification[sequence.size()]);
		
	}
	
	public StateMachine createStateMachine(){
		ArrayList<LabCommConnection> lc = new ArrayList<>();
		lc.add(Communication.getRobotConnection());
		StateMachine sm = new StateMachine(lc);
		SmState initalState = new SmState("Initial state");
		sm.setInitialState(initalState);
		SmState currState = initalState;
		SmTransition transition = new SmTransition();
		for(Specification s: sequence){
			SmState startState = s.getStartState();
			sm.addConnection(currState, transition, startState);
			transition = s.getEndTransition();
			currState = startState;
			
		}
		return sm;
	}

}
