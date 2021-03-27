package cz.kojotak.mtf;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ZmenaVelikostiIntervaluTest {

	@Test
	public void zvetseniMaleTercie() {
		assertEquals(Interval.TERCIE_VELKA, Interval.TERCIE_MALA.zvetsit());
	}
	
	@Test
	public void triton() {
		assertEquals(Interval.KVINTA.zmensit().getPultonu(), Interval.KVARTA.zvetsit().getPultonu());
	}

}
