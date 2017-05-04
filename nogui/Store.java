package nogui;

import java.util.ArrayList;
import java.util.Random;

public class Store{
	private Random rand = new Random();
	private ArrayList<Toy> toys = new ArrayList<Toy>();
	private ArrayList<Food> foods = new ArrayList<Food>();
	private int[] foodamounts = {69, 69, 999999, 1, 12, 4};
	private int[] toyamounts = {1, 1, 1, 1, 1, 1};
	/*
	 * Food Names
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
	
	public int[] getFoodamounts() {
		return foodamounts;
	}
	
	public int[] getToyamounts() {
	
		return toyamounts;
	}
	
	public ArrayList<Toy> getToys() {
		return toys;
	}
	
	public ArrayList<Food> getFoods() {
		return foods;
	}
	
	public void setToyamounts(int[] toyamounts) {
		this.toyamounts = toyamounts;
	}
	
	public void setFoodamounts(int[] foodamounts) {
		this.foodamounts = foodamounts;
	}

	public void nextDay() {
		for(int i=0; i < foodamounts.length; i++){
			int r = rand.nextInt(2);
			foodamounts[i] += r;
		}
		for(int m=0; m < foodamounts.length; m++){
			int r = rand.nextInt(2);
			foodamounts[m] += r;
		}
	}
}
