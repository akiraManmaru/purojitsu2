
public class ArrayOfEvenNumbers {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int[] even;
		even = new int[4];

		even[0] = 0;
		even[1] = 2;
		even[2] = 4;
		even[3] = 6;

		System.out.print("４番目までの偶数:");
		for (int i = 0; i < 4; i++) {
			System.out.printf("%4d", even[i]);
		}
		System.out.println();

	}

}
