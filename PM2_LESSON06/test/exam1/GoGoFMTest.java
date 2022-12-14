package exam1;


import static org.junit.Assert.*;

import org.junit.Test;

import headfirst.factory.curry_factory_fm.カレー;
import headfirst.factory.curry_factory_fm.カレーチェーン店;
import headfirst.factory.curry_factory_fm.ゴーゴーカレー;

/**
 * 具象ファクトリのテスト（ゴーゴーカレー）
 */
public class GoGoFMTest{

	/**
	 * 具体的な食材をチェック（カツ）
	 */
	@Test
	public void 具象ファクトリ実装検査01() {
		String message = "\n---- ゴーゴーカツカレー ----\n甘口\n大盛り\nメンチカツ\n生卵\n------------------------------\n";

		カレーチェーン店 gogo = new ゴーゴーカレー();
		カレー curry = gogo.orderCurry("カツ");
		assertEquals(message, curry.recipe());
	}

	/**
	 * 具体的な食材をチェック（Vegetable）
	 */
	@Test
	public void 具象ファクトリ実装検査02() {
		String message = "\n---- ゴーゴー野菜カレー ----\n甘口\n大盛り\n完熟カットトマト, トマトアスパラ\n生卵\n------------------------------\n";

		カレーチェーン店 gogo = new ゴーゴーカレー();
		カレー curry = gogo.orderCurry("野菜");
		assertEquals(message, curry.recipe());
	}
}
