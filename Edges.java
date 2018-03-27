package Classes;



public class Edges {
	public Node start;
	public Node end;
	public double weight;
	
	public Edges(Node s, Node e, double w) {
		this.start=s;
		this.end=e;
		this.weight=w;
	}
	
	public Edges() {
		this.start = null;
		this.end=null;
		this.weight=0;
	}
	
	public Node getStart() {
		return start;
	}
	public void setStart(Node start) {
		this.start = start;
	}
	public Node getEnd() {
		return end;
	}
	public void setEnd(Node end) {
		this.end = end;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}

}
