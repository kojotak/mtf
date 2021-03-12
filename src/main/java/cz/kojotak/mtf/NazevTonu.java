package cz.kojotak.mtf;

public enum NazevTonu implements Seraditelny<NazevTonu> {
	
	C,
	D,
	E,
	F,
	G,
	A,
	H;
	
	public NazevTonu dalsi() {
		int next = this.ordinal() + 1;
		NazevTonu[] vals = values();
		if(next >= vals.length) {
			return vals[0];
		} else {
			return vals[next];
		}
	}
	
	public NazevTonu predchozi() {
		int previous = this.ordinal() -1;
		NazevTonu[] vals = values();
		if( previous < 0 ) {
			return vals[vals.length-1];
		} else {
			return vals[previous];
		}
	}
	
	public static NazevTonu prvni() {
		return values()[0];
	}
	
	public static NazevTonu posledni() {
		var vals = values();
		return vals[vals.length];
	}
	
}
