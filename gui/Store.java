package gui;

import java.util.ArrayList;
import java.util.Random;

/**
 * The store class.
 * This class houses our store where we buy food and toys.
 */
public class Store{
	private Random rand = new Random();
	private ArrayList<Toy> toys = new ArrayList<>();
	private ArrayList<Food> foods = new ArrayList<>();
	private int[] foodamounts = {69, 69, 999999, 1, 12, 4};
	private int[] toyamounts = {5, 2, 12, 11, 42, 13};

	/**
	 * Instantiates a new store.
	 */
	public Store(){
		//Toys name, price, happiness, durability
		toys.add(new Toy("Bone", 10, 1, 10));
		toys.add(new Toy("Mud", 0, 1, 1000));
		toys.add(new Toy("Catnip", 30, 100, 100));
		toys.add(new Toy("Human", 10, 10, 5));
		toys.add(new Toy("Hutch", 30, 1, 100));
		toys.add(new Toy("Rat Wheel", 15, 1, 100));
		//Foods Name, price, nutrition, taste, size
		foods.add(new Food("Dog Food", 20, 30, 10, 2));
		foods.add(new Food("Cat Food", 20, 30, 10, 2));
		foods.add(new Food("Human", 150, 50, 0, 3));
		foods.add(new Food("Carrot", 5, 30, 10, 1));
		foods.add(new Food("Pellets", 30, 20, 10, 1));
		foods.add(new Food("Grass", 100, 30, 10, 1));
	}

	/**
	 * Gets the amounts of each food..
	 *
	 * @return the amounts of each food.
	 */
	public int[] getFoodamounts() {
		return foodamounts;
	}

	/**
	 * Gets the amounts of each toy.
	 *
	 * @return the amounts of each toy.
	 */
	public int[] getToyamounts() {

		return toyamounts;
	}

	/**
	 * Gets the actual toy objects.
	 *
	 * @return An arraylist of toys.
	 */
	public ArrayList<Toy> getToys() {
		return toys;
	}

	/**
	 * Gets the actual food objects as an arraylist.
	 *
	 * @return an arraylist of food
	 */
	public ArrayList<Food> getFoods() {
		return foods;
	}

	/**
	 * Sets the toyamounts.
	 *
	 * @param toyamounts, an int[] which is the new toyamounts
	 */
	public void setToyamounts(int[] toyamounts) {
		this.toyamounts = toyamounts;
	}

	/**
	 * Sets the foodamounts.
	 *
	 * @param foodamounts, an int[] which is the new foodamounts
	 */
	public void setFoodamounts(int[] foodamounts) {
		this.foodamounts = foodamounts;
	}

	/**
	 * Next day.
	 * Refills stock
	 */
	public void nextDay() {
		for(int i=0; i < foodamounts.length; i++){
			int r = rand.nextInt(2);
			foodamounts[i] += r;
		}
		for(int m=0; m < toyamounts.length; m++){
			int r = rand.nextInt(2);
			toyamounts[m] += r;
		}
	}
}
