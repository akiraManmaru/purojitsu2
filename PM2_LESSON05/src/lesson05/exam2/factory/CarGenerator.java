package lesson05.exam2.factory;

import lesson05.exam1.factory.Type;
import lesson05.exam1.vehicle.MiniVanCar;
import lesson05.exam1.vehicle.SUVCar;
import lesson05.exam1.vehicle.SedanCar;
import lesson05.exam1.vehicle.TruckCar;
import lesson05.exam1.vehicle.Vehicle;

/**
 * 自動車ジェネレータークラス
 */
public class CarGenerator extends VehicleGenerator {
	public Vehicle createVehicle(Type type) {
		if (type == Type.SEDAN) {
			return new SedanCar();
		} else if (type == Type.SUV) {
			return new SUVCar();
		} else if (type == Type.MINIVAN) {
			return new MiniVanCar();
		} else if (type == Type.TRUCK) {
			return new TruckCar();
		} else {
			System.out.println("エラー:" + type + "は作れません\n");
			return null;
		}
	}

}