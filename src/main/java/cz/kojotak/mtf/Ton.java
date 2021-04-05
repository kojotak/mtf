package cz.kojotak.mtf;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import cz.kojotak.mtf.stupnice.DiatonickaStupnice;

public record Ton(NazevTonu nazev, Posuvka posuvka, NazevOktavy oktava) {

	public static final int PULTONU_V_OKTAVE = Interval.OKTAVA.getPultonu();

	public static final Map<Integer, List<Ton>> ZAKLADNI_TONY = Stream
			.of( NazevTonu.values() )
			.flatMap( t-> Stream
						.of( Posuvka.values() )
						.map( p-> new Ton(t,p) ))
			.collect( Collectors.groupingBy( Ton::getPoradi) );
	
	public Ton(NazevTonu nazev) {
		this(nazev, null, null);
	}
	
	public Ton(NazevTonu nazev, Posuvka posuvka) {
		this(nazev, posuvka, null);
	}
	
	public Ton(NazevTonu nazev, NazevOktavy oktava) {
		this(nazev, null, oktava);
	}
	
	public Ton(NazevTonu nazev, Posuvka posuvka, NazevOktavy oktava) {
		if(posuvka==null) {
			this.posuvka = Posuvka.ODRAZKA;
		} else {
			this.posuvka = posuvka;
		}
		this.nazev = nazev;
		this.oktava = oktava;
	}

	@Override
	public String toString() {
		String result = posuvka.decorateString(nazev.name());
		if(oktava!=null) {
			return oktava.decorateString(result);
		} else {
			return result;
		}
	}
	
	public Ton pridejInterval(Vzdalenost interval) {
		if(interval == null) {
			throw new IllegalArgumentException();
		}
		NazevOktavy novaOktava = oktava;
		int pultonu = interval.getPultonu() + getPoradi();
		while(pultonu>=Interval.OKTAVA.getPultonu()) {
			pultonu -= Interval.OKTAVA.getPultonu();
			novaOktava = novaOktava!=null ? novaOktava.dalsi() : null;
		}
		while(pultonu<0) {
			pultonu += Interval.OKTAVA.getPultonu();
			novaOktava = novaOktava!=null ? novaOktava.predchozi() : null;
		}
		List<Ton> odpovidajiciTony = ZAKLADNI_TONY.get(Math.abs(pultonu));
		Ton odpovidajiciTon = vyberKandidat( odpovidajiciTony );
		for(Ton ton : odpovidajiciTony) {
			//najdi vyssi odpovidajici ton, ale se stejnou posuvkou
			if(this.posuvka.equals(ton.posuvka)) {
				odpovidajiciTon = ton;
			}
		}
		return new Ton(odpovidajiciTon.nazev, odpovidajiciTon.posuvka, novaOktava);
	}
	
	public int getPoradi() {
		int poradi = NazevTonu.prvni().equals(nazev) ? 0 : TypStupnice.DUROVA.getPultonu(nazev.ordinal()-1);
		poradi += posuvka.getPultonu();
		if(poradi<0) {
			poradi += PULTONU_V_OKTAVE;
		}
		if(poradi >= PULTONU_V_OKTAVE) {
			poradi -= PULTONU_V_OKTAVE;
		}
		return poradi;
	}
	
	public int getMidiNumber() {
		if(oktava==null) {
			throw new IllegalStateException("Pro zjisteni MIDI cisla je nutne specifikovat oktavu");
		}
		return getPoradi() + (PULTONU_V_OKTAVE * (oktava.ordinal()+1))  ;
	}
	
	public Stupnice newStupnice(TypStupnice intervaly) {
		return new DiatonickaStupnice(this, intervaly);
	}
	
	public Akord newAkord(TypAkordu intervaly) {
		return new Akord(this, intervaly);
	}
	
	public boolean equalsEnharmonicky(Ton ton) {
		for(Ton enharmonickyTon : ZAKLADNI_TONY.get(this.getPoradi())) {
			if(enharmonickyTon.equals(ton)) {
				return true;
			}
		}
		return false;
	}

	public static Ton ofMidi(int midiNumber){
		int idxOktavy = midiNumber / PULTONU_V_OKTAVE;
		int idxTonu = midiNumber % PULTONU_V_OKTAVE;
		NazevOktavy oktava = NazevOktavy.values()[idxOktavy-1];
		Ton ton = vyberKandidat(ZAKLADNI_TONY.get(idxTonu));
		return new Ton(ton.nazev(), ton.posuvka(), oktava);
	}
	
	public static Ton vyberKandidat(List<Ton> kandidati) {
		Collections.sort(
					kandidati, Comparator.comparing( 
							t -> Math.abs(t.posuvka().getPultonu())
							 ) );
		return kandidati.get(0);
	}

}
