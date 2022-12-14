package lesson14a;

import java.util.ArrayList;

import lesson14a.sorting.BubbleSort;
import lesson14a.sorting.Sort;

public enum UnitOrder {
	HITPOINT(new BubbleSort()) {
		@Override
		public int comparator(Unit a, Unit b) {
			return b.getStatus().getHitPoint() - a.getStatus().getHitPoint();
		}
	},
	AGE(new BubbleSort()) {
		@Override
		public int comparator(Unit a, Unit b) {
			return a.getStatus().getAge() - b.getStatus().getAge();
		}
	};

	Sort sortMethod = null;

	private UnitOrder(Sort sort) {
		this.sortMethod = sort;
	}

	public void sort(ArrayList<Unit> unitArray) {
		if (sortMethod != null) {
			sortMethod.sort(unitArray, this);
		}
	}

	public abstract int comparator(Unit a, Unit b);

}
