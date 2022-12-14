package lesson11.test2;

import static org.junit.Assert.assertEquals;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import lesson11.exam2.Lecturer;
import lesson11.exam2.Student;
import lesson11.exam2.TA;

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
	public void メソッド実装検査01() {
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
		_out.println("スミス講師が受信: [ 送信元: ダニエル, メッセージ: ダニエルです．レポートを提出します．よろしくお願いします． ]");
		_out.println("ジョンソン講師が受信: [ 送信元: ダニエル, メッセージ: ダニエルです．レポートを提出します．よろしくお願いします． ]");
		_out.println("イザベルTAが受信: [ 送信元: ダニエル, メッセージ: ダニエルです．レポートを提出します．よろしくお願いします． ]");
		_out.println("エマTAが受信: [ 送信元: ダニエル, メッセージ: ダニエルです．レポートを提出します．よろしくお願いします． ]");
		_out.println("クロエTAが受信: [ 送信元: ダニエル, メッセージ: ダニエルです．レポートを提出します．よろしくお願いします． ]");
		_out.println("ダニエルが受信: [ 送信元: システム, メッセージ: あなたのレポートは正しく送信できました ]");
		_out.println("テスト４回目：");
		_out.println("クロエTAが受信: [ 送信元: システム, メッセージ: あなたはお知らせを送信できません ]");
		_out.flush();
		
        // Actual
		Lecturer smith = new Lecturer("スミス講師");
		Lecturer johnson = new Lecturer("ジョンソン講師");
		TA isabel = new TA("イザベルTA");
		TA emma = new TA("エマTA");
		TA chloe = new TA("クロエTA");
		Student michael = new Student("マイケル");
		Student william = new Student("ウィリアム");
		Student daniel = new Student("ダニエル");
				
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

	
}
