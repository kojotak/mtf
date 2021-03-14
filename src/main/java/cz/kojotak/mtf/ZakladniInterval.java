package cz.kojotak.mtf;

public class ZakladniInterval implements Vzdalenost {

	public static final ZakladniInterval PRIMA = new ZakladniInterval( NazevIntervalu.PRIMA );
	public static final ZakladniInterval SEKUNDA_MALA = new ZakladniInterval( NazevIntervalu.SEKUNDA, TypIntervalu.MALY );
	public static final ZakladniInterval SEKUNDA_VELKA = new ZakladniInterval( NazevIntervalu.SEKUNDA, TypIntervalu.VELKY );
	public static final ZakladniInterval TERCIE_MALA = new ZakladniInterval( NazevIntervalu.TERCIE, TypIntervalu.MALY );
	public static final ZakladniInterval TERCIE_VELKA = new ZakladniInterval( NazevIntervalu.TERCIE, TypIntervalu.VELKY );
	public static final ZakladniInterval KVARTA = new ZakladniInterval( NazevIntervalu.KVARTA );
	public static final ZakladniInterval KVINTA = new ZakladniInterval( NazevIntervalu.KVINTA );
	public static final ZakladniInterval KVINTA_ZMENSENA = new ZakladniInterval( NazevIntervalu.KVINTA ).zmensena();
	public static final ZakladniInterval KVINTA_ZVETSENA = new ZakladniInterval( NazevIntervalu.KVINTA ).zvetsena();
	public static final ZakladniInterval SEXTA_MALA = new ZakladniInterval( NazevIntervalu.SEXTA, TypIntervalu.MALY );
	public static final ZakladniInterval SEXTA_VELKA = new ZakladniInterval( NazevIntervalu.SEXTA, TypIntervalu.VELKY );
	public static final ZakladniInterval SEPTIMA_MALA = new ZakladniInterval( NazevIntervalu.SEPTIMA, TypIntervalu.MALY );
	public static final ZakladniInterval SEPTIMA_VELKA = new ZakladniInterval( NazevIntervalu.SEPTIMA, TypIntervalu.VELKY );
	public static final ZakladniInterval OKTAVA = new ZakladniInterval( NazevIntervalu.OKTAVA );
	;
	
	private final int pultonu;
	private final SmerIntervalu smer;
	private final TypIntervalu typ;
	private final NazevIntervalu nazev;

	public ZakladniInterval(NazevIntervalu nazev) {
		this(nazev, TypIntervalu.CISTY, null);
	}
	
	public ZakladniInterval(NazevIntervalu nazev, TypIntervalu typ) {
		this(nazev, typ, null);
	}
	
//	public static ZakladniInterval cisty() {
	
	public ZakladniInterval zvetsena() {
		switch(typ) {
			case CISTY: return new ZakladniInterval(nazev, TypIntervalu.ZVETSENY, smer);
			case MALY: return new ZakladniInterval(nazev, TypIntervalu.VELKY, smer);
			case VELKY: return new ZakladniInterval(nazev, TypIntervalu.ZVETSENY, smer);
			case ZVETSENY: return new ZakladniInterval(nazev, TypIntervalu.DVOJZVETSENY, smer);
			case ZMENSENY: return new ZakladniInterval(nazev, TypIntervalu.MALY, smer);
			default: throw new IllegalArgumentException("nelze zvetsit " + nazev);
		}
	}
	
	public ZakladniInterval zmensena() {
		switch(typ) {
			case CISTY: return new ZakladniInterval(nazev, TypIntervalu.ZMENSENY, smer);
			case MALY: return new ZakladniInterval(nazev, TypIntervalu.ZMENSENY, smer);
			case VELKY: return new ZakladniInterval(nazev, TypIntervalu.MALY, smer);
			case ZVETSENY: return new ZakladniInterval(nazev, TypIntervalu.VELKY, smer);
			case ZMENSENY: return new ZakladniInterval(nazev, TypIntervalu.DVOJZMENSENY, smer);
			default: throw new IllegalArgumentException("nelze zmensit " + nazev);
		}
	}
	
	private ZakladniInterval(NazevIntervalu nazev, TypIntervalu typ, SmerIntervalu smer) {
		this.nazev = nazev;
		this.smer = smer;
		this.typ = typ;
		if(typ==null) {
			typ = TypIntervalu.CISTY;
		}
		if(smer==null) {
			smer = SmerIntervalu.VZESTUPNY;
		}
		if(nazev==null) {
			throw new IllegalArgumentException("nazev intervalu je povinny!");
		}
		this.pultonu = pultonu(nazev, typ);
	}
	
	public static int pultonu(NazevIntervalu nazev, TypIntervalu typ) {
		int result = pultonuVDuroveStupnici(nazev);
		switch(typ){
			case CISTY:
			case VELKY:
				break;
			case MALY: 
				result -= 1; 
				break;
			case ZMENSENY: 
				result -= nazev.jeCisty() ? 1 : 2;
				break;
			case DVOJZMENSENY: 
				result -= nazev.jeCisty() ? 2 : 3;
				break;
			case ZVETSENY:
				result += 1;
				break;
			case DVOJZVETSENY:
				result += 2;
		}
		return result;
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
			default: throw new IllegalArgumentException("neznamy interval " + nazev);
		}
	}
	
	@Override
	public int getPultonu() {
		return pultonu;
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
		String result = nazev.name();
		result += ", stupen=" + nazev.getStupen().name();
		result += ", typ=" + typ.name();
		if(smer!=null) {
			result += ", smer=" + smer;
		}
		result += ", pultonu=" + getPultonu();
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nazev == null) ? 0 : nazev.hashCode());
		result = prime * result + pultonu;
		result = prime * result + ((smer == null) ? 0 : smer.hashCode());
		result = prime * result + ((typ == null) ? 0 : typ.hashCode());
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
		ZakladniInterval other = (ZakladniInterval) obj;
		if (nazev != other.nazev)
			return false;
		if (pultonu != other.pultonu)
			return false;
		if (smer != other.smer)
			return false;
		if (typ != other.typ)
			return false;
		return true;
	}
	
}
