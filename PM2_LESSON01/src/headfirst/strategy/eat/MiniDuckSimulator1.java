package headfirst.strategy.eat;

import headfirst.strategy.FlyRocketPowered;

public class MiniDuckSimulator1 {
	public static void main(String[] args) {
		Duck duck = new RedHeadDuck();
		duck.display();
		duck.performQuack();
		duck.performFly();
		duck.performEat();
		duck.swim();

		duck = new RubberDuck();
		duck.display();
		duck.performQuack();
		duck.performFly();
		duck.performEat();
		duck.swim();

		duck = new ModelDuck();
		duck.display();
		duck.performQuack();
		duck.performFly();
		duck.setFlyBehavior(new FlyRocketPowered());
		duck.performFly();
		duck.performEat();
		duck.swim();
	}

}
