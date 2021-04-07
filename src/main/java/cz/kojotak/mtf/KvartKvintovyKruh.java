package cz.kojotak.mtf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import cz.kojotak.mtf.util.InfiniteIterator;

public class KvartKvintovyKruh {

	private static final int VELIKOST = Ton.PULTONU_V_OKTAVE;

	// vnejsi, durovy kruh
	private final LinkedList<Ton> kvinty = new LinkedList<Ton>();

	// vnitrni, mollovy kruh
	private final LinkedList<Ton> kvarty = new LinkedList<Ton>();
	private static final KvartKvintovyKruh INSTANCE = new KvartKvintovyKruh();

	private KvartKvintovyKruh() {
		kvinty.add(new Ton(NazevTonu.C));
		kvarty.add(new Ton(NazevTonu.A));
		for (int i = 1; i < VELIKOST; i++) {
			kvinty.add(kvinty.getLast().pridejInterval(Interval.KVINTA));
			kvarty.add(kvarty.getLast().pridejInterval(Interval.KVARTA));
		}
	}

	public static Iterator<Ton> getKvartovyIterator(Ton ton) {
		return preskocNa(INSTANCE.kvarty, ton);
	}

	public static Iterator<Ton> getKvintovyIterator(Ton ton) {
		return preskocNa(INSTANCE.kvinty, ton);
	}

	public static List<Ton> getKvarty(Ton ton, int pocet) {
		return vygeneruj(ton, preskocNa(INSTANCE.kvarty, ton), pocet);
	}

	public static List<Ton> getKvinty(Ton ton, int pocet) {
		return vygeneruj(ton, preskocNa(INSTANCE.kvinty, ton), pocet);
	}

	public static Predznamenani getDurovePredznamenani(Ton ton) {
		//fixme
//		for (int i = 0; i <= VELIKOST / 2; i++) {
//			if (INSTANCE.kvinty.get(i).equalsEnharmonicky(ton)) {
//				return new Predznamenani(posbirejTonPredznamenani(INSTANCE.kvinty, ton, i),null);
//			}
//		}
//		for (int i = 0; i <= VELIKOST / 2; i++) {
//			if (INSTANCE.kvinty.get(VELIKOST - i).equalsEnharmonicky(ton)) {
//				return new Predznamenani(posbirejTonPredznamenani(INSTANCE.kvinty, ton, i),null);
//			}
//		}
		return new Predznamenani(null, null);
	}

	private static List<Ton> posbirejTonPredznamenani(List<Ton> tony, Ton ton, int pocet){
		Iterator<Ton> it = preskocNa(INSTANCE.kvinty, ton).reversed();
	    it.next();
	    it.next();
	    List<Ton> result = new ArrayList<>();
		for(int i = 0; i<pocet; i++) {
			result.add(it.next());
		}
		return result;
	}

	public static Predznamenani getMollovePredznamenani(Ton ton) {
		return new Predznamenani(null, null);
	}

	static List<Ton> vygeneruj(Ton pocatecni, Iterator<Ton> it, int pocet) {
		List<Ton> list = new ArrayList<Ton>();
		list.add(pocatecni);
		for (int i = 0; i < pocet; i++) {
			list.add(it.next());
		}
		return list;
	}

	static InfiniteIterator<Ton> preskocNa(List<Ton> list, Ton t) {
		if (list == null) {
			throw new IllegalArgumentException("Nelze preskakovat v prazdnem seznamu");
		}
		InfiniteIterator<Ton> iterator = new InfiniteIterator<>(list);
		do {
			Ton dalsi = iterator.next();
			if (dalsi.equalsEnharmonicky(t)) {
				return iterator;
			}
		} while (true);
	}

}
