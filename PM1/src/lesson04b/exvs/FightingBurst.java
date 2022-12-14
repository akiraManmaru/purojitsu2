package lesson04b.exvs;

public class FightingBurst extends ExtremeBurst {

	public FightingBurst() {
		burstStatus = "格闘";
	}

	public void executeExtremeBurst() {
		System.out.println("格闘攻撃が強い状態です.");
	}

}
