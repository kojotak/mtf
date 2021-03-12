package cz.kojotak.mtf;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static cz.kojotak.mtf.NazevOktavy.*;
public class RazeniOktavTest {

	@Test
	void dalsiOktavaKMale() {
		assertEquals(JEDNOCARKOVANA, MALA.dalsi());
	}
	
	@Test
	void predchoziOktavaKMale() {
		assertEquals(VELKA, MALA.predchozi());
	}
	
	@Test
	void posledniOktavaNemaDalsi() {
		NazevOktavy[] octaves = NazevOktavy.values();
		NazevOktavy posledni = octaves[octaves.length-1];
		assertThrows(IllegalStateException.class, () -> posledni.dalsi() );
	}
	
	@Test
	void prvniOktavaNemaPredchozi() {
		NazevOktavy prvni = NazevOktavy.values()[0];
		assertThrows(IllegalStateException.class, () -> prvni.predchozi() );
	}

}
