/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 9
 * 提出日 2021/11/16
 */
/**
 * 絵画収集に執念を燃やす消費税率すら知らない社長さん
 */
public class President {
	private String favoritePainter; // お気に入り画家名
	private int numOfFavoritePaint; // お気に入り画家の作品数
	private Secretary kinkoban; // 金庫番担当秘書

	/**
	 * コンストラクタ
	 * @param favoritePainter
	 * @param kinkoban
	 */
	public President(String favoritePainter, Secretary kinkoban) {
		/* 引数値をフィールドに代入、numOfFavaritePaintは0で初期化*/
		this.favoritePainter = favoritePainter;
		this.kinkoban = kinkoban;
		this.numOfFavoritePaint = 0;
	}

	/**
	 * コンソールに自己紹介を表示
	 */
	public void show() {
		System.out.printf("ワシの好きな画家は%sじゃ\n", favoritePainter);
	}

	/**
	 * コンソールに絵画コレクションを表示
	 */
	public void showCollection() {
		System.out.print("======\nワシのコレクションは以下の通り\n");
		System.out.printf("%sの作品を%d点所有しておる", favoritePainter, numOfFavoritePaint); // お気に入りの画家の作品数は自分で表示
		/* 前の行を消去して System.out.printfメソッドを用いて同様の出力をするように実装する */
		kinkoban.showCollection(); // それ以外の画家の作品は秘書に表示させる（委譲）
		System.out.print("======\n");
	}

	/**
	 * 本業で収入を得た
	 * @param money 収入
	 */
	public void earn(int money) {
		/* 収入の9割（小数点以下切り捨て）を絵画購入資金として秘書に預託 */
		kinkoban.deposit(money * 9 / 10);
	}

	/**
	 * 絵画の売込みを受ける
	 * @param painter 制作者名
	 * @param price 税抜き価格
	 */
	public void sale(String painter, int price) {
		if (painter.equals(favoritePainter)) { // 文字列の一致判定にはequalsメソッド（教科書pp.94-95）を用いる
			// お気に入りの画家の場合
			if (kinkoban.payIfPossible(price)) { /* 秘書に購入を指示（trueの部分を書き換え） */
				// 購入完了の報告があった場合
				numOfFavoritePaint++; // お気に入り画家作品数をインクレメント
			} else { // 購入不可の報告があった場合
				System.out.print("本業頑張るぞ\n");
			}
		} else { // お気に入りの画家でない場合
			/* 購入判断は秘書に一任し，結果の報告も受けない */
			if (price < 500) {
				kinkoban.yokiniHakarae(painter, price);
			}
		}
	}
}