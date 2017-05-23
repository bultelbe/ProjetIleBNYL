public class Tuile {
	private String _nomCase;
	private int _colonne;
	private int _ligne;
	private int _statut;

	public String getNomCase() {
		return this._nomCase;
	}

	public int getStatut(String aNomCase) {
		throw new UnsupportedOperationException();
	}

	public void setStatut(int aStatut) {
		throw new UnsupportedOperationException();
	}

	public Tuile getPosition() {
		throw new UnsupportedOperationException();
	}
}