package gui;

public class Food {
	private String name; //Food Name
	private int value; //0 - INF
	private int nutrition; //0-100
	private int tastiness; //0-100
	private int mealsize; //1; Smallmeal, 2; Medium Meal, 3; Big Meal
	
	//Constructor
	public Food(String foodName, int val, int nutri, int taste, int size){
		this.name = foodName;
		this.value = val;
		this.nutrition = nutri;
		this.tastiness = taste;
		this.mealsize = size;
	}
	
	//Getters
	public String getName(){
		return name;
	}
	public int getValue(){
		return value;
	}
	public int getNutrion(){
		return nutrition;
	}
	public int getTastiness(){
		return tastiness;
	}
	public int getMeal(){
		return mealsize;
	}
	
	//Setters
	public void setName(String n){
		name = n;
	}
	public void setValue(int v){
		value = v;
	}
	public void setNutrion(int v){
		nutrition = v;
	}
	public void setTastiness(int v){
		mealsize = v;
	}
	public void setMeal(int v){
		mealsize = v;
	}
	
	
}
