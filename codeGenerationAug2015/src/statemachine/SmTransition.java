package statemachine;

import java.util.*;
import java.util.stream.Collectors;

import GraphElements.Positions;

public class SmTransition extends SmElement{
	protected HashSet<SmState> incomingStates = new HashSet<>();
	protected HashSet<SmState> outgoingStates = new HashSet<>();
	protected ArrayList<SmConditionElement> conditions = new ArrayList<>();
	private String condition = "1"; 
	
	public SmTransition(){
		super();
	}
	
	
	public SmTransition(SmTransition other){
		super();
		incomingStates = other.incomingStates;
		outgoingStates = other.outgoingStates;
		conditions = other.conditions;
	}
	
	public SmTransition(String s){
		condition = s;
	}
	
	public void addIncomingState(SmState s){
		if(!incomingStates.contains(s)){
		incomingStates.add(s);
		s.addOutgoingTransition(this);
		}
	}
	
	public void addOutgoingState(SmState s){
		if(!outgoingStates.contains(s)){
		outgoingStates.add(s);
		s.addIncomingTransition(this);
		}
	}
	
	public 	ArrayList<SmElement> next(){
		ArrayList<SmElement> d = new ArrayList<SmElement>();
		
		d.addAll(outgoingStates);
		return d;
	}
	
	public ArrayList<SmConditionElement>  getConditions(){
		return conditions;
	}
	
	public void addCondition(SmConditionElement c){
		conditions.add(c);
	}
	
	public HashSet<SmState> getIncomingStates(){
		return incomingStates;
	}
	
	public HashSet<SmState> getOutgoingStates(){
		return outgoingStates;
	}
	
	public String getConditionString(){
		return condition;
	}

	protected int getDistanceFromParentX(){
		return Positions.STATEDISTX;
	}
	protected int getDistanceFromParentY(){
		return Positions.STATEDISTY;
	}
	
	public 	ArrayList<SmElement> getParents(){
		ArrayList<SmElement> d = new ArrayList<SmElement>();
		d.addAll(incomingStates.stream().filter(s -> s.getDistance() < getDistance()).collect(Collectors.toList()));
		return d;
	}
	/*
	public String printAll(){
		StringBuilder sb = new StringBuilder();
		for(SmState t: outgoingStates){
			sb.append("Transition " + toString() + " connects to State " + t.toString()+ "\n");
		}
		for(SmState t: outgoingStates){
			sb.append(t.printAll());
		}
		return sb.toString();
	}
	*/
}
