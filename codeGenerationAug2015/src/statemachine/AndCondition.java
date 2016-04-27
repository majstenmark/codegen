package statemachine;

import statemachine.SmConditionElement.Type;
import devices.Sensor;
import devices.Unit;
import devices.VectorUnit;

public class AndCondition extends SmConditionElement{
	public SmCondition c1, c2;
	
	public AndCondition(SmCondition c1, SmCondition c2){
		type = Type.AND;
		this.c1 = c1;
		this.c2 = c2;
	}
	
}
