package exam4;

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
 * Ospreyクラスのテスト
 */
public class LarkTest{
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
			Class.forName("lesson03.exam3_4.Lark");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			fail();
		}
	}

	/**
	 * 指定されたインタフェースの実装を検査する
	 */
	@Test
	public void クラス依存関係検査() {
		Class<?>[] expectedInterfaces = {
				lesson03.exam3_4.Passerine.class
		};
		Class<?> superClass = lesson03.exam3_4.Lark.class.getSuperclass();
		assertEquals("java.lang.Object", superClass.getName());
		Class<?>[] interfaces = lesson03.exam3_4.Lark.class.getInterfaces();
		for (Class<?> iface: expectedInterfaces) {
			boolean flag = false;
			for (Class<?> iface2: interfaces) {
				if(iface.getName().equals(iface2.getName())) {
					flag = true;
					break;
				}
			}
			assertEquals(true, flag);
		}
		assertEquals(expectedInterfaces.length, interfaces.length);
	}

	/**
	 * 指定されたフィールド変数のみが存在するか検査する
	 */
	@Test
	public void フィールド実装検査() {
		int expected = 0;
		int actual = lesson03.exam3_4.Lark.class.getDeclaredFields().length;
		// assertThat(actual, is(expected));
		assertEquals(actual, expected);
	}

	/**
	 * 指定されたメソッドのみが存在するか検査する
	 */
	@Test
	public void メソッド実装検査() {
		Class<?>[] parameterTypes1 = {};
		String[] methods = {"scream", "fly"};
		for(String method: methods) {
			try {
				lesson03.exam3_4.Lark.class.getDeclaredMethod(method, parameterTypes1);
				assertTrue(true);
			} catch (SecurityException e) {
				fail();
			} catch (NoSuchMethodException e) {
				fail();
			}
		}

		try {   //　戻り値の型とアクセス修飾子のチェック
			for (Method m : lesson03.exam3_4.Lark.class.getDeclaredMethods()) {
				assertEquals(void.class, m.getReturnType());
				assertEquals(true, Modifier.isPublic(m.getModifiers()));
			}
		} catch (SecurityException e) {
			fail();
		}

		Method[] obj_methods = lesson03.exam3_4.Lark.class.getDeclaredMethods();
		assertEquals(2, obj_methods.length);
	}

	/**
	 * メソッドquack()の動作を検査する
	 */
	@Test(timeout=100)
	public void メソッド動作検査１() {
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			lesson03.exam3_4.Lark lark = new lesson03.exam3_4.Lark();
			lesson03.exam3_4.PasserineAdapter passerineAdapter = new lesson03.exam3_4.PasserineAdapter(lark);

			passerineAdapter.gobble();
			output += reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("ピーヨ、ピーヨ、ピーヨ、ピーヨ", output);


	}

	/**
	 * メソッドfly()の動作を検査する
	 */
	@Test(timeout=100)
	public void メソッド動作検査2() {
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			lesson03.exam3_4.Lark lark = new lesson03.exam3_4.Lark();
			lesson03.exam3_4.PasserineAdapter passerineAdapter = new lesson03.exam3_4.PasserineAdapter(lark);

			passerineAdapter.fly();
			output += reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("音を立てずに飛びます", output);
	}


}
