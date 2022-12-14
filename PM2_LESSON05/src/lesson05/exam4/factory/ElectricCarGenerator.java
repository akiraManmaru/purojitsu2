package lesson05.exam4.factory;

/**
 * 電気自動車ジェネレータークラス
 */
public class ElectricCarGenerator extends VehicleGenerator {
	public ElectricCarGenerator() {
		type2ClassTable = Type2ElectricCarClass.getType2ClassTable();
		// 各種類とそれを作るクラスのペアを登録したテーブルを得ます( null の所を書き換えること)。
	}

}
