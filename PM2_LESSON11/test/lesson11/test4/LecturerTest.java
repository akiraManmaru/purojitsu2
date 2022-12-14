package lesson11.test4;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class LecturerTest{

	@Test
	public void クラス実装検査01() {
		try {
			Class.forName("lesson11.exam4.Lecturer");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void クラス依存関係検査01() {
		assertEquals("lesson11.exam4.ClassMember", lesson11.exam4.Lecturer.class.getSuperclass().getName());
	}
	
	@Test
	public void メソッド実装検査01() {
		try {
			lesson11.exam4.MessageOperator mo = new lesson11.exam4.MessageOperator();
			lesson11.exam4.Lecturer t = new lesson11.exam4.Lecturer("test", mo );
			assertThat("test", is(t.getName()));
		} catch (SecurityException e) {
			fail();
		} catch (IllegalArgumentException e) {
			fail();	
		}
	}
		
}
