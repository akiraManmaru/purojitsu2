
/* 21-1-037-0034 池上開世
課題番号 12
提出日 2022/1/22
*/
import java.util.ArrayList;

/**
 * 個々のイベントを表すEvent型のオブジェクトを格納するArrayListをフィールドに持ち
 * スケジュール帳を模したメソッドを保持するクラス．
 * 
 * @author your name
 */
public class Scheduler {
	/**
	  スケジュール帳を利用するユーザ名．
	 */
	// ここに記載
	public String userName;

	/**
	  このクラスで管理されているイベントのリスト．EventクラスのArrayListで管理する．
	 */
	// ここに記載
	private ArrayList<Event> schedule;

	/**
	 * このコンストラクタでは，引数で受け取ったとおりの名前をフィールドに設定する．
	 * 同時にフィールドのArrayListを初期化，すなわち指定されるArrayListを生成し，
	 * フィールド変数に代入する．
	 *
	 * @param userName  ユーザ名
	 */
	// ここに記載
	public Scheduler(String userName) {
		this.userName = userName;
		schedule = new ArrayList<>();
	}

	/**
	 * ユーザ名を戻すゲッター．
	 * 
	 * @return ユーザ名
	 */
	// ここに記載
	public String getUserName() {
		return userName;
	}

	/**
	 * EventクラスのArrayListのフィールドscheduleに新たなイベント(Eventクラスのオブジェクト)
	 * をリストの最後に追加する．
	 * 
	 * @param event 新たに登録されるEventクラスのオブジェクト．
	 */
	public void registerEvent(Event event) {
		schedule.add(event);

	}

	/** 
	 * scheduleからindexで指定された位置のオブジェクトを削除する．
	 * indexの値がscheduleの要素数よりも大きいときには何もしない．
	 *
	 * @param index 削除するオブジェクトの位置を示すインデックス．
	 */
	public void deleteEvent(int index) {
		if (schedule.size() > index) {
			schedule.remove(index);
		}

	}

	/** 
	 * 引数dateで指定される日のイベントがフィールドscheduleに登録されているか
	 * 探索し，該当するイベントがあれば，そのイベントの情報を表示する．情報とは，
	 * そのイベントを表すEventクラスオブジェクトのeventInfoメソッドにより
	 * 作成される文字列を表す．
	 * 複数のイベントがある時は，空白や改行を間に入れず，実行例のように情報を
	 * 順番に並べて表示する．該当するイベントが無い場合は空行を表示する．
	 *
	 * 注意：行末にのみ改行を入れること．これを守らない場合は正解とみなさない．
	 * 
	 * @param date 探索する日．
	 *
	 */
	public void queryByDate(int date) {
		for (int i = 0; i < schedule.size(); i++) {
			if (schedule.get(i).getDate() == date) {
				System.out.print(schedule.get(i).eventInfo());
			}
		}

		System.out.println(""); // 消去しないこと（消去すると正しく採点できない）
	}

	/** 
	 * 引数nameと同じ名前のイベント（部分一致ではなく完全一致である点に注意）
	 * がフィールドscheduleに登録されているか探索し，該当するイベントがあれば，
	 * そのイベントの情報を表示する．情報とは，そのイベントを表すEventクラス
	 * オブジェクトのeventInfoメソッドにより作成される文字列を表す．
	 * 
	 * 複数のイベントがある時は，空白や改行を間に入れず，実行例のように情報を
	 * 順番に並べて表示する．該当するイベントが無い場合は空行を表示する．
	 *
	 * 注意：行末にのみ改行を入れること．これを守らない場合は正解とみなさない．
	 * 
	 * @param name 探索するイベントの名前．
	 *
	 */
	public void queryByName(String name) {
		for (int i = 0; i < schedule.size(); i++) {
			if (schedule.get(i).getName().equals(name)) {
				System.out.print(schedule.get(i).eventInfo());
			}
		}

		System.out.println(""); // 消去しないこと（消去すると正しく採点できない）
	}

	/** 
	 * フィールドscheduleに登録されているイベントの中で日時が重複している
	 * イベントがあれば，そのイベントの情報を表示する．なお，イベントの
	 * 開始時刻，終了時刻が同一でなくても，イベント時間が少しでも重なって
	 * いれば重複とみなす．
	 * 重複の例：1000～1200と1030～1100，1000～1200と930～1100
	 * 重複で無い例：1000～1200と1200～1300
	 * 
	 * 情報はそのイベントを表すEventクラスオブジェクトのeventInfoメソッドに
	 * より作成される文字列を表す．空白や改行を間に入れず，実行例のように
	 * 情報を順番に並べて表示する．
	 *
	 * 注意：行末にのみ改行を入れること．これを守らない場合は正解とみなさない．
	 *
	 */
	public void showDoubleBook() {
		for (int i = 0; i < schedule.size(); i++) {

			for (int j = 1; j < schedule.size(); j++) {
				if (schedule.get(i).getDate() == schedule.get(j).getDate()) {
					if (schedule.get(i).getStartTime() < schedule.get(j).getStartTime()
							&& schedule.get(i).getEndTime() > schedule.get(j).getStartTime()
							|| schedule.get(i).getStartTime() < schedule.get(j).getEndTime()
									&& schedule.get(i).getEndTime() > schedule.get(j).getEndTime()) {
						System.out.print(schedule.get(i).eventInfo());

					}
				}
			}

		}

		System.out.println(""); // 消去しないこと（消去すると正しく採点できない）
	}

	/** 
	 * scheduleのindexで指定された位置に登録されているイベントの開始時刻と
	 * 終了時刻をそれぞれ引数で与えられた時間（単位：分）を加算して変更する．
	 * また時刻変更後のイベントの情報を表示する．
	 * 情報はそのイベントを表すEventクラスオブジェクトのeventInfoメソッドに
	 * より作成される文字列を表す．空白や改行を間に入れず，実行例のように
	 * 表示する．
	 * 
	 * 実装ずみ（注意：決して変更しないこと．変更すると正しく採点できなくなる）
	 * 
	 * @param index 削除するオブジェクトの位置を示すインデックス．
	 */
	public void changeEventTime(int index, int time) {
		if (schedule.size() > index) {
			schedule.get(index).changeTime(time);
			System.out.print(schedule.get(index).eventInfo());
		}

		System.out.println(""); // 消去しないこと
	}

	/**
	 * フィールドscheduleに含まれるイベントの情報すべてを表示する．情報とは，
	 * そのイベントを表すEventクラスオブジェクトのeventInfoメソッドにより
	 * 作成される文字列を表す．
	 * 
	 * 実装ずみ（注意：決して変更しないこと．変更すると正しく採点できなくなる）
	 *
	 */
	public void showAllEvents() {
		for (Event event : schedule)
			System.out.print(event.eventInfo());
		System.out.println("");
	}

}