package headfirst.factory.curry_factory_fm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import headfirst.factory.curry.ingredient.サイズ;
import headfirst.factory.curry.ingredient.トマトアスパラ;
import headfirst.factory.curry.ingredient.ルー;
import headfirst.factory.curry.ingredient.卵;
import headfirst.factory.curry.ingredient.大盛り;
import headfirst.factory.curry.ingredient.完熟カットトマト;
import headfirst.factory.curry.ingredient.甘口;
import headfirst.factory.curry.ingredient.生卵;
import headfirst.factory.curry.ingredient.野菜;

public class ゴーゴー野菜カレー extends 野菜カレー {
	public ゴーゴー野菜カレー() {
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
	public List<野菜> setVeggies() {
		//ほうれん草とナス
		return new ArrayList<野菜>(Arrays.asList(new 完熟カットトマト(), new トマトアスパラ()));
	}

	@Override
	public 卵 setEgg() {
		return new 生卵();
	}

}
