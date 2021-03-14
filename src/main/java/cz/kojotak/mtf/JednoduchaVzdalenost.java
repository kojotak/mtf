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
	
	public static Vzdalenost[] rostouciSekvenceIntervalu(int maximum) {
		Vzdalenost[] intervaly = new Vzdalenost[maximum];
		for(int i = 0; i<maximum; i++) {
			intervaly[i] = new JednoduchaVzdalenost(i);
		}
		return intervaly;
	}

}
