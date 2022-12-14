package lesson11.test1;

import static org.junit.Assert.assertEquals;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import lesson11.exam1.Lecturer;
import lesson11.exam1.Student;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MessageRuleTest{
	
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

	@SuppressWarnings("unused")
	@Test
	public void メッセージ配送規則検査01() {
        // Expected
		_out.println("テスト１回目：");
		_out.println("スミス講師が受信: [ 送信元: スミス講師, メッセージ: みなさんこんにちは．スミスです．このメッセージが読めますか？ ]");
		_out.println("ジョンソン講師が受信: [ 送信元: スミス講師, メッセージ: みなさんこんにちは．スミスです．このメッセージが読めますか？ ]");
     	_out.println("マイケルが受信: [ 送信元: スミス講師, メッセージ: みなさんこんにちは．スミスです．このメッセージが読めますか？ ]");
		_out.println("ウィリアムが受信: [ 送信元: スミス講師, メッセージ: みなさんこんにちは．スミスです．このメッセージが読めますか？ ]");
		_out.println("ダニエルが受信: [ 送信元: スミス講師, メッセージ: みなさんこんにちは．スミスです．このメッセージが読めますか？ ]");
		_out.println("テスト２回目：");
		_out.println("スミス講師が受信: [ 送信元: ウィリアム, メッセージ: みなさんこんにちは．ウィリアムです．よろしくお願いします． ]");
		_out.println("ジョンソン講師が受信: [ 送信元: ウィリアム, メッセージ: みなさんこんにちは．ウィリアムです．よろしくお願いします． ]");
		_out.println("マイケルが受信: [ 送信元: ウィリアム, メッセージ: みなさんこんにちは．ウィリアムです．よろしくお願いします． ]");
		_out.println("ウィリアムが受信: [ 送信元: ウィリアム, メッセージ: みなさんこんにちは．ウィリアムです．よろしくお願いします． ]");
		_out.println("ダニエルが受信: [ 送信元: ウィリアム, メッセージ: みなさんこんにちは．ウィリアムです．よろしくお願いします． ]");
		_out.println("テスト３回目：");
		_out.println("スミス講師が受信: [ 送信元: ダニエル, メッセージ: ダニエルです．レポートを提出します．よろしくお願いします． ]");
		_out.println("ジョンソン講師が受信: [ 送信元: ダニエル, メッセージ: ダニエルです．レポートを提出します．よろしくお願いします． ]");
		_out.flush();
		
        // Actual
		Lecturer smith = new Lecturer("スミス講師");
		Lecturer johnson = new Lecturer("ジョンソン講師");
		Student michael = new Student("マイケル");
		Student william = new Student("ウィリアム");
		Student daniel = new Student("ダニエル");
				
		System.out.println("テスト１回目：");
		smith.sendMessage("みなさんこんにちは．スミスです．このメッセージが読めますか？");
		System.out.println("テスト２回目：");
		william.sendMessage("みなさんこんにちは．ウィリアムです．よろしくお願いします．");		
		System.out.println("テスト３回目：");
		daniel.submitReport("ダニエルです．レポートを提出します．よろしくお願いします．");		
        System.out.flush();

        // Compare
        assertEquals(_expected.toString(), _actual.toString());
    }

	
}
