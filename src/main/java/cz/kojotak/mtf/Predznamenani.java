package cz.kojotak.mtf;

import java.util.Collections;
import java.util.List;

//TODO udelat neco jako strukturu, ktera ma bud krizky nebo becka, nikoliv oboji
public record Predznamenani(List<Ton> krizky, List<Ton> becka) {
	
	public Predznamenani(List<Ton> krizky, List<Ton> becka) {
		this.krizky = krizky != null ? krizky : Collections.emptyList();
		this.becka = becka!=null ? becka : Collections.emptyList();
		if( getKrizku() > 0 && getBecek() > 0) {
			throw new IllegalArgumentException("Nelze vytvorit predznamenani s krizky i becky!");
		}
	}
	
	public int getKrizku() {
		return krizky.size();
	}
	
	public int getBecek() {
		return becka.size();
	}
}
