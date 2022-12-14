package lesson12b.testdrive;

import java.util.*;

import lesson12b.data.Car;
import lesson12b.sort.*;

public class TestSort4 {

	public static void main(String[] args) {

		List<Car> cars = new ArrayList<Car>();

		TestElectricCar.addFourCars(cars);

		for (Car c : cars)
			System.out.println(c);

		System.out.println(ElectricCarSortAlgorithm.INSERTION_SORT_TRAVELING_RANGE + "＝＝＝");
		ExecSort.execSort(new ArrayList<Car>(cars), new InsertionSortTravelingRange());

	}
}
