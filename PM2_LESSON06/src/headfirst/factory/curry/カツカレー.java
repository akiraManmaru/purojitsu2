package headfirst.factory.curry;

import headfirst.factory.factory.カレー店厨房;

/**
 * カツカレー　 
 */
public class カツカレー extends カレー {
	public カツカレー(カレー店厨房 ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
 
	public void prepare() {
		System.out.println(name + "を準備中");
		size = ingredientFactory.setSize();
		roux = ingredientFactory.setRoux();
		egg = ingredientFactory.setEgg();
		cutlet = ingredientFactory.setCutlet();
	}
}
