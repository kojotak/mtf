package cz.kojotak.mtf;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Akord {

	private final Ton ton;
	private final IntervalyAkordu intervaly;
	
	public Akord(Ton ton, IntervalyAkordu intervaly) {
		super();
		this.ton = ton;
		this.intervaly = intervaly;
	}

	@Override
	public String toString() {
		return "Akord [ton=" + ton + ", intervaly=" + intervaly.name() + "]";
	}
	
	public List<Ton> getTonyAkordu(){
		return Stream.concat(
					Stream.of(ton),
					intervaly.getIntervaly().stream().map( i -> ton.pridejInterval(i) ))
			.sorted(Comparator.comparing(Ton::getPoradi))
			.collect(Collectors.toList());
	}
	
}
