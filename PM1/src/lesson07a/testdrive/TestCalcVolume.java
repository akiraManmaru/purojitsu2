package lesson07a.testdrive;

import lesson07a.figure.BodyType;
import lesson07a.figure.BottomType;
import lesson07a.figure.CalcVolume;

public class TestCalcVolume {

	public static void main(String[] args) {

		//		CalcVolume calcvolume = new CalcVolume(CalcVolume.RECTANGLE, CalcVolume.PRISM, 10, 5, 3, 5, 2);
		//		System.out.printf("体積は%d\n", calcvolume.calculation());
		//
		//		calcvolume = new CalcVolume(CalcVolume.CIRCLE, CalcVolume.PYRAMIDAL, 10, 5, 3, 5, 0);
		//		System.out.printf("体積は%d\n", calcvolume.calculation());

		CalcVolume calcvolume = new CalcVolume(BottomType.RECTANGLE, BodyType.PRISM, 10, 5, 3, 5, 2);

		System.out.printf("この%sの体積は%d\n", BodyType.PRISM.toString(), calcvolume.calculation());
		calcvolume = new CalcVolume(BottomType.CIRCLE, BodyType.PYRAMIDAL, 10, 5, 3, 5, 0);

		System.out.printf("この%sの体積は%d\n", BodyType.PYRAMIDAL.toString(), calcvolume.calculation());
	}
}
