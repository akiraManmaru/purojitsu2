/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 5-4
 * 提出日 2021/10/12
 */
/*
 * 二次方程式の解を求める計算をするクラス
 */
public class SolveQE {
	/* フィールド */
	private int a, b, c;

	/**
	 * コンストラクタ
	 */
	public SolveQE(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	 * 判別式の値を計算するメソッド
	 */
	private int calcDiscriminant() {
		return b * b - 4 * a * c; //判別式
	}

	/**
	 * 二次方程式の解を計算し，結果を表示するメソッド
	 */
	public void showSolution() {
		// 判別結果に応じた計算と表示
		// 二次方程式の 判別式 が 0 以下の場合、実数解を持たないが
		// 判別式 が 0 以上の場合には 二つの解、または重解を持つ
		double s = this.calcDiscriminant();
		double x1 = (-b + Math.sqrt(s)) / (2 * (double) a);
		double x2 = (-b - Math.sqrt(s)) / (2 * (double) a);

		//判別式が0の時、0より大きい時、0より小さい時で条件分岐
		if (s > 0) {
			System.out.printf("入力された2次方程式の解は%.2fと%.2fです。", x1, x2);
		} else if (s == 0) {
			System.out.printf("入力された2次方程式の解は重解で%.2fです。", x1);
		} else {
			System.out.println("実数解を持ちません。");
		}

	}

}