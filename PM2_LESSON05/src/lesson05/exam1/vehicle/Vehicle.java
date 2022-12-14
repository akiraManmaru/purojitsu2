package lesson05.exam1.vehicle;

/**
 * 車両クラスの定義 車両を製造するための情報と製造方法
 */
public abstract class Vehicle {
	/**
	 * 車両の種類
	 */
	protected String type;

	/**
	 * 名称
	 */
	protected String name;

	/**
	 * 車体
	 */
	protected String body;

	/**
	 * ID(シリアルナンバー)
	 */
	protected int id;

	/**
	 * 駆動部(エンジンや車輪など)を製造する
	 */
	public abstract void produceDrive();

	/**
	 * 車体をとりつける
	 */
	public void produceBody() {
		System.out.println("車体：");
		System.out.println(body + "の車体を製造");
		System.out.println(body + "の車体をとりつけ");
	}

	/**
	 * 内装をとりつける
	 */
	public abstract void equip();

	/**
	 * IDをセットして履歴を出力する
	 */
	public void putID(int id) {
		this.id = id;
		System.out.println("種別:" + type + " 名称:" + name + " を製造しました。製造番号は "
				+ id + " となります\n");
	}
}
