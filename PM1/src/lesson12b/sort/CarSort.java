package lesson12b.sort;

import java.util.List;

import lesson12b.data.Car;

/**
 * CarのListをソートするためのクラスのスーパークラスとなる抽象クラス
 * @author moriya
 */
public abstract class CarSort {

	/**
	 * CarのListのインデックスiとjを入れ替える
	 * @param cars CarのList
	 * @param i 入れ替え対象のインデックス
	 * @param j 入れ替え対象のインデックス
	 */
	protected void swap(List<Car> cars, int i, int j){

		Car tmp = cars.get(i);
		cars.set(i, cars.get(j));
		cars.set(j, tmp);

	}
}
