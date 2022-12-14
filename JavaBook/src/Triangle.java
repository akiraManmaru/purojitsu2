/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 4-3
 * 提出日 2021/10/5
 */
/*
 * 三角形の面積をヘロンの公式を用いて計算するクラス
 */
public class Triangle {
	//フィールド
	private int lengthA;
	private int lengthB;
	private int lengthC;

	//コンストラクタ
	public Triangle(int lengthA, int lengthB, int lengthC) {
		super();
		this.lengthA = lengthA;
		this.lengthB = lengthB;
		this.lengthC = lengthC;
	}

	//ヘロンの公式で計算するメソッド
	public double calcArea() {
		double a = lengthA;
		double b = lengthB;
		double c = lengthC;
		double s = (a + b + c) / 2;
		return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}

	//メインメソッド
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Triangle triangle1 = new Triangle(16, 17, 20);
		double area1 = triangle1.calcArea();
		Triangle triangle1_1 = new Triangle(4, 6, 7);
		double area1_1 = triangle1_1.calcArea();
		System.out.printf("1問目の回答は%fです\n", (area1 - area1_1));

		Triangle triangle2 = new Triangle(22, 20, 30);
		double area2 = triangle2.calcArea();
		Triangle triangle2_1 = new Triangle(5, 5, 5); //三角形2つくり抜かれてる
		double area2_1 = triangle2_1.calcArea();
		System.out.printf("2問目の回答は%fです\n", (area2 - (2 * area2_1)));

	}

}
