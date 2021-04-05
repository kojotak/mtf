package cz.kojotak.mtf;

import static cz.kojotak.mtf.NazevTonu.A;
import static cz.kojotak.mtf.NazevTonu.C;
import static cz.kojotak.mtf.NazevTonu.D;
import static cz.kojotak.mtf.NazevTonu.E;
import static cz.kojotak.mtf.NazevTonu.F;
import static cz.kojotak.mtf.NazevTonu.G;
import static cz.kojotak.mtf.NazevTonu.H;
import static cz.kojotak.mtf.Posuvka.BECKO;
import static cz.kojotak.mtf.Posuvka.KRIZEK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

public abstract class TestovaciTony {

	protected static final Ton c=new Ton(C),d = new Ton(D),e = new Ton(E),f=new Ton(F),g=new Ton(G),a=new Ton(A),h=new Ton(H),
			cis=new Ton(C,KRIZEK),dis=new Ton(D,KRIZEK),eis=new Ton(E,KRIZEK),fis=new Ton(F,KRIZEK),gis=new Ton(G,KRIZEK),ais=new Ton(A,KRIZEK),his=new Ton(H,KRIZEK),
			ces=new Ton(C,BECKO),des=new Ton(D,BECKO),es=new Ton(E,BECKO),fes=new Ton(F,BECKO),ges=new Ton(G,BECKO),as=new Ton(A,BECKO),hes=new Ton(H,BECKO),
			b=hes;
	
	protected static void assertContainsAllExact(List<Ton> seznamTonu , Ton ...ocekavaneTony) {
		assertEquals( ocekavaneTony.length, seznamTonu.size() );
		for(int i = 0; i < ocekavaneTony.length; i++) {
			Ton testovany = seznamTonu.get(i);
			Ton ocekavany = ocekavaneTony[i];
			assertEquals(ocekavany.getPoradi(), testovany.getPoradi(), "i:"+i+", o:"+ocekavany+", t:"+testovany);
		}
	}
	
	protected static void assertContainsAllEnharmonicEquals(List<Ton> seznamTonu , Ton ...ocekavaneTony) {
		assertEquals( ocekavaneTony.length, seznamTonu.size() );
		for(int i = 0; i < ocekavaneTony.length; i++) {
			Ton testovany = seznamTonu.get(i);
			Ton ocekavany = ocekavaneTony[i];
			assertTrue(ocekavany.equalsEnharmonicky(testovany), " enharmonicke stejne i:"+i+", o:"+ocekavany+", t:"+testovany);
		}
	}
}
