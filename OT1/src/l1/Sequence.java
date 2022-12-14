package l1;

public class Sequence implements Comparable {

	public Sequence() {

	}

	public Sequence(Symbol symbol) {

	}

	public boolean equals(Object objest) {

	}

	public String toString() {

	}

	public int conpareTo(Sequence sequence) {

	}

	public Secuence concatenate(Sequence sequence) {

	}

	public static void main(String[] args) {
		Sequence sequence1 = new Sequence(new Symbol("H"));
		Sequence sequence2 = new Sequence(new Symbol("H"), new Symbol("T"));
		System.out.println(sequence1);
		System.out.println(sequence2);
		System.out.println(sequence1.equals(sequence1));
		System.out.println(sequence1.equals(sequence2));
		System.out.println(sequence1.compareTo(sequence1));
		System.out.println(sequence1.compareTo(sequence2));
		System.out.println(sequence2.compareTo(sequence1));
		System.out.println(sequence1.concatenate(sequence2));
	}

}
