package testgraphics;

import statemachine.*;
import statemachine.SmConditionElement.Type;

import java.util.ArrayList;

import GraphElements.jgcGraph;
import devices.*;
import jgrafchart.LabCommConnection;


public class SmTestC {

	public static void main(String[] args ){
		StateMachine sm = new StateMachine();
		
		SmState state1 = new SmState("1");
		
		SmState state2 = new SmState("2");
		SmState state3 = new SmState("3");
		SmState state4 = new SmState("4");
		SmState state5 = new SmState("5");
		SmState state6 = new SmState("6");
		SmState state7 = new SmState("7");
		SmState state8 = new SmState("8");

		SmTransition t12 = new SmTransition();
		SmTransition t13 = new SmTransition();
		SmTransition t24 = new SmTransition();
		SmTransition t34 = new SmTransition();
		SmTransition t45 = new SmTransition();
		SmTransition t46 = new SmTransition();

		SmTransition t47 = new SmTransition();
		SmTransition t58 = new SmTransition();
		SmTransition t68 = new SmTransition();
		SmTransition t78 = new SmTransition();
		sm.addConnection(state1, t12, state2);

		sm.addConnection(state1, t13, state3);
		sm.addConnection(state2, t24, state4);
		sm.addConnection(state4, t46, state6);
		sm.addConnection(state3, t34, state4);
		sm.addConnection(state4, t45, state5);
		sm.addConnection(state4, t47, state7);
		sm.addConnection(state5, t58, state8);
		sm.addConnection(state6, t68, state8);
		sm.addConnection(state7, t78, state8);

			sm.setInitialState(state1);
		
		jgcGraph g = new jgcGraph(sm);
		g.generateJgcCode("test1aug.xml");
		System.out.println(sm.toString());
		
		
		
	}
}
