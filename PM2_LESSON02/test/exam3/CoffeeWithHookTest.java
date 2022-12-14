package exam3;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * CoffeeWithHookクラスのテスト
 */
public class CoffeeWithHookTest{
	private PipedOutputStream pipOut;
	private PrintStream printOut;
	private InputStream in;

	@Before
	public void setUp() {
		pipOut = new PipedOutputStream();
		printOut = new PrintStream(pipOut);
		System.setOut(printOut);
		in = System.in;
	}

	@After
	public void tearDown() {
		System.setOut(null);
		try {
			printOut.close();
			pipOut.close();
			System.setIn(in);
		} catch (IOException e) {
		}
	}

	/**
	 * クラスが存在するか検査する
	 */
	@Test
	public void クラス実装検査() {
		try {
			Class.forName("lesson02.exam3.CoffeeWithHook");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			fail();
		}
	}

	/**
	 * 指定された通りにクラスを継承しているか検査する
	 */
	@Test
	public void クラス依存関係検査() {
		Class<?> superClass = lesson02.exam3.CoffeeWithHook.class.getSuperclass();
		assertEquals("lesson02.exam3.CaffeineDrinkWithHook", superClass.getName());
	}

	/**
	 * 指定されたフィールド変数のみが存在するか検査する
	 */
	@Test
	public void フィールド実装検査() {

		int expected = 0;
		int actual = lesson02.exam3.CoffeeWithHook.class.getDeclaredFields().length;
		assertThat(actual, is(expected));
	}

	/**
	 * 指定されたメソッドのみが存在するか検査する
	 */
	@Test
	public void メソッド実装検査() {
		Class<?>[] parameterTypes1 = {};
		String[] methods = {"brew",
				"putCondiments", "customerWantsCondiments"};

		for(String method: methods) {
			try {
				lesson02.exam3.CoffeeWithHook.class.getDeclaredMethod(method, parameterTypes1);
				assertTrue(true);
			} catch (SecurityException e) {
				fail();
			} catch (NoSuchMethodException e) {
				fail();
			}
		}

		try {   //　戻り値の型とアクセス修飾子のチェック
			for (Method m : lesson02.exam3.CoffeeWithHook.class.getDeclaredMethods()) {
				if (m.getName().equals("customerWantsCondiments")) {
					assertEquals(boolean.class, m.getReturnType());
				}
				else {
					assertEquals(void.class, m.getReturnType());
				}
				assertEquals(true, Modifier.isPublic(m.getModifiers()));
			}
		} catch (SecurityException e) {
			fail();
		}

		Method[] obj_methods = lesson02.exam3.CoffeeWithHook.class.getDeclaredMethods();
		assertEquals(3, obj_methods.length);
	}

	/**
	 * メソッドbrew()の動作を検査する
	 */
	@Test
	public void メソッド動作検査１() {
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			lesson02.exam3.CoffeeWithHook coffee = new lesson02.exam3.CoffeeWithHook();
			coffee.brew();
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("フィルタでコーヒーをドリップします", output);
	}

	/**
	 * メソッドputCondiments()の動作を検査する
	 */
	@Test
	public void メソッド動作検査2() {
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			lesson02.exam3.CoffeeWithHook coffee = new lesson02.exam3.CoffeeWithHook();
			coffee.putCondiments();
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("砂糖とミルクを追加します", output);
	}


	/**
	 * メソッドcustomerWantsCondiments()の動作を検査する　Yesの場合
	 */
	@Test
	public void メソッド動作検査3() {

		byte[] input = ("Yes\n").getBytes();
		System.setIn(new ByteArrayInputStream(input));

		lesson02.exam3.CoffeeWithHook coffee = new lesson02.exam3.CoffeeWithHook();
		boolean ret = coffee.customerWantsCondiments();
		assertEquals(true, ret);
	}

	@Test
	public void メソッド動作検査4() {

		byte[] input = ("y\n").getBytes();
		System.setIn(new ByteArrayInputStream(input));

		lesson02.exam3.CoffeeWithHook coffee = new lesson02.exam3.CoffeeWithHook();
		boolean ret = coffee.customerWantsCondiments();
		assertEquals(true, ret);
	}

	/**
	 * メソッドcustomerWantsCondiments()の動作を検査する（Noの場合）
	 */
	@Test
	public void メソッド動作検査5() {

		byte[] input = ("No\n").getBytes();
		System.setIn(new ByteArrayInputStream(input));

		lesson02.exam3.CoffeeWithHook coffee = new lesson02.exam3.CoffeeWithHook();
		boolean ret = coffee.customerWantsCondiments();
		assertEquals(false, ret);
	}

	@Test
	public void メソッド動作検査6() {

		byte[] input = ("engin\n").getBytes();
		System.setIn(new ByteArrayInputStream(input));

		lesson02.exam3.CoffeeWithHook coffee = new lesson02.exam3.CoffeeWithHook();
		boolean ret = coffee.customerWantsCondiments();
		assertEquals(false, ret);
	}

}
