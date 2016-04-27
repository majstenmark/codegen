package statemachine;

public class OrCondition extends SmConditionElement{
	public SmCondition c1, c2;
	
	public OrCondition(SmCondition c1, SmCondition c2){
		type = Type.OR;
		this.c1 = c1;
		this.c2 = c2;
	}
}
