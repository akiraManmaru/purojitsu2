package lesson02.exam1_2;

public abstract class CaffeineBeverage {

	public final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}

	public abstract void brew();

	public abstract void addCondiments();

	public void boilWater() {
		System.out.println("お湯を沸かします");
	}

	public void pourInCup() {
		System.out.println("カップに注ぎます");
	}

}
