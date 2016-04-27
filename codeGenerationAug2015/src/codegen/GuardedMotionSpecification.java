package codegen;
import org.w3c.dom.Node;

import statemachine.SmState;
import statemachine.SmTransition;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;


public class GuardedMotionSpecification extends Specification {
	//private GenerateJGrafchartXML codegenerator = new GenerateJGrafchartXML();
	private  RobotType r;
	private String name;
	private Direction direction;
	private ArrayList<FinalConstraint> finalConstraints = new ArrayList<>();
	private ArrayList<Constraint> motionConstraints = new ArrayList<>();
	private SmState state;
	private SmTransition transition;
	
	public GuardedMotionSpecification(String name, RobotType rob){
		super();
		r = rob;
		this.name = name;
		
	}
	
	public void addFinalConstraint(FinalConstraint f){
		finalConstraints.add(f);
	}
	
	public void addMotionConstraint(Constraint f){
		motionConstraints.add(f);
	}
	
	public void addDirection(Direction d){
		direction = d;
	}
	public SmState getStartState(){
		if(state == null || transition == null){
			state = new SmState();
			transition = new SmTransition();
			
		}
		return state;
	}
	
	
	
	public SmTransition getEndTransition(){
		if(state == null || transition == null){
			state = new SmState();
			transition = new SmTransition();
			
		}
		return transition;
	}
	/*
	public String stepCode(String fileName, UUID initialId, UUID macroID, UUID exceptionID,int initialX,  int initalY){
		String macroCode = codegenerator.macroStepXML(fileName, macroID.toString(), r, initialX, initalY);
		// DEBUG!!
		//ServletContext context = getServletContext();
		//String fullPath = context.getRealPath("/WEB-INF");

		ReadWriteTextFile rwtf = new ReadWriteTextFile();
		
		String fullPath = "./WEB-INF/";
		String fluff = codegenerator.buildXMLFile(rwtf, macroCode, r);
		//String fluff = rwtf.getContents(new File(fullPath +"/guardedMotionSteps.txt"));
		
		fluff = fluff.replace("INITIALID", initialId.toString());
		fluff = fluff.replace("MACROID", macroID.toString());
		fluff = fluff.replace("EXCEPTIONID", exceptionID.toString());
		fluff = fluff.replaceAll("Y1", ""+initalY);
		int yt1 = initalY+70;
		initalY += 90;
		fluff = fluff.replaceAll("YT1", ""+yt1);
		fluff = fluff.replaceAll("Y2", ""+initalY);
		yt1 = initalY+25;
		initalY += 45;
		fluff = fluff.replaceAll("YT2",""+yt1);	
		fluff = fluff.replaceAll("Y3", ""+initalY);
		 yt1 = initalY+70;
			initalY += 90;
			fluff = fluff.replaceAll("YT3", ""+yt1);
		fluff = fluff.replaceAll("Y4",  ""+initalY);
		yt1 = initalY+25;
		initalY += 45;
		fluff = fluff.replaceAll("YT4",  ""+yt1);
		fluff = fluff.replaceAll("Y5", ""+initalY);

		fluff = fluff.replaceAll("MACROY", ""+initalY);
		
		return fluff;
		
		
	}
	*/
	
}
