package headfirst.observer.weather;

/**
 * 天気予報表示
 */
public class ForecastDisplay implements Observer, DisplayElement {
	private float currentPressure = 29.92f;//現在の気圧
	private float lastPressure;//今までの気圧
	@SuppressWarnings("unused")
	private Subject weatherData;

	public ForecastDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void update(float temp, float humidity, float pressure) {
		lastPressure = currentPressure;
		currentPressure = pressure;

		display();
	}

	public void display() {
		System.out.print("予報: ");
		if (currentPressure > lastPressure) {
			System.out.println("天候は良くなります！");
		}
		else if (currentPressure == lastPressure) {
			System.out.println("ほとんど同じです");
		}
		else if (currentPressure < lastPressure) {
			System.out.println("より寒く雨模様の天候に注意してください");
		}
	}
}
