package gui;

// TODO: Auto-generated Javadoc
/**
 * The Class Rat.
 */
public class Rat extends Pet{
	
	/**
	 * Instantiates a new rat.
	 *
	 * @param name the name
	 */
	public Rat(String name) {
		super(name);
		super.setHungerNeed(1.00);
		super.setRoughness(1);
		super.setSleepiness(6);
		super.setFavfood("Pellets");
		super.setFavtoy("Rat Wheel");
	}
}
