package cz.kojotak.mtf;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import static cz.kojotak.mtf.Posuvka.*;
public record Predznamenani(Posuvka posuvka, List<Ton> tony) {
	
	public Predznamenani(Posuvka posuvka, List<Ton> tony) {
		this.tony = tony != null ? tony : Collections.emptyList();
		this.posuvka = posuvka != null ? posuvka : Posuvka.ODRAZKA;
		if( !EnumSet.of(KRIZEK, BECKO, ODRAZKA).contains(this.posuvka)) {
			throw new IllegalArgumentException("Neplatna posuvka "+posuvka+" pro predznamenani!");
		}
	}
	
	public int getPocet() {
		return tony.size();
	}
	
	public int getKrizku() {
		return KRIZEK.equals(posuvka) ? tony.size() : 0;
	}
	
	public int getBecek() {
		return BECKO.equals(posuvka) ? tony.size() : 0;
	}
}
