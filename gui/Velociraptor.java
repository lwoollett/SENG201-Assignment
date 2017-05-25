package gui;

// TODO: Auto-generated Javadoc
/**
 * The Class Velociraptor.
 */
public class Velociraptor extends Pet{

	/**
	 * Instantiates a new velociraptor.
	 *
	 * @param name the name
	 */
	public Velociraptor(String name) {
		super(name);
		super.setHungerNeed(10);
		super.setRoughness(70);
		super.setSleepiness(0);
		super.setFavfood("Human");
		super.setFavtoy("Human");
	}
}
