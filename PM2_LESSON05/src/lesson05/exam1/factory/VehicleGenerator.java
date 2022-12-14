package lesson05.exam1.factory;

import lesson05.exam1.vehicle.Vehicle;
import lesson05.exam1.vehicle.SedanCar;
import lesson05.exam1.vehicle.SUVCar;
import lesson05.exam1.vehicle.MiniVanCar;
import lesson05.exam1.vehicle.TruckCar;

/**
 * 車両ジェネレータークラス
 */
public class VehicleGenerator {
	/**
	 * ID(シリアルナンバーを管理する)
	 */
	private int id = 0;

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
		Vehicle vehicle;

		if (type == Type.SEDAN) {
			vehicle = new SedanCar();
		} else if (type == Type.SUV) {
			vehicle = new SUVCar();
		} else if (type == Type.MINIVAN) {
			vehicle = new MiniVanCar();
		} else if (type == Type.TRUCK) {
			vehicle = new TruckCar();
		} else {
			System.out.println("エラー:" + type + "は作れません\n");
			return null;
		}

		vehicle.produceDrive();
		vehicle.produceBody();
		vehicle.equip();
		vehicle.putID(++id);

		return vehicle;
	}
}
