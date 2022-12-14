package lesson05b.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 抽象クラスGameのフィールド，コンストラクタの定義が完成したら実行すること
 * @author handa
 *
 */
public class TestDrive07NtoriPlayer {
	/**
	 * テスト対象のクラスはlesson05b.shiritori.NtoriPlayer
	 */
	private static Class<?> target = lesson05b.shiritori.NtoriPlayer.class;
	private static int okCount = 0;

	public static void main(String[] args) {
		System.out.println("クラスの修飾子の検査");
		クラスの修飾子と継承関係の検査();
		System.out.println("フィールド実装の検査");
		フィールド実装検査();
		// クラス名とフィールドが書けたら，ここまでのテストはOKなはず
		System.out.println("コンストラクタ実装の検査");
		コンストラクタ実装検査();
		// コンストラクタの個数・引数が正しければ，ここまでのテストはOKなはず
		メソッド実装検査();
		コンストラクタ動作検査();
		メソッドupdate動作検査();
		System.out.println("全部で38個のOKが出ていたら次に進んでください: " + okCount);
		// ここまでのテストがすべてOKになったら次に行きましょう！
	}


	private static void クラスの修飾子と継承関係の検査() {
		printResult(Modifier.isPublic(target.getModifiers()), "クラスのアクセス修飾子はpublic?");
		printResult(!Modifier.isAbstract(target.getModifiers()), "クラスにはabstract修飾子がついていない?");
		printResult(target.getSuperclass().getName().equals("lesson05b.shiritori.Player"), "親クラスはPlayer?");
	}

	private static void フィールド実装検査() {

		ArrayList<FieldCheck> fields = new ArrayList<>();

		fields.add(new FieldCheck("length", int.class, Modifier.PRIVATE, false));

		for (FieldCheck f: fields) {
			printResult(f.isExisit(target),f.getName()+"が存在する？");
			printResult(f.isCorrectAccessor(target), f.getName()+"の修飾子が正しい？");
			printResult(f.isCorrectType(target), f.getName()+"の変数の型が正しい？");
		}
		printResult(fields.size() == target.getDeclaredFields().length, "余分なフィールドを宣言していない?");
	}

	private static void コンストラクタ実装検査() {
		ArrayList<ConstructorCheck> constructors = new ArrayList<>();

		constructors.add(new ConstructorCheck(new Class<?>[]{String.class, String[].class, int.class}, Modifier.PUBLIC));

		for (ConstructorCheck c: constructors) {
			printResult(c.isExisit(target), "コンストラクタが存在する？");
			printResult(c.isCorrectAccessor(target), "コンストラクタのアクセス修飾子は正しい？");
		}
		printResult(constructors.size() == target.getConstructors().length, "余分なコンストラクタを定義していない?");
	}

	public static void メソッド実装検査() {
		ArrayList<MethodCheck> methods = new ArrayList<>();

		methods.add(new MethodCheck("update", void.class, new Class<?>[]{String.class}, Modifier.PUBLIC, false));

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
		Constructor<lesson05b.shiritori.NtoriPlayer> con = (Constructor<lesson05b.shiritori.NtoriPlayer>) ConstructorCheck.getConstructor(target, new Class<?>[]{String.class, String[].class, int.class});
		if (con != null) {
			try {
				String[] sTest = {"りんご", "ごりら"};
				lesson05b.shiritori.NtoriPlayer e = con.newInstance("hi", sTest, 2);
				String s = (String) FieldCheck.getSuperClassPrivateField(e, "name");
				printResult("hi".equals(s), "フィールドnameに値がセットされている?");
				String[] vocabulary = (String[]) FieldCheck.getSuperClassPrivateField(e, "vocabulary");
				printResult(sTest == vocabulary, "フィールドvocabularyに値が格納されている？");
				printResult(vocabulary != null && "りんご".equals(vocabulary[0]), "vocabulary[0]の値を書き換えていない？");
				printResult(vocabulary != null && "ごりら".equals(vocabulary[1]), "vocabulary[1]の値を書き換えていない？");
				Map<String, List<String>> map = (Map<String, List<String>>)FieldCheck.getSuperClassPrivateField(e, "dictionary");
				printResult(map != null, "フィールドdictionaryは初期化されている?");
				printResult(FieldCheck.getSuperClassPrivateField(e, "keyChars") == null, "フィールドkeyCharsはnullのままにしてる？");
				printResult(map.size() == 2, "フィールドdictionaryのサイズは2？");
				printResult(map.containsKey("ごり"), "「ごり」をキーとするデータが存在する?");
				printResult(map.containsKey("りん"), "「りん」をキーとするデータが存在する?");


				String[] sTest2 = {"りんご", "ごりら", "らっぱ"};
				e = con.newInstance("hi2", sTest2, 1);
				s = (String) FieldCheck.getSuperClassPrivateField(e, "name");
				printResult("hi2".equals(s), "フィールドnameに値がセットされている?");
				vocabulary = (String[]) FieldCheck.getSuperClassPrivateField(e, "vocabulary");
				printResult(sTest2 == vocabulary, "フィールドvicabularyに値が格納されている？");
				printResult(vocabulary != null && "りんご".equals(vocabulary[0]), "vocabulary[0]の値を書き換えていない？");
				printResult(vocabulary != null && "ごりら".equals(vocabulary[1]), "vocabulary[1]の値を書き換えていない？");
				printResult(vocabulary != null && "らっぱ".equals(vocabulary[2]), "vocabulary[2]の値を書き換えていない？");
				map = (Map<String, List<String>>)FieldCheck.getSuperClassPrivateField(e, "dictionary");
				printResult(map != null, "フィールドdictionaryは初期化されている?");
				printResult(FieldCheck.getSuperClassPrivateField(e, "keyChars") == null, "フィールドkeyCharsはnullのままにしてる？");
				printResult(map.size() == 3, "フィールドdictionaryのサイズは2？");
				printResult(map.containsKey("ご"), "「ご」をキーとするデータが存在する?");
				printResult(map.containsKey("ら"), "「ら」をキーとするデータが存在する?");
				printResult(map.containsKey("り"), "「り」をキーとするデータが存在する?");
			} catch (Exception e2) {
			}
		}
	}


	@SuppressWarnings("unchecked")
	public static void メソッドupdate動作検査() {
		Constructor<lesson05b.shiritori.NtoriPlayer> con = (Constructor<lesson05b.shiritori.NtoriPlayer>) ConstructorCheck.getConstructor(target, new Class<?>[]{String.class, String[].class, int.class});
		if (con != null) {
			try {
				String[] sTest = {"りんご", "ごりら"};
				lesson05b.shiritori.NtoriPlayer e = con.newInstance("hi", sTest, 2);
				printResult(FieldCheck.getSuperClassPrivateField(e, "keyChars") == null, "フィールドkeyCharsはnullのままにしてる？");
				Method m = MethodCheck.getMethod(target, "update", new Class<?>[]{String.class});
				if (m != null) {
					m.invoke(e, new Object[]{"たんたんたぬき"});
					printResult("ぬき".equals(FieldCheck.getSuperClassPrivateField(e, "keyChars")), "フィールドkeyCharsは「ぬき」？");
					m.invoke(e, new Object[]{"あり"});
					printResult("あり".equals(FieldCheck.getSuperClassPrivateField(e, "keyChars")), "フィールドkeyCharsは「あり」？");

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
