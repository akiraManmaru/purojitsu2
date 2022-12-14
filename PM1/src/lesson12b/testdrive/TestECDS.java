package lesson12b.testdrive;

import java.util.*;

import lesson12b.data.*;

public class TestECDS {

	public static void main(String[] args) {

		ElectricCarDataServer ecds = new ElectricCarDataServer(listTestCars());

		ecds.showAllCars();

	}

	protected static List<Car> listTestCars() {

		List<Car> ret = new ArrayList<>();

		ret.add(new ElectricCar("コムス", "TOYOTA", "Japan", 2012, 57, 1, 57));
		ret.add(new ElectricCar("MIRAI", "TOYOTA", "Japan", 2020, 710, 5, 134));
		ret.add(new ElectricCar("bZ4X", "TOYOTA", "Japan", 2022, 600, 5, 460));
		ret.add(new ElectricCar("リーフ", "NISSAN", "Japan", 2010, 332, 5, 400));
		ret.add(new ElectricCar("アリア", "NISSAN", "Japan", 2021, 539, 5, 450));
		ret.add(new ElectricCar("サクラ", "NISSAN", "Japan", 2022, 233, 4, 180));
		ret.add(new ElectricCar("Honda e", "HONDA", "Japan", 2020, 451, 4, 308));
		ret.add(new ElectricCar("MX-30", "MAZDA", "Japan", 2020, 242, 5, 256));
		ret.add(new ElectricCar("ライクT3", "MITSUOKA", "Japan", 2012, 129, 2, 40));
		ret.add(new ElectricCar("モデルS", "TESLA", "USA", 2012, 1199, 5, 663));
		ret.add(new ElectricCar("モデルX", "TESLA", "USA", 2015, 1299, 7, 507));
		ret.add(new ElectricCar("モデル3", "TESLA", "USA", 2016, 579, 5, 409));

		return ret;
	}
}
