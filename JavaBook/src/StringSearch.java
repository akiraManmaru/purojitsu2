import java.util.Scanner;

public class StringSearch {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner keyBordScanner = new Scanner(System.in);
		int position;
		String word1, word2;

		System.out.print("文字列を入力してください:");
		word1 = keyBordScanner.next();
		System.out.print("文字列を入力してください:");
		word2 = keyBordScanner.next();

		if ((position = word1.indexOf(word2)) >= 0) {
			System.out.printf(" %s の %d 文字目に %s が現れる", word1, ++position, word2);

		} else {
			System.out.printf("%sは%sに現れない", word2, word1);
		}
		keyBordScanner.close();

	}

}
