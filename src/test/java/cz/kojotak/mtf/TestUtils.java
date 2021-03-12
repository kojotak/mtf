package cz.kojotak.mtf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class TestUtils {

	public static void assertContainsAll(List<Ton> seznamTonu , Ton ...ocekavaneTony) {
		assertEquals( ocekavaneTony.length, seznamTonu.size() );
		for(int i = 0; i < ocekavaneTony.length; i++) {
			Ton testovany = seznamTonu.get(i);
			Ton ocekavany = ocekavaneTony[i];
			assertEquals(ocekavany, testovany);
		}
	}
}
