package lesson12b.testdrive;

import java.util.Scanner;

import lesson12b.data.ElectricCarDataServer;
import lesson12b.sort.ElectricCarSortAlgorithm;

public class TestECDSDumpSort1{

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		ElectricCarDataServer ecds = new ElectricCarDataServer(TestECDS.listTestCars());

		System.out.print("country：");
		String country = scanner.next();

		ecds = new ElectricCarDataServer(ecds.dumpCarsMadeIn(country));

		ExecECDSSort.execCDSSort(ecds, ElectricCarSortAlgorithm.INSERTION_SORT_TRAVELING_RANGE );
		ecds.showAllCars();
		scanner.close();

	}
}
