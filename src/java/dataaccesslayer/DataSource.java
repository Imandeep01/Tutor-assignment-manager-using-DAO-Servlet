/**
Student Name:Imandeep Singh Sidhu
Student Number:041059799
Course & Section #: 22S_CST8288_012
Declaration:This is my own original work and is free from�Plagiarism.
*/
package dataaccesslayer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Imandeep Singh Sidhu
 * @version 1.0
 */
public class DataSource {
    private Connection connection = null;

    /**
     * This method will retrieve Connection from 'database.properties' file and open the connection to MySQL Database.
     * @return the connection to the Database
     */
    public Connection createConnection(){
        // added use of Properties and try-with-resources - kriger
        Properties props = new Properties();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(Exception e){
            
        }

        try (InputStream in = getClass().getClassLoader().getResourceAsStream("database.properties");) {
            props.load(in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }// catch()

        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");
        try {
            if(connection != null){
                System.out.println("Cannot create new connection, one exists already");
            }
            else{
                connection = DriverManager.getConnection(url, username, password);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return connection;
    }
}
