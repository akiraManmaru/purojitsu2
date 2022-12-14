package lesson14a.sorting;

import java.util.ArrayList;

import lesson14a.Unit;
import lesson14a.UnitOrder;

public class BubbleSort extends Sort {

	/**
	 * リストの要素をバブルソートを用いて昇順に並び替え，その結果を表示する
	 * @param unitArray  Integer型のArrayListのオブジェクト
	 */
	public void sort(ArrayList<Unit> unitArray, UnitOrder order) {
		int i, k, n;
		n = unitArray.size(); // リストの要素の個数を得る
		//printArray(unitArray);
		for (k = 1; k < n; k++) {
			for (i = 0; i < n - k; i++)
				if (order.comparator(unitArray.get(i), unitArray.get(i + 1)) > 0) {
					swap(unitArray, i, i + 1); // リストの指定した2つの要素を入れ替える
					//printArray(unitArray);
				}
		}
		printArray(unitArray);
	}

}
