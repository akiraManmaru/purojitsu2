package headfirst.factory.curry;

import headfirst.factory.factory.カレー店厨房;

/**
 * 野菜カレー 
 */
public class 野菜カレー extends カレー {
	public 野菜カレー(カレー店厨房 ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
 
	public void prepare() {
		System.out.println(name + "を準備中");
		size = ingredientFactory.setSize();
		roux = ingredientFactory.setRoux();
		egg = ingredientFactory.setEgg();
		veggies = ingredientFactory.setVeggies();
	}
}
