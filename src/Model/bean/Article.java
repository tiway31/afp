package Model.bean;

import java.sql.Timestamp;
import java.util.List;

public class Article {

    private int id;
    private String titre;
    private String contenu;
    private Long date;
    private List<String> tagList;
    private int journaliste;
    private String Login;

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public int getJournaliste() {
        return journaliste;
    }

    public void setJournaliste(int journaliste) {
        this.journaliste = journaliste;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
