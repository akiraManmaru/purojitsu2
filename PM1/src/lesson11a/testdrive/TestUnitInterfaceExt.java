package lesson11a.testdrive;

import lesson11a.strategy.*;

public class TestUnitInterfaceExt {

	public static void main(String[] args) {
		Unit unt1 = new Unit("エリウッド", 48, 37);
		Unit unt2 = new Unit("ロイ", 18, 15);
		Unit unt3 = new Unit("ロイ", 20, 23);
		unt1.showStatus();
		unt2.showStatus();
		unt3.showStatus();
		System.out.println();		

		UnitComparator unc = new UnitComparator();
		//名前での比較
		unc.compare(unt1, unt2, new NameComparator());
		unc.compare(unt2, unt3, new NameComparator());
		unc.compare(unt3, unt1, new NameComparator());
		System.out.println();		
	}

}
