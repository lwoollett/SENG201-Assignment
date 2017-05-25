package gui;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFood {
	//Name, val, nutritional, taste, size
	Food f = new Food("Test", 0, 0, 0, 0);

	@Test
	public void testGetName() {
		assertEquals("Test", f.getName());
	}

	@Test
	public void testSetName() {
		f.setName("Test2");
		assertEquals("Test2", f.getName());
	}

	@Test
	public void testSetValHigh() {
		f.setValue(10000);
		assertEquals(10000, f.getValue());
	}

	@Test
	public void testSetValNeg() {
		f.setValue(-10000);
		assertEquals(1, f.getValue());
	}

	@Test
	public void testGet() {
		f.setValue(10);
		assertEquals(10, f.getValue());
	}

	@Test
	public void testSetNutHigh() {
		f.setNutrition(101);
		assertEquals(100, f.getNutrition());
	}

	@Test
	public void testSetNutNeg() {
		f.setNutrition(-10);
		assertEquals(0, f.getNutrition());
	}

	@Test
	public void testSetTasteHigh() {
		f.setTastiness(101);
		assertEquals(100, f.getTastiness());
	}

	@Test
	public void testSetTasteNeg() {
		f.setTastiness(-10);
		assertEquals(0, f.getTastiness());
	}

	@Test
	public void testSetMealHigh() {
		f.setMeal(5);
		assertEquals(4, f.getMeal());
	}

	@Test
	public void testSetMealNeg() {
		f.setMeal(-10);
		assertEquals(0, f.getMeal());
	}


}
