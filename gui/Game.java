package gui;

import java.util.ArrayList;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Game.
 */
public class Game {

	/** The store. */
	Store store = new Store();

	/** The sc. */
	Scanner sc = new Scanner(System.in);

	/** The pnum. */
	int pnum = 0;

	/** The players. */
	static ArrayList<Player> players = new ArrayList<Player>();

	/** The pets. */
	ArrayList<Pet> pets = new ArrayList<Pet>();

	/**
	 * Populatepets.
	 */
	private void populatepets(){
		pets.add(new Cat("UnNamed"));
		pets.add(new Cow("UnNamed"));
		pets.add(new Dog("UnNamed"));
		pets.add(new Rabbit("UnNamed"));
		pets.add(new Rat("UnNamed"));
		pets.add(new Velociraptor("UnNamed"));
	}

	/**
	 * Keeps Trying for a value between two options
	 *
	 * @param ln the lower value
	 * @param hn the higher value
	 * @return the number
	 */
	public int getNumber(int ln, int hn){
		System.out.println("Please Enter A Number Between " + ln + " and " + hn);
		int num = sc.nextInt();
		if(num > ln && num < hn){
			return num;
		}else{
			while(num < ln || num > hn){
				System.out.println("Number was not between " + ln + " and " + hn);
				System.out.println("Please Enter A Number Between " + ln + " and " + hn);
				num = sc.nextInt();
			}
			return num;
		}
	}

	/**
	 * Gets the players.
	 *
	 * @return the players
	 */
	private void getPlayers() {
		System.out.println("How Many Players: ");
		pnum = getNumber(1, 3);

		for(int i=0; i < pnum; i++){
			System.out.println("What is player " + (i + 1) + "'s name? ");
			String name = sc.next();
			boolean dupe = true;
			while(dupe){
				int samecounter = 0;
				for(Player p : players){
					if(name.equals(p.getName())){
						samecounter += 1;
						System.out.println("Name is the same as another players. Please choose another name: ");
						name = sc.next();
					}
				}
				if(samecounter == 0){
					dupe = false;
				}
			}
			players.add(new Player(name));

		}
	}

	/**
	 * Gets the pets.
	 *
	 * @return the pets
	 */
	private void getPets(){
		for(Player p : players){
			ArrayList<Pet> currentpets = new ArrayList<Pet>();

			System.out.println("How many pets for " + p.getName() + ": ");
			int petnum = getNumber(1,3);
			for(int i = 0; i < petnum; i++){
				System.out.println("Pet options are:");
				int c = 1; //Counter for which pet, relating to which option
				for(Pet option : pets){
					System.out.println(c + ". " + option.getClass().getSimpleName() + ".");
					c++;
				}
				System.out.println("Please Choose Your Pet With A Number:");
				int selected = getNumber(1, 6);
				Pet selectedpet = pets.get(selected - 1);
				System.out.println("Please Enter A Name For Your Pet: ");
				String petname = sc.next();
				selectedpet.setPetname(petname);
				System.out.println("You now have a pet named " + selectedpet.getPetname());
				currentpets.add(selectedpet);
			}
			p.setPets(currentpets);
		}
	}

	/**
	 * Feed.
	 *
	 * @param p the p
	 */
	private void feed(Player p){
		System.out.println("What pet would you like to feed?");
		ArrayList<Food> foodlist = p.getFood();

		int c = 1;
		for(Pet pet : p.getPets()){
			System.out.println(c + ". " + pet.getPetname());
			c++;
		}

		int selectedpetindex = getNumber(1, p.getPets().size());
		Pet selectedpet = p.getPets().get(selectedpetindex - 1);
		System.out.println("What food do you want to feed " + selectedpet.getPetname() + " with?");

		c = 1;
		for(Food f : foodlist){
			System.out.println(c + ". " + f.getName());
			c++;
		}

		int foodindex = getNumber(1, foodlist.size());
		Food selectedfood = foodlist.get(foodindex);

		selectedpet.feed(selectedfood);
		foodlist.remove(foodindex);
		p.setFood(foodlist);

		p.setActions(p.getActions() - 1);
	}

	/**
	 * Play.
	 *
	 * @param p the p
	 */
	private void play(Player p){
		System.out.println("What pet would you like to play with?");
		int c = 1;
		ArrayList<Toy> toys = p.getToys();

		for(Pet pet : p.getPets()){
			System.out.println(c + ". " + pet.getPetname());
			c++;
		}
		int selectedpetindex = getNumber(1, p.getPets().size());
		Pet selectedpet = p.getPets().get(selectedpetindex - 1);
		System.out.println("What toy do you want to use to play with " + selectedpet.getPetname());

		c = 1;
		for(Toy t : toys){
			System.out.println(c + ". " + t.getName());
			c++;
		}
		int toyindex = getNumber(1, toys.size());
		Toy selectedtoy = toys.get(toyindex);

		selectedpet.play(selectedtoy);
		selectedtoy.setDurability(selectedtoy.getDurability() - selectedpet.getRoughness());

		if(selectedtoy.getDurability() < 1){
			toys.remove(toyindex);
		}else{
			toys.set(toyindex, selectedtoy);
		}

		p.setToys(toys);
		p.setActions(p.getActions() - 1);
	}

