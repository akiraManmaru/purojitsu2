package lesson12b.data;

public class Car {
	private String country;
	private String manufacturer;
	private String name;
	private int price;
	private int seats;
	private int year;

	public Car(String name, String manufacturer,
			String country, int year, int price, int seats) {

		this.country = country;
		this.manufacturer = manufacturer;
		this.name = name;
		this.price = price;
		this.seats = seats;
		this.year = year;
	}

	public String getCountry() {
		return country;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getSeats() {
		return seats;
	}

	public int getYear() {
		return year;
	}

	public String toString() {
		return name + "(" + manufacturer + "," + country + "),"
				+ price + "万円," + year + "年-," + seats + "人乗り";
	}

}
