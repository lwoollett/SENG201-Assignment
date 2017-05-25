package gui;
public class Pet {
	//Normal Vars
	private String petname;
	private int hunger; //0-100
	private int tiredness; //0-100
	private int mood; //1-4? Idk Fammmmmmm
	private boolean alive = true;
	private int toiletneed; //1-100
	private int weight; //ddwdwdawdawd
	//Vars That Differ By Species
	private int sleepiness;
	private double hungerNeed;
	private int roughness;
	private String favtoy;
	private String favfood;
	public Pet(String name){
		petname = name;
		hunger = 100;
		tiredness = 100;
		mood = 4;
		toiletneed = 100;
		weight = 50;
	}

	public String printStatus(){		String retstring = "";		retstring += "Pet Name: " + petname + "\n\n";
		retstring += "Hunger: " + hunger + "\n";
		retstring += "Tiredness: " + tiredness + "\n";
		retstring += "Mood: " + mood + "\n";
		retstring += "Alive: " + alive + "\n";
		retstring += "Toilet Need: " + toiletneed + "\n";
		retstring += "Weight: " + weight + "\n";
		retstring += "Sleepiness: " + sleepiness + "\n";
		retstring += "Need For Food: " + hungerNeed + "\n";
		retstring += "Roughness: " + roughness + "\n";
		retstring += "Favourite Toy: " + favtoy + "\n";
		retstring += "Favourite Food: " + favfood + "\n";		return retstring;
	}
	/*	 *Pet Status Updaters	 */
	public void feed(Food food){
		double io = food.getNutrion() * hungerNeed;
		hunger += io;
		if(hunger > 100){
			hunger = 100;
		}
		toiletneed -= food.getMeal() * 10;		if(toiletneed < 0){			toiletneed = 0;		}
	}
	public void play(Toy toy){
		mood += toy.getHappiness() / 10;		if(mood > 4){			mood = 4;		}		else if(mood < 1){			mood = 1;		}
	}
	public void sleep(){
		tiredness = 100;
	}

	public void goToToilet(){
		toiletneed = 100;
	}
	public void nextDay(){
		hunger -= 5 * hungerNeed;
		tiredness -= 5 * sleepiness;
		toiletneed -= 20;
	}
	/*
	 * Getters And Setters
	 */
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
	public void setMood(int mood) {		this.mood = mood;	}
	public boolean isAlive() {		return alive;	}
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
	public int getSleepiness() {
		return sleepiness;
	}
	public double getHungerweight() {
		return hungerNeed;
	}
	public String getFavtoy() {
		return favtoy;	}
	public double getHungerNeed() {
		return hungerNeed;
	}
	public void setHungerNeed(double hungerNeed) {
		this.hungerNeed = hungerNeed;
	}
	public int getRoughness() {
		return roughness;
	}
	public void setRoughness(int roughness) {
		this.roughness = roughness;
	}
	public String getFavfood() {
		return favfood;
	}
	public void setFavfood(String favfood) {
		this.favfood = favfood;
	}
	public void setPetname(String petname) {
		this.petname = petname;
	}
	public void setSleepiness(int sleepiness) {
		this.sleepiness = sleepiness;
	}
	public void setFavtoy(String favtoy) {
		this.favtoy = favtoy;
	}
}