/**
 *
 */
package gui;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 */
public class TestToy {
	@Test
	public void testDurability(){
		Toy t = new Toy("Test", 0, 0, 100);
		assertEquals(100, t.getDurability());
	}

	@Test
	public void testAddDurability(){
		Toy t = new Toy("Test", 0, 0, 100);
		t.setDurability(120);
		assertEquals(100, t.getDurability());
	}

	@Test
	public void testTakeDurability(){
		Toy t = new Toy("Test", 0, 0, 100);
		t.setDurability(t.getDurability() - 20);
		assertEquals(80, t.getDurability());
	}

	@Test
	public void testTakeDurabilityPet(){
		Toy t = new Toy("Test", 0, 0, 100);
		Pet p = new Pet("Test Pet");
		p.setRoughness(22);
		t.setDurability(t.getDurability() - p.getRoughness());
		assertEquals(78, t.getDurability());
	}

	@Test
	public void testTakeDurabilityNeg(){
		Toy t = new Toy("Test", 0, 0, 100);
		Pet p = new Pet("Test Pet");
		p.setRoughness(120);
		t.setDurability(t.getDurability() - p.getRoughness());
		assertEquals(0, t.getDurability());
	}

	@Test
	public void testHappiness(){
		Toy t = new Toy("Test", 0, 100, 0);
		assertEquals(100, t.getHappiness());
	}

	@Test
	public void testAddHappiness(){
		Toy t = new Toy("Test", 0, 100, 0);
		t.setHappiness(120);
		assertEquals(100, t.getHappiness());
	}

	@Test
	public void testTakeHappiness(){
		Toy t = new Toy("Test", 0, 100, 0);
		t.setHappiness(t.getHappiness() - 20);
		assertEquals(80, t.getHappiness());
	}

	@Test
	public void testTakeHappinessPet(){
		Toy t = new Toy("Test", 0, 100, 0);
		Pet p = new Pet("Test Pet");
		p.setRoughness(22);
		p.setMood(2);
		p.play(t);
		assertEquals(4, p.getMood());
	}

	@Test
	public void testTakeHappinessNeg(){
		Toy t = new Toy("Test", 0, 0, 100);
		t.setHappiness(-1);
		assertEquals(0, t.getHappiness());
	}

	@Test
	public void testGetName(){
		Toy t = new Toy("Test", 0, 0, 100);
		assertEquals("Test", t.getName());
	}

	@Test
	public void testSetName(){
		Toy t = new Toy("Test", 0, 0, 100);
		t.setName("Test2");
		assertEquals("Test2", t.getName());
	}

}
