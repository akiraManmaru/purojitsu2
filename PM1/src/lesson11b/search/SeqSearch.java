package lesson11b.search;

import java.util.List;

public class SeqSearch implements Search {

	public SeqSearch() {

	}

	public int search(List<Integer> s, int x) {
		int i = 0;
		while (true) {
			if (i == s.size())
				return -1;
			else if (x == s.get(i))
				return i;

			else
				i++;

		}
	}

}
