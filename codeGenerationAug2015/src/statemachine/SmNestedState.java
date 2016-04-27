package statemachine;

import java.util.*;

import GraphElements.Positions;

public class SmNestedState extends SmState{
private StateMachine sm;
private SmState exit;
private SmState enter;

	public SmNestedState(StateMachine sm){
		super();
		this.sm = sm;
		
	}
	
	public StateMachine getStateMachine(){
		return sm;
	}
	
	public void setPosition(){
		super.setPosition();
		if(enter == null){
		enter = new SmState();
		sm.getInitialStates().stream().forEach(s -> connectToInitial(enter, s));
		exit = new SmState();
		SmTransition exitTransition = new SmTransition();
		SmState lastState = findLastState();
		sm.addConnection(lastState, exitTransition, exit);
		}
		sm.spreadOut();
		
	}
	
	public SmState getEnter(){
		if(enter == null || exit == null){
			enter = new SmState();
			sm.getInitialStates().stream().forEach(s -> connectToInitial(enter, s));
			exit = new SmState();
			SmTransition exitTransition = new SmTransition();
			SmState lastState = findLastState();
			sm.addConnection(lastState, exitTransition, exit);
			}
		return enter;
	}
	
	public SmState getExit(){
		if(enter == null || exit == null){
			enter = new SmState();
			sm.getInitialStates().stream().forEach(s -> connectToInitial(enter, s));
			exit = new SmState();
			SmTransition exitTransition = new SmTransition();
			SmState lastState = findLastState();
			sm.addConnection(lastState, exitTransition, exit);
			}
		return exit;
	}
	
	private void connectToInitial(SmState enter, SmState s){
		SmTransition t = new SmTransition();
		sm.addConnection(enter,  t, s);
	}
	
	private SmState findLastState(){
		sm.runBFS(enter);
		SmState last = null;
		for(SmState s: sm.getAllStates()){
			if(last == null || s.getDistance() > last.getDistance() ){
				last = s;
			}
		}
		return last;
	}
	
}
