package Classes;

import java.util.Vector;

public class programa {
	public static void main(Vector<Vector<Integer>>[] args) {
		Vector<Vector<Integer>> vec = new Vector<Vector<Integer>>(4);
		vec.add(3);
		vec.add(5);
		vec.add(2);
		vec.add(1);
		
		System.out.println(vec);
		
	}
}
