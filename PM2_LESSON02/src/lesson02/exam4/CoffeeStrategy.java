package lesson02.exam4;

public class CoffeeStrategy extends CaffeineDrink {
	protected ICoffeeBrew iCoffeeBrew;
	protected ICondiment iCondiment;

	public CoffeeStrategy(ICoffeeBrew iCoffeeBrew, ICondiment iCondiment) {
		this.iCoffeeBrew = iCoffeeBrew;
		this.iCondiment = iCondiment;
	}

	public void brew() {
		iCoffeeBrew.brew();
	}

	public void putCondiments() {
		iCondiment.putCondiments();
	}

}
