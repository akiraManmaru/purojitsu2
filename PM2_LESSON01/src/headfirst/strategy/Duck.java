package headfirst.strategy;

/**
 * カモクラス
 */
public abstract class Duck {
	protected FlyBehavior flyBehavior;//飛び方
	protected QuackBehavior quackBehavior;//鳴き方
 
	public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
		this.flyBehavior = flyBehavior;
		this.quackBehavior = quackBehavior;
	}

	/**
	 * flyBehaviorのセッター
	 * @param fb 飛び方
	 */
	public void setFlyBehavior (FlyBehavior fb) {
		flyBehavior = fb;
	}
 
	/**
	 * quackBehaviorのセッター
	 * @param qb 鳴き方
	 */
	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}
 
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
 
	public void swim() {
		System.out.println("カモなら、たとえおとりでも泳ぎます");
	}
}
