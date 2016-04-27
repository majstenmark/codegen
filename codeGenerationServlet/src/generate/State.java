package generate;

import java.util.ArrayList;

import org.w3c.dom.Element;

class State{
	private Direction d;
	private ArrayList<Constraint> constraintList;
	private ArrayList<FinalConstraint> finalConditions;
	private String name;
	private String tool;
	private ArrayList<ErrorConstraint> errorConditions;
	private double xpos, ypos;
	private String jump_to_id = null;
	private int errorStateX= 600;
	private int errorTransX= 605;

	private int errorStrokeX= 622;
	private int regStrokeX= 270;
	private int regStateX= 248;
	private int regTransX= 255;
	
	
	private int i;
	private boolean regular = true;

	public State(String name, String tool, String jump_to){
		constraintList = new ArrayList<Constraint>();
		finalConditions = new ArrayList<FinalConstraint>();
		errorConditions = new ArrayList<ErrorConstraint>();
		this.name = name;
		this.jump_to_id = jump_to;
		this.tool = tool;
	}


	public void setNbr(int i, boolean regular){
		this.i = i;
		this.regular = regular;
		
	}

	public String jumpToId(){
		return jump_to_id;
	}
	public boolean isErrorState(){
		return !regular;
		
	}
	
	public Position getStatePos(){
		int x = regular? regStateX: errorStateX;
		return new Position(x, (36+120*(i+1)));
		
	}
	
	public Position getNextTransPos(){
		int x = regular? regTransX: errorTransX;
		return new Position(x, (110+(i+1)*120));
	} 
	

	public Position getNextTransStrokePos(){
		int x = regular? regStrokeX: errorStrokeX;
		return new Position(x, (136+120*(i+1)));
	} 
	

	public Position getLastTransStrokePos(){
		int x = regular? regStrokeX: errorStrokeX;
		return new Position(x, (155+120*(i+1)));
	} 
	
	public Position getNextStrokePos(){
		int x = regular? regStrokeX: errorStrokeX;
		return new Position(x, (92+120*(i+1)));
	}
	public Position getLastStrokePos(){
		int x = regular? regStrokeX: errorStrokeX;
		return new Position(x,(109+120*(i+1)));
	}
	

	public Position getAboveStatePos(){
		int x = regular? regStateX: errorStrokeX;
		return new Position(x, (10+120*(i+1)));
	} 

	public Position getNextStatePos(){
		int x = regular? regStateX: errorStateX;
		return new Position(x, 0);
	} 
	
	public void setDirection(Direction dir){
		d = dir;
	}

	public boolean hasErrorHandling(){
		return errorConditions.size()>0;
		
	}
	
	public void setErrorConstraint(ErrorConstraint fin){
		errorConditions.add(fin);
	}
	
	public void setFinalConstraint(FinalConstraint fin){
		finalConditions.add(fin);
	}
	
	public void addConstraint(Constraint con){
		constraintList.add(con);
	}

	public int getNumberOfConstraints(){
		return constraintList.size();
	}

	public Constraint getConstraint(int i){
		return constraintList.get(i);
	}

	public FinalConstraint getFinalConstraint(int i){
		return finalConditions.get(i);
	}
	
	public int nbrOfErrorConditions(){
		return errorConditions.size();
	}


	public ErrorConstraint getErrorConstraint(int i){
		return errorConditions.get(i);
	}
	
	public int nbrOfFinalConditions(){
		return finalConditions.size();
	}
	
	public String getTool(){
		return tool;
	}

	public Direction getDirection(){
		return d;
	}

	public String getName(){
		return name;
	}


	public boolean bouncy() {
		// TODO Auto-generated method stub
		return d.isBouncy();
	}
}
