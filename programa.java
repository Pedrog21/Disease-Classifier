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
		
		
		Node f = new Node(4);
		Node t = new Node(1);
		WGraph o = new WGraph(4);
		o.add_edge(t,f,2);
		o.add_edge(t,new Node(2),5);
		o.add_edge(new Node(3),new Node(2),7);
		o.add_edge(new Node(5),new Node(2),9);
		o.add_edge(new Node(1),new Node(2),8);
		o.remove_edge(t,f);
		o.remove_edge(new Node(2),f);
		System.out.println(o);
		

     
		System.out.println(amostra.getT());
		
		List<Integer> a= Arrays.asList(0,1);
		List<Integer> b= Arrays.asList(1,4);
		System.out.println(amostra.count(a,b));
		
		
	}
}
