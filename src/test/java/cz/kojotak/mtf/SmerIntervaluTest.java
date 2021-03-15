package cz.kojotak.mtf;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static cz.kojotak.mtf.SmerIntervalu.*;
public class SmerIntervaluTest {

	@Test
	void obracenySmer() {
		assertEquals(VZESTUPNY, SESTUPNY.obraceny());
		assertEquals(SESTUPNY, VZESTUPNY.obraceny());
	}

}
