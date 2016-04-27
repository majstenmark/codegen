package testcodegen;

import java.io.File;
import java.util.List;

import GraphElements.jgcGraph;
import codegen.InputXMLReader;
import codegen.TaskSpecification;
import statemachine.StateMachine;

public class simplesequence {
	public static void main(String[] args){
	
		List<TaskSpecification> tasks = InputXMLReader.readXML("input.xml");
		for(TaskSpecification t: tasks){
			
			StateMachine sm = t.createStateMachine();
			

			jgcGraph g = new jgcGraph(sm);	
			g.generateJgcCode("mytestfile.xml");
		}
	}

}
