package gui;

// TODO: Auto-generated Javadoc
/**
 * The Class Cat.
 */
public class Cat extends Pet{

	/**
	 * Instantiates a new cat.
	 *
	 * @param name the name
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
