/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 3-1
 * 提出日 2021/9/28
 */
/*
 * Rectangleクラスに小数点、外周計算、サイズ変更、90度回転できるメソッドを足したクラス
 */
public class RectangleDouble {
	//フィールド
	private double xPosition;
	private double yPosition;
	private double width;
	private double height;
	
	
    //コンストラクタ
	public RectangleDouble(double xPosition, double yPosition, double width, double height) {
		super();
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.width = width;
		this.height = height;
	}
	
	//移動するメソッド
    public void move(double xMove,double yMove) {
		xPosition = xPosition + xMove;
		yPosition = yPosition + yMove;
	}
    
    //座標表示するメソッド
  	public void showState() {
  		System.out.printf("位置:(%.1f,%.1f), 幅:%.1f, 高さ:%.1f, 面積:%.2e, 外周:%.1f\n",xPosition,yPosition,width,height,calcArea(),calcAround());
  	}
  	
    //面積を計算するメソッド
  	public double calcArea() {
  		double area;
  		area = width * height;
  		return area;
  	}
  	
  	//外周を計算するメソッド
  	public double calcAround() {
  		return (width + height) * 2;
  	}
  	
  	//サイズを変更するメソッド
  	public void resize(double ratio) {
  		width = width * ratio;
  		height = height * ratio;
  	}
  	
  	//90度回転させるメソッド
  	public void rotate90() {
  		double width2 = height;
  		double height2 = width;
  		width = width2;
  		height = height2;
  		showState();
  	}



    //メインメソッド
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		RectangleDouble rect1 = new RectangleDouble(2,1,5,6);
		rect1.move(1.5, 2);
		rect1.showState();
		//system.out.printf("面積:%f\n",rect1.calcArea());
		//System.out.printf("面積:%f, 外周:%f\n", rect1.calcArea(), rect1.calcAround());
		rect1.resize(0.5);
		rect1.showState();
		rect1.resize(3.14159e3);
		rect1.showState();
		rect1.rotate90();

	}

}
