package gui;

public class Cat extends Pet{
	public Cat(String name) {
		super(name);
		super.setHungerNeed(3.00);
		super.setRoughness(5);
		super.setSleepiness(7);
		super.setFavfood("Cat Food");
		super.setFavtoy("Scratch Post");
	}
}
