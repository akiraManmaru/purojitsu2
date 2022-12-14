package lesson12b.testdrive;

import java.util.*;

import lesson12b.data.Car;

public class TestCar {

	public static void main(String[] args) {

		List<Car> cars = new ArrayList<>();

		addFiveCars(cars);

		System.out.println("getterを使った表示＝＝＝");
		for (Car c : cars) {
			String str = String.format("%s,%s,%d人,%d万円(%s,%d)",
					c.getManufacturer(), c.getName(), c.getSeats(),
					c.getPrice(), c.getCountry(), c.getYear());
			System.out.println(str);
		}
		System.out.println("toStringを使った表示＝＝＝");
		for (Car c : cars) {
			System.out.println(c);
		}
	}

	protected static void addFiveCars(List<Car> cars) {

		cars.add(new Car("コペン","DAIHATSU","Japan",2002,194,2));
		cars.add(new Car("リーフ","NISSAN","Japan",2010,332,5));
		cars.add(new Car("エクストレイル","NISSAN","Japan",2000,248,5));
		cars.add(new Car("サクラ","NISSAN","Japan",2022,180,4));
		cars.add(new Car("モデルX","TESLA","USA",2015,1299,7));
	}

}
