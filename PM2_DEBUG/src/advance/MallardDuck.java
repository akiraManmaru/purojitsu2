package advance;

import java.util.Scanner;

/**
 * マガモ
 */
public class MallardDuck extends Duck {
	String name;

	public MallardDuck() {
		// 翼で飛んで、ガーガー鳴く
		setName();
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
		name = "";
	}

	private void setName() {
		//System.out.println("実行");

		Scanner s = new Scanner(System.in);
		int key = s.nextInt();

		if (key == 0)
			name = "大マガモ";
		else
			name = "小マガモ";
		//System.out.println("name:" + name);
	}

	public void display() {
		System.out.println("本物の" + name + "です");
	}
}
