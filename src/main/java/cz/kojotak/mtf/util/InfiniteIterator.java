package cz.kojotak.mtf.util;

import java.util.Iterator;
import java.util.List;

public class InfiniteIterator<T> implements Iterator<T>{

	private final List<T> list;
	private int idx;
	private boolean reversed;
	
	public InfiniteIterator(List<T> list) {
		this(list, false);
	}
	public InfiniteIterator(List<T> list, boolean reversed) {
		this.list = list;
		this.reversed = reversed;
		this.idx = reversed ? 0 : -1;
	}
	
	public InfiniteIterator<T> reversed() {
		return new InfiniteIterator<T>(this.list, !reversed);
	}
	
	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public T next() {
		if(!reversed && idx +1 >= list.size()) {
			idx-= list.size();
		} else if(reversed && idx<=0) {
			idx+= list.size();
		}
		T next = list.get(reversed ? --idx : ++idx);
		return next;
	}
	
}