package headfirst.factory.curry_factory_fm;

import java.util.*;

import headfirst.factory.curry.ingredient.*;

/**
 * 野菜カレー　　  　 
 */
public abstract class 野菜カレー extends カレー {
 
	abstract サイズ setSize();
	abstract ルー setRoux();
	abstract 卵 setEgg();
	abstract List<野菜> setVeggies();
	
	public 野菜カレー() {
	}
 
	public void prepare() {
		System.out.println(name + "を下処理");
		size = setSize();
		roux = setRoux();
		egg = setEgg();
		veggies = setVeggies();
	}
}
