package lesson06a.figure;

public class Rectangle extends Figure {

    protected int width;
    protected int height;

    /**
     * 指定された位置と大きさの長方形を作成
     * @param xPosition x座標
     * @param yPosition y座標
     * @param width 幅
     * @param height 高さ
     */
    public Rectangle(int xPosition, int yPosition, int width, int height) {
        super(xPosition, yPosition);
        this.width = width;
        this.height = height;
    }

    /**
     * y=xに関して反転
     */
    public void flip() {
        super.flip();
        int tmp = width;
        width = height;
        height = tmp;
    }

    /**
     * 各フィールドの状態を表示
     */
    public void showState() {
        super.showState();
        System.out.printf("幅：%d, 高さ：%d\n", width, height);
    }

    /**
     * 面積を計算
     */
    @Override
    public int getArea() {
        return width * height;
    }

    /**
     * 縦横に２倍
     */
    @Override
    public void twice() {
        width *= 2;
        height *= 2;
    }
}
