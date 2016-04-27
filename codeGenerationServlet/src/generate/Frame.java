package generate;

class Frame{
	private String name;
	private double[] origin = {0.0,0.0,0.0};
	protected double[] quaternion = {1.0,0.0,0.0,0.0};

	public Frame(String name, double[] o, double[] q){
		this.name = name;
		origin[0] = o[0];
		origin[1] = o[1];
		origin[2] = o[2];
		quaternion[0] = q[0];
		quaternion[1] = q[1];
		quaternion[2] = q[2];
		quaternion[3] = q[3];		
	}

	public String getName(){
		return name;
	}

	/** quaternion can be non-normalised */
	public double[] getYZXEulerAngles() {
		double phi = 0;
		double theta = 0;
		double psi = 0;
		double qw = quaternion[0];
		double qx = quaternion[1];
		double qy = quaternion[2];
		double qz = quaternion[3];
		double sqw = qw*qw;
		double sqx = qx*qx;
		double sqy = qy*qy;
		double sqz = qz*qz;
		double unit = sqx + sqy + sqz + sqw; // if normalised is one, otherwise is correction factor
		double test = qx*qy + qz*qw;
		if (test > 0.499*unit) { // singularity at north pole
			phi = 2*Math.atan2(qx,qw);
			theta = Math.PI/2;
			psi = 0;
		} else if (test < -0.499*unit) { // singularity at south pole
			phi = -2*Math.atan2(qx,qw);
			theta = -Math.PI/2;
			psi = 0;
		} else {
			phi = Math.atan2(2*qy*qw-2*qx*qz , sqx - sqy - sqz + sqw);
			theta = Math.asin(2*test/unit);
			psi = Math.atan2(2*qx*qw-2*qy*qz , -sqx + sqy - sqz + sqw);
		}

		double[] d = {phi,theta,psi};
		return d;
	}

	public double[] getOrigin(){
		return origin;
	}

	public double[] getQuaternion(){
		return quaternion;
	}

}
