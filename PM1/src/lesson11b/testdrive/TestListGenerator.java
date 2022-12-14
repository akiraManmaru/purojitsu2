package lesson11b.testdrive;

import lesson11b.util.ArrayListGenerator;

public class TestListGenerator {

	
	public static void main(String[] args){
		
		// 要素数10，最大値100のランダム順リストを作って表示
		System.out.println(ArrayListGenerator.generateList(10,100));
		
		// 要素数10のランダム順のリストを作って表示
		System.out.println(ArrayListGenerator.generateList(10));
		
		// 要素数10，間隔1以上10以下の昇順のリストを作って表示		
		System.out.println(ArrayListGenerator.generateAscendingList(10,10));
		
		// 要素数10の昇順のリストを作って表示		
		System.out.println(ArrayListGenerator.generateAscendingList(10));
	}
	
}
