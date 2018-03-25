package Classes;
import java.util.ArrayList;
import java.util.List;

public class Amostra {
	private  ArrayList<List<String>> T;
	private int length;
	
	public Amostra(ArrayList<List<String>> T, int length) {
		this.T = T;
		this.length = length;
	}
	
	public Amostra() {
		this.T =  new ArrayList<List<String>>();
		this.length = 0;
	}
		
	public ArrayList<List<String>> getT() {
		return T;
	}

	public void setT(ArrayList<List<String>> T) {
		this.T = T;
	}
	
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	public void add(List<String> d) {
		T.add(d);
		length++;
	}
	
	public int length() {
		return length;
	}
	
	public List<String> element(int k){
		return T.get(k);
		
	}
	

		
	
}
