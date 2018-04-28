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
		/* a é o vetor de variáveis, b é o vetor de valores */
		int res=0;
		int len=a.size();
		List<Integer> aux = new ArrayList<>();
		for(int i=0;i<length();i++) {
			aux=element(i);
			int j=0;
			boolean bool=true;
			while(j<len && bool) {
				if(aux.get(a.get(j))!=b.get(j)) bool=false;
				j++;
			}
			if(bool) res++;
		}
		return res;
	}
}
