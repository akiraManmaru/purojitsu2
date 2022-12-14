package lesson05.exam1.factory;

public class TestDrive1 {
	public static void main(String[] args) {
		System.out.println("exam1");
		VehicleGenerator generator = new VehicleGenerator();
		generator.orderVehicle(Type.SEDAN);
		generator.orderVehicle(Type.SUV);
		generator.orderVehicle(Type.MINIVAN);
		generator.orderVehicle(Type.TRUCK);
	}
}
