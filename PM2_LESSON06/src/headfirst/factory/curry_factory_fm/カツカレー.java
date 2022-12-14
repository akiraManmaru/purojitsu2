package headfirst.factory.curry_factory_fm;

import java.util.*;

import headfirst.factory.curry.ingredient.*;

/**
 * カツカレー　　  　 
 */
public abstract class カツカレー extends カレー {
 
	abstract サイズ setSize();
	abstract ルー setRoux();
	abstract 卵 setEgg();
	abstract List<カツ> setCutlet();
	
	public カツカレー() {
	}
 
	public void prepare() {
		System.out.println(name + "の準備をします");
		size = setSize();
		roux = setRoux();
		egg = setEgg();
		cutlet = setCutlet();
	}
}
