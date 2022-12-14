package headfirst.strategy;

/**
 * マガモ
 */
public class MallardDuck extends Duck {

	public MallardDuck() {
		//翼で飛んで、ガーガー鳴く
		super(new FlyWithWings(), new Quack());
	}

	public void display() {
		System.out.println("本物のマガモです");
	}
}
