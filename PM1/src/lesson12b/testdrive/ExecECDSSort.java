package lesson12b.testdrive;

import lesson12b.data.ElectricCarDataServer;
import lesson12b.sort.ElectricCarSortAlgorithm;

public class ExecECDSSort {

	protected static void execCDSSort(ElectricCarDataServer ecds,
			ElectricCarSortAlgorithm ecsa) {

		System.out.println(ecsa + "＝＝＝");
		ecds.sort(ecsa);
	}
}
