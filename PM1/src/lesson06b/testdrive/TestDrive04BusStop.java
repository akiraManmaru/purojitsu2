package lesson06b.testdrive;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import lesson06b.bus.BusStop;
import lesson06b.bus.BusTime;

/**
 * BusStopクラスを実装してから実行すること
 * ##################メソッドnextBus，setDelay, findSameDestination, getBustime, printTimeTableのメソッドの中身はまだ定義しなくてよい（Routeクラスが完成ないとできないので）##################
 * 
 * @author handa
 *
 */
public class TestDrive04BusStop {
	private static int count = 0;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
				
		BusStop busStop = new BusStop("テスト");

		String test = "BusStop#getName()";
		printResult(busStop.getName().equals("テスト"), test);
		
		test = "BusStop#busTimes";
		List<BusTime> busTimes = (List<BusTime>) getPrivateField(busStop, "busTimes");
		printResult(busTimes != null, test+ " a");
		printResult(busTimes.size() == 0, test+ " b");
		

		test = "BusStop#addBusTime()1";
		List<BusTime> busTimes2 = new ArrayList<BusTime>();
		BusTime busTime1 = new BusTime(2, 42);
		busStop.addBusTime(busTime1);
		busTimes2.add(busTime1);
		printResult(isSame(busTimes, busTimes2), test);

		test = "BusStop#addBusTime()2";
		BusTime busTime2 = new BusTime(2, 4);
		busStop.addBusTime(busTime2);
		busTimes2.add(0, busTime2);
		printResult(isSame(busTimes, busTimes2), test);

		test = "BusStop#addBusTime()3";
		BusTime busTime3 = new BusTime(2, 49);
		busStop.addBusTime(busTime3);
		busTimes2.add(busTime3);
		printResult(isSame(busTimes, busTimes2), test);

		test = "BusStop#addBusTime()4";
		BusTime busTime4 = new BusTime(2, 46);
		busStop.addBusTime(busTime4);
		busTimes2.add(2, busTime4);
		printResult(isSame(busTimes, busTimes2), test);

		test = "BusStop#addBusTime()5";
		BusTime busTime5 = new BusTime(2, 46);
		busStop.addBusTime(busTime5);
		busTimes2.add(2, busTime5);
		printResult(isSame(busTimes, busTimes2), test);

		
		System.out.println("全部で8個のOKが出ていたら次に進んでください: " + count);


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