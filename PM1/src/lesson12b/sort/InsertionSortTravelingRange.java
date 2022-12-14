package lesson12b.sort;

import java.util.List;

import lesson12b.data.Car;
import lesson12b.data.ElectricCar;

public class InsertionSortTravelingRange extends CarSort implements CarSortInterface {
	public void sort(List<Car> cars) {
		int n = cars.size();

		for (int k = 1; k < n; k++) {
			for (int j = k; j > 0; j--) {
				ElectricCar ec1;
				ElectricCar ec2;
				if (cars.get(j) instanceof ElectricCar) {
					ec1 = (ElectricCar) cars.get(j);
					if (cars.get(j - 1) instanceof ElectricCar) {
						ec2 = (ElectricCar) cars.get(j - 1);
						if (ec1.getTravelingRange() > ec2.getTravelingRange()) {
							swap(cars, j, j - 1);

						} else
							break;
					}

				}

			}
		}
	}

}
