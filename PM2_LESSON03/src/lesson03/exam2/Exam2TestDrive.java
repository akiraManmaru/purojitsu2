package lesson03.exam2;

/**
 * PasserineAdapterの挙動を確認するためのテストドライブ
 * @author Kimiaki Shirahama
 */
public class Exam2TestDrive {
	public static void main(String[] args) {

		// WildTurkey（事前に実装済み）の出力を確認する
		WildTurkey wildTurkey = new WildTurkey();
		System.out.println("WildTurkey（七面鳥）の出力...");
		wildTurkey.gobble();
		wildTurkey.fly();

		// Passerineインターフェースを実装するSwallowクラスを
		// PasserineAdapterに適用して、WildTurkeryクラスとしての
		// Swallowクラスの出力を確認する
		Passerine passerine = new Swallow();
		WildTurkey passerineAdapter = new PasserineAdapter(passerine);
		System.out.println("PasserineAdapter（ツバメ）の出力...");
		passerineAdapter.gobble();
		passerineAdapter.fly();

		// Passerineインターフェースを実装するSparrowクラスを
		// PasserineAdapterに適用して、WildTurkeryクラスとしての
		// Passerineクラスの出力を確認する
		passerine = new Sparrow();
		passerineAdapter = new PasserineAdapter(passerine);
		System.out.println("PasserineAdapter（スズメ）の出力...");
		passerineAdapter.gobble();
		passerineAdapter.fly();

	}
}
