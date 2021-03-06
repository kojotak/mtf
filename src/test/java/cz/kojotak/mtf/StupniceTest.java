package cz.kojotak.mtf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import cz.kojotak.mtf.stupnice.ChromatickaStupnice;
import cz.kojotak.mtf.stupnice.DiatonickaStupnice;

/**
 * @see https://cs.wikipedia.org/wiki/Mollov%C3%A1_stupnice
 * @see https://cs.wikipedia.org/wiki/Durov%C3%A1_stupnice
 */
class StupniceTest extends TestovaciTony {
	
	@MethodSource
	@ParameterizedTest(name="{index} {0} ma tony: {1}")
	void pultonyVIntervalu(Stupnice stupnice, List<Ton> tony) {
		assertContainsAllExact(stupnice.getTonyStupnice(), tony.toArray(new Ton[0]));
	}
	
	private static Stream<Arguments> pultonyVIntervalu() {
	    return Stream.of(
		 Arguments.of(new DiatonickaStupnice(cis, TypStupnice.DUROVA), List.of( cis, dis, eis, fis, gis, ais, his, cis )),
		 Arguments.of(new DiatonickaStupnice(fis, TypStupnice.DUROVA), List.of(  fis, gis, ais, h, cis, dis, eis, fis )),
		 Arguments.of(new DiatonickaStupnice(h, TypStupnice.DUROVA), List.of(  h, cis, dis, e, fis, gis, ais, h )),
		 Arguments.of(new DiatonickaStupnice(e, TypStupnice.DUROVA), List.of(  e, fis, gis, a, h, cis, dis, e )),
		 Arguments.of(new DiatonickaStupnice(a, TypStupnice.DUROVA), List.of(  a, h, cis, d, e, fis, gis, a )),
		 Arguments.of(new DiatonickaStupnice(d, TypStupnice.DUROVA), List.of(  d, e, fis, g, a, h, cis, d )),
		 Arguments.of(new DiatonickaStupnice(g, TypStupnice.DUROVA), List.of(  g, a, h, c, d, e, fis, g )),
		 Arguments.of(new DiatonickaStupnice(c, TypStupnice.DUROVA), List.of(  c, d, e, f, g, a, h, c )),
		 Arguments.of(new DiatonickaStupnice(f, TypStupnice.DUROVA), List.of(  f, g, a, b, c, d, e, f )),
		 Arguments.of(new DiatonickaStupnice(b, TypStupnice.DUROVA), List.of(  b, c, d, es, f, g, a, b )),
		 Arguments.of(new DiatonickaStupnice(es, TypStupnice.DUROVA), List.of(  es, f, g, as, b, c, d, es )),
		 Arguments.of(new DiatonickaStupnice(as, TypStupnice.DUROVA), List.of(  as, b, c, des, es, f, g, as )),
		 Arguments.of(new DiatonickaStupnice(des, TypStupnice.DUROVA), List.of(  des, es, f, ges, as, b, c, des )),
		 Arguments.of(new DiatonickaStupnice(ges, TypStupnice.DUROVA), List.of(  ges, as, b, ces, des, es, f, ges )),
		 Arguments.of(new DiatonickaStupnice(ces, TypStupnice.DUROVA), List.of(  ces, des, es, fes, ges, as, b, ces )),
		 
		 Arguments.of(new DiatonickaStupnice(c, TypStupnice.PENTATONIKA_DUROVA), List.of(  c, d, e, g, a, c )),
		 Arguments.of(new DiatonickaStupnice(c, TypStupnice.PENTATONIKA_MOLLOVA), List.of(  c, es, f, g, hes, c )),
		 
		 Arguments.of(new ChromatickaStupnice(c), List.of(  c, cis, d, dis, e, f, fis, g, gis, a, ais, h, c ))
		 ,
		 Arguments.of(new DiatonickaStupnice(ais, TypStupnice.MOLLOVA), List.of(  ais, his, cis, dis, eis, fis, gis, ais )),
		 Arguments.of(new DiatonickaStupnice(dis, TypStupnice.MOLLOVA), List.of(  dis, eis, fis, gis, ais, h, cis, dis )),
		 Arguments.of(new DiatonickaStupnice(gis, TypStupnice.MOLLOVA), List.of(  gis, ais, h, cis, dis, e, fis, gis )),
		 Arguments.of(new DiatonickaStupnice(cis, TypStupnice.MOLLOVA), List.of(  cis, dis, e, fis, gis, a, h, cis )),
		 Arguments.of(new DiatonickaStupnice(fis, TypStupnice.MOLLOVA), List.of(  fis, gis, a, h, cis, d, e, fis )),
		 Arguments.of(new DiatonickaStupnice(h, TypStupnice.MOLLOVA), List.of(  h, cis, d, e, fis, g, a, h )),
		 Arguments.of(new DiatonickaStupnice(e, TypStupnice.MOLLOVA), List.of(  e, fis, g, a, h, c, d, e )),
		 Arguments.of(new DiatonickaStupnice(a, TypStupnice.MOLLOVA), List.of(  a, h, c, d, e, f, g, a )),
		 Arguments.of(new DiatonickaStupnice(d, TypStupnice.MOLLOVA), List.of(  d, e, f, g, a, b, c, d )),
		 Arguments.of(new DiatonickaStupnice(g, TypStupnice.MOLLOVA), List.of(  g, a, b, c, d, es, f, g )),
		 Arguments.of(new DiatonickaStupnice(c, TypStupnice.MOLLOVA), List.of(  c, d, es, f, g, as, b, c )),
		 Arguments.of(new DiatonickaStupnice(f, TypStupnice.MOLLOVA), List.of(  f, g, as, b, c, des, es, f )),
		 Arguments.of(new DiatonickaStupnice(b, TypStupnice.MOLLOVA), List.of(  b, c, des, es, f, ges, as, b )),
		 Arguments.of(new DiatonickaStupnice(es, TypStupnice.MOLLOVA), List.of(  es, f, ges, as, b, ces, des, es )),
		 Arguments.of(new DiatonickaStupnice(as, TypStupnice.MOLLOVA), List.of(  as, b, ces, des, es, fes, ges, as ))
		 );
	}
	
