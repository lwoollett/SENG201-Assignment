package gui;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class TestPlayer.
 */
public class TestPlayer {

	/**
	 * Test player.
	 */
	@Test
	public void testPlayer() {
		Player testPlayer = new Player("Test Player 1");
		assertEquals("Test Player 1", testPlayer.getName());
	}

	/**
	 * Test next day.
	 */
	@Test
	public void testNextDay() {
		Player testPlayer = new Player("Test Player 1");
		ArrayList<Pet> testPetList = new ArrayList<>();
		testPetList.add(new Cat("TestCat"));
		testPlayer.setPets(testPetList);
		testPlayer.nextDay();
		for(Pet pet: testPetList){
			pet.nextDay();
		}
		assertEquals(testPetList,testPlayer.getPets());
	}

	/**
	 * Test set pets.
	 */
	@Test
	public void testSetPets() {
		Player testPlayer = new Player("Test Player 1");
		ArrayList<Pet> testPetList = new ArrayList<>();
		testPetList.add(new Cat("TestCat"));
		testPlayer.setPets(testPetList);
		assertEquals(testPetList, testPlayer.getPets());
	}

}
