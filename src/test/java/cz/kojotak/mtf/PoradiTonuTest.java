package cz.kojotak.mtf;

import static cz.kojotak.mtf.NazevTonu.C;
import static cz.kojotak.mtf.NazevTonu.D;
import static cz.kojotak.mtf.NazevTonu.H;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
public class PoradiTonuTest {

	@Test
	void dalsiPoC() {
		assertEquals(D, C.dalsi());
	}
	
	@Test
	void predchoziPredC() {
		assertEquals(H, C.predchozi());
	}
	
	@Test
	void dalsiPoH() {
		assertEquals(C, H.dalsi());
	}

}
