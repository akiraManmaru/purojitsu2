package base;

/**
 * マガモ
 */
public class MallardDuck extends Duck {
	public MallardDuck() {
		// 翼で飛んで、ガーガー鳴く
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}

	public void display() {
		System.out.println("本物のマガモです");
	}
}
