package Projecto;

import java.util.ArrayList;

public class DGraph {
	
	private int dim;
	private ArrayList<ArrayList<Integer>> edges;
	
	public DGraph(int n) {
		dim = n;
		edges = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			edges.add(new ArrayList<Integer>());
		}
	}
	
	public void add_edge(int u, int v) {
		if (!edges.get(u).contains(v)) {
			edges.get(u).add(v);
		}
	}
	
	public void remove_edge(int u, int v) {
		int i = edges.get(u).indexOf(v); 
		if (i != -1) edges.get(u).remove(i);
	}
	
	public ArrayList<Integer> parents(int v) {
		ArrayList<Integer> r = new ArrayList<Integer>();
		for (int i = 0; i < dim; i++) {
			if (edges.get(i).contains(v)) r.add(i);
		}
		return r;
	}
	
	public int get_dim() {
		return dim;
	}
	
	@Override
	public String toString() {
		return edges.toString();
	}

}