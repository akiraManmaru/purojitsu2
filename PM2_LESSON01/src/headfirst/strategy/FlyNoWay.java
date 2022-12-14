package headfirst.strategy;

/**
 * 飛べない
 */
public class FlyNoWay implements FlyBehavior {
	public void fly() {
		System.out.println("飛べません");
	}
}
