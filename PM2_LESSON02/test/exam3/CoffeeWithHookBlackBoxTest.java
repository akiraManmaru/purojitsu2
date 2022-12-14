package exam3;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * CoffeeWithHookクラスのテスト
 */
public class CoffeeWithHookBlackBoxTest{
	private PipedOutputStream pipOut;
	private PrintStream printOut;
	private InputStream in;

	@Before
	public void setUp() {
		pipOut = new PipedOutputStream();
		printOut = new PrintStream(pipOut);
		System.setOut(printOut);
		in = System.in;
	}

	@After
	public void tearDown() {
		System.setOut(null);
		try {
			printOut.close();
			pipOut.close();
			System.setIn(in);
		} catch (IOException e) {
		}
	}


	/**
	 * メソッドbrew()の動作を検査する
	 */
	@Test
	public void メソッド動作検査１() {
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			lesson02.exam3.CoffeeWithHook coffee = new lesson02.exam3.CoffeeWithHook();
			coffee.brew();
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("フィルタでコーヒーをドリップします", output);
	}

	/**
	 * メソッドputCondiments()の動作を検査する
	 */
	@Test
	public void メソッド動作検査2() {
		String output = "";

		try {
			PipedInputStream pipIn = new PipedInputStream(pipOut);
			BufferedReader reader  = new BufferedReader(new InputStreamReader(pipIn));

			lesson02.exam3.CoffeeWithHook coffee = new lesson02.exam3.CoffeeWithHook();
			coffee.putCondiments();
			output = reader.readLine();

			reader.close();
			pipIn.close();
		} catch (IOException e) {
			fail("Stream Error.");
		}
		assertEquals("砂糖とミルクを追加します", output);
	}


	/**
	 * メソッドcustomerWantsCondiments()の動作を検査する　Yesの場合
	 */
	@Test
	public void メソッド動作検査3() {

		byte[] input = ("Yes\n").getBytes();
		System.setIn(new ByteArrayInputStream(input));

		lesson02.exam3.CoffeeWithHook coffee = new lesson02.exam3.CoffeeWithHook();
		boolean ret = coffee.customerWantsCondiments();
		assertEquals(true, ret);
	}


	/**
	 * メソッドcustomerWantsCondiments()の動作を検査する（Noの場合）
	 */
	@Test
	public void メソッド動作検査4() {

		byte[] input = ("No\n").getBytes();
		System.setIn(new ByteArrayInputStream(input));

		lesson02.exam3.CoffeeWithHook coffee = new lesson02.exam3.CoffeeWithHook();
		boolean ret = coffee.customerWantsCondiments();
		assertEquals(false, ret);
	}

}
