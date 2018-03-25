package Classes;
import java.util.ArrayList;
import java.util.List;

public class Amostra {
	private  ArrayList<List<Integer>> T;
	private int length;
	
	public Amostra(ArrayList<List<Integer>> T, int length) {
		this.T = T;
		this.length = length;
	}
	
	public Amostra() {
		this.T =  new ArrayList<List<Integer>>();
		this.length = 0;
	}
		
	public ArrayList<List<Integer>> getT() {
		return T;
	}

	public void setT(ArrayList<List<Integer>> T) {
		this.T = T;
	}
	
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	public void add(List<Integer> d) {
		T.add(d);
		length++;
	}
	
	public int length() {
		return length;
	}
	
	public List<Integer> element(int k){
		return T.get(k);
		
	}
	
	
	
	public int count(List<Integer> a,List<Integer> b) {
		int res=0;
		List<Integer> aux = new ArrayList<>();
		for(int i=0;i<a.size();i++) {
			for(int j=0;j<length();j++) {
				aux=element(j);
				if(aux.get(a.get(i))==b.get(i))
					res++;
			}
		}
		return res;
	}

		
	
}
