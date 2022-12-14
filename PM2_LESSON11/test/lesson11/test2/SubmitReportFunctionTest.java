package lesson11.test2;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubmitReportFunctionTest{
	
	@Test
	public void クラス実装検査01() {
		try {
			Class.forName("lesson11.exam2.SubmitReportFunction");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}
	@Test
	public void クラス実装検査02() {
		try {
			Class.forName("lesson11.exam2.SubmitReportFunctionLecturerTA");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}

/*	@Test
	public void クラス依存関係検査01() {
		assertEquals("lesson11.exam2.MakeMessageString", lesson11.exam2.SubmitReportFunctionLecturerTA.class.getSuperclass().getName());
	}
*/
	@Test
	public void クラス依存関係検査02() {
		// sendReportFunction はインタフェースであること
        assertTrue(lesson11.exam2.SubmitReportFunction.class.isInterface());
        // sendReportFunctionTeacherTA は　sendReportFunction を実装していること
        lesson11.exam2.SubmitReportFunctionLecturerTA srf1 = new lesson11.exam2.SubmitReportFunctionLecturerTA();        
        assertEquals("interface lesson11.exam2.SubmitReportFunction", srf1.getClass().getInterfaces()[0].toString());
	}

	
	// implements の検査がない！
	
}
