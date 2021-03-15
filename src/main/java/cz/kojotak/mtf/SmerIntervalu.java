package cz.kojotak.mtf;

public enum SmerIntervalu {

	VZESTUPNY,
	SESTUPNY,
	;
	
	public SmerIntervalu obraceny() {
		return values()[ (ordinal() + 1) % values().length ];
	}
}
