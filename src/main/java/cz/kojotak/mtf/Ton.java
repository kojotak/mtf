package cz.kojotak.mtf;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record Ton(NazevTonu nazev, Posuvka posuvka, NazevOktavy oktava) {
	
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
		Ton odpovidajiciTon = odpovidajiciTony.get(0);
		for(Ton ton : odpovidajiciTony) {
			//najdi vyssi odpovidajici ton, ale se stejnou posuvkou
			if(this.posuvka.equals(ton.posuvka)) {
				odpovidajiciTon = ton;
			}
		}
		return new Ton(odpovidajiciTon.nazev, odpovidajiciTon.posuvka, novaOktava);
	}
	
	public int getPoradi() {
		int poradi = NazevTonu.prvni().equals(nazev) ? 0 : IntervalyStupnice.DUROVA.getPultonu(nazev.ordinal()-1);
		poradi += posuvka.getPultonu();
		if(poradi<0) {
			poradi += Interval.OKTAVA.getPultonu();
		}
		if(poradi >= Interval.OKTAVA.getPultonu()) {
			poradi -= Interval.OKTAVA.getPultonu();
		}
		return poradi;
	}

}
