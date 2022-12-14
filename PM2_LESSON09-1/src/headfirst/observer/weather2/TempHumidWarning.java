package headfirst.observer.weather2;

public class TempHumidWarning implements Observer, DisplayElement {
	private float humidity;
	protected final float humidityThreshold = 60.0f;
	private float temperature;
	protected final float temperatureThreshold = 30.0f;
	private Subject weatherData;

	public TempHumidWarning(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void display() {
		System.out.println("警告: 気温" + temperature + "度C 湿度" + humidity + "%です。注意してください。");

	}

	public void update(float temperature, float humidity, float pressure) {

		if (temperature >= temperatureThreshold && humidity >= humidityThreshold) {
			this.temperature = temperature;
			this.humidity = humidity;
			display();
		}

	}

}
