package exam5;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.JUnit4TestAdapter;
import lesson02.exam4.ICondiment;
import lesson02.exam4.Milk;
import lesson02.exam4.NoMilk;
import lesson02.exam5.CondimentArrayList;

/**
 * main()の実行検査
 */
public class Exam5TestDriveBlackBoxTest {
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
		_out.println("ミルクを追加します");
		_out.println("ミルクを追加します");
		_out.println("何も足しません．出来上がりです");
		_out.flush();

        // Actual
		CondimentArrayList condimentArray = new CondimentArrayList();

		ICondiment condiment = new Milk();
		condimentArray.add(condiment);
		condiment = new Milk();
		condimentArray.add(condiment);
		condiment = new NoMilk();
		condimentArray.add(condiment);
		condimentArray.putCondiments();

		System.out.flush();

        // Compare
        assertEquals(_expected.toString(), _actual.toString());
	}


    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(Exam5TestDriveBlackBoxTest.class);
    }
}