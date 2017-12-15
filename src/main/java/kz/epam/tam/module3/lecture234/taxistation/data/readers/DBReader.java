package kz.epam.tam.module3.lecture234.taxistation.data.readers;

import kz.epam.tam.module3.lecture234.taxistation.model.Taxi;
import kz.epam.tam.module3.lecture234.taxistation.model.TaxiStation;
import kz.epam.tam.module3.lecture234.taxistation.property.PropertyProvider;
import org.apache.derby.jdbc.EmbeddedDriver;

import java.sql.*;

public class DBReader implements IReader{

    private static final String SQL_SELECT = "SELECT * FROM TAXIS";

    public TaxiStation readData(){
        TaxiStation taxiStation = new TaxiStation();
        ResultSet rs = null;
        Connection con = null;
        Statement statement = null;
        try {
            DriverManager.registerDriver(new EmbeddedDriver());
            con = DriverManager.getConnection(PropertyProvider.getProperty("url"),PropertyProvider.getProperty("login"),
                    PropertyProvider.getProperty("password"));
            statement = con.createStatement();
            rs = statement.executeQuery(SQL_SELECT);
            while (rs.next()){
                taxiStation.addTaxi(new Taxi(rs.getString("model"),rs.getInt("price"),
                        rs.getInt("consumption"),rs.getString("body"), rs.getString("class")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                try{
                    rs.close();
                }catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            if (statement != null) {
                try{
                    statement.close();
                }catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
            if (con != null) {
                try{
                    con.close();
                } catch (SQLException e3) {
                    e3.printStackTrace();
                }
            }
        }
        return taxiStation;
    }

}
