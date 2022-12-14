/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 9
 * 提出日 2021/11/16
 */
/**
 * 社長のお気に入りの画家を知らない金庫番担当秘書
 */
public class Secretary {
	private int wallet = 0; // 購入資金残高
	private double taxRate = 0.1; // 消費税率
	private int numOfPaint; // 購入済み作品数(10を超える場合は想定しない)
	private String[] collection; // 購入済作品の制作者名の配列

	private static final String PF = "社長お気に入り"; // 定数の宣言、そのような名前の画家が存在し得ないことを想定している

	/**
	 * コンストラクタ collectionは容量10のString型配列で初期化
	 */
	public Secretary() {
		numOfPaint = 0;
		collection = new String[10];
	}

	/**
	 * コンソールに社長お気に入り以外の画家のコレクションを表示
	 */
	public void showCollection() {
		System.out.println("それ以外に以下の作品があります");
		for (int i = 0; i < numOfPaint; i++) {
			if (!collection[i].equals(PF)) {
				System.out.printf("%sの作品が1点\n", collection[i]);
			}
		}
	}

	/**
	 * 購入資金の追加
	 * @param money（追加金額）
	 */
	public void deposit(int money) {
		/* walletを引数値だけ増やす */
		wallet += money;
		System.out.printf("%dドルお預かりしています\n", wallet);
	}

	/**
	 * 社長の指示により可能ならば絵画を購入
	 * @param price（税抜き価格）
	 * @return 購入可否
	 */
	public boolean payIfPossible(int price) {
		boolean flag;
		int paintprice = this.calcPriceWithTax(price);
		if (paintprice < wallet) {
			flag = true;
			this.parchase(PF, paintprice);
		} else {
			flag = false;
		}
		return flag; // これは仮の戻り値

		/* calcPriceWithTaxメソッドを呼び出して税込み価格を計算しローカル変数に格納し，
		 * その時点の購入資金で支払い可能かどうかを調べ
		 * 支払い可能な場合、parchaseメソッドを呼び出し（第1引数はPFとする）て絵画を購入したあと、trueを返す
		 * 可能でない場合falseを返す */
	}

	/**
	 * 自身の判断で絵画を購入、結果の報告はしない
	 * 購入条件は、その制作者の作品が未購入で税抜き価格が500ドル以下、かつその時点の購入資金で支払い可能であること
	 * @param painter（制作者）
	 * @param price（税抜き価格）
	 */

	public void yokiniHakarae(String painter, int price) {
		int j = 1;

		/* 税込み価格を計算し、collection中にpainterがあるかどうかを調べたあと、
		 * このメソッドのドキュメンテーションコメントに記している条件が成り立っていれば購入を実行（step9）
		 * step8では購入条件から「その制作者の作品が未購入で」を除き、collection中にpainterがあるかどうかの検査もしない
		 */

		int tprice = this.calcPriceWithTax(price);
		for (int i = 0; i < collection.length - 1; i++) {
			if (painter.equals(collection[i])) {
				break;
			} else {
				if (tprice < wallet) {
					this.parchase(painter, tprice);
					break;
				}
			}

		}
		collection[j] = painter;
		j++;

	}

	/**
	 * 税込み価格の計算
	 * @param price（税抜き価格）
	 * @return 税込み価格
	 */
	private int calcPriceWithTax(int price) {
		double tprice = ((double) (price) + 0.5) * (taxRate + 1);
		return (int) tprice; // これは仮の戻り値
		/* 小数点以下四捨五入の税込み価格を計算し、戻り値にする */
	}

	/**
	 * 絵画の購入
	 * @param painter（制作者名）
	 * @param payment（税込み価格）
	 */
	private void parchase(String painter, int payment) {
		wallet -= payment; // 支払い実行

		/* 制作者名を配列collectionに収容し、購入済み作品数を1増やす */

		System.out.printf("%sの作品を%dドルで購入 残金%dドル\n", painter, payment, wallet);
	}
}