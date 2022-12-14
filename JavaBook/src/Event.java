/* 21-1-037-0034 池上開世
課題番号 12
提出日 2022/1/22
*/
/**
 * スケジュール帳に登録する個々のイベントを表すクラス
 * 
 * @author your name
 */
public class Event {
	/**
	  スケジュール帳に登録するイベント名（例：会議，授業，実習）．
	 */
	// ここに記載
	private String name;

	/**
	  イベントの日付（1月15日は115, 10月10日は1010のように整数で表す）．
	 */
	// ここに記載
	private int date;

	/**
	  イベントの開始時刻（9:30は930, 15:00は1500のように整数で表す）．
	 */
	// ここに記載
	private int startTime;

	/**
	  イベントの終了時刻（9:30は930, 15:00は1500のように整数で表す）．
	 */
	// ここに記載
	private int endTime;

	/**
	 * このコンストラクタでは，引数で受け取ったイベント名，日付，開始時刻，終了時刻を
	 * 対応するフィールドに設定する．
	 *
	 * @param name      イベント名
	 * @param date      イベントの日付（1月15日は115, 10月10日は1010のように整数で表す）
	 * @param startTime イベントの開始時刻（9:30は930, 15:00は1500のように整数で表す）
	 * @param endTime   イベントの終了時刻（9:30は930, 15:00は1500のように整数で表す）
	 */
	// ここに記載
	public Event(String name, int date, int startTime, int endTime) {
		this.name = name;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/**
	 * イベント名を戻すゲッター．
	 * 
	 * @return イベント名
	 */
	// ここに記載
	public String getName() {
		return name;
	}

	/**
	 * イベントの日付を戻すゲッター．
	 * 
	 * @return イベントの日付
	 */
	// ここに記載
	public int getDate() {
		return date;
	}

	/**
	 * イベントの開始時刻を戻すゲッター．
	 * 
	 * @return イベントの開始時刻
	 */
	// ここに記載
	public int getStartTime() {
		return startTime;
	}

	/**
	 * イベントの終了時刻を戻すゲッター．
	 * 
	 * @return イベントの終了時刻
	 */
	// ここに記載
	public int getEndTime() {
		return endTime;
	}

	/** 
	 * 整数で表される24時制の時刻（13:30であれば1330）を午前0時からの経過「分」
	 * に変換する．たとえば1330であれば，13×60+30=810という結果を返す．
	 *（1330は13:30を表すので，午前0時からの経過「分」は13h×60min/h+30minで計算できる）．
	 * 
	 * @param time 整数で表される時刻
	 * @return 午前0時からの経過「分」で表される時刻
	 */
	public int convertTimeToMin(int time) {
		int time1 = time / 100;
		int time2 = time - time1 * 100;
		return time1 * 60 + time2; // 正しく変更する
	}

	/** 
	 * 整数で表される午前0時からの経過「分」を，同じく整数で表される24時制の時刻
	 * に変換する．たとえば810であれば，1330という結果を返す．
	 * ヒント：午前0時からの経過「分」（例えば810）から「時」の情報を取り出すには
	 * 810(min)/60(min/h)の商の部分（今回の場合13.5となるので「13」が「時」に相当する）
	 * を見ればよい．同様に「分」の情報は810(min)/60(min/h)の剰余を見ればよい．
	 * 
	 * @param min 午前0時からの経過「分」で表される時刻
	 * @return 整数で表される時刻
	 */
	public int convertMinToTime(int min) {
		int time3 = min / 60;
		int time4 = min % 60;
		return time3 * 100 + time4; // 正しく変更する
	}

	/** 
	 * イベントの開始時刻，終了時刻をそれぞれ引数で与えられた時間（単位：分）を加算して
	 * 変更する．たとえば開始時刻が1330，終了時刻が1430，引数が60だった場合，
	 * 開始時刻，終了時刻ともに60分加算し，開始時刻1430，終了時刻1530と変更する．
	 * 注意：単純に1330+60とすると1390というあり得ない時刻になるので注意すること．
	 * 
	 * @param time 加算する時間
	 * @return 午前0時からの経過「分」で表される時刻
	 */
	public void changeTime(int time) {
		int time5 = time / 60;
		int time6 = time % 60;
		startTime = getStartTime() + time5 * 100 + time6;
		endTime = getEndTime() + time5 * 100 + time6;

	}

	/**
	 * このイベントの情報を文字列で戻す．
	 * 例えば，イベント名が「会議」，実施日が0115, 開始時刻が1000，終了時刻が1230であれば
	 * "会議,0115,1000,1230"という文字列を戻す．
	 *
	 * 注意：このメソッドでは0115のように3桁の数字は頭に0をつけて文字列を生成するが，
	 *       内部処理は通常のint型のため，課題を解く上で特別な処理を考える必要は無い．
	 *       普通にint型変数として（1月15日の場合は115として）扱えばよい．
	 * 
	 * 実装ずみ（注意：決して変更しないこと．変更すると正しく採点できなくなる）
	 * ※各フィールドへのゲッターが実装されていないと動作しない．
	 *
	 * @return このイベントの情報を表す文字列．
	 */
	public String eventInfo() {
		String ret = String.format("\"%s,%04d,%04d,%04d\"", getName(), getDate(), getStartTime(), getEndTime());
		return ret;
	}
}