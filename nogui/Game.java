package nogui;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	Scanner sc = new Scanner(System.in);
	int pnum = 0;
	ArrayList<Player> players = new ArrayList<Player>();
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
		System.out.println("Game Started");
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
	
	public static void main(String[] args){
		Game game = new Game();
		game.populatepets();
		game.getPlayers();
		game.getPets();
		
	}
	
}
