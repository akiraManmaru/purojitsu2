package lesson12b.data;

public class ElectricCar extends Car {
	private int travelingRange;

	public ElectricCar(String country, String manufacturer,
			String name, int price, int seats, int year, int travelingRange) {
		super(country, manufacturer, name, price, seats, year);
		this.travelingRange = travelingRange;
	}

	public int getTravelingRange() {
		return travelingRange;
	}

	public String toString() {
		return getName() + "(" + getManufacturer() + "," + getCountry() + "),"
				+ getPrice() + "万円," + getYear() + "年-,"
				+ getSeats() + "人乗り," + "航続距離" + travelingRange + "km";
	}

}
