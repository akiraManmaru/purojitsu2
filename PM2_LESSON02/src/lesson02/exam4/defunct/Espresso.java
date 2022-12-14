package lesson02.exam4.defunct;

import lesson02.exam4.CaffeineDrink;

public class Espresso extends CaffeineDrink {

	public void brew() {
		System.out.println("エスプレッソマシーンでコーヒーをいれます");
	}

	public void putCondiments() {
		System.out.println("何も足しません．出来上がりです");
	}

}
