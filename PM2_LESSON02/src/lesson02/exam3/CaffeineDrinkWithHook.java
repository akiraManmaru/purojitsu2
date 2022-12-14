package lesson02.exam3;

public abstract class CaffeineDrinkWithHook {
 
	public final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		if (customerWantsCondiments()) {
			putCondiments();
		}
	}
 
	public abstract void brew();
 
	public abstract void putCondiments();
 
	public void boilWater() {
		System.out.println("お湯を沸かします");
	}
 
	public void pourInCup() {
		System.out.println("カップに注ぎます");
	}
 
	public boolean customerWantsCondiments() {
		return true;
	}
}
