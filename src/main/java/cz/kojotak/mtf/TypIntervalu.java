package cz.kojotak.mtf;

public enum TypIntervalu implements Obratitelny<TypIntervalu> {

	CISTY,
	VELKY,
	MALY,
	ZVETSENY,
	ZMENSENY,
	DVOJZVETSENY,
	DVOJZMENSENY;
	
	@Override
	public TypIntervalu obratit() {
		switch(this) {
			case CISTY: return this;
			case MALY: return VELKY;
			case VELKY: return MALY;
			case ZMENSENY: return ZVETSENY;
			case ZVETSENY: return ZMENSENY;
			case DVOJZMENSENY: return DVOJZVETSENY;
			case DVOJZVETSENY: return DVOJZMENSENY;
			default: throw new IllegalStateException("neznamy typ intervalu " + this);
		}
	}
	
}
