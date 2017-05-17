package gui;

public class Toy {
	private String name;
	private int price;
	private int happiness;
	private int durability;
	
	public Toy(String name, int price, int happiness){
		this.name = name;
		this.price = price;
		this.happiness = happiness; //Needs to be between 0-40 40 is like, giving a puppy to your girlfriend. 
		this.durability = 100;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getHappiness() {
		return happiness;
	}
	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}
	public int getDurability() {
		return durability;
	}
	public void setDurability(int durability) {
		this.durability = durability;
	}
	
}