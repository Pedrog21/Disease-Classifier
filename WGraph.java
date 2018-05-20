package Classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class WEdge {
	
	private int v;
	private double weight;
	
	public WEdge(int n, double w) {
		v = n;
		weight = w;
	}
	
	public boolean nodeQ(int u) {
		return v == u;
	}
	
	public int getV() {
		return v;
	}
	
	public double getW() {
		return weight;
	}
	
	public int find(ArrayList<WEdge> A) {
		if (A.isEmpty()) return -1;
		int i = 0;
		boolean f = false;
		while(!f && i < A.size()) {
			f = A.get(i).v == this.v;
			i++;
		}
		if (f) return i - 1;
		return -1;
	}
	
	@Override
	public String toString() {
		return "(" + v + ", " + weight + ")";
	}
}

class keyNode {
	
	private int n;
	private double key;
	
	public keyNode(int i, double w) {
		n = i;
		key = w;
	}
	
	public int getN() {
		return n;
	}
	
	public double getK() {
		return key;
	}
	
	public void setK(double w) {
		key = w;
	}
}

class NodeComparator implements Comparator<keyNode> {
	
	@Override
    public int compare(keyNode x, keyNode y) { // se x.key for maior, então x é mais pequeno pois a queue orndena de pequeno para o maior
		if (x.getK() > y.getK()) return -1;
		else if (x.getK() < y.getK()) return 1;
		else return 0;
	}
}

public class WGraph {
	
	private int dim;
	private ArrayList<ArrayList<WEdge>> edges;
	
	public WGraph(int n) {
		dim = n;
		edges = new ArrayList<ArrayList<WEdge>>();
		for (int i = 0; i < n; i++) {
			edges.add(new ArrayList<WEdge>());
		}
	}
	
	public void add_edge(int u, int v, double w) {
		if (u < dim && v < dim) {
			WEdge e1 = new WEdge(v, w);
			WEdge e2 = new WEdge(u, w);
			if (e1.find(edges.get(u)) == -1) {
				edges.get(u).add(e1);
				edges.get(v).add(e2);
			}
		}
	}
	
	public void remove_edge(int u, int v) {
		WEdge e1 = new WEdge(v, 1.0);
		WEdge e2 = new WEdge(u, 1.0);
		int i = e1.find(edges.get(u));
		if (i != -1) {
			int j = e2.find(edges.get(v));
			edges.get(u).remove(i);
			edges.get(v).remove(j);
		}
	}
	
	public int get_dim() {
		return dim;
	}
	
	public DGraph MST(int n) {
		DGraph T = new DGraph(dim);
		ArrayList<keyNode> nodes = new ArrayList<keyNode>();
		ArrayList<Integer> parent = new ArrayList<Integer>();
		double inf = Double.POSITIVE_INFINITY;
		for (int i = 0; i < dim; i++) {
			keyNode node = new keyNode(i, -1.0); 
			nodes.add(node);
			parent.add(null);
		}
		nodes.get(n).setK(inf);
		Comparator<keyNode> comp = new NodeComparator();
		PriorityQueue<keyNode> Aux = new PriorityQueue<keyNode>(dim, comp);
		for (int i = 0; i < dim; i++) Aux.add(nodes.get(i));
		while (Aux.peek() != null) {
			keyNode u = Aux.poll(); 
			for (int i = 0; i < edges.get(u.getN()).size(); i++) {
				int v = edges.get(u.getN()).get(i).getV();
				double w = edges.get(u.getN()).get(i).getW();
				keyNode V = nodes.get(v);
				if (Aux.contains(V) && w > V.getK()) {
					Aux.remove(V);
					parent.set(v, u.getN());
					nodes.set(v, new keyNode(v, w));
					Aux.add(nodes.get(v));
				}
			}
		}
		for (int i = 0; i < dim; i++) {
			if (i != n) T.add_edge(parent.get(i), i);
		}
		return T;
	}
			
	@Override
	public String toString() {
		return edges.toString();
	}
	
}