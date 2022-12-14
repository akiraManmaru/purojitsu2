package exam1;

import static org.junit.Assert.*;

import org.junit.Test;

import headfirst.factory.curry_factory_fm.CoCo壱番屋;
import headfirst.factory.curry_factory_fm.カレー;
import headfirst.factory.curry_factory_fm.カレーチェーン店;

/**
 * 具象ファクトリのテスト（CoCo壱番屋）
 */
public class CoCoIchiFMTest{

	/**
	 * 具体的な食材をチェック（カツ）
	 */
	@Test
	public void 具象ファクトリ実装検査01() {
		String message = "\n---- CoCo壱番屋カツカレー ----\n辛口\n普通\nポークカツ\n------------------------------\n";

		カレーチェーン店 cocoIchiban = new CoCo壱番屋();
		カレー carry = cocoIchiban.orderCurry("カツ");
		assertEquals(message, carry.recipe());
	}

	/**
	 * 具体的な食材をチェック（Vegetable）
	 */
	@Test
	public void 具象ファクトリ実装検査02() {
		String message = "\n---- CoCo壱番屋野菜カレー ----\n辛口\n普通\nほうれん草, ナス\n------------------------------\n";

		カレーチェーン店 cocoIchiban = new CoCo壱番屋();
		カレー carry = cocoIchiban.orderCurry("野菜");
		assertEquals(message, carry.recipe());
	}
}
