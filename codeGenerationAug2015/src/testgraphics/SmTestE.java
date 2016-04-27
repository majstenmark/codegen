package testgraphics;

import statemachine.*;
import statemachine.SmConditionElement.Type;

import java.util.ArrayList;

import GraphElements.jgcGraph;
import devices.*;
import jgrafchart.LabCommConnection;


public class SmTestE {

	public static void main(String[] args ){
		StateMachine sm = new StateMachine();
		

		SmState state1 = new SmState("1");
		
		SmState state2 = new SmState("2");
		SmState state3 = new SmState("3");
		SmState state4 = new SmState("4");

		SmTransition t12 = new SmTransition();
		SmTransition t13 = new SmTransition();
		SmTransition t14 = new SmTransition();
		sm.addConnection(state1, t12, state2);

		sm.addConnection(state1, t13, state3);
		sm.addConnection(state1, t14, state4);

			sm.setInitialState(state1);
		
		jgcGraph g = new jgcGraph(sm);
		g.generateJgcCode("test1aug.xml");
		System.out.println(sm.toString());
		
		
		
	}
}
