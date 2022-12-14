
package lesson11.test4;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.JUnit4TestAdapter;
import lesson11.exam4.Lecturer;
import lesson11.exam4.MessageOperator;
import lesson11.exam4.Student;
import lesson11.exam4.TA;

public class MessageOperatorTest{

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
	public void メソッド実装検査01() {
		List<String> methods = new ArrayList<String>();
		methods.add("processMessage");
		methods.add("processReport");
		methods.add("addMember");
		methods.add("makeMessageStr");
		methods.add("deleteMember");

		for(Method m : lesson11.exam4.MessageOperator.class.getDeclaredMethods()) {
			assertTrue(methods.contains(m.getName()));
			methods.remove(m.getName());
		}

		int expected = 0;
		int actual = methods.size();
		assertThat(expected, is(actual));
	}

	@Test
	public void メソッド型検査01() {
		Method f;
		@SuppressWarnings("rawtypes")
		Class[] ClassArray = {String.class, lesson11.exam4.ClassMember.class};
		try {
			f = lesson11.exam4.MessageOperator.class.getDeclaredMethod("processMessage", ClassArray);
			assertEquals(void.class, f.getReturnType());
			f = lesson11.exam4.MessageOperator.class.getDeclaredMethod("processReport", ClassArray);
			assertEquals(void.class, f.getReturnType());
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchMethodException e) {
			fail();
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	@SuppressWarnings("unused")
	@Test
	public void メソッド実装検査02() {
        // Expected
		_out.println("テスト１回目：");
		_out.println("スミス講師が受信: [ 送信元: スミス講師, メッセージ: みなさんこんにちは．スミスです．このメッセージが読めますか？ ]");
		_out.println("ジョンソン講師が受信: [ 送信元: スミス講師, メッセージ: みなさんこんにちは．スミスです．このメッセージが読めますか？ ]");
		_out.println("イザベルTAが受信: [ 送信元: スミス講師, メッセージ: みなさんこんにちは．スミスです．このメッセージが読めますか？ ]");
		_out.println("エマTAが受信: [ 送信元: スミス講師, メッセージ: みなさんこんにちは．スミスです．このメッセージが読めますか？ ]");
		_out.println("クロエTAが受信: [ 送信元: スミス講師, メッセージ: みなさんこんにちは．スミスです．このメッセージが読めますか？ ]");
		_out.println("マイケルが受信: [ 送信元: スミス講師, メッセージ: みなさんこんにちは．スミスです．このメッセージが読めますか？ ]");
		_out.println("ウィリアムが受信: [ 送信元: スミス講師, メッセージ: みなさんこんにちは．スミスです．このメッセージが読めますか？ ]");
		_out.println("ダニエルが受信: [ 送信元: スミス講師, メッセージ: みなさんこんにちは．スミスです．このメッセージが読めますか？ ]");
		_out.println("テスト２回目：");
		_out.println("ウィリアムが受信: [ 送信元: システム, メッセージ: あなたはお知らせを送信できません ]");
		_out.println("テスト３回目：");
		_out.println("スミス講師が受信: [ 送信元: 25-003, メッセージ: ダニエルです．レポートを提出します．よろしくお願いします． ]");
		_out.println("ジョンソン講師が受信: [ 送信元: 25-003, メッセージ: ダニエルです．レポートを提出します．よろしくお願いします． ]");
		_out.println("イザベルTAが受信: [ 送信元: 25-003, メッセージ: ダニエルです．レポートを提出します．よろしくお願いします． ]");
		_out.println("エマTAが受信: [ 送信元: 25-003, メッセージ: ダニエルです．レポートを提出します．よろしくお願いします． ]");
		_out.println("クロエTAが受信: [ 送信元: 25-003, メッセージ: ダニエルです．レポートを提出します．よろしくお願いします． ]");
		_out.println("ダニエルが受信: [ 送信元: システム, メッセージ: あなたのレポートは正しく送信できました ]");
		_out.println("テスト４回目：");
		_out.println("クロエTAが受信: [ 送信元: システム, メッセージ: あなたはお知らせを送信できません ]");
		_out.flush();

        // Actual
		MessageOperator operator = new MessageOperator();

		Lecturer smith = new Lecturer("スミス講師", operator);
		Lecturer johnson = new Lecturer("ジョンソン講師", operator);
		TA isabel = new TA("イザベルTA", operator);
		TA emma = new TA("エマTA", operator);
		TA chloe = new TA("クロエTA", operator);
		Student michael = new Student("マイケル", operator,"25-001");
		Student william = new Student("ウィリアム", operator,"25-002");
		Student daniel = new Student("ダニエル", operator,"25-003");

		System.out.println("テスト１回目：");
		smith.sendMessage("みなさんこんにちは．スミスです．このメッセージが読めますか？");
		System.out.println("テスト２回目：");
		william.sendMessage("みなさんこんにちは．ウィリアムです．よろしくお願いします．");
		System.out.println("テスト３回目：");
		daniel.submitReport("ダニエルです．レポートを提出します．よろしくお願いします．");
		System.out.println("テスト４回目：");
		chloe.sendMessage("みなさんこんにちは．TAのクロエです．頑張ってください．");

        System.out.flush();

        // Compare
        assertEquals(_expected.toString(), _actual.toString());
    }

    public static junit.framework.Test suite() {
       return new JUnit4TestAdapter(MessageOperatorTest.class);
   }

}
