package headfirst.observer.weather2;

//import java.util.*;

/**
 * 問題２用テストドライブ
 */
public class WeatherStation2 {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		@SuppressWarnings("unused")
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(
				weatherData);
		@SuppressWarnings("unused")
		HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);
		@SuppressWarnings("unused")
		HeatIndexWarning heatIndexWarning = new HeatIndexWarning(weatherData);

		weatherData.setMeasurements(28, 60, 29.2f);
		System.out.println("--------------------");
		weatherData.setMeasurements(32, 70, 30.2f);
		System.out.println("--------------------");
		weatherData.setMeasurements(28, 70, 29.2f);
		System.out.println("--------------------");
		weatherData.setMeasurements(29, 90, 29.2f);
		System.out.println("--------------------");
	}
}
