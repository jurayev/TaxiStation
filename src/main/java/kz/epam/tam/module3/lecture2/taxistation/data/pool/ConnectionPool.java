package kz.epam.tam.module3.lecture2.taxistation.data.pool;

import org.apache.commons.dbcp2.BasicDataSource;

import java.util.ResourceBundle;

public class ConnectionPool {

    private static final int WAITING_TIMEOUT_SEC = 10;
    private static final ResourceBundle configBundle = ResourceBundle.getBundle("database");
    private static final int DEFAULT_POOL_SIZE = Integer.parseInt(configBundle.getString("defaultPoolSize"));
    private static BasicDataSource instance;


    /**
     * This method returns single instance of {@code BasicDataSource}
     * @return instance of {@code BasicDataSource}
     */
    public static BasicDataSource getInstance() {
        if (instance == null) {
            instance = new BasicDataSource();
            init(instance);
            System.out.println("connection has been established");
        }
        return instance;
    }

    /**
     * This method configure our connection pool
     * @param instance is instance of {@code BasicDataSource}(our connectionPool)
     */
    private static void init(BasicDataSource instance){
        //instance.setDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        instance.setUrl(configBundle.getString("url"));
        instance.setPassword(configBundle.getString("password"));
        instance.setUsername(configBundle.getString("login"));
        instance.setDefaultQueryTimeout(WAITING_TIMEOUT_SEC);
        //instance.setMaxTotal(DEFAULT_POOL_SIZE);
        instance.setMaxConnLifetimeMillis(12000);
        instance.setMaxOpenPreparedStatements(100);

    }
}

