package gui;


/**
 * The Rat Class
 */
public class Rat extends Pet{

	/**
	 * Instantiates a new rat.
	 *
	 * @param name the name for it
	 */
	public Rat(String name) {
		super(name);
		super.setHungerNeed(1.00);
		super.setRoughness(10);
		super.setSleepiness(6);
		super.setFavfood("Pellets");
		super.setFavtoy("Rat Wheel");
	}
}
