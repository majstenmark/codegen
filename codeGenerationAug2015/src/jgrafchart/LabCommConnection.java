package jgrafchart;

import java.util.UUID;

import GraphElements.Positions;
import codegen.Utilities;

public class LabCommConnection{
	private int port = 8888;
	private boolean isOrca;
	private String version = "2013";
	private String sample = "";
	private boolean input = true;
	private boolean output = true;
	private boolean isServer = false;
	private int x = -100;
	private int  y = -100;
	private UUID id;
	private String name;
	
	public LabCommConnection(String name, String sampleFile){
		id = Utilities.generateUniqueId();
		this.name = name;
		sample = Utilities.readFile(sampleFile);
	}
	 
	private String host;
	

	public void setInput(boolean i){
		input = i;
	}
	
	public boolean getInput(){
		return input;  
	}
	
	public String getName(){
		return name;}

	public boolean isServer() {
		return isServer;
	}

	
	public boolean isOrca(){
		return isOrca;
	}
	
	public String getVersion(){
		return version;
	}
	
	public boolean getOutput(){
		return output;
	}
	
	public void setOutput(boolean i){
		output = i;
	}
	
	
	public void setServer(String ip){
		host = ip;
	}
	
	public void setPort(int port){
		this.port = port;
	}
	public String getServer(){
		return host;
	}
	
	public int getPort(){
		return port;
	}
	
	public String getLC(){
		return sample;
	}
	
	public String getId(){
		return id.toString();
	}
	
	public int getX(){
		return x;
		
	}
	
	public int getY(){
		return y;
	}
	
	
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setPosition(int offset){
		x = Positions.INITALOBJECTX;
		y = Positions.INITIALOBJECTY + offset * Positions.OBJECTDIST;
	}
	
	

	
}
