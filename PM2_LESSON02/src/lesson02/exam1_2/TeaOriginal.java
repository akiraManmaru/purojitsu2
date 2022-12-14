package lesson02.exam1_2;

public class TeaOriginal {
 
	void prepareRecipe() {
		boilWater();
		steepTeaBag();
		pourInCup();
		addLemon();
	}
 
	public void boilWater() {
		System.out.println("お湯を沸かします");
	}
 
	public void steepTeaBag() {
		System.out.println("ティーバックを浸します");
	}
 
	public void addLemon() {
		System.out.println("レモンを入れます");
	}
 
	public void pourInCup() {
		System.out.println("カップに注ぎます");
	}
}
