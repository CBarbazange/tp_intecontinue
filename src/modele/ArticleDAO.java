package modele;

import java.text.DecimalFormat;
import javax.persistence.EntityManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

public class ArticleDAO {
    private static DecimalFormat df = new DecimalFormat("0.00");
    private String dbUrl;
    private String user;
    private String pswd;
    private Connection conn;
    
    public ArticleDAO() {
    	this.dbUrl = "jdbc:mysql://localhost:3306/intecontyoann";
        this.user = "root";
        this.pswd = "";
    }
    
   protected void connect() throws SQLException {
       if (conn == null || conn.isClosed()) {
           try {
               Class.forName("com.mysql.jdbc.Driver");
           } catch (ClassNotFoundException e) {
               throw new SQLException(e);
           }
           conn = DriverManager.getConnection(dbUrl, user, pswd);
       }
   }
    
   protected void disconnect() throws SQLException {
       if (conn != null && !conn.isClosed()) {
           conn.close();
       }
   }

    public void addArticle(Article a) {
        // TODO
    }

    public List<Article> getArticles(int clientId) {
        List<Article> articles = new ArrayList<>();
        Client client = new Client();
        
        String sqlClient = "SELECT contrat.marge_contract FROM contrat INNER JOIN client ON contrat.id = client.id_contrat WHERE client.id = ?";
         
        String sqlArticles = "SELECT * FROM article";
         
        try {
        	connect();
            	
            PreparedStatement stClient = conn.prepareStatement(sqlClient);
            stClient.setInt(1, clientId);
            ResultSet resClient = stClient.executeQuery();
            
            if (resClient.next() == false) {
            	return articles;
            }
            
            float marge = 0;

            marge = resClient.getFloat("marge_contract");
             
            Statement stArticles = conn.createStatement();
            //ResultSet resultSet= stClient.executeQuery();
            ResultSet resultSet= stArticles.executeQuery(sqlArticles);
            
             
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                float prix = (resultSet.getFloat("prix") * ((100 + marge) / 100));
                 
                Article art = new Article(id, nom, prix);
                articles.add(art);
            }
             
            resultSet.close();
            stArticles.close();
			disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        return articles;
    }    
}
