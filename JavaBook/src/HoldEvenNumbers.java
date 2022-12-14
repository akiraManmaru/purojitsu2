
/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 10-1
 * 提出日 2021/11/30
 */
import java.util.ArrayList;
import java.util.Scanner;
/*
 * 入力値までの偶数を表示するクラス
 */

public class HoldEvenNumbers {
	ArrayList<Integer> evenNumbers;

	//コンストラクタ
	public HoldEvenNumbers() {
		/* Integer
		
		型ArrayListのオブジェクトを生成、フィールドで参照 */
		evenNumbers = new ArrayList<Integer>();

	}

	//指定した個数だけ、偶数をArrayListに追加するメソッド
	public void setEvenNumbers(int size) {
		/* 指定した個数だけ、偶数をArrayListに追加 */
		for (int i = 0; i < size; i++) {
			evenNumbers.add(i * 2);
		}
	}

	//ArrayListの全要素の値を拡張for文を使って表示するメソッド
	public void showAll() {
		/* ArrayListの全要素の値を拡張for文を使って表示 */

		for (int num : evenNumbers) {
			System.out.printf(" %d ", num);
		}
		System.out.println();
	}

	//evenNumbersの指定した位置に指定した値の要素を追加するメソッド
	public void addElement(int position, int value) {
		if (0 <= position && position <= evenNumbers.size()) {
			evenNumbers.add(position, value);
		}
		/* evenNumbersの指定した位置に指定した値の要素を追加*/

	}

	//evenNumbersから指定した位置の要素を消去するメソッド
	public void removeElement(int position) {
		if (0 <= position && position < evenNumbers.size()) {
			evenNumbers.remove(position);
		}
		/* evenNumbersから指定した位置の要素を削除 */

	}

	//メインメソッド
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner kbScanner = new Scanner(System.in);
		System.out.print("0以上の偶数の個数を入力してしてください:");
		int imput1 = kbScanner.nextInt();
		HoldEvenNumbers hen = new HoldEvenNumbers();
		hen.setEvenNumbers(imput1);
		System.out.print("0以上の偶数:");
		hen.showAll();
		System.out.print("追加する位置と値を入力してください:");
		int imput2 = kbScanner.nextInt();
		int imput3 = kbScanner.nextInt();
		hen.addElement(imput2, imput3);
		System.out.print("追加後の数列:");
		hen.showAll();
		System.out.print("消去する要素の位置を入力してください:");
		int imput4 = kbScanner.nextInt();
		hen.removeElement(imput4);
		System.out.print("消去後の数列:");
		hen.showAll();
		kbScanner.close();

	}

}
