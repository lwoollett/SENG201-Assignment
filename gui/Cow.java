package gui;

/**
 * The Cow class.
 * Cow is one of the pets with the values of:
 * HungerNeed: 6
 * Roughness: 20
 * Sleepiness: 1
 * Favourite Food: Grass
 * Favourite Toy: Mud
 */

public class Cow extends Pet{

	/**
	 * Instantiates a new cow.
	 *
	 * @param name is The Pet's Name
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
