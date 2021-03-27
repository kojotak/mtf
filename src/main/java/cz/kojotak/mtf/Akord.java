package cz.kojotak.mtf;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public record Akord (Ton ton, Intervalovy intervaly) implements Obratitelny<Akord> {

	public List<Ton> getTonyAkordu(){
		return intervaly.getIntervaly().stream()
				.collect(this::listSeZakladnimTonem, 
						(list,i) -> list.add(list.getLast().pridejInterval(i)), 
						LinkedList::addAll);
	}
	
	private LinkedList<Ton> listSeZakladnimTonem(){
		LinkedList<Ton> list = new LinkedList<Ton>();
		list.add(ton);
		return list;
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
