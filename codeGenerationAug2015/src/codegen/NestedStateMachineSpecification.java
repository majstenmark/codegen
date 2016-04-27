package codegen;

import java.util.ArrayList;

import statemachine.SmNestedState;
import statemachine.SmState;
import statemachine.SmTransition;
import statemachine.StateMachine;

public class NestedStateMachineSpecification extends Specification {
	private ArrayList<Specification> sequence = new ArrayList<>();
	private SmNestedState macroState; 
	private SmTransition lastTransition; 
	
	public NestedStateMachineSpecification(){
		super();
	}
	
	public void addSpecification(Specification s){
		sequence.add(s);
	}
	
	public SmState getStartState(){
		if(macroState == null){
		StateMachine nestedSm = new StateMachine();
		SmState first = null;
		SmTransition t = null;
		for(Specification s: sequence){
			SmState state = s.getStartState();
			SmTransition trans = s.getEndTransition();
			if(first != null){
				nestedSm.addConnection(first, t, state);
			}else{
				nestedSm.setInitialState(state);
			}
			first = state;
			t = trans;
		}
		nestedSm.addConnection(first, t);
		
		macroState = new SmNestedState(nestedSm);
		}
		return macroState;
	}
	public SmTransition getEndTransition(){
		if(lastTransition== null){
			lastTransition = new SmTransition();
		}
		return lastTransition;
	}
}
