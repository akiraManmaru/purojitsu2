import java.util.ArrayList;

public class ArrayListAndExtFor {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList<Rectangle> listOfRectangles = new ArrayList<>();
		for (int i = 0; i < 100; i++)
			listOfRectangles.add(new Rectangle(i, i, 1, 1));

		for (Rectangle rect : listOfRectangles)
			rect.showState();

	}

}
