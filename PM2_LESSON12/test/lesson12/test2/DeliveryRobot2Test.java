package lesson12.test2;

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

import lesson12.exam2.*;

/**
 * 配送ロボットクラスのテスト
 * @author habe
 *
 */

public class DeliveryRobot2Test {
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
	public void 配送ロボットクラスメソッド存在検査() {
		List<String> methods = new ArrayList<String>();
		methods.add("detectCollapse");
		methods.add("getDelivering");
		methods.add("getEmergencyStop");
		methods.add("getState");
		methods.add("getWaiting");
		methods.add("voiceCommand");
		methods.add("resetCommand");
		methods.add("setState");

		for(Method m : DeliveryRobot2.class.getDeclaredMethods()) {
			assertTrue(methods.contains(m.getName()));
			methods.remove(m.getName());
		}

		int expected = 0;
		int actual = methods.size();
		assertEquals(expected, actual);
	}

	@Test
	public void 配送ロボットクラスフィールド存在検査() {
		List<String> fields = new ArrayList<String>();
		fields.add("delivering");
		fields.add("emergencyStop");
		fields.add("state");
		fields.add("waiting");

		for(Field f : DeliveryRobot2.class.getDeclaredFields()) {
			assertTrue(fields.contains(f.getName()));
			fields.remove(f.getName());
		}

		int expected = 0;
		int actual = fields.size();
		assertEquals(expected, actual);
	}
}

