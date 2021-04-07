package cz.kojotak.mtf.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class InfiniteIteratorTest {

	@Test
	void infiniteIteratorFromTwoElements() {
		List<Boolean> list = Arrays.asList(true, false);
		InfiniteIterator<Boolean> it = new InfiniteIterator<Boolean>(list);
		Boolean[] values = new Boolean[6];
		for(int i =0; i<values.length; i++) {
			values[i] = it.next();
		}
		assertArrayEquals(new Boolean[] {true, false, true, false, true, false}, values);
	}
	
	@Test
	void infiniteReversedIteratorFromTwoElements() {
		List<Boolean> list = Arrays.asList(true, false);
		InfiniteIterator<Boolean> it = new InfiniteIterator<Boolean>(list).reversed();
		Boolean[] values = new Boolean[6];
		for(int i =0; i<values.length; i++) {
			values[i] = it.next();
		}
		assertArrayEquals(new Boolean[] {false, true, false, true, false, true}, values);
	}

}
