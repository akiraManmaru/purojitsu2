package lesson12b.sort;

public enum ElectricCarSortAlgorithm {
	INSERTION_SORT_YEAR("インサーションソート(販売開始年)"), BUBBLE_SORT_SEATS("バブルソート(定員)"), SELECTION_SORT_SEATS(
			"セレクションソート(定員)"), INSERTION_SORT_SEATS("インサーションソート(定員)"), QUICK_SORT_PRICE(
					"クイックソート(価格)"), INSERTION_SORT_TRAVELING_RANGE("インサーションソート(航続距離)");

	String method;

	ElectricCarSortAlgorithm(String method) {
		this.method = method;
	}

	public String toString() {
		return method;
	}

}
