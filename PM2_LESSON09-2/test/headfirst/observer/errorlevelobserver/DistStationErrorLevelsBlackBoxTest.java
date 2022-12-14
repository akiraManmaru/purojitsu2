package headfirst.observer.errorlevelobserver;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DistStationErrorLevelsBlackBoxTest {
	private PipedOutputStream pipOut;
	private PrintStream printOut;

	@Before
	public void setUp() {
		pipOut = new PipedOutputStream();
		printOut = new PrintStream(pipOut);
		System.setOut(printOut);
	}

	@After
	public void tearDown() {
		System.setOut(null);
		try {
			printOut.close();
			pipOut.close();
		} catch (IOException e) {
		}
	}

	@Test
	public void クラスFarDistWarningはdist105のときに表示する_現在のエラーレベルが最小の時() {
		float dist = 105f;
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			ErrorLevel el=ErrorLevel.getInstance();
			el.putErrorLevel(el.getMinErrorLevel());
			DistSensorErrorLevels distSensorEL = new DistSensorErrorLevels();
			new FarWarning(distSensorEL.getDistSensorAtErrorLevel(5),105f);
						distSensorEL.setMeasurements(dist);

			printOut.println("");
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("遠すぎます。距離は" + dist + "です。", output);
	}

	@Test
	public void クラスFarDistWarningはdist105のときに表示する_現在のエラーレベルもWarningのエラーレベルも両方とも最大の時() {
		float dist = 105f;
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			ErrorLevel el=ErrorLevel.getInstance();
			el.putErrorLevel(el.getMaxErrorLevel());
			DistSensorErrorLevels distSensorEL = new DistSensorErrorLevels();
			new FarWarning(distSensorEL.getDistSensorAtErrorLevel(el.getMaxErrorLevel()),105f);
						distSensorEL.setMeasurements(dist);

			printOut.println("");
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("遠すぎます。距離は" + dist + "です。", output);
	}

	@Test
	public void クラスFarDistWarningはdist105のときに表示しない_現在のエラーレベルより小さい時() {
		float dist = 105f;
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			ErrorLevel el=ErrorLevel.getInstance();
			el.putErrorLevel(5);
			DistSensorErrorLevels distSensorEL = new DistSensorErrorLevels();
			new FarWarning(distSensorEL.getDistSensorAtErrorLevel(3),105f);
						distSensorEL.setMeasurements(dist);

			printOut.println("");
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("", output);
	}



	@Test
	public void クラスNearDistWarningはdist95のときに表示する_現在のエラーレベルが最小の時() {
		float dist = 95f;
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			ErrorLevel el=ErrorLevel.getInstance();
			el.putErrorLevel(el.getMinErrorLevel());
			DistSensorErrorLevels distSensorEL = new DistSensorErrorLevels();
			new NearWarning(distSensorEL.getDistSensorAtErrorLevel(5),95f);
						distSensorEL.setMeasurements(dist);

			printOut.println("");
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("近すぎます。距離は" + dist + "です。", output);
	}

	@Test
	public void クラスNearDistWarningはdist95のときに表示する_現在のエラーレベルもWarningのエラーレベルも両方とも最大の時() {
		float dist = 95f;
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			ErrorLevel el=ErrorLevel.getInstance();
			el.putErrorLevel(el.getMaxErrorLevel());
			DistSensorErrorLevels distSensorEL = new DistSensorErrorLevels();
			new NearWarning(distSensorEL.getDistSensorAtErrorLevel(el.getMaxErrorLevel()),95f);
						distSensorEL.setMeasurements(dist);

			printOut.println("");
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("近すぎます。距離は" + dist + "です。", output);
	}

	@Test
	public void クラスNearDistWarningはdist95のときに表示しない_現在のエラーレベルより小さい時() {
		float dist = 95f;
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			ErrorLevel el=ErrorLevel.getInstance();
			el.putErrorLevel(10);
			DistSensorErrorLevels distSensorEL = new DistSensorErrorLevels();
			new NearWarning(distSensorEL.getDistSensorAtErrorLevel(1),95f);
						distSensorEL.setMeasurements(dist);

			printOut.println("");
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("", output);
	}
	@Test
	public void クラスNearDistWarningはdist95のときに表示しない_現在のエラーレベルより小さい_登録エラーレベル指定無しの時() {
		float dist = 95f;
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			ErrorLevel el=ErrorLevel.getInstance();
			el.putErrorLevel(10);
			DistSensorErrorLevels distSensorEL = new DistSensorErrorLevels();
			new NearWarning(distSensorEL,95f);
						distSensorEL.setMeasurements(dist);

			printOut.println("");
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("", output);
	}

}

