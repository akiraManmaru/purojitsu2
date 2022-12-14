package lesson11a.strategy;

public class UnitComparator {
	private CompareType compareType;

	public UnitComparator() {
		
	}

	public void compare(Unit unt1, Unit unt2, CompareType compareType) {
		this.compareType = compareType;
		this.compareType.compare(unt1, unt2);
	}

}
