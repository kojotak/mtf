package cz.kojotak.mtf;

import org.junit.jupiter.api.Test;

public class TonyAkorduTest extends TestovaciTony{

	@Test
	void c() {
		Akord cdur = new Akord(c, IntervalyAkordu.KVINTAKORD_DUROVY);
		assertContainsAll(cdur.getTonyAkordu(), c, e, g );
	}
	
	@Test
	void cMoll() {
		Akord cmoll = new Akord(c, IntervalyAkordu.KVINTAKORD_MOLLOVY);
		assertContainsAll(cmoll.getTonyAkordu(), c, es, g );
	}
	
	@Test
	void c7() {
		Akord cdur = new Akord(c, IntervalyAkordu.SEPTAKORD_DOMINANTNI);
		assertContainsAll(cdur.getTonyAkordu(), c, e, g, hes );
	}

	@Test
	void c7maj() {
		Akord cdur = new Akord(c, IntervalyAkordu.SEPTAKORD_VELKY);
		assertContainsAll(cdur.getTonyAkordu(), c, e, g, h );
	}
	
	@Test
	void cmi7() {
		Akord cdur = new Akord(c, IntervalyAkordu.SEPTAKORD_MALY_MOLLOVY);
		assertContainsAll(cdur.getTonyAkordu(), c, es, g, hes );
	}
	
	@Test
	void cmi7maj() {
		Akord cdur = new Akord(c, IntervalyAkordu.SEPTAKORD_VELKY_MOLLOVY);
		assertContainsAll(cdur.getTonyAkordu(), c, es, g, h );
	}
}
