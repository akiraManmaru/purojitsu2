package lesson14a.sorting;

import java.util.ArrayList;

import lesson14a.Unit;
import lesson14a.UnitOrder;


public abstract class Sort {


	public abstract void sort(ArrayList<Unit> unitArray, UnitOrder order);


	protected void swap(ArrayList<Unit> unitArray, int i, int j){

		Unit tmp;
		tmp = unitArray.get(i);
		unitArray.set(i,unitArray.get(j));
		unitArray.set(j, tmp);

	}

	protected void printArray(ArrayList<Unit> unitArray) {
		for (Unit element : unitArray) {
			element.showStatus();
		}
		System.out.println();
	}
}
