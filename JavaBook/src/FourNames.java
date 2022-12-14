
/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 8-3
 * 提出日 2021/11/9
 */
import java.util.Scanner;

/*
 * 4人の名前を管理するクラス
 */
public class FourNames {

	private String[] names; // String型配列 names の宣言

	public FourNames() {//コンストラクタ

		names = new String[4];// フィールドnamesを,サイズ4の配列として生成

	}

	public void showAll() {//for文を用い結果を表示するメソッド

		/* for文を使って実行例の2行目のように表示 */
		System.out.print("[");
		for (int i = 0; i < 4; i++) {
			System.out.printf("%s", this.getName(i));
		}
		System.out.println("]");

	}

	public String getName(int idx) {//添字から名前を返すメソッド
		String str;
		/* namesの添字idxの値を戻す,
		指示どおりにidxが範囲外のときの対応もする */
		if (idx > 3 || idx < 0) {
			str = null;
		} else {
			str = names[idx];
		}
		return str;

	}

	public void setName(int idx, String newName) {//名前を変更するメソッド

		/* namesの添字idxの値をnewNameに更新,
		指示どおりにidxが範囲外のときの対応もする */
		if (idx <= 3 && idx >= 0) {
			names[idx] = newName;
		}

	}

	//メインメソッド
	public static void main(String[] args) {

		Scanner keyBoardScanner = new Scanner(System.in);

		FourNames fourNames = new FourNames();
		fourNames.showAll();
		for (int i = 0; i < 4; i++) { // 4回繰り返す
			System.out.printf("添字%dの名前を入力:", i);
			fourNames.setName(i, keyBoardScanner.next());
		}
		fourNames.showAll();
		for (int i = 0; i < 4; i++) { // 4回繰り返す
			System.out.print("どの添字の名前を表示しますか:");
			System.out.println(fourNames.getName(
					keyBoardScanner.nextInt()));
		}
		for (int i = 0; i < 3; i++) { // 3回繰り返す
			System.out.print("どの添字の名前を変更しますか:");
			int idx = keyBoardScanner.nextInt();//入力した値を代入
			System.out.print("新しい名前を入力:");
			String newName = keyBoardScanner.next();//入力した値を代入
			fourNames.setName(idx, newName);//setName呼び出し
		}
		fourNames.showAll();

		keyBoardScanner.close();
	}
}
