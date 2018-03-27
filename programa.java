package Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class programa {
	
	public static void main(String[] args) {
		Amostra amostra = new Amostra();
		List<Integer> c = Arrays.asList(1,2,3,4);
		amostra.add(c);
		List<Integer> q= Arrays.asList(1,2,6,3);
		amostra.add(q);
		Node g = new Node(5);
		Node t = new Node(3);
		ArrayList<Edges> r = new ArrayList<Edges>();
		Edges w = new Edges(g,t, 0.2);
		r.add(w);
		

		WGraph o = new WGraph(3);
		
		
		System.out.println(o);
      

	
		
	
		
		System.out.println(amostra.getT());
		
		
		List<Integer> a= Arrays.asList(0,1);
		List<Integer> b= Arrays.asList(1,4);
		System.out.println(amostra.count(a,b));
		
		
	}
}
