package lesson12.test5;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.JUnit4TestAdapter;
import lesson12.exam5.distsensor.DistSensor;
import lesson12.exam5.selfdrivingtruck.SelfDrivingTruck;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * 状態遷移の実行検査
 */
public class StateModelTestBB {

	private PrintStream _saved;
	private ByteArrayOutputStream _actual;
	private ByteArrayOutputStream _expected;
	private PrintStream _out;

	@Before public void setUp() {
		_saved = System.out;
		_actual = new ByteArrayOutputStream();
		_expected = new ByteArrayOutputStream();
		System.setOut(new PrintStream(new BufferedOutputStream(_actual)));
		_out = new PrintStream(new BufferedOutputStream(_expected));
	}

	@After public void tearDown() {
		System.setOut(_saved);
	}

	@Test
	public void 状態遷移実装検査01() throws SecurityException, NoSuchMethodException {

		// Expected
		_out.println("現在の距離は0.0です。");
		_out.println("そのままです");
		_out.println("現在の距離は14.9です。");
		_out.println("そのままです");
		_out.println("現在の距離は15.0です。");
		_out.println("ゆっくり動きます[->SlowMoving]");
		_out.println("現在の距離は5.0です。");
		_out.println("そのままです");
		_out.println("現在の距離は4.9です。");
		_out.println("停止します[->Stopping]");
		_out.println("現在の距離は15.0です。");
		_out.println("ゆっくり動きます[->SlowMoving]");
		_out.println("現在の距離は54.8です。");
		_out.println("そのままです");
		_out.println("現在の距離は55.0です。");
		_out.println("速く動きます[->FastMoving]");
		_out.println("現在の距離は65.0です。");
		_out.println("そのままです");
		_out.println("現在の距離は35.0です。");
		_out.println("そのままです");
		_out.println("現在の距離は34.9です。");
		_out.println("ゆっくり動きます[->SlowMoving]");
		_out.println("現在の距離は3.0です。");
		_out.println("停止します[->Stopping]");
		_out.flush();

		// Actual
		
		// 距離センサー
		DistSensor distSensor = new DistSensor();
		// ロボット
		SelfDrivingTruck rbt = new SelfDrivingTruck(distSensor);
		
		rbt.update(0.0f);
		rbt.update(14.9f);
		rbt.update(15.0f);
		rbt.update(5.0f);
		rbt.update(4.9f);
		rbt.update(15.0f);
		rbt.update(54.8f);
		rbt.update(55.0f);
		rbt.update(65.0f);
		rbt.update(35.0f);
		rbt.update(34.9f);
		rbt.update(3.0f);
		System.out.flush();

		// Compare
		assertEquals(_expected.toString(), _actual.toString());

	}

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(StateModelTestBB.class);
	}
}
