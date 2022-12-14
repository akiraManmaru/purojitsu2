package headfirst.factory.factory;

import headfirst.factory.curry.カレー;

public class CurryTestDrive_3 {

	public static void main(String[] args) {

		カレーチェーン店 jotoCurry = new 上等カレー();

		カレー curry = jotoCurry.orderCurry("カツ");
		System.out.println("\nイーサンが注文したカレーはこれです" + curry.recipe());

		curry = jotoCurry.orderCurry("野菜");
		System.out.println("\nイーサンが注文したカレーはこれです" + curry.recipe());

		curry = jotoCurry.orderCurry("シーフード");
		System.out.println("\nイーサンが注文したカレーはこれです" + curry.recipe());

	}
}
