
/** 21-1-037-0034 池上開世
課題番号 12
提出日 2021/12/14
*/
public class TestDrive12 {

	public static void main(String[] args) {
		String[] lines = {
				/* CSV形式の天体のデータ */
				/* 天体名(英語名),天体名(日本語名),種別,太陽からの平均距離(天文単位),公転周期(年),半径(km),自転周期(日),質量(対地球比) */
				/* 各データは理科年表2020年度版より引用 */
				/* (天体名(日本語名)と種別は長さ調整のため全角スペースが入っている) */
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
				"Eris,エリス　,準惑星,68.004,560.80,1163,1.08,0.0027"
		};

		//課題1
		System.out.println("==課題1の出力結果==");
		//showDummy(15);
		initializeSolarSystem2(lines);

		//課題2
		System.out.println("==課題2の出力結果==");
		//showDummy(5);
		queryNameTest(lines);

		//課題3
		System.out.println("==課題3の出力結果==");
		//showDummy(10);
		querySizeTest(lines);

		//課題4
		System.out.println("==課題4の出力結果==");
		//showDummy(24);
		queryDistanceTest(lines);

		//課題5
		System.out.println("==課題5の出力結果==");
		//showDummy(18);
		addStarTest(lines);

		//課題6
		System.out.println("==課題6の出力結果==");
		//showDummy(16);
		deleteStarTest(lines);

		//課題7
		System.out.println("==課題7の出力結果==");
		//showDummy(15);
		sortDataOfStarsTest(lines);

	}

	/**
	 *  実技試験では所定の行数に所定の結果が出ているかをもとに点数を算出するため，
	 *  出力が等しくなるよう，所定の行数分ダミーの出力をするメソッド．
	 *
	 *  @param num ダミー出力する行数
	 */
	//private static void showDummy(int num) {
	//	for (int i = 0; i < num; i++)
	//		System.out.println("未実装です");
	//}

	/**
	 * 天体のデータを元にSolarSystem2を初期化し、sortDataOfStarsの動作検証を行う。
	 * @param lines
	 */
	private static void sortDataOfStarsTest(String[] lines) {
		SolarSystem2 solarSystem2 = new SolarSystem2(lines);
		solarSystem2.sortDataOfStars();
	}

	/**
	 * 天体のデータを元にSolarSystem2を初期化し、deleteStarの動作検証を行う。
	 * @param lines
	 */
	private static void deleteStarTest(String[] lines) {

		SolarSystem2 solarSystem2 = new SolarSystem2(lines);
		solarSystem2.deleteStar(5);
		solarSystem2.deleteStar(100);
	}

	/**
	 * 天体のデータを元にSolarSystem2を初期化し、addStarの動作検証を行う。
	 * @param lines
	 */
	private static void addStarTest(String[] lines) {
		SolarSystem2 solarSystem2 = new SolarSystem2(lines);
		solarSystem2.addStar(5, "Dummy,ダミー　,ダミー星,1,1,1,1.0,1.0");
		solarSystem2.addStar(100, "Dummy2,ダミー2　,ダミー星2,1,1,1,1.0,1.0");
	}

	/**
	 * 天体のデータを元にSolarSystem2を初期化し、queryDistanceの動作検証を行う。
	 * @param lines
	 */
	private static void queryDistanceTest(String[] lines) {

		SolarSystem2 solarSystem2 = new SolarSystem2(lines);
		solarSystem2.queryDistance(1000);
		solarSystem2.queryDistance(0);
		solarSystem2.queryDistance(39.445);

	}

	/**
	 * 天体のデータを元にSolarSystem2を初期化し、querySizeの動作検証を行う。
	 * @param lines
	 */
	private static void querySizeTest(String[] lines) {

		SolarSystem2 solarSystem2 = new SolarSystem2(lines);
		solarSystem2.querySize(3000);
		solarSystem2.querySize(0);
		solarSystem2.querySize(695700);

	}

	/**
	 * 天体のデータを元にSolarSystem2を初期化し、queryNameの動作検証を行う。
	 * @param lines
	 */
	private static void queryNameTest(String[] lines) {

		SolarSystem2 solarSystem2 = new SolarSystem2(lines);
		solarSystem2.queryName("太陽");
		solarSystem2.queryName("木星");
		solarSystem2.queryName("キラキラ");
		solarSystem2.queryName("San");
		solarSystem2.queryName("Eris");

	}

	/**
	 * 天体のデータを元にSolarSystem2を初期化し、全ての天体のデータを表示する。
	 * @param lines
	 */
	private static void initializeSolarSystem2(String[] lines) {
		SolarSystem2 solarSystem2 = new SolarSystem2(lines);
		solarSystem2.showList();

	}

}