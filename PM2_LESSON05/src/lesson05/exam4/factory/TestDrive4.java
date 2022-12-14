package lesson05.exam4.factory;

public class TestDrive4 {
	public static void main(String[] args) {
		System.out.println("exam4");
		VehicleGenerator generator = new CarGenerator();
		generator.orderVehicle(Type.SEDAN);
		generator.orderVehicle(Type.SUV);
		generator.orderVehicle(Type.MINIVAN);
		generator.orderVehicle(Type.TRUCK);
		generator.orderVehicle(Type.MICRO);

		generator = new ElectricCarGenerator();
		generator.orderVehicle(Type.SEDAN);
		generator.orderVehicle(Type.SUV);
		generator.orderVehicle(Type.MINIVAN);
		generator.orderVehicle(Type.TRUCK);
	}
}
