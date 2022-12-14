package lesson11b.data;

import java.util.List;

import lesson11b.search.BinarySearch;
import lesson11b.search.FoulSearch;
import lesson11b.search.Search;
import lesson11b.search.SearchAlgorithm;
import lesson11b.search.SentSeqSearch;
import lesson11b.search.SeqSearch;
import lesson11b.util.ArrayListGenerator;

public class DataServer {
	private List<Integer> integers;
	private Order order;

	public DataServer(int n, Order order) {
		this.order = order;

		switch (order) {
		case RANDOM:
			integers = ArrayListGenerator.generateList(n);
			break;
		case ASCENDING:
			integers = ArrayListGenerator.generateAscendingList(n);
			break;
		}

	}

	public int search(int x, SearchAlgorithm searchAlgorithm) {
		Search s = null;
		switch (searchAlgorithm) {
		case SEQ_SEARCH:
			s = new SeqSearch();
			break;
		case SENT_SEQ_SEARCH:
			s = new SentSeqSearch();
			break;
		case BINARY_SEARCH:
			switch (order) {
			case RANDOM:
				s = new FoulSearch();
				break;
			case ASCENDING:
				s = new BinarySearch();
				break;
			}

		}

		return s.search(integers, x);
	}

}
