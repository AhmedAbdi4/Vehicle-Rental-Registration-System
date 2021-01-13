import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CustomerPanel extends JPanel {

    DBMethod db = new DBMethod();

    private JLabel nameLabel;
    private JLabel streetLabel;
    private JLabel cityLabel;
    private JLabel stateLabel;
    private JLabel zipCodeLabel;
    private JLabel creditCardNumberLabel;
    private JLabel phoneNumberLabel;

    private JLabel buttonLabel;
    private JButton submitButton;

    private JTextField nameField;
    private JTextField streetField;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField zipCodeField;
    private JTextField creditCardNumberField;
    private JTextField phoneNumberField;


    public CustomerPanel() {
        setLayout(new GridLayout(8,2));

        nameLabel = new JLabel(" Enter name");
        streetLabel = new JLabel(" Enter Street");
        cityLabel= new JLabel("Enter city");
        stateLabel= new JLabel("Enter state");
        zipCodeLabel= new JLabel("Enter zip code");
        creditCardNumberLabel= new JLabel("Enter a credit card number");
        phoneNumberLabel= new JLabel("Enter a phone number");

        buttonLabel = new JLabel("Click");
        submitButton = new JButton(" Click to Submit");

        nameField = new JTextField(20);
        nameField.setToolTipText("enter name");

        streetField = new JTextField(20);
        streetField.setToolTipText("enter street");

        cityField= new JTextField(20);
        cityField.setToolTipText("enter city");

        stateField= new JTextField(20);
        stateField.setToolTipText("enter state");

        zipCodeField= new JTextField(20);
        zipCodeField.setToolTipText("enter zip code");

        creditCardNumberField= new JTextField(20);
        creditCardNumberField.setToolTipText("enter credit card number");

        phoneNumberField= new JTextField(20);
        phoneNumberField.setToolTipText("enter phone number");

        submitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                DBMethod db = new DBMethod();
                String name;
                String street;
                String city;
                String state;
                String zipCode;
                String creditCardNumber;
                String phoneNumber;

                if(validInput()) {

                    name = nameField.getText();
                    street = streetField.getText();
                    city= cityField.getText();
                    state= stateField.getText();

                    zipCode=zipCodeField.getText();
                    creditCardNumber= creditCardNumberField.getText();
                    phoneNumber=phoneNumberField.getText();

                    db.insertCustomer(name,street,city,state,zipCode,creditCardNumber,phoneNumber);

                    System.out.println("New customer added to the database:\n  ");
                    clearAll();
                }
            }
        });

        add(nameLabel);
        add(nameField);
        add(streetLabel);
        add(streetField);
        add(cityLabel);
        add(cityField);
        add(stateLabel);
        add(stateField);
        add(zipCodeLabel);
        add(zipCodeField);
        add(creditCardNumberLabel);
        add(creditCardNumberField);
        add(phoneNumberLabel);
        add(phoneNumberField);
        add(buttonLabel);
        add(submitButton);
    }

    public void clearAll() {
        nameField.setText("");
        streetField.setText("");
        cityField.setText("");
        stateField.setText("");
        zipCodeField.setText("");
        creditCardNumberField.setText("");
        phoneNumberField.setText("");
        nameField.requestFocus();

    }

    public boolean validInput() {
        if(nameField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "enter a namee");
            nameLabel.setEnabled(false);
            nameField.requestFocus();
            return false;
        }
        else if(streetField.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "enter a street");
            streetField.requestFocus();
            return false;

        }
        else if(cityField.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "enter a city");
            cityField.requestFocus();
            return false;
        }

        else if(stateField.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "enter a state");
            stateField.requestFocus();
            return false;
        }
        else if(zipCodeField.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "enter a zip code");
            zipCodeField.requestFocus();
            return false;
        }
        else if(phoneNumberField.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "enter a phone number");
            phoneNumberField.requestFocus();
            return false;
        }
        else if(creditCardNumberField.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "enter a credit card");
            creditCardNumberField.requestFocus();
            return false;
        }

        return true;

    }
}