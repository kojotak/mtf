package cz.kojotak.mtf;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ton {
	
	public static final Map<Integer, List<Ton>> ZAKLADNI_TONY = Stream
			.of( NazevTonu.values() )
			.flatMap( t-> Stream
						.of( Posuvka.values() )
						.map( p-> new Ton(t,p) ))
			.collect( Collectors.groupingBy( Ton::getPoradi) );

	private final NazevTonu nazev;
	private final Posuvka posuvka;
	private final NazevOktavy oktava;
	private final int poradi;
	
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
		this.poradi = spocitejPoradi(this.nazev, this.posuvka);
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((oktava == null) ? 0 : oktava.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ton other = (Ton) obj;
		if (oktava != other.oktava)
			return false;
		return true;
	}

	public NazevOktavy getOktava() {
		return oktava;
	}

	public NazevTonu getNazev() {
		return nazev;
	}

	public Posuvka getPosuvka() {
		return posuvka;
	}

	public int getPoradi() {
		return poradi;
	}

	public Ton pridejInterval(Vzdalenost interval) {
		if(interval == null) {
			throw new IllegalArgumentException();
		}
		NazevOktavy novaOktava = getOktava();
		int pultonu = interval.getPultonu() + getPoradi();
		while(pultonu>=ZakladniInterval.OKTAVA.getPultonu()) {
			pultonu -= ZakladniInterval.OKTAVA.getPultonu();
			novaOktava = novaOktava!=null ? novaOktava.dalsi() : null;
		}
		List<Ton> odpovidajiciTony = ZAKLADNI_TONY.get(pultonu);
		Ton odpovidajiciTon = odpovidajiciTony.get(0);
		for(Ton ton : odpovidajiciTony) {
			//najdi vyssi odpovidajici ton, ale se stejnou posuvkou
			if(getPosuvka().equals(ton.getPosuvka())) {
				odpovidajiciTon = ton;
			}
		}
		return new Ton(odpovidajiciTon.getNazev(), odpovidajiciTon.getPosuvka(), novaOktava);
	}
	
	public static int spocitejPoradi(NazevTonu nazev, Posuvka posuvka) {
		int poradi = NazevTonu.prvni().equals(nazev) ? 0 : IntervalyStupnice.DUROVA.getPultonu(nazev.ordinal()-1);
		poradi += posuvka.getPultonu();
		if(poradi<0) {
			poradi += ZakladniInterval.OKTAVA.getPultonu();
		}
		if(poradi >= ZakladniInterval.OKTAVA.getPultonu()) {
			poradi -= ZakladniInterval.OKTAVA.getPultonu();
		}
		return poradi;
	}

}
