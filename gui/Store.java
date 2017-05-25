package gui;

import java.util.ArrayList;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Store.
 */
public class Store{
	
	/** The rand. */
	private Random rand = new Random();
	
	/** The toys. */
	private ArrayList<Toy> toys = new ArrayList<Toy>();
	
	/** The foods. */
	private ArrayList<Food> foods = new ArrayList<Food>();
	
	/** The foodamounts. */
	private int[] foodamounts = {69, 69, 999999, 1, 12, 4};
	
	/** The toyamounts. */
	private int[] toyamounts = {1, 1, 1, 1, 1, 1};
	/*
	 * Food Names
	 */
	
	/**
	 * Instantiates a new store.
	 */
	public Store(){
		//Toys name, price, happiness
		toys.add(new Toy("Bone", 10, 15));
		toys.add(new Toy("Mud", 10, 15));
		toys.add(new Toy("Scratch Post", 10, 15));
		toys.add(new Toy("Human", 10, 15));
		toys.add(new Toy("Food", 10, 15));
		toys.add(new Toy("Rat Wheel", 10, 15));
		//Foods Name, price, nutrition, taste, size
		foods.add(new Food("Dog Food", 10, 10, 10, 2));
		foods.add(new Food("Cat Food", 10, 10, 10, 2));
		foods.add(new Food("Human", 10, 10, 10, 2));
		foods.add(new Food("Carrot", 10, 10, 10, 2));
		foods.add(new Food("Pellets", 10, 10, 10, 2));
		foods.add(new Food("Grass", 10, 10, 10, 2));
	}
	
	/**
	 * Gets the foodamounts.
	 *
	 * @return the foodamounts
	 */
	public int[] getFoodamounts() {
		return foodamounts;
	}
	
	/**
	 * Gets the toyamounts.
	 *
	 * @return the toyamounts
	 */
	public int[] getToyamounts() {
	
		return toyamounts;
	}
	
	/**
	 * Gets the toys.
	 *
	 * @return the toys
	 */
	public ArrayList<Toy> getToys() {
		return toys;
	}
	
	/**
	 * Gets the foods.
	 *
	 * @return the foods
	 */
	public ArrayList<Food> getFoods() {
		return foods;
	}
	
	/**
	 * Sets the toyamounts.
	 *
	 * @param toyamounts the new toyamounts
	 */
	public void setToyamounts(int[] toyamounts) {
		this.toyamounts = toyamounts;
	}
	
	/**
	 * Sets the foodamounts.
	 *
	 * @param foodamounts the new foodamounts
	 */
	public void setFoodamounts(int[] foodamounts) {
		this.foodamounts = foodamounts;
	}

	/**
	 * Next day.
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
