package midrep01.s02;

import java.util.ArrayList;
import java.util.List;

/**
 * 各立体クラスのテストを行うテストクラス
 */
public class TestSolidFigure {
	/**
	 * 各立体クラスについて、体積を求めるメソッドのテストを行う
	 */
	public static void main(String[] args) {
		List<SolidFigure> solidFigures = new ArrayList<SolidFigure>();
		// 各立体クラスのインスタンスを作ってArrayListに追加
		solidFigures.add(new Cone(3.0, 2.0));
		solidFigures.add(new Cylinder(5.0, 3.0));
		solidFigures.add(new RectangularPyramid(3.0, 4.0, 2.5));
		solidFigures.add(new RectangularPrism(3.0, 4.0, 2.5));

		// ArrayListの各要素の立体の体積を求めて出力
		for(SolidFigure solidFigure: solidFigures) {
			System.out.printf("%.2f\n", solidFigure.getVolume());
		}
		// 以下のように出力するはず
		// 12.57
		// 141.37
		// 10.00
		// 30.00
	}
}
