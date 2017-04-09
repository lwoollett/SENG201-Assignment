package nogui;
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
	private ArrayList<Pet> pets = new ArrayList<Pet>();
	private ArrayList<Toy> toys = new ArrayList<Toy>();
	private ArrayList<Food> food = new ArrayList<Food>();
	
	public Player(String n){
		name = n;
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
	
	public ArrayList<Toy> getToys(){
		return toys;
	}
	
	public ArrayList<Food> getFood(){
		return food;
	}
}
