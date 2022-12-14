package lesson04b.testdrive;

import lesson04b.exvs.FightingBurst;
import lesson04b.exvs.Gundam;
import lesson04b.exvs.ShootingBurst;
import lesson04b.exvs.StatusOfMobileSuit;

public class TestDrive02Gundam {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		StatusOfMobileSuit sOfMs = new StatusOfMobileSuit();
		Gundam gundam = new Gundam(sOfMs.getMsMap().get("RX-78-2"));
		gundam.showInfo();
		gundam.executeExtremeBurst();
		gundam.setExtremeBurst(new ShootingBurst());
		gundam.showInfo();
		gundam.executeExtremeBurst();
		gundam.setExtremeBurst(new FightingBurst());
		gundam.showInfo();
		gundam.executeExtremeBurst();
		gundam.setExtremeBurst(null);
		gundam.showInfo();
		gundam.executeExtremeBurst();
		gundam.fighting();
		gundam.mainShooting();
		gundam.subShooting();

	}

}