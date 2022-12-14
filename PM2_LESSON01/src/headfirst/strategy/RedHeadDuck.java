package headfirst.strategy;

/**
 * アメリカホシハジロ
 */
public class RedHeadDuck extends Duck {
 
	public RedHeadDuck() {
		//翼で飛んで、ガーガー鳴く
		super(new FlyWithWings(), new Quack());
	}
 
	public void display() {
		System.out.println("本物のアメリカホシハジロです");
	}
}
