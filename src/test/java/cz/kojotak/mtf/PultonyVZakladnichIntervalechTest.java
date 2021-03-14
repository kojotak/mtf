package cz.kojotak.mtf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PultonyVZakladnichIntervalechTest {

	@MethodSource
	@ParameterizedTest
	void pultonyVIntervalu(int ocekavanychPultonu, ZakladniInterval interval) {
		assertEquals(ocekavanychPultonu, interval.getPultonu());
	}
	
	private static Stream<Arguments> pultonyVIntervalu() {
	    return Stream.of(
	    		
	      Arguments.of(0, ZakladniInterval.PRIMA),
	      
	      Arguments.of(1, ZakladniInterval.SEKUNDA_MALA),
	      Arguments.of(1, ZakladniInterval.SEKUNDA_VELKA.zmensena()),
	      Arguments.of(1, ZakladniInterval.TERCIE_MALA.zmensena().zmensena()),
	      Arguments.of(1, ZakladniInterval.PRIMA.zvetsena()),
	      
	      Arguments.of(2, ZakladniInterval.PRIMA.zvetsena().zvetsena()),
	      Arguments.of(2, ZakladniInterval.SEKUNDA_MALA.zvetsena()),
	      Arguments.of(2, ZakladniInterval.SEKUNDA_VELKA),
	      Arguments.of(2, ZakladniInterval.TERCIE_MALA.zmensena()),
	      Arguments.of(2, ZakladniInterval.TERCIE_VELKA.zmensena().zmensena()),
	      
	      Arguments.of(3, ZakladniInterval.TERCIE_MALA),
	      Arguments.of(3, ZakladniInterval.SEKUNDA_MALA.zvetsena().zvetsena()),
	      Arguments.of(3, ZakladniInterval.SEKUNDA_VELKA.zvetsena()),
	      Arguments.of(3, ZakladniInterval.KVARTA.zmensena().zmensena()),
	      
	      Arguments.of(4, ZakladniInterval.TERCIE_VELKA),
	      Arguments.of(4, ZakladniInterval.TERCIE_MALA.zvetsena()),
	      Arguments.of(4, ZakladniInterval.SEKUNDA_VELKA.zvetsena().zvetsena()),
	      Arguments.of(4, ZakladniInterval.KVARTA.zmensena()),
	      
	      Arguments.of(5, ZakladniInterval.KVARTA),
	      Arguments.of(5, ZakladniInterval.TERCIE_VELKA.zvetsena()),
	      Arguments.of(5, ZakladniInterval.TERCIE_MALA.zvetsena().zvetsena()),
	      Arguments.of(5, ZakladniInterval.KVINTA.zmensena().zmensena() ),
	      
	      //triton
	      Arguments.of(6, ZakladniInterval.KVARTA.zvetsena() ),
	      Arguments.of(6, ZakladniInterval.TERCIE_VELKA.zvetsena().zvetsena()),
	      Arguments.of(6, ZakladniInterval.KVINTA.zmensena() ),
	      Arguments.of(6, ZakladniInterval.SEXTA_MALA.zmensena().zmensena()),
	      
	      Arguments.of(7, ZakladniInterval.KVINTA),
	      Arguments.of(7, ZakladniInterval.KVARTA.zvetsena().zvetsena() ),
	      Arguments.of(7, ZakladniInterval.SEXTA_MALA.zmensena() ),
	      Arguments.of(7, ZakladniInterval.SEXTA_VELKA.zmensena().zmensena()),
	      
	      Arguments.of(8, ZakladniInterval.SEXTA_MALA),
	      Arguments.of(8, ZakladniInterval.SEXTA_VELKA.zmensena()),
	      Arguments.of(8, ZakladniInterval.SEPTIMA_MALA.zmensena().zmensena()),
	      Arguments.of(8, ZakladniInterval.KVINTA.zvetsena()),
	      
	      Arguments.of(9, ZakladniInterval.SEXTA_VELKA),
	      Arguments.of(9, ZakladniInterval.SEXTA_MALA.zvetsena()),
	      Arguments.of(9, ZakladniInterval.KVINTA.zvetsena().zvetsena()),
	      Arguments.of(9, ZakladniInterval.SEPTIMA_MALA.zmensena()),
	      Arguments.of(9, ZakladniInterval.SEPTIMA_VELKA.zmensena().zmensena()),
	      
	      Arguments.of(10, ZakladniInterval.SEPTIMA_MALA),
	      Arguments.of(10, ZakladniInterval.SEPTIMA_VELKA.zmensena()),
	      Arguments.of(10, ZakladniInterval.OKTAVA.zmensena().zmensena()),
	      Arguments.of(10, ZakladniInterval.SEXTA_VELKA.zvetsena()),
	      Arguments.of(10, ZakladniInterval.SEXTA_MALA.zvetsena().zvetsena()),
	      
	      Arguments.of(11, ZakladniInterval.SEPTIMA_VELKA),
	      Arguments.of(11, ZakladniInterval.SEPTIMA_MALA.zvetsena()),
	      Arguments.of(11, ZakladniInterval.SEXTA_VELKA.zvetsena().zvetsena()),
	      Arguments.of(11, ZakladniInterval.OKTAVA.zmensena()),
	      
	      Arguments.of(12, ZakladniInterval.OKTAVA),
	      Arguments.of(12, ZakladniInterval.SEPTIMA_VELKA.zvetsena()),
	      Arguments.of(12, ZakladniInterval.SEPTIMA_MALA.zvetsena().zvetsena())
		);
	}
}
