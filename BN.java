package Classes;

import java.util.ArrayList;

public class BN {
	
	private double S;
	private Amostra T;
	private ArrayList<ArrayList<Integer>> P;
	
	// a assumir que os vertices de G sao X1,...,Xn,C
	// e que C não vai ter parentes
	public BN(DGraph G, Amostra A, double S) {
		this.S = S;                           
		this.T= A;
		P = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < G.get_dim() - 1; i++) {
			P.add(G.parents(i));
		}
	}

	public double prob(ArrayList<Integer> V) { // V = {d1,...,dn,c}
		ArrayList<Integer> C = new ArrayList<Integer>();
		ArrayList<Integer> c = new ArrayList<Integer>();
		C.add(V.size() - 1);
		c.add(V.get(V.size() - 1));
		double Pr = (T.count(C, c) * 1.0) / (T.length() * 1.0);
		for (int i = 0; i < P.size() + 1; i++) {
			ArrayList<Integer> Twi = new ArrayList<Integer>();
			ArrayList<Integer> twi = new ArrayList<Integer>();
			ArrayList<Integer> Tdiwi = new ArrayList<Integer>();
			ArrayList<Integer> tdiwi = new ArrayList<Integer>();
			for (int j = 0; j < P.get(i).size(); j++) {
				Twi.add(P.get(i).get(j));
				Tdiwi.add(P.get(i).get(j));
				twi.add(V.get(P.get(i).get(j)));
				tdiwi.add(V.get(P.get(i).get(j)));
			}
			Tdiwi.add(i);
			tdiwi.add(V.get(i));
			Pr = Pr * ((T.count(Tdiwi, tdiwi) + S) / (T.count(Twi, twi) + S * T.domain(i).size()));
		}
		return Pr;
		
	}
}

/* estou com um pequeno problema de tipos, o count precisa de duas List<Integer>, 
 * mas o parents do DGraph o que dá é um ArrayList<Integer> 
 * (eu usei sempre ArrayList para tudo nos grafos),
 */