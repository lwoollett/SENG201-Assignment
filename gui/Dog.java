package gui;


/**
 * The Dog Class.
 */
public class Dog extends Pet{

	/**
	 * Instantiates a new dog.
	 *
	 * @param Name: The Pet's Name
	 */
	public Dog(String name) {
		super(name);
		super.setHungerNeed(4.00);
		super.setRoughness(50);
		super.setSleepiness(4);
		super.setFavfood("Dog Food");
		super.setFavtoy("Bone");
	}
}
