package lesson06b.testdrive;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import lesson06b.bus.Company;
import lesson06b.bus.BusStop;

/**
 * Companyクラス(シングルトンパターン関連のメソッド・コンストラクタ，getBusStop(), findBusStop()） 
 * を実装してから実行すること
 * 他のメソッドは実装していなくてよい
 * @author handa
 *
 */
public class TestDrive06Company {
	private static int count = 0;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Company company;
				
		company = Company.getInstance();
		
		String test = "Company#Company()";
		Company company2 =  (Company) getPrivateField(company, "instance");
		printResult(company == company2, test);

		test = "Company#Company()2";
		Company company3 =  Company.getInstance();
		printResult(company == company3, test);

		test = "Company#Company()3";
		List<BusStop> busStops = (List<BusStop>) getPrivateField(company, "busStops");
		printResult(busStops != null, test);
		
		test = "Company#getBusStop()1";
		List<BusStop> busStops2 = new ArrayList<BusStop>();
		BusStop stop1 = company.getBusStop("テスト1");
		printResult(stop1 != null, test + " a");
		printResult(stop1.getName().equals("テスト1"), test + " b");
		busStops2.add(stop1);
		printResult(isSame(busStops, busStops2), test + " c");

		test = "Company#getBusStop()2";
		BusStop stop2 = company.getBusStop("テスト2");
		printResult(stop2 != null, test + " a");
		printResult(stop2.getName().equals("テスト2"), test + " b");
		busStops2.add(stop2);
		printResult(isSame(busStops, busStops2), test + " c");

		test = "Company#getBusStop()3";
		BusStop stop3 = company.getBusStop("テスト1");
		printResult(stop1 == stop3, test + " a");
		printResult(isSame(busStops, busStops2), test + " b");

		test = "Company#findBusStop()1";
		BusStop stop4 = company.findBusStop("テスト3");
		printResult(stop4 == null, test + " a");
		printResult(isSame(busStops, busStops2), test + " b");
		
		test = "Company#findBusStop()2";
		BusStop stop5 = company.findBusStop("テスト1");
		printResult(stop1 == stop5, test + " a");
		printResult(isSame(busStops, busStops2), test + " b");

		System.out.println("全部で15個のOKが出ていたら次に進んでください: " + count);

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