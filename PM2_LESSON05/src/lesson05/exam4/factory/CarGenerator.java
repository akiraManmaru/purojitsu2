package lesson05.exam4.factory;

/**
 * 自動車ジェネレータークラス
 */
public class CarGenerator extends VehicleGenerator {
	public CarGenerator() {
		type2ClassTable = Type2CarClass.getType2ClassTable();
		// 各種類とそれを作るクラスのペアを登録したテーブルを得ます( null の所を書き換えること)。
	}
}
