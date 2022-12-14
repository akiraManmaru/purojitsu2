package lesson12b.sort;

import java.util.List;

import lesson12b.data.Car;

public class SelectionSortSeats extends CarSort implements CarSortInterface {
	public void sort(List<Car> cars) {
		int n = cars.size();

		for (int k = 1; k < n; k++) {
			int m = 0;
			for (int i = 1; i <= n - k; i++) {
				if (cars.get(m).getSeats() > cars.get(i).getSeats())
					m = i;
			}
			swap(cars, m, n - k);

		}

	}

}
