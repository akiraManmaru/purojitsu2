package lesson12.test5;

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

import lesson12.exam5.distsensor.DistSensor;
import lesson12.exam5.selfdrivingtruck.SelfDrivingTruck;

/**
 * 自動運転トラッククラスのテスト
 * @author habe
 *
 */

public class SelfDrivingTruckTest {
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
	 * CurrentDistDisplay クラスを継承しているか
	 */
	@Test
	public void 自動運転トラッククラスの継承検査() {
		assertEquals("lesson12.exam5.distsensor.CurrentDistDisplay", SelfDrivingTruck.class.getSuperclass().getName());
	}
	/**
	 * Observable 登録検査
	 */
	@Test
	public void 自動運転トラッククラスのコンストラクタでObservableを登録している() {
		try {
			DistSensor ds = new DistSensor();
			assertEquals(0, ds.countObservers());
			new SelfDrivingTruck(ds);
			assertEquals(1, ds.countObservers());
		} catch (SecurityException e) {
			fail();
		} catch (IllegalArgumentException e) {
			fail();
		}
	}


	@Test
	public void 自動運転トラッククラスメソッド存在検査() {
		List<String> methods = new ArrayList<String>();
		methods.add("update");
		methods.add("updateDistance");
		methods.add("getFastMoving");
		methods.add("getSlowMoving");
		methods.add("getState");
		methods.add("getStopping");
		methods.add("setState");

		for(Method m : SelfDrivingTruck.class.getDeclaredMethods()) {
			assertTrue(methods.contains(m.getName()));
			methods.remove(m.getName());
		}

		int expected = 0;
		int actual = methods.size();
		assertEquals(expected, actual);
	}

	@Test
	public void 自動運転トラッククラスフィールド存在検査() {
		List<String> fields = new ArrayList<String>();
		fields.add("fastMoving");
		fields.add("slowMoving");
		fields.add("stopping");
		fields.add("state");

		for(Field f : SelfDrivingTruck.class.getDeclaredFields()) {
			assertTrue(fields.contains(f.getName()));
			fields.remove(f.getName());
		}

		int expected = 0;
		int actual = fields.size();
		assertEquals(expected, actual);
	}
}

