package headfirst.strategy.eat;

import headfirst.strategy.FlyBehavior;
import headfirst.strategy.QuackBehavior;

/**
 * カモクラス
 */
public abstract class Duck {
	protected FlyBehavior flyBehavior;//飛び方
	protected QuackBehavior quackBehavior;//鳴き方
	protected EatBehavior eatBehavior;

	public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior, EatBehavior eatBehavior) {
		this.flyBehavior = flyBehavior;
		this.quackBehavior = quackBehavior;
		this.eatBehavior = eatBehavior;
	}

	/**
	 * flyBehaviorのセッター
	 * @param fb 飛び方
	 */
	public void setFlyBehavior(FlyBehavior fb) {
		flyBehavior = fb;
	}

	/**
	 * quackBehaviorのセッター
	 * @param qb 鳴き方
	 */
	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}

	public void setEatBehavior(EatBehavior eb) {
		eatBehavior = eb;
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

	/**
	 * 食べる
	 */
	public void performEat() {
		eatBehavior.eat();
	}

	public void swim() {
		System.out.println("カモなら、たとえおとりでも泳ぎます");
	}
}
