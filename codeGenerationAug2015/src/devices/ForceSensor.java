package devices;

public class ForceSensor extends Sensor {
	private VectorUnit force_xyz;
	private VectorUnit torque_xyz;
	private String name;
	
	public ForceSensor(String name){
		this.name = name;
		force_xyz = new VectorUnit("N");
		torque_xyz = new VectorUnit("Nm");
	}
	
	public String getName(){
		return name;
	}
	
	
}
