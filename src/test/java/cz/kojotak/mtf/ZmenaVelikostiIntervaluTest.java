package cz.kojotak.mtf;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ZmenaVelikostiIntervaluTest {

	@Test
	public void zvetseniMaleTercie() {
		assertEquals(Interval.TERCIE_VELKA, Interval.TERCIE_MALA.zvetsena());
	}
	
	@Test
	public void triton() {
		assertEquals(Interval.KVINTA.zmensena().getPultonu(), Interval.KVARTA.zvetsena().getPultonu());
	}

}
