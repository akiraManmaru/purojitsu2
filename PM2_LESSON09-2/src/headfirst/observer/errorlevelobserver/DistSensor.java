package headfirst.observer.errorlevelobserver;

import java.util.ArrayList;
import java.util.List;

public class DistSensor implements Subject {
	protected float dist;
	protected List<Observer> observers;

	public DistSensor() {
		observers = new ArrayList<Observer>();
	}

	public void registerObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(dist);
		}
	}

	public void measurementsChanged() {
		notifyObservers();
	}

	public void setMeasurements(float dist) {
		this.dist = dist;
		measurementsChanged();
	}

	public int countObservers() {
		return observers.size();
	}

	public float getDist() {
		return dist;
	}

}
