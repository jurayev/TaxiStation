package kz.epam.tam.module3.lecture2.taxistation.data.readers;

import kz.epam.tam.module3.lecture2.taxistation.model.Car;
import org.apache.derby.jdbc.EmbeddedDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DBReader implements IReader{

    private static final ResourceBundle configBundle = ResourceBundle.getBundle("database");
    private static  final String SQL_SELECT = "SELECT * FROM CARS";
    private String url = configBundle.getString("url");
    private String login = configBundle.getString("login");
    private String password = configBundle.getString("password");


    public List<Car> readData(){

        List<Car> data = new ArrayList<>();
        ResultSet rs = null;
        Connection con = null;
        Statement statement = null;

        try {
            DriverManager.registerDriver(new EmbeddedDriver());
            con = DriverManager.getConnection(url,login,password);
            statement = con.createStatement();
            rs = statement.executeQuery(SQL_SELECT);
            while (rs.next()){
                data.add(new Car(rs.getString("model"),rs.getInt("price"),
                        rs.getInt("consumption"),rs.getString("body")));
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
        return data;
    }

}
