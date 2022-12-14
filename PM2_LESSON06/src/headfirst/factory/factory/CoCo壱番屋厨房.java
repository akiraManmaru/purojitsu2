package headfirst.factory.factory;

import java.util.*;

import headfirst.factory.curry.ingredient.*;

/**
 * CoCo壱番屋厨房　　  　 
 */
public class CoCo壱番屋厨房 extends カレー店厨房 
{

	public サイズ setSize() {
		return new 普通();
	}

	public ルー setRoux() {
		return new 辛口();
	}

	public List<カツ> setCutlet() {
		return new ArrayList<カツ>(Arrays.asList(new ポークカツ()));
	}

	public List<野菜> setVeggies() {
		return new ArrayList<野菜>(Arrays.asList(new ほうれん草(), new ナス()));
	}

	public List<シーフード> setSeafood() {
		return new ArrayList<シーフード>(Arrays.asList(new エビ(), new イカ()));
	}

	public スペシャル setSpecial() {
		return new 納豆();
	}
	
	public 卵 setEgg() {
		return null;
	}
	
	
}
