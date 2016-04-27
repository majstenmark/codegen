package GraphElements;

import java.util.ArrayList;

public interface HasDistance {
	
	public int getDistance();
	public void setDistance(int dist);
	public ArrayList<HasDistance> next();
}
