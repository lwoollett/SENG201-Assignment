package gui;
import java.util.ArrayList;


/**
 * The player class
 */
public class Player {
	private String name;
	private int money = 1000; // Players Money.
	private int score = 0;
	private int actions = 2;
	private ArrayList<Pet> pets = new ArrayList<>();
	private ArrayList<Toy> toys = new ArrayList<>();
	private ArrayList<Food> food = new ArrayList<>();

	/**
	 * Instantiates a new player.
	 *
	 * @param n the name for the player.
	 */
	public Player(String n){
		name = n;
	}

	/**
	 * Next day.
	 * Resets actions, gets pets scores and adds them to the players score
	 * Also gives a small amount of money.
	 */
	public void nextDay(){
		actions = 2;
		money += 100;
		for(Pet pet: pets){
			pet.nextDay();
			score += pet.retScore();
		}
	}

	/**
	 * Prints the inventory.
	 * Only really useful for command line application.
	 */
	public void printInventory() {
		System.out.println("Toys:");
		for(Toy t : toys){
			System.out.println(t.getName() + " has " + t.getDurability() + " durability left.");

		}
		System.out.println("Food:");
		for(Food f : food){
			System.out.println(f.getName() + " nutrition: " + f.getNutrition());
		}
	}

	/**
	 * Gets the name of the player.
	 *
	 * @return the name of the player
	 */
	public String getName(){
		return name;
	}

	/**
	 * Gets the player's money.
	 *
	 * @return the players money.
	 */
	public int getMoney(){
		return money;
	}

	/**
	 * Sets the player's  money.
	 *
	 * @param m the new money amount.
	 */
	public void setMoney(int m){
		money = m;
	}

	/**
	 * Gets the player's  pets.
	 *
	 * @return the pets.
	 */
	public ArrayList<Pet> getPets(){
		return pets;
	}

	/**
	 * Sets the player's pets.
	 *
	 * @param p the new arraylist of pets
	 */
	public void setPets(ArrayList<Pet> p){
		pets = p;
	}

	/**
	 * Gets the player's  toys.
	 *
	 * @return the player's  toys.
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
	 * Gets the player's  food.
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
	 * Gets the player's  score.
	 *
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Sets the player's  score.
	 *
	 * @param score the new score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Gets the player's  actions.
	 *
	 * @return the player's remaining actions
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
