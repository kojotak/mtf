package cz.kojotak.mtf;

public enum Jednotka implements Vzdalenost {
	PULTON(1),
	TON(2),
	DITON(4),
	TRITON(6)
	;
	
	private Jednotka(int pultonu) {
		this.pultonu = pultonu;
	}
	private final int pultonu;
	
	@Override
	public int getPultonu() {
		return pultonu;
	}
	
}
