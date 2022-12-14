
/**
 * 提出者 21-1-037-0034 池上開世
 * 課題番号 11-3
 * 提出日 2021/12/10
 */
import java.util.Scanner;

/**
 * 太陽系内の天体のデータを表示するクラス
 *
 * 実行時に指定した引数に応じた天体のデータを表示する
 * -l : 天体のデータの一覧を表示する
 * -p : 天体のうち惑星のデータの一覧を表示する
 * -n : 天体名もしくは天体名の一部を入力すると，該当する天体のデータを表示する
 * -r : 直径(km)を入力すると，入力した半径以上の大きさの天体のデータを表示する
 * -d : 距離(天文単位)を入力すると、太陽からの距離が入力した距離以下の天体のデータを表示する
 * -s : 直径の大きい順に天体のデータの一覧を表示する (発展課題)
 */
public class SolarSystem {
	// フィールド変数の宣言
	private String dataOfStars[][];//天体のデータ
	private int numOfStars;

	// コンストラクタ
	public SolarSystem(String line[]) {
		this.numOfStars = line.length;//numOfStarsにlineの要素数を代入
		dataOfStars = new String[numOfStars][];//配列の生成
		for (int i = 0; i < numOfStars; i++) {
			dataOfStars[i] = line[i].split(",");//[,]で区切った値を代入する
		}

	}

	//dataOfStarsを表示するメソッド
	public void printDataOfStar(int i) {
		double distance = Double.parseDouble(dataOfStars[i][3]);//文字列をint,double型に変換
		double kouten = Double.parseDouble(dataOfStars[i][4]);
		int lid = Integer.parseInt(dataOfStars[i][5]);
		double days = Double.parseDouble(dataOfStars[i][6]);
		double weight = Double.parseDouble(dataOfStars[i][7]);

		//それぞれ表示する
		System.out.printf("%s", dataOfStars[i][1]);
		System.out.printf("%s", dataOfStars[i][2]);
		System.out.printf("%5.2fau", distance);
		if (dataOfStars[i][1].equals("太陽")) {//太陽の時は例外処理
			System.out.printf("%s年", dataOfStars[i][5]);
		} else {
			System.out.printf("%6.2f年", kouten);
		}

		System.out.printf("%6dkm", lid);
		System.out.printf("%6.2f日", days);
		System.out.printf("%10.3f\n", weight);
	}

	/**
	 * 天体の一覧を表示する
	 * 引数が -l の場合に使用する
	 * 登録されている天体のデータを順番に表示する
	 */
	public void showList() {
		System.out.println("天体一覧");
		System.out.println("天体名   種別   距離    公転周期 半径     自転周期 質量");
		// printDataOfStar()を用いて全ての天体のデータを表示する
		for (int i = 0; i < numOfStars; i++) {
			printDataOfStar(i);//printDataOfStarメソッドにi引数をとり、呼び出す
		}

		System.out.println();

	}

	/**
	 * 惑星の一覧を表示する
	 * 引数が -p の場合に使用する
	 * 登録されている天体のうち惑星のデータを順番に表示する
	 */
	public void showPlanetList() {
		System.out.println("惑星一覧");
		System.out.println("天体名   種別   距離    公転周期 半径     自転周期 質量");
		// printDataOfStar()を用いて全ての天体のうち惑星のデータを表示する
		for (int i = 0; i < numOfStars; i++) {
			if (dataOfStars[i][2].equals("惑星　")) {//惑星の天体だけ表示
				printDataOfStar(i);
			}
		}
	}

	/**
	 * 天体の一覧を表示する
	 * 引数が -n の場合に使用する
	 * 登録されている天体のうち特定の文字がある天体を順番に表示する
	 */
	public void queryName(String partOfName) {
		int flag = 0;
		for (int i = 0; i < numOfStars; i++) {
			int position = dataOfStars[i][1].indexOf(partOfName);//文字列の比較　特定の文字列がある時は-1以外を返す
			int position2 = dataOfStars[i][0].indexOf(partOfName);//英語表記も同様
			if (position != -1 || position2 != -1) {//-1の時は表示しない
				printDataOfStar(i);
				flag = 1;
			}
		}
		if (flag == 0) {
			System.out.println("該当する天体が見つかりません");
		}
	}

	/**
	 * 天体の一覧を表示する
	 * 引数が -r の場合に使用する
	 * 登録されている天体のうち特定半径より大きい天体を順番に表示する
	 */
	public void querySize(int radius) {

		int flag = 0;//ループをしたかの判定に使う
		if (radius <= 0) {//radiusが0以下の時は例外処理
			System.out.println("正の数を入力してください");
			return;//返す
		} else {
			System.out.printf("半径%dkm以上の星\n", radius);
			for (int i = 1; i < numOfStars; i++) {
				int dataInt = Integer.parseInt(dataOfStars[i][5]);//配列から取り出してきた半径をint型にキャストする
				if (dataInt >= radius) {//半径がradius以下の時は表示しない
					printDataOfStar(i);
					flag = 1;
				}
			}
		}
		if (flag == 0) {//ループしなかった時に表示する
			System.out.println("該当する天体が見つかりません");
		}

	}

