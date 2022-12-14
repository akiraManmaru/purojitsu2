package lesson06b.testdrive;

import java.lang.reflect.Field;
import java.util.List;

import lesson06b.bus.BusStop;
import lesson06b.bus.Company;
import lesson06b.bus.Route;

/**
 * Routeクラス(assign()，getBusDriver()以外)を実装してから実行すること
 * BusStopクラスのgetBusTimeメソッド，setDelayメソッドも完成する必要がある．
 * Company クラスの getBusStop()メソッドも実装すること
 * 
 * @author handa
 *
 */
public class TestDrive08Route {
	private static int count = 0;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Route route = new Route(new String[] { "115", "テスト1", "12", "33", "テスト2", "13", "44", "テスト3", "14", "22" });

		String test = "Route#Route()1";
		Company company = (Company) getPrivateField(route, "company");
		printResult(Company.getInstance() == company, test);

		test = "Route#Route()2";
		List<BusStop> busStops = (List<BusStop>) getPrivateField(route, "busStops");
		printResult(busStops != null, test);

		test = "Route#Route()3";
		List<BusStop> busStops2 = (List<BusStop>) getPrivateField(company, "busStops");
		printResult(isSame(busStops, busStops2), test);

		test = "Route#Route()4";

		//System.out.println(busStops.get(0).getBusTime(route).getHour());
		printResult(busStops.get(0).getBusTime(route).getHour() == 12, test + " a");
		printResult(busStops.get(0).getBusTime(route).getMinute() == 33, test + " b");
		printResult(busStops.get(0).getName().equals("テスト1"), test + " c");
		printResult(busStops.get(1).getBusTime(route).getHour() == 13, test + " d");
		printResult(busStops.get(1).getBusTime(route).getMinute() == 44, test + " e");
		printResult(busStops.get(1).getName().equals("テスト2"), test + " f");
		printResult(busStops.get(2).getBusTime(route).getHour() == 14, test + " g");
		printResult(busStops.get(2).getBusTime(route).getMinute() == 22, test + " h");
		printResult(busStops.get(2).getName().equals("テスト3"), test + " h");

		test = "Route#Route()5";
		lesson06b.bus.Driver driver = (lesson06b.bus.Driver) getPrivateField(route, "busDriver");
		printResult(driver == null, test);

		test = "Route#Route()6";
		List<Route> routes = (List<Route>) getPrivateField(company, "routes");
		printResult(routes.size() == 1, test + " a");
		printResult(routes.get(0) == route, test + " b");

		test = "Route#getName()";
		printResult(route.getName().equals("115"), test);

		test = "Route#getDestination()";
		printResult(route.getDestination().equals("テスト3"), test);

		test = "Route#getOrigin()";
		printResult(route.getOrigin().equals("テスト1"), test);

		test = "Route#setDelay()";
		route.setDelay("テスト2", 3);
		printResult(busStops.get(0).getBusTime(route).getDelay() == 0, test + "1");
		printResult(busStops.get(1).getBusTime(route).getDelay() == 0, test + "2");
		printResult(busStops.get(2).getBusTime(route).getDelay() == 3, test + "3");

		// printSchedule()はスライドの実行結果との目視でチェックしてください．
		route.printSchedule();

		System.out.println("全部で21個のOKが出ていたら次に進んでください: " + count);

	}

	private static <T> boolean isSame(List<T> arg, List<T> arg2) {
		if (arg.size() != arg2.size())
			return false;
		for (int i = 0; i < arg.size(); i++)
			if (arg.get(i) != arg2.get(i))
				return false;
		return true;
	}

	private static void printResult(boolean result, String test) {
		if (result) {
			count++;
			System.out.printf("%s \tのテストOK\n", test);
		} else {
			System.out.printf("%s \tのテストNG\n", test);
		}
	}

	public static Object getPrivateField(Object o, String fname) {
		try {
			Field f = o.getClass().getDeclaredField(fname);
			f.setAccessible(true);
			return f.get(o);
		} catch (NoSuchFieldException e) {
			System.out.println("フィールドが定義されていません");
		} catch (IllegalAccessException e) {
		}

		return null;
	}

}