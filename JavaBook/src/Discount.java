/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 4-2
 * 提出日 2021/10/5
 * 再提出日 2021/10/21
 */
/*
 * 割引した商品の価格を求めるクラス(小数点以下切り捨て)
 */
public class Discount {
	//フィールド
	private int price;

	//コンストラクタ
	public Discount(int price) {
		this.price = price;
	}

	//引数(~%引き)から商品の価格を求めるクラス
	public int calc(int ratePercent) {
		double rate = (1 - ((double) ratePercent / 100));
		return (int) (price * rate); //小数点以下切り捨て
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Discount discount1 = new Discount(12800); //12800円のオブジェクト生成
		System.out.printf("12800円の商品\n");
		System.out.printf("33パーセント引きは%d円です\n", discount1.calc(33));
		System.out.printf("65パーセント引きは%d円です\n", discount1.calc(65));
		System.out.println("\n");
		Discount discount2 = new Discount(32000); //32000円のオブジェクト生成
		System.out.printf("32000円の商品\n");
		System.out.printf("12パーセント引きは%d円です\n", discount2.calc(12));
		System.out.printf("28パーセント引きは%d円です\n", discount2.calc(28));

	}

}
