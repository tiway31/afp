package Bdd;

import Model.bean.Article;
import Model.bean.Journaliste;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ArticleDao {

    private Connection connexion;


    public List<Article> recupererTouslesArticles(){

    List<Article> articles =new ArrayList<Article>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT * FROM article LEFT JOIN journaliste on article.journaliste = journaliste.id");

            // Récupération des données
            while (resultat.next()) {
                int id = resultat.getInt("id");
                String titre = resultat.getString("titre");
                String contenu = resultat.getString("contenu");
                Long date= resultat.getLong("date_post");
                int journaliste = resultat.getInt("journaliste");
                String login = resultat.getString("login");

                Article article = new Article();
                article.setTitre(titre);
                article.setContenu(contenu);
                //LocalDateTime now = LocalDateTime.now();
                //article.setDate(new Timestamp(System.currentTimeMillis()));
                article.setDate(date);
                article.setId(id);
                article.setLogin(login);
                article.setJournaliste(journaliste);
                articles.add(article);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }

        return articles;
    }

    private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3308/afp?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "tiway", "tiway");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ajouterArticle(Article article) {
        loadDatabase();

        try {
            //penser à faire un setAutoCommit pour le mettre à false avant de faire une transaction pour pouvoir faire un commit et rollback
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO article(id,titre,contenu,date_post,id_JOURNALISTE) VALUES(?, ?,?,?,?);");
            preparedStatement.setString(1, null);
            preparedStatement.setString(2, article.getTitre());
            preparedStatement.setString(3, article.getContenu());
            preparedStatement.setLong(4, 23251515); //article.getDate()
            preparedStatement.setInt(5, article.getJournaliste());

            Logger logger = Logger.getLogger("com.javacodegeeks.snippets.core");
            logger.warning("TAG_SQL Titre:"+article.getTitre()+" Contenu: "+ article.getContenu()+" Date: "+article.getDate()+" Id: "+article.getJournaliste());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
