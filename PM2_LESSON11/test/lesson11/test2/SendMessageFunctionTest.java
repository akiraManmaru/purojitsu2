package lesson11.test2;

import static org.junit.Assert.*;

import org.junit.Test;

public class SendMessageFunctionTest{
	
	@Test
	public void クラス実装検査01() {
		try {
			Class.forName("lesson11.exam2.SendMessageFunction");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}
	@Test
	public void クラス実装検査02() {
		try {
			Class.forName("lesson11.exam2.SendMessageFunctionAll");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}
	@Test
	public void クラス実装検査03() {
		try {
			Class.forName("lesson11.exam2.SendMessageFunctionCannot");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}

/*	@Test
	public void クラス依存関係検査01() {
		assertEquals("lesson11.exam2.MakeMessageString", lesson11.exam2.SendMessageFunctionAll.class.getSuperclass().getName());
	}
	@Test
	public void クラス依存関係検査02() {
		assertEquals("lesson11.exam2.MakeMessageString", lesson11.exam2.SendMessageFunctionCannot.class.getSuperclass().getName());
	}
*/
	@Test
	public void クラス依存関係検査03() {
		// sendMessageFunction はインタフェースであること
        assertTrue(lesson11.exam2.SendMessageFunction.class.isInterface());
        // sendMessageFunctionAll は　sendMessageFunction を実装していること
        lesson11.exam2.SendMessageFunctionAll smf1 = new lesson11.exam2.SendMessageFunctionAll();        
        assertEquals("interface lesson11.exam2.SendMessageFunction", smf1.getClass().getInterfaces()[0].toString());
        // sendMessageFunctionCannot は　sendMessageFunction を実装していること
        lesson11.exam2.SendMessageFunctionCannot smf2 = new lesson11.exam2.SendMessageFunctionCannot();        
        assertEquals("interface lesson11.exam2.SendMessageFunction", smf2.getClass().getInterfaces()[0].toString());
	}

	
	// implements の検査がない！
	
}
