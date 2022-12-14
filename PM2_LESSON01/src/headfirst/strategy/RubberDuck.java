package headfirst.strategy;

/**
 * ゴムのアヒル
 */
public class RubberDuck extends Duck {
 
	public RubberDuck() {
		//飛ばずに、キューキュー鳴く
		super(new FlyNoWay(), new Squeak());
	}
 
	public void display() {
		System.out.println("ゴムのアヒルです");
	}
}
