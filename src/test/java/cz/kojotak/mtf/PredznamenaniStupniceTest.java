package cz.kojotak.mtf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import cz.kojotak.mtf.stupnice.DiatonickaStupnice;
import static cz.kojotak.mtf.TypStupnice.*;
import static cz.kojotak.mtf.NazevTonu.*;
/**
 * @see https://cs.wikipedia.org/wiki/Mollov%C3%A1_stupnice
 * @see https://cs.wikipedia.org/wiki/Durov%C3%A1_stupnice
 */
class PredznamenaniStupniceTest extends TestovaciTony {
	
	@MethodSource
	@ParameterizedTest(name="{index} stupnice {1} ma predznamenani {0}")
	public void predznamenaniStupnice(Predznamenani ocekavanePredznamenani, DiatonickaStupnice stupnice){
		Predznamenani predznamenani = stupnice.getPredznamenani();
		assertEquals(ocekavanePredznamenani.posuvka(), predznamenani.posuvka());
		assertEquals(ocekavanePredznamenani.getPocet(), predznamenani.getPocet());
		assertEquals(ocekavanePredznamenani.tony(), predznamenani.tony());
	}

	private static Stream<Arguments> predznamenaniStupnice(){
		 return Stream.of(
//				 Arguments.of(Predznamenani.zKrizku(F,C,G,D,A,E,H), new DiatonickaStupnice(cis, DUROVA) ),
//				 Arguments.of(Predznamenani.zKrizku(F,C,G,D,A,E), new DiatonickaStupnice(fis, DUROVA) ),
//				 Arguments.of(Predznamenani.zKrizku(F,C,G,D,A), new DiatonickaStupnice(h, DUROVA) ),
//				 Arguments.of(Predznamenani.zKrizku(F,C,G,D), new DiatonickaStupnice(e, DUROVA) ),
//				 Arguments.of(Predznamenani.zKrizku(F,C,G), new DiatonickaStupnice(a, DUROVA) ),
//				 Arguments.of(Predznamenani.zKrizku(F,C), new DiatonickaStupnice(d, DUROVA) ),
//	    		 Arguments.of(Predznamenani.zKrizku(F), new DiatonickaStupnice(g, DUROVA) ), 
	    		 Arguments.of(Predznamenani.zadne(), new DiatonickaStupnice(c, DUROVA) ),
//	    		 Arguments.of(Predznamenani.zBecek(H), new DiatonickaStupnice(f, DUROVA) ),
//	    		 Arguments.of(Predznamenani.zBecek(H,E), new DiatonickaStupnice(b, DUROVA) ),
//	    		 Arguments.of(Predznamenani.zBecek(H,E,A), new DiatonickaStupnice(es, DUROVA) ),
//	    		 Arguments.of(Predznamenani.zBecek(H,E,A,D), new DiatonickaStupnice(as, DUROVA) ),
//	    		 Arguments.of(Predznamenani.zBecek(H,E,A,D,G), new DiatonickaStupnice(des, DUROVA) ),
//	    		 Arguments.of(Predznamenani.zBecek(H,E,A,D,G,C), new DiatonickaStupnice(ges, DUROVA) ),
//	    		 Arguments.of(Predznamenani.zBecek(H,E,A,D,G,C,F), new DiatonickaStupnice(ces, DUROVA) ),
	    		 
	    		 Arguments.of(Predznamenani.zadne(), new DiatonickaStupnice(a, MOLLOVA) )
	    		 );
	}
	
} 