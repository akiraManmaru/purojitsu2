package lesson12b.testdrive;

import java.util.*;

import lesson12b.data.*;

public class TestECDSDump1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		ElectricCarDataServer ecds = new ElectricCarDataServer(TestECDS.listTestCars());

		ecds.showAllCars();

		System.out.print("country：");
		String country = scanner.next();

		ecds = new ElectricCarDataServer(ecds.dumpCarsMadeIn(country));

		ecds.showAllCars();

		scanner.close();
	}

}
