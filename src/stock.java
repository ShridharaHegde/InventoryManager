import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class stock extends JFrame {

    JTable table = null;
    connector conn = new connector();
    String delete_cell;
    int delete_column;


    stock(){

        JLabel l1,l2,l3,l4,l5,l6,l7,lbl1,lbl2;
        JTextField t0,t1,t2,t3,t4,t5,t6,t7;
        JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
        JRadioButton r1,r2,r3,r4,r5,r6,r7;


        setSize(1600,800);
        setTitle("Inventory Manager: Stock Inventory");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("src/images/stock_inventory.jpg")));
        setLayout(null);

        lbl1 = new JLabel("Search:");
        lbl1.setBounds(1100,85,150,30);
        lbl1.setFont(new Font("Titillium Web",Font.BOLD,20));
        add(lbl1);

        b2= new JButton("GO!");
        b2.setFont(new Font("Titillium Web",Font.BOLD,15));
        b2.setBounds(1355,85,70,31);
        add(b2);

        t0 = new JTextField();
        t0.setBounds(1200, 85, 150, 30);
        add(t0);

        lbl2 = new JLabel("Select column");
        lbl2.setBounds(800,129,100,30);
        lbl2.setFont(new Font("Titillium Web",Font.BOLD,15));
        add(lbl2);

        r1 = new JRadioButton("Product Name");
        r1.setFont(new Font("Titillium Web",Font.BOLD,13));
        r1.setBounds(900,130,130,30);
        r1.setOpaque(false);
        add(r1);

        r2 = new JRadioButton("Product ID");
        r2.setFont(new Font("Titillium Web",Font.BOLD,13));
        r2.setBounds(1010,130,100,30);
        r2.setOpaque(false);
        add(r2);

        r3 = new JRadioButton("Dealer Price");
        r3.setFont(new Font("Titillium Web",Font.BOLD,13));
        r3.setBounds(1100,130,100,30);
        r3.setOpaque(false);
        add(r3);

        r4 = new JRadioButton("Selling Price");
        r4.setFont(new Font("Titillium Web",Font.BOLD,13));
        r4.setBounds(1200,130,100,30);
        r4.setOpaque(false);
        add(r4);

        r5 = new JRadioButton("MRP");
        r5.setFont(new Font("Titillium Web",Font.BOLD,13));
        r5.setBounds(1300,130,60,30);
        r5.setOpaque(false);
        add(r5);

        r6 = new JRadioButton("No. in Stock");
        r6.setFont(new Font("Titillium Web",Font.BOLD,13));
        r6.setBounds(1350,130,100,30);
        r6.setOpaque(false);
        add(r6);

        r7 = new JRadioButton("Supplier ID");
        r7.setFont(new Font("Titillium Web",Font.BOLD,13));
        r7.setBounds(1450 ,130,150,30);
        r7.setOpaque(false);
        add(r7);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);buttonGroup.add(r2);buttonGroup.add(r3);buttonGroup.add(r4);buttonGroup.add(r5);buttonGroup.add(r6);buttonGroup.add(r7);

        l1 = new JLabel("Product Name:");
        l1.setBounds(100,250,150,30);
        l1.setFont(new Font("Titillium Web",Font.BOLD,20));
        add(l1);

        t1 = new JTextField();
        t1.setBounds(250,250,150,30);
        add(t1);

        l2 = new JLabel("Product ID:");
        l2.setBounds(100,300,150,30);
        l2.setFont(new Font("Titillium Web",Font.BOLD,20));
        add(l2);

        t2 = new JTextField();
        t2.setBounds(250,300,150,30);
        add(t2);

        l3 = new JLabel("Dealer Price:");
        l3.setBounds(100,350,150,30);
        l3.setFont(new Font("Titillium Web",Font.BOLD,20));
        add(l3);

        t3 = new JTextField();
        t3.setBounds(250,350,150,30);
        add(t3);

        l4 = new JLabel("Selling Price:");
        l4.setBounds(100,400,150,30);
        l4.setFont(new Font("Titillium Web",Font.BOLD,20));
        add(l4);

        t4 = new JTextField();
        t4.setBounds(250,400,150,30);
        add(t4);

        l5 = new JLabel("MRP:");
        l5.setBounds(100,450,150,30);
        l5.setFont(new Font("Titillium Web",Font.BOLD,20));
        add(l5);

        t5 = new JTextField();
        t5.setBounds(250,450,150,30);
        add(t5);

        l6 = new JLabel("No. In stock");
        l6.setBounds(100,500,150,30);
        l6.setFont(new Font("Titillium Web",Font.BOLD,20));
        add(l6);

        t6 = new JTextField();
        t6.setBounds(250,500,150,30);
        add(t6);

        l7 = new JLabel("Supplier ID:");
        l7.setBounds(100,550,150,30);
        l7.setFont(new Font("Titillium Web",Font.BOLD,20));
        add(l7);

        t7 = new JTextField();
        t7.setBounds(250,550,150,30);
        add(t7);

        b1 = new JButton("Add");
        b1.setBounds(200,600,100,30);
        add(b1);

        b3 = new JButton("Product_name");
        b3.setBounds(600,170,129,30);
        b3.setBackground(Color.white);
        b3.setFont(new Font("Arial",Font.BOLD,13));
        add(b3);

        b4 = new JButton("Product_ID");
        b4.setBounds(728,170,130,30);
        b4.setBackground(Color.white);
        b4.setFont(new Font("Arial",Font.BOLD,13));
        add(b4);

        b5 = new JButton("Dealer_price");
        b5.setBounds(857,170,129,30);
        b5.setBackground(Color.white);
        b5.setFont(new Font("Arial",Font.BOLD,13));
        add(b5);

        b6 = new JButton("Selling_price");
        b6.setBounds(984,170,131,30);
        b6.setBackground(Color.white);
        b6.setFont(new Font("Arial",Font.BOLD,13));
        add(b6);

        b7 = new JButton("MRP");
        b7.setBounds(1114,170,130,30);
        b7.setBackground(Color.white);
        b7.setFont(new Font("Arial",Font.BOLD,13));
        add(b7);

        b8 = new JButton("No_In_stock");
        b8.setBounds(1242,170,130,30);
        b8.setBackground(Color.white);
        b8.setFont(new Font("Arial",Font.BOLD,13));
        add(b8);

        b9 = new JButton("Supplier_ID");
        b9.setBounds(1371,170,129,30);
        b9.setBackground(Color.white);
        b9.setFont(new Font("Arial",Font.BOLD,13));
        add(b9);


        String str = "select * from stock_inventory";


        try {
            ResultSet res = conn.s.executeQuery(str);

            table =  new JTable(buildTableModel(res));

            JScrollPane jsp = new JScrollPane(table);

            table.setBounds(600,200,900,500);

            add(table);

            add(jsp);

            setVisible(true);

            Action action = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {


                    TableCellListener tbl = (TableCellListener)e.getSource();

                    Object old_val = tbl.getOldValue();
                    Object new_val = tbl.getNewValue();



                    update_table(old_val.toString(),new_val.toString());

                }

            };
            TableCellListener tbl = new TableCellListener(table,action);


            table.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    if(e.getButton() == MouseEvent.BUTTON3) {

                        int row = table.convertRowIndexToModel(table.getSelectedRow());
                        int column = table.convertColumnIndexToModel(table.getSelectedColumn());
                        Object oldValue = table.getModel().getValueAt(row, column);

                        delete_cell = oldValue.toString();
                        delete_column = column;

                        System.out.println(oldValue.toString());

                        int result = JOptionPane.showConfirmDialog(null,"Sure? You want to Delete?", "",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        if(result == JOptionPane.YES_OPTION){

                            table_delete();
                            dispose();
                            new stock();
                        }

                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }

            });




        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }



        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String x = t0.getText();
                ResultSet ans = null;
                if (x.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Search input is empty");
                } else {

                    if (r1.isSelected()) {

                        ans = table_search(x,"Product_name");

                    } else if (r2.isSelected()) {

                        ans = table_search(x,"Product_ID");

                    } else if (r3.isSelected()) {

                        ans = table_search(x,"Dealer_price");

                    } else if (r4.isSelected()) {

                        ans = table_search(x,"Selling_price");

                    } else if (r5.isSelected()) {

                        ans = table_search(x,"MRP");

                    } else if (r6.isSelected()) {

                        ans = table_search(x,"No_In_Stock");

                    } else if (r7.isSelected()) {

                        ans = table_search(x,"Supplier_ID");

                    } else {
                        JOptionPane.showMessageDialog(null, "Select a column to be searched");
                    }
                }

                try {
                    table_display(ans);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ResultSet ans = table_sort(b3.getText(), 0);

                try {
                    table_display(ans);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ResultSet ans = table_sort(b4.getText(), 1);
                try {
                    table_display(ans);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ResultSet ans = table_sort(b5.getText(), 2);
                try {
                    table_display(ans);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ResultSet ans = table_sort(b6.getText(), 3);
                try {
                    table_display(ans);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ResultSet ans = table_sort(b7.getText(), 4);
                try {
                    table_display(ans);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });


        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ResultSet ans = table_sort(b8.getText(), 5);
                try {
                    table_display(ans);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });


        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ResultSet ans = table_sort(b9.getText(), 6);
                try {
                    table_display(ans);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String a = t1.getText();
                String b = t2.getText();
                String c = t3.getText();
                String d = t4.getText();
                String ee = t5.getText();
                String ff = t6.getText();
                String g = t7.getText();

                String z = "insert into stock_inventory values('"+a+"','"+b+"','"+c+"','"+d+"','"+ee+"','"+ff+"','"+g+"')";
                try {
                    conn.s.executeUpdate(z);
                    dispose();
                    new stock();

                } catch (SQLException throwables) {

                    JOptionPane.showMessageDialog(null,throwables);

                    throwables.printStackTrace();
                }


            }
        });

        setSize(399,399);
        setSize(1600,800);

    }

    private void table_delete() {


        String command = "delete from stock_inventory where Product_name = '"+delete_cell+"'";

        try {
          conn.s.executeUpdate(command);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private ResultSet table_sort(String text, int val) {

        ResultSet res = null;

        String command = "select * from stock_inventory order by "+text+"";

        try {

             res = conn.s.executeQuery(command);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
            return res;
    }

    private void table_display(ResultSet ans) throws SQLException {


        table =  new JTable(buildTableModel(ans));

        JScrollPane jsp = new JScrollPane(table);

        table.setBounds(600,200,900,500);

        add(table);

        add(jsp);

        setVisible(true);

    }

    private ResultSet table_search(String search_box, String col_name) {

        ResultSet res = null;
        String command =  "select * from stock_inventory where "+col_name+" like '"+search_box+"%' ";
        try {
           res = conn.s.executeQuery(command);

        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }
        return  res;
    }

    private void update_table(String old_str, String new_str) {

        String command = "update stock_inventory set Product_name = '"+new_str+"' where Product_name = '"+old_str+"'  ";

        try {
            conn.s.executeUpdate(command);

        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }


    }


    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        Vector<String> columnNames = new Vector<String>();

        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }

    public static void main(String[] args) {

        new stock();

    }
}
