package headfirst.observer.distanceobserver;

/**
 * テストドライブ
 */
public class DistStation {

	public static void main(String[] args) {
		DistSensor distSensor = new DistSensor();
		@SuppressWarnings("unused")
		CurrentDistDisplay cdd = new CurrentDistDisplay(distSensor);
		@SuppressWarnings("unused")
		FarWarning fdw = new FarWarning(distSensor,105f);
		@SuppressWarnings("unused")
		NearWarning ndw = new NearWarning(distSensor,95f);

		distSensor.setMeasurements(94f);
		distSensor.setMeasurements(100f);
		distSensor.setMeasurements(106f);
	}
}
