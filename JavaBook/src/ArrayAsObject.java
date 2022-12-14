
public class ArrayAsObject {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int[] a = new int[10];
		int[] b;
		for (int i = 0; i < a.length; i++) {
			a[i] = 2 * i;
		}
		b = a;
		for (int i = 0; i < b.length; i++) {
			System.out.printf("%3d", b[i]);
		}
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			a[i]++;
		}
		for (int i = 0; i < b.length; i++) {
			System.out.printf("%3d", b[i]);
		}

	}

}
