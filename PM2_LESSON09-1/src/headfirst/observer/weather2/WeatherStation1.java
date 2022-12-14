package headfirst.observer.weather2;

//import java.util.*;

/**
 * 問題１用テストドライブ
 */
public class WeatherStation1 {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();

		@SuppressWarnings("unused")
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(
				weatherData);
		@SuppressWarnings("unused")
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		@SuppressWarnings("unused")
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		@SuppressWarnings("unused")
		TempHumidWarning hotWaringDisplay = new TempHumidWarning(weatherData);

		weatherData.setMeasurements(28, 60, 29.2f);
		weatherData.setMeasurements(32, 70, 30.2f);
		weatherData.setMeasurements(28, 60, 29.2f);
	}
}
