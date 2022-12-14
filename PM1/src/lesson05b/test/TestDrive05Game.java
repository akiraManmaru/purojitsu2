package lesson05b.test;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * 抽象クラスGameのフィールド，コンストラクタの定義が完成したら実行すること
 * @author handa
 *
 */
public class TestDrive05Game {
	/**
	 * テスト対象のクラスはlesson05b.shiritori.Game
	 */
	private static Class<?> target = lesson05b.shiritori.Game.class;
	private static int okCount = 0;

	public static void main(String[] args) {
		System.out.println("クラスの修飾子の検査");
		クラスの修飾子の検査();
		System.out.println("フィールド実装の検査");
		フィールド実装検査();
		// クラス名とフィールドが書けたら，ここまでのテストはOKなはず
		コンストラクタ実装検査();
		// コンストラクタの個数・引数が正しければ，ここまでのテストはOKなはず
		System.out.println("全部で18個のOKが出ていたら次に進んでください: " + okCount);
		// ここまでのテストがすべてOKになったら次に行きましょう！
	}


	private static void クラスの修飾子の検査() {
		printResult(Modifier.isPublic(target.getModifiers()), "クラスのアクセス修飾子はpublic?");
		printResult(Modifier.isAbstract(target.getModifiers()), "クラスにはabstract修飾子がついている?");
	}

	private static void フィールド実装検査() {

		ArrayList<FieldCheck> fields = new ArrayList<>();

		fields.add(new FieldCheck("players", List.class, Modifier.PROTECTED, false));
		fields.add(new FieldCheck("rule", lesson05b.shiritori.Rule.class, Modifier.PRIVATE, false));
		fields.add(new FieldCheck("currWord", String.class, Modifier.PRIVATE, false));
		fields.add(new FieldCheck("initialWord", String.class, Modifier.PRIVATE, false));

		for (FieldCheck f: fields) {
			printResult(f.isExisit(target),f.getName()+"が存在する？");
			printResult(f.isCorrectAccessor(target), f.getName()+"の修飾子が正しい？");
			printResult(f.isCorrectType(target), f.getName()+"の変数の型が正しい？");
		}
		printResult(fields.size() == target.getDeclaredFields().length, "余分なフィールドを宣言していない?");
	}

	private static void コンストラクタ実装検査() {
		ArrayList<ConstructorCheck> constructors = new ArrayList<>();

		constructors.add(new ConstructorCheck(new Class<?>[]{lesson05b.shiritori.Rule.class, String.class}, Modifier.PUBLIC));

		for (ConstructorCheck c: constructors) {
			printResult(c.isExisit(target), "コンストラクタが存在する？");
			printResult(c.isCorrectAccessor(target), "コンストラクタのアクセス修飾子は正しい？");
		}
		printResult(constructors.size() == target.getConstructors().length, "余分なコンストラクタを宣言していない?");
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
