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
		super.setHungerNeed(7.00);
		super.setRoughness(7);
		super.setSleepiness(0);
		super.setFavfood("Human");
		super.setFavtoy("Human");
	}
}
