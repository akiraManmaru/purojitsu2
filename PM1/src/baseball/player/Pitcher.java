package baseball.player;

public class Pitcher extends Player {
	private int win;
	private int loss;
	private int save;
	private int hp;
	private int out;
	private int er;

	public Pitcher(String name, String team, String hand, String game,
			String win, String loss, String save, String hp, String out, String er) {
		super(name, team, hand, game);
		this.win = Integer.parseInt(win);
		this.loss = Integer.parseInt(loss);
		this.save = Integer.parseInt(save);
		this.hp = Integer.parseInt(hp);
		this.out = Integer.parseInt(out);
		this.er = Integer.parseInt(er);
	}

	public int getWin() {
		return win;
	}

	public int getLoss() {
		return loss;
	}

	public int getSave() {
		return save;
	}

	public int getHp() {
		return hp;
	}

	public double getEra() {
		if (out == 0) {
			return -1.0;
		} else {
			return (double) er * 27 / out;

		}
	}

	public double calcPercentage() {
		if (win == loss) {
			return 0.0;
		} else {
			return (double) win / (win + loss);

		}
	}

	public int getOut() {
		return out;
	}

	public int getEr() {
		return er;
	}

	protected String toStringHand() {
		String h = null;
		switch (hand) {
		case RIGHT:
			h = "右投げ";
			break;
		case LEFT:
			h = "左投げ";
			break;
		case SWITCH:
			h = "両投げ";
			break;
		}
		return h;
	}

	protected String toStringStatistics() {
		return game + "試合, " + win + "勝, " + loss + "敗, " + save + "セーブ, " + hp + "HP, 防御率"
				+ String.format("%.2f", getEra()) + ", 勝率"
				+ String.format("%.3f", calcPercentage());
	}

}
