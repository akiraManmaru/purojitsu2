package headfirst.factory.factory;

import headfirst.factory.curry.カレー;

/**
 * CoCo壱番屋　　  　
 */
public class CoCo壱番屋 extends カレーチェーン店 {

	public カレー createCurry(String item) {
		カレー店厨房 ingredientFactory =
		new CoCo壱番屋厨房();
		カレー curry = createCurryInCookroom(item, ingredientFactory);
		if(curry != null ) {
			curry.setName("CoCo壱番屋"+item+"カレー");
		}
		return curry;
	}
}
