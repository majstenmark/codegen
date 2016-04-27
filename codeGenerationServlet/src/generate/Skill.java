package generate;

import java.util.ArrayList;
import java.util.UUID;

public class Skill extends ProgramElement {
	private String uri = "file://export.rdf";
	private ArrayList<Parameter> parameters= new ArrayList<Parameter>();
	private ArrayList<Parameter> outputParameters= new ArrayList<Parameter>();
	//private String server = "http://localhost:8080/openrdf-sesame";
	//String server = "http://localhost:8080/openrdf-sesame";
	String server = "http://vm25.cs.lth.se/openrdf-sesame";
	//String repo = "SFC_tests_ver2";
	private String repo = "lone_skill";
	private String controllerType = "";
	
	public Skill(String uri){
		this.uri = uri;
		System.err.println("Skill with uri " + uri);
		
	}
	
	public void addParameter(Parameter p){
		parameters.add(p);
		
	}
	public void addOutputParameter(Parameter p){
		outputParameters.add(p);
		
	}
	
	public String generateXml(UUID macroStepId){

		System.err.println("Here!!!!!!!!!!!");
		SFCKIF obj = new SFCKIF(server, repo, uri);
		String str =  obj.getSFCXML();

		System.out.println("CCCCCCCCCCCCCC " + str);
		int repId = str.indexOf("id=");
		int endIndex = str.indexOf("\"", repId+4);
		String oldId = str.substring(repId+4, endIndex);
		str = str.replaceAll(oldId, macroStepId.toString());
		controllerType = obj.getControllerType();
		return str;
		
	}
	
	
	public static void main(String[] args){
		// String server = "http://localhost:8080/openrdf-sesame";
		// String repo = "lone_skill";
		String uri = "file://../JGraphChartFiles/snapfittest2.xml";
		String server = "http://vm25.cs.lth.se/openrdf-sesame";
		String repo = "SFC_tests_ver2";
		/*
		 * -c get -s http://localhost:8080/openrdf-sesame -r lone_skill -x file://../JGraphChartFiles/snapfittest2.xml -f snapfitbetter.xml -n snapfittest
		 * */
		System.out.println("Start skill!");
		SFCKIF obj = new SFCKIF(server, repo, uri);
		String str = obj.getSFCXML();
		System.out.println(str);
		int repId = str.indexOf("id=");
		System.out.println("startindes" + repId);
		
		int endIndex = str.indexOf("\"", repId+4);
		System.out.println("startindes" + endIndex);
		
		String oldId = str.substring(repId+4, endIndex);
		//System.out.println("OldId " + oldId);
		//System.out.println(str);
		
	}
}