	/**
	 * 天体の一覧を表示する
	 * 引数が -d の場合に使用する
	 * 登録されている天体のうち入力された値より太陽との距離が近い天体を順番に表示する
	 */
	public void queryDistance(double distance) {
		int flag = 0;//ループしたかの判定に使う
		if (distance <= 0) {//distanceが０以下の時は例外処理
			System.out.println("正の数を入力してください");
			return;
		} else {
			System.out.printf("太陽から%.2f天文単位以内の星\n", distance);
		}
		for (int i = 1; i < numOfStars; i++) {
			double dataInt = Double.parseDouble(dataOfStars[i][3]);//配列から取り出してきた太陽との距離をdouble型にキャストする
			if (dataOfStars[i][1].equals("太陽") == false && dataInt <= distance) {//太陽もしくは距離がdistanceより大きい時表示しない
				printDataOfStar(i);
				flag = 1;
			}
		}
		if (flag == 0) {//ループしなかった時
			System.out.println("該当する天体が見つかりません");
		}
	}

	// sortDataOfStars()

	/**
	 * メインメソッド
	 * 実行時の引数に応じて，キーボード入力に対応する天体のデータを表示する
	 * @param args コマンドライン引数
	 */
	public static void main(String[] args) {
		//String[] lines = {
		String[] lines = {
				/* CSV形式天体星のデータ */
				/* 天体名(英語名),天体名(日本語名),種別,太陽からの平均距離(天文単位),公転周期(年),*/
				/*   半径(km),自転周期(日),質量(対地球比) */
				/* 各データは理科年表2020年度版より引用 */
				"Sun,太陽　　,恒星　,0,NaN,695700,27.3,333404.2",
				"Mercury,水星　　,惑星　,0.387,0.241,2440,58.65,0.0553",
				"Venus,金星　　,惑星　,0.723,0.615,6052,243.0,0.815",
				"Earth,地球　　,惑星　,1.000,1.000,6378,1.00,1.00",
				"Mars,火星　　,惑星　,1.524,1.88,3396,1.026,0.107",
				"Ceres,ケレス　,準惑星,2.769,4.61,476,0.3781,0.00015",
				"Jupiter,木星　　,惑星　,5.203,11.861,71492,0.4135,317.8",
				"Saturn,土星　　,惑星　,9.555,29.532,60268,0.4264,95.16",
				"Uranus,天王星　,惑星　,19.218,84.253,25559,0.7181,14.536",
				"Neptune,海王星　,惑星　,30.047,164.79,24764,0.6712,17.147",
				"Pluto,冥王星　,準惑星,39.445,247.74,1188,6.3872,0.0021",
				"Haumea,ハウメア,準惑星,43.032,282.29,816,0.1631,0.00067",
				"Makemake,マケマケ,準惑星,45.354,305.45,715,0.324,0.0007",
				"Eris,エリス　,準惑星,68.004,560.80,1163,1.08,0.0027",
		};

		Scanner keyBoardScanner = new Scanner(System.in);

		// SolarSystemクラスのオブジェクトの生成
		SolarSystem sorlarSystem = new SolarSystem(lines);

		// 引数が2個未満の場合はメッセージを出して終了する
		if (args.length < 2) {
			System.out.println("Usage:java SolarSystem{-l|-p|-n|-r|-d|-s}");
			System.exit(0);
		}

		// 引数に応じた処理を行う
		if (args[0].equals("-l")) {
			sorlarSystem.showList();
		} else if (args[0].equals("-p")) {
			sorlarSystem.showPlanetList();

		} else if (args[0].equals("-n")) {
			System.out.print("星名もしくは星名の一部を入力してください:");
			String string1 = keyBoardScanner.next();
			sorlarSystem.queryName(string1);
		} else if (args[0].equals("-r")) {
			System.out.print("半径(km)を入力してください:");
			int radius = keyBoardScanner.nextInt();
			sorlarSystem.querySize(radius);

		} else if (args[0].equals("-d")) {
			System.out.print("距離(天文単位)を入力してください:");
			double distance = keyBoardScanner.nextDouble();
			sorlarSystem.queryDistance(distance);

		} else {//エラーメッセージ
			System.out.println("Usage:java SolarSystem{-l|-p|-n|-r|-d|-s}");
		}

		keyBoardScanner.close();
	}
}