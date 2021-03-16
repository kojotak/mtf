package cz.kojotak.mtf;

public class JednoduchaVzdalenost implements Vzdalenost {

	private int pultonu;
	
	public JednoduchaVzdalenost(int pultonu) {
		super();
		this.pultonu = pultonu;
	}

	@Override
	public int getPultonu() {
		return pultonu;
	}
	
	public static Vzdalenost[] rostouciSekvenceIntervalu(int prvni, int posledni) {
		Vzdalenost[] intervaly = new Vzdalenost[posledni-prvni];
		for(int i = prvni; i<posledni; i++) {
			intervaly[i-prvni] = new JednoduchaVzdalenost(i);
		}
		return intervaly;
	}

}
