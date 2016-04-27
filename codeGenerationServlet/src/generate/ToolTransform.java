package generate;

class ToolTransform extends Frame {
	
	public ToolTransform(String name, double[] trans, double[] quat){
		// first invert quaternion
		super(name, trans, quat);
		super.quaternion[0] = quat[0];
		super.quaternion[1] = -quat[1];
		super.quaternion[2] = -quat[2];
		super.quaternion[3] = -quat[3];
	}

	public double[] getTrans(){
		return super.getOrigin();
	}

	public double[] getInvYZXEulerAngles(){
		return super.getYZXEulerAngles();
	}
}

