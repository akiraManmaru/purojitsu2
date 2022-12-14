package lesson12b.testdrive;

import lesson12b.data.ElectricCarDataServer;
import lesson12b.sort.ElectricCarSortAlgorithm;

public class TestECDSSort3{

	public static void main(String[] args) {

		ElectricCarDataServer ecds = new ElectricCarDataServer(TestECDS.listTestCars());


		ExecECDSSort.execCDSSort(ecds, ElectricCarSortAlgorithm.QUICK_SORT_PRICE );
		ecds.showAllCars();

	}
}
