package lesson12.test1;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.JUnit4TestAdapter;
import lesson12.exam1.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 状態遷移の実行検査
 */
public class StateModelTest {

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
		_out.println("荷崩れが起きたので緊急停止します[->EmergencyStop]");
		_out.println("リセットしました[->Waiting]");
		_out.println("=== 「待ち」状態からのチェック ===");
		_out.println("（その操作は無効です）");
		_out.println("（その操作は無効です）");
		_out.println("配送を開始しました[->Delivering]");
		_out.println("=== 「配送中」状態からのチェック ===");
		_out.println("（その操作は無効です）");
		_out.println("荷崩れが起きたので緊急停止します[->EmergencyStop]");
		_out.println("=== 「緊急停止」状態からのチェック ===");
		_out.println("（その操作は無効です）");
		_out.println("（その操作は無効です）");
		_out.println("リセットしました[->Waiting]");
		_out.flush();

		// Actual
		DeliveryRobot1 rc = new DeliveryRobot1();
		/*
		 * 状態遷移の網羅チェック
		 */
		System.out.println("=== 配送開始 ===");
		rc.voiceCommand(); // 1回目開始
		rc.voiceCommand();
		rc.voiceCommand(); // 2回目開始
		rc.detectCollapse();
		rc.resetCommand();
		/*
		 * それぞれの状態で受け付けない操作のチェック
		 */
		/*
		 * 「待ち」状態から
		 */
		System.out.println("=== 「待ち」状態からのチェック ===");
		rc.resetCommand();
		rc.detectCollapse();
		rc.voiceCommand();
		/*
		 * 「配送中」状態から
		 */
		System.out.println("=== 「配送中」状態からのチェック ===");
		rc.resetCommand();
		rc.detectCollapse();
		/*
		 * 「緊急停止」状態から
		 */
		System.out.println("=== 「緊急停止」状態からのチェック ===");
		rc.voiceCommand();
		rc.detectCollapse();
		rc.resetCommand();
		
		System.out.flush();

		// Compare
		assertEquals(_expected.toString(), _actual.toString());
	}

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(StateModelTest.class);
	}
}
