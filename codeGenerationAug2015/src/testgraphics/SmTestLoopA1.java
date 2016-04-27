package testgraphics;

import statemachine.*;
import statemachine.SmConditionElement.Type;

import java.util.ArrayList;

import GraphElements.jgcGraph;
import devices.*;
import jgrafchart.LabCommConnection;


public class SmTestLoopA1 {

	public static void main(String[] args ){
		StateMachine sm = new StateMachine();
		

		SmState state1 = new SmState("1");
		
		SmTransition t11 = new SmTransition();


		sm.addConnection(state1, t11, state1);

			sm.setInitialState(state1);
		
		jgcGraph g = new jgcGraph(sm);
		g.generateJgcCode("test1aug.xml");
		System.out.println(sm.toString());
		
		
		
	}
}
