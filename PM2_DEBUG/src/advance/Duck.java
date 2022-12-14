package advance;
/**
 * カモクラス
 */
public abstract class Duck {
	protected FlyBehavior flyBehavior;//飛び方
	protected QuackBehavior quackBehavior;//鳴き方

	/**
	 * 表示する（抽象メソッド）
	 */
	abstract void display();

	/**
	 * 飛ぶ
	 */
	public void performFly() {
		flyBehavior.fly();
	}

	/**
	 * 鳴く
	 */
	public void performQuack() {
		quackBehavior.quack();
	}

}

