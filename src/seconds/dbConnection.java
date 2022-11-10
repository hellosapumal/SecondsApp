/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seconds;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import javax.sql.DataSource;

/**
 *
 * @author Sapumal Bandara
 */
@SuppressWarnings("StaticNonFinalUsedInInitialization")
public class dbConnection {

    private static int isLocal = 1; //if using in developments; set value to 1. else set it to 0.

    private static String SERVER;
    public static int LOGIN_SET;
    private static String DB;
    private static String USER;
    private static String PASS;
    private static ComboPooledDataSource dataSource;

    //connection POOl jdbc:derby://localhost:1527/second_by_hellosapumal
    static {
        try {

            if (isLocal == 1) {
                LOGIN_SET = 1;
                DB = "second_by_hellosapumal";
                USER = "root";
                PASS = "123";
                SERVER = "localhost";

            } else {
                LOGIN_SET = 0;
                DB = "techseed_gold_rush";
                USER = "root";
                PASS = "ServerAdmin@SW$GR";
                SERVER = "172.105.48.26";

            }

            dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass("org.apache.derby.jdbc.ClientDriver");
//            dataSource.setJdbcUrl("jdbc:derby://" + SERVER + ":1527/" + DB);
            dataSource.setJdbcUrl("jdbc:derby://localhost:1527/seconds_by_hellosapumal");
            dataSource.setUser(USER);
            dataSource.setPassword(PASS);

// the settings below are optional -- c3p0 can work with defaults
            dataSource.setMinPoolSize(5);
            dataSource.setAcquireIncrement(5);
            dataSource.setMaxPoolSize(1000);
            dataSource.setTestConnectionOnCheckout(true);

        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    //OLD CONNECTION
//    static Connection getconnection() throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");
//
//        String url = "jdbc:mysql://" + SERVER + ":3306/" + DB + "?useUnicode=true&characterEncoding=UTF-8";
//        Connection c = DriverManager.getConnection(url, USER, PASS);
//        return c;
//
//    }
//    public static void main(String[] args) {
//        String ENV = System.getenv("TECHSEED");
//        String javaHome = System.getenv("JAVA_HOME");
//        System.out.println(javaHome);
//    }
}
