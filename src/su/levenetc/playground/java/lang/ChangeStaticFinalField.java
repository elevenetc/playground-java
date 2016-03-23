package su.levenetc.playground.java.lang;

import su.levenetc.playground.java.utils.Out;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by eleven on 23/03/2016.
 */
public class ChangeStaticFinalField {
	public static void run() {

		Out.pln("before:" + X.value);

		try {
			setFinalStatic(X.class, "value", new B());
		} catch (Exception e) {
			Out.pln(e);
		}

		Out.pln("after:" + X.value);
	}

	private static class X {
		static final Object value = new A();
	}

	private static class A {

	}

	private static class B {

	}

	static void setFinalStatic(Class clazz, String fieldName, Object newValue) throws Exception {
		Field field = clazz.getDeclaredField(fieldName);
		field.setAccessible(true);

		Field modifiersField = Field.class.getDeclaredField("modifiers");
		modifiersField.setAccessible(true);
		modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

		field.set(null, newValue);
	}

}
