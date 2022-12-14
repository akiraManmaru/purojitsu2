package lesson12.exam2;/** * 全状態での各メソッドの実行と状態遷移のテストドライブ * @author Hitoshi Habe (habe@kindai.ac.jp) * @version 1.0.0 */public class TestDrive_Exam2 { 	public static void main(String[] args) {		// ****** シーケンス図はここからの動作について書くこと ******		DeliveryRobot2 rc = new DeliveryRobot2();		/*		 * 状態遷移の網羅チェック		 */		System.out.println("=== 配送開始 ===");		rc.voiceCommand(); // 1回目開始		rc.voiceCommand();		// ****** シーケンス図はここまでの動作について書くこと ******		rc.voiceCommand(); // 2回目開始		rc.detectCollapse();		rc.resetCommand();		/*		 * それぞれの状態で受け付けない操作のチェック		 */		/*		 * 「待ち」状態から		 */		System.out.println("=== 「待ち」状態からのチェック ===");		rc.resetCommand();		rc.detectCollapse();		rc.voiceCommand();		/*		 * 「配送中」状態から		 */		System.out.println("=== 「配送中」状態からのチェック ===");		rc.resetCommand();		rc.detectCollapse();		/*		 * 「緊急停止」状態から		 */		System.out.println("=== 「緊急停止」状態からのチェック ===");		rc.voiceCommand();		rc.detectCollapse();		rc.resetCommand();	}}