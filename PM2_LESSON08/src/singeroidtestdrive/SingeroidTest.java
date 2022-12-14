package singeroidtestdrive;

import static org.junit.Assert.*;

import org.junit.Test;

import singersystem.Singeroid;

public class SingeroidTest {

	@Test
	public void test() {
		Singeroid player;
		player = new Singeroid("ミク");

		assertEquals("ミク", player.toString());
		assertEquals(0, player.getVolume());
		assertEquals(false, player.setVolume(-1));
		assertEquals(false, player.setVolume(11));
		assertEquals(true, player.setVolume(0));
		assertEquals(true, player.setVolume(3));
		assertEquals(true, player.setVolume(10));
		assertEquals(true, player.sing('c'));
		assertEquals(true, player.sing('d'));
		assertEquals(true, player.sing('e'));
		assertEquals(true, player.sing('f'));
		assertEquals(true, player.sing('g'));
		assertEquals(true, player.sing('a'));
		assertEquals(true, player.sing('b'));
		assertEquals(false, player.sing('z'));
	}
}
