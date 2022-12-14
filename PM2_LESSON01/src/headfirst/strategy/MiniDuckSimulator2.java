package headfirst.strategy;

public class MiniDuckSimulator2 {
	public static void main(String[] args) {
		Duck model = new ModelDuck();
		model.display();
		model.performQuack();
		model.performFly();

		model.setFlyBehavior(new FlyWithMetalWings());
		model.setQuackBehavior(new MuteQuack());
		model.display();
		model.performQuack();
		model.performFly();
	}

}
