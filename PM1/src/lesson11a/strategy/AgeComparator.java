package lesson11a.strategy;

public class AgeComparator implements CompareType{
	public void compare(Unit unt1, Unit unt2){
		if( unt1.getStatus().getAge() > unt2.getStatus().getAge() ){
			System.out.println(unt1.getStatus().getName() + "は" + unt2.getStatus().getName() + "より年上です。");
		}else if(unt1.getStatus().getAge() == unt2.getStatus().getAge() ){
			System.out.println(unt1.getStatus().getName() + "と" + unt2.getStatus().getName() +"は同じ年齢です。");
		}else{
			System.out.println(unt1.getStatus().getName() + "は" + unt2.getStatus().getName() + "より年下です。");
		}	            
	}
}
