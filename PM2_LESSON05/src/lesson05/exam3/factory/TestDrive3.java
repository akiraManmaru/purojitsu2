package lesson05.exam3.factory;

import lesson05.exam1.factory.Type;
import lesson05.exam2.factory.VehicleGenerator;
import lesson05.exam2.factory.CarGenerator;

public class TestDrive3 {
	public static void main(String[] args) {
		System.out.println("exam3");
		VehicleGenerator generator = new CarGenerator();
		generator.orderVehicle(Type.SEDAN);
		generator.orderVehicle(Type.SUV);
		generator.orderVehicle(Type.MINIVAN);
		generator.orderVehicle(Type.TRUCK);

		generator = new ElectricCarGenerator();
		generator.orderVehicle(Type.SEDAN);
		generator.orderVehicle(Type.SUV);
		generator.orderVehicle(Type.MINIVAN);
		generator.orderVehicle(Type.TRUCK);
	}
}
