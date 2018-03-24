package Classes;
import java.util.ArrayList;
import java.util.List;

public class Amostra {
	private  ArrayList<String> T;
	private int length;
	
	public Amostra(ArrayList<String> T, int length) {
		this.T = T;
		this.length = length;
	}
	
	public ArrayList<String> getVec() {
		return T;
	}

	public void setVec(ArrayList<String> T) {
		this.T = T;
	}
	
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	public void add(List<String> d) {
		T.addAll(d);
		length++;
	}
	
	public int length() {
		return length;
	}
	
	public String element(int k){
		return T.get(k);
		
	}
	

		
	
}
