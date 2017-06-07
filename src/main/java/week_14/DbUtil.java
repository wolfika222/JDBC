package week_14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Hp_Workplace on 2017. 06. 07..
 */
public class DbUtil {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Helixlab";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "Homme!89";
    private static final String DB_DRIVER_NAME = "org.postgresql.Driver";


    public static Connection getConnection(){

        Connection connection = null;
        Properties p = getProperties();
        try {
            Class.forName(p.getProperty("DB_DRIVER_NAME"));
            connection = DriverManager.getConnection(p.getProperty("DB_URL"),p.getProperty("DB_USER"),p.getProperty("DB_PASSWORD"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static Properties getProperties(){
        Properties p = new Properties();
        FileInputStream fls = null;
        try {
            fls = new FileInputStream("C:\\Users\\Hp_Workplace\\IdeaProjects\\gyak_14\\src\\main\\resources\\db.properties");
            p.load(fls);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }
}
