package headfirst.strategy.eat;

import headfirst.strategy.FlyNoWay;
import headfirst.strategy.Squeak;

public class RubberDuck extends Duck {

	public RubberDuck() {
		//飛ばずに、キューキュー鳴く
		super(new FlyNoWay(), new Squeak(), new EatNoWay());
	}

	public void display() {
		System.out.println("ゴムのアヒルです");
	}
}
