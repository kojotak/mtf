package cz.kojotak.mtf;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import static cz.kojotak.mtf.Posuvka.*;
public record Predznamenani(Posuvka posuvka, EnumSet<NazevTonu> tony) {
	
	public static Predznamenani zadne() {
		return new Predznamenani(null);
	}
	
	public static Predznamenani zKrizku(NazevTonu ... tony) {
		return new Predznamenani(Posuvka.KRIZEK, tony);
	}
	
	public static Predznamenani zBecek(NazevTonu ... tony) {
		return new Predznamenani(Posuvka.BECKO, tony);
	}
	
	public Predznamenani(Posuvka posuvka, NazevTonu ... tony) {
		//ugly
		this(posuvka != null ? posuvka : Posuvka.ODRAZKA, 
				 tony!=null && tony.length>0 
				 	? ( tony.length == 1 ? EnumSet.of(tony[0]) : EnumSet.of(tony[0], Arrays.copyOfRange(tony, 1, tony.length-1)) ) 
				 	: EnumSet.noneOf(NazevTonu.class) );
	}
	
	public Predznamenani(Posuvka posuvka, EnumSet<NazevTonu> tony) {
		this.posuvka = posuvka;
		this.tony = tony;
		if( !EnumSet.of(KRIZEK, BECKO, ODRAZKA).contains(this.posuvka)) {
			throw new IllegalArgumentException("Neplatna posuvka "+posuvka+" pro predznamenani!");
		}
		if( !Posuvka.ODRAZKA.equals(this.posuvka()) && this.tony().isEmpty() ){
			throw new IllegalArgumentException("Pro posuvku " + posuvka + " musi byt vybrane nejake tony!");
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
