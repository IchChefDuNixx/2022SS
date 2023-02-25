import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class VolumenTests {
	@Test
	void testHierarchie() throws NoSuchMethodException {

		// Volumen muss abstract sein
		assertFalse(Volumen.class.isInterface());
		assertTrue(Modifier.isAbstract(Volumen.class.getModifiers()));

		// ...und `double volumen()` ohne Argumente implementieren
		Method vol = Volumen.class.getDeclaredMethod("volumen");
		assertEquals(vol.getReturnType(), double.class);
		assertEquals(vol.getParameterCount(), 0);
		assertFalse(Modifier.isAbstract(vol.getModifiers()));

		// und muss eine abstrakte Methode haben, welche die Grundfläche implementiert
		Method abstr = null;
		for (Method m : Volumen.class.getDeclaredMethods()) {
			// nicht diese...
			if (m.getName().equals("volumen"))
				continue;

			// auch nicht diese...
			if (m.getParameterCount() > 0)
				continue;

			// Wir suchen: abstract [double|float] grundflaeche()
			if (Modifier.isAbstract(m.getModifiers()) &&
					(m.getReturnType().equals(double.class) || m.getReturnType().equals(float.class))) {
				// darf noch nicht gesetzt sein, wir brauchen genau eine Methode
				assertNull(abstr);
				abstr = m;
			}
		}
		assertNotNull(abstr);

		// andere Klassen muessen direkt erben und konkret sein (ergo grundflaeche implementieren)
		// aber volumen nicht ueberschreiben!
		assertEquals(DreiecksPrisma.class.getSuperclass(), Volumen.class);
		assertFalse(Modifier.isAbstract(DreiecksPrisma.class.getModifiers()));
		assertThrows(NoSuchMethodException.class, () -> DreiecksPrisma.class.getDeclaredMethod("volumen"));

		assertEquals(Quader.class.getSuperclass(), Volumen.class);
		assertFalse(Modifier.isAbstract(Quader.class.getModifiers()));
		assertThrows(NoSuchMethodException.class, () -> Quader.class.getDeclaredMethod("volumen"));

		assertEquals(Zylinder.class.getSuperclass(), Volumen.class);
		assertFalse(Modifier.isAbstract(Zylinder.class.getModifiers()));
		assertThrows(NoSuchMethodException.class, () -> Zylinder.class.getDeclaredMethod("volumen"));

		assertEquals(ZylindrischesRohr.class.getSuperclass(), Volumen.class);
		assertFalse(Modifier.isAbstract(ZylindrischesRohr.class.getModifiers()));
		assertThrows(NoSuchMethodException.class, () -> ZylindrischesRohr.class.getDeclaredMethod("volumen"));
	}

	@Test
	void testMathe() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		testMetheHilf(new DreiecksPrisma(1, 1, 1, 1), 0.433);
		testMetheHilf(new Quader(1, 1, 1), 1.0);
		testMetheHilf(new Zylinder(1,  1), Math.PI);
		testMetheHilf(new ZylindrischesRohr(2, 1, 1), 9.424);
	}

	void testMetheHilf(Object vol, double ref) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Method volumen = vol.getClass().getMethod("volumen");
		assertEquals(ref, (double) volumen.invoke(vol), 0.001);
	}

}
