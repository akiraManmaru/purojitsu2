package headfirst.strategy.eat;

import headfirst.strategy.FlyWithWings;
import headfirst.strategy.Quack;

public class RedHeadDuck extends Duck {

	public RedHeadDuck() {
		//翼で飛んで、ガーガー鳴く
		super(new FlyWithWings(), new Quack(), new Eat());
	}

	public void display() {
		System.out.println("本物のアメリカホシハジロです");
	}
}
