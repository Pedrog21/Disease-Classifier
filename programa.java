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
		Node f = new Node(2);
		Node t = new Node(1);
		ArrayList<Edges> r = new ArrayList<Edges>();
		Edges w = new Edges(t,f, 4);
		r.add(w);
		

		WGraph o = new WGraph(2);
		o.add_edge(t,f,2);
		o.remove_edge(t,f);
		
		
		System.out.println(o);
		

     
		System.out.println(amostra.getT());
		
		
		List<Integer> a= Arrays.asList(0,1);
		List<Integer> b= Arrays.asList(1,4);
		System.out.println(amostra.count(a,b));
		
		
	}
}
