package statemachine;
import devices.*;

public class SmCondition extends SmConditionElement{
	public Sensor sensor;
	Unit u;
	public double value;
	int index = 0;
	public Type type;
	
	public boolean booleanValue = false;
	
	
	
	public SmCondition(Sensor s, Unit u, double value, Type type){
		this.sensor = s;
		this.u = u;
		this.value = value;
		this.type = type;
	}
	
	public SmCondition(boolean b){
		booleanValue = true;
	}
	
	public SmCondition(Sensor s, VectorUnit u, double[] value, Type type){
		// fix
	}
	
	public SmCondition(Sensor s, VectorUnit u, double index, double value, Type type){
		// fix
	}
	
	
	
	public SmCondition(Sensor s, VectorUnit u, int index, double value){
		this.sensor = s;
		this.u = u;
		this.value = value;
		this.index = index;
		this.type = type;
	}
	
}
