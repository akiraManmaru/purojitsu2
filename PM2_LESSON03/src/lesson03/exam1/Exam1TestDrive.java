package lesson03.exam1;

/**
 * SwallowAdapterとSparrowAdapterの挙動を確認する
 * ためのテストドライブ
 * @author Kimiaki Shirahama
 */
public class Exam1TestDrive {
	public static void main(String[] args) {

		// WildTurkey（事前に実装済み）の出力を確認する
		Turkey wildTurkey = new WildTurkey();
		System.out.println("WildTurkey（七面鳥）の出力...");
		wildTurkey.gobble();
		wildTurkey.fly();

		// SwallowApdaterを用いて、SwallowクラスをTurkeyインター
		// フェースに適応させる。そして、Turkeryインターフェースとして
		// のSwallowクラスの出力を確認する。
		Turkey swallowAdapter = new SwallowAdapter(new Swallow());
		System.out.println("SwallowAdapter（ツバメ）の出力...");
		swallowAdapter.gobble();
		swallowAdapter.fly();

		// SparrowApdaterを用いて、SparrowクラスをTurkeyインター
		// フェースに適応させる。そして、Turkeryインターフェースとして
		// のSparrowクラスの出力を確認する。
		Turkey sparrowAdapter = new SparrowAdapter(new Sparrow());
		System.out.println("SparrowAdapter（スズメ）の出力...");
		sparrowAdapter.gobble();
		sparrowAdapter.fly();

	}
}
