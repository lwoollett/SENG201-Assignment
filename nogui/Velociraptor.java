package nogui;

public class Velociraptor extends Pet{
	public Velociraptor(String name) {
		super(name);
		super.setHungerNeed(7.00);
		super.setRoughness(7);
		super.setSleepiness(0);
		super.setFavfood("Human");
		super.setFavtoy("Human");
	}
}
