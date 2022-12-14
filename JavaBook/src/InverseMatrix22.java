/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 5-2
 * 提出日 2021/10/12
 */
/*
 * 行列式、逆行列を計算するクラス
 */
public class InverseMatrix22 {
	/* フィールド */
	private int a, b, c, d;

	/**
	 * コンストラクタ
	 */
	public InverseMatrix22(int a, int b, int c, int d) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	/**
	 * 行列式を計算するメソッド
	 */
	private int calcDeterminant() {

		int matrics = (a * d - b * c); //行列式

		return matrics;
	}

	/**
	 * 逆行列を計算し，画面上に表示するメソッド
	 */
	public void showInverseMatrix() {
		int matrix = this.calcDeterminant();
		double matrix2 = 1 / (double) matrix;
		if (matrix == 0) { //行列式が0の時
			System.out.println("この行列は正則ではありません");
		} else {
			double aI = matrix2 * d;
			double dI = matrix2 * a;
			double bI = matrix2 * -b;
			double cI = matrix2 * -c;
			System.out.printf("%.2f %.2f\n", aI, bI);
			System.out.printf("%.2f %.2f\n", cI, dI);
		}

	}

}