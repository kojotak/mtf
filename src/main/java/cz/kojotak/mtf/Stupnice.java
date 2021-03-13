package cz.kojotak.mtf;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public record Stupnice (Ton ton, IntervalyStupnice intervaly) {
	
	public List<Ton> getTonyStupnice(){
		return intervaly.getIntervaly()
				.stream()
				.map( i -> ton.pridejInterval(i) )
				.sorted(Comparator.comparing(Ton::getPoradi))
				.collect(Collectors.toList());
	}
	
}
