package cz.kojotak.mtf;

import static cz.kojotak.mtf.JednoduchaVzdalenost.*;
import static cz.kojotak.mtf.Interval.*;

import java.util.List;
public enum IntervalyStupnice {

	DUROVA(SEKUNDA_VELKA, TERCIE_VELKA, KVARTA, KVINTA, SEXTA_VELKA, SEPTIMA_VELKA, OKTAVA),
	MOLLOVA(SEKUNDA_MALA, TERCIE_MALA, KVARTA, KVINTA, SEXTA_MALA, SEPTIMA_MALA, OKTAVA),
	
	PENTATONIKA_DUROVA(SEKUNDA_VELKA, TERCIE_VELKA, KVINTA, SEXTA_VELKA, OKTAVA),
	PENTATONIKA_MOLLOVA(SEKUNDA_MALA, KVARTA, KVINTA, SEPTIMA_VELKA, OKTAVA),
	
	CHROMATICKA( rostouciSekvenceIntervalu(OKTAVA.getPultonu()) ),
	;
	
	private IntervalyStupnice(Vzdalenost ... intervaly) {
		this.intervaly = intervaly;
	}
	private final Vzdalenost[] intervaly;
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
