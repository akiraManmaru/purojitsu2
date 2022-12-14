package headfirst.factory.curry;

import headfirst.factory.factory.カレー店厨房;

public class シーフードカレー extends カレー {
	public シーフードカレー(カレー店厨房 ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	public void prepare() {
		System.out.println(name + "を準備中");
		size = ingredientFactory.setSize();
		roux = ingredientFactory.setRoux();
		egg = ingredientFactory.setEgg();
		seafood = ingredientFactory.setSeafood();
	}

}
