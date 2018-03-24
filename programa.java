package Classes;

import java.util.Arrays;
import java.util.List;

public class programa {
	
	public static void main(String[] args) {
		Amostra amostra = new Amostra(null,0);
		List<String> c = Arrays.asList("sup1", "sup2", "sup3");
		amostra.add(c);
		List<String> d= Arrays.asList("sup4", "sup5", "sup6");
		amostra.add(d);
		
		
		System.out.println(amostra.length());
		
		
	}
}
