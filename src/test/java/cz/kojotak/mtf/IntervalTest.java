package cz.kojotak.mtf;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static cz.kojotak.mtf.SmerIntervalu.*;
public class IntervalTest {

	@Test
	void obracenySmer() {
		assertEquals(VZESTUPNY, SESTUPNY.obraceny());
		assertEquals(SESTUPNY, VZESTUPNY.obraceny());
	}
	
	@Test
	void obracenaPrima() {
		assertEquals(Interval.OKTAVA, Interval.PRIMA.obratit());
	}

	@Test
	void obracenaKvarta() {
		assertEquals(Interval.KVINTA, Interval.KVARTA.obratit());
	}
	
	@Test
	void obracenaKvinta() {
		assertEquals(Interval.KVARTA, Interval.KVINTA.obratit());
	}
	
	@Test
	void obracenaMalaSekunda() {
		assertEquals(Interval.SEPTIMA_VELKA, Interval.SEKUNDA_MALA.obratit());
	}
	
	@Test
	void obracenaZvetsenaKvarta() {
		assertEquals(Interval.KVINTA_ZMENSENA, new Interval(NazevIntervalu.KVARTA, TypIntervalu.ZVETSENY).obratit());
	}
}
