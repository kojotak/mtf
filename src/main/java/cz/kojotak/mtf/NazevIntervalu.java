package cz.kojotak.mtf;

import static cz.kojotak.mtf.Stupen.I;
import static cz.kojotak.mtf.Stupen.II;
import static cz.kojotak.mtf.Stupen.III;
import static cz.kojotak.mtf.Stupen.IV;
import static cz.kojotak.mtf.Stupen.V;
import static cz.kojotak.mtf.Stupen.VI;
import static cz.kojotak.mtf.Stupen.VII;
import static cz.kojotak.mtf.Stupen.VIII;

public enum NazevIntervalu {

	PRIMA(I),
	SEKUNDA(II),
	TERCIE(III),
	KVARTA(IV),
	KVINTA(V),
	SEXTA(VI),
	SEPTIMA(VII),
	OKTAVA(VIII), //I?
	NONA(II),
	DECIMA(III),
	UNDECIMA(IV),
	DUODECIMA(V),
	TERCDECIMA(VI),
	KVARTDECIMA(VII),
	KVINTDECIMA(VIII),
	;
	
	private final Stupen stupen;
	private NazevIntervalu(Stupen stupen) {
		this.stupen = stupen;
	}
	
	public Stupen getStupen() {
		return stupen;
	}

	public boolean jeCisty() {
		switch(stupen) {
		case I:
		case IV:
		case V:
		case VIII:
			return true;
		default:
			return false;
		}
	}

}
