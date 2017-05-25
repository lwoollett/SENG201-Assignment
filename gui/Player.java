package gui;
/*
*Do we need any more 
*Vars for the player?
*What should the default
*Amount of money be?
*ArrayLists are masterrace
*/

import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
public class Player {
	
	/** The name. */
	private String name;
	
	/** The money. */
	private int money = 1000; //TODO Add a actual variable with reasoning.
	
	/** The score. */
	private int score = 0;
	
	/** The actions. */
	private int actions = 2;
	
	/** The pets. */
	private ArrayList<Pet> pets = new ArrayList<Pet>();
	
	/** The toys. */
	private ArrayList<Toy> toys = new ArrayList<Toy>();
	
	/** The food. */
	private ArrayList<Food> food = new ArrayList<Food>();
	
	/**
	 * Instantiates a new player.
	 *
	 * @param n the n
	 */
	public Player(String n){
		name = n;
	}
	
	/**
	 * Next day.
	 */
	public void nextDay(){
		actions = 2;
		for(Pet pet: pets){
			pet.nextDay();
		}
	}
	
	/**
	 * Prints the inventory.
	 */
	public void printInventory() {
		System.out.println("Toys:");
		for(Toy t : toys){
			System.out.println(t.getName() + " has " + t.getDurability() + " durability left.");
			
		}
		System.out.println("Food:");
		for(Food f : food){
			System.out.println(f.getName() + " nutrition: " + f.getNutrion());
		}
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Gets the money.
	 *
	 * @return the money
	 */
	public int getMoney(){
		return money;
	}
	
	/**
	 * Sets the money.
	 *
	 * @param m the new money
	 */
	public void setMoney(int m){
		money = m;
	}
	
	/**
	 * Gets the pets.
	 *
	 * @return the pets
	 */
	public ArrayList<Pet> getPets(){
		return pets;
	}
	
	/**
	 * Sets the pets.
	 *
	 * @param p the new pets
	 */
	public void setPets(ArrayList<Pet> p){
		pets = p;
	}
	
	/**
	 * Gets the toys.
	 *
	 * @return the toys
	 */
	public ArrayList<Toy> getToys(){
		return toys;
	}
	
	/**
	 * Sets the toys.
	 *
	 * @param t the new toys
	 */
	public void setToys(ArrayList<Toy> t){
		this.toys = t;
	}
	
	/**
	 * Gets the food.
	 *
	 * @return the food
	 */
	public ArrayList<Food> getFood(){
		return food;
	}
	
	/**
	 * Sets the food.
	 *
	 * @param f the new food
	 */
	public void setFood(ArrayList<Food> f){
		this.food = f;
	}
	
	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Sets the score.
	 *
	 * @param score the new score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Gets the actions.
	 *
	 * @return the actions
	 */
	public int getActions() {
		return actions;
	}

	/**
	 * Sets the actions.
	 *
	 * @param actions the new actions
	 */
	public void setActions(int actions) {
		this.actions = actions;
	}

	/**
	 * Adds the food.
	 *
	 * @param f the f
	 */
	public void addFood(Food f) {
		this.food.add(f);
	}
	
	/**
	 * Adds the toy.
	 *
	 * @param t the t
	 */
	public void addToy(Toy t) {
		this.toys.add(t);
	}
}
