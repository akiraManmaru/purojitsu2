
/**
 * 天体のデータを管理するクラス
 * @version 1.1 2021/12/1
 * @author infoStaff
 */
public class Star {

	private String name; //天体名(英語名)
	private String japaneseName; //天体名(日本語名)
	private String type; //種別
	private double distance; //距離(天文単位)
	private double orbitalPeriod; //公転周期(年)
	private int radius; //半径(km)
	private double rotationPeriod; //自転周期(日)
	private double mass; //質量(対地球比)

	public Star(String line) {
		String s[] = line.split(",");
		this.name = s[0];
		this.japaneseName = s[1];
		this.type = s[2];
		this.distance = Double.parseDouble(s[3]);
		this.orbitalPeriod = Double.parseDouble(s[4]);
		this.radius = Integer.parseInt(s[5]);
		this.rotationPeriod = Double.parseDouble(s[6]);
		this.mass = Double.parseDouble(s[7]);

	}

	/**
	 * 天体名(英語名)を取得するメソッド
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 天体名(日本語名)を取得するメソッド
	 * @return japaneseName
	 */
	public String getJapaneseName() {
		return japaneseName;
	}

	/**
	 * 種別を取得するメソッド
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 距離(天文単位)を取得するメソッド
	 * @return distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * 半径(km)を取得するメソッド
	 * @return radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * 公転周期(年)を取得するメソッド
	 * @return orbitalPeriod
	 */
	public double getOrbitalPeriod() {
		return orbitalPeriod;
	}

	/**
	 * 自転周期(日)を取得するメソッド
	 *  @return rotationPeriod
	 */
	public double getRotationPeriod() {
		return rotationPeriod;
	}

	/**
	 * 質量(対地球比)を取得するメソッド
	 * @return mass
	 */
	public double getMass() {
		return mass;
	}

}