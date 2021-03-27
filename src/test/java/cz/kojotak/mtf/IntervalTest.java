package cz.kojotak.mtf;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static java.util.Collections.singletonList;
import static java.util.List.of;
import static cz.kojotak.mtf.Interval.*;
import static cz.kojotak.mtf.SmerIntervalu.*;
public class IntervalTest {

	@Test
	void obracenySmer() {
		assertEquals(VZESTUPNY, SESTUPNY.obraceny());
		assertEquals(SESTUPNY, VZESTUPNY.obraceny());
	}
	
	@Test
	void obracenaPrima() {
		assertEquals(OKTAVA, PRIMA.obratit());
	}

	@Test
	void obracenaKvarta() {
		assertEquals(KVINTA, KVARTA.obratit());
	}
	
	@Test
	void obracenaKvinta() {
		assertEquals(KVARTA, KVINTA.obratit());
	}
	
	@Test
	void obracenaMalaSekunda() {
		assertEquals(SEPTIMA_VELKA, SEKUNDA_MALA.obratit());
	}
	
	@Test
	void obracenaZvetsenaKvarta() {
		assertEquals(KVINTA_ZMENSENA, new Interval(NazevIntervalu.KVARTA, TypIntervalu.ZVETSENY).obratit());
	}
	
	@MethodSource
	@ParameterizedTest(name="{index} {0} ma tony: {1}")
	void stupneIntervalu(Stupen ocekavanyStupen, Collection<Interval> intervaly) {
		for(Interval interval : intervaly) {
			assertEquals(ocekavanyStupen, interval.getStupen());
		}
	}
	
	private static Stream<Arguments> stupneIntervalu() {
	    return Stream.of(	
	      Arguments.of(Stupen.I, singletonList(PRIMA)),
	      Arguments.of(Stupen.II, of(SEKUNDA_MALA, SEKUNDA_VELKA) ),
	      Arguments.of(Stupen.III, of(TERCIE_MALA, TERCIE_VELKA) ),
	      Arguments.of(Stupen.IV, singletonList(KVARTA) ),
	      Arguments.of(Stupen.V, singletonList(KVINTA) ),
	      Arguments.of(Stupen.VI, of(SEXTA_MALA, SEXTA_VELKA) ),
	      Arguments.of(Stupen.VII, of(SEPTIMA_MALA, SEPTIMA_VELKA) ),
	      Arguments.of(Stupen.VIII, singletonList(OKTAVA) )
	      );
	}
}
