package lesson04b.exvs;

import java.util.ArrayList;

public class Gundam extends MobileSuit {
	public Gundam(ArrayList<String> a) {
		super(a);
	}

	public void fighting() {
		System.out.println("ビームサーベルを使います.");
	}

	public void mainShooting() {
		System.out.println("ビームライフルを使います.");
	}

	public void subShooting() {
		System.out.println("ハイパー・バズーカを使います.");
	}

}
