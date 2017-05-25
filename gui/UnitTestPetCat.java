package gui;

// TODO: Auto-generated Javadoc
/**
 * The Class UnitTestPetCat.
 */
public class UnitTestPetCat {
	
	/**
	 * Prints the confirm work.
	 *
	 * @param methodName the method name
	 */
	public void printConfirmWork(String methodName)
	{
		System.out.println(String.format("%-15s Works.", methodName));
	}
	
	/**
	 * Prints the deny work.
	 *
	 * @param methodName the method name
	 */
	public void printDenyWork(String methodName)
	{
		System.out.println(String.format("%-15s Does not work.", methodName));
	}

	/**
	 * Test pet status.
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
		cat.play(new Toy("testToy", 50, 10));
		
		if (3 == cat.getMood()){
			printConfirmWork("play From 2");
		}
		else
		{
			printDenyWork("play From 2");
		}
		
		cat.setMood(4);
		cat.play(new Toy("testToy", 50, 10));
		
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
	
	
	
	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		UnitTestPetCat tester = new UnitTestPetCat();
		tester.testPetStatus();
	}
}
