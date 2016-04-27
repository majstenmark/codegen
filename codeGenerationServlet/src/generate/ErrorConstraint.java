package generate;

class ErrorConstraint extends FinalConstraint{
	String handlingStateId = "";
	State handlingState = null;
	
	public ErrorConstraint(String type, String motionFrame, String motionDir, double threshold, String thresholdUnit, String handlingStep){
			super(type, motionFrame, motionDir, threshold, thresholdUnit);
		this.handlingStateId = handlingStep;
	}
	
	public String getStateId(){
		return handlingStateId;
		
	}
	
	public State getState(){
		return handlingState;
		
	}
	public void setState(State s){
		handlingState = s;
		
	}
	
}

