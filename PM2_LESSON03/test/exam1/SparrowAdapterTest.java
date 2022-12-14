package exam1;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * SparrowAdapterクラスのテスト
 */
public class SparrowAdapterTest{

	private PipedOutputStream pipOut;
	private PrintStream printOut;

	/**
	 * SparrowApdaterの一般性検証で使用する、
	 * srcには存在しないクラス
	 */
	class Sparrow2 extends lesson03.exam1.Sparrow {
		public void scream() {
			System.out.println("キ");
		}
		public void fly() {
			System.out.println("バ");
		}
	}

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
			Class.forName("lesson03.exam1.SparrowAdapter");
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
				lesson03.exam1.Turkey.class
		};
		Class<?> superClass = lesson03.exam1.SparrowAdapter.class.getSuperclass();
		assertEquals("java.lang.Object", superClass.getName());
		Class<?>[] interfaces = lesson03.exam1.SparrowAdapter.class.getInterfaces();
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
		int expected = 1;
		int actual = lesson03.exam1.SparrowAdapter.class.getDeclaredFields().length;
		// assertThat(actual, is(expected));
		assertEquals(actual, expected);

		String[] fields = {"sparrow"};
		for(String field: fields) {
			try {
				Field f = lesson03.exam1.SparrowAdapter.class.getDeclaredField(field);
				assertTrue(true);
				assertEquals(true, Modifier.isPrivate(f.getModifiers()));
			} catch (SecurityException e) {
				fail();
			} catch (NoSuchFieldException e) {
				fail();
			}
		}
	}

	/**
	 * 指定されたコンストラクタのみが存在するか検査する
	 */
	@Test
	public void コンストラクタ実装検査() {
		Class<?>[] parameterTypes1 = {lesson03.exam1.Sparrow.class};
		try {
			lesson03.exam1.SparrowAdapter.class.getDeclaredConstructor(parameterTypes1);
			assertTrue(true);
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchMethodException e) {
			fail();
		}
		Constructor<?>[] m = lesson03.exam1.SparrowAdapter.class.getDeclaredConstructors();
		assertEquals(1, m.length);
	}

	/**
	 * コンストラクタの動作を検査する
	 */
	@Test
	public void コンストラクタ動作検査() {
		lesson03.exam1.Sparrow falcon = new lesson03.exam1.Sparrow();
		lesson03.exam1.SparrowAdapter falconAdapter = new lesson03.exam1.SparrowAdapter(falcon);
		try {
			Field f = lesson03.exam1.SparrowAdapter.class.getDeclaredField("sparrow");
			f.setAccessible(true);
			assertEquals(falcon, f.get(falconAdapter));
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchFieldException e) {
			fail();
		} catch (IllegalAccessException e) {
			fail();
		}
	}

	/**
	 * 指定されたメソッドのみが存在するか検査する
	 */
	@Test
	public void メソッド実装検査() {

		Class<?>[] parameterTypes1 = {};
		String[] methods = {"gobble", "fly"};
		for(String method: methods) {
			try {
				lesson03.exam1.SparrowAdapter.class.getDeclaredMethod(method, parameterTypes1);
				assertTrue(true);
			} catch (SecurityException e) {
				fail();
			} catch (NoSuchMethodException e) {
				fail();
			}
		}

		try {   //　戻り値の型とアクセス修飾子のチェック
			for (Method m : lesson03.exam1.SparrowAdapter.class.getDeclaredMethods()) {
				assertEquals(void.class, m.getReturnType());
				assertEquals(true, Modifier.isPublic(m.getModifiers()));
			}
		} catch (SecurityException e) {
			fail();
		}

		Method[] obj_methods = lesson03.exam1.SparrowAdapter.class.getDeclaredMethods();
		assertEquals(2, obj_methods.length);
	}

	/**
	 * メソッドgobble()の動作を検査する
	 */
	@Test(timeout=100)
	public void メソッド動作検査１() {
		String output = "";
		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			lesson03.exam1.Sparrow sparrow = new lesson03.exam1.Sparrow();
			lesson03.exam1.SparrowAdapter sparrowAdapter = new lesson03.exam1.SparrowAdapter(sparrow);

			sparrowAdapter.gobble();
			output += reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("ピヨピヨピヨ", output);
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

			lesson03.exam1.Sparrow sparrow = new lesson03.exam1.Sparrow();
			lesson03.exam1.SparrowAdapter sparrowAdapter = new lesson03.exam1.SparrowAdapter(sparrow);

			sparrowAdapter.fly();
			output += reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("パサパサ、パサパサ", output);
	}

	/**
	 * メソッドgobble()の動作を検査する
	 * （srcに存在しないクラスを用いた一般性検証）
	 */
	@Test(timeout=100)
	public void メソッド動作検査3() {
		String output = "";
		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			lesson03.exam1.Sparrow sparrow = new Sparrow2();
			lesson03.exam1.SparrowAdapter sparrowAdapter = new lesson03.exam1.SparrowAdapter(sparrow);

			sparrowAdapter.gobble();
			output += reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("キ", output);
	}

	/**
	 * メソッドfly()の動作を検査する
	 * （srcに存在しないクラスを用いた一般性検証）
	 */
	@Test(timeout=100)
	public void メソッド動作検査4() {
		String output = "";
		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			lesson03.exam1.Sparrow sparrow = new Sparrow2();
			lesson03.exam1.SparrowAdapter sparrowAdapter = new lesson03.exam1.SparrowAdapter(sparrow);

			sparrowAdapter.fly();
			output += reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("バ", output);
	}

}
