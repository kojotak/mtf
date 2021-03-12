package cz.kojotak.mtf;

public enum NazevOktavy implements Seraditelny<NazevOktavy> {

	SUBKONTRA( 2 ),
	KONTRA( 1 ),
	VELKA( 0 ),
	MALA( 0 ),
	JEDNOCARKOVANA( 1 ),
	DVOJCARKOVANA( 2 ),
	TROJCARKOVANA( 3 ),
	CTYRCARKOVANA( 4 ),
	PETICARKOVANA( 5 ),
	SESTICARKOVANA( 6 );
	
	private final int carek;
	
	private NazevOktavy(int carek) {
		this.carek = carek;
	}
	
	public NazevOktavy dalsi() {
		int next = this.ordinal() + 1;
		NazevOktavy[] vals = values();
		if(next >= vals.length) {
			throw new IllegalStateException("Pro " + this + " neexistuje dalsi oktava");
		} else {
			return vals[next];
		}
	}
	
	public NazevOktavy predchozi() {
		int previous = this.ordinal() -1;
		if( previous < 0 ) {
			throw new IllegalStateException("Pro " + this + " neexistuje predchozi oktava");
		} else {
			return values()[previous];
		}
	}
	
	public String decorateString(final String nazevTonu) {
		String firstLetter = nazevTonu.substring(0, 1);
		String result;
		switch(this) {
			case SUBKONTRA:
			case KONTRA:
			case VELKA:
				result = firstLetter.toUpperCase();
				break;
			default: 
				result = firstLetter.toLowerCase();
		}
		result += nazevTonu.substring(1);
		result += "'".repeat(carek);
		return result;
	};
}
