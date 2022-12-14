import java.util.Scanner;

public class ArrayOfOddNumbers {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int[] odd;
		Scanner keyBoardScanner = new Scanner(System.in);
		System.out.print("配列サイズを入力してください:");
		int size = keyBoardScanner.nextInt();
		odd = new int[size];
		for (int i = 0; i < size; i++) {
			odd[i] = i * 2 + 1;
		}
		System.out.printf("%d番目までの奇数:", size);
		for (int i = 0; i < size; i++) {
			System.out.printf("%4d", odd[i]);
		}
		System.out.println();
		keyBoardScanner.close();

	}

}
