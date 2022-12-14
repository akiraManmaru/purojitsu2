/**
 * RectangleオブジェクトのArrayListを操作，処理するクラス
 */
package lesson02b.arraylist;

import java.util.ArrayList;

public class ArrayListRectangle {
	private ArrayList<Rectangle> listOfRectangle; // Rectangleオブジェクトを収容するリスト

	/**
	 * コンストラクタではRectangleオブジェクト（の参照）を要素にもつArrayListオブジェクトを生成して
	 * listOfRectanglesフィールドに（その参照を）格納する
	 */
	public ArrayListRectangle() {
		listOfRectangle = new ArrayList<>();

	}

	/**
	 * ArrayListの指定した位置にRectangleオブジェクトを追加する
	 * @param i ArrayListの位置
	 * @param r 追加するRectangleオブジェクト
	 */
	public void addRectangle(int i, Rectangle r) {
		if (0 <= i && i <= listOfRectangle.size()) { // 指定した位置がリストサイズの範囲内であれば
			listOfRectangle.add(i, r);
		}
	}

	/**
	 * ArrayListのRectangleオブジェクトの個数を得る 
	 * @return  Rectangleオブジェクトの個数
	 */
	public int getNumberOfRectangles() {
		return listOfRectangle.size();
	}

	/**
	 * ArrayListの指定した位置のRectangleオブジェクトを得る
	 * @param i ArrayListの位置
	 * @return  得られたRectangleオブジェクト
	 */
	public Rectangle getRectangle(int i) {
		if (0 <= i && i < listOfRectangle.size() && listOfRectangle.size() != 0) { // 指定した位置がリストサイズの範囲内であれば
			return listOfRectangle.get(i);
		} else {
			return null;
		}
	}

	/**
	 * ArrayListの全てのRectangleオブジェクトの状態を表示する
	 */
	public void showRectangleStates() {
		for (Rectangle r : listOfRectangle) {
			r.showState();
		}
	}

	/**
	 * ArrayListの指定した位置のRectangleオブジェクトを指定のRectangleオブジェクトで置き換える 
	 * @param i ArrayListの位置
	 * @param r 置き換えるRectangleオブジェクト
	 */
	public void setRectangle(int i, Rectangle r) {
		if (!listOfRectangle.isEmpty() && i >= 0) {
			listOfRectangle.set(i, r);
		} else {
			System.out.println("list is Empty");
		}
	}

	/**
	 * ArrayListの指定した位置のRectangleオブジェクトを削除する 
	 * @param i ArrayListの位置
	 */
	public void removeRectangle(int i) {
		if (!listOfRectangle.isEmpty()) {
			listOfRectangle.remove(i);
		}
	}

	/**
	 * ArrayListの2つの指定した位置のRectangleオブジェクトを入れ換える
	 * @param　i  1つ目のArrayListの位置
	 * @param　j  2つ目のArrayListの位置
	 */
	public void swapRectangle(int i, int j) {
		Rectangle r2 = listOfRectangle.get(i);
		if (i == j) {

		} else if (listOfRectangle.size() >= 2) {
			listOfRectangle.set(i, listOfRectangle.get(j));
			listOfRectangle.set(j, r2);
		}
	}

	/**
	 * ArrayListのRectangleオブジェクトの中から，面積の最小値を得る
	 * @return　面積の最小値
	 */
	public int getMinArea() {
		int min = listOfRectangle.get(0).getArea();
		for (int i = 0; i < listOfRectangle.size(); i++) {
			if (min > listOfRectangle.get(i).getArea()) {
				min = listOfRectangle.get(i).getArea();
			}
		}
		return min;
	}

	/**
	 * ArrayListのRectangleオブジェクトの中から，面積の最大値を得る
	 * @return　面積の最大値
	 */
	public int getMaxArea() {
		int max = 0;
		for (Rectangle r : listOfRectangle) {
			if (max < r.getArea()) {
				max = r.getArea();
			}
		}
		return max;
	}

	/**
	 * ArrayListのRectangleオブジェクトの中で，指定した面積以下のRectangleオブジェクトを取り出す 
	 * @param a 指定の面積
	 * @return  該当のRectangleオブジェクトを格納したArrayListオブジェクト
	 */
	public ArrayList<Rectangle> extractRectanglesByArea(int a) {
		ArrayList<Rectangle> r1 = new ArrayList<>();

		for (Rectangle r : listOfRectangle) {
			if (a > r.getArea()) {
				r1.add(r);
			}
		}
		return r1;
	}

}
