import com.sun.security.auth.module.JndiLoginModule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainPage extends JFrame {



    public mainPage(){

        JButton stockInventory, customerAccount, supplierAccount, deliveryList, salesPurchases, billing;


        setSize(1600,800);
        setTitle("Inventory Manager: Main Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("src/images/bg.jpg")));
        setLayout(null);

        stockInventory = new JButton("Stock Inventory");
        stockInventory.setBackground(new Color(0xFAE5E4));
        stockInventory.setForeground(new Color(0x000000));
        stockInventory.setBounds(600,200,150,70);
        add(stockInventory);

        stockInventory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // setVisible(false);
               new stock();
            }
        });


        customerAccount = new JButton("Customer Account");
        customerAccount.setBackground(new Color(0xFAE5E4));
        customerAccount.setForeground(new Color(0x000000));
        customerAccount.setBounds(600,300, 150,70);
        add(customerAccount);

        salesPurchases = new JButton("Sales/Purchases");
        salesPurchases.setBackground(new Color(0x9F4BFC));
        salesPurchases.setForeground(new Color(0xFFFFFF));
        salesPurchases.setBounds(600,400,150,70);
        add(salesPurchases);

        supplierAccount = new JButton("Supplier Account");
        supplierAccount.setBackground(new Color(0x9F4BFC));
        supplierAccount.setForeground(new Color(0xFFFFFF));
        supplierAccount.setBounds(800,200,150,70);
        add(supplierAccount);

        deliveryList = new JButton("Delivery List");
        deliveryList.setBackground(new Color(0x9F4BFC));
        deliveryList.setForeground(new Color(0xFFFFFF));
        deliveryList.setBounds(800,300,150,70);
        add(deliveryList);



        billing = new JButton("Billing");
        billing.setBackground(new Color(0x9F4BFC));
        billing.setForeground(new Color(0xFFFFFF));
        billing.setBounds(800,400,150,70);
        add(billing);

        customerAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new customerAccount();
            }
        });


        setSize(399,399);
        setSize(1600,800);

    }

}
