package Classes;

import java.util.ArrayList;


public class WGraph {
	public ArrayList<Node> nodes;

	public WGraph(int n) {
		int i;
		nodes = new ArrayList<Node>();
		for(i=0; i<=n; i++) {
			Node a = new Node(i);
			nodes.add(a);
		}
	
	}
	
	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}
	
	

}
