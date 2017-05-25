package gui;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Junit Testing
 */
public class TestPet {

	/**
	 * Test feed from 50 hunger.
	 */
	@Test
	public void testFeedFrom50() {
		Cat cat = new Cat("Cat");
		cat.setHunger(50);
		cat.setToiletneed(50);
		cat.feed(new Food("TestFood", 5,5,5,5));
		assertEquals(55, cat.getHunger());
		assertEquals(0, cat.getToiletneed());
	}

	/**
	 * Test feed from 90 hunger.
	 */
	@Test
	public void testFeedFrom90() {
		Cat cat = new Cat("Cat");
		cat.setHunger(90);
		cat.setToiletneed(50);
		cat.feed(new Food("TestFood", 5,10,5,5));
		assertEquals(100, cat.getHunger());
		assertEquals(0, cat.getToiletneed());
	}

	/**
	 * Test play from 2 mood.
	 */
	@Test
	public void testPlayFrom2() {
		Cat cat = new Cat("Cat");
		cat.setMood(2);
		cat.play(new Toy("testToy", 50, 10, 0));
		assertEquals(4, cat.getMood());
	}

	/**
	 * Test favourite food.
	 */
	@Test
	public void TestFavFood(){
		Velociraptor v = new Velociraptor("Bob");
		Food hooman = new Food("Human", 5,5,5,5);
		v.setMood(2);
		v.feed(hooman);
		assertEquals(3, v.getMood());
	}

	/**
	 * Test play from 4 mood.
	 */
	@Test
	public void testPlayFrom4() {
		Cat cat = new Cat("Cat");
		cat.setMood(4);
		cat.play(new Toy("testToy", 50, 10, 0));
		assertEquals(4, cat.getMood());
	}

	/**
	 * Test sleep.
	 */
	@Test
	public void testSleep() {
		Cat cat = new Cat("Cat");
		cat.setTiredness(50);
		cat.sleep();
		assertEquals(100,cat.getTiredness());
	}

	/**
	 * Test go to toilet.
	 */
	@Test
	public void testGoToToilet() {
		Cat cat = new Cat("Cat");
		cat.setToiletneed(50);
		cat.goToToilet();
		assertEquals(100,cat.getToiletneed());
	}

	/**
	 * Test going to the next day from full stats.
	 */
	@Test
	public void testNextDayFromFull() {
		Cat cat = new Cat("Cat");
		cat.setToiletneed(100);
		cat.setHunger(100);
		cat.setTiredness(100);
		cat.nextDay();
		assertEquals(85,cat.getHunger());
		assertEquals(65,cat.getTiredness());
		assertEquals(80,cat.getToiletneed());
	}

	/**
	 * Test going to the next day from empty stats
	 */
	@Test
	public void testNextDayFromEmpty() {
		Cat cat = new Cat("Cat");
		cat.setToiletneed(0);
		cat.setHunger(0);
		cat.setTiredness(0);
		cat.nextDay();
		assertEquals(0,cat.getHunger());
		assertEquals(0,cat.getTiredness());
		assertEquals(0,cat.getToiletneed());
		assertEquals(false, cat.isAlive());
	}

	/**
	 * Test going to the next day from negative stats
	 */
	@Test
	public void testNextDayFromNeg() {
		Cat cat = new Cat("Cat");
		cat.setToiletneed(-10);
		cat.setHunger(-200);
		cat.setTiredness(-0);
		cat.nextDay();
		assertEquals(0,cat.getHunger());
		assertEquals(0,cat.getTiredness());
		assertEquals(0,cat.getToiletneed());
		assertEquals(false, cat.isAlive());
	}


}
