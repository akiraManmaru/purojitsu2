package headfirst.observer.errorlevelobserver;

/**
 * テストドライブ
 */
public class DistStationErrorLevel {

	public static void main(String[] args) {
		ErrorLevel el=ErrorLevel.getInstance();

		DistSensorErrorLevels distSensorEL = new DistSensorErrorLevels();
		@SuppressWarnings("unused")
		CurrentDistDisplay cdd = new CurrentDistDisplay(distSensorEL);
		@SuppressWarnings("unused")
		FarWarning fdw = new FarWarning(distSensorEL.getDistSensorAtErrorLevel(3),105f);
		@SuppressWarnings("unused")
		NearWarning ndw = new NearWarning(distSensorEL.getDistSensorAtErrorLevel(5),95f);

		System.out.println("--------------------");
		el.putErrorLevel(1);
		el.displayCurrentErrorLevel();
		distSensorEL.setMeasurements(94f);
		distSensorEL.setMeasurements(100f);
		distSensorEL.setMeasurements(106f);
		System.out.println("--------------------");
		el.putErrorLevel(3);
		el.displayCurrentErrorLevel();
		distSensorEL.setMeasurements(94f);
		distSensorEL.setMeasurements(100f);
		distSensorEL.setMeasurements(106f);
		System.out.println("--------------------");
		el.putErrorLevel(5);
		el.displayCurrentErrorLevel();
		distSensorEL.setMeasurements(94f);
		distSensorEL.setMeasurements(100f);
		distSensorEL.setMeasurements(106f);
		System.out.println("--------------------");
	}
}
