package headfirst.factory.curry;

import headfirst.factory.factory.カレー店厨房;

public class スペシャルカレー extends カレー {
	public スペシャルカレー(カレー店厨房 ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	public void prepare() {
		System.out.println(name + "を準備中");
		size = ingredientFactory.setSize();
		roux = ingredientFactory.setRoux();
		egg = ingredientFactory.setEgg();
		special = ingredientFactory.setSpecial();
	}

}
