package lesson02b.testdrive;

import java.util.ArrayList;

import lesson02b.arraylist.ArrayListRectangle;
import lesson02b.arraylist.Rectangle;

public class TestArrayListRectangle {
	public static void main(String[] args) {

		// 1つのRectangleオブジェクトを生成する
		System.out.println("Rectangleオブジェクト（x座標：4，y座標：2，幅：2，高さ：4）を生成");
		Rectangle r = new Rectangle(4, 2, 2, 4);

		// Rectangleオブジェクトの面積を得る
		System.out.println();
		System.out.printf("Rectangleオブジェクトの面積は%d\n", r.getArea());

		// Rectangleオブジェクトの状態を表示する
		System.out.println();
		System.out.println("Rectangleオブジェクトの状態：");
		r.showState();

		// ArrayListRectangleオブジェクトを生成，RectangleオブジェクトをArrayListに追加する
		System.out.println();
		System.out.println("ArrayListRectangleオブジェクトを生成，RectangleオブジェクトをArrayListに追加");
		ArrayListRectangle alr = new ArrayListRectangle();
		alr.addRectangle(0, r);

		// ArrayListのRectangleオブジェクトの個数を得る
		System.out.println();
		System.out.printf("ArrayListのRectangleオブジェクトの個数は%d\n", alr.getNumberOfRectangles());

		// ArrayListの0番目のRectangleオブジェクトの状態を表示する
		System.out.println();
		System.out.println("ArrayListの0番目のRectangleオブジェクトの状態：");
		alr.getRectangle(0).showState();

		// 4つのRectangleオブジェクトを生成，ArrayListに追加する
		System.out.println();
		System.out.println("4つのRectangleオブジェクトを生成，ArrayListに追加");
		alr.addRectangle(1, new Rectangle(7, 5, 2, 4));
		alr.addRectangle(2, new Rectangle(6, 3, 6, 4));
		alr.addRectangle(3, new Rectangle(4, 2, 2, 6));
		alr.addRectangle(4, new Rectangle(3, 3, 2, 5));

		// ArrayListの全てのRectangleオブジェクトの状態を表示する
		System.out.println();
		System.out.println("ArrayListの全てのRectangleオブジェクトの状態：");
		alr.showRectangleStates();

		// ArrayListの4番目のRectangleオブジェクトを指定のRectangleオブジェクトで置き換える
		System.out.println();
		System.out.println("ArrayListの4番目のRectangleオブジェクトを指定のRectangleオブジェクトで置き換え");
		alr.setRectangle(4, new Rectangle(6, 6, 3, 6));

		// ArrayListの2番目のRectangleオブジェクトを削除する
		System.out.println();
		System.out.println("ArrayListの2番目のRectangleオブジェクトを削除");
		alr.removeRectangle(2);

		// ArrayListの0番目と2番目のRectangleオブジェクトを入れ替える
		System.out.println();
		System.out.println("ArrayListの0番目と2番目のRectangleオブジェクトを入れ替え");
		alr.swapRectangle(0, 2);

		// ArrayListの全てのRectangleオブジェクトの状態を表示する
		System.out.println();
		System.out.println("ArrayListの全てのRectangleオブジェクトの状態：");
		alr.showRectangleStates();

		// ArrayListのRectangleオブジェクトの中で最小の面積を得る
		System.out.println();
		System.out.printf("ArrayListのRectangleオブジェクトの中で最小の面積は%d\n", alr.getMinArea());

		// ArrayListのRectangleオブジェクトの中で最大の面積を得る
		System.out.println();
		System.out.printf("ArrayListのRectangleオブジェクトの中で最大の面積は%d\n", alr.getMaxArea());

		// ArrayListのRectangleオブジェクトの中で面積が27以下のものを取り出す
		System.out.println();
		System.out.println("ArrayListのRectangleオブジェクトの中で面積が15以下のものを取り出す");
		ArrayList<Rectangle> result = alr.extractRectanglesByArea(15);
		for (Rectangle r0 : result)
			r0.showState();

	}
}
