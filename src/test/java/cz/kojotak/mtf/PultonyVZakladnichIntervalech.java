package cz.kojotak.mtf;

import static cz.kojotak.mtf.TypIntervalu.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static cz.kojotak.mtf.NazevIntervalu.*;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PultonyVZakladnichIntervalech {

	@MethodSource
	@ParameterizedTest
	void pultonyVIntervalu(int ocekavanychPultonu, ZakladniInterval interval) {
		assertEquals(ocekavanychPultonu, interval.getPultonu());
	}

	private static Stream<Arguments> pultonyVIntervalu() {
	    return Stream.of(
	      Arguments.of(0, ZakladniInterval.PRIMA),
	      Arguments.of(1, ZakladniInterval.SEKUNDA_MALA),
	      Arguments.of(2, ZakladniInterval.SEKUNDA_VELKA),
	      Arguments.of(3, ZakladniInterval.TERCIE_MALA),
	      Arguments.of(4, ZakladniInterval.TERCIE_VELKA),
	      Arguments.of(5, ZakladniInterval.KVARTA),
	      
	      //triton
	      Arguments.of(6, new ZakladniInterval( KVARTA, ZVETSENA)),
	      Arguments.of(6, new ZakladniInterval( KVINTA, TypIntervalu.ZMENSENA )),
	      
	      Arguments.of(7, ZakladniInterval.KVINTA),
	      Arguments.of(8, ZakladniInterval.SEXTA_MALA),
	      Arguments.of(9, ZakladniInterval.SEXTA_VELKA),
	      Arguments.of(10, ZakladniInterval.SEPTIMA_MALA),
	      Arguments.of(11, ZakladniInterval.SEPTIMA_VELKA),
	      Arguments.of(12, ZakladniInterval.OKTAVA)
		);
	}
}
