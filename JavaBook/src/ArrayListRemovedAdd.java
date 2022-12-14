import java.util.ArrayList;

public class ArrayListRemovedAdd {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList<Integer> intList = new ArrayList<>();
		for (int i = 0; i < 100; i++)
			intList.add(i);
		System.out.printf("初めはインデックス50の要素は%dです\n", intList.get(50));
		System.out.printf("大きさは%dです", intList.size());
		intList.remove(4);
		System.out.printf("インデックス4の要素消去後のインデックス50" + "の要素は%dです\n", intList.get(50));
		System.out.printf("消去後の大きさは%dです\n", intList.size());
		intList.add(3, 20);
		System.out.printf("インデックス3に%dを挿入した後の" + "インデックス50の要素は%dです", intList.get(3), intList.get(50));

	}

}
