package cz.kojotak.mtf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class KvartKvintovyKruh {
	
	private final int velikost = Ton.PULTONU_V_OKTAVE;
	private final LinkedList<Ton> kvinty = new LinkedList<Ton>();
	private final LinkedList<Ton> kvarty = new LinkedList<Ton>();
	private static final KvartKvintovyKruh INSTANCE = new KvartKvintovyKruh();
	
	private KvartKvintovyKruh() {
		Ton c = new Ton(NazevTonu.C);
		kvinty.add(c);
		kvarty.add(c);
		for(int i=1; i< velikost; i++) {
			kvinty.add( kvinty.getLast().pridejInterval(Interval.KVINTA) );
			kvarty.add( kvarty.getLast().pridejInterval(Interval.KVARTA) );
		}
	}
	
	public static Iterator<Ton> getKvartovyIterator(Ton ton){
		return preskocNa(INSTANCE.kvarty, ton);
	}
	
	public static Iterator<Ton> getKvintovyIterator(Ton ton){
		return preskocNa(INSTANCE.kvinty, ton);
	}
	
	public static List<Ton> getKvarty(Ton ton, int pocet){
		return vygeneruj(ton, preskocNa(INSTANCE.kvarty, ton), pocet);
	}
	
	public static List<Ton> getKvinty(Ton ton, int pocet){
		return vygeneruj(ton, preskocNa(INSTANCE.kvinty, ton), pocet);
	}
	
	static List<Ton> vygeneruj(Ton pocatecni, Iterator<Ton> it, int pocet){
		List<Ton> list = new ArrayList<Ton>();
		list.add(pocatecni);
		for(int i=0; i<pocet; i++) {
			list.add(it.next());
		}
		return list;
	}
	
	static Iterator<Ton> preskocNa(List<Ton> list, Ton t) {
		if(list == null) {
			throw new IllegalArgumentException("Nelze preskakovat v prazdnem seznamu");
		}
		Iterator<Ton> iterator = new InfiniteIterator<Ton>(list);
		do {
			Ton dalsi = iterator.next();
			if(dalsi.equalsEnharmonicky(t)) {
				return iterator;
			}
		}while(true);
	}

	static class InfiniteIterator<T> implements Iterator<T>{

		private final List<T> list;
		private int idx = -1;
		public InfiniteIterator(List<T> list) {
			this.list=list;
		}
		
		@Override
		public boolean hasNext() {
			return true;
		}

		@Override
		public T next() {
			if(idx +1 >= list.size()) {
				idx-= list.size();
			}
			T next = list.get(++idx);
			return next;
		}
		
	}

}
