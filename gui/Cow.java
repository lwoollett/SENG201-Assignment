package gui;

public class Cow extends Pet{
	public Cow(String name) {
		super(name);
		super.setHungerNeed(6.00);
		super.setRoughness(2);
		super.setSleepiness(1);
		super.setFavfood("Grass");
		super.setFavtoy("Mud");
	}
}
