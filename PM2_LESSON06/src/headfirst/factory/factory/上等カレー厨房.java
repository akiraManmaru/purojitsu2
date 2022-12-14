package headfirst.factory.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import headfirst.factory.curry.ingredient.ゆで卵;
import headfirst.factory.curry.ingredient.カキフライ;
import headfirst.factory.curry.ingredient.カツ;
import headfirst.factory.curry.ingredient.サイズ;
import headfirst.factory.curry.ingredient.シーフード;
import headfirst.factory.curry.ingredient.スペシャル;
import headfirst.factory.curry.ingredient.チキンカツ;
import headfirst.factory.curry.ingredient.チーズ;
import headfirst.factory.curry.ingredient.フィッシュフライ;
import headfirst.factory.curry.ingredient.ポークカツ;
import headfirst.factory.curry.ingredient.ルー;
import headfirst.factory.curry.ingredient.卵;
import headfirst.factory.curry.ingredient.季節野菜;
import headfirst.factory.curry.ingredient.普通;
import headfirst.factory.curry.ingredient.激辛;
import headfirst.factory.curry.ingredient.野菜;

public class 上等カレー厨房 extends カレー店厨房 {
	public サイズ setSize() {
		return new 普通();
	}

	public ルー setRoux() {
		return new 激辛();
	}

	public List<カツ> setCutlet() {
		return new ArrayList<カツ>(Arrays.asList(new ポークカツ(), new チキンカツ()));
	}

	public List<野菜> setVeggies() {
		return new ArrayList<野菜>(Arrays.asList(new 季節野菜()));
	}

	public List<シーフード> setSeafood() {
		return new ArrayList<シーフード>(Arrays.asList(new フィッシュフライ(), new カキフライ()));
	}

	public スペシャル setSpecial() {
		return new チーズ();
	}

	public 卵 setEgg() {
		return new ゆで卵();
	}

}
