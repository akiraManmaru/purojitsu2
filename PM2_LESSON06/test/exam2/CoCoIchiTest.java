package exam2;

import static org.junit.Assert.*;

import org.junit.Test;

import headfirst.factory.curry.カレー;
import headfirst.factory.factory.CoCo壱番屋;
import headfirst.factory.factory.カレーチェーン店;

/**
 * 具象ファクトリのテスト（CoCo壱番屋）
 */
public class CoCoIchiTest{

	/**
	 * 具体的な食材をチェック（カツ）
	 */
	@Test
	public void 具象ファクトリ実装検査01() {
		String message = "\n---- CoCo壱番屋カツカレー ----\n辛口\n普通\nポークカツ\n------------------------------\n";
		
		カレーチェーン店 cocoIchiban = new CoCo壱番屋();
		カレー curry = cocoIchiban.orderCurry("カツ");
		assertEquals(message, curry.recipe());
	}

	/**
	 * 具体的な食材をチェック（Vegetable）
	 */
	@Test
	public void 具象ファクトリ実装検査02() {
		String message = "\n---- CoCo壱番屋野菜カレー ----\n辛口\n普通\nほうれん草, ナス\n------------------------------\n";
		
		カレーチェーン店 cocoIchiban = new CoCo壱番屋();
		カレー curry = cocoIchiban.orderCurry("野菜");
		assertEquals(message, curry.recipe());
	}

	/**
	 * 具体的な食材をチェック（魚介）
	 */
	@Test
	public void 具象ファクトリ実装検査03() {
		String message = "\n---- CoCo壱番屋シーフードカレー ----\n辛口\n普通\nエビ, イカ\n------------------------------\n";
		
		カレーチェーン店 cocoIchiban = new CoCo壱番屋();
		カレー curry = cocoIchiban.orderCurry("シーフード");
		assertEquals(message, curry.recipe());
	}
}
