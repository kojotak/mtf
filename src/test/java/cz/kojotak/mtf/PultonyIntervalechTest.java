package cz.kojotak.mtf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static cz.kojotak.mtf.TypIntervalu.*;
public class PultonyIntervalechTest {

	@MethodSource
	@ParameterizedTest(name="{index} {1} ma {0} pultonu")
	void pultonyVIntervalu(int ocekavanychPultonu, Interval interval) {
		assertEquals(ocekavanychPultonu, interval.getPultonu());
	}
	
	private static Stream<Arguments> pultonyVIntervalu() {
	    return Stream.of(
	    		
	      Arguments.of(0, Interval.PRIMA),
	      
	      Arguments.of(1, Interval.SEKUNDA_MALA),
	      Arguments.of(1, Interval.SEKUNDA_VELKA.zmensit()),
	      Arguments.of(1, Interval.TERCIE_MALA.zmensit().zmensit()),
	      Arguments.of(1, Interval.PRIMA.zvetsit()),
	      
	      Arguments.of(2, Interval.PRIMA.zvetsit().zvetsit()),
	      Arguments.of(2, Interval.SEKUNDA_MALA.zvetsit()),
	      Arguments.of(2, Interval.SEKUNDA_VELKA),
	      Arguments.of(2, Interval.TERCIE_MALA.zmensit()),
	      Arguments.of(2, Interval.TERCIE_VELKA.zmensit().zmensit()),
	      
	      Arguments.of(3, Interval.TERCIE_MALA),
	      Arguments.of(3, Interval.SEKUNDA_MALA.zvetsit().zvetsit()),
	      Arguments.of(3, Interval.SEKUNDA_VELKA.zvetsit()),
	      Arguments.of(3, Interval.KVARTA.zmensit().zmensit()),
	      
	      Arguments.of(4, Interval.TERCIE_VELKA),
	      Arguments.of(4, Interval.TERCIE_MALA.zvetsit()),
	      Arguments.of(4, Interval.SEKUNDA_VELKA.zvetsit().zvetsit()),
	      Arguments.of(4, Interval.KVARTA.zmensit()),
	      
	      Arguments.of(5, Interval.KVARTA),
	      Arguments.of(5, Interval.TERCIE_VELKA.zvetsit()),
	      Arguments.of(5, Interval.TERCIE_MALA.zvetsit().zvetsit()),
	      Arguments.of(5, Interval.KVINTA.zmensit().zmensit() ),
	      
	      //triton
	      Arguments.of(6, Interval.KVARTA.zvetsit() ),
	      Arguments.of(6, Interval.TERCIE_VELKA.zvetsit().zvetsit()),
	      Arguments.of(6, Interval.KVINTA.zmensit() ),
	      Arguments.of(6, Interval.SEXTA_MALA.zmensit().zmensit()),
	      
	      Arguments.of(7, Interval.KVINTA),
	      Arguments.of(7, Interval.KVARTA.zvetsit().zvetsit() ),
	      Arguments.of(7, Interval.SEXTA_MALA.zmensit() ),
	      Arguments.of(7, Interval.SEXTA_VELKA.zmensit().zmensit()),
	      
	      Arguments.of(8, Interval.SEXTA_MALA),
	      Arguments.of(8, Interval.SEXTA_VELKA.zmensit()),
	      Arguments.of(8, Interval.SEPTIMA_MALA.zmensit().zmensit()),
	      Arguments.of(8, Interval.KVINTA.zvetsit()),
	      
	      Arguments.of(9, Interval.SEXTA_VELKA),
	      Arguments.of(9, Interval.SEXTA_MALA.zvetsit()),
	      Arguments.of(9, Interval.KVINTA.zvetsit().zvetsit()),
	      Arguments.of(9, Interval.SEPTIMA_MALA.zmensit()),
	      Arguments.of(9, Interval.SEPTIMA_VELKA.zmensit().zmensit()),
	      
	      Arguments.of(10, Interval.SEPTIMA_MALA),
	      Arguments.of(10, Interval.SEPTIMA_VELKA.zmensit()),
	      Arguments.of(10, Interval.OKTAVA.zmensit().zmensit()),
	      Arguments.of(10, Interval.SEXTA_VELKA.zvetsit()),
	      Arguments.of(10, Interval.SEXTA_MALA.zvetsit().zvetsit()),
	      
	      Arguments.of(11, Interval.SEPTIMA_VELKA),
	      Arguments.of(11, Interval.SEPTIMA_MALA.zvetsit()),
	      Arguments.of(11, Interval.SEXTA_VELKA.zvetsit().zvetsit()),
	      Arguments.of(11, Interval.OKTAVA.zmensit()),
	      
	      Arguments.of(12, Interval.OKTAVA),
	      Arguments.of(12, Interval.SEPTIMA_VELKA.zvetsit()),
	      Arguments.of(12, Interval.SEPTIMA_MALA.zvetsit().zvetsit()),
	      
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
