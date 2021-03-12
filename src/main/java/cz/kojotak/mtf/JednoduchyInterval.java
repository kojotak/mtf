package cz.kojotak.mtf;

public class JednoduchyInterval implements Interval {

	private int pultonu;
	
	public JednoduchyInterval(int pultonu) {
		super();
		this.pultonu = pultonu;
	}

	@Override
	public int getPultonu() {
		return pultonu;
	}
	
	public static Interval[] rostouciSekvenceIntervalu(int maximum) {
		Interval[] intervaly = new Interval[maximum];
		for(int i = 0; i<maximum; i++) {
			intervaly[i] = new JednoduchyInterval(i);
		}
		return intervaly;
	}

}
