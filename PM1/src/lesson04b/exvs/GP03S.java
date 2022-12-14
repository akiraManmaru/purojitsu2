package lesson04b.exvs;

import java.util.ArrayList;

public class GP03S extends MobileSuit {
	public GP03S(ArrayList<String> a) {
		super(a);
	}

	public void fighting() {
		System.out.println("ビームサーベルを使います.");
	}

	public void mainShooting() {
		System.out.println("フォールディング・バズーカを使います.");
	}

	public void subShooting() {
		System.out.println("大型集束ミサイル/マイクロミサイルを使います.");
	}

}
