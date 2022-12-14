package lesson06b.bus;

import java.util.ArrayList;
import java.util.List;

/**
 * バス停のクラス．複数のバス路線が同じバス停を経由するなら，そのバス停のためのバス停オブジェクトを
 * 複数作らずに一つのオブジェクトとする．フィールド busTimesで各バス路線がこのバス停を出発する
 * 時刻を保持する．
 * @author Hisashi Handa
 *
 */
public class BusStop {
	private List<BusTime> busTimes;
	private String name;

	public BusStop(String name) {
		this.name = name;
		busTimes = new ArrayList<>();
	}

	public void addBusTime(BusTime busTime) {
		int i = 0;
		//boolean flag = true;
		if (busTimes.size() >= 1) {

			for (i = 0; i < busTimes.size(); i++) {
				if (busTime.isEarlier(busTimes.get(i))) {
					busTimes.add(i, busTime);
					break;
				}
			}
			if (i == busTimes.size()) {
				busTimes.add(busTimes.size(), busTime);
			}
		} else {
			busTimes.add(busTime);
		}

		//System.out.println(busTimes.size());

	}

	//@SuppressWarnings("unused")
	private boolean findSameDestination(List<BusTime> busTimes, String destination) {
		String ls;
		int i;
		boolean flag = false;
		for (i = 0; i < busTimes.size(); i++) {
			ls = busTimes.get(i).getRoute().getDestination();
			if (ls == destination) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public BusTime getBusTime(Route route) {
		boolean flag = false;
		int i;
		for (i = 0; i < busTimes.size(); i++) {
			if (busTimes.get(i).getRoute() != null) {
				//System.out.println("a");
				if (busTimes.get(i).getRoute() == route) {
					flag = true;
					break;
				}
			}
		}
		if (flag) {
			return busTimes.get(i);
		} else {
			return null;
		}
	}

	public String getName() {
		return name;
	}

	public List<BusTime> nextBus(int hour, int minute) {
		List<BusTime> bts = new ArrayList<>();

		//BusTime busTime = new BusTime(hour, minute);
		int i = 0;

		for (i = 0; i < busTimes.size(); i++) {
			if (busTimes.get(i).getHour() > hour) {
				break;
			} else if (busTimes.get(i).getHour() == hour) {
				if (busTimes.get(i).getMinute() > minute) {
					break;

				}
			}
		}
		if (i == busTimes.size()) {
			return null;
		}

		List<String> r = new ArrayList<>();
		for (int j = i; j < busTimes.size(); j++) {
			if (r.indexOf(busTimes.get(j).getRoute().getName()) == -1) {
				bts.add(busTimes.get(j));
				r.add(busTimes.get(j).getRoute().getName());
			}
		}
		return bts;
	}

	public void printTimeTable() {
		//System.out.println(busTimes.size());
		System.out.printf("%02d: ", busTimes.get(0).getHour());
		for (int i = 0; i < busTimes.size(); i++) {
			if (i >= 1 && busTimes.get(i - 1).getHour() < busTimes.get(i).getHour()) {
				System.out.println();
				System.out.printf("%02d: ", busTimes.get(i).getHour());
			}
			System.out.printf("%s%d ", busTimes.get(i).getRoute().getDestination(), busTimes.get(i).getMinute());
		}
		System.out.println();

	}

	public void setDelay(Route route, int delay) {
		if (findSameDestination(busTimes, route.getDestination())) {
			for (BusTime bt : busTimes) {
				if (route != null && bt.getRoute() == route) {
					bt.setDelay(delay);

				}
			}
		}

	}

}