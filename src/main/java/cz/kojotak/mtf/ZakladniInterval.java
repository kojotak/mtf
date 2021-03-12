package cz.kojotak.mtf;

public enum ZakladniInterval implements Interval {
	
	PRIMA(0, 1),
	SEKUNDA_MALA(1, 2),
	SEKUNDA_VELKA(2, 2),
	TERCIE_MALA(3, 3),
	TERCIE_VELKA(4, 3),
	KVARTA_ZMENSENA(4,4),
	KVARTA(5, 4),
	KVARTA_ZVETSENA(6,4),
	KVINTA_ZMENSENA(6,5),
	KVINTA(7, 5),
	KVINTA_ZVETSENA(8,5),
	SEXTA_MALA(8, 6),
	SEXTA_VELKA(9, 6),
	SEPTIMA_MALA(10, 7),
	SEPTIMA_VELKA(11, 7),
	OKTAVA(12, 8),
	NONA_MALA(13, 9),
	NONA_VELKA(14, 9),
	DECIMA_MALA(15,10),
	DECIMA_VELKA(16,10),
	UNDECIMA(17,11),
	DUODECIMA(19,12),
	TERCDECIMA_MALA(20,13),
	TERCDECIMA_VELKA(21,13),
	KVARTDECIMA_MALA(22,14),
	KVARTDECIMA_VELKA(23,14),
	KVINTDECIMA_VELKA(24,15),
	;
	
	private final int pultonu;
	private final int stupen;
	private ZakladniInterval(int pultonu, int stupen) {
		this.pultonu = pultonu;
		this.stupen = stupen;
	}
	@Override
	public int getPultonu() {
		return pultonu;
	}
	public int getStupen() {
		return stupen;
	}
	
}
