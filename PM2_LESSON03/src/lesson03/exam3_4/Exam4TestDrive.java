package lesson03.exam3_4;

/**
 * PasserineAdapterの挙動を確認するためのテストドライブ（パート2）
 * @author Kimiaki Shirahama
 */
public class Exam4TestDrive {
	public static void main(String[] args) {

		// Passerineインターフェースを実装するSwallowクラスを
		// PasserineAdapterに適用して、Turkeyインターフェース
		// としてのSwallowクラスの出力を確認する
		Turkey passerineAdapter = new PasserineAdapter(new Swallow());
		System.out.println("PasserineAdapter（ツバメ）の出力...");
		passerineAdapter.gobble();
		passerineAdapter.fly();

		// Passerineインターフェースを実装するLarkクラスを
		// PasserineAdapterに適用して、Turkeyインターフェース
		// としてのLarkクラスの出力を確認する
		passerineAdapter = new PasserineAdapter(new Lark());
		System.out.println("PasserineAdapter（ヒバリ）の出力...");
		passerineAdapter.gobble();
		passerineAdapter.fly();

	}
}
