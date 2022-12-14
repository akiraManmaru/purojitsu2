
/** 21-1-037-0034 池上開世
課題番号 12
提出日 2021/12/14
*/
import java.util.ArrayList;

/**
 * 太陽系内の天体のデータを表示するクラス
 *
 * @version 1.0 2021/12/4
 * @author infoStaff
 */
public class SolarSystem2 {
	private ArrayList<Star> dataOfStars; // 天体(星)のデータ

	/**
	 * コンストラクタ
	 * linesの各要素に格納されている天体のデータを使ってStarクラスのオブジェクトを生成し、それをArrayListにそれぞれ格納
	 * @param lines CSV形式の天体のデータ
	 */
	public SolarSystem2(String lines[]) {
		dataOfStars = new ArrayList<Star>();
		for (int i = 0; i < lines.length; i++) {
			dataOfStars.add(i, new Star(lines[i]));
		}

	}

	/**
	 * i番目の天体のデータを表示する
	 * 天体名(日本語名), 種別, 太陽からの距離(天文単位), 公転周期(年), 半径(km), 自転周期(日), 質量(対地球比)を表示する
	 * @param i 何番目の天体か
	 */
	private void printDataOfStar(int i) {
		System.out.printf("%s %s %5.2fau %6.2f年 %6dkm %6.2f日 %10.3f\n",
				dataOfStars.get(i).getName(), // 天体名(日本語名)
				dataOfStars.get(i).getType(), // 種別
				dataOfStars.get(i).getDistance(), // 距離(天文単位)
				dataOfStars.get(i).getOrbitalPeriod(), // 公転周期(年)
				dataOfStars.get(i).getRadius(), // 半径(km)
				dataOfStars.get(i).getRotationPeriod(), // 自転周期(日)
				dataOfStars.get(i).getMass()); // 質量(対地球比)
	}

	/**
	 * 天体の一覧を表示する
	 * 登録されている天体のデータを順番に表示する
	 */
	public void showList() {
		System.out.println("天体名   種別   距離    公転周期 半径     自転周期 質量");
		for (int i = 0; i < this.dataOfStars.size(); ++i) {
			printDataOfStar(i);
		}
	}

	/**
	 * 天体名(英語名,日本語名)に partOfName を含む天体のデータを表示する
	 * 該当する天体が複数あった場合はその全てが表示される
	 * 該当する天体が無い場合は見つからなかったと表示される
	 * @param partOfName 探索する天体名の一部
	 */
	public void queryName(String partOfName) {
		int i;
		int flag = 0;
		for (i = 0; i < this.dataOfStars.size(); ++i) {
			if (dataOfStars.get(i).getName().indexOf(partOfName) != -1
					|| dataOfStars.get(i).getJapaneseName().indexOf(partOfName) != -1) {
				printDataOfStar(i);
				flag = 1;
			}

		}
		if (flag == 0) {
			System.out.println("該当する天体が見つかりません");
		}

	}

	/**
	 * 半径が radius 以上の天体のデータを表示する
	 * 該当する天体が複数ある場合はその全てが表示される
	 * 該当する天体が無かった場合は見つからなかったと表示される
	 * @param radius 半径
	 */
	public void querySize(int radius) {
		int flag = 0;
		if (radius <= 0) {
			System.out.println("正の数を入力してください");
		} else {
			for (int i = 0; i < this.dataOfStars.size(); ++i) {
				if (dataOfStars.get(i).getRadius() >= radius) {
					printDataOfStar(i);
					flag = 1;
				}
			}
			if (flag == 0) {
				System.out.println("該当する天体が見つかりません");
			}

		}

	}

	/**
	 * 太陽以外で太陽からの距離が distance 以下の天体のデータを表示する
	 * 該当する天体が複数ある場合はその全てが表示される
	 * 該当する天体が無かった場合は見つからなかったと表示される
	 * @param distance 太陽からの距離
	 */
	public void queryDistance(double distance) {
		int flag = 0;
		if (distance <= 0) {
			System.out.println("正の数を入力してください");
		} else {
			for (int i = 0; i < this.dataOfStars.size(); ++i) {
				if (dataOfStars.get(i).getDistance() <= distance
						&& dataOfStars.get(i).getName().equals("Sun") == false) {
					printDataOfStar(i);
					flag = 1;
				}
			}
			if (flag == 0) {
				System.out.println("該当する天体が見つかりません");
			}

		}

	}

	/**
	 * 第1引数posで指定された位置に、第2引数で指定された第2引数で指定されたline からStarクラスのオブジェクトを生成した上で追加する
	 * @param pos Starオブジェクトの挿入位置
	 * @param line Starクラスのコンストラクタの引数
	 */
	public void addStar(int pos, String line) {
		Star ns = new Star(line);//一時保存するための変数
		if (pos >= 0 && pos <= this.dataOfStars.size() - 1) {
			System.out.println("追加しました");
			dataOfStars.add(pos, ns);
			showList();
		} else {
			System.out.printf("%d番目には追加できません(dataOfStarsのサイズ:%d)\n", pos, this.dataOfStars.size());
		}

	}

	/**
	 * 第1引数posで指定されたdataOfStarsの位置のStarクラスのオブジェクトを削除する
	 * @param pos 削除するStarオブジェクトの位置
	 */
	public void deleteStar(int pos) {
		if (pos >= 0 && pos <= this.dataOfStars.size() - 1) {
			System.out.println("削除しました");
			dataOfStars.remove(pos);
			showList();
		} else {
			System.out.printf("%d番目にはオブジェクトがありません(dataOfStarsのサイズ:%d)\n", pos, this.dataOfStars.size());
		}

	}

	/**
	 * 天体を大きさ(半径)順に並べ替え表示する
	 * 選択法で大きさ(半径)順にStarオブジェクトをソートし、表示する
	 * このメソッドを実行後は、Starオブジェクトは大きさ(半径)順にソートされたものとなる
	 */
	public void sortDataOfStars() {
		Star star2;
		for (int i = 0; i < this.dataOfStars.size(); i++) {//バブルソート
			for (int j = 0; j < this.dataOfStars.size() - 1; j++) {//大きさを比較し前の要素の方が小さければ入れ替える
				if (dataOfStars.get(j).getRadius() < dataOfStars.get(j + 1).getRadius()) {
					star2 = dataOfStars.get(j);
					dataOfStars.set(j, dataOfStars.get(j + 1));
					dataOfStars.set(j + 1, star2);
				}
			}
		}

		/* ソート後の天体のデータを表示する */
		showList();
	}

}