	@MethodSource
	@ParameterizedTest(name="{index} {1} ma MIDI cislo {0}")
	public void midiCislaTonu(int ocekavaneMidi, Ton ton) {
		assertEquals(ocekavaneMidi, ton.getMidiNumber());
	}

	//https://www.inspiredacoustics.com/en/MIDI_note_numbers_and_center_frequencies
	private static Stream<Arguments> midiCislaTonu() {
	    return Stream.of(
	    		 Arguments.of( 12, new Ton(NazevTonu.C, NazevOktavy.SUBKONTRA) ),
	    		 Arguments.of( 24, new Ton(NazevTonu.C, NazevOktavy.KONTRA) ),
	    		 Arguments.of( 36, new Ton(NazevTonu.C, NazevOktavy.VELKA) ),
	    		 Arguments.of( 48, new Ton(NazevTonu.C, NazevOktavy.MALA) ),
	    		 Arguments.of( 55, new Ton(NazevTonu.G, NazevOktavy.MALA) ),
	    		 Arguments.of( 56, new Ton(NazevTonu.G, Posuvka.KRIZEK, NazevOktavy.MALA) ),
	    		 Arguments.of( 60, new Ton(NazevTonu.C, NazevOktavy.JEDNOCARKOVANA) ),
	    		 Arguments.of( 72, new Ton(NazevTonu.C, NazevOktavy.DVOJCARKOVANA) )
			);
	    }
	
	@MethodSource
	@ParameterizedTest(name="{index} MIDI cislo {0} ma {1}")
	public void tonZMidiCisla(int midiCislo, Ton ocekavanyTon){
		assertEquals(ocekavanyTon, Ton.ofMidi(midiCislo));
	}

	private static Stream<Arguments> tonZMidiCisla(){
		//reuse the same data as for midiCislaTonu()
		return midiCislaTonu();
	}
	
} 