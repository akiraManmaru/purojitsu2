package exam4;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * DomesticatedDuckクラスのテスト
 */
public class MiniDuckSimularot1Test{
    private ByteArrayOutputStream _actual;
    private ByteArrayOutputStream _expected;
    private PrintStream _out;

	@Before
	public void setUp() {
        _actual = new ByteArrayOutputStream();
        _expected = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(_actual)));
        _out = new PrintStream(new BufferedOutputStream(_expected));
	}

	@After
	public void tearDown() {
		System.setOut(null);
	}

	/**
	 * クラスが存在するか検査する
	 */
	@Test(timeout=500)
	public void クラス実装検査() {
		try {
			Class.forName("headfirst.strategy.eat.MiniDuckSimulator1");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			fail();
		}
	}
	
	/**
	 * 指定されたメソッドのみが存在するか検査する
	 */
	@Test(timeout=100)
	public void メソッド実装検査() {
		Class<?>[] parameterTypes1 = {String[].class};
		try {
			headfirst.strategy.eat.MiniDuckSimulator1.class.getDeclaredMethod("main", parameterTypes1);
			assertTrue(true);
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchMethodException e) {
			fail();
		}

		Method[] methods = headfirst.strategy.eat.MiniDuckSimulator1.class.getDeclaredMethods();
		assertThat(methods.length,is(1));
	}

	/**
	 * メソッドmain()の動作を検査する
	 */
	@Test(timeout=500)
	public void メソッド動作検査２() {
		// Expected
		_out.println("本物のアメリカホシハジロです");
		_out.println("ガーガー");
		_out.println("飛んでいます！！");
		_out.println("食べています！！");
		_out.println("カモなら、たとえおとりでも泳ぎます");
		_out.println("ゴムのアヒルです");
		_out.println("キューキュー");
		_out.println("飛べません");
		_out.println("食べられません");
		_out.println("カモなら、たとえおとりでも泳ぎます");
		_out.println("模型の鴨です");
		_out.println("ガーガー");
		_out.println("飛べません");
		_out.println("ロケットで飛んでいます！");
		_out.println("食べられません");
		_out.println("カモなら、たとえおとりでも泳ぎます");
		_out.flush();

		// Actual
		String[] args = {};
		headfirst.strategy.eat.MiniDuckSimulator1.main(args);
		System.out.flush();

		// Compare
		assertThat(_actual.toString(),is(_expected.toString()));

	}
}
