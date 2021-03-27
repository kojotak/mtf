package cz.kojotak.mtf;

public enum Posuvka implements Vzdalenost {
	ODRAZKA(0),
	KRIZEK(1),
	BECKO(-1),
	DVOJKRIZEK(2),
	DVOJBECKO(-2)
	;
	
	private final int posunPultonu;
	private Posuvka(int posunPultonu) {
		this.posunPultonu = posunPultonu;
	}
	@Override
	public int getPultonu() {
		return posunPultonu;
	}
	public String decorateString(final String nazevTonu) {
		if(posunPultonu == 0) {
			return nazevTonu;
		}
		String suffix;
		if(posunPultonu > 0) {
			suffix = "is";
		}else {
			if( nazevTonu.toLowerCase().startsWith("e") || nazevTonu.toLowerCase().startsWith("a") ) {
				suffix = "s";
			}else {
				suffix = "es";
			}
		}
		return nazevTonu + suffix.repeat(Math.abs(posunPultonu));
	};
}
