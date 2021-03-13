package cz.kojotak.mtf;
import static cz.kojotak.mtf.NazevIntervalu.SEKUNDA;
import static cz.kojotak.mtf.NazevIntervalu.SEPTIMA;
import static cz.kojotak.mtf.NazevIntervalu.SEXTA;
import static cz.kojotak.mtf.NazevIntervalu.TERCIE;
import static cz.kojotak.mtf.TypIntervalu.CISTA;
import static cz.kojotak.mtf.TypIntervalu.MALA;
import static cz.kojotak.mtf.TypIntervalu.VELKA;
import static cz.kojotak.mtf.TypIntervalu.*;

import java.util.EnumSet;

public class ZakladniInterval implements Interval {

	public static final EnumSet<NazevIntervalu> CISTE_INTERVALY = EnumSet.of(
			NazevIntervalu.PRIMA, NazevIntervalu.KVARTA, NazevIntervalu.KVINTA, NazevIntervalu.OKTAVA, 
			NazevIntervalu.UNDECIMA, NazevIntervalu.DUODECIMA, NazevIntervalu.KVINTDECIMA);
	
	public static final ZakladniInterval PRIMA = new ZakladniInterval( NazevIntervalu.PRIMA, CISTA );
	public static final ZakladniInterval SEKUNDA_MALA = new ZakladniInterval( SEKUNDA, MALA );
	public static final ZakladniInterval SEKUNDA_VELKA = new ZakladniInterval( SEKUNDA, VELKA );
	public static final ZakladniInterval TERCIE_MALA = new ZakladniInterval( TERCIE, MALA );
	public static final ZakladniInterval TERCIE_VELKA = new ZakladniInterval( TERCIE, VELKA );
	public static final ZakladniInterval KVARTA = new ZakladniInterval( NazevIntervalu.KVARTA, CISTA );
	public static final ZakladniInterval KVINTA = new ZakladniInterval( NazevIntervalu.KVINTA, CISTA );
	public static final ZakladniInterval KVINTA_ZMENSENA = new ZakladniInterval( NazevIntervalu.KVINTA, ZMENSENA );
	public static final ZakladniInterval KVINTA_ZVETSENA = new ZakladniInterval( NazevIntervalu.KVINTA, ZVETSENA );
	public static final ZakladniInterval SEXTA_MALA = new ZakladniInterval( SEXTA, MALA);
	public static final ZakladniInterval SEXTA_VELKA = new ZakladniInterval( SEXTA, VELKA);
	public static final ZakladniInterval SEPTIMA_MALA = new ZakladniInterval( SEPTIMA, MALA);
	public static final ZakladniInterval SEPTIMA_VELKA = new ZakladniInterval( SEPTIMA, VELKA);
	public static final ZakladniInterval OKTAVA = new ZakladniInterval( NazevIntervalu.OKTAVA, CISTA);
	;
	
	private final int pultonu;
	private final int stupen;
	private final SmerIntervalu smer;
	private final TypIntervalu typ;
	private final NazevIntervalu nazev;
	
	public ZakladniInterval(NazevIntervalu nazev) {
		this(nazev, null, null);
	}
	
	public ZakladniInterval(NazevIntervalu nazev, TypIntervalu typ) {
		this(nazev, typ, null);
	}
	
	public ZakladniInterval(NazevIntervalu nazev, SmerIntervalu smer) {
		this(nazev, null, smer);
	}
	
	public ZakladniInterval(NazevIntervalu nazev, TypIntervalu typ, SmerIntervalu smer) {
		this.nazev = nazev;
		this.smer = smer;
		this.typ = typ;
		if(typ==null) {
			typ = TypIntervalu.CISTA;
		}
		if(smer==null) {
			smer = SmerIntervalu.VZESTUPNY;
		}
		if(nazev==null) {
			throw new IllegalArgumentException("nazev intervalu je povinny!");
		}
		if(CISTE_INTERVALY.contains(nazev) && (MALA.equals(typ) || VELKA.equals(typ))) {
			throw new IllegalArgumentException("cisty interval " + nazev + " nemuze byt " + typ);
		} else if(!CISTE_INTERVALY.contains(nazev) && CISTA.equals(typ)) {
			throw new IllegalArgumentException("interval " + nazev + " nemuze byt cisty");
		}
		this.stupen = nazev.ordinal();
		int pocitadlo = pultonuVDuroveStupnici(nazev);
		if(!VELKA.equals(typ)) {
			//rozdil oproti velkym intervalum
			pocitadlo += typ.getPultonu();
		}
		this.pultonu = pocitadlo;
	}
	
	public static int pultonuVDuroveStupnici(NazevIntervalu nazev) {
		switch(nazev) {
			case PRIMA: return 0;
			case SEKUNDA: return 2;
			case TERCIE: return 4;
			case KVARTA: return 5;
			case KVINTA: return 7;
			case SEXTA: return 9;
			case SEPTIMA: return 11;
			case OKTAVA: return 12;
			case NONA: return 14;
			case DECIMA: return 16;
			case UNDECIMA: return 17; //oktava+kvarta
			case DUODECIMA: return 19;//oktava+kvinta
			case TERCDECIMA: return 21;
			case KVARTDECIMA: return 23;
			case KVINTDECIMA: return 24;//dve oktavy
		}
		throw new IllegalArgumentException("neznamy nazev intervalu " + nazev);
	}

	@Override
	public int getPultonu() {
		return pultonu;
	}
	public int getStupen() {
		return stupen;
	}
	public SmerIntervalu getSmer() {
		return smer;
	}
	public TypIntervalu getTyp() {
		return typ;
	}
	public NazevIntervalu getNazev() {
		return nazev;
	}

	@Override
	public String toString() {
		return "ZakladniInterval [nazev=" + nazev + ", typ=" + typ + ", smer=" + smer + "]";
	}
	
}
