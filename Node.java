package Classes;



public class Node {
	public int key;
	
	
	public Node(int key) {
		this.key=key;
	
	}
	
	public Node() {
		this.key=0;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	
	@Override
	public String toString() {
		return "Node [key=" + key+ "]";
	}
	

}
