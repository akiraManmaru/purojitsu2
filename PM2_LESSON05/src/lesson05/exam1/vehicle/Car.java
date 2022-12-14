package lesson05.exam1.vehicle;

/**
 * 自動車クラスの定義
 */
public class Car extends Vehicle {
	/**
	 * 駆動部(エンジンや車輪など)を製造する
	 */
	public void produceDrive() {
		System.out.println("駆動部：");
		System.out.println(type + "用のシャーシを準備する");
		System.out.println(type + "用のエンジンをとりつける");
		System.out.println(type + "用の車軸とタイヤをとりつける");
	}

	/**
	 * 内装をとりつける
	 */
	public void equip() {
		System.out.println("内装：");
		System.out.println("電気系を接続する");
		System.out.println("シートと操作部をとりつける");
	}
}
