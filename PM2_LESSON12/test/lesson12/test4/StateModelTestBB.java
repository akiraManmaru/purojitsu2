package lesson12.test4;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.JUnit4TestAdapter;
import lesson12.exam4.*;

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
		_out.println("=== 配送開始 ===");
		_out.println("配送を開始しました[->Delivering]");
		_out.println("配送を終了しました[->Waiting]");
		_out.println("配送を開始しました[->Delivering]");
		_out.println("緊急車両を検知したので緊急停止します[->EmergencyStop]");
		_out.println("リセットしました[->Waiting]");
		_out.println("配送を開始しました[->Delivering]");
		_out.println("荷崩れが起きたので自動積み直しを行い配送を続けます");
		_out.println("迅速配送の要請が発生したので迅速に配送します[->PrimeDelivering]");
		_out.println("荷崩れが起きたので自動積み直しを行い配送を続けます");
		_out.println("配送を終了しました[->Waiting]");
		_out.println("配送を開始しました[->Delivering]");
		_out.println("迅速配送の要請が発生したので迅速に配送します[->PrimeDelivering]");
		_out.println("緊急車両を検知したので緊急停止します[->EmergencyStop]");
		_out.println("リセットしました[->Waiting]");
		_out.println("=== 「待ち」状態からのチェック ===");
		_out.println("（その操作は無効です）");
		_out.println("（その操作は無効です）");
		_out.println("（その操作は無効です）");
		_out.println("（その操作は無効です）");
		_out.println("配送を開始しました[->Delivering]");
		_out.println("=== 「配送中」状態からのチェック ===");
		_out.println("（その操作は無効です）");
		_out.println("緊急車両を検知したので緊急停止します[->EmergencyStop]");
		_out.println("=== 「緊急停止」状態からのチェック ===");
		_out.println("（その操作は無効です）");
		_out.println("（その操作は無効です）");
		_out.println("（その操作は無効です）");
		_out.println("（その操作は無効です）");
		_out.println("リセットしました[->Waiting]");
		_out.println("配送を開始しました[->Delivering]");
		_out.println("迅速配送の要請が発生したので迅速に配送します[->PrimeDelivering]");
		_out.println("=== 「迅速配送中」状態からのチェック ===");
		_out.println("（その操作は無効です）");
		_out.println("（その操作は無効です）");
		_out.println("配送を終了しました[->Waiting]");
		_out.flush();

		// Actual
		DeliveryRobot4 rc = new DeliveryRobot4();
		/*
		 * 状態遷移の網羅チェック
		 */
		System.out.println("=== 配送開始 ===");
		rc.voiceCommand(); // 1回目開始
		rc.voiceCommand();
		rc.voiceCommand(); // 2回目開始
		rc.detectEmergencyVehicle();
		rc.resetCommand();
		rc.voiceCommand(); // 3回目開始
		rc.detectCollapse();
		rc.detectPrime();
		rc.detectCollapse();
		rc.voiceCommand();
		rc.voiceCommand(); // 4回目開始
		rc.detectPrime();
		rc.detectEmergencyVehicle();;
		rc.resetCommand();
		/*
		 * それぞれの状態で受け付けない操作のチェック
		 */
		/*
		 * 「待ち」状態から
		 */
		System.out.println("=== 「待ち」状態からのチェック ===");
		rc.resetCommand();
		rc.detectEmergencyVehicle();
		rc.detectCollapse();
		rc.detectPrime();
		rc.voiceCommand();
		/*
		 * 「配送中」状態から
		 */
		System.out.println("=== 「配送中」状態からのチェック ===");
		rc.resetCommand();
		rc.detectEmergencyVehicle();
		/*
		 * 「緊急停止」状態から
		 */
		System.out.println("=== 「緊急停止」状態からのチェック ===");
		rc.voiceCommand();
		rc.detectEmergencyVehicle();
		rc.detectCollapse();
		rc.detectPrime();
		rc.resetCommand();
		rc.voiceCommand();
		rc.detectPrime();
		/*
		 * 「迅速配送中」状態から
		 */
		System.out.println("=== 「迅速配送中」状態からのチェック ===");
		rc.detectPrime();
		rc.resetCommand();
		rc.voiceCommand();		
		System.out.flush();

		// Compare
		assertEquals(_expected.toString(), _actual.toString());

	}

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(StateModelTestBB.class);
	}
}
