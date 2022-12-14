package lesson04b.exvs;

import java.util.ArrayList;

public class NuGundam extends MobileSuit {
	public NuGundam(ArrayList<String> a) {
		super(a);
	}

	public void fighting() {
		System.out.println("ビームサーベルを使います.");
	}

	public void mainShooting() {
		System.out.println("ビームライフルを使います.");
	}

	public void subShooting() {
		System.out.println("フィン・ファンネルを使います.");
	}

}
