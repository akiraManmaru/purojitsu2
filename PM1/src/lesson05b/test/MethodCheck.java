package lesson05b.test;


import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodCheck {
	private String name;
	private Class<?> returnType;
	private Class<?>[] argTypes;
	private int accessor;
	private boolean isStatic;
	
	public MethodCheck(String name, Class<?> returnType, Class<?>[] argTypes, int accessor, boolean isStatic) {
		this.name = name;
		this.returnType = returnType;
		this.argTypes = argTypes;
		this.accessor = accessor;
		this.isStatic = isStatic;
	}
	
	public static Method getMethod(Class<?> c, String name, Class<?>[] argTypes) {
		Method ret = null;
		try {
			ret = c.getDeclaredMethod(name, argTypes);
		} catch (NoSuchMethodException e) {
			System.out.println(c.getName() + " " + name);

		}

		return ret;
	}


	public boolean isExisit(Class<?> c) {
		boolean ret = true;
		try {
			c.getDeclaredMethod(name, argTypes);
		} catch (NoSuchMethodException e) {
			ret = false;
		}
		return ret;
	}
	
	public boolean isCorrectReturnType(Class<?> c) {
		boolean ret = false;
		try {
			Method m = c.getDeclaredMethod(name, argTypes);
			ret = (m.getReturnType() == returnType);				
		} catch (NoSuchMethodException e) {
		}
		return ret;
	}

	public boolean isCorrectAccessor(Class<?> c) {
		boolean ret = true;
		try {
			Method m = c.getDeclaredMethod(name, argTypes);
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
	
	public boolean isAbstract(Class<?> c) {
		boolean ret = false;
		try {
			Method m = c.getDeclaredMethod(name, argTypes);
			ret = Modifier.isAbstract(m.getModifiers());
		} catch (NoSuchMethodException e) {
		}
		return ret;
		
	}
	
	public boolean isCorrectStatic(Class<?> c) {
		boolean ret = false;
		try {
			Method m = c.getDeclaredMethod(name, argTypes);
			ret = (isStatic == Modifier.isStatic(m.getModifiers()));
		} catch (NoSuchMethodException e) {
		}
		return ret;
	}
	public String getName() {
		return name;
	}
}
