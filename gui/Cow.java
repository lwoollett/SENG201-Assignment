package gui;


/**
 * The Cow Class.
 */
public class Cow extends Pet{

	/**
	 * Instantiates a new cow.
	 *
	 * @param Name: The Pet's Name
	 */
	public Cow(String name) {
		super(name);
		super.setHungerNeed(6.00);
		super.setRoughness(20);
		super.setSleepiness(1);
		super.setFavfood("Grass");
		super.setFavtoy("Mud");
	}
}
