package nogui;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	Store store = new Store();
	Scanner sc = new Scanner(System.in);
	int pnum = 0;
	static ArrayList<Player> players = new ArrayList<Player>();
	ArrayList<Pet> pets = new ArrayList<Pet>();
	
	private void populatepets(){
		pets.add(new Cat("UnNamed"));
		pets.add(new Cow("UnNamed"));
		pets.add(new Dog("UnNamed"));
		pets.add(new Rabbit("UnNamed"));
		pets.add(new Rat("UnNamed"));
		pets.add(new Velociraptor("UnNamed"));
	}

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
		case 3:
			break;
		
		default:
			System.out.println("ERROR");
		}
		}
	
	private void dayLoop(Player p){
		//TODO
		/*
		 * So a day should have a few options
		 * 1. Play with a pet
		 * 2. Feed a pet
		 * 3. Go to the store to buy toys / food
		 * 4. End the day early
		 * Make sure to tell the player how many actions they have left in the day
		 * 
		 */
		System.out.println("*******************");
		System.out.println("It is now " + p.getName() + "'s turn on this day.");
		
		while(p.getActions() > 0){
				int c = 1; //This is our selection counter, we reset it when we need to count through shit.
				int selectedpetindex;
				Pet selectedpet;
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
				case 4:
					for(Pet pet : p.getPets()){
						pet.printStatus();
					}
					break;
				case 5:
					//I dunno fam, do some shit that does magic and stuff. 
					break;
				default:
					System.out.println("Fatal Error.");
				}
		}
	}
	
	public static void main(String[] args){
		System.out.println("Game Started");
		Game game = new Game();
		System.out.println("How Many Days Is The Game Gonna last?");
		int gamedays = game.getNumber(1, 31); //31 is just a random number, could be anything really.
		game.populatepets();
		game.getPlayers();
		game.getPets();
		
		for(int day=0; day < gamedays; day++){
			for(Player p : players){
				game.dayLoop(p);
			}
			System.out.println("Day " + day + " over.");
		}
	}
}
