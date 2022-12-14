package lesson12.test5;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import lesson12.exam5.distsensor.*;
import lesson12.exam5.selfdrivingtruck.*;

public class StatePatternTest {

	@Test
	/**
	 * 課題で提示されたクラスが実装されているかどうかの検査
	 */
	public void ConcreteStateクラス実装検査01() {
		try {
			Class.forName("lesson12.exam5.selfdrivingtruck.FastMoving");
			Class.forName("lesson12.exam5.selfdrivingtruck.SlowMoving");
			Class.forName("lesson12.exam5.selfdrivingtruck.Stopping");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	/**
	 * Stateインタフェースに関する依存関係検査
	 */
	public void Stateパターン依存関係検査01() {
		// State はインタフェースであること
		assertTrue(State.class.isInterface());
		// それぞれの状態を表すクラスは State インタフェースの実装であること
		DistSensor distSensor = new DistSensor();
		SelfDrivingTruck rbt = new SelfDrivingTruck(distSensor);
		State subclass = new FastMoving(rbt);
		assertEquals("interface lesson12.exam5.selfdrivingtruck.State", subclass.getClass().getInterfaces()[0].toString());
		subclass = new SlowMoving(rbt);
		assertEquals("interface lesson12.exam5.selfdrivingtruck.State", subclass.getClass().getInterfaces()[0].toString());
		subclass = new Stopping(rbt);
		assertEquals("interface lesson12.exam5.selfdrivingtruck.State", subclass.getClass().getInterfaces()[0].toString());
	}	

	/**
	 * 各クラスで提示されたメソッドが実装されているかどうかの検査
	 */	
	@Test
	/**
	 * 「高速移動中」クラスのメソッド
	 */
	public void 高速移動中クラスメソッド実装検査01() throws SecurityException, NoSuchMethodException {
		List<String> methods = new ArrayList<String>();
		methods.add("updateDistance");

		for(Method m : FastMoving.class.getDeclaredMethods()) {
			assertTrue(methods.contains(m.getName()));
			methods.remove(m.getName());
			assertTrue(Modifier.isPublic(m.getModifiers()));
		}

		int expected = 0;
		int actual = methods.size();
		assertEquals(expected, actual);
	}
	@Test
	/**
	 * 「低速移動中」クラスのメソッド
	 */
	public void 低速移動中クラスメソッド実装検査01() throws SecurityException, NoSuchMethodException {
		List<String> methods = new ArrayList<String>();
		methods.add("updateDistance");

		for(Method m : SlowMoving.class.getDeclaredMethods()) {
			assertTrue(methods.contains(m.getName()));
			methods.remove(m.getName());
			assertTrue(Modifier.isPublic(m.getModifiers()));
		}

		int expected = 0;
		int actual = methods.size();
		assertEquals(expected, actual);
	}
	@Test
	/**
	 * 「停止中」クラスのメソッド
	 */
	public void 停止中クラスメソッド実装検査01() throws SecurityException, NoSuchMethodException {
		List<String> methods = new ArrayList<String>();
		methods.add("updateDistance");

		for(Method m : Stopping.class.getDeclaredMethods()) {
			assertTrue(methods.contains(m.getName()));
			methods.remove(m.getName());
			assertTrue(Modifier.isPublic(m.getModifiers()));
		}

		int expected = 0;
		int actual = methods.size();
		assertEquals(expected, actual);
	}
}