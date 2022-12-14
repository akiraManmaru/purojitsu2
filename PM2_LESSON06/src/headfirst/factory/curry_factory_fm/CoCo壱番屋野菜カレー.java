package headfirst.factory.curry_factory_fm;

import java.util.*;

import headfirst.factory.curry.ingredient.*;

/**
 * CoCo壱番屋野菜カレー　　  　 
 */
public class CoCo壱番屋野菜カレー extends 野菜カレー {
	public CoCo壱番屋野菜カレー() {
	}

	@Override
	public サイズ setSize() {
		return new 普通();//普通サイズ
	}

	@Override
	public ルー setRoux() {
		return new 辛口();//Hot
	}

	@Override
	public List<野菜> setVeggies() {
		//ほうれん草とナス
		return new ArrayList<野菜>(Arrays.asList(new ほうれん草(), new ナス()));
	}

	@Override
	public 卵 setEgg() {
		return null;//卵は無し
	} 
}
