package baseball.sorting;

import java.util.List;

import baseball.Order;
import baseball.player.Player;

public class QuickSort extends Sort {

	@Override
	public void sort(List<Player> list, Order order) {
		// TODO 自動生成されたメソッド・スタブ
		int n = list.size();
		//printArray(data);
		quickSort(list, 0, n - 1, order);
	}

	public void quickSort(List<Player> list, int left, int right, Order order) {
		int mid = (left + right) / 2;
		Player x = list.get(mid);
		int i = left;
		int j = right;
		while (i <= j) {
			while (order.compare(x, list.get(i)) > 0)
				i++;
			while (order.compare(list.get(j), x) > 0)
				j--;
			if (i <= j) {
				swap(list, i++, j--);
				//printArray(data);
			}
		}
		if (left < j)
			quickSort(list, left, j, order);
		if (i < right)
			quickSort(list, i, right, order);
	}

}
