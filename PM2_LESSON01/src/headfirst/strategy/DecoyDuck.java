package headfirst.strategy;

/**
 * おとりのカモ
 */
public class DecoyDuck extends Duck {
	public DecoyDuck() {
		super(new FlyNoWay(), new MuteQuack());
	}
	
	public void display() {
		System.out.println("おとりの鴨です");
	}
}
