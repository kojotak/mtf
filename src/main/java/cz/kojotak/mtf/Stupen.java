package cz.kojotak.mtf;

public enum Stupen implements Obratitelny<Stupen> {

	I,
	II,
	III,
	IV,
	V,
	VI,
	VII,
	VIII;
	
	public int getPoradi() {
		return ordinal()+1;
	}

	@Override
	public Stupen obratit() {
		int ord = values().length - getPoradi();
		return values()[ord];
	}
	
}
