package cz.kojotak.mtf;

import static cz.kojotak.mtf.ZakladniInterval.*;

import java.util.List;
import static cz.kojotak.mtf.JednoduchyInterval.*;
public enum IntervalyStupnice {

	DUROVA(SEKUNDA_VELKA, TERCIE_VELKA, KVARTA, KVINTA, SEXTA_VELKA, SEPTIMA_VELKA, OKTAVA),
	MOLLOVA(SEKUNDA_MALA, TERCIE_MALA, KVARTA, KVINTA, SEXTA_MALA, SEPTIMA_MALA, OKTAVA),
	
	PENTATONIKA_DUROVA(SEKUNDA_VELKA, TERCIE_VELKA, KVINTA, SEXTA_VELKA, OKTAVA),
	PENTATONIKA_MOLLOVA(SEKUNDA_MALA, KVARTA, KVINTA, SEPTIMA_VELKA, OKTAVA),
	
	CHROMATICKA( rostouciSekvenceIntervalu(OKTAVA.getPultonu()) ),
	;
	
	private IntervalyStupnice(Interval ... intervaly) {
		this.intervaly = intervaly;
	}
	private final Interval[] intervaly;
	public int getPultonu(int stupen) {
		if(stupen > intervaly.length) {
			throw new IllegalArgumentException("stupnice " + this.name() + " nema " + stupen  +" stupnu");
		}
		return intervaly[stupen].getPultonu();
	}
	public List<Interval> getIntervaly() {
		return List.of(intervaly);
	}
	
}
