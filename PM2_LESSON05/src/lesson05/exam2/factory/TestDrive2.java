package lesson05.exam2.factory;

import lesson05.exam1.factory.Type;

public class TestDrive2 {
	public static void main(String[] args) {
		System.out.println("exam2");
		VehicleGenerator generator = new CarGenerator();
		generator.orderVehicle(Type.SEDAN);
		generator.orderVehicle(Type.SUV);
		generator.orderVehicle(Type.MINIVAN);
		generator.orderVehicle(Type.TRUCK);
	}
}
