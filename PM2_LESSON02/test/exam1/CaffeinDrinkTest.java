package exam1;

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
 * CaffeineDrinkTestクラスのテスト
 */
public class CaffeinDrinkTest{
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
			Class.forName("lesson02.exam1_2.CaffeineDrink");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			fail();
		}
	}
	/**
	 * 指定されたフィールド変数のみが存在するか検査する
	 */
	@Test
	public void フィールド実装検査() {

		int expected = 0;
		int actual = lesson02.exam1_2.CaffeineDrink.class.getDeclaredFields().length;
		assertThat(actual, is(expected));
	}

	/**
	 * 指定されたメソッドのみが存在するか検査する
	 */
	@Test
	public void メソッド実装検査() {
		Class<?>[] parameterTypes1 = {};
		String[] methods = {"prepareRecipe", "brew", 
				"putCondiments", "boilWater",
				"pourInCup"};
		for(String method: methods) {
			try {
				lesson02.exam1_2.CaffeineDrink.class.getDeclaredMethod(method, parameterTypes1);
				assertTrue(true);
			} catch (SecurityException e) {
				fail();
			} catch (NoSuchMethodException e) {
				fail();
			}
		}	

		try {   //　戻り値の型とアクセス修飾子のチェック
			for (Method m : lesson02.exam1_2.CaffeineDrink.class.getDeclaredMethods()) {
				assertEquals(void.class, m.getReturnType());
				assertEquals(true, Modifier.isPublic(m.getModifiers()));
			}
		} catch (SecurityException e) {
			fail();
		}

		
		
		try {
			Method m = lesson02.exam1_2.CaffeineDrink.class.getDeclaredMethod("prepareRecipe", parameterTypes1);
			assertTrue(true);
			assertEquals(true, Modifier.isFinal(m.getModifiers()));
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchMethodException e) {
			fail();
		}

		try {
			Method m = lesson02.exam1_2.CaffeineDrink.class.getDeclaredMethod("brew", parameterTypes1);
			assertTrue(true);
			assertEquals(true, Modifier.isAbstract(m.getModifiers()));
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchMethodException e) {
			fail();
		}
		
		try {
			Method m = lesson02.exam1_2.CaffeineDrink.class.getDeclaredMethod("putCondiments", parameterTypes1);
			assertTrue(true);
			assertEquals(true, Modifier.isAbstract(m.getModifiers()));
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchMethodException e) {
			fail();
		}

		Method[] obj_methods = lesson02.exam1_2.CaffeineDrink.class.getDeclaredMethods();
		assertEquals(5, obj_methods.length);
	}
	
	/**
	 * メソッドboilWater()の動作を検査する
	 */
	@Test
	public void メソッド動作検査１() {
		String output = "";

		try {   // Coffeeを書き換えてboilWater()を実装していないかをチェック
			for (Method m : lesson02.exam1_2.Coffee.class.getDeclaredMethods()) {
				assertTrue(!m.equals("boilWater"));
			}
		} catch (SecurityException e) {
			fail();
		}

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			lesson02.exam1_2.CaffeineDrink coffee = new lesson02.exam1_2.Coffee();
			coffee.boilWater();
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("お湯を沸かします", output);
	}
	
	/**
	 * メソッドpourInCup()の動作を検査する
	 */
	@Test
	public void メソッド動作検査2() {
		String output = "";

		try {   // Coffeeを書き換えてpourInCup()を実装していないかをチェック
			for (Method m : lesson02.exam1_2.Coffee.class.getDeclaredMethods()) {
				assertTrue(!m.equals("pourInCup"));
			}
		} catch (SecurityException e) {
			fail();
		}

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			lesson02.exam1_2.CaffeineDrink coffee = new lesson02.exam1_2.Coffee();
			coffee.pourInCup();
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("カップに注ぎます", output);
	}


}
