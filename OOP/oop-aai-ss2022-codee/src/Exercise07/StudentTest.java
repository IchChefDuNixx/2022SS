
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
	@Test
	void testStudent() {
		Student s = new Student(123, "Hans");
		System.out.println(s);

		assertThrows(IllegalArgumentException.class, () -> s.setName(null));
		assertThrows(IllegalArgumentException.class, () -> s.setMatrikel(-3));
	}
}