package headfirst.factory.factory;

import java.util.*;

import headfirst.factory.curry.ingredient.*;

/**
 * カレー店厨房　　  　 
 */
public abstract class カレー店厨房 {
 
	public abstract サイズ setSize();
	public abstract ルー setRoux();
	public abstract List<カツ> setCutlet();
	public abstract List<野菜> setVeggies();
	public abstract List<シーフード> setSeafood();
	public abstract スペシャル setSpecial();
	public abstract 卵 setEgg(); 
}
