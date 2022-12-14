package lesson05.exam4.factory;

import java.util.HashMap;
import java.util.Map;

import lesson05.exam1.vehicle.MiniVanCar;
import lesson05.exam1.vehicle.SUVCar;
import lesson05.exam1.vehicle.SedanCar;
import lesson05.exam1.vehicle.TruckCar;
import lesson05.exam1.vehicle.Vehicle;
import lesson05.exam4.vehicle.MicroCar;

public class Type2CarClass {
	private static final Map<Type, Class<? extends Vehicle>> type2ClassTable = new HashMap<Type, Class<? extends Vehicle>>() {
		private static final long serialVersionUID = 1L; // おまじないです。気にする必要はありません。
		{ // 各種類とそれを作るクラスのペアを登録
			// 登録後、例えば type2ClassTable.get(Type.SEDAN) とすると、セダン型自動車を作るクラスである SedanCar.class が戻り値として返ります。
			put(Type.SEDAN, SedanCar.class); // セダンとそれを作るClass
			put(Type.SUV, SUVCar.class); // スポーツ車とそれを作るClass
			put(Type.MINIVAN, MiniVanCar.class);// ミニバンとそれを作るClassを追加すること。
			put(Type.TRUCK, TruckCar.class);// トラックとそれを作るClassを追加すること。
			put(Type.MICRO, MicroCar.class);

		}
	};

	/*
	 * 登録したHashMapのゲッター
	 */
	public static Map<Type, Class<? extends Vehicle>> getType2ClassTable() {
		return type2ClassTable;
	}
}
