package lesson12b.testdrive;

import lesson12b.data.ElectricCarDataServer;
import lesson12b.sort.ElectricCarSortAlgorithm;

public class TestECDSSort2{

	public static void main(String[] args) {

		ElectricCarDataServer ecds = new ElectricCarDataServer(TestECDS.listTestCars());
		ExecECDSSort.execCDSSort(ecds, ElectricCarSortAlgorithm.BUBBLE_SORT_SEATS );
		ecds.showAllCars();

		ecds = new ElectricCarDataServer(TestECDS.listTestCars());
		ExecECDSSort.execCDSSort(ecds, ElectricCarSortAlgorithm.SELECTION_SORT_SEATS );
		ecds.showAllCars();

		ecds = new ElectricCarDataServer(TestECDS.listTestCars());
		ExecECDSSort.execCDSSort(ecds, ElectricCarSortAlgorithm.INSERTION_SORT_SEATS );
		ecds.showAllCars();
	}
}
