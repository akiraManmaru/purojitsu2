package lesson12b.data;

import java.util.ArrayList;
import java.util.List;

import lesson12b.sort.BubbleSortSeats;
import lesson12b.sort.CarSortInterface;
import lesson12b.sort.ElectricCarSortAlgorithm;
import lesson12b.sort.InsertionSortSeats;
import lesson12b.sort.InsertionSortTravelingRange;
import lesson12b.sort.InsertionSortYear;
import lesson12b.sort.QuickSortPrice;
import lesson12b.sort.SelectionSortSeats;

public class ElectricCarDataServer {
	private List<Car> cars;

	public ElectricCarDataServer(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> dumpCarsMadeBy(String manufacturer) {
		List<Car> list = new ArrayList<>();
		for (Car c : cars) {
			if (c.getManufacturer().equals(manufacturer)) {
				list.add(c);
			}
		}
		return list;
	}

	public List<Car> dumpCarsMadeIn(String country) {
		List<Car> list = new ArrayList<>();
		for (Car c : cars) {
			if (c.getCountry().equals(country)) {
				list.add(c);
			}
		}
		return list;
	}

	public void showAllCars() {
		if (cars.size() == 0) {
			System.out.println("該当する自動車はありません");
		}

		for (Car c : cars)
			System.out.println(c);

	}

	public List<Car> sort(ElectricCarSortAlgorithm sortAlgorithm) {
		CarSortInterface csi;
		switch (sortAlgorithm) {
		case INSERTION_SORT_YEAR:
			csi = new InsertionSortYear();
			csi.sort(cars);
			break;
		case BUBBLE_SORT_SEATS:
			csi = new BubbleSortSeats();
			csi.sort(cars);
			break;
		case SELECTION_SORT_SEATS:
			csi = new SelectionSortSeats();
			csi.sort(cars);
			break;
		case INSERTION_SORT_SEATS:
			csi = new InsertionSortSeats();
			csi.sort(cars);
			break;
		case QUICK_SORT_PRICE:
			csi = new QuickSortPrice();
			csi.sort(cars);
			break;
		case INSERTION_SORT_TRAVELING_RANGE:
			csi = new InsertionSortTravelingRange();
			csi.sort(cars);
			break;
		}
		return cars;
	}

}
