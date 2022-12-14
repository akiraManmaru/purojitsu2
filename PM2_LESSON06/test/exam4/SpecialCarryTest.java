package exam4;

import static org.junit.Assert.*;

import org.junit.Test;

import headfirst.factory.curry.カレー;
import headfirst.factory.factory.CoCo壱番屋;
import headfirst.factory.factory.カレーチェーン店;
import headfirst.factory.factory.ゴーゴーカレー;
import headfirst.factory.factory.上等カレー;

/**
 * 具象ファクトリのテスト（スペシャルカレー）
 */
public class SpecialCarryTest{

	/**
	 * 具体的な食材をチェック（スペシャル）
	 */
	@Test
	public void 具象ファクトリ実装検査01() {
		String message = "\n---- CoCo壱番屋スペシャルカレー ----\n辛口\n普通\n納豆\n------------------------------\n";
		
		カレーチェーン店 cocoIchiban = new CoCo壱番屋();
		カレー curry = cocoIchiban.orderCurry("スペシャル");
		assertEquals(message, curry.recipe());
	}

	/**
	 * 具体的な食材をチェック（スペシャル）
	 */
	@Test
	public void 具象ファクトリ実装検査02() {
		String message = "\n---- ゴーゴースペシャルカレー ----\n甘口\n大盛り\nキノコ\n生卵\n------------------------------\n";
		
		カレーチェーン店 gogo = new ゴーゴーカレー();
		カレー curry = gogo.orderCurry("スペシャル");
		assertEquals(message, curry.recipe());
	}

	/**
	 * 具体的な食材をチェック（スペシャル）
	 */
	@Test
	public void 具象ファクトリ実装検査03() {
		String message = "\n---- 上等カレースペシャルカレー ----\n激辛\n普通\nチーズ\nゆで卵\n------------------------------\n";
		
		カレーチェーン店 jotoCurry = new 上等カレー();
		カレー curry = jotoCurry.orderCurry("スペシャル");
		assertEquals(message, curry.recipe());
	}
}
