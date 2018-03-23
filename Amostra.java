package Classes;

import java.util.Vector;

public class Amostra {
	private Vector<Vector<Integer>> vec;

	public Vector<Vector<Integer>> getVec() {
		return vec;
	}

	public void setVec(Vector<Vector<Integer>> vec) {
		this.vec = vec;
	}
	
	public void add(Vector<Integer> v) {
		vec.add(v);
		
	}
	
	public int length() {
		return vec.size();
		
	}
	

}
