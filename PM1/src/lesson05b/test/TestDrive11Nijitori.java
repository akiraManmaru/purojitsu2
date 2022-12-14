package lesson05b.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;


public class TestDrive11Nijitori {
	/**
	 * テスト対象のクラスはlesson05b.shiritori.Nijitori
	 */
	private static Class<?> target = lesson05b.shiritori.Nijitori.class;
	private static int okCount = 0;

	public static void main(String[] args){
		System.out.println("クラスの修飾子の検査");
		クラスの修飾子と継承実装関係の検査();
		System.out.println("フィールド実装の検査");
		フィールド実装検査();
		System.out.println("コンストラクタ実装の検査");
		コンストラクタ実装検査();
		System.out.println("メソッド実装の検査");
		メソッド実装検査();
		System.out.println("コンストラクタの動作の検査");
		コンストラクタ動作検査();

		System.out.println("全部で22個のOKが出ていたら次に進んでください: " + okCount);

	}

	private static void クラスの修飾子と継承実装関係の検査() {
		printResult(Modifier.isPublic(target.getModifiers()), "クラスのアクセス修飾子はpublic?");
		printResult(!Modifier.isAbstract(target.getModifiers()), "クラスにはabstract修飾子がついていない?");
		printResult(target.getSuperclass().getName().equals("lesson05b.shiritori.Game"), "クラスGameを継承している?");
		printResult(target.getInterfaces().length == 0, "インタフェースは実装していない?");
	}

	private static void フィールド実装検査() {
		printResult(0 == target.getDeclaredFields().length, "余分なフィールドを宣言していない?");
	}

	private static void コンストラクタ実装検査() {
		ArrayList<ConstructorCheck> constructors = new ArrayList<>();

		constructors.add(new ConstructorCheck(new Class<?>[]{String[].class, String[][].class}, Modifier.PUBLIC));

		for (ConstructorCheck c: constructors) {
			printResult(c.isExisit(target), "コンストラクタが存在する？");
			printResult(c.isCorrectAccessor(target), "コンストラクタのアクセス修飾子は正しい？");
		}
		printResult(constructors.size() == target.getConstructors().length, "余分なコンストラクタを定義していない?");
	}

	public static void メソッド実装検査() {
			printResult(0 == target.getDeclaredMethods().length, "余分なメソッドを定義していない?");

	}
	@SuppressWarnings("unchecked")
	private static void コンストラクタ動作検査() {
		Constructor<lesson05b.shiritori.Nijitori> con = (Constructor<lesson05b.shiritori.Nijitori>) ConstructorCheck.getConstructor(target, new Class<?>[]{String[].class, String[][].class});
		if (con != null) {
			try {
				String[] sTest = {"近大2", "情報2"};
				String[][] sTest2 = {new String[]{"りんご", "らくてん"}, new String[]{"ごりら"}};
				lesson05b.shiritori.Nijitori e = con.newInstance(sTest, sTest2);
				String s = (String) FieldCheck.getSuperClassPrivateField(e, "initialWord");
				printResult("にじとり".equals(s), "フィールドinitialWordに値がセットされている?");
				s = (String) FieldCheck.getSuperClassPrivateField(e, "currWord");
				printResult(s==null, "フィールドcurrWordはnullのまま?");
				lesson05b.shiritori.Rule r =  (lesson05b.shiritori.Rule) FieldCheck.getSuperClassPrivateField(e, "rule");
				if (r != null) {
					printResult(r instanceof lesson05b.shiritori.NtoriRule, "フィールドruleはNtoriRuleクラスのオブジェクト？");
					int len = (int)  FieldCheck.getPrivateField(r, "length");
					printResult(len == 2, "フィールドruleのフィールドlengthは1？");
				}
				else {
					System.out.println("error: ruleがnull");
				}
				List<lesson05b.shiritori.Player> players = (List<lesson05b.shiritori.Player>) FieldCheck.getSuperClassPrivateField(e, "players");
				if (players != null) {
					printResult(players.size() == 2, "プレイヤーは二人？");
					lesson05b.shiritori.Player player = players.get(0);
					printResult("近大2".equals(player.getName()), "一人目の名前は近大2？");
					printResult(player instanceof lesson05b.shiritori.NtoriPlayer, "一人目はNtoriPlayerはのオブジェクト？");
					printResult(((String[]) FieldCheck.getSuperClassPrivateField(player, "vocabulary")).length == 2, "一人目の単語数は2?");
					printResult(((int) FieldCheck.getPrivateField(player, "length")) == 2, "一人目のフィールドlengthは2?");

					player = players.get(1);
					printResult("情報2".equals(player.getName()), "二人目の名前は情報2？");
					printResult(player instanceof lesson05b.shiritori.NtoriPlayer, "二人目はNtoriPlayerはのオブジェクト？");
					printResult(((String[]) FieldCheck.getSuperClassPrivateField(player, "vocabulary")).length == 1, "二人目の単語数は1?");
					printResult(((int) FieldCheck.getPrivateField(player, "length")) == 2, "二人目のフィールドlengthは2?");

				}
				else {
					System.out.println("error: playersがnull");
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
