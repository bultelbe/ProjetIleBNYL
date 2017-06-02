package projetilebnyl;

public class Tuile {
	private String nomCase;
	private int colonne;
	private int ligne;
	private int statut;
        
    Tuile(String nomCase){
        this.nomCase=nomCase;
        this.statut=1;
    }
        
    public String getNomCase() {
		return nomCase;
	}

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getStatut() {
         return this.statut;
    }

    public void setStatut(int statut) {
            this.statut=statut;
    }

    public String getPosition() {
        return ("("+this.getColonne()+","+this.getLigne()+")");
    }

    public void afficheTuiles(){
        int x = this.getColonne();
        int y = this.getLigne();
        String nom = this.getNomCase();
        int stat = this.getStatut();
        String statut="";
        if (stat==1){
            statut="Séche";
        }else if(stat==2){
            statut="Innodée";
        }else if(stat==3){
            statut="Coulée";
        }

        System.out.print(nom +" , Colone :"+x+" , Ligne : "+y+" , "+statut);

    }
}

