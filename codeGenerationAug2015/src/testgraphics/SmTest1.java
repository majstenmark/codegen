package testgraphics;

import statemachine.*;
import statemachine.SmConditionElement.Type;

import java.util.ArrayList;

import GraphElements.jgcGraph;
import devices.*;
import jgrafchart.LabCommConnection;


public class SmTest1 {

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
		SmState s1 = new SmState();
		SmState s11 = new SmState();
		SmState s12 = new SmState();
		SmTransition t11 = new SmTransition();
		SmCondition c11 = new SmCondition(forceRight, newton, 4, Type.GREATER);
		t11.addCondition(c11);
		
		StateMachine nested = new StateMachine();
		nested.setInitialState(s11);
		nested.addConnection(s11, t11, s12);

		SmNestedState nestedState = new SmNestedState(nested);
		
		SmTransition t1 = new SmTransition();
		SmTransition t2 = new SmTransition();
		SmCondition c1 = new SmCondition(forceRight, newton, 4, Type.GREATER);
		
		SmCondition c2 = new SmCondition(forceRight, newton, 3, Type.GREATEREQ);
		AndCondition and = new AndCondition(c1, c2);
		OrCondition or = new OrCondition(c1, c2);
		sm.addConnection(initialState,  t1, s1);
		sm.addConnection(s1, t2, nestedState);
		sm.setInitialState(initialState);
		t1.addCondition(and);
		t2.addCondition(or);
		
		jgcGraph g = new jgcGraph(sm);
		g.generateJgcCode("test1aug.xml");
		System.out.println(sm.toString());
		
		
		
	}
}
