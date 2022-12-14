package lesson06b.testdrive;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldCheck {
	private String name;
	private Class<?> type;
	private int accessor;
	private boolean isStatic;
	
	public FieldCheck(String name, Class<?> type, int accessor, boolean isStatic) {
		this.name = name;
		this.type = type;
		this.accessor = accessor;
		this.isStatic = isStatic;
	}
	
	public static Object getPrivateField(Object o, String fname) {
		Object ret = null;
		try {
			Field f = o.getClass().getDeclaredField(fname);
			f.setAccessible(true);
			ret = f.get(o);
		} catch (NoSuchFieldException e) {
		} catch (IllegalAccessException e) {
		}

		return ret;
	}

	public static Object getSuperClassPrivateField(Object o, String fname) {
		Object ret = null;
		try {
			Field f = o.getClass().getSuperclass().getDeclaredField(fname);
			f.setAccessible(true);
			ret = f.get(o);
		} catch (NoSuchFieldException e) {
			System.out.println("c");
		} catch (IllegalAccessException e) {
			System.out.println("b");
		}

		return ret;
	}

	public static boolean setPrivateField(Object o, String fname, Object val) {
		boolean ret = true;
		try {
			Field f = o.getClass().getDeclaredField(fname);
			f.setAccessible(true);
			f.set(o, val);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			ret = false;
		}
		return ret;
	}

	public static boolean setSuperClassPrivateField(Object o, String fname, Object val) {
		boolean ret = true;
		try {
			Field f = o.getClass().getSuperclass().getDeclaredField(fname);
			f.setAccessible(true);
			f.set(o, val);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			ret = false;
		}
		return ret;
	}

	public boolean isExisit(Class<?> c) {
		boolean ret = true;
		try {
			c.getDeclaredField(name);
		} catch (NoSuchFieldException e) {
			ret = false;
		}
		return ret;
	}
	
	public boolean isCorrectType(Class<?> c) {
		boolean ret = false;
		try {
			Field f = c.getDeclaredField(name);
			ret = (f.getType() == type);				
		} catch (NoSuchFieldException e) {
			System.out.println(name);
		}
		return ret;
	}

	public boolean isCorrectAccessor(Class<?> c) {
		boolean ret = true;
		try {
			Field f = c.getDeclaredField(name);
			if (accessor == Modifier.PRIVATE) {
				ret = Modifier.isPrivate(f.getModifiers());
			}
			else if (accessor == Modifier.PUBLIC) {
				ret = Modifier.isPublic(f.getModifiers());
			}
			else if (accessor == Modifier.PROTECTED) {
				ret = Modifier.isProtected(f.getModifiers());
			}
			else {
				if (Modifier.isPrivate(f.getModifiers())) {
					ret = false;
				}
				else if (Modifier.isPublic(f.getModifiers())) {
					ret = false;
				}
				else if (Modifier.isProtected(f.getModifiers())) {
					ret = false;
				}
			}
		} catch (NoSuchFieldException e) {
			System.out.println("hi");
		}
		return ret;
	}
	
	public boolean isCorrectStatic(Class<?> c) {
		boolean ret = false;
		try {
			Field f = c.getDeclaredField(name);
			ret = (isStatic == Modifier.isStatic(f.getModifiers()));
		} catch (NoSuchFieldException e) {
		}
		return ret;
	}
	
	public String getName() {
		return name;
	}
}
