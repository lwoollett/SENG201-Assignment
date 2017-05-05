package gui;

public class Rat extends Pet{
	public Rat(String name) {
		super(name);
		super.setHungerNeed(1.00);
		super.setRoughness(1);
		super.setSleepiness(6);
		super.setFavfood("Pellets");
		super.setFavtoy("Rat Wheel");
	}
}
