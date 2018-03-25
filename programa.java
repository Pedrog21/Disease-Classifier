package Classes;

import java.util.Arrays;
import java.util.List;

public class programa {
	
	public static void main(String[] args) {
		Amostra amostra = new Amostra();
		List<Integer> c = Arrays.asList(1,2,3,4);
		amostra.add(c);
		List<Integer> q= Arrays.asList(1,2,6);
		amostra.add(q);
	
		
		
		System.out.println(amostra.getT());
		
		
		List<Integer> a= Arrays.asList(0,1);
		List<Integer> b= Arrays.asList(1,4);
		System.out.println(amostra.count(a,b));
		
		
	}
}
