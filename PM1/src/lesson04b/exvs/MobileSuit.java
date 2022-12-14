package lesson04b.exvs;

import java.util.ArrayList;

public abstract class MobileSuit {
	private String name;
	private String pilot;
	protected ExtremeBurst extremeBurst;
	protected String burstStatus;

	public MobileSuit(ArrayList<String> map) {
		this.name = map.get(0);
		this.pilot = map.get(1);
		this.extremeBurst = null;
		this.burstStatus = "通常";

	}

	public void showInfo() {
		System.out.println("機体名:" + name + " 覚醒状態:" + burstStatus + " パイロット名:" + pilot);

	}

	public void setExtremeBurst(ExtremeBurst ex) {

		if (ex != null) {
			this.extremeBurst = ex;
			this.burstStatus = ex.getBurstStatus();
		} else {
			this.extremeBurst = null;
			this.burstStatus = "通常";

		}
	}

	public void executeExtremeBurst() {
		if (extremeBurst == null) {
			System.out.println("エクストリームバーストは使えません");
		} else {
			extremeBurst.executeExtremeBurst();

		}
	}

	public abstract void fighting();

	public abstract void mainShooting();

	public abstract void subShooting();

}
