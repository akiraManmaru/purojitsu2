package headfirst.observer.weather2;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TempHumidWarningTest {
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
	public void クラスTempHumidWarningが存在する() {
		try {
			Class.forName("headfirst.observer.weather2.TempHumidWarning");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void クラスTempHumidWarningがObserverとDisplayElementを実装している() {
		List<Class<?>> expects = new ArrayList<Class<?>>();
		expects.add(Observer.class);
		expects.add(DisplayElement.class);

		Class<?>[] interfaces = TempHumidWarning.class.getInterfaces();
		for(Class<?> cls : interfaces) {
			assertTrue(expects.contains(cls));
			expects.remove(cls);
		}

		int expected = 0;
		int actual = expects.size();
		assertThat(actual, is(expected));
	}

/*	@Test
	public void クラスTempHumidWarningのコンストラクタでObserverを登録している() {
		Field f = null;
		try {
			f = WeatherData.class.getDeclaredField("observers");
			f.setAccessible(true);
			WeatherData wd = new WeatherData();
			TempHumidWarning hwd = new TempHumidWarning(wd);
			@SuppressWarnings("unchecked")
			ArrayList<Observer> list = (ArrayList<Observer>) f.get(wd);
			assertTrue(list.contains(hwd));
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchFieldException e) {
			fail();
		} catch (IllegalArgumentException e) {
			fail();
		} catch (IllegalAccessException e) {
			fail();
		}
	}
*/
	@Test
	public void クラスTempHumidWarningのコンストラクタでObserverを登録している() {
		Field f = null;
		try {
			f = WeatherData.class.getDeclaredField("observers");
			f.setAccessible(true);
			WeatherData wd = new WeatherData();
			TempHumidWarning hwd = new TempHumidWarning(wd);
			@SuppressWarnings("unchecked")
			ArrayList<Observer> list = (ArrayList<Observer>) f.get(wd);
			assertTrue(list.contains(hwd));
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchFieldException e) {
			fail();
		} catch (IllegalArgumentException e) {
			fail();
		} catch (IllegalAccessException e) {
			fail();
		}
	}

	@Test
	public void クラスTempHumidWarningのメソッド名は英数字以外を含まない() {
		for(Method m : TempHumidWarning.class.getDeclaredMethods()) {
			//このテストが不合格になる場合、資料ZeroWidthSpace.pdfの「見分け方」を見て、
			//カーソルキーでゼロ幅スペースを探して削除するとテストを通ります。
			assertTrue(m.getName().matches("^[0-9a-zA-Z]+$"));
		}
	}

	@Test
	public void クラスTempHumidWarningのメソッドはupdateとdisplayのみが存在する() {
		List<String> methods = new ArrayList<String>();
		methods.add("update");
		methods.add("display");

		for(Method m : TempHumidWarning.class.getDeclaredMethods()) {
			assertTrue(methods.contains(m.getName()));
			methods.remove(m.getName());
		}

		int expected = 0;
		int actual = methods.size();
		assertThat(actual, is(expected));
	}

	@Test
	public void クラスTempHumidWarningのフィールドはtemperatureとhumidityとweatherDataとtemperatureThresholdとhumidityThresholdのみが存在する() {
		List<String> fields = new ArrayList<String>();
		fields.add("temperature");
		fields.add("humidity");
		fields.add("weatherData");
		fields.add("temperatureThreshold");
		fields.add("humidityThreshold");

		for(Field f : TempHumidWarning.class.getDeclaredFields()) {
			assertTrue(fields.contains(f.getName()));
			fields.remove(f.getName());
		}

		int expected = 0;
		int actual = fields.size();
		assertThat(actual, is(expected));
	}

	@Test
	public void クラスTempHumidWarningのフィールドの型が指定通りである() {
		Field f;
		try {
			f = TempHumidWarning.class.getDeclaredField("temperature");
			assertEquals(float.class, f.getType());
			f = TempHumidWarning.class.getDeclaredField("humidity");
			assertEquals(float.class, f.getType());
			f = TempHumidWarning.class.getDeclaredField("weatherData");
			assertEquals(Subject.class, f.getType());
			f = TempHumidWarning.class.getDeclaredField("temperatureThreshold");
			assertEquals(float.class, f.getType());
			f = TempHumidWarning.class.getDeclaredField("humidityThreshold");
			assertEquals(float.class, f.getType());
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchFieldException e) {
			fail();
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	@Test
	public void クラスTempHumidWarningのメソッドupdateとdisplayが仕様通り動作する() {
		Field tempField = null;
		Field humiField = null;
		float temp = 0.0f;
		float humi = 0.0f;

		WeatherData wd = new WeatherData();
		TempHumidWarning hwd = new TempHumidWarning(wd);

		try {
			tempField = TempHumidWarning.class.getDeclaredField("temperature");
			humiField = TempHumidWarning.class.getDeclaredField("humidity");
			tempField.setAccessible(true);
			humiField.setAccessible(true);

			wd.setMeasurements(30.1f, 60.1f, 0);
			temp = (Float) tempField.get(hwd);
			humi = (Float) humiField.get(hwd);
			assertThat(temp, is(30.1f));
			assertThat(humi, is(60.1f));

			wd.setMeasurements(29.9f, 59.9f, 0);
			temp = (Float) tempField.get(hwd);
			humi = (Float) humiField.get(hwd);
			assertThat(temp, is(30.1f));
			assertThat(humi, is(60.1f));

			wd.setMeasurements(30.1f, 59.9f, 0);
			temp = (Float) tempField.get(hwd);
			humi = (Float) humiField.get(hwd);
			assertThat(temp, is(30.1f));
			assertThat(humi, is(60.1f));

			wd.setMeasurements(29.9f, 60.1f, 0);
			temp = (Float) tempField.get(hwd);
			humi = (Float) humiField.get(hwd);
			assertThat(temp, is(30.1f));
			assertThat(humi, is(60.1f));

			wd.setMeasurements(30.0f, 60.0f, 0);
			temp = (Float) tempField.get(hwd);
			humi = (Float) humiField.get(hwd);
			assertThat(temp, is(30.0f));
			assertThat(humi, is(60.0f));
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchFieldException e) {
			fail();
		} catch (IllegalArgumentException e) {
			fail();
		} catch (IllegalAccessException e) {
			fail();
		}
	}
}