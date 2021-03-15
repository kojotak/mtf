package cz.kojotak.mtf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static cz.kojotak.mtf.TypIntervalu.*;
public class PultonyIntervalechTest {

	@MethodSource
	@ParameterizedTest
	void pultonyVIntervalu(int ocekavanychPultonu, Interval interval) {
		assertEquals(ocekavanychPultonu, interval.getPultonu());
	}
	
	private static Stream<Arguments> pultonyVIntervalu() {
	    return Stream.of(
	    		
	      Arguments.of(0, Interval.PRIMA),
	      
	      Arguments.of(1, Interval.SEKUNDA_MALA),
	      Arguments.of(1, Interval.SEKUNDA_VELKA.zmensena()),
	      Arguments.of(1, Interval.TERCIE_MALA.zmensena().zmensena()),
	      Arguments.of(1, Interval.PRIMA.zvetsena()),
	      
	      Arguments.of(2, Interval.PRIMA.zvetsena().zvetsena()),
	      Arguments.of(2, Interval.SEKUNDA_MALA.zvetsena()),
	      Arguments.of(2, Interval.SEKUNDA_VELKA),
	      Arguments.of(2, Interval.TERCIE_MALA.zmensena()),
	      Arguments.of(2, Interval.TERCIE_VELKA.zmensena().zmensena()),
	      
	      Arguments.of(3, Interval.TERCIE_MALA),
	      Arguments.of(3, Interval.SEKUNDA_MALA.zvetsena().zvetsena()),
	      Arguments.of(3, Interval.SEKUNDA_VELKA.zvetsena()),
	      Arguments.of(3, Interval.KVARTA.zmensena().zmensena()),
	      
	      Arguments.of(4, Interval.TERCIE_VELKA),
	      Arguments.of(4, Interval.TERCIE_MALA.zvetsena()),
	      Arguments.of(4, Interval.SEKUNDA_VELKA.zvetsena().zvetsena()),
	      Arguments.of(4, Interval.KVARTA.zmensena()),
	      
	      Arguments.of(5, Interval.KVARTA),
	      Arguments.of(5, Interval.TERCIE_VELKA.zvetsena()),
	      Arguments.of(5, Interval.TERCIE_MALA.zvetsena().zvetsena()),
	      Arguments.of(5, Interval.KVINTA.zmensena().zmensena() ),
	      
	      //triton
	      Arguments.of(6, Interval.KVARTA.zvetsena() ),
	      Arguments.of(6, Interval.TERCIE_VELKA.zvetsena().zvetsena()),
	      Arguments.of(6, Interval.KVINTA.zmensena() ),
	      Arguments.of(6, Interval.SEXTA_MALA.zmensena().zmensena()),
	      
	      Arguments.of(7, Interval.KVINTA),
	      Arguments.of(7, Interval.KVARTA.zvetsena().zvetsena() ),
	      Arguments.of(7, Interval.SEXTA_MALA.zmensena() ),
	      Arguments.of(7, Interval.SEXTA_VELKA.zmensena().zmensena()),
	      
	      Arguments.of(8, Interval.SEXTA_MALA),
	      Arguments.of(8, Interval.SEXTA_VELKA.zmensena()),
	      Arguments.of(8, Interval.SEPTIMA_MALA.zmensena().zmensena()),
	      Arguments.of(8, Interval.KVINTA.zvetsena()),
	      
	      Arguments.of(9, Interval.SEXTA_VELKA),
	      Arguments.of(9, Interval.SEXTA_MALA.zvetsena()),
	      Arguments.of(9, Interval.KVINTA.zvetsena().zvetsena()),
	      Arguments.of(9, Interval.SEPTIMA_MALA.zmensena()),
	      Arguments.of(9, Interval.SEPTIMA_VELKA.zmensena().zmensena()),
	      
	      Arguments.of(10, Interval.SEPTIMA_MALA),
	      Arguments.of(10, Interval.SEPTIMA_VELKA.zmensena()),
	      Arguments.of(10, Interval.OKTAVA.zmensena().zmensena()),
	      Arguments.of(10, Interval.SEXTA_VELKA.zvetsena()),
	      Arguments.of(10, Interval.SEXTA_MALA.zvetsena().zvetsena()),
	      
	      Arguments.of(11, Interval.SEPTIMA_VELKA),
	      Arguments.of(11, Interval.SEPTIMA_MALA.zvetsena()),
	      Arguments.of(11, Interval.SEXTA_VELKA.zvetsena().zvetsena()),
	      Arguments.of(11, Interval.OKTAVA.zmensena()),
	      
	      Arguments.of(12, Interval.OKTAVA),
	      Arguments.of(12, Interval.SEPTIMA_VELKA.zvetsena()),
	      Arguments.of(12, Interval.SEPTIMA_MALA.zvetsena().zvetsena()),
	      
	      Arguments.of(13, new Interval(NazevIntervalu.NONA, MALY)),
	      Arguments.of(14, new Interval(NazevIntervalu.NONA, VELKY)),
	      Arguments.of(15, new Interval(NazevIntervalu.DECIMA, MALY)),
	      Arguments.of(16, new Interval(NazevIntervalu.DECIMA, VELKY)),
	      Arguments.of(17, new Interval(NazevIntervalu.UNDECIMA)),
	      Arguments.of(19, new Interval(NazevIntervalu.DUODECIMA)),
	      Arguments.of(20, new Interval(NazevIntervalu.TERCDECIMA, MALY)),
	      Arguments.of(21, new Interval(NazevIntervalu.TERCDECIMA, VELKY)),
	      Arguments.of(22, new Interval(NazevIntervalu.KVARTDECIMA, MALY)),
	      Arguments.of(23, new Interval(NazevIntervalu.KVARTDECIMA, VELKY)),
	      Arguments.of(24, new Interval(NazevIntervalu.KVINTDECIMA, VELKY))
		);
	}
}
