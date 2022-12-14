package exam3;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * DomesticatedDuckクラスのテスト
 */
public class DuckTest{
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
			Class.forName("headfirst.strategy.eat.Duck");
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
		List<String> fields = new ArrayList<String>();
		fields.add("flyBehavior");
		fields.add("quackBehavior");
		fields.add("eatBehavior");

		for(Field f : headfirst.strategy.eat.Duck.class.getDeclaredFields()) {
			assertTrue(fields.contains(f.getName()));
			fields.remove(f.getName());
		}

		int expected = 0;
		int actual = fields.size();
		assertThat(actual, is(expected));
	}
	
	/**
	 * フィールドの型が指定通りであるか検査する
	 */
	@Test(timeout=100)
	public void フィールド型検査() {
		Field f;
		try {
			f = headfirst.strategy.eat.Duck.class.getDeclaredField("flyBehavior");
			assertEquals(f.getType(),headfirst.strategy.FlyBehavior.class);
			f = headfirst.strategy.eat.Duck.class.getDeclaredField("quackBehavior");
			assertEquals(f.getType(),headfirst.strategy.QuackBehavior.class);
			f = headfirst.strategy.eat.Duck.class.getDeclaredField("eatBehavior");
			assertEquals(f.getType(),headfirst.strategy.eat.EatBehavior.class);
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchFieldException e) {
			fail();
		} catch (IllegalArgumentException e) {
			fail();
		}
	}
	/**
	 * 指定されたメソッドのみが存在するか検査する
	 */
	@Test(timeout=100)
	public void メソッド実装検査() {
		Class<?>[] parameterTypes1 = {};
		String[] methods = {"display", "performFly", 
				"performQuack", "performEat",
				"swim"};
		for(String method: methods) {
			try {
				headfirst.strategy.eat.Duck.class.getDeclaredMethod(method, parameterTypes1);
				assertTrue(true);
			} catch (SecurityException e) {
				fail();
			} catch (NoSuchMethodException e) {
				fail();
			}
		}	

		Class<?>[] parameterTypes_fly = {headfirst.strategy.FlyBehavior.class};
		try {
			headfirst.strategy.eat.Duck.class.getDeclaredMethod("setFlyBehavior", parameterTypes_fly);
			assertTrue(true);
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchMethodException e) {
			fail();
		}

		Class<?>[] parameterTypes_quack = {headfirst.strategy.QuackBehavior.class};
		try {
			headfirst.strategy.eat.Duck.class.getDeclaredMethod("setQuackBehavior", parameterTypes_quack);
			assertTrue(true);
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchMethodException e) {
			fail();
		}
		
		Class<?>[] parameterTypes_walk = {headfirst.strategy.eat.EatBehavior.class};
		try {
			headfirst.strategy.eat.Duck.class.getDeclaredMethod("setEatBehavior", parameterTypes_walk);
			assertTrue(true);
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchMethodException e) {
			fail();
		}

		Method[] obj_methods = headfirst.strategy.eat.Duck.class.getDeclaredMethods();
		assertThat(obj_methods.length,is(8));
	}
	
}
