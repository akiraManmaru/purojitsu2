package headfirst.strategy.eat;

import headfirst.strategy.FlyNoWay;
import headfirst.strategy.MuteQuack;

public class DecoyDuck extends Duck {
	public DecoyDuck() {
		super(new FlyNoWay(), new MuteQuack(), new EatNoWay());
	}

	public void display() {
		System.out.println("おとりの鴨です");
	}

}
