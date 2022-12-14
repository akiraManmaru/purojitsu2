package exam3;

import lesson02.exam3.CoffeeWithHook;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
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
public class Exam3TestDriveBlackBoxTest {
    private PrintStream _saved;
    private ByteArrayOutputStream _actual;
    private ByteArrayOutputStream _expected;
    private PrintStream _out;
	private InputStream _in;

    @Before public void setUp() {
        _saved = System.out;
        _actual = new ByteArrayOutputStream();
        _expected = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(_actual)));
        _out = new PrintStream(new BufferedOutputStream(_expected));
//        _out = System.out;
		_in = System.in;
    }

    @After public void tearDown() {
        System.setOut(_saved);
		System.setIn(_in);
    }

	@Test
	public void メソッド実装検査01() throws SecurityException, NoSuchMethodException {
		byte[] input = ("Y\n").getBytes();
		System.setIn(new ByteArrayInputStream(input));

        // Expected
//		_out.println("");
		_out.println("\nコーヒーを作ります...");
		_out.println("お湯を沸かします");
		_out.println("フィルタでコーヒーをドリップします");
		_out.println("カップに注ぎます");
		_out.print("お砂糖とミルクはご利用ですか(y/n)?");
		_out.println("砂糖とミルクを追加します");
		_out.flush();

        // Actual
		CoffeeWithHook coffeeHook = new CoffeeWithHook();

		System.out.println("\nコーヒーを作ります...");
		coffeeHook.prepareRecipe();

		System.out.flush();

        // Compare
        assertEquals(_expected.toString(), _actual.toString());
	}


    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(Exam3TestDriveBlackBoxTest.class);
    }
}