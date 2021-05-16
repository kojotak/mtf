package cz.kojotak.mtf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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

	
	public static List<Ton> getKvarty(Ton ton, int pocet) {
	return getTonyKruhu(ton, INSTANCE.kvarty, pocet);
	}

	public static List<Ton> getKvinty(Ton ton, int pocet) {
		return getTonyKruhu(ton, INSTANCE.kvinty, pocet);
	}
	
	private static List<Ton> getTonyKruhu(Ton ton, List<Ton> kruh, int pocet) {
		List<Ton> result = new ArrayList<>();
		int idx = 0;
		while(result.size()<=pocet) {
			Ton t = kruh.get(idx);
			if(t.equalsEnharmonicky(ton) || !result.isEmpty()) {
				result.add(t);
			}
			idx++;
			if(idx>=VELIKOST) {
				idx=0;
			}
		}
		return result;
	}

	public static Predznamenani getDurovePredznamenani(Ton ton) {
		//fixme
		return Predznamenani.zadne();
	}

	public static Predznamenani getMollovePredznamenani(Ton ton) {
		return Predznamenani.zadne();
	}


}
