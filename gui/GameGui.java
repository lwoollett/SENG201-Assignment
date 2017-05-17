package gui;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


public class GameGUI {
	Store store = new Store();
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

	private JFrame frmVirtualPets;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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
					"Player " + i);
			
			
			players.add(new Player(playername));
			
			
			int val = 0;
			
			while(val != -1 && players.get(i-1).getPets().size() != 3){
				String retPet = (String)JOptionPane.showInputDialog(
						frmVirtualPets,
	                    "Select Cancel To Stop Adding Pets",
	                    "Customized Dialog",
	                    JOptionPane.PLAIN_MESSAGE,
	                    null,
	                    petobjects,
	                    petobjects[0]);
				
				
				System.out.println(retPet);
				val = petstrings.indexOf(retPet);
				ArrayList<Pet> ppets = players.get(i-1).getPets();
				if(val == -1 && players.get(i-1).getPets().size() == 0){
					val = 0;
				}else if(val != -1){
					ppets.add(pets.get(val));
					players.get(i-1).setPets(ppets);
				}
			}
		}
		
		
		//Create our panels
		JPanel action_panel = new JPanel();
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
		
		JPanel pet3_panel = new JPanel();
		pet3_panel.setBounds(372, 255, 255, 255);
		pet3_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frmVirtualPets.getContentPane().add(pet3_panel);
		
		JPanel inventory_panel = new JPanel();
		inventory_panel.setBounds(372, 0, 255, 255);
		inventory_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frmVirtualPets.getContentPane().add(inventory_panel);
		
		JPanel pet2_panel = new JPanel();
		pet2_panel.setBounds(112, 255, 255, 255);
		frmVirtualPets.getContentPane().add(pet2_panel);
		pet2_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JButton btnHomeScreen = new JButton("Home Screen");
		btnHomeScreen.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) {
				System.out.println("Clicked!");
				inventory_panel.setVisible(true);
				pet1_panel.setVisible(true);
				pet2_panel.setVisible(true);
				pet3_panel.setVisible(true);
				
			}
		});
		
		nav_panel.add(btnHomeScreen);
		
		JButton btnFeed = new JButton("Feed");
		nav_panel.add(btnFeed);
		
		JButton btnStore = new JButton("Store");
		btnStore.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) {
				System.out.println("Clicked!");
				inventory_panel.setVisible(false);
				pet1_panel.setVisible(false);
				pet2_panel.setVisible(false);
				pet3_panel.setVisible(false);
			}
		});
		nav_panel.add(btnStore);
		
		JButton btnPlay = new JButton("Play");
		nav_panel.add(btnPlay);
		
		JButton btnHelp = new JButton("Help");
		nav_panel.add(btnHelp);
		
		JButton btnEndDay = new JButton("End Day");
		nav_panel.add(btnEndDay);
		
		
		
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
		
		
		
		
		
		JList<String> list_toys = new JList<String>();
		inventory_panel.add(list_toys);
		
		JList<String> list_food = new JList<String>();
		inventory_panel.add(list_food);
		
		
		for(int day = 1; day < 30; day ++){
			for(int pcounter = 0; pcounter < pnum; pcounter++){
				Player player = players.get(pcounter);
				lblPlayerName.setText("Player: " + player.getName());
				lblPlayerMoney.setText("$: " + player.getMoney());
				lblPlayerScore.setText("Score: " + player.getScore());
				lblActionsLeftFor.setText("Actions Left: " + player.getActions());
				lblDaysPassed.setText("Days Passed: " + day);
				
			}
		}
		
	}
}
