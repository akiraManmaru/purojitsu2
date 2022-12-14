package lesson06a.testdrive;
import lesson06a.figure.BoundedRectangle;
// まずはBoundedRectangleクラスを作成すること。

public class TestBoundedRectangle {
    public static void main(String[] args) {
        BoundedRectangle.printMaxSize();
        BoundedRectangle rect1 = new BoundedRectangle(0, 0, 80, 30);
        rect1.showState();
        rect1.twice();
        rect1.showState();
        rect1.twice(); // この拡大は実行されないはず
        rect1.showState();
        BoundedRectangle rect2 = new BoundedRectangle(0, 0, 150, 80);
        rect2.showState();
        rect2.twice(); // この拡大は実行されないはず
        rect2.showState();
        BoundedRectangle.printObjNumber();
    }
}
