package lesson03.exam5;

/**
 * IStackインターフェースを実装するMyStackクラス
 */
public class MyStack<T> implements IStack<T> {

	/**
	 * スタック内の1つの要素を定義するための内部クラス
	 */
	private class StackData{
		/**
		 * この要素に保持されているデータ
		 */
		private T data;
		/**
		 * 次の要素
		 */
		private StackData next;
		/**
		 * コンストラクタ
		 * @param data 要素に保持させるデータ
		 */
		public StackData(T data) {
			this.data = data;
			next = null;
		}
		/**
		 * この要素が現在保持しているデータを取得するためのゲッター
		 * @return 要素が保持しているデータ
		 */
		public T getData() {
			return data;
		}
		/**
		 * 次の要素を設定するセッター
		 * @param arg 次の要素
		 */
		public void setNext(StackData arg) {
			next = arg;
		}
		/**
		 * 次の要素を取得するためにゲッター
		 * @return 次の要素
		 */
		public StackData getNext() {
			return next;
		}
	}

	/**
	 * スタックの先頭の要素
	 */
	private StackData root;

	/**
	 * コンストラクタ
	 */
	public MyStack() {
		// 先頭の要素をnullで初期化
		root = null;
	}

	/**
	 * 与えられたデータをもつ要素を先頭に追加する
	 * @param arg 追加する要素
	 */
	@Override
	public void push(T arg) {
		StackData sTmp = new StackData(arg);
		sTmp.setNext(root);
		root = sTmp;
	}

	/**
	 * 先頭の要素のデータを取り出し、先頭の要素を削除する
	 * @return 先頭の要素のデータ
	 */
	@Override
	public T pop() {
		if (root == null) return null;
		T ret = root.getData();
		// 先頭の要素を次の要素とする
		// 参照されなくなった「以前の先頭の要素」は、
		// ガーベッジコレクターが自動で解放してくれる
		root = root.getNext();
		return ret;
	}

	/**
	 * 全要素を削除する
	 */
	@Override
	public void clear() {
		// rootをnullにすれば、全要素は、参照されなくなり、
		// ガーベッジコレクターによって自動で解放される
		root = null;
	}

}
