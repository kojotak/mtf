package cz.kojotak.mtf.stupnice;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import cz.kojotak.mtf.Interval;
import cz.kojotak.mtf.Stupnice;
import cz.kojotak.mtf.Ton;

public record ChromatickaStupnice(Ton tonika) implements Stupnice {

	@Override
	public List<Ton> getTonyStupnice() {
		return IntStream.range(1, 13).collect( 
				 ()->{ 
					 LinkedList<Ton> list = new LinkedList<>();
					 list.add( getTonika() );
					 return list;
					 },
				 (l,el)->{
					 Ton dalsi = l.getLast().pridejInterval(Interval.SEKUNDA_MALA);
					 l.add(dalsi);
				 },
				 LinkedList::addAll
				); 
	}
	
	@Override
	public Ton getTonika() {
		return tonika;
	}

}
