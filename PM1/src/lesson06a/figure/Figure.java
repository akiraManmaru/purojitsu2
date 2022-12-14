package lesson06a.figure;

public abstract class Figure {

    protected Coordinates coordinates;

    /**
     * 指定された位置の図形を作成
     * @param xPosition x座標
     * @param yPosition y座標
     */
    public Figure(int xPosition, int yPosition) {
        this.coordinates = new Coordinates(xPosition, yPosition);
    }

    /**
     * 指定された距離だけ移動
     * @param xMove
     * @param yMove
     */
    public void move(int xMove, int yMove) {
        coordinates.move(xMove, yMove);
    }

    /**
     * y=xに関して反転
     */
    public void flip() {
        coordinates.flip();
    }

    /**
     * 各フィールドの状態を表示
     */
    public void showState() {
        coordinates.showState();
        System.out.print(", ");
    }

    /**
     * 面積を計算
     */
    public abstract int getArea();

    /**
     * 縦横に２倍
     */
    public abstract void twice();
}
