package lesson03.exam5;

import java.util.List;

public class ListAdapter<T> implements IStack<T> {
	private List<T> list;

	public ListAdapter(List<T> list) {
		//super();
		this.list = list;
	}

	public void clear() {
		list.clear();
	}

	public T pop() {
		if (list.size() == 0) {
			return null;
		}
		T hoge = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		return hoge;
	}

	public void push(T arg) {
		list.add(arg);
	}

}
