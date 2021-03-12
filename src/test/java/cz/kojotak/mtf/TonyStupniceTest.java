package cz.kojotak.mtf;

import static cz.kojotak.mtf.NazevTonu.A;
import static cz.kojotak.mtf.NazevTonu.C;
import static cz.kojotak.mtf.NazevTonu.D;
import static cz.kojotak.mtf.NazevTonu.E;
import static cz.kojotak.mtf.NazevTonu.F;
import static cz.kojotak.mtf.NazevTonu.G;
import static cz.kojotak.mtf.NazevTonu.H;
import static cz.kojotak.mtf.Posuvka.BECKO;
import static cz.kojotak.mtf.Posuvka.KRIZEK;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class TonyStupniceTest {

	@Test
	void cDur() {
		Stupnice cdur = new Stupnice(new Ton(C), IntervalyStupnice.DUROVA);
		assertContainsAll(cdur.getTonyStupnice(), new Ton(C), new Ton(D), new Ton(E), new Ton(F), new Ton(G), new Ton(A), new Ton(H)  );
	}
	
	@Test
	void aMoll() {
		Stupnice amoll = new Stupnice(new Ton(A), IntervalyStupnice.MOLLOVA);
		assertContainsAll(amoll.getTonyStupnice(), new Ton(C), new Ton(D), new Ton(E), new Ton(F), new Ton(G), new Ton(A), new Ton(H)  );
	}
	
	@Test
	void cDurPentatonika() {
		Stupnice cdur = new Stupnice(new Ton(C), IntervalyStupnice.PENTATONIKA_DUROVA);
		assertContainsAll(cdur.getTonyStupnice(), new Ton(C), new Ton(D), new Ton(E), new Ton(G), new Ton(A) );
	}
	
	@Test
	void cMollPentatonika() {
		Stupnice cmoll = new Stupnice(new Ton(C), IntervalyStupnice.PENTATONIKA_MOLLOVA);
		assertContainsAll(cmoll.getTonyStupnice(), new Ton(C), new Ton(E, BECKO), new Ton(F), new Ton(G), new Ton(H, BECKO) );
	}
	
	@Test
	void chromatickaStupnice() {
		Stupnice stupnice = new Stupnice(new Ton(C), IntervalyStupnice.CHROMATICKA);
		assertContainsAll(stupnice.getTonyStupnice(), new Ton(C), new Ton(C, KRIZEK), new Ton(D), new Ton(D, KRIZEK),
				new Ton(E), new Ton(F), new Ton(F, KRIZEK), new Ton(G), new Ton(G, KRIZEK),
				new Ton(A), new Ton(A, KRIZEK), new Ton(H) );
	}
	
	private void assertContainsAll(List<Ton> seznamTonu , Ton ...ocekavaneTony) {
		assertEquals( ocekavaneTony.length, seznamTonu.size() );
		for(int i = 0; i < ocekavaneTony.length; i++) {
			Ton testovany = seznamTonu.get(i);
			Ton ocekavany = ocekavaneTony[i];
			assertEquals(ocekavany, testovany);
		}
	}

}
