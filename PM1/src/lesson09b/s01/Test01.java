package lesson09b.s01;

public class Test01 {

	public static void main(String[] args) {
		EllipticalCone ellipticalCone = new EllipticalCone(5.0, 3.0, 2.0);
		System.out.println("楕円錐の体積=" + ellipticalCone.getVolume());
		EllipticalCylinder ellipticalCylinder = new EllipticalCylinder(4.0, 4.0, 3.0);
		System.out.println("楕円柱の体積=" + ellipticalCylinder.getVolume());
		RectangularPyramid rectangularPyramid = new RectangularPyramid(3.0, 4.0, 5.0);
		System.out.println("四角錐の体積=" + rectangularPyramid.getVolume());
		RectangularCylinder rectangularCylinder = new RectangularCylinder(3.0, 4.0, 5.0);
		System.out.println("四角柱の体積=" + rectangularCylinder.getVolume());
	}
}