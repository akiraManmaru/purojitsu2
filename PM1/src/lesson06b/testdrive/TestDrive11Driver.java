package lesson06b.testdrive;

import java.lang.reflect.Field;
import java.util.List;

import lesson06b.bus.Company;
import lesson06b.bus.Driver;
import lesson06b.bus.BusStop;
import lesson06b.bus.Route;

/**
 * Driverクラスを実装してから実行すること
 * Companyクラスのassign()とreportDelay()メソッドを実装すること
 * RouteクラスのフィールドbusDriverや残りのメソッドを実装すること
 * @author handa
 */
public class TestDrive11Driver {
	private static int count = 0;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Route route1 = new Route(new String[]{"115", "テスト1", "12", "33", "テスト2", "13", "44", "テスト3", "14", "22"});
		Route route2 = new Route(new String[]{"118", "テスト2", "12", "44", "テスト1", "12", "45", "テスト4", "13", "22"});
		Route route3 = new Route(new String[]{"118", "テスト2", "13", "44", "テスト1", "13", "45", "テスト4", "14", "22"});

		Company busCompany =  Company.getInstance();
		List<BusStop> busStops = (List<BusStop>) getPrivateField(busCompany, "busStops");
		
		Driver busDriver1 = new Driver();
		Driver busDriver2 = new Driver();
		Driver busDriver3 = new Driver();
		Driver busDriver4 = new Driver();
		
		String test = "Route#getBusDriver()1";
		printResult(route1.getBusDriver() == busDriver1, test);

		test = "Route#getBusDriver()2";
		printResult(route2.getBusDriver() == busDriver2, test);

		test = "Route#getBusDriver()3";
		printResult(route3.getBusDriver() == busDriver3, test);
		
		test = "BusDriver#reportDelay()1";
		printResult(busDriver1.reportDelay("テスト1", 2) == true, test);
		printResult(busStops.get(0).getBusTime(route1).getDelay() == 0, test);
		printResult(busStops.get(1).getBusTime(route1).getDelay() == 2, test);
		printResult(busStops.get(2).getBusTime(route1).getDelay() == 2, test);
	
		test = "BusDriver#reportDelay()2";
		printResult(busDriver1.reportDelay("テスト4", 5) == false, test);

		test = "BusDriver#reportDelay()3";
		printResult(busDriver4.reportDelay("テスト4", 5) == false, test);
		
		System.out.println("全部で9個のOKが出ていたら次に進んでください: " + count);
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