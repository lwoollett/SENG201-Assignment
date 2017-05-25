package gui;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Tester.
 */
public class Tester {

	/**
	 * Prints the confirm work.
	 *
	 * @param methodName the method name
	 */
	public void printConfirmWork(String methodName)
	{
		System.out.println(String.format("%-20s Works as expected.", methodName));
	}

	/**
	 * Prints the deny work.
	 *
	 * @param methodName the method name
	 */
	public void printDenyWork(String methodName)
	{
		System.out.println(String.format("%-20s Does not work as expected.", methodName));
	}


	/**
	 * Test pet status.
	 */
	/*

	 * Testing Pets Methods

	 */
	public void testPetStatus ()
	{
		Cat cat = new Cat("Cat");

		//Testing feed
		cat.setHunger(50);
		cat.setToiletneed(50);
		cat.feed(new Food("TestFood", 5,5,5,5));
		if (65 == cat.getHunger() && 0 == cat.getToiletneed()){
			printConfirmWork("feed From 50");
		}
		else
		{
			printDenyWork("feed From 50");
		}

		cat.feed(new Food("TestFood", 5,5,5,5));
		if (80 == cat.getHunger() && 0 == cat.getToiletneed()){
			printConfirmWork("feed From 65");
		}
		else
		{
			printDenyWork("feed From 65");
			System.out.println(cat.getToiletneed());
		}

		cat.setHunger(90);
		cat.feed(new Food("TestFood", 5,5,5,5));
		if (100 == cat.getHunger() && 0 == cat.getToiletneed()){
			printConfirmWork("feed From 90");
		}
		else
		{
			printDenyWork("feed From 90");
			System.out.println(cat.getToiletneed());
		}

		//Testing play
		cat.setMood(2);
		cat.play(new Toy("testToy", 50, 10, 0));

		if (3 == cat.getMood()){
			printConfirmWork("play From 2");
		}
		else
		{
			printDenyWork("play From 2");
		}

		cat.setMood(4);
		cat.play(new Toy("testToy", 50, 10, 0));

		if (4 == cat.getMood()){
			printConfirmWork("play From 4");
		}
		else
		{
			printDenyWork("play From 4");
		}


		//Testing sleep
		cat.setTiredness(50);
		cat.sleep();
		if (100 == cat.getTiredness()){
			printConfirmWork("sleep");
		}
		else
		{
			printDenyWork("sleep");
		}

		//Testing goToToilet
		cat.setToiletneed(50);
		cat.goToToilet();
		if (100 == cat.getToiletneed()){
			printConfirmWork("goToToilet");
		}
		else
		{
			printDenyWork("goToToilet");
		}

		//testing nextDay
		cat.setToiletneed(100);
		cat.setHunger(100);
		cat.setTiredness(100);
		cat.nextDay();
		if(cat.getHunger() == 85 && cat.getTiredness() == 65 && cat.getToiletneed() == 80)
		{
			printConfirmWork("nextDay");
		}
		else
		{
			printDenyWork("nextDay");
		}

	}

	/*

	 * Testing Players

	 */

	/**
	 * Testplayers.
	 */
	private void testplayers(){
		Player testPlayer = new Player("Test Player 1");
		if(testPlayer.getName() == "Test Player 1" && testPlayer.getMoney() == 1000){
			printConfirmWork("player Initialise");
		}
		else{
			printDenyWork("player Initialise");
		}

		//Testing giving players pets
		ArrayList<Pet> testPetList = new ArrayList<Pet>();
		testPetList.add(new Cat("TestCat"));
		testPlayer.setPets(testPetList);
		if(testPetList == testPlayer.getPets()){
			printConfirmWork("setPets");
		}
		else{
			printDenyWork("setPets");
		}

		//Testing nextDay
		testPlayer.nextDay();
		for(Pet pet: testPetList){
			pet.nextDay();
		}
		if(testPlayer.getPets() == testPetList){
			printConfirmWork("nextDay");
		}
		else{
			printDenyWork("nextDay");
		}
	}




	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		Tester tester = new Tester();

		System.out.println("Player Method Testing:");
		tester.testplayers();

		System.out.println("\nPet Method Testing:");
		tester.testPetStatus();

		System.out.println("\nStore Method Testing:");
		tester.testPetStatus();
	}
}
