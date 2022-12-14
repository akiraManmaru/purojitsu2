package lesson02.exam5;

import lesson02.exam4.ICondiment;
import lesson02.exam4.Milk;
import lesson02.exam4.NoMilk;

public class Exam5TestDrive {

	public static void main(String[] args) {
		CondimentArrayList doubleMilk = new CondimentArrayList();

		ICondiment condiment = new Milk();
		doubleMilk.add(condiment);
		condiment = new Milk();
		doubleMilk.add(condiment);
		condiment = new NoMilk();
		doubleMilk.add(condiment);
		doubleMilk.putCondiments();
	}
}
