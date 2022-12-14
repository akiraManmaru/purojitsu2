package base;
/**
 * キューキュー鳴く
 */
public class Squeak implements QuackBehavior {
	public void quack() {
		System.out.println("キューキュー");
	}
}
