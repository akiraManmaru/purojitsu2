package lesson12a.sort;

import java.util.List;

public class SelectionSort extends Sort {

	public void sort(List<Integer> data) {
		int n = data.size();
		printArray(data);
		for (int k = 1; k < n; k++) {
			int m = 0;
			for (int i = 1; i <= n - k; i++) {
				if (data.get(m) < data.get(i))
					m = i;
			}
			swap(data, m, n - k);
			printArray(data);
		}

	}

}
