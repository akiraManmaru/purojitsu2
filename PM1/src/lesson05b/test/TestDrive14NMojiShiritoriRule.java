package lesson05b.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * クラスNMojiShiritoriRuleのフィールド，コンストラクタの定義が完成したら実行すること
 * @author handa
 *
 */
public class TestDrive14NMojiShiritoriRule {
	/**
	 * テスト対象のクラスはlesson05b.shiritori.NMojiShiritoriRule
	 */
	private static Class<?> target = lesson05b.shiritori.NMojiShiritoriRule.class;
	private static int okCount = 0;

	public static void main(String[] args) {
		System.out.println("クラスの修飾子の検査");
		クラスの修飾子と継承実装関係の検査();
		System.out.println("フィールド実装の検査");
		フィールド実装検査();
		// クラス名とフィールドが書けたら，ここまでのテストはOKなはず
		System.out.println("コンストラクタ実装の検査");
		コンストラクタ実装検査();
		// コンストラクタの個数・引数が正しければ，ここまでのテストはOKなはず
		System.out.println("メソッド実装の検査");
		メソッド実装検査();
		System.out.println("コンストラクタの動作の検査");
		コンストラクタ動作検査();
		System.out.println("メソッドcheckの検査");
		メソッドcheck動作検査();
		System.out.println("全部で24個のOKが出ていたら次に進んでください: " + okCount);
		// ここまでのテストがすべてOKになったら次に行きましょう！
	}


	private static void クラスの修飾子と継承実装関係の検査() {
		printResult(Modifier.isPublic(target.getModifiers()), "クラスのアクセス修飾子はpublic?");
		printResult(!Modifier.isAbstract(target.getModifiers()), "クラスにはabstract修飾子がついていない?");
		printResult(target.getSuperclass().getName().equals("java.lang.Object"), "他クラスを継承していない?");
		printResult(target.getInterfaces().length == 1, "一つのインタフェースを実装?");
		if (target.getInterfaces().length == 1) {
			printResult("lesson05b.shiritori.Rule".equals(target.getInterfaces()[0].getName()), "Ruleインタフェースを実装している?");
		}
	}

	private static void フィールド実装検査() {

		ArrayList<FieldCheck> fields = new ArrayList<>();

		fields.add(new FieldCheck("position", int.class, Modifier.PRIVATE, false));

		for (FieldCheck f: fields) {
			printResult(f.isExisit(target),f.getName()+"が存在する？");
			printResult(f.isCorrectAccessor(target), f.getName()+"の修飾子が正しい？");
			printResult(f.isCorrectType(target), f.getName()+"の変数の型が正しい？");
		}
		printResult(fields.size() == target.getDeclaredFields().length, "余分なフィールドを宣言していない?");
	}

	private static void コンストラクタ実装検査() {
		ArrayList<ConstructorCheck> constructors = new ArrayList<>();

		constructors.add(new ConstructorCheck(new Class<?>[]{int.class}, Modifier.PUBLIC));

		for (ConstructorCheck c: constructors) {
			printResult(c.isExisit(target), "コンストラクタが存在する？");
			printResult(c.isCorrectAccessor(target), "コンストラクタのアクセス修飾子は正しい？");
		}
		printResult(constructors.size() == target.getConstructors().length, "余分なコンストラクタを定義していない?");
	}

	public static void メソッド実装検査() {
		ArrayList<MethodCheck> methods = new ArrayList<>();

		methods.add(new MethodCheck("checkCurrentWord", boolean.class, new Class<?>[]{List.class, String.class}, Modifier.PUBLIC, false));

		for (MethodCheck m: methods) {
			printResult(m.isExisit(target), m.getName()+"が存在する？");
			printResult(m.isCorrectAccessor(target), m.getName()+"の修飾子が正しい？");
			printResult(m.isCorrectReturnType(target), m.getName()+"の戻り値の型が正しい？");
			printResult(!m.isAbstract(target), m.getName()+"にabstract修飾子が付いていない？");
		}
		printResult(methods.size() == target.getDeclaredMethods().length, "余分なメソッドを定義していない?");
	}

	@SuppressWarnings("unchecked")
	public static void コンストラクタ動作検査() {
		Constructor<lesson05b.shiritori.NMojiShiritoriRule> con = (Constructor<lesson05b.shiritori.NMojiShiritoriRule>) ConstructorCheck.getConstructor(target, new Class<?>[]{int.class});
		if (con != null) {
			try {
				lesson05b.shiritori.NMojiShiritoriRule e = con.newInstance(2);
				printResult(((int)FieldCheck.getPrivateField(e, "position")) == 2, "フィールドpositionは2？");

				e = con.newInstance(1);
				printResult(((int)FieldCheck.getPrivateField(e, "position")) == 1, "フィールドpositionは1？");

			} catch (Exception e2) {
			}
		}
	}


	@SuppressWarnings("unchecked")
	public static void メソッドcheck動作検査() {
		Constructor<lesson05b.shiritori.NMojiShiritoriRule> con = (Constructor<lesson05b.shiritori.NMojiShiritoriRule>) ConstructorCheck.getConstructor(target, new Class<?>[]{int.class});
		if (con != null) {
			try {
				lesson05b.shiritori.NMojiShiritoriRule e = con.newInstance(2);
				printResult(((int)FieldCheck.getPrivateField(e, "position")) == 2, "フィールドpositionは2？");
				Method m = MethodCheck.getMethod(target, "checkCurrentWord", new Class<?>[]{List.class, String.class});
				if (m != null) {
					List<String> l = new ArrayList<>();
					l.add("らくだ");
					l.add("くだもの");
					printResult(((boolean)m.invoke(e, new Object[]{l, "のはら"})) == false, "「のはら」は「くだもの」に続けられない?");
					printResult(((boolean)m.invoke(e, new Object[]{l, "もり"})) == true, "「もり」は「くだもの」に続けられる?");
					l.add("もり");
					printResult(((boolean)m.invoke(e, new Object[]{l, "ものぼけ"})) == true, "「ものぼけ」は「もり」に続けられる?");
					l.add("ものぼけ");
					printResult(((boolean)m.invoke(e, new Object[]{l, "ぼんち"})) == false, "「ぼんち」は最後から二文字目が「ん」なのでだめ?");


				}
			} catch (Exception e2) {
			}
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
