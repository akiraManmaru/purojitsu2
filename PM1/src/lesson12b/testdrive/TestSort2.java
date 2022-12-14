package lesson12b.testdrive;

import java.util.*;

import lesson12b.data.Car;
import lesson12b.sort.*;

public class TestSort2 {

	public static void main(String[] args) {

		List<Car> cars = new ArrayList<Car>();

		TestCar.addFiveCars(cars);

		for (Car c : cars)
			System.out.println(c);

		System.out.println(ElectricCarSortAlgorithm.BUBBLE_SORT_SEATS + "＝＝＝");
		ExecSort.execSort(new ArrayList<Car>(cars), new BubbleSortSeats());

		System.out.println(ElectricCarSortAlgorithm.SELECTION_SORT_SEATS + "＝＝＝");
		ExecSort.execSort(new ArrayList<Car>(cars), new SelectionSortSeats());

		System.out.println(ElectricCarSortAlgorithm.INSERTION_SORT_SEATS + "＝＝＝");
		ExecSort.execSort(new ArrayList<Car>(cars), new InsertionSortSeats());
	}
}
