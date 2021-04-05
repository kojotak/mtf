package cz.kojotak.mtf;

import java.util.List;

import org.junit.jupiter.api.Test;

class KvartKvintovyKruhTest extends TestovaciTony{

	@Test
	void kvintyOdC() {
		List<Ton> kvinty = KvartKvintovyKruh.getKvinty(c, 12);
		assertContainsAllEnharmonicEquals(kvinty, c, g, d, a, e, h, fis, des, as, es, b, f, c );		
	}
	
	@Test
	void kvartyOdC() {
		List<Ton> kvarty = KvartKvintovyKruh.getKvarty(c, 12);
		assertContainsAllEnharmonicEquals(kvarty, c, f, b, es, as, des, ges, h, e, a, d, g, c);		
	}

	@Test
	void kvintyOdA() {
		List<Ton> kvinty = KvartKvintovyKruh.getKvinty(a, 12);
		assertContainsAllEnharmonicEquals(kvinty, a, e, h, ges, des, as, es, b, f, c, g, d, a );		
	}
	
	@Test
	void kvartyOdEs() {
		List<Ton> kvarty = KvartKvintovyKruh.getKvarty(es, 12);
		assertContainsAllEnharmonicEquals(kvarty, es, as, des, ges, h, e, a, d, g, c, f, b, es);		
	}
}
