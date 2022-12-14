package lesson13a.baseball;

public class SimplePlayer {

	protected String name; // 名前
	protected String team; // チーム名
	protected String hand; // 利き腕

	public SimplePlayer(String name, String team, String hand) {
		this.name = name;
		this.team = team;
		this.hand = hand;
	}

	public void printInfo() {
		System.out.println("名前は" + name + ", チームは" + team + ", 利き腕は" + hand);
	}

	public String toStringData() {
		return String.format("%s, %s, %s", this.name, this.team, this.hand);
	}

}