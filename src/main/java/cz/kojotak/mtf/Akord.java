package cz.kojotak.mtf;

import java.util.ArrayList;
import java.util.List;

public record Akord (Ton ton, Intervalovy intervaly) implements Obratitelny<Akord> {

	public List<Ton> getTonyAkordu(){
//TODO pouzit streamy
//		return Stream.concat(
//					Stream.of(ton),
//					intervaly.getIntervaly().stream().map( i -> ton.pridejInterval(i) ))
//			.sorted(Comparator.comparing(Ton::getPoradi))
//			.collect(Collectors.toList());
		
		List<Ton> tony = new ArrayList<>();
		Ton posledni = this.ton();
		tony.add(posledni);
		for(Interval interval : intervaly.getIntervaly()) {
			posledni = posledni.pridejInterval(interval);
			tony.add(posledni);
		}
		return tony;
	}

	@Override
	public Akord obratit() {
		Ton zakladniTon = getTonyAkordu().get(1);
		Interval obratPrvnihoIntervalu = intervaly().getIntervaly().get(0).obratit();
		Interval druhyInterval = intervaly().getIntervaly().get(1);
		Interval posledniInterval = obratPrvnihoIntervalu.odecti(druhyInterval);
		List<Interval> intervaly = new ArrayList<>();
		intervaly.addAll(intervaly().getIntervaly().subList(1, intervaly().getIntervaly().size()));
		intervaly.add(posledniInterval);
		return new Akord(zakladniTon, () -> {return intervaly;} );//TODO zrefaktorovat, tohle je pouha obezlicka
	}
	
}
