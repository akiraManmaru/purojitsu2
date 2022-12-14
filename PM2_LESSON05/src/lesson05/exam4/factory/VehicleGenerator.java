package lesson05.exam4.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import lesson05.exam1.vehicle.Vehicle;

/**
 * 車両ジェネレータークラス
 */
public abstract class VehicleGenerator {
	/**
	 * ID(シリアルナンバーを管理する)
	 */
	private int id = 0;

	/*
	 * type と、それに対応するクラスのテーブル
	 * 値は、実装クラスで設定
	 */
	protected Map<Type, Class<? extends Vehicle>> type2ClassTable;

	/**
	 * 注文を受けて、全てのジェネレーターで下記の製造方法を指定している
	 * (1) 注文されたタイプ(type)のインスタンスを生成する
	 * (2) 駆動部を製造する
	 * (3) 車体をとりつける
	 * (4) 内装をとりつける
	 * (5) IDをセットして履歴を出力する
	 * @param type
	 *            車両のタイプ
	 * @return 製造された車両のインスタンス
	 */
	public final Vehicle orderVehicle(Type type) {
		Vehicle vehicle = createVehicle(type);

		if (vehicle != null) {
			vehicle.produceDrive();
			vehicle.produceBody();
			vehicle.equip();
			vehicle.putID(++id);
		}

		return vehicle;
	}

	/**
	 * 受注車両のインスタンスを作成する
	 */
	/**
	 * 車両ジェネレーターに対する注文
	 */
	public Vehicle createVehicle(Type type) {

		Vehicle vehicle = null;

		Class<? extends Vehicle> vehicleClass = type2ClassTable.get(type);
		// 引数のtypeに対応したクラスを得ます( null の所を書き換えること)。
		// 戻り値の型は Class<? extends Vehicle> です。
		// Class はまさに型がクラスであることを示しています。
		// ? extends Vehicle はそのクラスが Vehicle の下位クラスのどれかであることを示しています。

		if (vehicleClass == null) { // type に対応するクラスがなかった
			System.out.println("エラー:" + type + "は作れません\n");
			vehicle = null;
		} else {
			try {
				vehicle = vehicleClass.getDeclaredConstructor().newInstance(); // type に対応するクラスのインスタンスを生成
				// vehicleClassの引数なしのコンストラクタを呼んだのと同じことになる。
				// 引数ありのコンストラクタを呼ぶことももちろんできるが、ここでは言及しない。
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}

		return vehicle;
	}
}
