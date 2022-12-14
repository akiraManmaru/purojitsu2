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

public class WeatherStation1BlackBoxTest {
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
	public void クラスTempHumidWarningは全角コロンを含まない() {
		float temperature = 100f;
		float humidity = 100f;
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			WeatherData wd = new WeatherData();
			new TempHumidWarning(wd);
			wd.setMeasurements(temperature, humidity, 23f);

			printOut.println("");
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertFalse(output.contains("："));
	}

	@Test
	public void クラスTempHumidWarningは半角小文字のcを含まない() {
		float temperature = 100f;
		float humidity = 100f;
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			WeatherData wd = new WeatherData();
			new TempHumidWarning(wd);
			wd.setMeasurements(temperature, humidity, 23f);

			printOut.println("");
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertFalse(output.contains("c"));
	}

	@Test
	public void クラスTempHumidWarningは全角パーセント記号を含まない() {
		float temperature = 100f;
		float humidity = 100f;
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			WeatherData wd = new WeatherData();
			new TempHumidWarning(wd);
			wd.setMeasurements(temperature, humidity, 23f);

			printOut.println("");
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertFalse(output.contains("％"));
	}

	@Test
	public void クラスTempHumidWarningは全角空白を含まない() {
		float temperature = 100f;
		float humidity = 100f;
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			WeatherData wd = new WeatherData();
			new TempHumidWarning(wd);
			wd.setMeasurements(temperature, humidity, 23f);

			printOut.println("");
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertFalse(output.contains("　"));
	}

	@Test
	public void クラスTempHumidWarningは文字列温度を含まない() {
		float temperature = 100f;
		float humidity = 100f;
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			WeatherData wd = new WeatherData();
			new TempHumidWarning(wd);
			wd.setMeasurements(temperature, humidity, 23f);

			printOut.println("");
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertFalse(output.contains("温度"));
	}

	@Test
	public void クラスTempHumidWarningは気温30で湿度60のときに表示する() {
		float temperature = 30f;
		float humidity = 60f;
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			WeatherData wd = new WeatherData();
			new TempHumidWarning(wd);
			wd.setMeasurements(temperature, humidity, 23f);

			printOut.println("");
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("警告: 気温" + temperature + "度C 湿度" + humidity + "%です。注意してください。", output);
	}

	@Test
	public void クラスTempHumidWarningは気温30で湿度59のときに表示しない() {
		float temperature = 30f;
		float humidity = 59f;
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			WeatherData wd = new WeatherData();
			new TempHumidWarning(wd);
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
	public void クラスTempHumidWarningは気温29で湿度60のときに表示しない() {
		float temperature = 29f;
		float humidity = 60f;
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			WeatherData wd = new WeatherData();
			new TempHumidWarning(wd);
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
	public void クラスTempHumidWarningは気温29で湿度59のときに表示しない() {
		float temperature = 29f;
		float humidity = 59f;
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			WeatherData wd = new WeatherData();
			new TempHumidWarning(wd);
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

}