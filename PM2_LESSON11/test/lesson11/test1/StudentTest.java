package lesson11.test1;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTest{

	@Test
	public void クラス実装検査01() {
		try {
			Class.forName("lesson11.exam1.Student");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void クラス依存関係検査01() {
		assertEquals("lesson11.exam1.ClassMember", lesson11.exam1.Student.class.getSuperclass().getName());
	}
}
