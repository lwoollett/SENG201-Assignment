package gui;

// TODO: Auto-generated Javadoc
/**
 * The Class Rabbit.
 */
public class Rabbit extends Pet{
	
	/**
	 * Instantiates a new rabbit.
	 *
	 * @param name the name
	 */
	public Rabbit(String name) {
		super(name);
		super.setHungerNeed(2.00);
		super.setRoughness(1);
		super.setSleepiness(2);
		super.setFavfood("Carrot");
		super.setFavtoy("Food");
	}
}
