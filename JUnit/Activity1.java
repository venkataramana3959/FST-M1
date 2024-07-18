package Activities;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class Activity1 {
	static ArrayList<String> list;

	@BeforeEach
	void setup() throws Exception {
		list = new ArrayList<>();
		list.add("Pavan");
		list.add("Abhi");

	}

	@Test
	void insertTest() {

		assertEquals(2, list.size(), "Wrong Size");
		list.add("Kishore");
		assertEquals(3, list.size(), "Wrong Size");

		assertEquals("Pavan", list.get(0), "Wrong name");
		assertEquals("Abhi", list.get(1), "Wrong name");
		assertEquals("Kishore", list.get(2), "Wrong name");

	}

	@Test
	void replaceTest() {
		assertEquals(2, list.size(), "Wrong Size");
		list.add("Kishore");
		assertEquals(3, list.size(), "Wrong Size");

		list.set(0, "Pavani");

		assertEquals("Pavani", list.get(0), "Wrong name");
		assertEquals("Abhi", list.get(1), "Wrong name");
		assertEquals("Kishore", list.get(2), "Wrong name");

	}
}
