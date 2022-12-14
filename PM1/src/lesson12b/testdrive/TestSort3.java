package lesson12b.testdrive;

import java.util.*;

import lesson12b.data.Car;
import lesson12b.sort.*;

public class TestSort3 {

	public static void main(String[] args) {

		List<Car> cars = new ArrayList<Car>();

		TestCar.addFiveCars(cars);

		for (Car c : cars)
			System.out.println(c);

		System.out.println(ElectricCarSortAlgorithm.QUICK_SORT_PRICE + "＝＝＝");
		ExecSort.execSort(new ArrayList<Car>(cars), new QuickSortPrice());

	}
}
