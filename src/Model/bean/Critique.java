package Model.bean;

public class Critique {

    private int id_ARTICLE;
    private int id_JOURNALISTE;
    private int interet;
    private String comment;
    private boolean valide;

    public int getId_ARTICLE() {
        return id_ARTICLE;
    }

    public void setId_ARTICLE(int id_ARTICLE) {
        this.id_ARTICLE = id_ARTICLE;
    }

    public int getId_JOURNALISTE() {
        return id_JOURNALISTE;
    }

    public void setId_JOURNALISTE(int id_JOURNALISTE) {
        this.id_JOURNALISTE = id_JOURNALISTE;
    }

    public int getInteret() {
        return interet;
    }

    public void setInteret(int interet) {
        this.interet = interet;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }
}
