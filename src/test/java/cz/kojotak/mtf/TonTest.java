package cz.kojotak.mtf;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TonTest extends TestovaciTony {

	@MethodSource
	@ParameterizedTest(name="{index} {0} je enharmonicky ekvivalentni s {1}")
	void equalsEnharmonicky(Ton jeden, Ton druhy) {
		assertTrue(jeden.equalsEnharmonicky(druhy));
		assertTrue(druhy.equalsEnharmonicky(jeden));
	}
	
	//priklady enharmonicky ekvivalentnich dvojic
	private static Stream<Arguments> equalsEnharmonicky() {
	    return Stream.of(	
	      Arguments.of(cis, des),
	      Arguments.of(b, hes),
	      Arguments.of(f, eis),
	      Arguments.of(fis, ges),
	      Arguments.of(cis.pridejInterval(Interval.SEKUNDA_MALA), d)
	      );
	}

}
