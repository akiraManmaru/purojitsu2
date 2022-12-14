package lesson11a.strategy;

public class HitPointComparator implements CompareType{
	public void compare(Unit unt1, Unit unt2){
		if( unt1.getStatus().getHitPoint() > unt2.getStatus().getHitPoint() ){
			System.out.println(unt1.getStatus().getName() + "は" + unt2.getStatus().getName() + "よりヒットポイントが高いです。");
		}else if(unt1.getStatus().getHitPoint() == unt2.getStatus().getHitPoint() ){
			System.out.println(unt1.getStatus().getName() + "と" + unt2.getStatus().getName() +"は同じヒットポイントです。");
		}else{
			System.out.println(unt1.getStatus().getName() + "は" + unt2.getStatus().getName() + "よりヒットポイントが少ないです。");
		}	            
	}
}
