package headfirst.observer.weather2;

public interface Observer {
	public void update(float temp, float humidity, float pressure);
}
