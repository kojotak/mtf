package cz.kojotak.mtf;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record Stupnice (Ton ton, IntervalyStupnice intervaly) {
	
	public List<Ton> getTonyStupnice(){
		return Stream.concat(
				Stream.of(ton),
				intervaly.getIntervaly().stream().map( i -> ton.pridejInterval(i) ))
				.collect(Collectors.toList());
	}
	
}
