package lesson02.exam5;

import java.util.ArrayList;
import java.util.Iterator;

import lesson02.exam4.ICondiment;

public class CondimentArrayList extends ArrayList {
	public void putCondiments() {
		Iterator<ICondiment> iterator = this.iterator();
		while (iterator.hasNext()) {
			ICondiment s = iterator.next();
			s.putCondiments();
		}
	}
}
