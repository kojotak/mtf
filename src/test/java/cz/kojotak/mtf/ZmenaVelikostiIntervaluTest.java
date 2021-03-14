package cz.kojotak.mtf;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ZmenaVelikostiIntervaluTest {

	@Test
	public void zvetseniMaleTercie() {
		assertEquals(ZakladniInterval.TERCIE_VELKA, ZakladniInterval.TERCIE_MALA.zvetsena());
	}
	
	@Test
	public void triton() {
		assertEquals(ZakladniInterval.KVINTA.zmensena().getPultonu(), ZakladniInterval.KVARTA.zvetsena().getPultonu());
	}

}
