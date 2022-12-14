package lesson05b.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;


/**
 * 抽象クラスPlayerのコンストラクタ，メソッドの定義が完成したら実行すること
 * @author handa
 *
 */
public class TestDrive06Game {
	/**
	 * テスト対象のクラスはGame， TestClass3(Gameのテスト用の具象クラス）はオブジェクト生成用
	 */
	private static Class<?> target = TestClass3.class;
	private static Class<?> target2 = lesson05b.shiritori.Game.class;
	private static int okCount = 0;


	public static void main(String[] args) {
		コンストラクタ動作検査();
		// クラスGame のコンストラクタの動作が正しければ，ここまでのテストはOKなはず
		System.out.println("メソッドsendMessageの検査");
		メソッドsendMessage実装and動作検査();
		メソッドの個数check();
		System.out.println("全部で16個のOKが出ていたら次に進んでください: " + okCount);
		// ここまでのテストがすべてOKになったら次に行きましょう！
	}

	@SuppressWarnings("unchecked")
	public static void コンストラクタ動作検査() {
		Constructor<TestClass3> con = (Constructor<TestClass3>) ConstructorCheck.getConstructor(target, new Class<?>[]{lesson05b.shiritori.Rule.class, String.class});
		if (con != null) {
			try {
				lesson05b.shiritori.Rule rule = new TestRule();
				String iniWord = "hi";
				TestClass3 e = con.newInstance(rule, iniWord);
				lesson05b.shiritori.Rule  r = (lesson05b.shiritori.Rule) FieldCheck.getSuperClassPrivateField(e,"rule");
				printResult(r == rule, "フィールドruleに値がセットされている?");
				String word = (String) FieldCheck.getSuperClassPrivateField(e, "initialWord");
				printResult(word == iniWord, "フィールドinitialWordに値が格納されている？");
				printResult(FieldCheck.getSuperClassPrivateField(e, "currWord") == null, "フィールドcurrWordはnullのままにしてる？");
				List<lesson05b.shiritori.Player> players = (List<lesson05b.shiritori.Player>) FieldCheck.getSuperClassPrivateField(e, "players");
				printResult(players != null, "フィールドplayersはnullではない？");
				if (players != null)
					printResult(players.size() == 0, "フィールドplayersのサイズは0？");
			} catch (Exception e2) {
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void メソッドsendMessage実装and動作検査() {

		MethodCheck m = new MethodCheck("sendMessage", void.class, new Class<?>[]{}, Modifier.PRIVATE, false);
		printResult(m.isExisit(target2), m.getName()+"が存在する？");
		printResult(m.isCorrectAccessor(target2), m.getName()+"の修飾子が正しい？");
		printResult(m.isCorrectReturnType(target2), m.getName()+"の戻り値の型が正しい？");
		printResult(!m.isAbstract(target2), m.getName()+"をabstractにしていない？");

		Constructor<TestClass3> con = (Constructor<TestClass3>) ConstructorCheck.getConstructor(target, new Class<?>[]{lesson05b.shiritori.Rule.class, String.class});

		if (con != null) {
			try {
				lesson05b.shiritori.Rule rule = new TestRule();
				String iniWord = "hi";
				TestClass3 e = con.newInstance(rule, iniWord);
				List<lesson05b.shiritori.Player> players = (List<lesson05b.shiritori.Player>) FieldCheck.getSuperClassPrivateField(e, "players");
				players.add(new TestPlayer(null, null));
				players.add(new TestPlayer(null, null));
				players.add(new TestPlayer(null, null));

				Method m2 = e.getClass().getSuperclass().getDeclaredMethod("sendMessage", new Class<?>[]{});
				if (m2 != null) {
					m2.setAccessible(true);
					FieldCheck.setSuperClassPrivateField(e, "currWord", "test1");
					m2.invoke(e, new Object[]{});
					for (lesson05b.shiritori.Player player: players) {
						String ret = ((TestPlayer) player).getData();
						printResult("test1".equals(ret),"playerが受け取ったメッセージは「test1」?");
					}

					FieldCheck.setSuperClassPrivateField(e, "currWord", "test2");
					m2.invoke(e, new Object[]{});
					for (lesson05b.shiritori.Player player: players) {
						String ret = ((TestPlayer) player).getData();
						printResult("test2".equals(ret),"playerが受け取ったメッセージは「test2」?");
					}

				}

			}
			catch (Exception e) {
				System.out.println(e);
			}
		}

	}


	public static void メソッドの個数check() {

		printResult(target2.getDeclaredMethods().length == 2, "余分なメソッドを宣言していない?");

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


	private static class TestClass3 extends lesson05b.shiritori.Game {

		public TestClass3(lesson05b.shiritori.Rule rule, String initialWord) {
			super(rule, initialWord);
		}

	}

	private static class TestRule implements lesson05b.shiritori.Rule {

		@Override
		public boolean checkCurrentWord(List<String> prevWords, String currWord) {
			return false;
		}

	}

	private static class TestPlayer extends lesson05b.shiritori.Player {
		private String data;

		public TestPlayer(String name, String[] words) {
			super(name, words);
		}

		@Override
		public void update(String message) {
			data = message;
		}

		public String getData() {
			return data;
		}
	}

}

