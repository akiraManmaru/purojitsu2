package lesson14a.testdrive;

import java.util.ArrayList;

import lesson14a.Unit;
import lesson14a.UnitOrder;

public class OderedSortTest {
	public static void main(String[] args) {
		ArrayList<Unit> unitArray = new ArrayList<Unit>();

		unitArray.add(new Unit("エリウッド", 48, 37));
		unitArray.add(new Unit("ロイ", 18, 15));
		unitArray.add(new Unit("リリーナ", 16, 15));
		unitArray.add(new Unit("パロア", 10, 11));
		unitArray.add(new Unit("ルト", 23, 82));

		System.out.println("ヒットポイントが高い順");
		UnitOrder.HITPOINT.sort(unitArray);
		System.out.println("年齢が若い順");
		UnitOrder.AGE.sort(unitArray);
	}

}
