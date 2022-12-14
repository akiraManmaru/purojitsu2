package headfirst.factory.factory;

import headfirst.factory.curry.カレー;

public class 上等カレー extends カレーチェーン店 {
	public カレー createCurry(String item) {
		カレー店厨房 ingredientFactory = new 上等カレー厨房();
		カレー curry = createCurryInCookroom(item, ingredientFactory);
		if (curry != null) {
			curry.setName("上等カレー" + item + "カレー");
		}
		return curry;
	}

}
