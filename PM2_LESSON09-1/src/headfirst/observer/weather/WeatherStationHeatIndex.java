package headfirst.observer.weather;

public class WeatherStationHeatIndex {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

		weatherData.setMeasurements(27, 65, 30.4f);
		weatherData.setMeasurements(28, 70, 29.2f);
		weatherData.setMeasurements(26, 90, 29.2f);
	}
}
