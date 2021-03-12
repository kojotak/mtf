package cz.kojotak.mtf;

public enum Jednotka implements Interval {
	PULTON(1),
	TON(2),
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
