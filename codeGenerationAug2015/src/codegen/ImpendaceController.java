package codegen;


class ImpedanceController {
	private double D;
	private double M;
	private String name;

	public ImpedanceController(String name, double M, double D){
		this.name = name;
		this.M = M;
		this.D = D;
	}

	public String getName(){
		return name;
	}

	public double getD(){
		return D;
	}

	public double getM(){
		return M;
	}
}
