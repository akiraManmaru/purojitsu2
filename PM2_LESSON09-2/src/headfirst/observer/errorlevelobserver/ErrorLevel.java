package headfirst.observer.errorlevelobserver;

public class ErrorLevel {

	private static ErrorLevel instance;
	private int level;

	private ErrorLevel() {
		instance = null;
	}

	public void displayCurrentErrorLevel() {
		System.out.println("現在のエラーレベルは" + level + "です");

	}

	public int getErrorLevel() {
		return level;
	}

	public static ErrorLevel getInstance() {

		if (instance == null) {
			instance = new ErrorLevel();
		}
		return instance;
	}

	public int getMaxErrorLevel() {
		return 5;
	}

	public int getMinErrorLevel() {
		return 1;
	}

	public void putErrorLevel(int level) {
		this.level = level;
	}

}
