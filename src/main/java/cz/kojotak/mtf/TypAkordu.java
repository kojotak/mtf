package cz.kojotak.mtf;

import static cz.kojotak.mtf.Interval.*;

import java.util.List;

/** @see https://cs.wikipedia.org/wiki/Seznam_akordov%C3%BDch_zna%C4%8Dek */
public enum TypAkordu {
	KVINTAKORD_DUROVY(TERCIE_VELKA, KVINTA),
	KVINTAKORD_MOLLOVY(TERCIE_MALA, KVINTA),
	KVINTAKORD_ZVETSENY(TERCIE_VELKA, KVINTA_ZVETSENA),
	KVINTAKORD_ZMENSENY(TERCIE_MALA, KVINTA_ZMENSENA),
	
	SEPTAKORD_DOMINANTNI(TERCIE_VELKA, KVINTA, SEPTIMA_MALA),
	SEPTAKORD_VELKY(TERCIE_VELKA, KVINTA, SEPTIMA_VELKA),
	SEPTAKORD_MALY_MOLLOVY(TERCIE_MALA, KVINTA, SEPTIMA_MALA),
	SEPTAKORD_VELKY_MOLLOVY(TERCIE_MALA, KVINTA, SEPTIMA_VELKA),
	SEPTAKORD_ZVETSENY(TERCIE_VELKA, KVINTA_ZVETSENA, SEPTIMA_VELKA),
	SEPTAKORD_MALY_ZMENSENY(TERCIE_MALA, KVINTA_ZMENSENA, SEPTIMA_MALA),
	SEPTAKORD_ZMENSENY(TERCIE_MALA, KVINTA_ZMENSENA, SEPTIMA_MALA),
	;
	
	private TypAkordu(Interval ... intervaly) {
		this.intervaly = intervaly;
	}
	private final Interval[] intervaly;
	public int getPultonu(int stupen) {
		if(stupen > intervaly.length) {
			throw new IllegalArgumentException("stupnice " + this.name() + " nema " + stupen  +" stupnu");
		}
		return intervaly[stupen].getPultonu();
	}
	public List<Vzdalenost> getIntervaly() {
		return List.of(intervaly);
	}
	
}
