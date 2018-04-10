package Classes;

import java.util.ArrayList;


public class WGraph {
	public ArrayList<Node> nodes;
	public ArrayList<Edges> connections;

	public WGraph(int n) {
		int i;
		nodes = new ArrayList<Node>();
		connections = new ArrayList<Edges>();
		for(i=1; i<=n; i++) {
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

	public void setConnections(ArrayList<Edges> connections) {
		this.connections = connections;
	}

	public ArrayList<Edges> getConnections() {
		return connections;
	}

	public void add_edge(Node a, Node b, double w) {
		Edges r = new Edges(a,b,w);
		ArrayList<Edges> d = getConnections();
		d.add(r);
		setConnections(d);
	}
	
	public void remove_edge(Node a, Node b) {
		ArrayList<Edges> d = getConnections();
		int i=0;
		int l=-1;
		boolean s=false;
		while(i<d.size() && !s) {
			Edges t=new Edges();
			t=d.get(i);
			if((t.getStart()==a && t.getEnd()==b) || (t.getStart()==b && t.getEnd()==a)) {
				s=true;
				l=i;
			}
			i++;
		}
		d.remove(l);
		setConnections(d);
	}
	
	
	
	@Override
	public String toString() {
		return "WGraph [nodes=" + nodes + ", connections=" + connections + "]";
	}
}
