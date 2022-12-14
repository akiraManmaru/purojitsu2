package lesson06b.bus;

/**
 * バスの時刻(○時△分という時刻)を表すためのクラス
 * 同時刻に同じバス停を出発する場合でも、路線が違えば、別のオブジェクトを生成すること
 * @author Hisashi Handa
 *
 */
public class BusTime {
	private int delay;
	private int hour;
	private static int HOUR = 24;
	private int minute;
	private static int MINUTE = 60;
	private Route route;

	public BusTime(int hour, int minute) {
		this(hour, minute, null);
		delay = 0;
	}

	public BusTime(int hour, int minute, Route route) {
		this.hour = hour;
		this.minute = minute;
		this.route = route;
	}

	public int getDelay() {
		return delay;
	}

	public int getHour() {
		return hour;
	}

	public static int getHOUR() {
		return HOUR;
	}

	public int getMinute() {
		return minute;
	}

	public static int getMINUTE() {
		return MINUTE;
	}

	public Route getRoute() {
		return route;
	}

	public boolean isEarlier(BusTime busTime) {
		boolean flag = false;
		if (busTime.hour * 100 + busTime.minute >= this.hour * 100 + this.minute) {
			flag = true;
		}

		return flag;
	}

	public static boolean isValidTime(int hour, int minute) {
		boolean flag = false;
		//System.out.println(HOUR + MINUTE);
		if (0 <= hour && HOUR > hour && 0 <= minute && MINUTE > minute) {
			flag = true;
		}
		return flag;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

}
