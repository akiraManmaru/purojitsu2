package exam3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * DomesticatedDuckクラスのテスト
 */
public class EatNoWayTest{
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
	@Test(timeout=100)
	public void クラス実装検査() {
		try {
			Class.forName("headfirst.strategy.eat.EatNoWay");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			fail();
		}
	}

	/**
	 * 指定されたインターフェースを実装しているか検査する
	 */
	@Test(timeout=100)
	public void クラス依存関係検査() {
		Class<?>[] interfaces = headfirst.strategy.eat.EatNoWay.class.getInterfaces();
		assertThat(interfaces.length,is(1));
		assertThat(interfaces[0].getName(),is("headfirst.strategy.eat.EatBehavior"));
	}
	
	/**
	 * 指定されたメソッドのみが存在するか検査する
	 */
	@Test(timeout=100)
	public void メソッド実装検査() {
		Class<?>[] parameterTypes1 = {};
		try {
			headfirst.strategy.eat.EatNoWay.class.getDeclaredMethod("eat", parameterTypes1);
			assertTrue(true);
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchMethodException e) {
			fail();
		}

		Method[] methods = headfirst.strategy.eat.EatNoWay.class.getDeclaredMethods();
		assertThat(methods.length,is(1));
	}
	
	/**
	 * メソッドeat()の動作を検査する
	 */
	@Test(timeout=100)
	public void メソッド動作検査1() {
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			headfirst.strategy.eat.EatNoWay eatBehavior = new headfirst.strategy.eat.EatNoWay();
			eatBehavior.eat();
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertThat(output,is("食べられません"));
	}
}