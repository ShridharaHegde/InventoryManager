import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

public class loginPage extends JFrame{

    loginPage() {

        setTitle("Inventory Manager: Login");
        setSize(1600,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("src/images/bg1.jpg")));
        setLayout(null);

        JTextField userId = new JTextField();
        userId.setBounds(410,460,200,38);
        add(userId);

        JPasswordField psswd = new JPasswordField();
        psswd.setBounds(410,525,200,38);
        add(psswd);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(410,580,200,38);
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new mainPage();
            }
        });

        setSize(399,399);
        setSize(1600,800);
    }

    public static void main(String args[]){

        new loginPage();

    }

}