package codegen;

import java.util.ArrayList;
import java.util.UUID;

public class LoopStep extends Specification {
	
	public ArrayList<Specification> nestedStatements = new ArrayList<Specification>();
	private ArrayList<String> order1 = new ArrayList<String>();
	private ArrayList<String> order2 = new ArrayList<String>();
	
	public void addOrder(int order, String item1, String item2){
		if(order == 1) {
			order1.add(""+ item1 + "," + item2);
		}else{
			order2.add(""+ item1 + "," + item2);
		}
		
	}
	
	public int limit(){
		return Math.min(order1.size(), order2.size());
	}
	
	public String values1(){
		String str = "";
		for(int i = 0; i < order1.size(); i++){
			String s = order1.get(i);
			str += "&quot;"+s+"&quot;";
			if(i != order1.size()-1) str += ";";
		}
		return str;
	}
	public String values2(){
		String str = "";
		for(int i = 0; i < order2.size(); i++){
			String s = order2.get(i);
			str += "&quot;"+s+"&quot;";
			if(i != order2.size()-1) str += ";";
		}
		return str;
	}
	
	public void addProgramElement(Specification e){
	//	System.out.println("add " + e);
		nestedStatements.add(e);
	}

	
}
