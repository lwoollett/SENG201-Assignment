package gui;
/*
*Do we need any more 
*Vars for the player?
*What should the default
*Amount of money be?
*ArrayLists are masterrace
*/

import java.util.ArrayList;


public class Player {
	private String name;
	private int money = 1000; //TODO Add a actual variable with reasoning.
	private int score = 0;
	private int actions = 2;
	private ArrayList<Pet> pets = new ArrayList<Pet>();
	private ArrayList<Toy> toys = new ArrayList<Toy>();
	private ArrayList<Food> food = new ArrayList<Food>();
	
	public Player(String n){
		name = n;
	}
	
	public void nextDay(){
		actions = 2;
		for(Pet pet: pets){
			pet.nextDay();
		}
	}
	
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
	
	public String getName(){
		return name;
	}
	
	public int getMoney(){
		return money;
	}
	
	public void setMoney(int m){
		money = m;
	}
	
	public ArrayList<Pet> getPets(){
		return pets;
	}
	
	public void setPets(ArrayList<Pet> p){
		pets = p;
	}
	
	public ArrayList<Toy> getToys(){
		return toys;
	}
	
	public void setToys(ArrayList<Toy> t){
		this.toys = t;
	}
	
	public ArrayList<Food> getFood(){
		return food;
	}
	
	public void setFood(ArrayList<Food> f){
		this.food = f;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getActions() {
		return actions;
	}

	public void setActions(int actions) {
		this.actions = actions;
	}

	public void addFood(Food f) {
		this.food.add(f);
	}
	
	public void addToy(Toy t) {
		this.toys.add(t);
	}
}
