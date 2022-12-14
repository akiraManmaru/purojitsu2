
/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 10-3
 * 提出日 2021/11/30
 */
import java.util.ArrayList;
import java.util.Scanner;
/*
 * 総数を計算し保持するクラス
 */

public class GeneratePrimeNumbers {
	private int upperNumber;
	ArrayList<Integer> primeNumbers;

	//コンストラクタ
	public GeneratePrimeNumbers(int upperNumber) {
		/* int型変数のフィールドに引数を代入 */
		this.upperNumber = upperNumber;
		/* Integer
		
		型ArrayListのオブジェクトを生成、フィールドで参照 */
		primeNumbers = new ArrayList<Integer>();

	}

	//ArrayListの全要素の値を拡張for文を使って表示するメソッド
	public void showAll() {
		/* ArrayListの全要素の値を拡張for文を使って表示 */

		for (int num : primeNumbers) {
			System.out.printf(" %d ", num);
		}
		System.out.println();
	}

	//evenNumbersの指定した位置に指定した値の要素を追加するクラス
	public void addElement(int position, int value) {
		if (0 <= position && position <= primeNumbers.size()) {
			primeNumbers.add(position, value);
		}
		/* evenNumbersの指定した位置に指定した値の要素を追加*/

	}

	//evenNumbersから指定した位置の要素を削除するクラス
	public void removeElement(int position) {
		if (0 <= position && position < primeNumbers.size()) {
			primeNumbers.remove(position);
		}
		/* evenNumbersから指定した位置の要素を削除 */

	}

	//1からupperNumber以下の奇数を、primeNumbersに追加するクラス
	public void setOddNumbers() {
		/* 1からupperNumber以下の奇数を、primeNumbersに追加 */
		for (int i = 1; i < upperNumber + 1; i = i + 2) {
			primeNumbers.add(i);
		}
	}

	//奇数の合成数を消去するメソッド
	public void removeOddCompNumbers() {

		int i = 1;
		while (primeNumbers.get(i) <= (int) Math.sqrt(upperNumber)) {
			int j = i + 1;
			while (j < primeNumbers.size()) {
				if (primeNumbers.get(j) % primeNumbers.get(i) == 0) {
					primeNumbers.remove(j);
				} else {
					j++;
				}

			}

			i++;
		}
	}

	//メインメソッド
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner kbScanner = new Scanner(System.in);
		System.out.print("3以上の素数の上限を入力してください:");
		/* キーボードから3以上の整数を入力、その値を得る */
		int imput1 = kbScanner.nextInt();
		/* 入力された値を引数に指定、当クラスのオブジェクトを生成し、参照型変数で参照 */
		GeneratePrimeNumbers gpn = new GeneratePrimeNumbers(imput1);
		System.out.printf("%dまでの奇数:", imput1);
		/* 1以上の奇数列を追加するsetOddNumbersメソッドを呼び出す */
		gpn.setOddNumbers();
		/* showAllメソッドを呼び出す */
		gpn.showAll();
		/* 1番目に2を追加するためaddElementメソッドを呼び出す */
		System.out.print("1番目に2を追加:");
		gpn.addElement(1, 2);
		gpn.showAll();
		/* 0番目の1を削除するためremoveElementメソッドを呼び出す */
		System.out.print("0番目の要素を消去:");
		gpn.removeElement(0);
		/* showAllメソッドを呼び出す */
		gpn.showAll();
		System.out.print("奇数の合成数を消去:");
		/*奇数の合成数を除くremoveOddCompNumbersメソッドを呼び出す*/
		gpn.removeOddCompNumbers();
		gpn.showAll();
		kbScanner.close();

	}

}
