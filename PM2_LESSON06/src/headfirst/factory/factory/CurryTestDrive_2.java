package headfirst.factory.factory;

import headfirst.factory.curry.カレー;

public class CurryTestDrive_2 {

	public static void main(String[] args) {

		カレーチェーン店 gogo = new ゴーゴーカレー();
		カレーチェーン店 cocoIchiban = new CoCo壱番屋();

		カレー curry = gogo.orderCurry("カツ");
		System.out.println("\nイーサンが注文したカレーはこれです" + curry.recipe());

		curry = gogo.orderCurry("野菜");
		System.out.println("\nイーサンが注文したカレーはこれです" + curry.recipe());

		curry = gogo.orderCurry("シーフード");
		System.out.println("\nイーサンが注文したカレーはこれです" + curry.recipe());

		curry = cocoIchiban.orderCurry("カツ");
		System.out.println("\nジョエルが注文したカレーはこれです" + curry.recipe());

		curry = cocoIchiban.orderCurry("野菜");
		System.out.println("\nジョエルが注文したカレーはこれです" + curry.recipe());

		curry = cocoIchiban.orderCurry("シーフード");
		System.out.println("\nジョエルが注文したカレーはこれです" + curry.recipe());

	}
}
