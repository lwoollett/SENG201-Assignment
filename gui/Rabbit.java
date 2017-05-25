package gui;

/**
 * The Rabbit class.
 * Rabbit is one of the pets with the values of:
 * HungerNeed: 2
 * Roughness: 10
 * Sleepiness: 2
 * Favourite Food: Carrot
 * Favourite Toy: Hutch
 */

public class Rabbit extends Pet{

	/**
	 * Instantiates a new rabbit.
	 *
	 * @param name the name for it.
	 */
	public Rabbit(String name) {
		super(name);
		super.setHungerNeed(2.00);
		super.setRoughness(10);
		super.setSleepiness(2);
		super.setFavfood("Carrot");
		super.setFavtoy("Hutch");
	}
}
