package lesson05.exam2.factory;

import lesson05.exam1.factory.Type;
import lesson05.exam1.vehicle.Vehicle;

/**
 * 車両ジェネレータークラス
 */
public abstract class VehicleGenerator {
	/**
	 * ID(シリアルナンバーを管理する)
	 */
	private int id = 0;

	public abstract Vehicle createVehicle(Type type);

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

		vehicle.produceDrive();
		vehicle.produceBody();
		vehicle.equip();
		vehicle.putID(++id);

		return vehicle;
	}

}
