package cz.kojotak.mtf;


import static cz.kojotak.mtf.Posuvka.*;
import static cz.kojotak.mtf.Interval.*;
import static cz.kojotak.mtf.NazevOktavy.*;
import static cz.kojotak.mtf.NazevTonu.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TonoveIntervalyTest {

	@Test
	void velkaSekundaKVelkemuC() {
		assertEquals(new Ton(D, VELKA), new Ton(C, VELKA).pridejInterval(SEKUNDA_VELKA));
	}
	
	@Test
	void velkaSekundaKVelkemuH() {
		assertEquals(new Ton(C, KRIZEK, MALA), new Ton(H, VELKA).pridejInterval(SEKUNDA_VELKA));
	}
	
	@Test
	void oktavaKMalemuC() {
		assertEquals(new Ton(C, MALA), new Ton(C, VELKA).pridejInterval(OKTAVA));
	}
	
	@Test
	void primaNicNemeni() {
		assertEquals(new Ton(E, MALA), new Ton(E, MALA).pridejInterval(PRIMA));
	}
	
	@Test
	void zvetsiOPulTonMaleC() {
		assertEquals(new Ton(C, JEDNOCARKOVANA), new Ton(H, MALA).pridejInterval(SEKUNDA_MALA));
	}
	
	@Test
	void pultonBezPrechoduOktavy() {
		assertEquals(new Ton(G, Posuvka.KRIZEK, VELKA), new Ton(G, VELKA).pridejInterval(SEKUNDA_MALA));
	}

	@Test
	void velkaSekundZVelkehoD() {
		assertEquals(new Ton(C, VELKA), new Ton(D, VELKA).pridejInterval(SEKUNDA_VELKA.otocit()));
	}
	
	@Test
	void pultonNizeNezMaleC() {
		assertEquals(new Ton(H, VELKA), new Ton(C, MALA).pridejInterval(SEKUNDA_MALA.otocit()));
	}
}
