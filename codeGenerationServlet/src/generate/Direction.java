package generate;

class Direction{
	private String motionFrame;
	private String motionDir;
	private double searchVelocity;
	private String unit;
	private double bounce = 0;
	private boolean bouncy = false;

	public Direction(String motionFrame, String motionDir, double searchVelocity, String unit){
		this.motionFrame = motionFrame;
		this.motionDir = motionDir;
		this.searchVelocity = searchVelocity;
		this.unit = unit;
	}
	
	public Direction(String motionFrame, String motionDir, double searchVelocity, String unit, double bounce){
		this.motionFrame = motionFrame;
		this.motionDir = motionDir;
		this.searchVelocity = searchVelocity;
		this.unit = unit;
		this.bouncy = true;
		this.bounce = bounce;
	}

	public double getBounce(){
		return bounce;
	}

	public boolean isBouncy(){
		return bouncy;
	}

	
	public String getFrame(){
		return motionFrame;
	}

	public String getMotionDir(){
		return motionDir;
	}

	public double getSearchVelocity(){
		return searchVelocity;
	}

	public String getUnit(){
		return unit;
	}

	
}