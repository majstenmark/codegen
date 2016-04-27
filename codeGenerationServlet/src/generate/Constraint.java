package generate;

class Constraint{
	private String type;
	private String controllerId;
	private String motionFrame;
	private String motionDir;
	private double reference;
	private String referenceUnit;

	public Constraint(String type, String ctrlId, String motionFrame, String motionDir, double ref, String unit){
		this.type = type;
		this.controllerId = ctrlId;
		this.motionFrame = motionFrame;
		this.motionDir = motionDir;
		this.reference = ref;
		this.referenceUnit = unit;
	}

	public String getFrame(){
		return motionFrame;
	}

	public String getMotionDir(){
		return motionDir;
	}

	public String getUnit(){
		return referenceUnit;
	}

	public double getReference(){
		return scale();
	}
	private double scale(){
		double ref =0;
	if( referenceUnit.equals("N") ){
		ref = reference;
	} else if( referenceUnit.equals("mN") ){
		ref = reference*0.001;
	}else if( referenceUnit.equals("Nmm") || referenceUnit.equals("mNm") ){
		ref = reference; 
	} else if( referenceUnit.equals("Nm") ){
		ref = reference*1000;
	} 
		return ref;
	}

	public String getControllerId(){
		return controllerId;
	}
	
}