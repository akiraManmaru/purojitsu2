package lesson05.exam3.vehicle;

import lesson05.exam1.vehicle.Vehicle;

/**
 * 電気自動車クラスの定義
 */
public class ElectricCar extends Vehicle {
	/**
	 * 駆動部(エンジンや車輪など)を製造する
	 */
	public void produceDrive() {
		System.out.println("駆動部：");
		System.out.println(type + "用のシャーシを準備する");
		System.out.println(type + "用のモーターをとりつける");
		System.out.println(type + "用の車軸とタイヤをとりつける");
		System.out.println("電気系を接続する");
	}

	/**
	 * 内装をとりつける
	 */
	public void equip() {
		System.out.println("内装：");
		System.out.println("制御用ソフトウェアをインストールする");
		System.out.println("シートと操作部をとりつける");
	}

}
