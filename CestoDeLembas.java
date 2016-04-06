public class CestoDeLembas {

	private int lembas;

	public CestoDeLembas(int lembas) {
		this.lembas = lembas;
	}

	public boolean podeDividirEntre() {

		if (lembas % 2 == 0 && (lembas / 2) != 0 && lembas != 2
				|| lembas % 2 != 0 && (lembas % 2) % 2 == 0 && lembas != 2) {
			
			return true;
		} else {
			
			return false;
		}
	}

}