package lesson03.exam3_4;

/**
 * PasserineAdapterの挙動を確認するためのテストドライブ
 * @author Kimiaki Shirahama
 */
public class Exam3TestDrive {
	public static void main(String[] args) {
		// Passerineインターフェースを実装するSwallowクラスを
		// PasserineAdapterに適用して、Turkeyインターフェース
		// としてのPasserineクラスの出力を確認する
		Turkey passerineAdapter = new PasserineAdapter(new Swallow());
		System.out.println("PasserineAdapter（ツバメ）の出力...");
		passerineAdapter.gobble();
		passerineAdapter.fly();
	}
}
