import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MavRentalGUI extends JFrame {
    private JDesktopPane theDesktop;
    static ArrayList<Customer> customerList = new ArrayList<Customer>();
    static ArrayList<Rental> rentalList = new ArrayList<Rental>();

    public MavRentalGUI() {
        super("Mav Rental System");
        DBMethod db = new DBMethod();

        theDesktop = new JDesktopPane();

        JMenuBar bar = new JMenuBar();

        JMenu addMenu = new JMenu("Add");
        JMenuItem addCustomer = new JMenuItem("Add Customer");
        JMenuItem addRental = new JMenuItem("Add Rental");

        addMenu.add(addCustomer);
        addMenu.add(addRental);

        JMenu databaseMenu = new JMenu("Database");
        JMenuItem writeItem = new JMenuItem("Write Database Tables");

        databaseMenu.add(writeItem);

        JMenu exitMenu = new JMenu("Exit");
        JMenuItem calcItem = new JMenuItem("Calculate Charges");
        JMenuItem exitItem = new JMenuItem("Exit");

        exitMenu.add(calcItem);
        exitMenu.add(exitItem);

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        writeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                DBMethod db = new DBMethod();
                db.DisplayCustomer();
            }
        });

        calcItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                db.CalculateCharge();

                //JOptionPane.showMessageDialog(null, message);

            }
        });

        addCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JInternalFrame frame = new JInternalFrame("Add Customer",
                        true, true, true, true);

                CustomerPanel cp = new CustomerPanel();

                frame.add(cp);
                frame.pack();
                theDesktop.add(frame);
                frame.setVisible(true);


            }
        });

        addRental.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JInternalFrame frame2 = new JInternalFrame("Add rental",
                        true, true, true, true);

                RentalPanel cp2 = new RentalPanel();

                frame2.add(cp2);
                frame2.pack();
                theDesktop.add(frame2);
                frame2.setVisible(true);

            }
        });

		/*GUI class
			create DB instance
			your menu
			creation of panels
			exit
			db.connect()
			*/

        bar.add(addMenu);
        bar.add(databaseMenu);
        bar.add(exitMenu);

        setJMenuBar(bar);

        add(theDesktop);

        //db.connectDatabase();

    }
}
