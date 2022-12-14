package lesson06b.testdrive;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import lesson06b.bus.Company;
import lesson06b.bus.BusStop;
import lesson06b.bus.BusTime;
import lesson06b.bus.Route;

/**
 * BusStopクラスを実装してから実行すること 
 * CompanyのフィールドbusStopsのテストもしています．
 * @author handa
 *
 */
public class TestDrive09BusStop {
	private static int count = 0;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Route route1 = new Route(new String[]{"115", "テスト1", "12", "33", "テスト2", "13", "44", "テスト3", "14", "22"});
		Route route2 = new Route(new String[]{"118", "テスト2", "12", "44", "テスト1", "12", "45", "テスト4", "13", "22"});
		Route route3 = new Route(new String[]{"118", "テスト2", "13", "44", "テスト1", "13", "45", "テスト4", "14", "22"});
		
		Company busCompany =  (Company) getPrivateField(route1, "company");
		List<BusStop> busStops = (List<BusStop>) getPrivateField(busCompany, "busStops");

		String test = "BusCompany#busStops";
		printResult(busStops.get(0).getBusTime(route1).getHour()   == 12, 	test+"01");
		printResult(busStops.get(0).getBusTime(route1).getMinute() == 33, 	test+"02");
		printResult(busStops.get(0).getBusTime(route2).getHour()   == 12, 	test+"03");
		printResult(busStops.get(0).getBusTime(route2).getMinute() == 45, 	test+"04");
		printResult(busStops.get(0).getBusTime(route3).getHour()   == 13, 	test+"05");
		printResult(busStops.get(0).getBusTime(route3).getMinute() == 45, 	test+"06");
		printResult(busStops.get(0).getName().equals("テスト1"), 			test+"07");
		printResult(busStops.get(1).getBusTime(route1).getHour()   == 13, 	test+"08");
		printResult(busStops.get(1).getBusTime(route1).getMinute() == 44, 	test+"09");
		printResult(busStops.get(1).getBusTime(route2).getHour()   == 12, 	test+"10");
		printResult(busStops.get(1).getBusTime(route2).getMinute() == 44, 	test+"11");
		printResult(busStops.get(1).getBusTime(route3).getHour()   == 13, 	test+"12");
		printResult(busStops.get(1).getBusTime(route3).getMinute() == 44, 	test+"13");
		printResult(busStops.get(1).getName().equals("テスト2"), 			test+"14");
		printResult(busStops.get(2).getBusTime(route1).getHour()   == 14, 	test+"15");
		printResult(busStops.get(2).getBusTime(route1).getMinute() == 22, 	test+"16");
		printResult(busStops.get(2).getName().equals("テスト3"), 			test+"17");
		printResult(busStops.get(3).getBusTime(route2).getHour()   == 13, 	test+"18");
		printResult(busStops.get(3).getBusTime(route2).getMinute() == 22, 	test+"19");
		printResult(busStops.get(3).getBusTime(route3).getHour()   == 14, 	test+"20");
		printResult(busStops.get(3).getBusTime(route3).getMinute() == 22, 	test+"21");
		printResult(busStops.get(3).getName().equals("テスト4"), 			test+"22");
		
		test = "BusStop#nextBus()1";
		List<BusTime> busTimes = new ArrayList<BusTime>();
		busTimes.add(busStops.get(0).getBusTime(route1));
		busTimes.add(busStops.get(0).getBusTime(route2));
		printResult(isSame(busStops.get(0).nextBus(12, 0), busTimes), test);

		test = "BusStop#nextBus()2";
		busTimes.clear();
		busTimes.add(busStops.get(0).getBusTime(route3));
		printResult(isSame(busStops.get(0).nextBus(13, 0), busTimes), test);

		
		test = "BusStop#nextBus()3";
		busTimes.clear();
		busTimes.add(busStops.get(1).getBusTime(route3));
		busTimes.add(busStops.get(1).getBusTime(route1));
		printResult(isSame(busStops.get(1).nextBus(13, 0), busTimes), test);

		System.out.println("全部で25個のOKが出ていたら次に進んでください: " + count);
	}

	private static <T> boolean isSame(List<T> arg, List<T> arg2) {
		if (arg.size() != arg2.size()) return false;
		for (int i = 0; i < arg.size(); i++) 
			if (arg.get(i) != arg2.get(i)) return false;
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