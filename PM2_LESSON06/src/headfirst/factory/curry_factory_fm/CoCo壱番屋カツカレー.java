package headfirst.factory.curry_factory_fm;

import java.util.*;

import headfirst.factory.curry.ingredient.*;

/**
 * CoCo壱番屋カツカレー 　　  　 
 */
public class CoCo壱番屋カツカレー extends カツカレー {

	public CoCo壱番屋カツカレー() { 
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
	public List<カツ> setCutlet() {
		//ポークカツ
		return new ArrayList<カツ>(Arrays.asList(new ポークカツ()));
	}
	
	@Override
	public 卵 setEgg() {
		return null;//卵は無し
	}
		
}
