package headfirst.observer.weather2;

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

public class WeatherStation2BlackBoxTest {
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
	public void クラスHeatIndexWarningは気温28で湿度60のときに表示しない() {
		float temperature = 28f;
		float humidity = 60f;
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			WeatherData wd = new WeatherData();
			new HeatIndexWarning(wd);
			wd.setMeasurements(temperature, humidity, 23f);

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
	public void クラスHeatIndexWarningは気温32で湿度70のときに表示する() {
		float temperature = 32f;
		float humidity = 70f;
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			WeatherData wd = new WeatherData();
			new HeatIndexWarning(wd);
			wd.setMeasurements(temperature, humidity, 23f);

			printOut.println("");
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("熱中症に注意してください", output);
	}
	@Test
	public void クラスHeatIndexWarningは気温28で湿度70のときに表示しない() {
		float temperature = 28f;
		float humidity = 70f;
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			WeatherData wd = new WeatherData();
			new HeatIndexWarning(wd);
			wd.setMeasurements(temperature, humidity, 23f);

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
	public void クラスHeatIndexWarningは気温29で湿度90のときに表示する() {
		float temperature = 29f;
		float humidity = 90f;
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			WeatherData wd = new WeatherData();
			new HeatIndexWarning(wd);
			wd.setMeasurements(temperature, humidity, 23f);

			printOut.println("");
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("熱中症に注意してください", output);
		}

}
