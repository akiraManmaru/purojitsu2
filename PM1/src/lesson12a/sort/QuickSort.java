package lesson12a.sort;

import java.util.List;

public class QuickSort extends Sort {
	public void sort(List<Integer> data) {
		int n = data.size();
		printArray(data);
		quickSort(data, 0, n - 1);
	}

	public void quickSort(List<Integer> data, int left, int right) {
		int mid = (left + right) / 2;
		int x = data.get(mid);
		int i = left;
		int j = right;
		while (i <= j) {
			while (data.get(i) < x)
				i++;
			while (data.get(j) > x)
				j--;
			if (i <= j) {
				swap(data, i++, j--);
				printArray(data);
			}
		}
		if (left < j)
			quickSort(data, left, j);
		if (i < right)
			quickSort(data, i, right);
	}

}
