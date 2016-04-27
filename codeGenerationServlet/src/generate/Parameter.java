package generate;

public class Parameter {
	private String type, value;
	
	public Parameter(String type, String value){
		this.type = type;
		this.value = value;
		
	}
	
	public Parameter(String value){
		this.value = value;
		
	}
	
	public String toString(){
		if(type.toLowerCase().equals("string")){
			return "\\&quot;\\&quot;"+ value +"\\&quot;\\&quot;";
			
		}
		return value;
		
	}
}
