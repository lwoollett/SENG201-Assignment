package gui;/** * The Pet Class. * All of the indivual pets inherit from this class. * We have this so we can have everything in the same lists. */public class Pet {	//Normal Vars
	private String petname;	private int hunger; //0-100	private int tiredness; //0-100	private int mood; //1-4? Idk Fammmmmmm
	private boolean alive = true;	private boolean issick = false;
	private int toiletneed; //1-100
	private int weight; //ddwdwdawdawd
	//Vars That Differ By Species
	private int sleepiness;
	private double hungerNeed;
	private int roughness;
	private String favtoy;
	private String favfood;
	/**	 * Makes a new pet :o	 * @param name the name	 */	public Pet(String name){
		petname = name;
		hunger = 100;
		tiredness = 100;
		mood = 4;
		toiletneed = 100;
		weight = 100;
	}

	/**	 * Prints the status.	 *	 * @return the status string.	 */	public String printStatus(){		String retstring = "";		if(alive){			retstring += "Pet Name: " + petname + "\n\n";			retstring += "Hunger: " + hunger + "\n";			retstring += "Tiredness: " + tiredness + "\n";			retstring += "Mood: " + this.getMoodString() + "\n";			retstring += "Alive: " + alive + "\n";			retstring += "Sick: " + issick + "\n";			retstring += "Toilet Need: " + toiletneed + "\n";			retstring += "Weight: " + weight + "\n";			retstring += "Sleepiness: " + sleepiness + "\n";			retstring += "Need For Food: " + hungerNeed + "\n";			retstring += "Roughness: " + roughness + "\n";			retstring += "Favourite Toy: " + favtoy + "\n";			retstring += "Favourite Food: " + favfood + "\n";		}else{			retstring = "Pet\nIs\nDead\nYou\nAre\nA\nHorrible\nOwner.";		}		return retstring;
	}	/**	 * Returns a score.	 * @return the score to be added to the player score.	 */	public int retScore(){		int petScore = 0;		if(alive){			petScore += hunger;			petScore += tiredness;			petScore += mood * 10;			petScore += toiletneed;			petScore += weight;			return petScore;		}else{			return petScore;		}	}	/**	 * Feed the pet, given a food.	 * @param food to be fed to the pet.	 */	public void feed(Food food){		if(food.getName().equals(favfood)){			mood += 1;			if(mood > 4){				mood = 4;			}		}		if(food.getTastiness() == 0){			if(favfood.equals(food.getName())){				//Its fine, we're just wanting to add a detriment for things eating humans			}else{				mood = 0;			}		}
		hunger += food.getNutrition();
		if(hunger > 100){
			hunger = 100;
		}		weight += food.getMeal() * 10;		if(weight > 150){			mood -= 2;		}else if(weight < 50){			mood -= 2;		}
		toiletneed -= food.getMeal() * 10;		if(toiletneed < 0){			toiletneed = 0;		}
	}
	/**	 * Play with a given toy	 * @param toy, the toy to be played with.	 */	public void play(Toy toy){		if(toy.getName().equals(favtoy)){			mood += toy.getHappiness() *2;			if(mood > 4){				mood = 4;			}		}
		mood += toy.getHappiness();		if(mood > 4){			mood = 4;		}		//Unlikely as heck		else if(mood < 0){			mood = 0;		}
	}
	/**	 * Sleep.	 */	public void sleep(){
		tiredness = 100;
	}

	/**	 * Go to the toilet.	 */	public void goToToilet(){
		toiletneed = 100;
	}
	/**	 * Next day.	 */	public void nextDay(){		if(issick){			hunger -= 5 * (hungerNeed*2);			tiredness -= 5 * (sleepiness*2);			toiletneed -= 40;		}else{
			hunger -= 5 * hungerNeed;
			tiredness -= 5 * sleepiness;
			toiletneed -= 20;		}		if(hunger <= 0){			hunger = 0;			alive = false;			mood = -10;		}if(tiredness <= 0){			tiredness = 0;			alive = false;			mood = -10;		}if(toiletneed <= 0){			toiletneed = 0;			alive = false;			mood = -10;		}
	}
	/*
	 * Getters And Setters
	 */
	/**	 * gets pet name	 * @return the petname	 */	public String getPetname() {
		return petname;
	}
	/**	 * Gets hunger.	 * @return the hunger	 */	public int getHunger() {
		return hunger;
	}
	/**	 * 	sets hunger	 * @param hunger the new hunger	 */	public void setHunger(int hunger) {
		this.hunger = hunger;		if(this.hunger > 100){			this.hunger = 100;		}else if(this.hunger < 0){			this.hunger = 0;			this.alive = false;		}
	}
	/**	 * gets tiredness	 *	 * @return the tiredness	 */	public int getTiredness() {
		return tiredness;
	}
	/**	 * sets tiredness	 * @param tiredness the new tiredness	 */	public void setTiredness(int tiredness) {
		this.tiredness = tiredness;		if(this.tiredness > 100){			this.tiredness = 100;		}else if(this.tiredness < 0){			this.tiredness = 0;			this.alive = false;		}
	}
	/**	 * gets mood	 *	 * @return the mood	 */	public int getMood() {
		return mood;
	}
	/**	 * sets mood	 * @param mood the new mood	 */	public void setMood(int mood) {		this.mood = mood;		if(this.mood < 0){			this.mood = 0;		}else if(this.mood > 4){			this.mood = 4;		}	}
	/**	 * checks if pet is alive	 *	 * @return Pets alive status	 */	public boolean isAlive() {		return alive;	}
	/**	 * sets if pet is alive or not	 * @param alive is a bool true or false	 */	public void setAlive(boolean alive) {
		this.alive = alive;
	}	/**	 * returns sickness	 *	 * @return the sickness	 */	public boolean getSickness(){		return issick;	}	/**	 * sets if the pet is sick or not	 * @param sickness bool true / false	 */	public void setSickness(boolean sickness){		issick = sickness;	}
	/**	 * Gets the toiletneed.	 *	 * @return the toiletneed	 */	public int getToiletneed() {
		return toiletneed;
	}
	/**	 * Sets toiletneed	 * @param toiletneed the new toiletneed	 */	public void setToiletneed(int toiletneed) {
		this.toiletneed = toiletneed;		if(this.toiletneed > 100){			this.toiletneed = 100;		}else if(this.toiletneed < 0){			this.toiletneed = 0;			this.alive = false;		}
	}
	/**	 * gets weight	 * @return the weight	 */	public int getWeight() {
		return weight;
	}
	/**	 * sets weight*	 * @param weight the new weight	 */	public void setWeight(int weight) {
		this.weight = weight;
	}
	/**	 * get sleepiness	 * @return the sleepiness	 */	public int getSleepiness() {
		return sleepiness;
	}
	/**	 * gets hunger need	 * @return the hungerneed	 */	public double getHungerweight() {
		return hungerNeed;
	}
	/**	 * Get's pet favourite toy	 * @return Their favourite toy	 */	public String getFavtoy() {
		return favtoy;	}
	/**	 * returns hunger need	 * @return the hunger need	 */	public double getHungerNeed() {
		return hungerNeed;
	}
	/**	 * Sets hunger Need	 * @param hungerNeed the new hunger need	 */	public void setHungerNeed(double hungerNeed) {
		this.hungerNeed = hungerNeed;
	}
	/**	 * gets roughness	 * @return the roughness	 */	public int getRoughness() {
		return roughness;
	}
	/**	 * Sets roughness	 * @param roughness the new roughness	 */	public void setRoughness(int roughness) {
		this.roughness = roughness;
	}	/**	 * gets mood string	 * @return the mood string	 */	public String getMoodString(){		String retstring = "";		switch(mood){		case 0:			retstring = "Beyond Unhappy";			break;		case 1:			retstring = "Not Very Happy";			break;		case 2:			retstring = "Averagely Happy";			break;		case 3:			retstring = "Happy";			break;		case 4:			retstring = "Extremely Happy";			break;		default:			retstring = "Unexpected Mood";			break;		}		return retstring;	}
	/**	 * Gets favourite food	 * @return the favfood	 */	public String getFavfood() {
		return favfood;
	}
	/**	 * Sets the favourite food	 * @param favfood the new favfood	 */	public void setFavfood(String favfood) {
		this.favfood = favfood;
	}
	/**	 * Sets the pet's name	 * @param petname the new petname	 */	public void setPetname(String petname) {
		this.petname = petname;
	}
	/**	 * Sets pets sleepiness	 * @param sleepiness the new sleepiness	 */	public void setSleepiness(int sleepiness) {
		this.sleepiness = sleepiness;
	}
	/**	 * Sets the pets favourite toy	 * @param favtoy the new favtoy	 */	public void setFavtoy(String favtoy) {
		this.favtoy = favtoy;
	}
}