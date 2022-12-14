package lesson12a.sort;

import java.util.List;

public class InsertionSort extends Sort {
	public void sort(List<Integer> data) {
		int n = data.size();
		printArray(data);
		for (int k = 1; k < n; k++) {
			for (int j = k; j > 0; j--) {
				if (data.get(j) < data.get(j - 1)) {
					swap(data, j, j - 1);
					printArray(data);
				} else
					break;
			}
		}
	}

}
