package lesson12b.testdrive;

import java.util.*;

import lesson12b.data.Car;
import lesson12b.sort.*;

public class TestSort1 {

	public static void main(String[] args) {

		List<Car> cars = new ArrayList<Car>();

		TestCar.addFiveCars(cars);

		for (Car c : cars)
			System.out.println(c);

		System.out.println(ElectricCarSortAlgorithm.INSERTION_SORT_YEAR + "＝＝＝");
		ExecSort.execSort(new ArrayList<Car>(cars), new InsertionSortYear());

	}
}
