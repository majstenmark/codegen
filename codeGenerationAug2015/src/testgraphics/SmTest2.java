package testgraphics;

import statemachine.*;
import statemachine.SmConditionElement.Type;

import java.util.ArrayList;

import GraphElements.jgcGraph;
import devices.*;
import jgrafchart.LabCommConnection;


public class SmTest2 {

	public static void main(String[] args ){
		LabCommConnection o = new LabCommConnection("o", "o.lc");

		LabCommConnection i = new LabCommConnection("i", "i.lc");
		Sensor forceRight = new ForceSensor("i.y_meas_extR.get(0)");
		Sensor forceLeft = new ForceSensor("i.y_meas_extR.get(1)");
		ArrayList<LabCommConnection> io = new ArrayList<LabCommConnection>();
		io.add(o);
		io.add(i);
		StateMachine sm = new StateMachine(io);
		Unit newton = new Unit("N");
		SmState initialState = new SmState();
		SmState state1 = new SmState();
		SmState stateLeft = new SmState();

		SmState stateMid = new SmState();
		SmState stateRight = new SmState();
		SmState last = new SmState();
		SmTransition is = new SmTransition();
		SmTransition im = new SmTransition();

		SmTransition ml = new SmTransition();
		SmTransition sl = new SmTransition();
		SmTransition sr = new SmTransition();
		SmTransition rl = new SmTransition();
		SmTransition ll = new SmTransition();
		sm.addConnection(initialState, is, state1);
		sm.addConnection(state1, im, stateMid);
		sm.addConnection(stateMid, ml, last);
		
		sm.addConnection(state1, sl, stateLeft);
		sm.addConnection(state1, sr, stateRight);
		sm.addConnection(stateLeft, ll, last);
		sm.addConnection(stateRight, rl, last);
			sm.setInitialState(initialState);
		
		jgcGraph g = new jgcGraph(sm);
		g.generateJgcCode("test1aug.xml");
		System.out.println(sm.toString());
		
		
		
	}
}
