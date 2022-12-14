package lesson12a.sort;

import java.util.List;

public abstract class Sort {

	/**
	 * 抽象メソッド．リストの要素を実装されたソートアルゴリズムを用いて並び替える
	 * @param data  Integer型のListのオブジェクト
	 */
	public abstract void sort(List<Integer> data);

	/**
	 * リストの要素を格納順に表示する
	 * @param data  Integer型のListのオブジェクト
	 */
	protected void printArray(List<Integer> data) {
		for (int element : data) {
			System.out.printf("%d ", element);
		}
		System.out.println();
	}

	/**
	 * リストの指定した2つの要素を入れ替える
	 * @param data  Integer型のListのオブジェクト
	 * @param i  1つ目の要素の位置
	 * @param j  2つ目の要素の位置
	 */
	protected void swap(List<Integer> data, int i, int j) {
		int tmp;
		tmp = data.get(i);
		data.set(i, data.get(j));
		data.set(j, tmp);
	}
}
