package lesson06b.testdrive;

import lesson06b.bus.BusTime;

/**
 * BusTimeクラスを実装してから実行すること
 * Routeクラスは外枠だけあれば良い： public class Route { }
 */
public class TestDrive02BusTime {
	private static int count = 0;

	public static void main(String[] args) {
		BusTime busTime = new BusTime(2, 42);

		String test = "getHour()";
		printResult(busTime.getHour() == 2, test);

		test = "getMinute()";
		printResult(busTime.getMinute() == 42, test);

		test = "getDelay()";
		printResult(busTime.getDelay() == 0, test);

		test = "getRoute()";
		printResult(busTime.getRoute() == null, test);
		
		BusTime busTime2 = new BusTime(2, 50);
		test = "isEarlier()1";
		printResult(busTime.isEarlier(busTime2) == true, test);

		test = "isEarlier()2";
		printResult(busTime2.isEarlier(busTime) == false, test);

		busTime2 = new BusTime(2, 42);
		test = "isEarlier()3";
		printResult(busTime.isEarlier(busTime2) == true, test);

		busTime2 = new BusTime(3, 40);
		test = "isEarlier()4";
		printResult(busTime.isEarlier(busTime2) == true, test);

		test = "isEarlier()5";
		printResult(busTime2.isEarlier(busTime) == false, test);

		test = "isValidTime()1";
		printResult(BusTime.isValidTime(0, 0) == true, test);

		test = "isValidTime()2";
		printResult(BusTime.isValidTime(-1, 0) == false, test);

		test = "isValidTime()3";
		printResult(BusTime.isValidTime(0, -1) == false, test);

		test = "isValidTime()4";
		printResult(BusTime.isValidTime(24, 0) == false, test);

		test = "isValidTime()5";
		printResult(BusTime.isValidTime(23, 59) == true, test);

		test = "isValidTime()6";
		printResult(BusTime.isValidTime(23, 60) == false, test);
		
		test = "setDelay()";
		busTime.setDelay(5);
		printResult(busTime.getDelay() == 5, test);

		System.out.println("全部で16個のOKが出ていたら次に進んでください: " + count);


	}

	private static void printResult(boolean result, String test) {
		if (result) {
			count++;
			System.out.printf("%s \tのテストOK\n", test);
		} else {
			System.out.printf("%s \tのテストNG\n", test);
		}
	}
}