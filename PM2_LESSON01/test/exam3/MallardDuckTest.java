package exam3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * MallardDuckクラスのテスト
 */
public class MallardDuckTest{
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
			Class.forName("headfirst.strategy.eat.MallardDuck");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			fail();
		}
	}
	
	/**
	 * 指定されたフィールド変数のみが存在するか検査する
	 */
	@Test(timeout=100)
	public void フィールド実装検査() {
		Field[] fields = headfirst.strategy.eat.MallardDuck.class.getDeclaredFields();

		int expected = 0;
		int actual = fields.length;
		assertThat(actual, is(expected));
	}

	/**
	 * 指定されたメソッドのみが存在するか検査する
	 */
	@Test(timeout=100)
	public void メソッド実装検査() {
		Class<?>[] parameterTypes1 = {};
		try {
			headfirst.strategy.eat.MallardDuck.class.getDeclaredMethod("display", parameterTypes1);
			assertTrue(true);
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchMethodException e) {
			fail();
		}

		Method[] methods = headfirst.strategy.eat.MallardDuck.class.getDeclaredMethods();
		assertThat(methods.length,is(1));
	}

	/**
	 * メソッドdisplay()の動作を検査する
	 */
	@Test(timeout=100)
	public void メソッド動作検査1() {
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			headfirst.strategy.eat.MallardDuck mallard = new headfirst.strategy.eat.MallardDuck();
			mallard.display();
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("本物のマガモです", output);
	}
	
	/**
	 * メソッドperformFly()の動作を検査する
	 */
	@Test(timeout=100)
	public void メソッド動作検査2() {
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			headfirst.strategy.eat.MallardDuck mallard = new headfirst.strategy.eat.MallardDuck();
			mallard.performFly();
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertThat(output,is("飛んでいます！！"));
	}
	
	/**
	 * メソッドperformQuack()の動作を検査する
	 */
	@Test(timeout=100)
	public void メソッド動作検査3() {
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			headfirst.strategy.eat.MallardDuck mallard = new headfirst.strategy.eat.MallardDuck();
			mallard.performQuack();
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertThat(output,is("ガーガー"));
	}
	
	/**
	 * メソッドperformEat()の動作を検査する
	 */
	@Test(timeout=100)
	public void メソッド動作検査4() {
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			headfirst.strategy.eat.MallardDuck mallard = new headfirst.strategy.eat.MallardDuck();
			mallard.performEat();
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertThat(output,is("食べています！！"));
	}
	
	/**
	 * メソッドswim()の動作を検査する
	 */
	@Test(timeout=100)
	public void メソッド動作検査5() {
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			headfirst.strategy.eat.MallardDuck mallard = new headfirst.strategy.eat.MallardDuck();
			mallard.swim();
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertThat(output,is("カモなら、たとえおとりでも泳ぎます"));
	}
}
