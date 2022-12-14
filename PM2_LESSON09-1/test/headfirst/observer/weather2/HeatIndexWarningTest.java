package headfirst.observer.weather2;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HeatIndexWarningTest {
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

	@Test
	public void クラスHeatIndexWarningが存在する() {
		try {
			Class.forName("headfirst.observer.weather2.HeatIndexWarning");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void クラス継承検査() {
		assertEquals("headfirst.observer.weather2.HeatIndexDisplay", HeatIndexWarning.class.getSuperclass().getName());
	}

	// 次のテストは現在使われていません。
	/*
	@Test
	public void クラスHeatIndexWarningがObserverとDisplayElementを実装している() {
		List<Class<?>> expects = new ArrayList<Class<?>>();
		expects.add(Observer.class);
		expects.add(DisplayElement.class);

		Class<?>[] interfaces = HeatIndexWarning.class.getInterfaces();
		for(Class<?> cls : interfaces) {
			assertTrue(expects.contains(cls));
			expects.remove(cls);
		}

		int expected = 0;
		int actual = expects.size();
		assertThat(actual, is(expected));
	}
	 */

	@Test
	public void クラスHeatIndexWarningのコンストラクタでObserverを登録している() {
		Field f = null;
		try {
			f = WeatherData.class.getDeclaredField("observers");
			f.setAccessible(true);
			WeatherData wd = new WeatherData();
			HeatIndexWarning hwd = new HeatIndexWarning(wd);
			@SuppressWarnings("unchecked")
			ArrayList<Observer> list = (ArrayList<Observer>) f.get(wd);
			assertTrue(list.contains(hwd));
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchFieldException e) {
			fail();
		} catch (IllegalArgumentException e) {
			fail();
		} catch (IllegalAccessException e) {
			fail();
		}
	}

	@Test
	public void クラスHeatIndexWarningのメソッド名は英数字以外を含まない() {
		//このテストが不合格になる場合、資料ZeroWidthSpace.pdfの「見分け方」を見て、
		//カーソルキーでゼロ幅スペースを探して削除するとテストを通ります。
		for(Method m : HeatIndexWarning.class.getDeclaredMethods()) {
			assertTrue(m.getName().matches("^[0-9a-zA-Z]+$"));
		}
	}
	
	@Test
	public void クラスHeatIndexWarningのメソッドはdisplayのみが存在する() {
		List<String> methods = new ArrayList<String>();
		methods.add("display");

		for(Method m : HeatIndexWarning.class.getDeclaredMethods()) {
			assertTrue(methods.contains(m.getName()));
			methods.remove(m.getName());
		}

		int expected = 0;
		int actual = methods.size();
		assertThat(actual, is(expected));
	}

	@Test
	public void クラスHeatIndexWarningのフィールドはheatIndexThresholdのみが存在する() {
		List<String> fields = new ArrayList<String>();
		fields.add("heatIndexThreshold");

		for(Field f : HeatIndexWarning.class.getDeclaredFields()) {
			assertTrue(fields.contains(f.getName()));
			fields.remove(f.getName());
		}

		int expected = 0;
		int actual = fields.size();
		assertThat(actual, is(expected));
	}

	@Test
	public void クラスHeatIndexWarningのフィールドの型が指定通りである() {
		Field f;
		try {
			f = HeatIndexWarning.class.getDeclaredField("heatIndexThreshold");
			assertEquals(float.class, f.getType());
//			assertTrue(Modifier.isFinal(f.getModifiers()));
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchFieldException e) {
			fail();
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	//
	
	/*
	@Test
	public void クラスHeatIndexWarningのdisplayメソッドにoverrideアノテーションが付いている() {
		Class<Override> anno = Override.class;
		//Class<?>[] parameterTypes1 = {};
        //Field field;
        //Method method;
        Method methodArray[];
        //String methodName;
        
        System.out.println("In JUNIT");

        try {
        
        //methodName = "display";
//        method = HeatIndexWarning.class.getMethod("display");
         methodArray = HeatIndexWarning.class.getDeclaredMethods();
         System.out.println(methodArray[0].toString());
         //for (Method m : methodArray) {
        	// System.out.println(m);
         //}
         assertTrue(methodArray[0].isAnnotationPresent(anno));
	        
			//f = HeatIndexWarning.class.getDeclaredField("heatIndexThreshold");
			//assertEquals(float.class, f.getType());
//			assertTrue(Modifier.isFinal(f.getModifiers()));
		} catch (SecurityException e) {
			fail();
		//} catch (NoSuchFieldException e) {
		//	fail();
		} catch (IllegalArgumentException e) {
			fail();
		}
	}
 	*/
	
}
