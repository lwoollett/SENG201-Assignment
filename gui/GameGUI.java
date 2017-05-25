package gui;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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


// TODO: Auto-generated Javadoc
/**
 * The Class GameGUI.
 */
public class GameGUI {

	/** The store */
	public static Store store = new Store();

	/** The Number of players. */
	int pnum = 0;

	int maxdays = 0;
	/** The day. */
	int day = 1;

	/** The current player. */
	Player currplayer;

	/** The pcounter. */
	public static int pcounter = 0;

	/** The players. */
	public static ArrayList<Player> players = new ArrayList<Player>();

	/** The pets. */
	ArrayList<Pet> pets = new ArrayList<Pet>();

	/**
	 * Populates the pet arraylist
	 */
	private void populatepets(){
		pets.add(new Cat("UnNamed"));
		pets.add(new Cow("UnNamed"));
		pets.add(new Dog("UnNamed"));
		pets.add(new Rabbit("UnNamed"));
		pets.add(new Rat("UnNamed"));
		pets.add(new Velociraptor("UnNamed"));
	}

	/** The frm virtual pets. */
	private JFrame frmVirtualPets;

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
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
		populatepets();
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

		while(maxdays == 0){
			String playername = (String)JOptionPane.showInputDialog(
					frmVirtualPets,
					"How Many Days?",
					"Day Selection",
					JOptionPane.PLAIN_MESSAGE,
					null, //Icon
					null, //To use a list or just text box
					"29"
					);
			try{
				maxdays = Integer.parseInt(playername);
			}catch(Exception e){
				//User has entered something thats not a int. thats cool, we'll just loop again
				maxdays = 0;
			}
		}


		Object[] options = {"1", //Selection options for the popup
				"2",
		"3"};

		while(pnum == 0){
			pnum = 1 + JOptionPane.showOptionDialog(frmVirtualPets, "Please Select The Number Of Players", "Select # Of Players",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options,
					options[2]);
		}

		//Counter for player, then pets.
		//The fuck is this spaghetti code??
		//TODO Make into actual code
		Object[] petobjects = {"Cat", "Cow", "Dog", "Rabbit", "Rat", "Velociraptor"};
		ArrayList<String> petstrings = new ArrayList<String>();
		petstrings.add("Cat");petstrings.add("Cow");petstrings.add("Dog");petstrings.add("Rabbit");petstrings.add("Rat");petstrings.add("Velociraptor");


		for(int i = 1; i < pnum + 1; i++){
			String playername = (String)JOptionPane.showInputDialog(
					frmVirtualPets,
					"What is player " + i + "'s name?",
					"Player Naming",
					JOptionPane.PLAIN_MESSAGE,
					null, //Icon
					null, //To use a list or just text box
					"Player " + i
					);

			boolean playerdouble = false;
			for(Player p: players){
				if(playername.equals(p.getName())){
					i--;
					playerdouble = true;
					System.out.println(playername + " " + p.getName());
				}
			}
			if(playerdouble == false){
				players.add(new Player(playername));
				int val = 0;
				while(val != -1 && players.get(i-1).getPets().size() != 3){
					String retPet = (String)JOptionPane.showInputDialog(
							frmVirtualPets,
							"Select Cancel To Stop Adding Pets",
							"Select A Pet",
							JOptionPane.PLAIN_MESSAGE,
							null,
							petobjects,
							petobjects[0]);


					val = petstrings.indexOf(retPet);
					ArrayList<Pet> ppets = players.get(i-1).getPets();
					if(val == -1 && players.get(i-1).getPets().size() == 0){
						val = 0;
					}else if(val != -1){
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
						p.setPetname(petname);
						ppets.add(p);
						players.get(i-1).setPets(ppets);
						/*TODO:
						 * Fix the bug where having 2 or more of the same
						 * pet will make them all have the same name.
						 * The name is the same as the last pet, which is very very odd.
						 *
						 */
					}
				}
			}
		}
		//Create our panels
		JPanel action_panel = new JPanel();
		action_panel.setToolTipText("dawdadad");
		action_panel.setBounds(112, 0, 520, 510);
		action_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frmVirtualPets.getContentPane().add(action_panel);

