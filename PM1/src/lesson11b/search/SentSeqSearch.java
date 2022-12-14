package lesson11b.search;

import java.util.List;

public class SentSeqSearch implements Search {
	public SentSeqSearch() {

	}

	public int search(List<Integer> s, int x) {
		int i = 0;
		s.add(x);
		while (true) {
			if (x == s.get(i))
				break;
			i++;

		}
		s.remove(s.size() - 1);
		if (i == s.size())
			return -1;
		else
			return i;

	}

}
