package lesson12b.sort;

import java.util.List;

import lesson12b.data.Car;

public class BubbleSortSeats extends CarSort implements CarSortInterface {
	public void sort(List<Car> cars) {
		int i, k, n;
		n = cars.size(); // リストの要素の個数を得る

		for (k = 1; k < n; k++) {
			for (i = 0; i < n - k; i++)
				if (cars.get(i).getSeats() < cars.get(i + 1).getSeats()) {
					swap(cars, i, i + 1); // リストの指定した2つの要素を入れ替える

				}
		}
	}
}
