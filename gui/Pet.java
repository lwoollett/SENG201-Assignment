package gui;
// TODO: Auto-generated Javadoc/** * The Class Pet. */public class Pet {
	/** The petname. */	//Normal Vars
	private String petname;
	/** The hunger. */	private int hunger; //0-100
	/** The tiredness. */	private int tiredness; //0-100
	/** The mood. */	private int mood; //1-4? Idk Fammmmmmm
	/** The alive. */	private boolean alive = true;
	/** The toiletneed. */	private int toiletneed; //1-100
	/** The weight. */	private int weight; //ddwdwdawdawd
	/** The sleepiness. */	//Vars That Differ By Species
	private int sleepiness;
	/** The hunger need. */	private double hungerNeed;
	/** The roughness. */	private int roughness;
	/** The favtoy. */	private String favtoy;
	/** The favfood. */	private String favfood;
	/**	 * Instantiates a new pet.	 *	 * @param name the name	 */	public Pet(String name){
		petname = name;
		hunger = 100;
		tiredness = 100;
		mood = 4;
		toiletneed = 100;
		weight = 50;
	}

	/**	 * Prints the status.	 *	 * @return the string	 */	public String printStatus(){		String retstring = "";		retstring += "Pet Name: " + petname + "\n\n";
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
	}	/**	 * Feed.	 *	 * @param food the food	 */	public void feed(Food food){
		double io = food.getNutrion() * hungerNeed;
		hunger += io;
		if(hunger > 100){
			hunger = 100;
		}
		toiletneed -= food.getMeal() * 10;		if(toiletneed < 0){			toiletneed = 0;		}
	}
	/**	 * Play.	 *	 * @param toy the toy	 */	public void play(Toy toy){
		mood += toy.getHappiness() / 10;		if(mood > 4){			mood = 4;		}		else if(mood < 1){			mood = 1;		}
	}
	/**	 * Sleep.	 */	public void sleep(){
		tiredness = 100;
	}

	/**	 * Go to toilet.	 */	public void goToToilet(){
		toiletneed = 100;
	}
	/**	 * Next day.	 */	public void nextDay(){
		hunger -= 5 * hungerNeed;
		tiredness -= 5 * sleepiness;
		toiletneed -= 20;
	}
	/*
	 * Getters And Setters
	 */
	/**	 * Gets the petname.	 *	 * @return the petname	 */	public String getPetname() {
		return petname;
	}
	/**	 * Gets the hunger.	 *	 * @return the hunger	 */	public int getHunger() {
		return hunger;
	}
	/**	 * Sets the hunger.	 *	 * @param hunger the new hunger	 */	public void setHunger(int hunger) {
		this.hunger = hunger;
	}
	/**	 * Gets the tiredness.	 *	 * @return the tiredness	 */	public int getTiredness() {
		return tiredness;
	}
	/**	 * Sets the tiredness.	 *	 * @param tiredness the new tiredness	 */	public void setTiredness(int tiredness) {
		this.tiredness = tiredness;
	}
	/**	 * Gets the mood.	 *	 * @return the mood	 */	public int getMood() {
		return mood;
	}
	/**	 * Sets the mood.	 *	 * @param mood the new mood	 */	public void setMood(int mood) {		this.mood = mood;	}
	/**	 * Checks if is alive.	 *	 * @return true, if is alive	 */	public boolean isAlive() {		return alive;	}
	/**	 * Sets the alive.	 *	 * @param alive the new alive	 */	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	/**	 * Gets the toiletneed.	 *	 * @return the toiletneed	 */	public int getToiletneed() {
		return toiletneed;
	}
	/**	 * Sets the toiletneed.	 *	 * @param toiletneed the new toiletneed	 */	public void setToiletneed(int toiletneed) {
		this.toiletneed = toiletneed;
	}
	/**	 * Gets the weight.	 *	 * @return the weight	 */	public int getWeight() {
		return weight;
	}
	/**	 * Sets the weight.	 *	 * @param weight the new weight	 */	public void setWeight(int weight) {
		this.weight = weight;
	}
	/**	 * Gets the sleepiness.	 *	 * @return the sleepiness	 */	public int getSleepiness() {
		return sleepiness;
	}
	/**	 * Gets the hungerweight.	 *	 * @return the hungerweight	 */	public double getHungerweight() {
		return hungerNeed;
	}
	/**	 * Gets the favtoy.	 *	 * @return the favtoy	 */	public String getFavtoy() {
		return favtoy;	}
	/**	 * Gets the hunger need.	 *	 * @return the hunger need	 */	public double getHungerNeed() {
		return hungerNeed;
	}
	/**	 * Sets the hunger need.	 *	 * @param hungerNeed the new hunger need	 */	public void setHungerNeed(double hungerNeed) {
		this.hungerNeed = hungerNeed;
	}
	/**	 * Gets the roughness.	 *	 * @return the roughness	 */	public int getRoughness() {
		return roughness;
	}
	/**	 * Sets the roughness.	 *	 * @param roughness the new roughness	 */	public void setRoughness(int roughness) {
		this.roughness = roughness;
	}
	/**	 * Gets the favfood.	 *	 * @return the favfood	 */	public String getFavfood() {
		return favfood;
	}
	/**	 * Sets the favfood.	 *	 * @param favfood the new favfood	 */	public void setFavfood(String favfood) {
		this.favfood = favfood;
	}
	/**	 * Sets the petname.	 *	 * @param petname the new petname	 */	public void setPetname(String petname) {
		this.petname = petname;
	}
	/**	 * Sets the sleepiness.	 *	 * @param sleepiness the new sleepiness	 */	public void setSleepiness(int sleepiness) {
		this.sleepiness = sleepiness;
	}
	/**	 * Sets the favtoy.	 *	 * @param favtoy the new favtoy	 */	public void setFavtoy(String favtoy) {
		this.favtoy = favtoy;
	}
}