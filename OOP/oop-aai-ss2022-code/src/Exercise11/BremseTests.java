import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class BremseTests {

	@Test
	void testForHierarchy() throws NoSuchMethodException {
		// Bremse muss eine abstrakte Klasse sein
		assertFalse(Bremse.class.isInterface());
		assertTrue(Modifier.isAbstract(Bremse.class.getModifiers()));

		// ...mit zwei String Attributen
		int nstr = 0;
		for (Field f : Bremse.class.getDeclaredFields()) {
			// must be string _and_ private
			if (f.getType().equals(String.class) && Modifier.isPrivate(f.getModifiers()))
				nstr++;
		}
		assertEquals(2, nstr);

		// ...welche über einen entsprechenden Konstruktor gesetzt werden.
		assertNotNull(Bremse.class.getConstructor(String.class, String.class));

		// ...und `bremsen()` als abstrakte Methode ohne Argumente vorschreibt.
		Method bremsen = Bremse.class.getMethod("bremsen");
		assertTrue(Modifier.isAbstract(bremsen.getModifiers()));
		assertEquals(0, bremsen.getParameterCount());

		// ...ebenso brauchtService()
		Method service = Bremse.class.getMethod("brauchtService");
		assertTrue(Modifier.isAbstract(service.getModifiers()));
		assertEquals(0, service.getParameterCount());

		// Alle Bremsarten müssen nun von Bremse abgeleitet sein.
		assertEquals(Cantileverbremse.class.getSuperclass(), Bremse.class);
		assertEquals(Scheibenbremse.class.getSuperclass(), Bremse.class);
		assertEquals(Trommelbremse.class.getSuperclass(), Bremse.class);
	}
}
