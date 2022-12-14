package headfirst.strategy;

/**
 * ロケットで飛ぶ
 */
public class FlyRocketPowered implements FlyBehavior {
	public void fly() {
		System.out.println("ロケットで飛んでいます！");
	}
}
