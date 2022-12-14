package lesson12b.sort;

import java.util.List;
import lesson12b.data.Car;

public class InsertionSortSeats extends CarSort implements CarSortInterface {
	public void sort(List<Car> cars) {
		int n = cars.size();

		for (int k = 1; k < n; k++) {
			for (int j = k; j > 0; j--) {
				if (cars.get(j).getSeats() > cars.get(j - 1).getSeats()) {
					swap(cars, j, j - 1);

				} else
					break;
			}
		}
	}

}
