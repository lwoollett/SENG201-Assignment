package gui;

/**
 * The Dog class.
 * Dog is one of the pets with the values of:
 * HungerNeed: 4
 * Roughness: 50
 * Sleepiness: 4
 * Favourite Food: Dog Food
 * Favourite Toy: Bone
 */

public class Dog extends Pet{

	/**
	 * Instantiates a new dog.
	 *
	 * @param name is The Pet's Name
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
