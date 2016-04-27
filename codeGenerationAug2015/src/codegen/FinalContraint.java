package codegen;

class FinalConstraint{
	private Controller controllerType;
	private String motionFrame;
	private String motionDir;
	private double threshold;
	private String thresholdUnit;
	private boolean largerThan = true;

	public FinalConstraint(Controller controllerType, String motionFrame, String motionDir, double threshold, String thresholdUnit){
		this.controllerType = controllerType;
		this.motionFrame = motionFrame;
		this.motionDir = motionDir;
		this.threshold = threshold;
		this.thresholdUnit = thresholdUnit;

	}

	public String getFrame(){
		return motionFrame;
	}

	public String getMotionDir(){
		return motionDir;
	}

	public double getThreshold(){
		return scale();
	}
	
	public boolean sign(){
		return largerThan;
	}
	
	public Controller ControllerType(){
		return controllerType;
	}
	
	
	private double scale(){
		double ref =threshold;
	if( thresholdUnit.equals("N") ){
		ref = threshold;
	} else if( thresholdUnit.equals("mN") ){
		ref = threshold*0.001;
	}else if( thresholdUnit.equals("Nmm") || thresholdUnit.equals("mNm") ){
		ref = threshold; 
	} else if( thresholdUnit.equals("Nm") ){
		ref = threshold*1000;
	} 
		return ref;
	}

	public String getThresholdUnit(){
		return thresholdUnit;
	}


}

