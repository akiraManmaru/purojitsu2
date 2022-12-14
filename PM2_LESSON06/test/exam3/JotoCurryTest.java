package exam3;

import static org.junit.Assert.*;

import org.junit.Test;

import headfirst.factory.curry.カレー;
import headfirst.factory.factory.カレーチェーン店;
import headfirst.factory.factory.上等カレー;

/**
 * 具象ファクトリのテスト（リトルスプーン）
 */
public class JotoCurryTest{

	/**
	 * 具体的な食材をチェック（カツ）
	 */
	@Test
	public void 具象ファクトリ実装検査01() {
		String message = "\n---- 上等カレーカツカレー ----\n激辛\n普通\nポークカツ, チキンカツ\nゆで卵\n------------------------------\n";

		カレーチェーン店 jotoCurry = new 上等カレー();
		カレー curry = jotoCurry.orderCurry("カツ");
		assertEquals(message, curry.recipe());
	}

	/**
	 * 具体的な食材をチェック（Vegetable）
	 */
	@Test
	public void 具象ファクトリ実装検査02() {
		String message = "\n---- 上等カレー野菜カレー ----\n激辛\n普通\n季節野菜\nゆで卵\n------------------------------\n";

		カレーチェーン店 jotoCurry = new 上等カレー();
		カレー curry = jotoCurry.orderCurry("野菜");
		assertEquals(message, curry.recipe());
	}

	/**
	 * 具体的な食材をチェック（魚介）
	 */
	@Test
	public void 具象ファクトリ実装検査03() {
		String message = "\n---- 上等カレーシーフードカレー ----\n激辛\n普通\nフィッシュフライ, カキフライ\nゆで卵\n------------------------------\n";

		カレーチェーン店 jotoCurry = new 上等カレー();
		カレー curry = jotoCurry.orderCurry("シーフード");
		assertEquals(message, curry.recipe());
	}
}
