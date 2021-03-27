package cz.kojotak.mtf;

import static cz.kojotak.mtf.Interval.*;

import java.util.List;

/** @see https://cs.wikipedia.org/wiki/Seznam_akordov%C3%BDch_zna%C4%8Dek */
public enum TypAkordu implements Intervalovy{
	KVINTAKORD_DUROVY(TERCIE_VELKA, TERCIE_MALA),
	KVINTAKORD_MOLLOVY(TERCIE_MALA, TERCIE_VELKA),
	KVINTAKORD_ZVETSENY(TERCIE_VELKA, TERCIE_VELKA),
	KVINTAKORD_ZMENSENY(TERCIE_MALA, TERCIE_MALA),
	
	SEPTAKORD_DOMINANTNI(TERCIE_VELKA, TERCIE_MALA, TERCIE_MALA),
	SEPTAKORD_VELKY(TERCIE_VELKA, TERCIE_MALA, TERCIE_VELKA),
	SEPTAKORD_MALY_MOLLOVY(TERCIE_MALA, TERCIE_VELKA, TERCIE_MALA),
	SEPTAKORD_VELKY_MOLLOVY(TERCIE_MALA, TERCIE_VELKA, TERCIE_VELKA),
	SEPTAKORD_ZVETSENY(TERCIE_VELKA, TERCIE_VELKA, TERCIE_VELKA),
	SEPTAKORD_MALY_ZMENSENY(TERCIE_MALA, TERCIE_MALA, TERCIE_MALA),
	SEPTAKORD_ZMENSENY(TERCIE_MALA, TERCIE_MALA, TERCIE_MALA),
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
	
	@Override
	public List<Interval> getIntervaly() {
		return List.of(intervaly);
	}
	
}
