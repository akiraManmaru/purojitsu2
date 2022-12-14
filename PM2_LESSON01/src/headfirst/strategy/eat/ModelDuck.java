package headfirst.strategy.eat;

import headfirst.strategy.FlyNoWay;
import headfirst.strategy.Quack;

public class ModelDuck extends Duck {
	public ModelDuck() {
		//飛ばないが、ガーガー鳴く
		super(new FlyNoWay(), new Quack(), new EatNoWay());

	}

	public void display() {
		System.out.println("模型の鴨です");
	}

}
