package exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * DomesticatedDuckクラスのテスト
 */
public class FlyWithMetalWingsTest{
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

	/**
	 * クラスが存在するか検査する
	 */
	@Test
	public void クラス実装検査() {
		try {
			Class.forName("headfirst.strategy.FlyWithMetalWings");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			fail();
		}
	}

	/**
	 * 指定されたインターフェースを実装しているか検査する
	 */
	@Test
	public void クラス依存関係検査() {
		Class<?>[] interfaces = headfirst.strategy.FlyWithMetalWings.class.getInterfaces();
		assertThat(interfaces.length,is(1));
		assertThat(interfaces[0].getName(),is("headfirst.strategy.FlyBehavior"));
	}
	
	/**
	 * 指定されたメソッドのみが存在するか検査する
	 */
	@Test
	public void メソッド実装検査() {
		Class<?>[] parameterTypes1 = {};
		try {
			headfirst.strategy.FlyWithMetalWings.class.getDeclaredMethod("fly", parameterTypes1);
			assertTrue(true);
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchMethodException e) {
			fail();
		}

		Method[] methods = headfirst.strategy.FlyWithMetalWings.class.getDeclaredMethods();
		assertThat(methods.length,is(1));
	}
	
	/**
	 * メソッドfly()の動作を検査する
	 */
	@Test
	public void メソッド動作検査１() {
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			headfirst.strategy.FlyWithMetalWings flyBehavior = new headfirst.strategy.FlyWithMetalWings();
			flyBehavior.fly();
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertThat(output,is("金属の翼で飛んでいます"));
	}
}
