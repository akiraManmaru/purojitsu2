package lesson06a.testdrive;

import lesson06a.figure.UniqueCircle;
// (1)まずはUniqueCircleクラスを作成すること。

public class TestUniqueCircle {
	public static void main(String[] args) {

		// UniqueCircle instance = new UniqueCircle();
		// (2)上のコメントアウトを外すと、エラーになることを確認すること。
		// (3)クラスUniqueCircleのメソッドgetInstance()の
		// 修飾子staticを取り除くとエラーとなることを確認すること。
		UniqueCircle instance1 = UniqueCircle.getInstance();
		instance1.showState();
		instance1.move(2, 3);
		instance1.showState();
		instance1 = null;
		// 通常は、どこからも参照されないオブジェクトは消滅する。
		// しかし、UniqueCircle.instanceがオブジェクトを参照しているので、オブジェクトが消滅しない。
		UniqueCircle instance2 = UniqueCircle.getInstance();
		instance2.showState();
		// instance1が参照していたオブジェクトをinstance2も
		// 参照しているので、showState()で表示される出力が同じになる。
	}
}
