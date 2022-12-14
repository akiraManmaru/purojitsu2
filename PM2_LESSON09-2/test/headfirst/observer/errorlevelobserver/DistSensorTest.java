package headfirst.observer.errorlevelobserver;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DistSensorTest {
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
	public void クラスが存在する() {
		try {
			Class.forName("headfirst.observer.errorlevelobserver.DistSensor");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void 指定のインターフェースを実装している() {
		List<Class<?>> expects = new ArrayList<Class<?>>();
		expects.add(Subject.class);

		Class<?>[] interfaces = DistSensor.class.getInterfaces();
		for(Class<?> cls : interfaces) {
			assertTrue(expects.contains(cls));
			expects.remove(cls);
		}

		int expected = 0;
		int actual = expects.size();
		assertThat(actual, is(expected));
	}

/*  クラスは継承していないので以下のテストは無効*/
//	@Test
//	public void クラス継承検査() {
//		assertEquals("headfirst.observer.erroelevelobserver.Subject", DistSensor.class.getSuperclass().getName());
//	}

	@Test
	public void メソッド名は英数字以外を含まない() {
		//このテストが不合格になる場合、資料ZeroWidthSpace.pdfの「見分け方」を見て、
		//カーソルキーでゼロ幅スペースを探して削除するとテストを通ります。
		for(Method m : DistSensor.class.getDeclaredMethods()) {
			assertTrue(m.getName().matches("^[0-9a-zA-Z]+$"));
		}
	}

	@Test
	public void メソッド検査() {
		List<String> methods = new ArrayList<String>();
		methods.add("registerObserver");
		methods.add("removeObserver");
		methods.add("notifyObservers");
		methods.add("measurementsChanged");
		methods.add("setMeasurements");
		methods.add("getDist");
		methods.add("countObservers");

		for(Method m : DistSensor.class.getDeclaredMethods()) {
			assertTrue(methods.contains(m.getName()));
			methods.remove(m.getName());
		}

		int expected = 0;
		int actual = methods.size();
		assertThat(actual, is(expected));
	}

	@Test
	public void フィールド存在検査() {
		List<String> fields = new ArrayList<String>();
		fields.add("dist");
		fields.add("observers");
		for(Field f : DistSensor.class.getDeclaredFields()) {
			assertTrue(fields.contains(f.getName()));
			fields.remove(f.getName());
		}

		int expected = 0;
		int actual = fields.size();
		assertThat(actual, is(expected));
	}

	@Test
	public void フィールド型検査dist() {
		Field f;
		try {
			f = DistSensor.class.getDeclaredField("dist");
			assertEquals(float.class, f.getType());
			assertTrue(Modifier.isProtected(f.getModifiers()));
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchFieldException e) {
			fail();
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	@Test
	public void フィールド型検査observers() {
		Field f;
		try {
			f = DistSensor.class.getDeclaredField("observers");
			assertEquals(List.class, f.getType());
			assertTrue(Modifier.isProtected(f.getModifiers()));
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchFieldException e) {
			fail();
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	@Test
	public void クラスDistSensorはsetMeasurementsでフィールドに値を代入する() {
		float distance = 95f;
		float dist;
		@SuppressWarnings("unused")
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			DistSensor ds = new DistSensor();
			new NearWarning(ds, 95f);
			new FarWarning(ds,105f);

			distance = 99f;
			ds.setMeasurements(distance);
			dist=ds.getDist();
			assertThat(dist,is(distance));

			distance = 101f;
			ds.setMeasurements(distance);
			dist=ds.getDist();
			assertThat(dist,is(distance));

			printOut.println("");
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
	}

}

