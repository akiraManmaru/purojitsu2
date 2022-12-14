package lesson06b.bus;

/**
 * バスの運転手のクラス（作成不要）
 * @author handa
 */
public class Driver {
	
	/**
	 * バス会社の参照型変数
	 */
	private Company busCompany;
	
	/**
	 * フィールドbusCompanyの初期化
	 * busCompanyに運転する路線を割り当ててもらう
	 */
	public Driver() {
		busCompany = Company.getInstance();
		busCompany.assign(this);	
	}
	
	/**
	 * 引数busStopName以降のバス停に遅延時間を設定する．
	 * @param busStopName バス停の名前
	 * @param delay 遅延時間
	 * @return busDriverが担当している路線や，その路線にbusStopNameというバス停がない場合はfalseを返す．その他はtrueを返す．
	 */
	public boolean reportDelay(String busStopName, int delay) {
		return busCompany.reportDelay(this, busStopName, delay);
	}

}
