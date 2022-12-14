package lesson03.exam5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ListAdapterの挙動を確認するためのテストドライブ
 */
public class Exam5TestDrive {
	public static void main(String[] arg) {

		/*
		 * スタックIStackインターフェースを実装するMyStackクラス
		 * （事前に実装済み）の挙動確認
		 * （スタックへの文字列の追加と取り出し、全文字列の削除）
		 */
		System.out.println("オリジナル");
		IStack<String> myStack = new MyStack<String>();
		myStack.push("おはようさん");
		myStack.push("こんにちは");
		myStack.push("こんばんは");
		String str;
		while((str = myStack.pop()) != null) {
			System.out.println(str);
		}
		myStack.push("おはようさん");
		myStack.push("こんにちは");
		myStack.clear();
		if (myStack.pop() == null) {
			System.out.println("データは削除されました");
		}

		/*
		 * ListApapterを用いて、ArrayListをIStackインターフェースに適応し、
		 * ArrayListを用いたIStackの挙動確認
		 * （スタックへの文字列の追加と取り出し、全文字列の削除）
		 */
		System.out.println("\nArrayList");
		List<String> list = new ArrayList<String>();
		IStack<String> listAdapter = new ListAdapter<String>(list);
		listAdapter.push("おはようさん");
		listAdapter.push("こんにちは");
		listAdapter.push("こんばんは");
		while((str = listAdapter.pop()) != null) {
			System.out.println(str);
		}
		listAdapter.push("おはようさん");
		listAdapter.push("こんにちは");
		listAdapter.clear();
		if (listAdapter.pop() == null) {
			System.out.println("データは削除されました");
		}

		/*
		 * ListApapterを用いて、LinkedListをIStackインターフェースに適応し、
		 * LinkedListを用いたIStackの挙動確認
		 * （スタックへの整数の追加と取り出し、全整数の削除）
		 */
		System.out.println("\nLinkedList");
		List<Integer>list2 = new LinkedList<Integer>();
		IStack<Integer> listAdapterInt = new ListAdapter<Integer>(list2);
		listAdapterInt.push(1);
		listAdapterInt.push(2);
		listAdapterInt.push(3);
		Integer i = 0;
		while((i = listAdapterInt.pop()) != null) {
			System.out.println(i);
		}
		listAdapterInt.push(1);
		listAdapterInt.push(2);
		listAdapterInt.clear();
		if (listAdapterInt.pop() == null) {
			System.out.println("データは削除されました");
		}
	}

}
