package exam4;

import lesson02.exam4.CoffeeStrategy;
import lesson02.exam4.DripBrew;
import lesson02.exam4.EspressoBrew;
import lesson02.exam4.Milk;
import lesson02.exam4.NoMilk;

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
public class Exam4TestDriveBlackBoxTest {
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
		//byte[] input = ("Y\n").getBytes();
		//System.setIn(new ByteArrayInputStream(input));

        // Expected
//		_out.println("");
		_out.println("\nエスプレッソを作ります...");
		_out.println("お湯を沸かします");
		_out.println("エスプレッソマシーンでコーヒーをいれます");
		_out.println("カップに注ぎます");
		_out.println("何も足しません．出来上がりです");
		_out.println("\nカフェラテを作ります...");
		_out.println("お湯を沸かします");
		_out.println("エスプレッソマシーンでコーヒーをいれます");
		_out.println("カップに注ぎます");
		_out.println("ミルクを追加します");
		_out.println("\nカフェオレを作ります...");
		_out.println("お湯を沸かします");
		_out.println("フィルタでコーヒーをドリップします");
		_out.println("カップに注ぎます");
		_out.println("ミルクを追加します");
		_out.println("\nブラックコーヒーを作ります...");
		_out.println("お湯を沸かします");
		_out.println("フィルタでコーヒーをドリップします");
		_out.println("カップに注ぎます");
		_out.println("何も足しません．出来上がりです");
		_out.flush();

        // Actual
		EspressoBrew espressoBrew = new EspressoBrew();
		DripBrew     dripBrew     = new DripBrew();
		NoMilk       noMilk       = new NoMilk();
		Milk         milk         = new Milk();

		CoffeeStrategy espresso = new CoffeeStrategy(espressoBrew, noMilk);
  		System.out.println("\nエスプレッソを作ります...");
		espresso.prepareRecipe();

		CoffeeStrategy caffeLatte = new CoffeeStrategy(espressoBrew, milk);
		System.out.println("\nカフェラテを作ります...");
		caffeLatte.prepareRecipe();

		CoffeeStrategy cafeAuLait = new CoffeeStrategy(dripBrew, milk);
		System.out.println("\nカフェオレを作ります...");
		cafeAuLait.prepareRecipe();

		CoffeeStrategy black = new CoffeeStrategy(dripBrew, noMilk);
		System.out.println("\nブラックコーヒーを作ります...");
		black.prepareRecipe();

		System.out.flush();

        // Compare
        assertEquals(_expected.toString(), _actual.toString());
	}


    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(Exam4TestDriveBlackBoxTest.class);
    }
}