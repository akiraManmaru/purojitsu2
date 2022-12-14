package lesson04b.testdrive;

import java.util.ArrayList;

import lesson04b.exvs.Alex;
import lesson04b.exvs.GP03S;
import lesson04b.exvs.Gundam;
import lesson04b.exvs.GundamMK2;
import lesson04b.exvs.MobileSuit;
import lesson04b.exvs.NuGundam;
import lesson04b.exvs.StatusOfMobileSuit;

public class TestDrive03AllMobileSuit {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList<MobileSuit> msList = new ArrayList<MobileSuit>();
		StatusOfMobileSuit sOfMs = new StatusOfMobileSuit();
		msList.add(new Gundam(sOfMs.getMsMap().get("RX-78-2")));
		msList.add(new Alex(sOfMs.getMsMap().get("RX-78NT-1")));
		msList.add(new GP03S(sOfMs.getMsMap().get("RX-78GP03S")));
		msList.add(new GundamMK2(sOfMs.getMsMap().get("RX-178")));
		msList.add(new NuGundam(sOfMs.getMsMap().get("RX-93")));

		for (MobileSuit ms : msList) {
			ms.showInfo();
			ms.fighting();
			ms.mainShooting();
			ms.subShooting();
		}
	}

}
