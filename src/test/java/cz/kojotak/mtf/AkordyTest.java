package cz.kojotak.mtf;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class AkordyTest {

	@Test
	void prvniObratkaCdur() {
		Akord cdur = new Akord(new Ton(NazevTonu.C), TypAkordu.KVINTAKORD_DUROVY);
		List<Ton> prvniObrat = cdur.obratit().getTonyAkordu();
		assertEquals(new Ton(NazevTonu.E), prvniObrat.get(0));
		assertEquals(new Ton(NazevTonu.G), prvniObrat.get(1));
		assertEquals(new Ton(NazevTonu.C), prvniObrat.get(2));
	}
	
	@Test
	void druhaObratkaCdur() {
		Akord cdur = new Akord(new Ton(NazevTonu.C), TypAkordu.KVINTAKORD_DUROVY);
		List<Ton> druhyObrat = cdur.obratit().obratit().getTonyAkordu();
		assertEquals(new Ton(NazevTonu.G), druhyObrat.get(0));
		assertEquals(new Ton(NazevTonu.C), druhyObrat.get(1));
		assertEquals(new Ton(NazevTonu.E), druhyObrat.get(2));
	}
	
	@Test
	void tretiObratkaCdur() {
		Akord cdur = new Akord(new Ton(NazevTonu.C), TypAkordu.KVINTAKORD_DUROVY);
		List<Ton> tonyCdur = cdur.getTonyAkordu();
		List<Ton> tretiObrat = cdur.obratit().obratit().obratit().getTonyAkordu();
		assertEquals(tonyCdur.get(0), tretiObrat.get(0));
		assertEquals(tonyCdur.get(1), tretiObrat.get(1));
		assertEquals(tonyCdur.get(2), tretiObrat.get(2));
	}

}
