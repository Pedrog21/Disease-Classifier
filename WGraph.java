package Classes;

import java.util.ArrayList;


public class WGraph {
	public ArrayList<Node> nodes;
	public ArrayList<ArrayList<ArrayList<Double>>> connections;

	public WGraph(int n) {
		nodes = new ArrayList<Node>();
		connections = new ArrayList<ArrayList<ArrayList<Double>>>();
		int i;
		for(i=1; i<=n; i++) {
			Node a = new Node(i);
			nodes.add(a);
			connections.add(new ArrayList<ArrayList<Double>>());
		}
	
	}
	
	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}
	
	public void setConnections(ArrayList<ArrayList<ArrayList<Double>>> connections) {
		this.connections = connections;
	}

	public ArrayList<ArrayList<ArrayList<Double>>> getConnections() {
		return connections;
	}
	
	public void add_edge(Node a, Node b, double w) {
		ArrayList<Node> g=getNodes();
		if(a.getKey()<=g.size() && b.getKey()<=g.size()) {
			int q1=a.getKey();
			int q2=b.getKey();
			ArrayList<Double> r1 = new ArrayList<Double>();
			r1.add(1.0*q1); r1.add(w);
			ArrayList<Double> r2 = new ArrayList<Double>();
			r2.add(1.0*q2); r2.add(w);
			ArrayList<ArrayList<ArrayList<Double>>> d = getConnections();
			ArrayList<ArrayList<Double>> i1= d.get(q1-1);
			i1.add(r2);
			ArrayList<ArrayList<Double>> i2= d.get(q2-1);
			i2.add(r1);
			d.remove(q1-1);
			d.add(q1-1,i1);
			d.remove(q2-1);
			d.add(q2-1,i2);
			setConnections(d);
			/*falta não deixar adicionar uma aresta entre dois nós que já têm uma aresta*/
		}
	}
	
	public void remove_edge(Node a, Node b) {
		int q1=a.getKey();
		int q2=b.getKey();
		ArrayList<ArrayList<ArrayList<Double>>> d = getConnections();
		ArrayList<ArrayList<Double>> l1 = d.get(q1-1);
		ArrayList<ArrayList<Double>> l2 = d.get(q2-1);
		int i=0;
		boolean s=false;
		while(i<l1.size() && !s) {
			ArrayList<Double> t=l1.get(i);
			if(t.get(0)==q2) s=true;
			i++;
		}
		if(s) l1.remove(i-1);
		i=0; s=false;
		while(i<l2.size() && !s) {
			ArrayList<Double> t=l2.get(i);
			if(t.get(0)==q1) s=true;
			i++;
		}
		if(s) l2.remove(i-1);
		d.remove(q1-1);
		d.add(q1-1,l1);
		d.remove(q2-1);
		d.add(q2-1,l2);
		setConnections(d);
	}
	
	
	
	@Override
	public String toString() {
		return "WGraph [nodes=" + nodes + ", connections=" + connections + "]";
	}
}
