package nogui;


//SCORE = score * sum(points per attribute)
//Break pets up into many subclasses.
//Kill a small child.
//Sacra
public class Pet {
	//Normal Vars
	private String pettype; //TODO Make functions for each pet type changing vars.	
	private String petname;
	private int hunger; //0-100
	private int tiredness; //0-100
	private int mood; //1-3? Idk Fammmmmmm
	private boolean alive = true;
	private int toiletneed;
	private int weight;
	//Vars That Differ By Species
	private int sleepweight;
	private int hungerweight;
	private int toyweight;
	private String favtoy;
	
	public Pet(String name, String type){
		pettype = type;
		petname = name;
	}

	public String getPettype() {
		return pettype;
	}

	public String getPetname() {
		return petname;
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public int getTiredness() {
		return tiredness;
	}

	public void setTiredness(int tiredness) {
		this.tiredness = tiredness;
	}

	public int getMood() {
		return mood;
	}

	public void setMood(int mood) {
		this.mood = mood;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getToiletneed() {
		return toiletneed;
	}

	public void setToiletneed(int toiletneed) {
		this.toiletneed = toiletneed;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getSleepweight() {
		return sleepweight;
	}

	public void setSleepweight(int sleepweight) {
		this.sleepweight = sleepweight;
	}

	public int getHungerweight() {
		return hungerweight;
	}

	public void setHungerweight(int hungerweight) {
		this.hungerweight = hungerweight;
	}

	public int getToyweight() {
		return toyweight;
	}

	public void setToyweight(int toyweight) {
		this.toyweight = toyweight;
	}

	public String getFavtoy() {
		return favtoy;
	}

	public void setFavtoy(String favtoy) {
		this.favtoy = favtoy;
	}
}