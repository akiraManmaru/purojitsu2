package headfirst.strategy.eat;

public class EatNoWay implements EatBehavior {
	public void eat() {
		System.out.println("食べられません");
	}

}
