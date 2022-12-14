package lesson11.test4;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ClassMemberTest{

	@Test
	public void クラス実装検査01() {
		try {
			Class.forName("lesson11.exam4.ClassMember");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void クラス依存関係検査01() {
		assertEquals("java.lang.Object", lesson11.exam4.ClassMember.class.getSuperclass().getName());
	}
	
	@Test
	public void フィールド実装検査01() {
		List<String> fields = new ArrayList<String>();
		fields.add("messageOperator");
		fields.add("name");

		for(Field f : lesson11.exam4.ClassMember.class.getDeclaredFields()) {
			assertTrue(fields.contains(f.getName()));
			fields.remove(f.getName());
		}

		int expected = 0;
		int actual = fields.size();
		assertThat(actual, is(expected));
	}
	
	@Test
	public void メソッド実装検査01() {
		List<String> methods = new ArrayList<String>();
		methods.add("getName");
		methods.add("addMember");
		methods.add("receiveMessage");
		methods.add("sendMessage");
		methods.add("submitReport");

		for(Method m : lesson11.exam4.ClassMember.class.getDeclaredMethods()) {
			assertTrue(methods.contains(m.getName()));
			methods.remove(m.getName());
		}

		int expected = 0;
		int actual = methods.size();
		assertThat(actual, is(expected));
	}
		
}
