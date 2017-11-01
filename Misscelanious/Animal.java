package LeetCode.Misscelanious;

public class Animal {
	
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int setName(String name) {
		this.name = name;
		return 0;
	}

}

class Tortoise extends Animal{
	
	public static void main(String[] args) {
		Tortoise t = new Tortoise();
		
	}
	
}