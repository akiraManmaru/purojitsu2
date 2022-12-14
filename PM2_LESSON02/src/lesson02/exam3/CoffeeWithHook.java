package lesson02.exam3;

import java.util.Scanner;

public class CoffeeWithHook extends CaffeineDrinkWithHook {
	public void brew() {
		System.out.println("フィルタでコーヒーをドリップします");
	}

	public void putCondiments() {
		System.out.println("砂糖とミルクを追加します");
	}

	public boolean customerWantsCondiments() {

		System.out.print("お砂糖とミルクはご利用ですか(y/n)?");
		Scanner in = new Scanner(System.in);
		String answer = in.next();

		if (answer.toLowerCase().startsWith("y")) {
			return true;
		} else {
			return false;
		}

	}

}
