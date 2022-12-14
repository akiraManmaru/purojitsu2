package headfirst.observer.errorlevelobserver;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ErrorLevelTest {
	private PipedOutputStream pipOut;
	private PrintStream printOut;

	@Before
	public void setUp() {
		pipOut = new PipedOutputStream();
		printOut = new PrintStream(pipOut);
		System.setOut(printOut);
	}

	@After
	public void tearDown() {
		System.setOut(null);
		try {
			printOut.close();
			pipOut.close();
		} catch (IOException e) {
		}
	}

	@Test
	public void クラスが存在する() {
		try {
			Class.forName("headfirst.observer.errorlevelobserver.ErrorLevel");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void エラーレベル最大値検査() {
		try {
			ErrorLevel el=ErrorLevel.getInstance();
			assertEquals(5, el.getMaxErrorLevel());
		} catch (SecurityException e) {
			fail();
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	@Test
	public void エラーレベル最小値検査() {
		try {
			ErrorLevel el=ErrorLevel.getInstance();
			assertEquals(1, el.getMinErrorLevel());
		} catch (SecurityException e) {
			fail();
		} catch (IllegalArgumentException e) {
			fail();
		}
	}


}

