package gui;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPet {

	@Test
	public void testFeedFrom50() {
		Cat cat = new Cat("Cat");
		cat.setHunger(50);
		cat.setToiletneed(50);
		cat.feed(new Food("TestFood", 5,5,5,5));
		assertEquals(65, cat.getHunger());
		assertEquals(0, cat.getToiletneed());
	}
	
	@Test
	public void testFeedFrom90() {
		Cat cat = new Cat("Cat");
		cat.setHunger(90);
		cat.setToiletneed(50);
		cat.feed(new Food("TestFood", 5,5,5,5));
		assertEquals(100, cat.getHunger());
		assertEquals(0, cat.getToiletneed());
	}

	@Test
	public void testPlayFrom2() {
		Cat cat = new Cat("Cat");
		cat.setMood(2);
		cat.play(new Toy("testToy", 50, 10));
		assertEquals(3, cat.getMood());
	}
	
	@Test
	public void testPlayFrom4() {
		Cat cat = new Cat("Cat");
		cat.setMood(4);
		cat.play(new Toy("testToy", 50, 10));
		assertEquals(4, cat.getMood());
	}

	@Test
	public void testSleep() {
		Cat cat = new Cat("Cat");
		cat.setTiredness(50);
		cat.sleep();
		assertEquals(100,cat.getTiredness());
	}

	@Test
	public void testGoToToilet() {
		Cat cat = new Cat("Cat");
		cat.setToiletneed(50);
		cat.goToToilet();
		assertEquals(100,cat.getToiletneed());
	}

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
	
	

}
