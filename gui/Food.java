package gui;

// TODO: Auto-generated Javadoc
/**
 * The Class Food.
 */
public class Food {
	
	/** The name. */
	private String name; //Food Name
	
	/** The value. */
	private int value; //0 - INF
	
	/** The nutrition. */
	private int nutrition; //0-100
	
	/** The tastiness. */
	private int tastiness; //0-100
	
	/** The mealsize. */
	private int mealsize; //1; Smallmeal, 2; Medium Meal, 3; Big Meal
	
	/**
	 * Instantiates a new food.
	 *
	 * @param foodName the food name
	 * @param val the val
	 * @param nutri the nutri
	 * @param taste the taste
	 * @param size the size
	 */
	//Constructor
	public Food(String foodName, int val, int nutri, int taste, int size){
		this.name = foodName;
		this.value = val;
		this.nutrition = nutri;
		this.tastiness = taste;
		this.mealsize = size;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	//Getters
	public String getName(){
		return name;
	}
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public int getValue(){
		return value;
	}
	
	/**
	 * Gets the nutrion.
	 *
	 * @return the nutrion
	 */
	public int getNutrion(){
		return nutrition;
	}
	
	/**
	 * Gets the tastiness.
	 *
	 * @return the tastiness
	 */
	public int getTastiness(){
		return tastiness;
	}
	
	/**
	 * Gets the meal.
	 *
	 * @return the meal
	 */
	public int getMeal(){
		return mealsize;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param n the new name
	 */
	//Setters
	public void setName(String n){
		name = n;
	}
	
	/**
	 * Sets the value.
	 *
	 * @param v the new value
	 */
	public void setValue(int v){
		value = v;
	}
	
	/**
	 * Sets the nutrion.
	 *
	 * @param v the new nutrion
	 */
	public void setNutrion(int v){
		nutrition = v;
	}
	
	/**
	 * Sets the tastiness.
	 *
	 * @param v the new tastiness
	 */
	public void setTastiness(int v){
		mealsize = v;
	}
	
	/**
	 * Sets the meal.
	 *
	 * @param v the new meal
	 */
	public void setMeal(int v){
		mealsize = v;
	}
	
	
}
