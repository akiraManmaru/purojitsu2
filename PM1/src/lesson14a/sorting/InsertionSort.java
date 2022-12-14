package lesson14a.sorting;

import java.util.ArrayList;

import lesson14a.Unit;
import lesson14a.UnitOrder;

public class InsertionSort extends Sort {
	public void sort(ArrayList<Unit> unitArray, UnitOrder order) {
		int n = unitArray.size();
		//printArray(unitArray);
		for (int k = 1; k < n; k++) {
			for (int j = k; j > 0; j--) {
				if (order.comparator(unitArray.get(j), unitArray.get(j + 1)) > 0) {
					swap(unitArray, j, j - 1);
					//printArray(unitArray);
				} else
					break;
			}
		}
		printArray(unitArray);
	}

}