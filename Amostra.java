package Classes;

import java.util.Vector;

public class Amostra {
	private Vector<Vector<Integer>> vec;
	private int length;
	

	public Vector<Vector<Integer>> getVec() {
		return vec;
	}

	public void setVec(Vector<Vector<Integer>> vec) {
		this.vec = vec;
	}
	
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	

	public void add(Vector<Integer> v) {
		vec.add(v);
		
	}
	
	public int length() {
		return length;
	}
	
	public Vector<Integer> element(int k){
		return vec.get(k);
		
	}
	
	
	
	

}
