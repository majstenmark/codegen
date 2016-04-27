package generate;

import java.util.ArrayList;

public class Primitive extends ProgramElement {
	private String functionCall;
	private ArrayList<Parameter> params = new ArrayList<Parameter>();
	
	public Primitive(String call){
		super();
		functionCall = call;
		
	}
	
	public void addParam(Parameter p){
		params.add(p);
		
	}
	
	public String toString(){
		String s = "";
		s+=  functionCall;
		if(params.size() > 0) s +=  " ";
		for(Parameter p: params){
			if(!p.equals(params.get(0))){
				s+= ",";
			}
			s += p.toString();
			
		}
		return s;
		
	}
}
