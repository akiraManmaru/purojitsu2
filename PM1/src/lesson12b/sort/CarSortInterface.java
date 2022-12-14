package lesson12b.sort;

import java.util.List;

import lesson12b.data.Car;

/**
 * CarオブジェクトListに対するソートアルゴリズムのインタフェース
 * @author Sen MORIYA
 *
 */
public interface CarSortInterface {

	/**
	 * CarのListに対するソートを行う
	 * @param cars 探索対象のArrayList
	 */
	public void sort(List<Car> cars);

}
