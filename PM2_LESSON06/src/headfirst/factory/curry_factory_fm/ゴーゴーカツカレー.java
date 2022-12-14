package headfirst.factory.curry_factory_fm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import headfirst.factory.curry.ingredient.カツ;
import headfirst.factory.curry.ingredient.サイズ;
import headfirst.factory.curry.ingredient.メンチカツ;
import headfirst.factory.curry.ingredient.ルー;
import headfirst.factory.curry.ingredient.卵;
import headfirst.factory.curry.ingredient.大盛り;
import headfirst.factory.curry.ingredient.甘口;
import headfirst.factory.curry.ingredient.生卵;

public class ゴーゴーカツカレー extends カツカレー {
	public ゴーゴーカツカレー() {
	}

	@Override
	public サイズ setSize() {
		return new 大盛り();//普通サイズ
	}

	@Override
	public ルー setRoux() {
		return new 甘口();//Hot
	}

	@Override
	public List<カツ> setCutlet() {
		//ポークカツ
		return new ArrayList<カツ>(Arrays.asList(new メンチカツ()));
	}

	@Override
	public 卵 setEgg() {
		return new 生卵();
	}

}
