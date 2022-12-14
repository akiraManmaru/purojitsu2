package lesson05b.test;

import java.util.List;

import lesson05b.shiritori.Rule;

/**
 * インタフェースRuleが完成してから実行すること
 * @author handa
 *
 */
public class TestDrive02Rule {
	private static int okCount = 0;

	public static void main(String[] args) {
		TestClass    test   = new TestClass();

		String testName = "インタフェースRuleのメソッドcheckCurrentWord()";
        printResult(test.checkCurrentWord(null, "false") == false, testName);

		testName = "インタフェースRuleのメソッドcheckCurrentWord()2";
        printResult(test.checkCurrentWord(null, "true") == true, testName);

		System.out.println("全部で2個のOKが出ていたら次に進んでください: " + okCount);

	}

	/**
	 * テスト結果を表示する
	 * @param result テスト結果
	 * @param test テスト項目
	 */
	static void printResult(boolean result, String test) {
		if (result) {
			okCount++;
			System.out.printf("%s \tの　テストOK\n", test);
		} else {
			System.out.printf("%s \tの　テストNG\n", test);
		}
	}

}

class TestClass implements Rule {

	@Override
	public boolean checkCurrentWord(List<String> prevWords, String currWord) {
		boolean ret = false;
		if (currWord.equals("true"))
			ret = true;
		return ret;
	}

}
