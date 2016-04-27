package statemachine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

import GraphElements.Positions;

public class SmElement {
	private UUID id;
	private int x = -100;
	private int  y = -100;
	private HashSet<SmElement> allDecendants;
	private int distFromInit = Integer.MAX_VALUE;


	public SmElement(){
		id = codegen.Utilities.generateUniqueId();
	}

	public int hashCode(){
		return id.hashCode();
	}

	public boolean equals(Object o){
		if(o instanceof SmElement){
			return ((SmElement)o).id.equals(this.id);
		}
		return false;
	}

	public String toString(){
		return id.toString();
	}

	public void setDistance(int d){
		distFromInit = d;
	}

	public int getDistance(){
		return distFromInit;
	}

	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}

	public 	ArrayList<SmElement> next(){
		return null;
	}

	public 	ArrayList<SmElement> getParents(){
		return null;
	}

	public String getId(){
		return id.toString();
	}

	public void setPosition(){
		ArrayList<SmElement> p = getParents();
		if(p == null || p.size() == 0){
			x = Positions.INITIALSTATEX;
			y = Positions.INITIALSTATEY;
			setChildrenX();
			return;
		}
		double avX = p.stream().mapToInt(SmElement::getX).average().getAsDouble();

		if(x < 0) x = (int)avX + getDistanceFromParentX();
		setChildrenX();
		int maxY = p.stream().mapToInt(SmElement::getY).max().getAsInt();

		y = maxY + getDistanceFromParentY();

	}
	
	public String getName(){
		return "";
	}
	
	private void setChildrenX(){
		if(next().size() > 1){
			int totalW = maxWidth();
			double half = (totalW -1) * 0.5;
			int tmpX = x - (int)(half*Positions.PARALLELWIDTH);

			for(SmElement e: next()){
				int tmpW = e.maxWidth();

				double offset = (tmpW-1.0)*0.5; // integer div
				int eX = tmpX + (int)(offset*Positions.PARALLELWIDTH);
				tmpX = tmpX + tmpW*Positions.PARALLELWIDTH;
				e.x = eX + e.getDistanceFromParentX();

			}
		}
	}

	private SmElement findMergePoint(){
		HashMap<SmElement, HashSet<SmElement>> decMap = new HashMap<>();
		ArrayList<SmElement> n = next();
		for(SmElement e: n ){
			decMap.put(e,e.getDecendants());
		}
		SmElement mergePoint = null;
		if(n.size() > 0){
		HashSet<SmElement> d = decMap.get(n.get(0));
		for(SmElement ne: d){
			boolean inAll = true;
			innerLoop: for(int i = 1; i < n.size() && inAll; i++){
				
				if(!decMap.get(n.get(i)).contains(ne)){
					inAll = false;
					break innerLoop;
					
				}
			}
			if(inAll){
				if(mergePoint == null || mergePoint.getDistance() > ne.getDistance()){
					mergePoint = ne;
				}
			}
		}

		}return mergePoint;
	}
	protected int maxWidth(){
		HashSet<String> path = new HashSet<String>();
		path.add(getId());
		return maxWidth(path);
	}
	
	protected int maxWidth(HashSet<String> path){
		SmElement merged = findMergePoint();
		int w = 0;
		if(merged != null){
			for(SmElement e: next()){
				if(!path.contains(e.getId())){
					HashSet<String> forkedPath = new HashSet<String>();
					forkedPath.addAll(path);
				w =w + e.maxWidth(merged.getId(), forkedPath);
				}
			}
		}else{
			for(SmElement e: next()){

				if(!path.contains(e.getId())){
					HashSet<String> forkedPath = new HashSet<String>();
					forkedPath.addAll(path);
				w = w +  e.maxWidth(forkedPath);
				}
			}
		}
		return w > 0? w: 1;
		// calculate maxWidth for each child on the way.


	}

	private HashSet<SmElement> getDecendants() {
		if(allDecendants == null){
			allDecendants = new HashSet<SmElement>();
			for(SmElement e: next()){
				if(!allDecendants.contains(e)){
				allDecendants.add(e);
				allDecendants.addAll(e.getDecendants());
				}
			}
		}
		return allDecendants;
	}

	protected int maxWidth(String toID, HashSet<String> path){
		if( path.contains(getId())) return 0;
		if(getId().equals(toID)) return 1;

		int w = 0;
		path.add(getId());
		for(SmElement e: next()){
			w = w +  e.maxWidth(toID, path);
		}

		return w > 0? w: 1;
	}

	protected int getDistanceFromParentX(){
		return Positions.DISTSTATETRANS;
	}

	protected int getDistanceFromParentY(){
		return Positions.DISTSTATETRANS;
	}

	public int getX(){
		if(x < 0){
			setPosition();
		}
		return x;
	}
	public int getY(){
		if(y < 0){
			setPosition();
		}
		return y;
	}
}
