package lesson04b.exvs;

public class ShootingBurst extends ExtremeBurst {

	public ShootingBurst() {
		super.burstStatus = "射撃";
	}

	public void executeExtremeBurst() {
		System.out.println("射撃攻撃が強い状態です.");
	}

}
