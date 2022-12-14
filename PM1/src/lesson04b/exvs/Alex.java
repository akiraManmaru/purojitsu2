package lesson04b.exvs;

import java.util.ArrayList;

public class Alex extends MobileSuit {
	public Alex(ArrayList<String> a) {
		super(a);
	}

	public void fighting() {
		System.out.println("格闘を使います.");
	}

	public void mainShooting() {
		System.out.println("バルカンを使います.");
	}

	public void subShooting() {
		System.out.println("ジム・スナイパーII呼出を使います.");
	}

}
