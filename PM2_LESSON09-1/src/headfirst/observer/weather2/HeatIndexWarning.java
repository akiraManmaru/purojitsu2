package headfirst.observer.weather2;

public class HeatIndexWarning extends HeatIndexDisplay {
	protected float heatIndexThreshold = 90.f;

	public HeatIndexWarning(WeatherData weatherData) {
		super(weatherData);
		//this.heatIndexThreshold = heatIndexThreshold;
	}

	public void display() {
		if (heatIndex >= heatIndexThreshold) {
			System.out.println("熱中症に注意してください");
		}
	}

}
