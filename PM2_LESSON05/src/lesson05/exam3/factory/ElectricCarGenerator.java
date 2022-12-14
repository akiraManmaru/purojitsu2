package lesson05.exam3.factory;

import lesson05.exam1.factory.Type;
import lesson05.exam1.vehicle.Vehicle;
import lesson05.exam2.factory.VehicleGenerator;
import lesson05.exam3.vehicle.MiniVanElectricCar;
import lesson05.exam3.vehicle.SUVElectricCar;
import lesson05.exam3.vehicle.SedanElectricCar;
import lesson05.exam3.vehicle.TruckElectricCar;

/**
 * 電気自動車ジェネレータークラス
 */
public class ElectricCarGenerator extends VehicleGenerator {
	public Vehicle createVehicle(Type type) {
		if (type == Type.SEDAN) {
			return new SedanElectricCar();
		} else if (type == Type.SUV) {
			return new SUVElectricCar();
		} else if (type == Type.MINIVAN) {
			return new MiniVanElectricCar();
		} else if (type == Type.TRUCK) {
			return new TruckElectricCar();
		} else {
			System.out.println("エラー:" + type + "は作れません\n");
			return null;
		}
	}

}