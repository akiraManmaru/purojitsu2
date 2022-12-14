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

public class NearWarningTest {
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
			Class.forName("headfirst.observer.errorlevelobserver.NearWarning");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void クラス継承検査() {
		assertEquals("headfirst.observer.errorlevelobserver.CurrentDistDisplay", NearWarning.class.getSuperclass().getName());
	}

	@Test
	public void コンストラクタでObservableを登録している() {
		try {
			DistSensor ds = new DistSensor();
			assertThat(0, is(ds.countObservers()));
			new NearWarning(ds,95f);
			assertThat(1, is(ds.countObservers()));
		} catch (SecurityException e) {
			fail();
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	@Test
	public void メソッド名は英数字以外を含まない() {
		//このテストが不合格になる場合、資料ZeroWidthSpace.pdfの「見分け方」を見て、
		//カーソルキーでゼロ幅スペースを探して削除するとテストを通ります。
		for(Method m : NearWarning.class.getDeclaredMethods()) {
			assertTrue(m.getName().matches("^[0-9a-zA-Z]+$"));
		}
	}

	@Test
	public void メソッド存在検査() {
		List<String> methods = new ArrayList<String>();
		methods.add("update");
		methods.add("display");

		for(Method m : NearWarning.class.getDeclaredMethods()) {
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
//		fields.add("dist");
//		fields.add("observable");
		fields.add("distThreshold");

		for(Field f : NearWarning.class.getDeclaredFields()) {
			assertTrue(fields.contains(f.getName()));
			fields.remove(f.getName());
		}

		int expected = 0;
		int actual = fields.size();
		assertThat(actual, is(expected));
	}

	@Test
	public void フィールド型検査() {
		Field f;
		try {
			f = NearWarning.class.getDeclaredField("distThreshold");
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
	public void dist95のときに表示する() {
		float dist = 95f;
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			DistSensor ds = new DistSensor();
			new NearWarning(ds,95f);
			ds.setMeasurements(dist);

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
	public void dist96のときに表示しない() {
		float dist = 96f;
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			DistSensor ds = new DistSensor();
			new NearWarning(ds,95f);
			ds.setMeasurements(dist);

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

