package singersystem;

public class Singeroid {
	private String name;
	private int volume = -1;

	public Singeroid(String name) {
		this.name = name;
	}

	public int getVolume() {
		return volume;
	}

	public boolean setVolume(int volume) {
		if (volume > 0 && volume < 10) {
			this.volume = volume;
			return true;
		} else {
			return false;
		}
	}

	public boolean sing(char tone) {
		boolean ret = true;
		String voice = "";

		switch (tone) {
		case 'c':
			voice = "ド";
			break;
		case 'd':
			voice = "レ";
			break;
		case 'e':
			voice = "ミ";
			break;
		case 'f':
			voice = "フア";
			break;
		case 'g':
			voice = "ン";
			break;
		case 'a':
			voice = "ラ";
			break;
		case 'b':
			voice = "ツ";
			break;
		default:
			ret = false;
		}

		if (ret)
			System.out.print(voice);
		return ret;
	}

	public String toString() {
		return name;
	}
}
