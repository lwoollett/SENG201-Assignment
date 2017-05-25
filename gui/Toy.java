package gui;

// TODO: Auto-generated Javadoc/** * The Class Toy. */public class Toy {
	/** The name. */	private String name;
	/** The price. */	private int price;
	/** The happiness. */	private int happiness;
	/** The durability. */	private int durability;

	/**	 * Makes a new toy :o	 * @param name the name of the toy	 * @param price the price $$	 * @param happiness the happiness the toy adds	 * @param dur the durability of the toy	 */	public Toy(String name, int price, int happiness, int dur){
		this.name = name;
		this.price = price;
		this.happiness = happiness;
		this.durability = dur;
	}	/* (non-Javadoc)	 * @see java.lang.Object#toString()	 */	@Override	public String toString(){		String retstring = name + " " + durability + "%";		return retstring;	}
	/**	 * getter for the name	 * @return the name	 */	public String getName() {
		return name;
	}
	/**	 * Setter for the name	 * @param name the new name	 */	public void setName(String name) {
		this.name = name;
	}
	/**	 * Getter for the price	 * @return the price	 */	public int getPrice() {
		return price;
	}
	/**	 * Set the price	 * @param price the new price	 */	public void setPrice(int price) {
		this.price = price;		if(this.price < 0){			this.price = 1;		}
	}
	/**	 * Geter for happiness. You cant get happiness.  Only pain and assignments.	 * @return the happiness	 */	public int getHappiness() {
		return happiness;
	}
	/**	 * Set the happiness given from the toy	 * @param happiness the new happiness	 */	public void setHappiness(int happiness) {
		this.happiness = happiness;		if(this.happiness > 100){			this.happiness = 100;		}else if(this.happiness < 0){			this.happiness = 0;		}
	}
	/**	 * Get the remaining durability of the toy	 * @return the durability	 */	public int getDurability() {
		return durability;
	}
	/**	 * Set the durability of the toy once it has been used	 * @param durability the new durability	 */	public void setDurability(int durability) {
		this.durability = durability;		if(this.durability > 100){			this.durability = 100;		}else if(this.durability < 0){			this.durability = 0;		}
	}

}
