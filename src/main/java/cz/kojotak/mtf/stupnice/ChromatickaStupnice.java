package cz.kojotak.mtf.stupnice;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import cz.kojotak.mtf.Interval;
import cz.kojotak.mtf.NazevTonu;
import cz.kojotak.mtf.Stupnice;
import cz.kojotak.mtf.Ton;

public record ChromatickaStupnice(Ton tonika) implements Stupnice {

	@Override
	public List<Ton> getTonyStupnice() {
		LinkedList<Ton> list = new LinkedList<Ton>();
		list.add(tonika);
		IntStream.range(1, 13).forEach( i->
			list.add( list.getLast().pridejInterval(Interval.SEKUNDA_MALA)) 
		);
		return list;
	}
	
	@Override
	public Ton getTonika() {
		return tonika;
	}

}
