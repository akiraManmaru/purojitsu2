package lesson12b.testdrive;

import java.util.*;

import lesson12b.data.*;

public class TestECDSDump2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		ElectricCarDataServer ecds = new ElectricCarDataServer(TestECDS.listTestCars());

		ecds.showAllCars();

		System.out.print("manufacturer：");
		String manufacturer = scanner.next();

		ecds = new ElectricCarDataServer(ecds.dumpCarsMadeBy(manufacturer));

		ecds.showAllCars();

		scanner.close();
	}

}
