import java.sql.*;
import javax.swing.*;

public class DBMethod {
    private final String DATABASE_URL = "jdbc:derby:rental";
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private int res;
    private int ser;
    private PreparedStatement insertCustomer = null;
    private PreparedStatement insertRental = null;

    public void insertCustomer(String name, String street, String city, String state, String zip, String creditCardNumber, String phoneNumber) {

        try {
            connection = DriverManager.getConnection(DATABASE_URL, "davis", "davis");

            statement = connection.createStatement();

            insertCustomer = connection.prepareStatement("Insert into customer(name,street,city,state,zip,creditcardnumber,phonenumber) values(?,?,?,?,?,?,?)");

            insertCustomer.setString(1, name);
            insertCustomer.setString(2, street);
            insertCustomer.setString(3, city);
            insertCustomer.setString(4, state);
            insertCustomer.setString(5, zip);
            insertCustomer.setString(6, creditCardNumber);
            insertCustomer.setString(7, phoneNumber);

            res = insertCustomer.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        public void insertRental (String name,double pricePerDay, int numberOfDays, int numberOfMiles, String carType,
        int tonSize, int passenger){

            try {
                connection = DriverManager.getConnection(DATABASE_URL, "davis", "davis");
                statement = connection.createStatement();

                insertRental = connection.prepareStatement("Insert into rental (name, pricePerDay, numberOfDays, numberOfMiles, carType, tonSize,passenger ) values (?,?,?,?,?,?,?)");
                insertRental.setString(1, name);
                insertRental.setDouble(2, pricePerDay);
                insertRental.setInt(3, numberOfDays);
                insertRental.setInt(4, numberOfMiles);
                insertRental.setString(5, carType);

                insertRental.setInt(6, tonSize);

                insertRental.setInt(7, passenger);

                ser = insertRental.executeUpdate();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }

        }
        public void DisplayCustomer () {
            final String DATABASE_URL = "jdbc:derby:rental";
            final String SELECT_QUERY = "SELECT name, street, city, state, zip, creditCardNumber, phoneNumber FROM customer";

            try {
                connection = DriverManager.getConnection(
                        DATABASE_URL, "davis", "davis");
                statement = connection.createStatement();
                resultSet = statement.executeQuery(SELECT_QUERY);

                // get ResultSet's meta data
                ResultSetMetaData metaData = resultSet.getMetaData();
                int numberOfColumns = metaData.getColumnCount();

                System.out.printf("Customers Database:%n%n");

                for (int i = 1; i <= numberOfColumns; i++) {
                    System.out.printf("%-8s\t", metaData.getColumnName(i));
                }
                System.out.println();

                while (resultSet.next()) {
                    for (int i = 1; i <= numberOfColumns; i++) {
                        System.out.printf("%-8s\t", resultSet.getObject(i));
                    }
                    System.out.println();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

        public void DisplayRental () {

            final String DATABASE_URL = "jdbc:derby:rental";
            final String SELECT_QUERY = "SELECT name, pricePerDay, numberOfDays, numberOfMiles, carType, tonSize, passenger FROM rental";


            try {
                connection = DriverManager.getConnection(
                        DATABASE_URL, "davis", "davis");
                statement = connection.createStatement();
                resultSet = statement.executeQuery(SELECT_QUERY);

                // get ResultSet's meta data
                ResultSetMetaData metaData = resultSet.getMetaData();
                int numberOfColumns = metaData.getColumnCount();

                System.out.printf("Rental Database:%n%n");


                for (int i = 1; i <= numberOfColumns; i++) {
                    System.out.printf("%-8s\t", metaData.getColumnName(i));
                }
                System.out.println();


                while (resultSet.next()) {
                    for (int i = 1; i <= numberOfColumns; i++) {
                        System.out.printf("%-8s\t", resultSet.getObject(i));
                    }
                    System.out.println();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

        public void CalculateCharge () {
            final String DATABASE_URL = "jdbc:derby:rental";
            final String SELECT_QUERY = "SELECT name, pricePerDay, numberOfDays from rental";

            try {
                connection = DriverManager.getConnection(DATABASE_URL, "davis", "davis");
                statement = connection.createStatement();
                resultSet = statement.executeQuery(SELECT_QUERY);
                ResultSetMetaData metaData = resultSet.getMetaData();
                String name = "";
                String msg = "";
                double price = 0;
                int day = 0;
                double total = 0;
                int numberOfColumns = metaData.getColumnCount();

                while (resultSet.next()) {
                    for (int i = 1; i <= numberOfColumns; i++) {
                        if (metaData.getColumnName(i).equals("NAME")) {
                            name = String.valueOf(resultSet.getObject(i));
                        } else if (metaData.getColumnName(i).equals("PRICEPERDAY")) {
                            price = ((Number) resultSet.getObject(i)).floatValue();
                        } else if (metaData.getColumnName(i).equals("NUMBEROFDAYS")) {
                            day = ((Number) resultSet.getObject(i)).intValue();
                        }

                    }
                    total = price * day;

                    msg += String.format("%s%s$%.2f%n", name, "   ", total);

                    total = 0;
                }
                JOptionPane.showMessageDialog(null, msg);
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
    }
}