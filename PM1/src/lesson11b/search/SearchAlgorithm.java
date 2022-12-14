package lesson11b.search;

public enum SearchAlgorithm {
	BINARY_SEARCH("2分探索"), SENT_SEQ_SEARCH("番兵法"), SEQ_SEARCH("逐次探索");

	String string;

	SearchAlgorithm(String string) {
		this.string = string;
	}

	public String toString() {
		return string;
	}

}
