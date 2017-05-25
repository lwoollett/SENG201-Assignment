package gui;

/**
 * Cat class.
 */
public class Cat extends Pet{

	/**
	 * Instantiates a new Cat.
	 *
	 * @param Name: The Pet's Name
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
