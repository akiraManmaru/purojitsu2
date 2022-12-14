package lesson06b.bus;

import java.util.ArrayList;
import java.util.List;

/**
 * バスの路線のクラス
 * 同じ路線番号であっても，出発時刻が異なれば，別のオブジェクトを作成して
 * 状態やスケジュールを記憶する．
 * @author handa
 *
 */
public class Route {
	private Driver busDriver;
	private List<BusStop> busStops;
	private Company company;
	private String name;

	public Route(String[] args) {
		this.company = Company.getInstance();
		busStops = new ArrayList<>();
		for (int i = 0; i < (args.length - 1) / 3; i++) {
			//System.out.println(args[1]);
			busStops.add(company.getBusStop(args[i * 3 + 1]));
			int a = Integer.parseInt(args[i * 3 + 2]);
			int b = Integer.parseInt(args[i * 3 + 3]);
			BusTime busTime = new BusTime(a, b, this);
			busStops.get(i).addBusTime(busTime);

			//System.out.println(busStops.get(i));
		}
		name = args[0];
		company.addRoute(this);
		busDriver = null;

	}

	public void assign(Driver busDriver) {
		this.busDriver = busDriver;
	}

	public Driver getBusDriver() {
		return busDriver;
	}

	public String getDestination() {
		return busStops.get(busStops.size() - 1).getName();
	}

	public String getName() {
		return name;
	}

	public String getOrigin() {
		return busStops.get(0).getName();
	}

	public void printSchedule() {
		for (BusStop bs : busStops) {
			System.out.printf("バス停: %s \t%d:%d発\t %d分遅れ\n", bs.getName(), bs.getBusTime(this).getHour(),
					bs.getBusTime(this).getMinute(), bs.getBusTime(this).getDelay());
		}
		//System.out.printf("バス停:%s\t%d:%d発\t%d分遅れ\n", );

	}

	public boolean setDelay(String busStopName, int delay) {
		boolean flag = false;
		int i;
		for (i = 0; i < busStops.size(); i++) {
			if (busStops.get(i).getName().equals(busStopName)) {
				flag = true;
				for (int j = i + 1; j < busStops.size(); j++) {
					company.getBusStop(busStops.get(j).getName()).getBusTime(this).setDelay(delay);

				}

				break;
			}

		}
		return flag;
	}
}