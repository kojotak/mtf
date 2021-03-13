package cz.kojotak.mtf;

import static cz.kojotak.mtf.NazevTonu.C;
import static cz.kojotak.mtf.NazevTonu.E;
import static cz.kojotak.mtf.NazevTonu.G;
import static cz.kojotak.mtf.NazevTonu.H;
import static cz.kojotak.mtf.Posuvka.BECKO;
import static cz.kojotak.mtf.TestUtils.assertContainsAll;

import org.junit.jupiter.api.Test;

public class TonyAkorduTest {

	@Test
	void c() {
		Akord cdur = new Akord(new Ton(C), IntervalyAkordu.KVINTAKORD_DUROVY);
		assertContainsAll(cdur.getTonyAkordu(), new Ton(C), new Ton(E), new Ton(G) );
	}
	
	@Test
	void cMoll() {
		Akord cmoll = new Akord(new Ton(C), IntervalyAkordu.KVINTAKORD_MOLLOVY);
		assertContainsAll(cmoll.getTonyAkordu(), new Ton(C), new Ton(E, BECKO), new Ton(G) );
	}
	
	@Test
	void c7() {
		Akord cdur = new Akord(new Ton(C), IntervalyAkordu.SEPTAKORD_DOMINANTNI);
		assertContainsAll(cdur.getTonyAkordu(), new Ton(C), new Ton(E), new Ton(G), new Ton(H, BECKO) );
	}

	@Test
	void c7maj() {
		Akord cdur = new Akord(new Ton(C), IntervalyAkordu.SEPTAKORD_VELKY);
		assertContainsAll(cdur.getTonyAkordu(), new Ton(C), new Ton(E), new Ton(G), new Ton(H) );
	}
	
	@Test
	void cmi7() {
		Akord cdur = new Akord(new Ton(C), IntervalyAkordu.SEPTAKORD_MALY_MOLLOVY);
		assertContainsAll(cdur.getTonyAkordu(), new Ton(C), new Ton(E, BECKO), new Ton(G), new Ton(H, BECKO) );
	}
	
	@Test
	void cmi7maj() {
		Akord cdur = new Akord(new Ton(C), IntervalyAkordu.SEPTAKORD_VELKY_MOLLOVY);
		assertContainsAll(cdur.getTonyAkordu(), new Ton(C), new Ton(E, BECKO), new Ton(G), new Ton(H) );
	}
}
