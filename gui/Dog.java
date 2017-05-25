package gui;

// TODO: Auto-generated Javadoc
/**
 * The Class Dog.
 */
public class Dog extends Pet{
	
	/**
	 * Instantiates a new dog.
	 *
	 * @param name the name
	 */
	public Dog(String name) {
		super(name);
		super.setHungerNeed(4.00);
		super.setRoughness(5);
		super.setSleepiness(4);
		super.setFavfood("Dog Food");
		super.setFavtoy("Bone");
	}
}
