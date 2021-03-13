package cz.kojotak.mtf;

public enum TypIntervalu implements Interval{

	CISTA(0),
	VELKA(1),
	MALA(-1),
	ZVETSENA(1),
	ZMENSENA(-1),
	
// TODO	tohle nefunguje - zvetsena tercie je pouze +1 oproti tercii v durove stupnici
//	ZVETSENA_VELKA(2),
//	ZMENSENA_MALA(-2)
	;
	
	private TypIntervalu(int pultonu) {
		this.pultonu = pultonu;
	}

	private final int pultonu;

	public int getPultonu() {
		return pultonu;
	}
	
}
