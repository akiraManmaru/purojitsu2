package lesson05b.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 抽象クラスPlayerのコンストラクタ，メソッドの定義が完成したら実行すること
 *
 * @author handa
 *
 */
public class TestDrive04Player {
	/**
	 * テスト対象のクラスはPlayer， TestClass2(Playerのテスト用の具象クラス）はオブジェクト生成用
	 */
	private static Class<?> target = TestClass2.class;
	private static Class<?> target2 = lesson05b.shiritori.Player.class;
	private static int okCount = 0;

	public static void main(String[] args) {
		コンストラクタ動作検査();
		// クラスPlayer のコンストラクタの動作が正しければ，ここまでのテストはOKなはず
		System.out.println("メソッドgetNameの検査");
		メソッドgetName実装and動作検査();
		System.out.println("メソッドmakeDictionaryの検査");
		メソッドmakeDictionary実装and動作検査();
		System.out.println("メソッドgetWordの検査");
		メソッドgetWord実装and動作検査();
		メソッドの個数check();
		System.out.println("全部で66個のOKが出ていたら次に進んでください: " + okCount);
		// ここまでのテストがすべてOKになったら次に行きましょう！
	}

	@SuppressWarnings("unchecked")
	public static void コンストラクタ動作検査() {
		Constructor<TestClass2> con = (Constructor<TestClass2>) ConstructorCheck.getConstructor(target,
				new Class<?>[] { String.class, String[].class });
		if (con != null) {
			try {
				String[] sTest = { "hi2", "hi3" };
				TestClass2 e = con.newInstance("hi", sTest);
				String s = (String) FieldCheck.getSuperClassPrivateField(e, "name");
				printResult("hi".equals(s), "フィールドnameに値がセットされている?");
				String[] vocabulary = (String[]) FieldCheck.getSuperClassPrivateField(e, "vocabulary");
				printResult(sTest == vocabulary, "フィールドvocabularyに値が格納されている？");
				printResult(vocabulary != null && "hi2".equals(vocabulary[0]), "vocabulary[0]の値を書き換えていない？");
				printResult(vocabulary != null && "hi3".equals(vocabulary[1]), "vocabulary[1]の値を書き換えていない？");
				printResult(FieldCheck.getSuperClassPrivateField(e, "dictionary") == null,
						"フィールドdictionaryはnullのままにしてる？");
				printResult(FieldCheck.getSuperClassPrivateField(e, "keyChars") == null, "フィールドkeyCharsはnullのままにしてる？");
			} catch (Exception e2) {
				System.out.println("error at コンストラクタ動作検査");
				System.out.println(e2);
				System.exit(1);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void メソッドgetName実装and動作検査() {

		MethodCheck m = new MethodCheck("getName", String.class, new Class<?>[] {}, Modifier.PUBLIC, false);
		printResult(m.isExisit(target2), m.getName() + "が存在する？");
		printResult(m.isCorrectAccessor(target2), m.getName() + "の修飾子が正しい？");
		printResult(m.isCorrectReturnType(target2), m.getName() + "の戻り値の型が正しい？");
		printResult(!m.isAbstract(target2), m.getName() + "をabstractにしていない？");

		Constructor<TestClass2> con = (Constructor<TestClass2>) ConstructorCheck.getConstructor(target,
				new Class<?>[] { String.class, String[].class });
		if (con != null) {
			try {
				String[] sTest = { "ごりら", "らいおん", "らくだ" };
				TestClass2 e = con.newInstance("hi", sTest);
				Method m2 = e.getClass().getSuperclass().getDeclaredMethod("getName", new Class<?>[] {});
				if (m2 != null) {
					String ret = (String) m2.invoke(e, new Object[] {});
					printResult("hi".equals(ret), "メソッドgetNameの戻り値は「hi」?");
				}

				e = con.newInstance("hi2", sTest);
				m2 = e.getClass().getSuperclass().getDeclaredMethod("getName", new Class<?>[] {});
				if (m2 != null) {
					String ret = (String) m2.invoke(e, new Object[] {});
					printResult("hi2".equals(ret), "メソッドgetNameの戻り値は「hi2」?");
				}

			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	@SuppressWarnings("unchecked")
	public static void メソッドmakeDictionary実装and動作検査() {

		MethodCheck m = new MethodCheck("makeDictionary", void.class, new Class<?>[] { int.class }, Modifier.PROTECTED,
				false);
		printResult(m.isExisit(target2), m.getName() + "が存在する？");
		printResult(m.isCorrectAccessor(target2), m.getName() + "の修飾子が正しい？");
		printResult(m.isCorrectReturnType(target2), m.getName() + "の戻り値の型が正しい？");
		printResult(!m.isAbstract(target2), m.getName() + "をabstractにしていない？");

		Constructor<TestClass2> con = (Constructor<TestClass2>) ConstructorCheck.getConstructor(target,
				new Class<?>[] { String.class, String[].class });
		if (con != null) {
			try {
				String[] sTest = { "ごりら", "らいおん", "らくだ" };
				TestClass2 e = con.newInstance("hi", sTest);
				Method m2 = e.getClass().getSuperclass().getDeclaredMethod("makeDictionary",
						new Class<?>[] { int.class });
				if (m2 != null) {
					m2.setAccessible(true);
					m2.invoke(e, new Object[] { 1 });
				}
				Map<String, List<String>> map = (Map<String, List<String>>) FieldCheck.getSuperClassPrivateField(e,
						"dictionary");
				printResult(map != null, "フィールドdictionaryを初期化している？");
				printResult(map instanceof HashMap, "フィールドdictionaryはHashMapクラスのオブジェクト？");
				printResult(map.size() == 2, "フィールドdictionaryのサイズは2？");
				printResult(map.containsKey("ご"), "「ご」をキーとするデータが存在する?");
				printResult(map.containsKey("ら"), "「ら」をキーとするデータが存在する?");
				if (map.containsKey("ご")) {
					printResult(map.get("ご") != null, "「ご」をキーとするデータ（参照型変数）がオブジェクトを参照している?");
					if (map.get("ご") != null) {
						printResult(map.get("ご").size() == 1, "「ご」をキーとするデータのサイズは1?");
						printResult(map.get("ご").get(0).equals("ごりら"), "「ご」をキーとするデータの最初のデータは「ごりら」?");
					}
				}
				if (map.containsKey("ら")) {
					printResult(map.get("ら") != null, "「ら」をキーとするデータ（参照型変数）がオブジェクトを参照している?");
					if (map.get("ら") != null) {
						printResult(map.get("ら").size() == 2, "「ら」をキーとするデータのサイズは2?");
						printResult(map.get("ら").get(0).equals("らいおん"), "「ら」をキーとするデータの最初のデータは「らいおん」?");
						printResult(map.get("ら").get(1).equals("らくだ"), "「ら」をキーとするデータの２個目のデータは「らくだ」?");
					}
				}

				String[] sTest2 = { "おおさか", "きょうと", "ひょうご", "なら", "わかやま", "しが", "おかやま", "ひろしま", "おおいた" };
				e = con.newInstance("hi", sTest2);
				m2 = e.getClass().getSuperclass().getDeclaredMethod("makeDictionary", new Class<?>[] { int.class });
				if (m2 != null) {
					m2.setAccessible(true);
					m2.invoke(e, new Object[] { 2 });
				}
				map = (Map<String, List<String>>) FieldCheck.getSuperClassPrivateField(e, "dictionary");
				printResult(map != null, "フィールドdictionaryを初期化している？");
				printResult(map instanceof HashMap, "フィールドdictionaryはHashMapクラスのオブジェクト？");
				printResult(map.size() == 8, "フィールドdictionaryのサイズは8？");
				printResult(map.containsKey("ひょ"), "「ひょ」をキーとするデータが存在する?");
				if (map.containsKey("ひょ")) {
					printResult(map.get("ひょ") != null, "「ひょ」をキーとするデータ（参照型変数）がオブジェクトを参照している?");
					if (map.get("ひょ") != null) {
						printResult(map.get("ひょ").size() == 1, "「ひょ」をキーとするデータのサイズは1?");
						printResult(map.get("ひょ").get(0).equals("ひょうご"), "「ひょ」をキーとするデータの最初のデータは「ごりら」?");
					}
				}
				printResult(map.containsKey("おお"), "「おお」をキーとするデータが存在する?");
				if (map.containsKey("おお")) {
					printResult(map.get("おお") != null, "「おお」をキーとするデータ（参照型変数）がオブジェクトを参照している?");
					if (map.get("おお") != null) {
						printResult(map.get("おお").size() == 2, "「おお」をキーとするデータのサイズは2?");
						printResult(map.get("おお").get(0).equals("おおさか"), "「おお」をキーとするデータの最初のデータは「おおさか」?");
						printResult(map.get("おお").get(1).equals("おおいた"), "「おお」をキーとするデータの２個目のデータは「おおいた」?");
					}
				}
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}

	}

	@SuppressWarnings("unchecked")
	public static void メソッドgetWord実装and動作検査() {

		MethodCheck m3 = new MethodCheck("makeDictionary", void.class, new Class<?>[] { int.class }, Modifier.PROTECTED,
				false);
		if (!m3.isExisit(target2)) {
			System.out.println(m3.getName() + "がないと，メソッドgetHandのテストはできません．");
			return;
		}

		MethodCheck m = new MethodCheck("getWord", String.class, new Class<?>[] {}, Modifier.PUBLIC, false);
		printResult(m.isExisit(target2), m.getName() + "が存在する？");
		printResult(m.isCorrectAccessor(target2), m.getName() + "の修飾子が正しい？");
		printResult(m.isCorrectReturnType(target2), m.getName() + "の戻り値の型が正しい？");
		printResult(!m.isAbstract(target2), m.getName() + "をabstractにしていない？");

		Constructor<TestClass2> con = (Constructor<TestClass2>) ConstructorCheck.getConstructor(target,
				new Class<?>[] { String.class, String[].class });
		if (con != null) {
			try {
				String[] sTest = { "ごりら", "らいおん", "らくだ", "らーめん" };
				TestClass2 e = con.newInstance("hi", sTest);
				Method m2 = e.getClass().getSuperclass().getDeclaredMethod("getWord", new Class<?>[] {});
				Method m4 = e.getClass().getSuperclass().getDeclaredMethod("makeDictionary",
						new Class<?>[] { int.class });
				if (m2 != null) {
					m4.setAccessible(true);
					m4.invoke(e, new Object[] { 1 });
					FieldCheck.setSuperClassPrivateField(e, "keyChars", "ご");
					String ret = (String) m2.invoke(e, new Object[] {});
					Map<String, List<String>> map = (Map<String, List<String>>) FieldCheck.getSuperClassPrivateField(e,
							"dictionary");

					printResult("ごりら".equals(ret), "メソッドgetWordの戻り値は「ごりら」");
					printResult(!map.containsKey("ご"), "「ご」をキーとするデータが存在しない?");

					ret = (String) m2.invoke(e, new Object[] {});
					printResult(ret == null, "メソッドgetWordの戻り値はnull?");

					FieldCheck.setSuperClassPrivateField(e, "keyChars", "ら");
					ret = (String) m2.invoke(e, new Object[] {});
					printResult("らいおん".equals(ret), "メソッドgetWordの戻り値は「らいおん」");
					printResult(map.containsKey("ら"), "「ら」をキーとするデータが存在する?");
					if (map.containsKey("ら")) {
						printResult(map.get("ら").size() == 2, "「ら」をキーとするデータのサイズは2?");
					}

					ret = (String) m2.invoke(e, new Object[] {});
					printResult("らくだ".equals(ret), "メソッドgetWordの戻り値は「らくだ」");
					printResult(map.containsKey("ら"), "「ら」をキーとするデータが存在すr?");
					if (map.containsKey("ら")) {
						printResult(map.get("ら").size() == 1, "「ら」をキーとするデータのサイズは1?");
					}

					ret = (String) m2.invoke(e, new Object[] {});
					printResult("らーめん".equals(ret), "メソッドgetWordの戻り値は「らーめん」");
					printResult(!map.containsKey("ら"), "「ら」をキーとするデータが存在しない?");
				}

				String[] sTest2 = { "おおさか", "きょうと", "ひょうご", "なら", "わかやま", "しが", "おかやま", "ひろしま", "おおいた" };
				e = con.newInstance("hi", sTest2);
				m2 = e.getClass().getSuperclass().getDeclaredMethod("getWord", new Class<?>[] {});
				m4 = e.getClass().getSuperclass().getDeclaredMethod("makeDictionary", new Class<?>[] { int.class });
				if (m2 != null) {
					m4.setAccessible(true);
					m4.invoke(e, new Object[] { 2 });
					FieldCheck.setSuperClassPrivateField(e, "keyChars", "きょ");

					String ret = (String) m2.invoke(e, new Object[] {});
					Map<String, List<String>> map = (Map<String, List<String>>) FieldCheck.getSuperClassPrivateField(e,
							"dictionary");

					printResult("きょうと".equals(ret), "メソッドgetWordの戻り値は「きょうと」");
					printResult(!map.containsKey("きょ"), "「きょ」をキーとするデータが存在しない?");

					FieldCheck.setSuperClassPrivateField(e, "keyChars", "ひょ");
					ret = (String) m2.invoke(e, new Object[] {});

					printResult("ひょうご".equals(ret), "メソッドgetWordの戻り値は「ひょうご」");
					printResult(!map.containsKey("ひょ"), "「ひょ」をキーとするデータが存在しない?");

					FieldCheck.setSuperClassPrivateField(e, "keyChars", "なら");
					ret = (String) m2.invoke(e, new Object[] {});

					printResult("なら".equals(ret), "メソッドgetWordの戻り値は「なら」");
					printResult(!map.containsKey("なら"), "「なら」をキーとするデータが存在しない?");

					FieldCheck.setSuperClassPrivateField(e, "keyChars", "おお");
					ret = (String) m2.invoke(e, new Object[] {});

					printResult("おおさか".equals(ret), "メソッドgetWordの戻り値は「おおさか」");
					printResult(map.containsKey("おお"), "「おお」をキーとするデータが存在する?");

					ret = (String) m2.invoke(e, new Object[] {});

					printResult("おおいた".equals(ret), "メソッドgetWordの戻り値は「おおいた」");
					printResult(!map.containsKey("おお"), "「おお」をキーとするデータが存在しない?");
				}

			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}

	public static void メソッドの個数check() {
		ArrayList<MethodCheck> methods = new ArrayList<>();

		methods.add(new MethodCheck("update", void.class, new Class<?>[] { String.class }, Modifier.PUBLIC, false));
		methods.add(new MethodCheck("getHand", String.class, new Class<?>[] {}, Modifier.PUBLIC, false));
		methods.add(new MethodCheck("getName", String.class, new Class<?>[] {}, Modifier.PUBLIC, false));
		methods.add(
				new MethodCheck("makeDictionary", void.class, new Class<?>[] { int.class }, Modifier.PROTECTED, false));

		printResult(methods.size() == target2.getDeclaredMethods().length, "余分なメソッドを宣言していない?");

	}

	/**
	 * テスト結果を表示する
	 *
	 * @param result テスト結果
	 * @param test   テスト項目
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

class TestClass2 extends lesson05b.shiritori.Player {

	public TestClass2(String name, String[] words) {
		super(name, words);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(String message) {
		// TODO Auto-generated method stub

	}

}
