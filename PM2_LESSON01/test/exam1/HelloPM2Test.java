package exam1;

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
 * HelloPM2クラスのテスト
 */
public class HelloPM2Test{
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
			Class.forName("hello.HelloPM2");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			fail();
		}
	}

	/**
	 * 指定されたメソッドのみが存在するか検査する
	 */
	@Test(timeout=100)
	public void メソッド実装検査() {
		Class<?>[] parameterTypes1 = {};
		try {
			hello.HelloPM2.class.getDeclaredMethod("say", parameterTypes1);
			assertTrue(true);
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchMethodException e) {
			fail();
		}

		Method[] methods = hello.HelloPM2.class.getDeclaredMethods();
		assertThat(methods.length,is(2));
	}
	
	/**
	 * メソッドsay()の動作を検査する
	 */
	@Test(timeout=100)
	public void メソッド動作検査１() {
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			hello.HelloPM2 pm2 = new hello.HelloPM2();
			pm2.setName("pj2");
			pm2.say();
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertThat(output,is("Hello pj2"));
	}

}