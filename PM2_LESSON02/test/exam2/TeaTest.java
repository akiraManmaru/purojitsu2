package exam2;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
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
 * Teaクラスのテスト
 */
public class TeaTest{
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
			Class.forName("lesson02.exam1_2.Tea");
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
		Class<?> superClass = lesson02.exam1_2.Tea.class.getSuperclass();
		assertEquals("lesson02.exam1_2.CaffeineDrink", superClass.getName());
	}

	/**
	 * 指定されたフィールド変数のみが存在するか検査する
	 */
	@Test
	public void フィールド実装検査() {

		int expected = 0;
		int actual = lesson02.exam1_2.Tea.class.getDeclaredFields().length;
		assertThat(actual, is(expected));
	}

	/**
	 * 指定されたメソッドのみが存在するか検査する
	 */
	@Test
	public void メソッド実装検査() {
		Class<?>[] parameterTypes1 = {};
		String[] methods = {"brew", "putCondiments"};
		for(String method: methods) {
			try {
				lesson02.exam1_2.Tea.class.getDeclaredMethod(method, parameterTypes1);
				assertTrue(true);
			} catch (SecurityException e) {
				fail();
			} catch (NoSuchMethodException e) {
				fail();
			}
		}	

		try {   //　戻り値の型とアクセス修飾子のチェック
			for (Method m : lesson02.exam1_2.Tea.class.getDeclaredMethods()) {
				assertEquals(void.class, m.getReturnType());
				assertEquals(true, Modifier.isPublic(m.getModifiers()));
			}
		} catch (SecurityException e) {
			fail();
		}


		Method[] obj_methods = lesson02.exam1_2.Tea.class.getDeclaredMethods();
		assertEquals(2, obj_methods.length);
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

			lesson02.exam1_2.Tea tea = new lesson02.exam1_2.Tea();
			tea.brew();
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("ティーバックを浸します", output);
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

			lesson02.exam1_2.Tea  tea = new lesson02.exam1_2.Tea();
			tea.putCondiments();
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("レモンを入れます", output);
	}


}
