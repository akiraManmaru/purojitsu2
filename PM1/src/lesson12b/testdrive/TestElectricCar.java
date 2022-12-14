package lesson12b.testdrive;

import java.util.*;

import lesson12b.data.*;


public class TestElectricCar {

	public static void main(String[] args) {

		List<Car> cars = new ArrayList<>();

		addFourCars(cars);

		System.out.println("getterを使った表示＝＝＝");
		for (Car c : cars) {
			String str = String.format("%s,%s,%d人,%d万円(%s,%d),%dkm",
					c.getManufacturer(), c.getName(), c.getSeats(),
					c.getPrice(), c.getCountry(), c.getYear(),
					((ElectricCar)c).getTravelingRange());
			System.out.println(str);
		}
		System.out.println("toStringを使った表示＝＝＝");
		for (Car c : cars) {
			System.out.println(c);
		}

	}

	protected static void addFourCars(List<Car> cars) {

		cars.add(new ElectricCar("リーフ","NISSAN","Japan",2010,332,5,400));
		cars.add(new ElectricCar("サクラ","NISSAN","Japan",2022,180,4,180));
		cars.add(new ElectricCar("コムス","TOYOTA","Japan",2012,57,1,57));
		cars.add(new ElectricCar("モデルX","TESLA","USA",2015,1299,7,507));

	}

}
