package lesson06b.testdrive;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import lesson06b.bus.Company;
import lesson06b.bus.BusStop;
import lesson06b.bus.BusTime;
import lesson06b.bus.Route;

/**
 * CompanyのnextBus()のテスト
 * @author handa
 *
 */
public class TestDrive10BusCompany {
	private static int count = 0;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Route route1 = new Route(new String[]{"115", "テスト1", "12", "33", "テスト2", "13", "44", "テスト3", "14", "22"});
		Route route2 = new Route(new String[]{"118", "テスト2", "12", "44", "テスト1", "12", "45", "テスト4", "13", "22"});
		Route route3 = new Route(new String[]{"118", "テスト2", "13", "44", "テスト1", "13", "45", "テスト4", "14", "22"});
		
		Company busCompany =  Company.getInstance();
		List<BusStop> busStops = (List<BusStop>) getPrivateField(busCompany, "busStops");
		
		String test = "BusCompany#nextBus()1";
		List<BusTime> busTimes = new ArrayList<BusTime>();
		busTimes.add(busStops.get(0).getBusTime(route1));
		busTimes.add(busStops.get(0).getBusTime(route2));
		printResult(isSame(busCompany.nextBus("テスト1", 12, 0), busTimes), test);

		test = "BusCompany#nextBus()2";
		busTimes.clear();
		busTimes.add(busStops.get(0).getBusTime(route3));
		printResult(isSame(busCompany.nextBus("テスト1", 13, 0), busTimes), test);
		
		test = "BusCompany#nextBus()3";
		busTimes.clear();
		busTimes.add(busStops.get(1).getBusTime(route3));
		busTimes.add(busStops.get(1).getBusTime(route1));
		printResult(isSame(busCompany.nextBus("テスト2", 13, 0), busTimes), test);
		test = "BusCompany#nextBus()4";
		printResult(busCompany.nextBus("テスト2", 16, 0) == null, test);

		test = "BusCompany#nextBus()5";
		printResult(busCompany.nextBus("テスト4", 0, 60) == null, test);

		test = "BusCompany#nextBus()6";
		printResult(busCompany.nextBus("テスト5", 12, 0) == null, test);

		System.out.println("全部で6個のOKが出ていたら次に進んでください: " + count);

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