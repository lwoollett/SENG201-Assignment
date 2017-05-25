package gui;

// TODO: Auto-generated Javadoc/** * The Class Toy. */public class Toy {
	/** The name. */	private String name;
	/** The price. */	private int price;
	/** The happiness. */	private int happiness;
	/** The durability. */	private int durability;

	/**	 * 	 * Instantiates a new toy.	 * 	 *	 * 	 * @param name the name	 * 	 * @param price the price	 * 	 * @param happiness the happiness	 *	 * @param name the name	 * @param price the price	 * @param happiness the happiness	 */	public Toy(String name, int price, int happiness){
		this.name = name;
		this.price = price;
		this.happiness = happiness; //Needs to be between 0-40 40 is like, giving a puppy to your girlfriend.
		this.durability = 100;
	}	/* (non-Javadoc)	 * @see java.lang.Object#toString()	 */	@Override	public String toString(){		String retstring = name + " " + durability + "%";		return retstring;	}
	/**	 * 	 * Gets the name.	 * 	 *	 * 	 * @return the name	 *	 * @return the name	 */	public String getName() {
		return name;
	}
	/**	 * 	 * Sets the name.	 * 	 *	 * 	 * @param name the new name	 *	 * @param name the new name	 */	public void setName(String name) {
		this.name = name;
	}
	/**	 * 	 * Gets the price.	 * 	 *	 * 	 * @return the price	 *	 * @return the price	 */	public int getPrice() {
		return price;
	}
	/**	 * 	 * Sets the price.	 * 	 *	 * 	 * @param price the new price	 *	 * @param price the new price	 */	public void setPrice(int price) {
		this.price = price;
	}
	/**	 * 	 * Gets the happiness.	 * 	 *	 * 	 * @return the happiness	 *	 * @return the happiness	 */	public int getHappiness() {
		return happiness;
	}
	/**	 * 	 * Sets the happiness.	 * 	 *	 * 	 * @param happiness the new happiness	 *	 * @param happiness the new happiness	 */	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}
	/**	 * 	 * Gets the durability.	 * 	 *	 * 	 * @return the durability	 *	 * @return the durability	 */	public int getDurability() {
		return durability;
	}
	/**	 * 	 * Sets the durability.	 * 	 *	 * 	 * @param durability the new durability	 *	 * @param durability the new durability	 */	public void setDurability(int durability) {
		this.durability = durability;
	}

}
