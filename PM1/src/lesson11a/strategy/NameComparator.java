package lesson11a.strategy;

public class NameComparator implements CompareType {
	public void compare(Unit unt1, Unit unt2) {
		if (unt1.getStatus().getName().equals(unt2.getStatus().getName())) {
			System.out.println("同じ名前です。");
		} else {
			System.out.println("異なる名前です。");
		}
	}

}
