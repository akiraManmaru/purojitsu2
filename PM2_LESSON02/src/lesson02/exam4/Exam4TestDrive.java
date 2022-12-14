package lesson02.exam4;

public class Exam4TestDrive {
	public static void main(String[] args) {
 
		EspressoBrew espressoBrew = new EspressoBrew();
		DripBrew     dripBrew     = new DripBrew();
		NoMilk       noMilk       = new NoMilk();
		Milk         milk         = new Milk();
		
		CoffeeStrategy espresso = new CoffeeStrategy(espressoBrew, noMilk);
  		System.out.println("\nエスプレッソを作ります...");
		espresso.prepareRecipe();

		CoffeeStrategy caffeLatte = new CoffeeStrategy(espressoBrew, milk);
		System.out.println("\nカフェラテを作ります...");
		caffeLatte.prepareRecipe();
		
		CoffeeStrategy cafeAuLait = new CoffeeStrategy(dripBrew, milk);
		System.out.println("\nカフェオレを作ります...");
		cafeAuLait.prepareRecipe();

		CoffeeStrategy black = new CoffeeStrategy(dripBrew, noMilk);
		System.out.println("\nブラックコーヒーを作ります...");
		black.prepareRecipe();

 	}
}
