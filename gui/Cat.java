package gui;

/**
 * The Cat class.
 * Cat is one of the pets with the values of:
 * HungerNeed: 3
 * Roughness: 50
 * Sleepiness: 7
 * Favourite Food: Catnip
 * Favourite Toy: Scratch Post
 */
public class Cat extends Pet{

	/**
	 * Instantiates a new Cat.
	 *
	 * @param name is The Pet's Name
	 */
	public Cat(String name) {
		super(name);
		super.setHungerNeed(3.00);
		super.setRoughness(50);
		super.setSleepiness(7);
		super.setFavfood("Catnip");
		super.setFavtoy("Scratch Post");
	}
}
