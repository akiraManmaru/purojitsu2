package lesson12b.testdrive;

import java.util.List;

import lesson12b.data.*;
import lesson12b.sort.CarSortInterface;

public class ExecSort {

	public static void execSort(List<Car> cars,
			CarSortInterface csi) {

		csi.sort(cars);
		for(Car c : cars)
			System.out.println(c);
	}
}
