package testgraphics;

import statemachine.*;
import statemachine.SmConditionElement.Type;

import java.util.ArrayList;

import GraphElements.jgcGraph;
import devices.*;
import jgrafchart.LabCommConnection;


public class SmTestLoopA2 {

	public static void main(String[] args ){
		StateMachine sm = new StateMachine();
		

		SmState state1 = new SmState("1");
		
		SmState state2 = new SmState("2");

		SmTransition t12 = new SmTransition();
		SmTransition t11 = new SmTransition();
		sm.addConnection(state1, t12, state2);

		sm.addConnection(state1, t11, state1);

			sm.setInitialState(state1);
		
		jgcGraph g = new jgcGraph(sm);
		g.generateJgcCode("test1aug.xml");
		System.out.println(sm.toString());
		
		
		
	}
}
