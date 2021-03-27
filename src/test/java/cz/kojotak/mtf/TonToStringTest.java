package cz.kojotak.mtf;

import static cz.kojotak.mtf.NazevOktavy.*;
import static cz.kojotak.mtf.NazevTonu.*;
import static cz.kojotak.mtf.Posuvka.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TonToStringTest {

	@Test
	void velkeG() {
		assertEquals("G", new Ton(G, VELKA).toString() );
	}
	
	@Test
	void velkeCis() {
		assertEquals("Cis", new Ton(C, KRIZEK, VELKA).toString() );
	}
	
	@Test
	void maleA() {
		assertEquals("a", new Ton(A, MALA).toString() );
	}
	
	@Test
	void maleSnizeneE() {
		assertEquals("es", new Ton(E, BECKO, MALA).toString() );
	}
	
	@Test
	void velkeSnizeneA() {
		assertEquals("As", new Ton(A, BECKO, VELKA).toString() );
	}
	
	@Test
	void maleHeses() {
		assertEquals("heses", new Ton(H, DVOJBECKO, MALA).toString());
	}
	
	@Test
	void eSubkontra() {
		assertEquals("E,,", new Ton(E, SUBKONTRA).toString() );
	}
	
	@Test
	void contraF() {
		assertEquals("F,", new Ton(F, KONTRA).toString() );
	}
	
	@Test
	void peticarkoveD() {
		assertEquals("d'''''", new Ton(D, PETICARKOVANA).toString() );
	}

	
}
