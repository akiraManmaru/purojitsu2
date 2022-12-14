package lesson02.exam1_2;

public class Exam2TestDrive {
	public static void main(String[] args) {
 
		Tea tea = new Tea();
		Coffee coffee = new Coffee();
 
		System.out.println("\n紅茶を作ります...");
		tea.prepareRecipe();
 
		System.out.println("\nコーヒーを作ります...");
		coffee.prepareRecipe();

 	}
}
