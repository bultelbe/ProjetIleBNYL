package projetilebnyl;

public class Tuile {
	private String nomCase;
	private int colonne;
	private int ligne;
	private int statut;
        //1=sec 2=innodé 3=coulée

    public Tuile(String _nomCase) {
        this.nomCase = _nomCase;
        this.statut=0;
    }
   
        
    public String getNomCase() {
        return this.nomCase;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int _colonne) {
        this.colonne = _colonne;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int _ligne) {
        this.ligne = _ligne;
    }
       
    
    public int getStatut(String aNomCase) {
	return this.statut;
    }

    public void setStatut(int aStatut) {
	this.statut=aStatut;
    }

    public String getPosition() {
        return ("("+this.getColonne()+","+this.getLigne()+")");
    }
}