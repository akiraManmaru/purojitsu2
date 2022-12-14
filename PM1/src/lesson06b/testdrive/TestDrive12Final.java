package lesson06b.testdrive;

import lesson06b.bus.Company;
import lesson06b.bus.Driver;

/**
 * 残りのすべてのメソッドを実装してから実行すること．
 * @author handa
 *
 */
public class TestDrive12Final {
	public static void main(String[] args) {
		Company company = Company.getInstance();
		company.loadData("test01.csv");
		
		System.out.println("八戸ノ里駅前の時刻表を表示");
		company.getBusStop("八戸ノ里駅前").printTimeTable();
		
		System.out.println("\nすべてのルートを表示");
		company.printAllSchedules();
		
		Driver busDriver = new Driver();
		
		System.out.println("\nバスドライバが遅延を報告");
		busDriver.reportDelay("八戸ノ里駅前", 3);

		System.out.println("\nすべてのルートを表示");
		company.printAllSchedules();
	}

}