		action_panel.setVisible(false);

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


		//Text Panes and shit.
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

		DefaultListModel<String> toys_model = new DefaultListModel<String>();
		toys_model.addElement("Toy: Durability");

		DefaultListModel<String> food_model = new DefaultListModel<String>();
		food_model.addElement("Food: Nutrition");


		JList<String> list_toys = new JList<String>(toys_model);
		inventory_panel.add(list_toys);

		JList<String> list_food = new JList<String>(food_model);
		inventory_panel.add(list_food);

		JButton btnFeed = new JButton("Feed");
		btnFeed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(currplayer.getFood().size() == 0){
					JOptionPane.showMessageDialog(frmVirtualPets, "Player " + currplayer.getName() + " has no food.");
				}else if(currplayer.getActions() == 0){
					JOptionPane.showMessageDialog(frmVirtualPets, "Player " + currplayer.getName() + " is out of actions.");
				}else{
					ArrayList<Pet> pets = currplayer.getPets();
					ArrayList<Food> foods = currplayer.getFood();

					JComboBox<String> selectedPet = new JComboBox<String>();
					for(Pet p:currplayer.getPets()){
						selectedPet.addItem(p.getPetname());
					}

					JComboBox<String> selectedFood = new JComboBox<String>();
					for(Food f:currplayer.getFood()){
						selectedFood.addItem(f.getName());
					}
					final JComponent[] things = new JComponent[] {
							new JLabel("Pet To Feed"),
							selectedPet,
							new JLabel("Food To Use"),
							selectedFood
					};

					int result = JOptionPane.showConfirmDialog(null, things, "Sweg xd", JOptionPane.PLAIN_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {
						Pet setPet = pets.get(selectedPet.getSelectedIndex());
						Food setFood = foods.get(selectedFood.getSelectedIndex());
						setPet.feed(setFood);
						foods.remove(setFood);
						currplayer.setFood(foods);

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
							//System.out.println("Only 2 Pets");
						}

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
				ArrayList<Food> foods = store.getFoods();
				int c = 0;
				JComboBox<String> selectedFood = new JComboBox<String>();
				for(Food f: foods){
					selectedFood.addItem(f.getName() + " $" + f.getValue() + " Stock: " + store.getFoodamounts()[c]);
					c++;
				}
				final JComponent[] things = new JComponent[] {
						new JLabel("Food To Buy:"),
						selectedFood};

				int result = JOptionPane.showConfirmDialog(null, things, "Player Has $" + currplayer.getMoney(), JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					int foodindex = selectedFood.getSelectedIndex();
					if(currplayer.getMoney() >= foods.get(foodindex).getValue()){
						ArrayList<Food> prevfood = currplayer.getFood();
						prevfood.add(foods.get(foodindex));
						currplayer.setMoney(currplayer.getMoney() - foods.get(foodindex).getValue());
						currplayer.setFood(prevfood);

						lblPlayerMoney.setText("Money: $" + currplayer.getMoney());

						food_model.clear();
						food_model.addElement("Food: Nutrition");
						for(Food f:prevfood){
							food_model.addElement(f.toString());
						}

					}
				} else {
					//System.out.println("Box Closed");
				}
			}
		});

		nav_panel.add(btnFoodStore);

		JButton btnToyStore = new JButton("Toy Store");
		btnToyStore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				ArrayList<Toy> toys = store.getToys();
				JComboBox<String> selectedToy = new JComboBox<String>();
				int c = 0;
				for(Toy t : toys){
					selectedToy.addItem(t.getName() + ": " + store.getToyamounts()[c]);
					c++;
				}
				final JComponent[] things = new JComponent[] {
						new JLabel("Toy To Buy:"),
						selectedToy};

				int result = JOptionPane.showConfirmDialog(null, things, "Player Has $" + currplayer.getMoney(), JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					int toyindex = selectedToy.getSelectedIndex();
					if(currplayer.getMoney() >= toys.get(toyindex).getPrice()){
						ArrayList<Toy> prevtoys = currplayer.getToys();
						prevtoys.add(toys.get(toyindex));
						currplayer.setMoney(currplayer.getMoney() - toys.get(toyindex).getPrice());
						currplayer.setToys(prevtoys);

						lblPlayerMoney.setText("Money: $" + currplayer.getMoney());

						toys_model.clear();
						toys_model.addElement("Toy: Durability");
						for(Toy t: prevtoys){
							toys_model.addElement(t.toString());
						}
					}
				} else {
					//System.out.println("User canceled / closed the dialog, result = " + result);
				}
			}
		});
		nav_panel.add(btnToyStore);

		JButton btnPlay = new JButton("Play");
		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(currplayer.getToys().size() == 0){
					JOptionPane.showMessageDialog(frmVirtualPets, "Player " + currplayer.getName() + " has no toys.");
				}else if(currplayer.getActions() == 0){
					JOptionPane.showMessageDialog(frmVirtualPets, "Player " + currplayer.getName() + " is out of actions.");
				}else{
					ArrayList<Pet> pets = currplayer.getPets();
					ArrayList<Toy> toys = currplayer.getToys();

					JComboBox<String> selectedPet = new JComboBox<String>();
					for(Pet p:currplayer.getPets()){
						selectedPet.addItem(p.getPetname());
					}

					JComboBox<String> selectedToy = new JComboBox<String>();
					for(Toy t: toys){
						selectedToy.addItem(t.getName());
					}
					final JComponent[] things = new JComponent[] {
							new JLabel("Pet To Play With"),
							selectedPet,
							new JLabel("Toy To Use"),
							selectedToy
					};

					int result = JOptionPane.showConfirmDialog(null, things, "Sweg xd", JOptionPane.PLAIN_MESSAGE);
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
							//System.out.println("Only 2 Pets");
						}

						currplayer.setToys(toys);
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
				if(currplayer.getActions() == 0){
					JOptionPane.showMessageDialog(frmVirtualPets, "Player " + currplayer.getName() + " is out of actions.");
				}else{
					ArrayList<Pet> pets = currplayer.getPets();
					JComboBox<String> selectedPet = new JComboBox<String>();
					for(Pet p:currplayer.getPets()){
						selectedPet.addItem(p.getPetname());
					}

					final JComponent[] things = new JComponent[] {
							new JLabel("Pet To Send To Toilet:"),
							selectedPet
					};

					int result = JOptionPane.showConfirmDialog(null, things, "Sending Pet To Toilet", JOptionPane.PLAIN_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {
						Pet setPet = pets.get(selectedPet.getSelectedIndex());
						setPet.goToToilet();
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
						//System.out.println("Only 2 Pets");
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
					JComboBox<String> selectedPet = new JComboBox<String>();
					for(Pet p:currplayer.getPets()){
						selectedPet.addItem(p.getPetname());
					}

					final JComponent[] things = new JComponent[] {
							new JLabel("Pet To Send To Sleep:"),
							selectedPet
					};

					int result = JOptionPane.showConfirmDialog(null, things, "Sending Pet To Sleep", JOptionPane.PLAIN_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {
						Pet setPet = pets.get(selectedPet.getSelectedIndex());
						setPet.sleep();
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
						//System.out.println("Only 2 Pets");
					}
				}
			}
		});
		nav_panel.add(btnSleep);

		JButton btnHelp = new JButton("Help");
		btnHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//TODO ADD SHIT HERE YOU MORON
			}
		});
		nav_panel.add(btnHelp);


		JButton btnEndDay = new JButton("End Day");
		btnEndDay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				pcounter += 1;
				if(pcounter > players.size()-1){
					pcounter = 0;
					store.nextDay();
					for(Player p:players){
						p.nextDay();
					}
					day += 1;
					lblDaysPassed.setText("Day: " + day);
					lblPlayerScore.setText("Score: " + currplayer.getScore());

				}else{
					currplayer = players.get(pcounter);
					lblPlayerName.setText("Player: " + currplayer.getName());
					lblPlayerMoney.setText("Money: $" + currplayer.getMoney());
					lblActionsLeftFor.setText("Actions Left: " + currplayer.getActions());

				}

				lblDaysPassed.setText("Day: " + day);
				lblPlayerScore.setText("Score: " + currplayer.getScore());


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
