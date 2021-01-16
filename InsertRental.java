package javaapplication45;

import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class InsertRental {
    static final String DATABASE_URL = "jdbc:derby:rental";

    public static void main(String args[]) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String n = nameField.getText();
        String s = streetField.getText();
        String c = cityField.getText();
        String st = stateField.getText();
        String z = zipCodeField.getText();
        String cc = creditCardNumberField.getText();
        String pn = phoneNumberField.getText();
        int res;

        PreparedStatement insertRental = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL,
                    "davis","davis");

            statement = connection.createStatement();

//this statement updates the database without prepared statements
//statement.executeUpdate("Insert into rental(customername, priceperday) values('5','6')");

//these statements demonstrate prepared statements

            insertRental = connection.prepareStatement("Insert into customer(name, street, city, state, zip, creditcard, phonenumber) values(?,?,?,?,?,?,?)");

            insertRental.setString(1,n);
            insertRental.setString(2,s);
            insertRental.setString(3,c);
            insertRental.setString(4,st);
            insertRental.setString(5,z);
            insertRental.setString(6,cc);
            insertRental.setString(7,pn);


            res = insertRental.executeUpdate();
        }

        catch(SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
