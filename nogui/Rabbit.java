package nogui;

public class Rabbit extends Pet{
	public Rabbit(String name) {
		super(name);
		super.setHungerNeed(2.00);
		super.setRoughness(1);
		super.setSleepiness(2);
		super.setFavfood("Carrot");
		super.setFavtoy("Food");
	}
}
