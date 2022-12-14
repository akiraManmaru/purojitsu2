package lesson12a.sort;

import java.util.List;

public class BubbleSort extends Sort {

	/**
	 * リストの要素をバブルソートを用いて昇順に並び替え，その結果を表示する
	 * @param data  Integer型のListのオブジェクト
	 */
	public void sort(List<Integer> data) {
		int i, k, n;
		n = data.size(); // リストの要素の個数を得る
		printArray(data); // リストの要素を格納順に表示する
		for (k = 1; k < n; k++) {
			for (i = 0; i < n - k; i++)
				if (data.get(i) > data.get(i + 1)){
					swap(data, i, i + 1); // リストの指定した2つの要素を入れ替える
					printArray(data); // リストの要素を格納順に表示する
				}
		}
	}


}
