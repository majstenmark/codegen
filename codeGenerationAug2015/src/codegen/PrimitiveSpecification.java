package codegen;

import java.util.ArrayList;
import java.util.List;

import statemachine.SmState;
import statemachine.SmTransition;

public class PrimitiveSpecification extends Specification {
	private String functionCall;
	private ArrayList<Parameter> params = new ArrayList<Parameter>();
	private String name;
	private SmState state;
	private SmTransition transition;
	
	public PrimitiveSpecification(String name, String call){
		super();
		functionCall = call;
		this.name = name;
	}
	
	public void addParam(Parameter p){
		params.add(p);
		
	}
	public SmState getStartState(){
		if(state == null){
			state = new SmState(name);
			state.setAction(Communication.getFunctionCall(toString()));
		}		
		return state;

	}
	public SmTransition getEndTransition(){
		if(state == null) getStartState();
		if(transition == null){
			transition = new SmTransition(Communication.getFunctionCallAck());
			
		}
		return transition;
	}
	
	
	public String toString(){
		String s = "";
		s+=  functionCall;
		if(params.size() > 0) s +=  " ";
		for(Parameter p: params){
			if(!p.equals(params.get(0))){
				s+= ",";
			}
			s += p.toString();
			
		}
		return s;
		
	}
}
