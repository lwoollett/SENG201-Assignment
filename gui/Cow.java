package gui;

// TODO: Auto-generated Javadoc
/**
 * The Class Cow.
 */
public class Cow extends Pet{
	
	/**
	 * Instantiates a new cow.
	 *
	 * @param name the name
	 */
	public Cow(String name) {
		super(name);
		super.setHungerNeed(6.00);
		super.setRoughness(2);
		super.setSleepiness(1);
		super.setFavfood("Grass");
		super.setFavtoy("Mud");
	}
}
