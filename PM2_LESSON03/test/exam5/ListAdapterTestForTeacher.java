package exam5;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * ListAdapterクラスのテスト
 */
public class ListAdapterTestForTeacher{

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
			Class.forName("lesson03.exam5.ListAdapter");
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
		int expected = 1;
		int actual = lesson03.exam5.ListAdapter.class.getDeclaredFields().length;
		// assertThat(actual, is(expected));
		assertEquals(actual, expected);

		String[] fields = {"list"};
		for(String field: fields) {
			try {
				Field f = lesson03.exam5.ListAdapter.class.getDeclaredField(field);
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
		Class<?>[] parameterTypes1 = {java.util.List.class};
		try {
			lesson03.exam5.ListAdapter.class.getDeclaredConstructor(parameterTypes1);
			assertTrue(true);
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchMethodException e) {
			fail();
		}
		Constructor<?>[] m = lesson03.exam5.ListAdapter.class.getDeclaredConstructors();
		assertEquals(1, m.length);
	}

	/**
	 * コンストラクタの動作を検査する
	 */
	@Test
	public void コンストラクタ動作検査() {
		java.util.List<String> list = new java.util.LinkedList<String>();
		lesson03.exam5.ListAdapter<String> listAdapter = new lesson03.exam5.ListAdapter<String>(list);
		try {
			Field f = lesson03.exam5.ListAdapter.class.getDeclaredField("list");
			f.setAccessible(true);
			assertEquals(list, f.get(listAdapter));
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

		Class<?>[] parameterTypes = {java.lang.Object.class};
		String[] methods = {"push"};
		for(String method: methods) {
			try {
				lesson03.exam5.ListAdapter.class.getDeclaredMethod(method, parameterTypes);
				assertTrue(true);
			} catch (SecurityException e) {
				fail();
			} catch (NoSuchMethodException e) {
				fail();
			}
		}

		Class<?>[] parameterTypes2 = {};
		String[] methods2 = {"pop", "clear"};
		for(String method: methods2) {
			try {
				lesson03.exam5.ListAdapter.class.getDeclaredMethod(method, parameterTypes2);
				assertTrue(true);
			} catch (SecurityException e) {
				fail();
			} catch (NoSuchMethodException e) {
				fail();
			}
		}

		try {   //　戻り値の型とアクセス修飾子のチェック
			for (Method m : lesson03.exam5.ListAdapter.class.getDeclaredMethods()) {
				System.out.println(m.getName());
				if(m.getName().equals("push") || m.getName().equals("clear"))
					assertEquals(void.class, m.getReturnType());
				else
					assertEquals(java.lang.Object.class, m.getReturnType());
				assertEquals(true, Modifier.isPublic(m.getModifiers()));
			}
		} catch (SecurityException e) {
			fail();
		}

		Method[] obj_methods = lesson03.exam5.ListAdapter.class.getDeclaredMethods();
		assertEquals(3, obj_methods.length);

	}

	/**
	 * メソッドpush()の動作を検査する
	 */
	@Test
	public void メソッド動作検査１() {

		ArrayList<String> list = new ArrayList<String>();
		lesson03.exam5.ListAdapter<String> listAdapter = new lesson03.exam5.ListAdapter<String>(list);

		String[] inp = {"ハロー", "ハロー2"};
		for (String data: inp) {
			listAdapter.push(data);
		}
		for (String data: inp) {
			list.contains(data);
			assertTrue(true);
		}

		int expected = inp.length;
		int actualSize = list.size();
		assertEquals(expected, actualSize);

	}

	/**
	 * メソッドpop()の動作を検査する
	 */
	@Test
	public void メソッド動作検査2() {

		ArrayList<String> list = new ArrayList<String>();
		lesson03.exam5.ListAdapter<String> listAdapter = new lesson03.exam5.ListAdapter<String>(list);

		String[] inp = {"ハロー", "ハロー2"};
		for (String data: inp) {
			listAdapter.push(data);
		}

		for(int i = 0; i < inp.length; i++) {
			String expectedStr = inp[inp.length-1-i];
			String actualStr = listAdapter.pop();
			assertEquals(expectedStr, actualStr);

			int expected = inp.length - 1 - i;
			int actualSize = list.size();
			assertEquals(expected, actualSize);
		}

		assertEquals(null, listAdapter.pop());

	}

	/**
	 * メソッドclear()の動作を検査する
	 */
	@Test
	public void メソッド動作検査3() {

		ArrayList<String> list = new ArrayList<String>();
		lesson03.exam5.ListAdapter<String> listAdapter = new lesson03.exam5.ListAdapter<String>(list);

		String[] inp = {"ハロー", "ハロー2"};
		for (String data: inp) {
			listAdapter.push(data);
		}
		listAdapter.clear();

		int expected = 0;
		int actualSize = list.size();
		assertEquals(expected, actualSize);

	}

}
