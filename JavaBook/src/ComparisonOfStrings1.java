import java.util.Scanner;

public class ComparisonOfStrings1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner keyBordScanner = new Scanner(System.in);
		String word1, word2;

		System.out.print("文字列を入力してくさださい:");
		word1 = keyBordScanner.next();
		System.out.print("文字列を入力してくさださい:");
		word2 = keyBordScanner.next();

		if (word1.equals(word2)) {
			System.out.printf("%sと%sは等しい\n", word1, word2);
		} else {
			System.out.printf("%sと%sは等しくない\n", word1, word2);
		}
		keyBordScanner.close();

	}

}
