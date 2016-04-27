package codegen;

import java.util.List;

import statemachine.SmState;
import statemachine.SmTransition;

public class Specification{
	protected Controller controller = Controller.POSITION;
	
	public Controller getController(){
		return controller;
	}
	
	public SmState getStartState(){
		return null;
	}
	public SmTransition getEndTransition(){
		return null;
	}
	
	
}
