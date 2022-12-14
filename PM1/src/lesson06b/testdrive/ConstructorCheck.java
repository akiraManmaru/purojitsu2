package lesson06b.testdrive;


import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class ConstructorCheck {
	private Class<?>[] argTypes;
	private int accessor;
	
	public ConstructorCheck(Class<?>[] argTypes, int accessor) {
		this.argTypes = argTypes;
		this.accessor = accessor;
	}
	
	public static Constructor<?> getConstructor(Class<?> c, Class<?>[] argTypes) {
		Constructor<?>  ret = null;
		try {
			ret = c.getDeclaredConstructor(argTypes);
		} catch (NoSuchMethodException e) {
		}
		return ret;
	}
	
	public boolean isExisit(Class<?> c) {
		boolean ret = true;
		try {
			c.getDeclaredConstructor(argTypes);
		} catch (NoSuchMethodException e) {
			ret = false;
		}
		return ret;
	}

	public boolean isCorrectAccessor(Class<?> c) {
		boolean ret = true;
		try {
			Constructor<?> m = c.getDeclaredConstructor(argTypes);
			if (accessor == Modifier.PRIVATE) {
				ret = Modifier.isPrivate(m.getModifiers());
			}
			else if (accessor == Modifier.PUBLIC) {
				ret = Modifier.isPublic(m.getModifiers());
			}
			else if (accessor == Modifier.PROTECTED) {
				ret = Modifier.isProtected(m.getModifiers());
			}
			else {
				if (Modifier.isPrivate(m.getModifiers())) {
					ret = false;
				}
				else if (Modifier.isPublic(m.getModifiers())) {
					ret = false;
				}
				else if (Modifier.isProtected(m.getModifiers())) {
					ret = false;
				}
			}
		} catch (NoSuchMethodException e) {
			ret = false;
		}
		return ret;
	}


}
