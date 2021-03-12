package cz.kojotak.mtf;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stupnice {

	private final Ton ton;
	private final IntervalyStupnice intervaly;
	
	public Stupnice(Ton ton, IntervalyStupnice intervaly) {
		super();
		this.ton = ton;
		this.intervaly = intervaly;
	}

	@Override
	public String toString() {
		return "Stupnice [ton=" + ton + ", intervaly=" + intervaly.name() + "]";
	}
	
	public List<Ton> getTonyStupnice(){
		return intervaly.getIntervaly()
				.stream()
				.map( i -> ton.pridejInterval(i) )
				.sorted(Comparator.comparing(Ton::getPoradi))
				.collect(Collectors.toList());
	}
	
}
