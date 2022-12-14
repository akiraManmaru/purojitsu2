package exam2;

import lesson02.exam1_2.Coffee;
import lesson02.exam1_2.Tea;
import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import junit.framework.JUnit4TestAdapter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * main()の実行検査
 */
public class Exam2TestDriveBlackBoxTest {
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
	public void メソッド実装検査01() throws SecurityException, NoSuchMethodException {

        // Expected
//		_out.println("");
		_out.println("\n紅茶を作ります...");
		_out.println("お湯を沸かします");
		_out.println("ティーバックを浸します");
		_out.println("カップに注ぎます");
		_out.println("レモンを入れます");
		_out.println("\nコーヒーを作ります...");
		_out.println("お湯を沸かします");
		_out.println("フィルタでコーヒーをドリップします");
		_out.println("カップに注ぎます");
		_out.println("砂糖とミルクを追加します");
		_out.flush();

        // Actual
		Tea tea = new Tea();
		Coffee coffee = new Coffee();

		System.out.println("\n紅茶を作ります...");
		tea.prepareRecipe();

		System.out.println("\nコーヒーを作ります...");
		coffee.prepareRecipe();

		System.out.flush();

        // Compare
        assertEquals(_expected.toString(), _actual.toString());
	}


    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(Exam2TestDriveBlackBoxTest.class);
    }
}