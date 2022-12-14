package lesson03.exam5;

/**
 * スタックを定義するためのIStackインターフェース
 */
public interface IStack<T> {
	/**
	 * 与えられた要素を先頭に追加する
	 * @param arg 追加する要素
	 */
	public void push(T arg);
	/**
	 * 先頭の要素を取り出し削除する
	 * @return 先頭の要素
	 */
	public T pop();
	/**
	 * 全要素を削除する
	 */
	public void clear();
}
