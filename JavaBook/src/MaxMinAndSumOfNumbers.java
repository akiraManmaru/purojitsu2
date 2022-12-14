
/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 8-4
 * 提出日 2021/11/9
 */
import java.util.Scanner;
/*
 * 何個かの整数の最大値、最小値、和などを求める機能を持つクラス
 */

// キーボード入力のためのクラスをimport
public class MaxMinAndSumOfNumbers {
	// int型配列フィールド numbers の宣言
	private int[] numbers;

	public MaxMinAndSumOfNumbers(int[] numbers) {//コンストラクタ
		this.numbers = numbers;
	}

	public void showAll() {//for文を用い結果を表示するメソッド
		/* for文を使って実行例のように表示 */
		System.out.print("[");
		for (int i = 0; i < numbers.length; i++) {
			System.out.printf("%s", this.numbers[i]);
		}
		System.out.println("]");
	}

	public int max() {
		/* numbers中の最大値を返すメソッド */
		int max = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] >= max) {
				max = numbers[i];
			}
		}
		return max;
	}

	public int min() {
		/* numbers中の最小値を返すメソッド */
		int mini = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] <= mini) {
				mini = numbers[i];
			}
		}
		return mini;
	}

	public int sum() {
		/* numbersの総和を返すメソッド */
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		return sum;
	}

	public void incrementElement(int idx) {
		/* 添字idxの値を1増やすメソッド,
		idxが範囲外のときの対応もする */

		if (idx < 0 || idx > numbers.length - 1) {
			System.out.println("範囲外の添字を指定しています");

		} else {
			numbers[idx]++;
		}

	}

	public void decrementElement(int idx) {
		/* 添字idxの値を1減らすメソッド,
		idxが範囲外のときの対応もする */
		if (idx < 0 || idx > numbers.length - 1) {//-1大事
			System.out.println("範囲外の添字を指定しています");

		} else {
			numbers[idx]--;
		}

	}

	public void copyElement(int dest, int src) {
		/* 添字destの値を添字srcの値に更新するメソッド,
		idxが範囲外のときの対応もする */
		if ((dest < 0 || dest > numbers.length - 1) || (src < 0 || src > numbers.length - 1)) {//-1大事
			System.out.println("範囲外の添字を指定しています");

		} else {
			numbers[dest] = numbers[src];
		}

	}

	public static void main(String[] args) {

		Scanner keyBoardScanner = new Scanner(System.in);

		System.out.print("配列サイズを入力してください:");
		int input = keyBoardScanner.nextInt();
		int[] numbers = new int[input];
		System.out.print("値を入力してください:");
		for (int i = 0; i < numbers.length; i++)
			numbers[i] = keyBoardScanner.nextInt();

		MaxMinAndSumOfNumbers mmsNumbers = new MaxMinAndSumOfNumbers(numbers);
		mmsNumbers.showAll();
		System.out.printf("最大値は%dです.最小値は%dです.総和は%dです.\n", mmsNumbers.max(), mmsNumbers.min(), mmsNumbers.sum());
		for (int i = 0; i < 3; i++) { // 3回繰り返す
			System.out.print("どの添字を更新しますか:");
			int idx = keyBoardScanner.nextInt();
			System.out.print("更新値を入力してください:");
			input = keyBoardScanner.nextInt();
			numbers[idx] = input; // numbersの要素を書き換える
			mmsNumbers.showAll();
			System.out.printf("最大値は%dです.最小値は%dです.総和は%dです.\n", mmsNumbers.max(), mmsNumbers.min(), mmsNumbers.sum());// 前ページの最後のprintfと同様に
		}
		for (int i = 0; i < 3; i++) { // 3回繰り返す
			System.out.print("どの添字の値を増やしますか:");
			int idx = keyBoardScanner.nextInt();
			mmsNumbers.incrementElement(idx);
			System.out.print("どの添字の値を減らしますか:");
			idx = keyBoardScanner.nextInt();
			mmsNumbers.decrementElement(idx);
			System.out.print("どの添字の値をどの添字の値に更新しますか:");
			idx = keyBoardScanner.nextInt();
			int idx2 = keyBoardScanner.nextInt();
			mmsNumbers.copyElement(idx, idx2);
			mmsNumbers.showAll();
			System.out.printf("最大値は%dです.最小値は%dです.総和は%dです.\n", mmsNumbers.max(), mmsNumbers.min(), mmsNumbers.sum());// 前ページの最後のprintfと同様に
		}

		keyBoardScanner.close();
	}
}