
/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 6-3
 * 提出日 2021/10/22
 */
import java.util.Scanner;

/*
 * Circleクラスを用いて範囲内で円を動かすメソッド
 */
public class CircleField {
	//フィールド
	private Circle circle;
	private int lowerBoundX;
	private int upperBoundX;
	private int lowerBoundY;
	private int upperBoundY;

	//コンストラクタ
	public CircleField(int lowerBoundX, int upperBoundX, int lowerBoundY, int upperBoundY) {
		this.lowerBoundX = lowerBoundX;
		this.upperBoundX = upperBoundX;
		this.lowerBoundY = lowerBoundY;
		this.upperBoundY = upperBoundY;
		circle = new Circle((lowerBoundX + upperBoundX) / 2, (lowerBoundY + upperBoundY) / 2, 2);//オブジェクト生成

	}

	//範囲内か判定するメソッド
	public boolean checkRange() {
		int xPosition = circle.getXPosition();
		int yPosition = circle.getYPosition();

		boolean suc = true;
		if (xPosition + circle.getRadius() < lowerBoundX || xPosition + circle.getRadius() > upperBoundX) {
			suc = false;
		}
		if (yPosition + circle.getRadius() < lowerBoundY || yPosition + circle.getRadius() > upperBoundY) {
			suc = false;
		}
		return suc;
	}

	//円を動かすメソッド
	public void moveCircle(int xMove, int yMove) {
		circle.move(xMove, yMove);
	}

	//縁の情報を表示するメソッド
	public void showCircleState() {
		circle.showState();
	}

	//メインメソッド
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner kbScanner = new Scanner(System.in);
		System.out.println("x座標の下限と上限、y座標の下限と上限を入力してください:");
		int input1 = kbScanner.nextInt();
		int input2 = kbScanner.nextInt();
		int input3 = kbScanner.nextInt();
		int input4 = kbScanner.nextInt();

		CircleField circlef = new CircleField(input1, input2, input3, input4);
		circlef.showCircleState();
		while (circlef.checkRange()) { //無限ループ
			System.out.println("x軸とy軸の移動距離を入力してください:");
			int input5 = kbScanner.nextInt();
			int input6 = kbScanner.nextInt();
			circlef.moveCircle(input5, input6);
			circlef.showCircleState();
		}
		kbScanner.close();

		kbScanner.close();

	}

}
