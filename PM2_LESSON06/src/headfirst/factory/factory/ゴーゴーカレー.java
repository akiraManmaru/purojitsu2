package headfirst.factory.factory;

import headfirst.factory.curry.カレー;

public class ゴーゴーカレー extends カレーチェーン店 {
	public カレー createCurry(String item) {
		カレー店厨房 ingredientFactory = new ゴーゴーカレー厨房();
		カレー curry = createCurryInCookroom(item, ingredientFactory);
		if (curry != null) {
			curry.setName("ゴーゴー" + item + "カレー");
		}
		return curry;
	}

}
