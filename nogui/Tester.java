package nogui;

public class Tester {
	private void testplayers(){
		Player tp1 = new Player("Test Player 1");
		System.out.println(tp1.getName());
		System.out.println(tp1.getMoney());
	}
	public static void main(String[] args){
		Tester t = new Tester();
		t.testplayers();
	}
}