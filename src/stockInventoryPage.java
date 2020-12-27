import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class stockInventoryPage extends JFrame {

    stockInventoryPage(){

        JLabel l1,l2,l3,l4,l5,l6,l7,lbl1,lbl2;
        JTextField t0,t1,t2,t3,t4,t5,t6,t7;
        JButton b1,b2;
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



        viewTable(null,null,0);


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    connector conn = new connector();

                    String a = t1.getText();
                    String b = t2.getText();
                    String c = t3.getText();
                    String d = t4.getText();
                    String ee = t5.getText();
                    String ff = t6.getText();
                    String g = t7.getText();

                    String z = "insert into stock_inventory values('"+a+"','"+b+"','"+c+"','"+d+"','"+ee+"','"+ff+"','"+g+"')";
                    conn.s.executeUpdate(z);

                    viewTable(null,null,0);

                }catch (Exception e1){

                    System.out.println("error"+e1);
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                connector conn = new connector();
                String x = t0.getText();

                if (x.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Search input is empty");
                } else {

                    if (r1.isSelected()) {

                        viewTable(x,"Product_name",1);

                    } else if (r2.isSelected()) {

                        viewTable(x,"Product_ID",1);

                    } else if (r3.isSelected()) {

                        viewTable(x,"Dealer_price",1);

                    } else if (r4.isSelected()) {

                        viewTable(x,"Selling_price",1);

                    } else if (r5.isSelected()) {

                        viewTable(x,"MRP",1);

                    } else if (r6.isSelected()) {

                        viewTable(x,"No_In_Stock",1);

                    } else if (r7.isSelected()) {

                        viewTable(x,"Supplier_ID",1);

                    } else {
                        JOptionPane.showMessageDialog(null, "Select a column to be searched");
                    }
                }

            }
        });



        setSize(399,399);
        setSize(1600,800);




    }

    public void viewTable(String s,String t, int k){

        String str;
        try {
            if(k == 0){
                str = "select * from stock_inventory";
            }
            else{
                str = "select * from stock_inventory where "+t+" like '"+s+"%' ";
            }
            connector conn = new connector();

            ResultSet rs = conn.s.executeQuery(str);

            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"Item not Found");
                return;
            }

             JTable table = new JTable(buildTableModel(rs));
            /* table.getModel().addTableModelListener(new TableModelListener() {
                @Override
                public void tableChanged(TableModelEvent e) {

                    TableCellListener tcl = (TableCellListener)e.getSource();

                    Object q =  tcl.getNewValue();
                    Object p = tcl.getOldValue();
                    Object r = tcl.getColumn();
                    String column_num = r.toString();
                    String updated_value = q.toString();
                    String old_value = p.toString();

                    //updateTable(updated_value,old_value,column_num,conn);

                    System.out.println(column_num + updated_value + old_value);
                    TableCellListener tbl = (TableCellListener)e.getSource();
                    Object old = tbl.getOldValue();

                    int col_no = table.getSelectedColumn();
                    //System.out.println(col_no);

                    int row_no = table.getSelectedRow();

                    //Object value = table.getValueAt(row_no,col_no);
                    System.out.println(value.toString());
                    System.out.println(old.toString());

                }
            });*/
            //JOptionPane.showMessageDialog(null, new JScrollPane(table));

          Action action = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    TableCellListener tbl = (TableCellListener)e.getSource();
                    Object old_value = tbl.getOldValue();
                    Object new_value = tbl.getNewValue();
                    int col_value = tbl.getColumn();

                    updateTable(new_value.toString(),old_value.toString(),col_value,conn);

                    table.repaint();
                }

            };

            TableCellListener tbl = new TableCellListener(table,action);

            JScrollPane jsp = new JScrollPane(table);

            table.setBounds(600,200,900,500);

            add(table);

            add(jsp);

            setVisible(true);

        }catch (Exception e1){

            System.out.println("error"+e1);

        }

    }

    public void updateTable(String new_val, String old_val,int col_val, connector conn){


        String buffer;
        String update_command;

        switch(col_val){

            case 0:
                update_command = "update stock_inventory set Product_name = '"+new_val+"' where Product_name = '"+old_val+"'";
                break;
            case 1:
                update_command = "update stock_inventory set Product_ID = '"+new_val+"' where Product_ID = '"+old_val+"'";
                break;
            case 2:
                update_command = "update stock_inventory set Dealer_price = '"+new_val+"' where Dealer_price = '"+old_val+"'";
                break;
            case 3:
                update_command = "update stock_inventory set Selling_price = '"+new_val+"' where Selling_price = '"+old_val+"'";
                break;
            case 4:
                update_command = "update stock_inventory set MRP = '"+new_val+"' where MRP = '"+old_val+"'";
                break;
            case 5:
                update_command = "update stock_inventory set No_In_stock = '"+new_val+"' where No_In_Stock = '"+old_val+"'";
                break;
            case 6:
                update_command = "update stock_inventory set Supplier_ID = '"+new_val+"' where Supplier_ID = '"+old_val+"'";
                break;
            default:
                update_command = "select * from stock_inventory";
        }

        try {

            conn.s.executeUpdate(update_command);
        }catch (Exception e){
            System.out.println(e);
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


}
