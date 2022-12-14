package lesson06b.bus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Singletonパターンを用いる．そのため，一部のコンストラクタ・フィールド・メソッドについては詳細を記述していない．2時限目の資料を参考にすること
 * バス会社の時刻表に関するサービスを提供するためのクラス。 時刻表を管理し、ユーザからの問い合わせに答える機能を持つ。
 * 運転手からの遅延時間の設定も行う．
 * @author your name
 *
 */
public class Company {
	private List<BusStop> busStops;
	private static Company instance = null;
	private int noAssignedRoute;
	private List<Route> routes;

	private Company() {
		busStops = new ArrayList<>();

		noAssignedRoute = 0;
		routes = new ArrayList<>();
	}

	public void addRoute(Route route) {
		routes.add(route);

	}

	public void assign(Driver bussDriver) {
		if (routes.size() > noAssignedRoute) {
			routes.get(noAssignedRoute).assign(bussDriver);
			noAssignedRoute++;
		}

	}

	public BusStop findBusStop(String name) {
		BusStop busStop = null;
		for (BusStop bs : busStops) {
			if (name.equals(bs.getName())) {
				busStop = bs;
				break;
			}
		}

		return busStop;
	}

	public BusStop getBusStop(String name) {

		BusStop busStop = this.findBusStop(name);

		if (busStop == null) {
			busStop = new BusStop(name);
			busStops.add(busStop);
		}
		return busStop;
	}

	public static Company getInstance() {
		if (instance == null) {
			instance = new Company();
		}
		return instance;
	}

	/**
	 * 引数fnameのファイルを開き，運行データを読み込む
	 * @param fname ファイル名
	 */

	public void loadData(String fname) {
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(new File(fname));
			while (fileScanner.hasNextLine()) {
				String lineBuffer = fileScanner.nextLine();
				new Route(lineBuffer.split(","));
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} finally {
			if (fileScanner != null) {
				fileScanner.close();
			}
		}

	}

	public List<BusTime> nextBus(String stopName, int hour, int minute) {
		if (0 <= hour && hour <= 23 && 0 <= minute && minute <= 60) {
			boolean flag = false;
			int i;

			for (i = 0; i < busStops.size(); i++) {
				if (busStops.get(i).getName() == stopName) {
					flag = true;
					break;
				}
			}
			if (flag) {
				return busStops.get(i).nextBus(hour, minute);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public void printAllSchedules() {
		for (Route r : routes) {
			System.out.printf("路線番号 %s:", r.getName());
			System.out.printf("\t始発 %s\t終着 %s:\n", r.getOrigin(), r.getDestination());
			r.printSchedule();

		}

	}

	public boolean reportDelay(Driver busDriver, String busStopName, int delay) {

		int i;
		boolean flag = false;
		boolean s = false;
		for (i = 0; i < routes.size(); i++) {
			if (routes.get(i).getBusDriver() == busDriver) {
				flag = true;
				break;
			}
		}
		if (flag) {
			s = routes.get(i).setDelay(busStopName, delay);
		}
		return s;
	}

}
