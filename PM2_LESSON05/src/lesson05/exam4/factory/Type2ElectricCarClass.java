package lesson05.exam4.factory;

import java.util.HashMap;
import java.util.Map;

import lesson05.exam1.vehicle.Vehicle;
import lesson05.exam3.vehicle.MiniVanElectricCar;
import lesson05.exam3.vehicle.SUVElectricCar;
import lesson05.exam3.vehicle.SedanElectricCar;
import lesson05.exam3.vehicle.TruckElectricCar;

public class Type2ElectricCarClass {
	private static final Map<Type, Class<? extends Vehicle>> type2ClassTable = new HashMap<Type, Class<? extends Vehicle>>() {
		private static final long serialVersionUID = 1L; // おまじないです。気にする必要はありません。
		{ // 各種類とそれを作るクラスのペアを登録
			// 登録後、例えば type2ClassTable.get(Type.SEDAN) とすると、セダン型自動車を作るクラスである SedanCar.class が戻り値として返ります。

			put(Type.SEDAN, SedanElectricCar.class); // セダンとそれを作るClass
			put(Type.SUV, SUVElectricCar.class); // スポーツ車とそれを作るClass
			put(Type.MINIVAN, MiniVanElectricCar.class);// ミニバンとそれを作るClassを追加すること。
			put(Type.TRUCK, TruckElectricCar.class);
		}
	};

	/*
	 * 登録したHashMapのゲッター
	 */
	public static Map<Type, Class<? extends Vehicle>> getType2ClassTable() {
		return type2ClassTable;
	}

}
