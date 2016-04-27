package statemachine;
import java.util.*;
import java.util.stream.Collectors;

import GraphElements.Positions;

public class SmState extends SmElement{
	protected HashSet<SmTransition> incomingTransitions = new HashSet<>();
	
	protected HashSet<SmTransition> exitTransitions = new HashSet<>();
	protected boolean isInitial = false;
	private String action = "";
	private String name = "";
	
	
	public SmState(){
		super();
	}
	

	public SmState(String n){
		super();
		name = n;
	}
	
	public SmState(SmState other){
		super();
		incomingTransitions = other.incomingTransitions;
		exitTransitions = other.exitTransitions;
		isInitial = other.isInitial;
	}
	
	public void addIncomingTransition(SmTransition t){
		if(!incomingTransitions.contains(t)){
		incomingTransitions.add(t);
		t.addOutgoingState(this);
		}
		
	}
	
	public void setAction(String n){
		action = n;
	}
	
	public String getAction(){
		return action;
	}
	public String getName(){
		return name;
	}
	

	protected int getDistanceFromParentX(){
		return - Positions.STATEDISTX;
	}
	protected int getDistanceFromParentY(){
		return Positions.DISTSTATETRANS;
	}
	
	public HashSet<SmTransition> getIncomingTransitions(){
		return incomingTransitions;
	}

	public HashSet<SmTransition> getOutgoingTransitions(){
		return exitTransitions;
	}
	
	public HashSet<SmState> getPreviousStates(){
		HashSet<SmState> p = new HashSet<SmState>();
		incomingTransitions.stream().forEach(s -> p.addAll(s.incomingStates));
		return p;
	}
	
	public HashSet<SmState> getNextStates(){
		HashSet<SmState> p = new HashSet<SmState>();
		exitTransitions.stream().forEach(s -> p.addAll(s.outgoingStates));
		return p;
	}
	
	public void addOutgoingTransition(SmTransition t){
		if(!exitTransitions.contains(t)){
		exitTransitions.add(t);
		t.addIncomingState(this);
		}
	}
	
	public 	ArrayList<SmElement> getParents(){
		ArrayList<SmElement> d = new ArrayList<SmElement>();
		d.addAll(incomingTransitions.stream().filter(s -> s.getDistance() < getDistance()).collect(Collectors.toList()));
		return d;
	}
	
	
	public void setInitial(boolean init){
		isInitial = init;
	}
	public boolean isInitial(){
		return isInitial;
	}
	
	public 	ArrayList<SmElement> next(){
		ArrayList<SmElement> d = new ArrayList<SmElement>();
		d.addAll(exitTransitions);
		return d;
	}
	/*
	public String printAll(){
		StringBuilder sb = new StringBuilder();
		for(SmTransition t: exitTransitions){
			sb.append("State " + toString() + " connects to Transition " + t.toString() + "\n");
		}
		for(SmTransition t: exitTransitions){
			sb.append(t.printAll());
		}
		return sb.toString();
	}*/
	

}
