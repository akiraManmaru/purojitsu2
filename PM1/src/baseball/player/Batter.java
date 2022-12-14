package baseball.player;

public class Batter extends Player {

	private int pa;
	private int atBat;
	private int hit;
	private int twoBaseHit;
	private int threeBaseHit;
	private int homerun;
	private int rbi;
	private int strikeOut;

	public Batter(String name, String team, String hand, String game, String pa, String atBat, String hit,
			String twoBaseHit,
			String threeBaseHit, String homerun, String rbi, String strikeOut) {
		super(name, team, hand, game);
		this.pa = Integer.parseInt(pa);
		this.atBat = Integer.parseInt(atBat);
		this.hit = Integer.parseInt(hit);
		this.twoBaseHit = Integer.parseInt(twoBaseHit);
		this.threeBaseHit = Integer.parseInt(threeBaseHit);
		this.homerun = Integer.parseInt(homerun);
		this.rbi = Integer.parseInt(rbi);
		this.strikeOut = Integer.parseInt(strikeOut);

	}

	public double calcAverage() {
		if (atBat == 0) {
			return 0.0;
		} else {
			return (double) hit / atBat;

		}
	}

	public double calcSlg() {
		if (atBat == 0) {
			return 0.0;
		} else {
			return (double) (hit + twoBaseHit + threeBaseHit * 2 + homerun * 3) / atBat;

		}
	}

	public int getPa() {
		return pa;
	}

	public int getAtBat() {
		return atBat;
	}

	public int getHit() {
		return hit;
	}

	public int getTwoBaseHit() {
		return twoBaseHit;
	}

	public int getThreeBaseHit() {
		return threeBaseHit;
	}

	public int getHomerun() {
		return homerun;
	}

	public int getRbi() {
		return rbi;
	}

	public int getStrikeOut() {
		return strikeOut;
	}

	protected String toStringHand() {
		String h = null;
		switch (hand) {
		case RIGHT:
			h = "右打ち";
			break;
		case LEFT:
			h = "左打ち";
			break;
		case SWITCH:
			h = "両打ち";
			break;
		}
		return h;
	}

	protected String toStringStatistics() {
		return game + "試合, 打率" + String.format("%.3f", calcAverage()) + ", " + pa + "打席, " + hit + "安打, " + homerun
				+ "本塁打, " + rbi + "打点, "
				+ strikeOut + "三振, 長打率" + String.format("%.3f", calcSlg());
	}

}
