package gui;

/**
 * The Velociraptor class.
 *  is one of the pets with the values of:
 * HungerNeed: 10
 * Roughness: 70
 * Sleepiness: 0
 * Favourite Food: Human
 * Favourite Toy: Human
 */

public class Velociraptor extends Pet{

	/**
	 * Instantiates a new FREAKING velociraptor.
	 *
	 * @param name the name of this awesome creature
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
