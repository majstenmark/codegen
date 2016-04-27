package testgraphics;

import statemachine.*;
import statemachine.SmConditionElement.Type;

import java.util.ArrayList;

import GraphElements.jgcGraph;
import devices.*;
import jgrafchart.LabCommConnection;


public class SmTestB {

	public static void main(String[] args ){
		StateMachine sm = new StateMachine();
		
		SmState state1 = new SmState();
		
		SmState state2 = new SmState();
		SmState state3 = new SmState();
		SmState state4 = new SmState();
		SmState state5 = new SmState();
		SmState state6 = new SmState();

		SmTransition t01 = new SmTransition();
		SmTransition t12 = new SmTransition();
		SmTransition t13 = new SmTransition();
		SmTransition t24 = new SmTransition();
		SmTransition t35 = new SmTransition();
		SmTransition t46 = new SmTransition();
		SmTransition t56 = new SmTransition();
		sm.addConnection(state1, t12, state2);

		sm.addConnection(state1, t13, state3);
		sm.addConnection(state2, t24, state4);
		sm.addConnection(state4, t46, state6);
		sm.addConnection(state3, t35, state5);

		sm.addConnection(state5, t56, state6);
			sm.setInitialState(state1);
		
		jgcGraph g = new jgcGraph(sm);
		g.generateJgcCode("test1aug.xml");
		System.out.println(sm.toString());
		
		
		
	}
}
