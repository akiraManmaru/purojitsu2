package lesson02.exam4;

public abstract class CaffeineDrink {
	public final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		putCondiments();
	}

	public abstract void brew();

	public abstract void putCondiments();

	public void boilWater() {
		System.out.println("お湯を沸かします");
	}

	public void pourInCup() {
		System.out.println("カップに注ぎます");
	}

}
