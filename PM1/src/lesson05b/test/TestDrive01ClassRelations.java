package lesson05b.test;

/**
 * クラス関係確認用 14:30までに提出すること
 * @author handa
 *
 */
public class TestDrive01ClassRelations {

	public static void main(String[] args) {
		// オブジェクト指向設計の予習確認テスト・期末テストと同じ要領で解答して，yourAnsに代入してください    
		//　各クラスにどのアルファベットを使うかは，課題PDFを参照してください
		// 委譲: X^Y
		// 継承：Y>Z
		// 実装：Z.X
		// 　　　↑の矢印を表す三文字が，辞書順になるようにハイフンを挟んで配置してください．
		String yourAns = "B>A-C>G-D.H-E>G-F.H-G^A-H^A-I>A-J>A";

		int ans = 484951907;
		String testName = "クラス図のクラス間の関係";
		printResult(yourAns.hashCode() == ans, testName);
	}

	/**
	 * テスト結果を表示する
	 * @param result テスト結果
	 * @param test テスト項目
	 */
	static void printResult(boolean result, String test) {
		if (result) {
			System.out.printf("%s \tの　テストOK\n", test);
		} else {
			System.out.printf("%s \tの　テストNG\n", test);
		}
	}

}
