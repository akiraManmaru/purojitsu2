package lesson12b.sort;

import java.util.List;

import lesson12b.data.Car;

public class QuickSortPrice extends CarSort implements CarSortInterface {
	public void sort(List<Car> cars) {
		int n = cars.size();

		quickSort(cars, 0, n - 1);
	}

	public void quickSort(List<Car> cars, int left, int right) {
		int mid = (left + right) / 2;
		Car c = cars.get(mid);
		int i = left;
		int j = right;
		while (i <= j) {
			while (cars.get(i).getPrice() < c.getPrice())
				i++;
			while (cars.get(j).getPrice() > c.getPrice())
				j--;
			if (i <= j) {
				swap(cars, i++, j--);

			}
		}
		if (left < j)
			quickSort(cars, left, j);
		if (i < right)
			quickSort(cars, i, right);
	}

}
