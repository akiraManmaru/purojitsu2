package lesson12.exam3;

/**
 * 配送ロボット（State パターンを使わないバージョン）
 * @author Hitoshi Habe (habe@kindai.ac.jp)
 * @version 1.0.0
 */
public class DeliveryRobot3 {

	/**
	 * 状態を表現する固定値
	 */
	/**
	 * 「待ち」状態
	 */
	final static int WAITING = 100;
	/**
	 * 「配送中」状態
	 */
	final static int DELIVERING = 101;
	/**
	 * 「緊急停止」状態
	 */
	final static int EMERGENCYSTOP = 102;

	final static int PRIMEDELIVERING = 103;

	/**
	 * 状態を保持する
	 */
	private int state;

	/**
	 * コンストラクタ
	 * 初期状態は Waiting にする
	 */
	public DeliveryRobot3() {
		state = WAITING;
	}

	/**
	 * 音声コマンドを実行する
	 */
	public void voiceCommand() {
		if (state == WAITING) {
			// 状態が「待ち」の場合
			state = DELIVERING;
			System.out.println("配送を開始しました[->Delivering]");
		} else if (state == DELIVERING || state == PRIMEDELIVERING) {
			state = WAITING;
			System.out.println("配送を終了しました[->Waiting]");

		} else {
			// その他の状態では無効
			System.out.println("（その操作は無効です）");
		}
	}

	/**
	 * リセットコマンドを実行する
	 */
	public void resetCommand() {
		if (state == EMERGENCYSTOP) {
			System.out.println("リセットしました[->Waiting]");
			state = WAITING;
		} else {
			// その他の状態では無効
			System.out.println("（その操作は無効です）");
		}

	}

	/**
	 * 荷崩れが起きたことを検知
	 */
	public void detectCollapse() {

		if (state == DELIVERING || state == PRIMEDELIVERING) {
			System.out.println("荷崩れが起きたので自動積み直しを行い配送を続けます");
		} else {
			// その他の状態では無効
			System.out.println("（その操作は無効です）");
		}

	}

	public void detectEmergencyVehicle() {
		if (state == DELIVERING || state == PRIMEDELIVERING) {
			System.out.println("緊急車両を検知したので緊急停止します[->EmergencyStop]");
			state = EMERGENCYSTOP;
		} else {
			// その他の状態では無効
			System.out.println("（その操作は無効です）");
		}

	}

	public void detectPrime() {
		if (state == DELIVERING) {
			System.out.println("迅速配送の要請が発生したので迅速に配送します[->PrimeDelivering]");
			state = PRIMEDELIVERING;
		} else {
			// その他の状態では無効
			System.out.println("（その操作は無効です）");
		}

	}
}
