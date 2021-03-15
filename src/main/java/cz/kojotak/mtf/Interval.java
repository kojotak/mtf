package cz.kojotak.mtf;

public record Interval(NazevIntervalu nazev, TypIntervalu typ, SmerIntervalu smer) implements Vzdalenost {

	public static final Interval PRIMA = new Interval( NazevIntervalu.PRIMA );
	public static final Interval SEKUNDA_MALA = new Interval( NazevIntervalu.SEKUNDA, TypIntervalu.MALY );
	public static final Interval SEKUNDA_VELKA = new Interval( NazevIntervalu.SEKUNDA, TypIntervalu.VELKY );
	public static final Interval TERCIE_MALA = new Interval( NazevIntervalu.TERCIE, TypIntervalu.MALY );
	public static final Interval TERCIE_VELKA = new Interval( NazevIntervalu.TERCIE, TypIntervalu.VELKY );
	public static final Interval KVARTA = new Interval( NazevIntervalu.KVARTA );
	public static final Interval KVINTA = new Interval( NazevIntervalu.KVINTA );
	public static final Interval KVINTA_ZMENSENA = new Interval( NazevIntervalu.KVINTA ).zmensena();
	public static final Interval KVINTA_ZVETSENA = new Interval( NazevIntervalu.KVINTA ).zvetsena();
	public static final Interval SEXTA_MALA = new Interval( NazevIntervalu.SEXTA, TypIntervalu.MALY );
	public static final Interval SEXTA_VELKA = new Interval( NazevIntervalu.SEXTA, TypIntervalu.VELKY );
	public static final Interval SEPTIMA_MALA = new Interval( NazevIntervalu.SEPTIMA, TypIntervalu.MALY );
	public static final Interval SEPTIMA_VELKA = new Interval( NazevIntervalu.SEPTIMA, TypIntervalu.VELKY );
	public static final Interval OKTAVA = new Interval( NazevIntervalu.OKTAVA );
	;

	public Interval(NazevIntervalu nazev) {
		this(nazev, TypIntervalu.CISTY, SmerIntervalu.VZESTUPNY);
	}
	
	public Interval(NazevIntervalu nazev, TypIntervalu typ) {
		this(nazev, typ, SmerIntervalu.VZESTUPNY);
	}
	
	public Interval zvetsena() {
		switch(typ) {
		case CISTY: return new Interval(nazev, TypIntervalu.ZVETSENY, smer);
		case MALY: return new Interval(nazev, TypIntervalu.VELKY, smer);
		case VELKY: return new Interval(nazev, TypIntervalu.ZVETSENY, smer);
		case ZVETSENY: return new Interval(nazev, TypIntervalu.DVOJZVETSENY, smer);
		case ZMENSENY: return new Interval(nazev, TypIntervalu.MALY, smer);
		default: throw new IllegalArgumentException("nelze zvetsit " + nazev);
		}
	}
	
	public Interval zmensena() {
		switch(typ) {
		case CISTY: return new Interval(nazev, TypIntervalu.ZMENSENY, smer);
		case MALY: return new Interval(nazev, TypIntervalu.ZMENSENY, smer);
		case VELKY: return new Interval(nazev, TypIntervalu.MALY, smer);
		case ZVETSENY: return new Interval(nazev, TypIntervalu.VELKY, smer);
		case ZMENSENY: return new Interval(nazev, TypIntervalu.DVOJZMENSENY, smer);
		default: throw new IllegalArgumentException("nelze zmensit " + nazev);
		}
	}
	
	public Interval otocena() {
		return new Interval(nazev, typ, smer.obraceny());
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
		switch(smer) {
			case SESTUPNY: return -1 * result;
			case VZESTUPNY: return result;
			default: throw new IllegalStateException("neznamy smer " + smer);
		}
	}

}
