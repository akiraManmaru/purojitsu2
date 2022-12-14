package lesson06a.figure;

public class BoundedRectangle extends Rectangle {
	private static int num;
	private static int maxSize = 200;

	public BoundedRectangle(int xPosition, int yPosition, int width, int height) {
		super(xPosition, yPosition, width, height);
		num++;

	}

	public static void printObjNumber() {
		System.out.println("これまでに" + num + "個のBoundedRectangleを生成しました。");
	}

	public static void printMaxSize() {
		System.out.println("最大サイズは" + maxSize + "です。");
	}

	public void twice() {
		if (height * 2 < maxSize && width * 2 < maxSize) {
			super.twice();

		} else {
			System.out.println("最大サイズ制限を超えるので、拡大しません。");
		}

	}

}
