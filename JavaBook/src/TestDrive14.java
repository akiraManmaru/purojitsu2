/**
 * 第14回実技試験　動作確認用のクラス．
 * 
 * @author 情報実習II担当教員
 */
public class TestDrive14 {
	public static void main(String[] args) {

		// 課題14-1（Eventクラス）
		Event event141 = new Event("実習", 108, 1300, 1600);
		System.out.printf("%s\n", event141.eventInfo());

		// 課題14-1（Schedulerクラス）
		Scheduler schedule = new Scheduler("情報太郎");
		System.out.printf("%sのスケジュール\n", schedule.getUserName());
		System.out.println("=================== (1) ===================");

		// 課題14-2（registerEventメソッド）
		schedule.registerEvent(event141);
		Event event1421 = new Event("輪講", 108, 1800, 2000);
		Event event1422 = new Event("全体会議", 111, 1900, 2300);
		schedule.registerEvent(event1421);
		schedule.registerEvent(event1422);
		schedule.showAllEvents();
		System.out.println("=================== (2) ===================");

		// 課題14-3（deleteEventメソッド）
		schedule.deleteEvent(100); // indexがscheduleの要素数を超える場合のチェック
		schedule.deleteEvent(1);
		System.out.println("インデックス1のオブジェクトを削除");
		schedule.showAllEvents();
		System.out.println("=================== (3) ===================");

		// 課題14-4（queryByDateメソッド）
		String[] inputDataList = {
				"会議,111,1700,1830",
				"個別会議,115,1000,1200",
				"昼食,115,1200,1300",
				"授業,115,1300,1600",
				"個別会議,122,1000,1100",
				"会議,122,900,1030",
				"昼食,122,1200,1300",
				"授業,122,1300,1600",
				"追試,129,1400,1500",
				"補講,130,1300,1600" };

		for (int i = 0; i < inputDataList.length; i++) {
			// inputDataListからデータを抽出
			String[] inputData = inputDataList[i].split(",");

			if (inputData.length != 4) {
				System.out.print("入力データの書式が異なります");
				System.exit(0);
			}
			// Eventクラスのオブジェクトを生成
			Event tmpEvent = new Event(inputData[0], Integer.parseInt(inputData[1]),
					Integer.parseInt(inputData[2]), Integer.parseInt(inputData[3]));
			// 生成したEventクラスのオブジェクトをscheduleに登録
			schedule.registerEvent(tmpEvent);
		}

		System.out.println("0115のイベント");
		schedule.queryByDate(115);
		System.out.println("=================== (4) ===================");

		// 課題14-5（queryByNameメソッド）
		System.out.println("会議イベント");
		schedule.queryByName("会議");
		System.out.println("=================== (5) ===================");

		// 課題14-6（showDoubleBookメソッド）
		System.out.println("ダブルブッキングしているイベント");
		schedule.showDoubleBook();
		System.out.println("=================== (6) ===================");

		// 課題14-7（convertTimeToMinメソッド）
		System.out.println("ダブルブッキングしているイベントを解消");
		schedule.changeEventTime(6, 60);
		System.out.println("ダブルブッキングしているイベント");
		schedule.showDoubleBook();
		System.out.println("=================== (7) ===================");
	}
}