package lesson12a.testdrive;

import java.util.ArrayList;
import java.util.List;

import lesson12a.sort.Sort;
import lesson12a.sort.BubbleSort;

public class TestBubbleSort {
	public static void main(String[] args) {

		// Integer型のArrayListのオブジェクトを生成する
		List<Integer> data = new ArrayList<Integer>();

		// リストに要素（Integer型の値）を追加する
		data.add(8);
		data.add(5);
		data.add(12);
		data.add(3);
		data.add(0);
		data.add(9);

		// リストの要素をバブルソートを使って昇順に並び替え，その結果を表示する
		System.out.println("バブルソート");
		Sort bSort = new BubbleSort(); // BubbleSortオブジェクトを生成する
		bSort.sort(new ArrayList<Integer>(data));

	}
}
