package lesson12a.testdrive;

import java.util.ArrayList;
import java.util.List;

import lesson12a.sort.BubbleSort;
import lesson12a.sort.InsertionSort;
import lesson12a.sort.QuickSort;
import lesson12a.sort.SelectionSort;
import lesson12a.sort.Sort;

public class TestSort {
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

		// リストの要素をセレクションソートを使って昇順に並び替え，その結果を表示する
		System.out.println("セレクションソート");
		Sort sSort = new SelectionSort(); // SelectionSortオブジェクトを生成する
		sSort.sort(new ArrayList<Integer>(data));

		// リストの要素をインサーションソートを使って昇順に並び替え，その結果を表示する
		System.out.println("インサーションソート");
		Sort iSort = new InsertionSort(); // InsertionSortオブジェクトを生成する
		iSort.sort(new ArrayList<Integer>(data));

		// リストの要素をクイックソートを使って昇順に並び替え，その結果を表示する
		System.out.println("クイックソート");
		Sort qSort = new QuickSort(); // QuickSortオブジェクトを生成する
		qSort.sort(new ArrayList<Integer>(data));
	}
}
