
/*
提出者 21-1-037-0034 池上開世
課題 13-1
提出日 2021/12/21
*/
import java.util.ArrayList;
import java.util.Scanner;

/*
 * キーボード入力した値をArrayListで管理するためのクラス
 */
public class DataStorage {
	private ArrayList<Double> data;
	private Scanner kbScanner;

	//コンストラクタ
	public DataStorage() {
		kbScanner = new Scanner(System.in);
		data = new ArrayList<>();
	}

	//データを格納するメソッド
	public void enterData(int numOfData) {
		for (int i = 0; i < numOfData; i++) {//データの数だけループ
			if (kbScanner.hasNextDouble()) {//double型ならtrueを返す
				double a = kbScanner.nextDouble();
				data.add(i, a);
			} else {
				System.out.println("浮動小数点数以外が入力されました。終了します。");
				System.exit(0);//強制終了
			}

		}

	}

	//データを取得する
	public double valueAt(int i) {
		return data.get(i);
	}

	//メインメソッド
	public static void main(String[] args) {
		int numOfData = 3;
		DataStorage dStorage = new DataStorage();//オブジェクト生成
		System.out.printf("%d 個の浮動小数点数をスペース区切りで入力: ", numOfData);
		dStorage.enterData(numOfData);
		for (int i = 0; i < numOfData; i++) {
			System.out.printf("data%d: %4.2f ", i + 1, dStorage.valueAt(i));
		}
		System.out.println();

		numOfData = 2;
		System.out.printf("%d 個の浮動小数点数をスペース区切りで入力: ",

				numOfData);
		dStorage.enterData(numOfData);
		for (int i = 0; i < numOfData; i++) {
			System.out.printf("data%d: %4.2f ", i + 1, dStorage.valueAt(i));
		}
	}

}
