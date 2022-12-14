package headfirst.observer.errorlevelobserver;

public class DistSensorErrorLevels extends DistSensor {

	private DistSensor[] distSensorErrorLevels;
	private ErrorLevel el = ErrorLevel.getInstance();

	public DistSensorErrorLevels() {
		distSensorErrorLevels = new DistSensor[el.getMaxErrorLevel() + 1];
	}

	public int countObservers() {
		return super.countObservers();
	}

	public DistSensor getDistSensorAtErrorLevel(int errorLevel) {
		if (distSensorErrorLevels[errorLevel] == null) {
			distSensorErrorLevels[errorLevel] = new DistSensor();
		}
		return distSensorErrorLevels[errorLevel];
	}

	public void registerObserver(Observer o) {
		super.registerObserver(o);
		distSensorErrorLevels[1] = this;
	}

	public void registerObserver(Observer o, int errlevelToRegister) {
		if (distSensorErrorLevels[errlevelToRegister] == null) {
			distSensorErrorLevels[errlevelToRegister] = this;
		}
		distSensorErrorLevels[errlevelToRegister].registerObserver(o);
	}

	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	public void notifyObservers() {
		for (int i = el.getErrorLevel(); i <= el.getMaxErrorLevel(); i++) {
			if (distSensorErrorLevels[i] != null) {
				for (Observer observer : distSensorErrorLevels[i].observers) {
					observer.update(dist);
				}
			}
		}
	}

	public void measurementsChanged() {
		notifyObservers();
	}

	public void setMeasurements(float dist) {
		this.dist = dist;
		measurementsChanged();
	}

}
