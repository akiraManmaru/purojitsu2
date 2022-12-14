package lesson05b.test;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Map;

/**
 * 抽象クラスPlayerのフィールド，コンストラクタ，抽象メソッドの定義が完成したら実行すること．メソッドの動作はここでは見ていないので，メソッドの中身が空でもOKがでる．
 * @author handa
 *
 */
public class TestDrive03Player {
	/**
	 * テスト対象のクラスはlesson05b.shiritori.Player
	 */
	private static Class<?> target = lesson05b.shiritori.Player.class;
	private static int okCount = 0;

	public static void main(String[] args) {

		System.out.println("クラスの修飾子の検査");
		クラスの修飾子の検査();
		System.out.println("フィールド実装の検査");
		フィールド実装検査();
		// クラス名とフィールドが書けたら，ここまでのテストはOKなはず
		System.out.println("コンストラクタ実装の検査");
		コンストラクタ実装検査();
		// コンストラクタの個数・引数が正しければ，ここまでのテストはOKなはず
		System.out.println("抽象メソッド実装の検査");
		抽象メソッド実装検査();
		// ここまでのテストがすべてOKになったら次に行きましょう！
		System.out.println("全部で22個のOKが出ていたら次に進んでください: " + okCount);
	}


	private static void クラスの修飾子の検査() {
		printResult(Modifier.isPublic(target.getModifiers()), "クラスのアクセス修飾子はpublic?");
		printResult(Modifier.isAbstract(target.getModifiers()), "クラスにはabstract修飾子がついている?");
	}

	private static void フィールド実装検査() {

		ArrayList<FieldCheck> fields = new ArrayList<>();

		fields.add(new FieldCheck("name", String.class, Modifier.PRIVATE, false));
		fields.add(new FieldCheck("keyChars", String.class, Modifier.PROTECTED, false));
		fields.add(new FieldCheck("dictionary", Map.class, Modifier.PRIVATE, false));
		fields.add(new FieldCheck("vocabulary", String[].class, Modifier.PRIVATE, false));

		for (FieldCheck f: fields) {
			printResult(f.isExisit(target),f.getName()+"が存在する？");
			printResult(f.isCorrectAccessor(target), f.getName()+"の修飾子が正しい？");
			printResult(f.isCorrectType(target), f.getName()+"の変数の型が正しい？");
		}
		printResult(fields.size() == target.getDeclaredFields().length, "余分なフィールドを宣言していない?");
	}

	private static void コンストラクタ実装検査() {
		ArrayList<ConstructorCheck> constructors = new ArrayList<>();

		constructors.add(new ConstructorCheck(new Class<?>[]{String.class, String[].class}, Modifier.PUBLIC));

		for (ConstructorCheck c: constructors) {
			printResult(c.isExisit(target), "コンストラクタが存在する？");
			printResult(c.isCorrectAccessor(target), "コンストラクタのアクセス修飾子は正しい？");
		}
		printResult(constructors.size() == target.getConstructors().length, "余分なコンストラクタを宣言していない?");
	}

	public static void 抽象メソッド実装検査() {
		ArrayList<MethodCheck> methods = new ArrayList<>();

		methods.add(new MethodCheck("update", void.class, new Class<?>[]{String.class}, Modifier.PUBLIC, false));

		for (MethodCheck m: methods) {
			printResult(m.isExisit(target), m.getName()+"が存在する？");
			printResult(m.isCorrectAccessor(target), m.getName()+"の修飾子が正しい？");
			printResult(m.isCorrectReturnType(target), m.getName()+"の戻り値の型が正しい？");
			printResult(m.isAbstract(target), m.getName()+"にabstract修飾子が付いている？");
		}
	}




	/**
	 * テスト結果を表示する
	 * @param result テスト結果
	 * @param test テスト項目
	 */
	static void printResult(boolean result, String test) {
		if (result) {
			okCount++;
			System.out.printf("%s \tOK\n", test);
		} else {
			System.out.printf("%s \tNG\n", test);
		}
	}

}
