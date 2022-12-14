package lesson11.test4;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TATest{

	@Test
	public void クラス実装検査01() {
		try {
			Class.forName("lesson11.exam4.TA");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void クラス依存関係検査01() {
		assertEquals("lesson11.exam4.ClassMember", lesson11.exam4.TA.class.getSuperclass().getName());
	}
	
	@Test
	public void メソッド実装検査01() {
		try {
			lesson11.exam4.MessageOperator mo = new lesson11.exam4.MessageOperator();
			lesson11.exam4.TA ta = new lesson11.exam4.TA("test", mo );
			assertThat("test", is(ta.getName()));
		} catch (SecurityException e) {
			fail();
		} catch (IllegalArgumentException e) {
			fail();	
		}
	}
		
}
