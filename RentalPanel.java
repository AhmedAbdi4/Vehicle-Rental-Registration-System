import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JRadioButton;

public class RentalPanel extends JPanel {
    DBMethod db = new DBMethod();

    private JLabel nameLabel;
    private JLabel pricePerDayLabel;
    private JLabel numberOfDaysLabel;
    private JLabel numberOfMilesLabel;
    private JLabel passengerLabel;
    private JLabel tonSizeLabel;

    private JButton submitButton;

    private JTextField nameField;
    private JTextField pricePerDayField;
    private JTextField numberOfDaysField;
    private JTextField numberOfMilesField;
    private JTextField passengerField;
    private JTextField tonSizeField;

    private JCheckBox car;
    private JCheckBox truck;

    private JRadioButton sedan;
    private JRadioButton coupe;
    private JRadioButton convertible;
    private JRadioButton sport;

    private ButtonGroup radioGroup;
    private ButtonGroup boxGroup;


    public RentalPanel() {
        setLayout(new GridLayout(8,2));
        //textField = new JTextField("Please select the type of vehicle first");

        nameLabel = new JLabel(" Enter name ");
        pricePerDayLabel = new JLabel(" Enter price ");
        numberOfDaysLabel = new JLabel(" Enter number of days ");
        numberOfMilesLabel= new JLabel(" Enter number of miles ");
        passengerLabel = new JLabel (" Please, enter the number of passenger ");
        tonSizeLabel = new JLabel (" Please enter ton size ");

        car = new JCheckBox("Car");
        truck = new JCheckBox("Truck");

        sedan = new JRadioButton("Sedan");
        coupe = new JRadioButton("Coupe");
        convertible = new JRadioButton("Convertible");
        sport = new JRadioButton("Sport");

        radioGroup = new ButtonGroup();
        boxGroup = new ButtonGroup();

        boxGroup.add(car);
        boxGroup.add(truck);

        radioGroup.add(sedan);
        radioGroup.add(coupe);
        radioGroup.add(convertible);
        radioGroup.add(sport);

        submitButton = new JButton(" Click to Submit ");

        nameField = new JTextField(20);
        nameField.setToolTipText(" e.g first and last name ");
        pricePerDayField = new JTextField(20);
        pricePerDayField.setToolTipText(" e.g  $ 15.00 ");
        numberOfDaysField = new JTextField(20);
        numberOfDaysField.setToolTipText(" must be a whole number. e.g '10' ");
        numberOfMilesField= new JTextField(20);
        numberOfMilesField.setToolTipText(" Please enter a whole number ");
        passengerField = new JTextField(20);
        passengerField.setToolTipText(" must be a whole number ");
        tonSizeField = new JTextField(20);
        tonSizeField.setToolTipText(" must be a whole number ");

        // when the customer selects car
        car.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                passengerLabel.setEnabled(true);
                passengerField.setEnabled(true);
                sedan.setEnabled(true);
                coupe.setEnabled(true);
                convertible.setEnabled(true);
                sport.setEnabled(true);
                tonSizeLabel.setEnabled(false);
                tonSizeField.setEnabled(false);
            }
        });

        // when the customer selects truck
        truck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (truck.isSelected()) {
                    passengerLabel.setEnabled(false);
                    passengerField.setEnabled(false);
                    sedan.setEnabled(false);
                    coupe.setEnabled(false);
                    convertible.setEnabled(false);
                    sport.setEnabled(false);
                    tonSizeLabel.setEnabled(true);
                    tonSizeField.setEnabled(true);
                }

            }
        });

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String name;
                double pricePerDay;
                int numberOfDays;
                int numberOfMiles;
                int passenger;
                int tonSize;

                if(validInput()) {

                    name = nameField.getText();
                    pricePerDay = Double.parseDouble(pricePerDayField.getText());
                    numberOfDays = Integer.parseInt(numberOfDaysField.getText());
                    numberOfMiles = Integer.parseInt(numberOfMilesField.getText());
                    tonSize = Integer.parseInt(tonSizeField.getText());
                    passenger=Integer.parseInt(passenger.getText());

                    db.connectDatabase();
                    db.insertRental(name, pricePerDay, numberOfDays, numberOfMiles, tonSize, passenger);

                    clearAll();
                }

            }
        });
        add(car);
        add(truck);
        add(nameLabel);
        add(nameField);
        add(pricePerDayLabel);
        add(pricePerDayField);
        add(numberOfDaysLabel);
        add(numberOfDaysField);
        add(numberOfMilesLabel);
        add(numberOfMilesField);
        add(passengerLabel);
        add(passengerField);
        add(tonSizeLabel);
        add(tonSizeField);

        add(submitButton);
    }

    public void clearAll() {
        pricePerDayField.setText("");
        numberOfDaysField.setText("");
        numberOfMilesField.setText("");
        passengerField.setText("");
        tonSizeField.setText("");

        pricePerDayField.requestFocus();

    }

    public boolean validInput() {
        if(pricePerDayField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "enter a price");
            pricePerDayField.requestFocus();
            return false;
        }
        else if(numberOfDaysField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "enter num of days");
            numberOfDaysField.requestFocus();
            return false;

        }

        else if(numberOfMilesField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "enter num of miles");
            numberOfMilesField.requestFocus();
            return false;
        }
        else if(passengerField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "enter the number of passenger");
            passengerField.requestFocus();
            return false;
        }
        else if(tonSizeField.getText().isEmpty() ) {

            //JOptionPane.showMessageDialog(null, "enter the tonSize");
            //tonSizeField.requestFocus();

            return false;
        }
        else if(truck.isSelected()) {
            if(tonSizeField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "enter num of days");
                numberOfDaysField.requestFocus();
                return false;
            }

        }
        return true;

    }
}
