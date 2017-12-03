package kz.epam.tam.module3.lecture234.taxistation.data.readers;

import kz.epam.tam.module3.lecture234.taxistation.model.CargoTaxi;
import kz.epam.tam.module3.lecture234.taxistation.model.PassengerTaxi;
import kz.epam.tam.module3.lecture234.taxistation.model.Vehicle;
import org.apache.derby.jdbc.EmbeddedDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DBReader implements IReader{

    private static final ResourceBundle configBundle = ResourceBundle.getBundle("database");
    private String url = configBundle.getString("url");
    private String login = configBundle.getString("login");
    private String password = configBundle.getString("password");


    public List<Vehicle> readData(String sql){

        List<Vehicle> data = new ArrayList<>();
        ResultSet rs = null;
        Connection con = null;
        Statement statement = null;

        try {
            DriverManager.registerDriver(new EmbeddedDriver());
            con = DriverManager.getConnection(url,login,password);
            statement = con.createStatement();
            switch (sql){
                case "SELECT * FROM PASSENGERTAXI":
                    rs = statement.executeQuery(sql);
                    while (rs.next()){
                        data.add(new PassengerTaxi(rs.getString("model"),rs.getInt("price"),
                                rs.getInt("consumption"),rs.getString("body"), rs.getString("body")));
                    }
                    break;
                case "SELECT * FROM CARGOTAXI":
                    rs = statement.executeQuery(sql);
                    while (rs.next()){
                        data.add(new CargoTaxi(rs.getString("model"),rs.getInt("price"),
                                rs.getInt("consumption"),rs.getInt("capacity"), rs.getString("shipping")));
                    }
                    break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e3) {
                e3.printStackTrace();
            }

        }
        return data;
    }

}