	/**
	 * Store trip.
	 *
	 * @param p the p
	 */
	private void storeTrip(Player p){
		System.out.println("Welcome to the store!");
		System.out.println("Just a reminder, you have $" + p.getMoney() + " to spend!");
		System.out.println("Please Select An Option: ");
		System.out.println("1. Buy Food");
		System.out.println("2. Buy Toys");
		System.out.println("3. Leave the store");
		ArrayList<Toy> storetoys = store.getToys();
		ArrayList<Food> storefood = store.getFoods();
		int[] toyamounts = store.getToyamounts();
		int[] foodamounts = store.getFoodamounts();
		int buyoption; //The buying option
		int c; //Counter

		int selectedoption = getNumber(1, 3);
		switch(selectedoption){
		//Buy food
		case 1:
			c = 1;
			for(Food f : storefood){
				System.out.println(c + ". " + f.getName() + "\nPrice: $" + f.getValue() + " Stock: " + foodamounts[c-1]);
				System.out.println("");
				c++;
			}
			buyoption = getNumber(1, storefood.size());
			Food selectedfood = storefood.get(buyoption -1);
			if(p.getMoney() > selectedfood.getValue() && foodamounts[buyoption-1] > 0){
				p.setMoney(p.getMoney() - selectedfood.getValue());
				foodamounts[buyoption -1]--; //Take one away, as it has been sold.
				p.addFood(selectedfood);
				store.setFoodamounts(foodamounts);
			}
			break;

			//Buy toys
		case 2:
			c = 1;
			for(Toy t : storetoys){
				System.out.println(c + ". " + t.getName() + "\nPrice: $" + t.getPrice() + " Stock: " + toyamounts[c-1]);
				System.out.println("");
				c++;
			}
			buyoption = getNumber(1, storetoys.size());
			Toy selectedtoy = storetoys.get(buyoption -1);
			if(p.getMoney() > selectedtoy.getPrice() && toyamounts[buyoption-1] > 0){
				p.setMoney(p.getMoney() - selectedtoy.getPrice());
				toyamounts[buyoption -1]--; //Take one away, as it has been sold.
				p.addToy(selectedtoy);
				store.setToyamounts(toyamounts);
			}
			else{
				System.out.println("\n\n\n\n\n\nError. Either the store was out of stock for the selected product or the player was out of money.");
			}
		case 3:
			break;

		default:
			System.out.println("ERROR");
		}
	}

	/**
	 * End day.
	 *
	 * @param p the p
	 */
	private void endDay(Player p){
		p.setActions(2);
		ArrayList<Pet> pets = p.getPets();
		for(Pet pet : pets){
			pet.nextDay();
		}
		store.nextDay();
	}

	/**
	 * Day loop.
	 *
	 * @param p the p
	 */
	private void dayLoop(Player p){
		//Loop for every day.
		System.out.println("*******************");
		System.out.println("It is now " + p.getName() + "'s turn on this day.");
		while(p.getActions() > 0){
			System.out.println("Choose what you're going to do with the day.");
			System.out.println(p.getName() + " has " + p.getActions() + " actions left for the day.");
			System.out.println("1. Play with a pet.");
			System.out.println("2. Feed a pet.");
			System.out.println("3. Go to the store.");
			System.out.println("4. Print out pet status.");
			System.out.println("5. End the day early.");
			int selected = getNumber(1,5);
			switch(selected){
			//Playing with a pet.
			case 1:
				play(p);
				break;

				//Feeding a pet.
			case 2:
				feed(p);
				break;

				//Code for the store.
			case 3:
				storeTrip(p);
				break;
				//Print Pet Status
			case 4:
				for(Pet pet : p.getPets()){
					System.out.println(pet.printStatus());
				}
				break;
				//Print Player inventory.
			case 5:
				p.printInventory();
				//Finish the day early.
			case 6:
				p.setActions(0);
				break;
			default:
				System.out.println("Fatal Error.");
			}
		}
		endDay(p);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		System.out.println("Game Started");
		Game game = new Game();
		System.out.println("How Many Days Is The Game Gonna last?");
		int gamedays = game.getNumber(1, 31); //31 is just a random number, could be anything really.
		game.populatepets();
		game.getPlayers();
		game.getPets();

		for(int day=1; day < gamedays + 1; day++){
			for(Player p : players){
				game.dayLoop(p);
			}
			System.out.println("Day " + day + " over.");
		}
	}
}