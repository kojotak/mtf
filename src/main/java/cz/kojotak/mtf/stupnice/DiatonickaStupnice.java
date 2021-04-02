package cz.kojotak.mtf.stupnice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import cz.kojotak.mtf.Stupnice;
import cz.kojotak.mtf.Ton;
import cz.kojotak.mtf.TypStupnice;

public record DiatonickaStupnice (Ton tonika, TypStupnice intervaly) implements Stupnice {
	
	@Override
	public List<Ton> getTonyStupnice(){
		return Stream.concat(
				Stream.of(tonika),
				intervaly.getIntervaly().stream().map( i -> tonika.pridejInterval(i) ))
				.collect(Collectors.toList());
	}
	
	@Override
	public Ton getTonika() {
		return tonika;
	}
	
}
