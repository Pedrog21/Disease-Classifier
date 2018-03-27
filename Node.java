package Classes;

import java.util.ArrayList;

public class Node {
	public int key;
	public ArrayList<Edges> connections;
	
	public Node(int key, ArrayList<Edges> connections) {
		this.key=key;
		this.connections=connections;
	
	}
	
	public Node(int key) {
		this.key=key;
		this.connections = new ArrayList<Edges>();
	}
	
	public Node() {
		this.key=0;
		this.connections = new ArrayList<Edges>();
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public ArrayList<Edges> getConnections() {
		return connections;
	}
	public void setConnections(ArrayList<Edges> connections) {
		this.connections = connections;
	}
	

}
