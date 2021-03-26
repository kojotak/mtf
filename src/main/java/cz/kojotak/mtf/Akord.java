package cz.kojotak.mtf;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record Akord (Ton ton, TypAkordu intervaly) {

	public List<Ton> getTonyAkordu(){
		return Stream.concat(
					Stream.of(ton),
					intervaly.getIntervaly().stream().map( i -> ton.pridejInterval(i) ))
			.sorted(Comparator.comparing(Ton::getPoradi))
			.collect(Collectors.toList());
	}
	
}
