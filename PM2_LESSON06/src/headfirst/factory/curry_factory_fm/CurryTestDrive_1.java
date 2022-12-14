package headfirst.factory.curry_factory_fm;

public class CurryTestDrive_1 {
 
	public static void main(String[] args) {

		カレーチェーン店 gogoCurry = new ゴーゴーカレー();
		カレーチェーン店 cocoIchibanCurry = new CoCo壱番屋();
 
		カレー curry = gogoCurry.orderCurry("カツ");
		System.out.println("\nイーサンが注文したカレーはこれです" + curry.recipe());
 
		curry = gogoCurry.orderCurry("野菜");
		System.out.println("\nイーサンが注文したカレーはこれです" + curry.recipe());
 
		curry = cocoIchibanCurry.orderCurry("カツ");
		System.out.println("\nジョエルが注文したカレーはこれです" + curry.recipe());

		curry = cocoIchibanCurry.orderCurry("野菜");
		System.out.println("\nジョエルが注文したカレーはこれです" + curry.recipe());

	}
}
