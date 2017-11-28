package kz.epam.tam.module3.lecture2.taxistation.data.pool;

import org.apache.derby.jdbc.EmbeddedDriver;

import java.sql.*;

public class DerbyDB {

    public static void main(String[] Args){
        ResultSet rs = null;
        Connection con = null;
        Statement statement = null;

        try {
            DriverManager.registerDriver(new EmbeddedDriver());
            con = DriverManager.getConnection("jdbc:derby:my_db;create=true;user=yuriy;password=jurayev");
            statement = con.createStatement();
            statement.executeUpdate("CREATE TABLE Cars(" +
                    "MODEL varchar(255)," +
                    "PRICE int," +
                    "CONSUMPTION int," +
                    "BODY varchar(255)," +
                    "CLASS varchar(255))");
            statement.addBatch("INSERT INTO cars(MODEL,PRICE,CONSUMPTION,BODY,CLASS)VALUES('kia',4000,15,'sedan','comfort')");
            statement.addBatch("INSERT INTO cars(MODEL,PRICE,CONSUMPTION,BODY,CLASS)VALUES('benz',4000,10,'sedan','business')");
            statement.addBatch("INSERT INTO cars(MODEL,PRICE,CONSUMPTION,BODY,CLASS)VALUES('honda',4000,11,'hatchback','econom')");
            statement.addBatch("INSERT INTO cars(MODEL,PRICE,CONSUMPTION,BODY,CLASS)VALUES('audi',4000,9,'vagon','comfort+')");
            statement.addBatch("INSERT INTO cars(MODEL,PRICE,CONSUMPTION,BODY,CLASS)VALUES('WV',5000,12,'vagon','comfort+')");
            statement.addBatch("INSERT INTO cars(MODEL,PRICE,CONSUMPTION,BODY,CLASS)VALUES('bmw',4000,9,'sedan','business')");
            int[] count = statement.executeBatch();
            con.commit();
            rs = statement.executeQuery("SELECT * FROM CARS");
            int columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()){
                System.out.println(rs.getString("model"));
                System.out.println(rs.getInt("price"));
                System.out.println(rs.getInt("consumption"));
                System.out.println(rs.getString("body"));
                /*for(int i =1; i<=columnCount;i++){
                    String object = rs.getString(i);
                    System.out.println(object);
                }
                System.out.println("==================");*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException var17) {
                ;
            }

            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException var16) {
                ;
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException var18) {
                ;
            }

        }


    }
}
