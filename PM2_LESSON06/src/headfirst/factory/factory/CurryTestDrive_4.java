package headfirst.factory.factory;

import headfirst.factory.curry.カレー;

public class CurryTestDrive_4 {
 
	public static void main(String[] args) {
		カレーチェーン店 gogo = new ゴーゴーカレー();
		カレーチェーン店 cocoIchiban = new CoCo壱番屋();
		カレーチェーン店 jotoCurry = new 上等カレー();
		
		カレー curry = gogo.orderCurry("スペシャル");
		System.out.println("\nジョエルが注文したカレーはこれです" + curry.recipe());

		curry = cocoIchiban.orderCurry("スペシャル");
		System.out.println("\nジョエルが注文したカレーはこれです" + curry.recipe());

		curry = jotoCurry.orderCurry("スペシャル");
		System.out.println("\nジョエルが注文したカレーはこれです" + curry.recipe());
		
	}
}
