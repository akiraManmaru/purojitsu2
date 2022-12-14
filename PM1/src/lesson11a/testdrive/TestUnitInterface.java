package lesson11a.testdrive;

import lesson11a.strategy.*;

public class TestUnitInterface {

	public static void main(String[] args) {
		Unit unt1 = new Unit("エリウッド", 48, 37);
		Unit unt2 = new Unit("ロイ", 18, 15);
		Unit unt3 = new Unit("リリーナ", 16, 15);
		unt1.showStatus();
		unt2.showStatus();
		unt3.showStatus();
		System.out.println();		

		UnitComparator unc1 = new UnitComparator();    
		//ヒットポイントでの比較
		unc1.compare(unt1, unt2, new HitPointComparator()); 
		unc1.compare(unt2, unt3, new HitPointComparator()); 
		unc1.compare(unt3, unt1, new HitPointComparator()); 
		System.out.println();		

		//年齢での比較
		unc1.compare(unt1, unt2, new AgeComparator());
		unc1.compare(unt2, unt3, new AgeComparator());
		unc1.compare(unt3, unt1, new AgeComparator());
	}

}
