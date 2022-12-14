/**
 * President.javaとSecretary.javaのテスト用のmainメソッドのみからなるクラス
 */
public class TestDrive09 {

	/**
	 * テスト用mainメソッド
	 * @param args
	 */
	public static void main(String[] args) {
		/* テスト用データの定義 */
		String[] painter = { "Picasso", "Taro Okamoto", "Picasso", "Monet",
				"Manet", "Monet", "da Vinci", "van Gogh", "Picasso" };
		int[] price = { 1000, 108, 2000, 205, 510, 403, 500, 400, 3000 };

		/* 秘書とPicasso好きの社長の生成 */
		Secretary secretary = new Secretary();
		President president = new President("Picasso", secretary);

		/* 社長に自己紹介させ、コレクションを表示させる */
		president.show();
		president.showCollection();

		president.sale("Picasso", 4006); // 最初の売込み
		president.earn(10000); // 社長 10000 ドル稼ぐ
		president.sale("Picasso", 4006); // 再度の売込み

		/* 繰り返しの売込み */
		for (int i = 0; i < painter.length; i++) {
			president.sale(painter[i], price[i]);
		}

		/* コレクションの表示 */
		president.showCollection();
	}
}