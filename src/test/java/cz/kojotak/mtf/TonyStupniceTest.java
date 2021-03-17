package cz.kojotak.mtf;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @see https://cs.wikipedia.org/wiki/Mollov%C3%A1_stupnice
 * @see https://cs.wikipedia.org/wiki/Durov%C3%A1_stupnice
 */
class TonyStupniceTest extends TestovaciTony {
	
	@MethodSource
	@ParameterizedTest
	void pultonyVIntervalu(Stupnice stupnice, List<Ton> tony) {
		assertContainsAll(stupnice.getTonyStupnice(), tony.toArray(new Ton[0]));
	}
	
	private static Stream<Arguments> pultonyVIntervalu() {
	    return Stream.of(
		 Arguments.of(new Stupnice(cis, IntervalyStupnice.DUROVA), List.of( cis, dis, eis, fis, gis, ais, his, cis )),
		 Arguments.of(new Stupnice(fis, IntervalyStupnice.DUROVA), List.of(  fis, gis, ais, h, cis, dis, eis, fis )),
		 Arguments.of(new Stupnice(h, IntervalyStupnice.DUROVA), List.of(  h, cis, dis, e, fis, gis, ais, h )),
		 Arguments.of(new Stupnice(e, IntervalyStupnice.DUROVA), List.of(  e, fis, gis, a, h, cis, dis, e )),
		 Arguments.of(new Stupnice(a, IntervalyStupnice.DUROVA), List.of(  a, h, cis, d, e, fis, gis, a )),
		 Arguments.of(new Stupnice(d, IntervalyStupnice.DUROVA), List.of(  d, e, fis, g, a, h, cis, d )),
		 Arguments.of(new Stupnice(g, IntervalyStupnice.DUROVA), List.of(  g, a, h, c, d, e, fis, g )),
		 Arguments.of(new Stupnice(c, IntervalyStupnice.DUROVA), List.of(  c, d, e, f, g, a, h, c )),
		 Arguments.of(new Stupnice(f, IntervalyStupnice.DUROVA), List.of(  f, g, a, b, c, d, e, f )),
		 Arguments.of(new Stupnice(b, IntervalyStupnice.DUROVA), List.of(  b, c, d, es, f, g, a, b )),
		 Arguments.of(new Stupnice(es, IntervalyStupnice.DUROVA), List.of(  es, f, g, as, b, c, d, es )),
		 Arguments.of(new Stupnice(as, IntervalyStupnice.DUROVA), List.of(  as, b, c, des, es, f, g, as )),
		 Arguments.of(new Stupnice(des, IntervalyStupnice.DUROVA), List.of(  des, es, f, ges, as, b, c, des )),
		 Arguments.of(new Stupnice(ges, IntervalyStupnice.DUROVA), List.of(  ges, as, b, ces, des, es, f, ges )),
		 Arguments.of(new Stupnice(ces, IntervalyStupnice.DUROVA), List.of(  ces, des, es, fes, ges, as, b, ces )),
		 
		 Arguments.of(new Stupnice(c, IntervalyStupnice.PENTATONIKA_DUROVA), List.of(  c, d, e, g, a, c )),
		 Arguments.of(new Stupnice(c, IntervalyStupnice.PENTATONIKA_MOLLOVA), List.of(  c, es, f, g, hes, c )),
		 
		 Arguments.of(new Stupnice(c, IntervalyStupnice.CHROMATICKA), List.of(  c, cis, d, dis, e, f, fis, g, gis, a, ais, h, c ))
		 ,
		 Arguments.of(new Stupnice(ais, IntervalyStupnice.MOLLOVA), List.of(  ais, his, cis, dis, eis, fis, gis, ais )),
		 Arguments.of(new Stupnice(dis, IntervalyStupnice.MOLLOVA), List.of(  dis, eis, fis, gis, ais, h, cis, dis )),
		 Arguments.of(new Stupnice(gis, IntervalyStupnice.MOLLOVA), List.of(  gis, ais, h, cis, dis, e, fis, gis )),
		 Arguments.of(new Stupnice(cis, IntervalyStupnice.MOLLOVA), List.of(  cis, dis, e, fis, gis, a, h, cis )),
		 Arguments.of(new Stupnice(fis, IntervalyStupnice.MOLLOVA), List.of(  fis, gis, a, h, cis, d, e, fis )),
		 Arguments.of(new Stupnice(h, IntervalyStupnice.MOLLOVA), List.of(  h, cis, d, e, fis, g, a, h )),
		 Arguments.of(new Stupnice(e, IntervalyStupnice.MOLLOVA), List.of(  e, fis, g, a, h, c, d, e )),
		 Arguments.of(new Stupnice(a, IntervalyStupnice.MOLLOVA), List.of(  a, h, c, d, e, f, g, a )),
		 Arguments.of(new Stupnice(d, IntervalyStupnice.MOLLOVA), List.of(  d, e, f, g, a, b, c, d )),
		 Arguments.of(new Stupnice(g, IntervalyStupnice.MOLLOVA), List.of(  g, a, b, c, d, es, f, g )),
		 Arguments.of(new Stupnice(c, IntervalyStupnice.MOLLOVA), List.of(  c, d, es, f, g, as, b, c )),
		 Arguments.of(new Stupnice(f, IntervalyStupnice.MOLLOVA), List.of(  f, g, as, b, c, des, es, f )),
		 Arguments.of(new Stupnice(b, IntervalyStupnice.MOLLOVA), List.of(  b, c, des, es, f, ges, as, b )),
		 Arguments.of(new Stupnice(es, IntervalyStupnice.MOLLOVA), List.of(  es, f, ges, as, b, ces, des, es )),
		 Arguments.of(new Stupnice(as, IntervalyStupnice.MOLLOVA), List.of(  as, b, ces, des, es, fes, ges, as ))
		 );
	}		
	
}
