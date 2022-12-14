
import java.util.Scanner;

public class ScannerHasNext {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner keyBoardScanner = new Scanner(System.in);
		System.out.println("数値を入力してください：");
		if (keyBoardScanner.hasNextInt()) {
			int input = keyBoardScanner.nextInt();
			System.out.printf("入力は整数%dと解釈できます\n", input);

		} else if (keyBoardScanner.hasNextDouble()) {
			double input = keyBoardScanner.nextDouble();
			System.out.printf("入力された浮動小数点数%8.2fと解釈できます\n", input);
		} else {
			String input = keyBoardScanner.nextLine();
			System.out.printf("入力された%sは数値とは解釈できません\n", input);
		}
		keyBoardScanner.close();

	}

}
