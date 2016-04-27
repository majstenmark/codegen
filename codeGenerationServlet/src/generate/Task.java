package generate;

import java.util.ArrayList;

public class Task {
	private String ip, port, name;
	private ArrayList<ProgramElement> sequence = new ArrayList<ProgramElement>();
	
	public Task(String name, String ip, String port){
		this.ip = ip;
		this.name = name;
		this.port = port;
		
	}
	
	public void addSkill(ProgramElement skill){
		sequence.add(skill);
		
	}
	
	public String toString(){
		
		String str = "";
		for(ProgramElement s: sequence){
			str += s.toString() + "\n";
			
		}
		
		return str;
		
	}
	
	public String ip(){
		return ip;
	}
	
	public String port(){
		return port;
	}
	
	public String taskName(){
		return this.name;
	}
	
	public ProgramElement[] sequence(){
		return sequence.toArray(new ProgramElement[sequence.size()]);
		
	}

}
