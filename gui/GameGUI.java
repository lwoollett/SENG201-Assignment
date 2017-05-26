package gui;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;


/**
 * Main Class of the game GUI
 */
public class GameGUI {
	Random rand = new Random(); //Random for random events
	public static Store store = new Store();
	int pnum = 0; //Number of players
	int maxdays = 0;
	int day = 1;
	Player currplayer; //Current player
	public static int pcounter = 0; //Player counter
	public static ArrayList<Player> players = new ArrayList<>();
	ArrayList<Pet> pets = new ArrayList<>();

	/**
	 * Populates the pet arraylist.
	 */
	private void populatepets(){
		pets.add(new Cat("UnNamed"));
		pets.add(new Cow("UnNamed"));
		pets.add(new Dog("UnNamed"));
		pets.add(new Rabbit("UnNamed"));
		pets.add(new Rat("UnNamed"));
		pets.add(new Velociraptor("UnNamed"));
	}

	private JFrame frmVirtualPets; //Main frame

	/**
	 * Launch the application.
	 *
	 * @param args Args arent used
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					GameGUI window = new GameGUI();
					window.frmVirtualPets.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameGUI() {
		populatepets(); //Put some pets in the pets array
		playgame();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void playgame() {
		frmVirtualPets = new JFrame();
		frmVirtualPets.setTitle("Virtual Pets");
		frmVirtualPets.setBounds(100, 100, 653, 549);
		frmVirtualPets.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVirtualPets.getContentPane().setLayout(null);


		Object[] options = {"1", "2", "3"}; //Selection options for the popup

		while(pnum == 0){ //Keep looping so we get a actual number
			pnum = 1 + JOptionPane.showOptionDialog(frmVirtualPets,
					"Please Select The Number Of Players", //Label
					"Select # Of Players", //Window label
					JOptionPane.YES_NO_CANCEL_OPTION, //Type of optionpane
					JOptionPane.QUESTION_MESSAGE, //
					null, //To use a custom image or not
					options, //Options for buttons
					options[2]);
		}


		while(maxdays == 0){ //Same thing for getting the number of days.
			String daystr = (String)JOptionPane.showInputDialog(
					frmVirtualPets,
					"How Many Days?",
					"Day Selection",
					JOptionPane.PLAIN_MESSAGE,
					null, //Icon
					null, //To use a list or just text box
					"29" //Default value
					);
			try{ //This is purely to convert a text box into a int
				maxdays = Integer.parseInt(daystr);
			}catch(Exception e){
				//User has entered something thats not a int. thats cool, we'll just loop again
				maxdays = 0;
			}
		}

		//Counter for player, then pets.
		//The fuck is this spaghetti code??
		//TODO Make into actual code

		Object[] petobjects = {"Cat", "Cow", "Dog", "Rabbit", "Rat", "Velociraptor"}; //Need a object array to put into dialougbox
		ArrayList<String> petstrings = new ArrayList<>(); //The strings for the objects
		petstrings.add("Cat");petstrings.add("Cow");petstrings.add("Dog");petstrings.add("Rabbit");petstrings.add("Rat");petstrings.add("Velociraptor");

		for(int i = 1; i < pnum + 1; i++){ //Getting player name
			String playername = (String)JOptionPane.showInputDialog(
					frmVirtualPets,
					"What is player " + i + "'s name?",
					"Player Naming",
					JOptionPane.PLAIN_MESSAGE,
					null, //Icon
					null, //To use a list or just text box
					"Player " + i
					);

			boolean playerdouble = false; //If player is a double up
			for(Player p: players){
				if(playername.equals(p.getName())){
					i--;
					playerdouble = true;
					JOptionPane.showMessageDialog(frmVirtualPets, "You cannot enter a duplicate name."); //Simple popup
				}
			}
			if(playerdouble == false){ //Else if it isnt a double up
				players.add(new Player(playername)); //Add the player
				int val = 0; //Number of pets currently added to the player
				while(val != -1 && players.get(i-1).getPets().size() != 3){ //While the box isnt in a exited state and the player has less than 4 pets...
					String retPet = (String)JOptionPane.showInputDialog(
							frmVirtualPets,
							"Select Cancel To Stop Adding Pets",
							"Select A Pet",
							JOptionPane.PLAIN_MESSAGE,
							null,
							petobjects,
							petobjects[0]);


					val = petstrings.indexOf(retPet); //Get the index of the selected pet
					ArrayList<Pet> ppets = players.get(i-1).getPets();
					if(val == -1 && players.get(i-1).getPets().size() == 0){
						val = 0;
					}else if(val != -1){
						boolean petdouble = true; //Checking for pet name double ups
						while(petdouble){
							Pet p = pets.get(val);
							String petname = (String)JOptionPane.showInputDialog(
									frmVirtualPets,
									"Name your new " + retPet,
									"Pet Naming",
									JOptionPane.PLAIN_MESSAGE,
									null, //Icon
									null, //To use a list or just text box
									""
									);

							petdouble = false; //Double up checking. Apparently == does not work with strings.
							if(petname == null){
								petdouble = true;
							}else{
								for(Pet pet:ppets){
									if(pet.getPetname().equals(petname)){
										petdouble = true;
										JOptionPane.showMessageDialog(frmVirtualPets, "You cannot enter a duplicate name.");
									}
								}
								if(petdouble == false){
									if(petname.equals(null)){
										p.setPetname("UnNamed Pet");
									}else{
										p.setPetname(petname);
									}
									ppets.add(p);
									players.get(i-1).setPets(ppets);
								}
							}
							/*TODO:
							 * Fix bug with null pet names and iteration
							 */
						}
					}
				}
			}
		}
		//Create our panels
		JPanel nav_panel = new JPanel();
		nav_panel.setBounds(0, 0, 113, 255);
		nav_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frmVirtualPets.getContentPane().add(nav_panel);

		JPanel status_panel = new JPanel();
		status_panel.setBounds(0, 255, 113, 255);
		status_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frmVirtualPets.getContentPane().add(status_panel);

		JPanel pet1_panel = new JPanel();
		pet1_panel.setBounds(112, 0, 255, 255);
		pet1_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frmVirtualPets.getContentPane().add(pet1_panel);


		JPanel pet2_panel = new JPanel();
		pet2_panel.setBounds(112, 255, 255, 255);
		frmVirtualPets.getContentPane().add(pet2_panel);
		pet2_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));


		JPanel pet3_panel = new JPanel();
		pet3_panel.setBounds(372, 255, 255, 255);
		pet3_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frmVirtualPets.getContentPane().add(pet3_panel);

		JPanel inventory_panel = new JPanel();
		inventory_panel.setBounds(372, 0, 255, 255);
		inventory_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frmVirtualPets.getContentPane().add(inventory_panel);


		//Text Panes for pet status.
		//Pretty much the displays for everything
		JTextPane pet1_text = new JTextPane();
		pet1_panel.add(pet1_text);

		JTextPane pet2_text = new JTextPane();
		pet2_panel.add(pet2_text);

		JTextPane pet3_text = new JTextPane();
		pet3_panel.add(pet3_text);

		JLabel lblPlayerName = new JLabel("Player Name");
		status_panel.add(lblPlayerName);

		JLabel lblPlayerMoney = new JLabel("Player Money");
		status_panel.add(lblPlayerMoney);

		JLabel lblPlayerScore = new JLabel("Player Score");
		status_panel.add(lblPlayerScore);

		JLabel lblActionsLeftFor = new JLabel("Actions Left");
		status_panel.add(lblActionsLeftFor);

		JLabel lblDaysPassed = new JLabel("Days Passed");
		status_panel.add(lblDaysPassed);


		//Player inventory lists
		DefaultListModel<String> toys_model = new DefaultListModel<>();
		toys_model.addElement("Toy: Durability");

		DefaultListModel<String> food_model = new DefaultListModel<>();
		food_model.addElement("Food: Nutrition");

		JList<String> list_toys = new JList<>(toys_model);
		inventory_panel.add(list_toys);

		JList<String> list_food = new JList<>(food_model);
		inventory_panel.add(list_food);


		//Feeding the pets
		JButton btnFeed = new JButton("Feed");
		btnFeed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(currplayer.getFood().size() == 0){ //If player has no food
					JOptionPane.showMessageDialog(frmVirtualPets, "Player " + currplayer.getName() + " has no food.");
				}else if(currplayer.getActions() == 0){ //Or if player has no actions left
					JOptionPane.showMessageDialog(frmVirtualPets, "Player " + currplayer.getName() + " is out of actions.");
				}else{
					ArrayList<Pet> pets = currplayer.getPets();
					ArrayList<Food> foods = currplayer.getFood();

					JComboBox<String> selectedPet = new JComboBox<>(); //Combo box for selecting pets
					for(Pet p:pets){
						if(p.isAlive()){ //We dont want to feed a dead pet, what a waste of good food.
							selectedPet.addItem(p.getPetname());
						} //Iterate through all the players pets and put them in the combobox
					}

					JComboBox<String> selectedFood = new JComboBox<>();
					for(Food f:foods){
						selectedFood.addItem(f.getName());
					}//Same thing for food.

					final JComponent[] things = new JComponent[] {
							new JLabel("Pet To Feed"),
							selectedPet,
							new JLabel("Food To Use"),
							selectedFood
					}; //This is a array for the components of the dialogbox

					int result = JOptionPane.showConfirmDialog(null, things, "Feed Pets", JOptionPane.PLAIN_MESSAGE); //Show the pane
					if (result == JOptionPane.OK_OPTION) { //If the player clicked ok

						//get selected pet and food, and then feed the pet
						Pet setPet = pets.get(selectedPet.getSelectedIndex());
						Food setFood = foods.get(selectedFood.getSelectedIndex());
						setPet.feed(setFood);
						foods.remove(setFood);
						//Update the player's inventory
						currplayer.setFood(foods);
						currplayer.setActions(currplayer.getActions() - 1);

						//Update the label
						lblActionsLeftFor.setText("Actions Left: " + currplayer.getActions());


						//Update the pet text
						pet1_text.setText(currplayer.getPets().get(0).printStatus());
						try{
							pet2_text.setText(currplayer.getPets().get(1).printStatus());
						}catch(IndexOutOfBoundsException e){
							pet2_text.setText("No Second Pet");
						}
						try{
							pet3_text.setText(currplayer.getPets().get(2).printStatus());
						}catch(IndexOutOfBoundsException e){
							pet3_text.setText("No Third Pet");
						}


						//Update the inventory panel
						food_model.clear();
						food_model.addElement("Food: Nutrition");
						for(Food f:foods){
							food_model.addElement(f.toString());
						}
					}
				}
			}
		});
		nav_panel.add(btnFeed);

		JButton btnFoodStore = new JButton("Food Store");
		btnFoodStore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				boolean running = true;
				while(running){ //So that we can meet the requirement " Be able to purchase multiple objects at a time without leaving the store. "
					ArrayList<Food> foods = store.getFoods();
					int c = 0;
					JComboBox<String> selectedFood = new JComboBox<>();
					for(Food f: foods){
						if(store.getFoodamounts()[c] < 1){
							//Nope, food is out of stock
						}else{
							//Add the food
							selectedFood.addItem(f.getName() + ": $" + f.getValue() + " Stock: " + store.getFoodamounts()[c]
									+ " Nutrition: " + f.getNutrition() + " Meal Size: " + f.getMeal());
							c++;
						}
					}
					final JComponent[] things = new JComponent[] {
							new JLabel("Food To Buy:"),
							selectedFood};

					int result = JOptionPane.showConfirmDialog(null, things, "Player Has $" + currplayer.getMoney(), JOptionPane.OK_CANCEL_OPTION);
					if (result == JOptionPane.OK_OPTION) {
						int foodindex = selectedFood.getSelectedIndex();
						if(currplayer.getMoney() >= foods.get(foodindex).getValue()){ //Check if the player has enough money
							ArrayList<Food> prevfood = currplayer.getFood();
							prevfood.add(foods.get(foodindex));
							currplayer.setMoney(currplayer.getMoney() - foods.get(foodindex).getValue()); //Set the players money
							currplayer.setFood(prevfood);

							int[] amounts = store.getFoodamounts();
							amounts[foodindex] = amounts[foodindex] - 1; //Remove one from the store inv
							store.setFoodamounts(amounts);

							lblPlayerMoney.setText("Money: $" + currplayer.getMoney()); //Sets the label for player money

							food_model.clear(); //Sets the inventory display
							food_model.addElement("Food: Nutrition");
							for(Food f:prevfood){
								food_model.addElement(f.toString());
							}

						}else{
							//Shows error message if player could not afford
							JOptionPane.showMessageDialog(frmVirtualPets, "Player " + currplayer.getName() + " does not  have enough money to purchase that.");
						}
					}
					else if(result == JOptionPane.CLOSED_OPTION || result == JOptionPane.CANCEL_OPTION){
						running = false;
					}
				}
			}
		});

		nav_panel.add(btnFoodStore);

		JButton btnToyStore = new JButton("Toy Store");
		btnToyStore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				boolean running = true;
				while(running){
					ArrayList<Toy> toys = store.getToys();
					JComboBox<String> selectedToy = new JComboBox<>();
					int c = 0;
					for(Toy t : toys){
						if(store.getToyamounts()[c] < 1){
							//Nope, food is out of stock
						}else{
							selectedToy.addItem(t.getName() + ": $" + t.getPrice() + " Stock: " + store.getToyamounts()[c] +
									" Happiness: " + t.getHappiness() + " Base Durability: " + t.getDurability());
							c++;
						}
					}
					final JComponent[] things = new JComponent[] {
							new JLabel("Toy To Buy:"),
							selectedToy};

					int result = JOptionPane.showConfirmDialog(null, things, "Player Has $" + currplayer.getMoney(), JOptionPane.OK_CANCEL_OPTION);
					if (result == JOptionPane.OK_OPTION) {
						int toyindex = selectedToy.getSelectedIndex();
						if(currplayer.getMoney() >= toys.get(toyindex).getPrice()){
							ArrayList<Toy> prevtoys = currplayer.getToys();
							prevtoys.add(toys.get(toyindex));
							currplayer.setMoney(currplayer.getMoney() - toys.get(toyindex).getPrice());
							currplayer.setToys(prevtoys);

							lblPlayerMoney.setText("Money: $" + currplayer.getMoney());

							int[] amounts = store.getToyamounts();
							amounts[toyindex] = amounts[toyindex] - 1; //Remove one from the store inv
							store.setFoodamounts(amounts);

							toys_model.clear();
							toys_model.addElement("Toy: Durability");
							for(Toy t: prevtoys){
								toys_model.addElement(t.toString());
							}
						}else{
							//Shows error message if player could not afford
							JOptionPane.showMessageDialog(frmVirtualPets, "Player " + currplayer.getName() + " does not  have enough money to purchase that.");
						}
					}
					else if(result == JOptionPane.CLOSED_OPTION || result == JOptionPane.CANCEL_OPTION){
						running = false;
					}
				}
			}
		});
		nav_panel.add(btnToyStore);

		JButton btnPlay = new JButton("Play");
		btnPlay.addMouseListener(new MouseAdapter() { //Play with a pet and a toy
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(currplayer.getToys().size() == 0){
					JOptionPane.showMessageDialog(frmVirtualPets, "Player " + currplayer.getName() + " has no toys.");
				}else if(currplayer.getActions() == 0){
					JOptionPane.showMessageDialog(frmVirtualPets, "Player " + currplayer.getName() + " is out of actions.");
				}else{
					ArrayList<Pet> pets = currplayer.getPets();
					ArrayList<Toy> toys = currplayer.getToys();

					JComboBox<String> selectedPet = new JComboBox<>();
					for(Pet p:currplayer.getPets()){
						if(p.isAlive()){
							selectedPet.addItem(p.getPetname()); //Only add the pet to the combo box if they're alive
						}
					}

					JComboBox<String> selectedToy = new JComboBox<>();
					for(Toy t: toys){
						selectedToy.addItem(t.getName());
					}
					final JComponent[] things = new JComponent[] {
							new JLabel("Pet To Play With"),
							selectedPet,
							new JLabel("Toy To Use"),
							selectedToy
					};
					//All this is practially identical to the food
					int result = JOptionPane.showConfirmDialog(null, things, "Play With Pet", JOptionPane.PLAIN_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {
						Pet setPet = pets.get(selectedPet.getSelectedIndex());
						Toy setToy = toys.get(selectedToy.getSelectedIndex());
						setPet.play(setToy);
						int dur = setToy.getDurability();
						if(dur - setPet.getRoughness() < 1){
							toys.remove(setToy);
						}else{
							setToy.setDurability(dur - setPet.getRoughness());
							toys.remove(setToy);
							toys.add(setToy);
						}

						currplayer.setActions(currplayer.getActions() - 1);
						lblActionsLeftFor.setText("Actions Left: " + currplayer.getActions());

						pet1_text.setText(currplayer.getPets().get(0).printStatus());
						try{
							pet2_text.setText(currplayer.getPets().get(1).printStatus());
						}catch(IndexOutOfBoundsException e){
							pet2_text.setText("No Second Pet");
						}
						try{
							pet3_text.setText(currplayer.getPets().get(2).printStatus());
						}catch(IndexOutOfBoundsException e){
							pet3_text.setText("No Third Pet");
						}

						currplayer.setToys(toys); //Update the inventory display
						toys_model.clear();
						toys_model.addElement("Toy: Durability");
						for(Toy t: toys){
							toys_model.addElement(t.toString());
						}
					}
				}
			}
		});

		nav_panel.add(btnPlay);

		JButton btnGoToilet = new JButton("Toilet");
		btnGoToilet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(currplayer.getActions() == 0){ //Always check player actions
					JOptionPane.showMessageDialog(frmVirtualPets, "Player " + currplayer.getName() + " is out of actions.");
				}else{
					ArrayList<Pet> pets = currplayer.getPets();
					JComboBox<String> selectedPet = new JComboBox<>();
					for(Pet p:currplayer.getPets()){
						if(p.isAlive()){
							selectedPet.addItem(p.getPetname()); //Pet's gotta be alive
						}
					}

					final JComponent[] things = new JComponent[] {
							new JLabel("Pet To Send To Toilet:"),
							selectedPet //Wow a array that contains components :O
					};

					int result = JOptionPane.showConfirmDialog(null, things, "Sending Pet To Toilet", JOptionPane.PLAIN_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {
						Pet setPet = pets.get(selectedPet.getSelectedIndex());
						setPet.goToToilet(); //Send the pet to the toilet
					}


					//Update the pet displays
					currplayer.setActions(currplayer.getActions() - 1);
					lblActionsLeftFor.setText("Actions Left: " + currplayer.getActions());
					pet1_text.setText(currplayer.getPets().get(0).printStatus());
					try{
						pet2_text.setText(currplayer.getPets().get(1).printStatus());
					}catch(IndexOutOfBoundsException e){
						pet2_text.setText("No Second Pet");
					}
					try{
						pet3_text.setText(currplayer.getPets().get(2).printStatus());
					}catch(IndexOutOfBoundsException e){
						pet3_text.setText("No Third Pet");
					}
				}
			}
		});
		nav_panel.add(btnGoToilet);

		JButton btnSleep = new JButton("Sleep");
		btnSleep.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(currplayer.getActions() == 0){
					JOptionPane.showMessageDialog(frmVirtualPets, "Player " + currplayer.getName() + " is out of actions.");
				}else{
					ArrayList<Pet> pets = currplayer.getPets();
					JComboBox<String> selectedPet = new JComboBox<>();
					for(Pet p:currplayer.getPets()){
						if(p.isAlive()){
							selectedPet.addItem(p.getPetname());
						}
					}

					final JComponent[] things = new JComponent[] {
							new JLabel("Pet To Send To Sleep:"),
							selectedPet
					};

					int result = JOptionPane.showConfirmDialog(null, things, "Sending Pet To Sleep", JOptionPane.PLAIN_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {
						Pet setPet = pets.get(selectedPet.getSelectedIndex());
						setPet.sleep(); //Send the pet to sleep
					}

					//Update the pet displays
					currplayer.setActions(currplayer.getActions() - 1);
					lblActionsLeftFor.setText("Actions Left: " + currplayer.getActions());
					pet1_text.setText(currplayer.getPets().get(0).printStatus());
					try{
						pet2_text.setText(currplayer.getPets().get(1).printStatus());
					}catch(IndexOutOfBoundsException e){
						pet2_text.setText("No Second Pet");
					}
					try{
						pet3_text.setText(currplayer.getPets().get(2).printStatus());
					}catch(IndexOutOfBoundsException e){
						pet3_text.setText("No Third Pet");
					}
				}
			}
		});
		nav_panel.add(btnSleep);

		JButton btnHelp = new JButton("Help");
		btnHelp.addMouseListener(new MouseAdapter() { //Literally a display box that shows a wall of text
			@Override
			public void mouseReleased(MouseEvent arg0) {
				String helpstring = " Players can now choose from several options for their pets on the left side of the screen.\n"
						+ "They can buy toys and food from the respective stores.\n"
						+ "Interactive options are: Feed pet with food, play with the pet using a toy, send pet to sleep or toilet.\n"
						+ "Once the player has used both of their actions they must click the ‘End Day’ button.\n"
						+ "Player scores are calculated from the pet stats.\n"
						+ "Once the end day is reached, all of the players scores will be shown on the screen.";
				JOptionPane.showMessageDialog(frmVirtualPets, helpstring);
			}
		});
		nav_panel.add(btnHelp);


		JButton btnEndDay = new JButton("End Day");
		btnEndDay.addMouseListener(new MouseAdapter() { //oh boy the end day loop!
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(day == maxdays && pcounter == players.size()-1){ //if the game is actually over
					String gamestring = "Game Over. Player Scores:\n";
					for(Player p:players){
						p.nextDay(); //Make sure the player gets their last day of score
						gamestring += "\n Player: " + p.getName() + "'s Score: " + p.getScore(); //Add players to a string
					} //Put it in a dialog yay.
					JOptionPane.showMessageDialog(frmVirtualPets, gamestring);
					frmVirtualPets.dispose(); //GOODBYE WORLD
				}

				pcounter += 1;
				int n = rand.nextInt(100) + 1; //Random events
				if(n == 13 || n == 99){ // 2/100 chance
					ArrayList<Pet> pets = currplayer.getPets();
					int index = rand.nextInt(pets.size());
					Pet randompet = pets.get(index);
					int result = JOptionPane.showConfirmDialog(null, "Uh oh, " + randompet.getPetname() +
							" has started misbehaving!\n You can correct this with punishment but it will drop the pet's mood.\nHit Ok to punish your pet.",
							"Random Event", JOptionPane.OK_CANCEL_OPTION);
					if(result == JOptionPane.OK_OPTION){
						randompet.setMood(randompet.getMood() - 2);
					}else{
						randompet.setRoughness(rand.nextInt(100) + 50); //Screw up the pet majorly
						randompet.setTiredness(rand.nextInt(10) + 5); //Small chance to be a bonus
						randompet.setSleepiness(rand.nextInt(10) + 5);
						randompet.setMood(4);
					}
					pets.set(index, randompet);
				}else if(n == 63){ //1/100 chance
					ArrayList<Pet> pets = currplayer.getPets();
					int index = rand.nextInt(pets.size());
					Pet randompet = pets.get(index);
					int result = JOptionPane.showConfirmDialog(null, "Uh oh, " + randompet.getPetname() +
							" has fallen sick.\n Click ok to pay $200 to send the pet to get treatment. " +
							"Player Has $" + currplayer.getMoney(), "Random Event", JOptionPane.OK_CANCEL_OPTION);
					if(result == JOptionPane.OK_OPTION){ //Money exortion
						if(currplayer.getMoney() - 200 < 0){
							JOptionPane.showMessageDialog(frmVirtualPets, "Not enough money to purchase this."); //Rest in peace
							randompet.setSickness(true);
						}else{
							currplayer.setMoney(currplayer.getMoney() - 200);
							randompet.setMood(randompet.getMood() + 1);
						}
					}else{
						randompet.setSickness(true);
					}
					pets.set(index, randompet);
				}else if(n == 22){ //Yay a good thing happening, like being done with this assignment!
					currplayer.setScore(currplayer.getScore() + 1000);
					JOptionPane.showMessageDialog(frmVirtualPets, "Congratulations, you've got some free score.");
				}
				if(pcounter > players.size()-1){ //If everyone has completed the day
					pcounter = 0;
					store.nextDay();
					for(Player p:players){
						p.nextDay();
					} //Do the nextday for each person and the store
					day += 1; //Add a day
					//Set labels and shit
					lblDaysPassed.setText("Day: " + day);
					lblPlayerScore.setText("Score: " + currplayer.getScore());
					currplayer = players.get(pcounter);
				}else{
					currplayer = players.get(pcounter);
					lblPlayerMoney.setText("Money: $" + currplayer.getMoney());
					lblActionsLeftFor.setText("Actions Left: " + currplayer.getActions());

				}
				lblPlayerName.setText("Player: " + currplayer.getName());
				lblDaysPassed.setText("Day: " + day);
				lblPlayerScore.setText("Score: " + currplayer.getScore());

				food_model.clear();
				food_model.addElement("Food: Nutrition");
				for(Food f:currplayer.getFood()){
					food_model.addElement(f.toString());
				}

				toys_model.clear();
				toys_model.addElement("Toy: Durability");
				for(Toy t: currplayer.getToys()){
					toys_model.addElement(t.toString());
				}

				pet1_text.setText(currplayer.getPets().get(0).printStatus());
				try{
					pet2_text.setText(currplayer.getPets().get(1).printStatus());
				}catch(IndexOutOfBoundsException e){
					pet2_text.setText("No Second Pet");
				}
				try{
					pet3_text.setText(currplayer.getPets().get(2).printStatus());
				}catch(IndexOutOfBoundsException e){
					pet3_text.setText("No Third Pet");
				}
			}
		});
		nav_panel.add(btnEndDay);


		//Initial Label filling
		currplayer = players.get(pcounter);
		lblPlayerName.setText("Player: " + currplayer.getName());
		lblPlayerMoney.setText("Money: $" + currplayer.getMoney());
		lblPlayerScore.setText("Score: " + currplayer.getScore());
		lblActionsLeftFor.setText("Actions Left: " + currplayer.getActions());
		lblDaysPassed.setText("Day: " + day);

		pet1_text.setText(currplayer.getPets().get(0).printStatus());
		try{
			pet2_text.setText(currplayer.getPets().get(1).printStatus());
		}catch(IndexOutOfBoundsException e){
			pet2_text.setText("No Second Pet");
		}
		try{
			pet3_text.setText(currplayer.getPets().get(2).printStatus());
		}catch(IndexOutOfBoundsException e){
			pet3_text.setText("No Third Pet");
		}
	}
}
