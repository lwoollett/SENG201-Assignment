package gui;

public class Dog extends Pet{
	public Dog(String name) {
		super(name);
		super.setHungerNeed(4.00);
		super.setRoughness(5);
		super.setSleepiness(4);
		super.setFavfood("Dog Food");
		super.setFavtoy("Bone");
	}
}
