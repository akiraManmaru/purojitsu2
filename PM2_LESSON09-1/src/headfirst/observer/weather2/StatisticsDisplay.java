package headfirst.observer.weather2;

/**
 * 統計量の表示
 */
public class StatisticsDisplay implements Observer, DisplayElement {
	private float maxTemp = -100.0f;
	private float minTemp = 200.0f;
	private float tempSum= 0.0f;
	private int numReadings;
	@SuppressWarnings("unused")
	private Subject weatherData;

	public StatisticsDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void update(float temp, float humidity, float pressure) {
		tempSum += temp;//今までの気温の和
		numReadings++;//気温を計った回数

		if (temp > maxTemp) {//最高気温
			maxTemp = temp;
		}
 
		if (temp < minTemp) {//最低気温
			minTemp = temp;
		}

		display();
	}

	public void display() {
		System.out.println("平均/最高/最低気温：" + (tempSum / numReadings)
			+ "/" + maxTemp + "/" + minTemp);
	}
}
