package statemachine;

import java.util.*;

import jgrafchart.LabCommConnection;

public class StateMachine extends SmElement{
	ArrayList<SmState> initialStates = new ArrayList<>();
	//HashSet<SmElement> graph = new HashSet<SmElement>();
	private HashSet<SmState> allStates = new HashSet<SmState>();
	private HashSet<SmTransition> allTransitions = new HashSet<SmTransition>();

	private  List<LabCommConnection> io = new ArrayList<LabCommConnection>();
	
	public StateMachine(){
		super();
	}
	
	public StateMachine(List<LabCommConnection> io){
		super();
		this.io = io;
	}
	
	public HashSet<SmState> getAllStates(){
		return (HashSet<SmState>) allStates.clone();
	}
	
	public HashSet<SmTransition> getAllTransitions(){
		return (HashSet<SmTransition>) allTransitions.clone();
	}
	
	public List<LabCommConnection>  getIo(){
		return io;
	}
	
	public void setInitialState(SmState s){
		initialStates.add(s);
		allStates.add(s);
		s.setInitial(true);
	}
	

	public void spreadOut(){

		getInitialStates().stream().forEach(s -> runBFS(s));

		for(int i = 0; i < io.size(); i ++){
			io.get(i).setPosition(i);
		}

		getAllStates().forEach(s -> s.setPosition());
	
		getAllTransitions().forEach(s -> s.setPosition());

	}
	
	

	protected void runBFS(SmState init){
		init.setDistance(0);
		Queue<SmElement> q = new LinkedList<SmElement>();
		q.offer(init);
		while(!q.isEmpty()){
			SmElement currState = q.poll();
			ArrayList<SmElement> next = currState.next();
			if(next.size() > 0){
			for(SmElement ns : next){
				if(ns.getDistance() > currState.getDistance() + 1) {ns.setDistance(currState.getDistance() + 1);
				q.offer(ns);
				}
			}
			}
		}

	}
	
	public void addConnection(SmState s1, SmTransition t, SmState s2){
		s1.addOutgoingTransition(t);
		s2.addIncomingTransition(t);
		if(!allStates.contains(s1)){
			allStates.add(s1);
		}
		if(!allStates.contains(s2)){
			allStates.add(s2);
		}
		if(!allTransitions.contains(t)){
			allTransitions.add(t);
		}
	}
	
	public void addConnection(SmState s, SmTransition t){
		s.addOutgoingTransition(t);
		if(!allStates.contains(s)){
			allStates.add(s);
		}
		if(!allTransitions.contains(t)){
			allTransitions.add(t);
		}
	}

	public void addConnection(SmTransition t, SmState s){
		s.addIncomingTransition(t);
		if(!allStates.contains(s)){
			allStates.add(s);
		}
		if(!allTransitions.contains(t)){
			allTransitions.add(t);
		}
	}
	
	public ArrayList<SmState> getInitialStates(){
		return initialStates;
	}
	
	/*
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(SmState s: initialStates){
			sb.append("Init state " + s.toString() + "\n");
		}
		for(SmState s: initialStates){
			sb.append(s.printAll());
		}
		return sb.toString();
		
	}*/
	
}
