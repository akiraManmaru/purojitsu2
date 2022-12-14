import java.util.Scanner;

public class SeveralHelloWorlds {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner keyBoardScanner = new Scanner(System.in);

		System.out.print("繰り返し回数を入力してください：");
		int times = keyBoardScanner.nextInt();

		for (int i = 0; i < times; i++) {
			System.out.println("Hello world!");
		}
		keyBoardScanner.close();

	}

}
