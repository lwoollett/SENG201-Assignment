package gui;

/**
 * The Food class.
 * Foods are only created by the store
 * Foods have a name, value, nutrition value, tastiness, and meal size.
 */
public class Food {
	private String name; //Food Name
	private int value; //0 - INF
	private int nutrition; //0-100
	private int tastiness; //0-100
	private int mealsize; //1; Smallmeal, 2; Medium Meal, 3; Big Meal

	/**
	 * Makes  a new food.
	 *
	 * @param foodName the name of the food.
	 * @param val the dollar value.
	 * @param nutri the nutritional value.
	 * @param taste the taste value.
	 * @param size the size of the meal.
	 */

	//Constructor
	public Food(String foodName, int val, int nutri, int taste, int size){
		this.name = foodName;
		this.value = val;
		this.nutrition = nutri;
		this.tastiness = taste;
		this.mealsize = size;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		String retstring;
		retstring = name + " " + nutrition;
		return retstring;
	}

	/**
	 * Gets the name.
	 *
	 * @return the Name
	 */
	//Getters
	public String getName(){
		return name;
	}

	/**
	 * Gets the value.
	 *
	 * @return the $$ Value
	 */
	public int getValue(){
		return value;
	}

	/**
	 * Gets the nutrition.
	 *
	 * @return Nutrition
	 */
	public int getNutrition(){
		return nutrition;
	}

	/**
	 * Gets the tastiness.
	 *
	 * @return the tastiness of the food.
	 */
	public int getTastiness(){
		return tastiness;
	}

	/**
	 * Gets the meal size.
	 *
	 * @return the meal size
	 */
	public int getMeal(){
		return mealsize;
	}

	/**
	 * Sets the name. This should not be used.
	 *
	 * @param n the new name for the food.
	 */
	//Setters
	public void setName(String n){
		name = n;
	}

	/**
	 * Sets the value.
	 *
	 * @param v the new value in $$
	 */
	public void setValue(int v){
		value = v;
		if(value < 0){
			value = 1;
		}
	}

	/**
	 * Sets the nutrion.
	 *
	 * @param v the new nutrion
	 */
	public void setNutrition(int v){
		nutrition = v;
		if(nutrition < 0){
			nutrition = 0;
		}else if(nutrition > 100){
			nutrition = 100;
		}
	}

	/**
	 * Sets the tastiness.
	 *
	 * @param v the new tastiness
	 */
	public void setTastiness(int v){
		tastiness = v;
		if(tastiness < 0){
			tastiness = 0;
		}else if(tastiness > 100){
			tastiness = 100;
		}
	}

	/**
	 * Sets the meal size.
	 *
	 * @param v (value) the new meal size
	 */
	public void setMeal(int v){
		mealsize = v;
		if(mealsize < 0){
			mealsize = 0;
		}else if(mealsize > 4){
			mealsize = 4;
		}
	}


}
