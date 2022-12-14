
/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 10-3
 * 提出日 2021/11/30
 */
import java.util.ArrayList;
import java.util.Scanner;

/*
 * 素因数分解を行うクラス
 */
public class PrimeFactorization {
	private int upperNumber;
	ArrayList<Integer> primeNumbers;

	//コンストラクタ
	public PrimeFactorization(int upperNumber) {
		/* int型変数のフィールドに引数を代入 */
		this.upperNumber = upperNumber;
		/* Integer
		
		型ArrayListのオブジェクトを生成、フィールドで参照 */
		primeNumbers = new ArrayList<Integer>();

	}

	//ArrayListの全要素を表示するメソッド
	public void showAll() {
		/* ArrayListの全要素の値を拡張for文を使って表示 */

		for (int num : primeNumbers) {
			System.out.printf(" %d ", num);
		}
		System.out.println();
	}

	//ArrayList型の引数を持ち、primeNumbersの全要素を表示するメソッド
	public void showAll(ArrayList<Integer> list) {
		/* ArrayListの全要素の値を拡張for文を使って表示 */

		for (int num : list) {
			System.out.printf(" %d ", num);
		}
		System.out.println();
	}

	//
	public void addElement(int position, int value) {
		if (0 <= position && position <= primeNumbers.size()) {
			primeNumbers.add(position, value);
		}
		/* evenNumbersの指定した位置に指定した値の要素を追加*/

	}

	//evenNumbersから指定した位置の要素を削除するメソッド
	public void removeElement(int position) {
		if (0 <= position && position < primeNumbers.size()) {
			primeNumbers.remove(position);
		}
		/* evenNumbersから指定した位置の要素を削除 */

	}

	//奇数をprimeNumbersに追加するメソッド
	public void setOddNumbers() {
		/* 1からupperNumber以下の奇数を、primeNumbersに追加 */
		for (int i = 1; i < upperNumber + 1; i = i + 2) {
			primeNumbers.add(i);
		}
	}

	//素数をprimeNumbersに格納する
	public void setPrimeNumbers() {
		/* 1以上の奇数列を追加するsetOddNumbersメソッドを呼び出す */
		setOddNumbers();
		/* 1番目に
		2を追加するためaddElementメソッドを呼び出す */
		addElement(1, 2);

		/* 0番目の
		1を削除するためremoveElementメソッドを呼び出す */
		removeElement(0);
		/* 奇数の合成数を除くremoveOddCompNumbersメソッドを呼び出す*/
		removeOddCompNumbers();
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

	//素数で割り切れた回数をfrequenciesに格納するクラス
	public ArrayList<Integer> factorization(int number) {
		/* 素因数分解の結果(各素数の個数)を格納する
		Integer型ArrayListを生成、frequenciesで参照する */

		ArrayList<Integer> frequencies = new ArrayList<Integer>();

		/* primeNumsから素数primeを取り出す */
		for (int prime : primeNumbers) {
			int flag = 0;//割り切れる回数を代入する変数
			/* primeで割り切れた回数を初期化*/
			while (true) {
				if (number % prime == 0) {
					number = number / prime;
					flag++;
				} else {
					break;
				}
			}

			frequencies.add(flag);/* numberがprimeで割り切れる回数をカウントする */
		}
		return frequencies;
	}

	//メインメソッド
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		/* キーボードから3以上の整数を入力、その値を得る */
		Scanner kbScanner = new Scanner(System.in);
		System.out.print("3以上の整数を入力してください:");
		int imput1 = kbScanner.nextInt();
		/*入力した値を引数に指定、当クラスのオブジェクトを生成し、参照型変数で参照する */
		PrimeFactorization gf = new PrimeFactorization(imput1);
		gf.setPrimeNumbers();
		System.out.printf("%dまでの素数:", imput1);
		gf.showAll();
		/* 入力した値を引数に指定、factorizationメソッドを呼び出し、素因数分解の結果を得る */
		ArrayList<Integer> frequencies = gf.factorization(imput1);//factorizationメソッドの戻り値をfreqenciesに代入
		/* 素因数分解の結果を引数に指定、showAllメソッドを呼び出し、割り切れた回数を表示する */
		System.out.print("割り切れた回数:");
		gf.showAll(frequencies);
		kbScanner.close();

	}

}
