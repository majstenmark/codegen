package generate;
import org.w3c.dom.Node;

import java.io.File;
import java.util.UUID;


public class GuardedMotion extends ProgramElement {
	private GenerateJGrafchartXML codegenerator = new GenerateJGrafchartXML();
	private  RobotType r;
	
	public GuardedMotion(Node node, RobotType rob){
		super();
		r = rob;
		codegenerator.readInput(node);
		
	}
	
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
	
}
