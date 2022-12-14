package lesson11b.util;

import java.util.ArrayList;
import java.util.Random;

public class ArrayListGenerator {
	public static ArrayList<Integer> generateList(int n) {
		return generateList(n, n * 5);
	}

	public static ArrayList<Integer> generateList(int n, int max) {
		Random r = new Random();
		ArrayList<Integer> list = new ArrayList<>();
		int i = 0;
		while (i < n) {
			int num = r.nextInt(max) + 1;
			list.add(num);
			i++;
		}
		return list;
	}

	public static ArrayList<Integer> generateAscendingList(int n) {
		return generateAscendingList(n, 5);

	}

	public static ArrayList<Integer> generateAscendingList(int n, int gap) {
		Random r = new Random();
		ArrayList<Integer> list = new ArrayList<>();
		int num = r.nextInt(gap) + 1;
		list.add(num);
		int i = 1;
		while (i < n) {
			int num2 = num + list.get(i - 1);
			list.add(num2);
			i++;
		}
		return list;

	}

}
