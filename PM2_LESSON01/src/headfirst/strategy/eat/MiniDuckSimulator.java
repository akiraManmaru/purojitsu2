package headfirst.strategy.eat;

public class MiniDuckSimulator {
	public static void main(String[] args) {
		MallardDuck mallard = new MallardDuck();
		DecoyDuck decoy = new DecoyDuck();

		mallard.display();
		mallard.performQuack();
		mallard.performFly();
		mallard.performEat();

		decoy.display();
		decoy.performQuack();
		decoy.performFly();
		decoy.performEat();
	}

}
