import java.util.ArrayList;

public class ArrayListInt {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int numFirst, numLast;
		int size;
		ArrayList<Integer> intList = new ArrayList<Integer>();

		for (int i = 0; i < 100; i++)
			intList.add(i);
		size = intList.size();
		numFirst = intList.get(0);
		numLast = intList.get(size - 1);
		System.out.printf("%d + %d = %d", numFirst, numLast, numFirst + numLast);

	}

}
