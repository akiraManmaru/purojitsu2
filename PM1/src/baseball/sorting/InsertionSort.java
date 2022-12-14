package baseball.sorting;

import java.util.List;

import baseball.Order;
import baseball.player.Player;

public class InsertionSort extends Sort {

	@Override
	public void sort(List<Player> list, Order order) {
		// TODO 自動生成されたメソッド・スタブ

		int n = list.size();

		for (int k = 1; k < n; k++) {
			for (int j = k; j > 0; j--) {
				if (order.compare(list.get(j), list.get(j - 1)) > 0) {
					swap(list, j, j - 1);

				} else
					break;
			}
		}

	}

}
