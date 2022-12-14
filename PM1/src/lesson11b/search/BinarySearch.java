package lesson11b.search;

import java.util.List;

public class BinarySearch implements Search {

	public int search(List<Integer> s, int x) {
		int left = 0, right = s.size() - 1;
		while (left <= right) {
			int cen = (left + right) / 2;
			if (x == s.get(cen))
				return cen;
			else if (x < s.get(cen))
				right = cen - 1;
			else
				left = cen + 1;

		}
		return -1;
	}

}
