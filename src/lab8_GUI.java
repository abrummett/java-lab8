import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.*;


public class lab8_GUI extends DB {

    private JTextField textField1;
    private JButton searchButton;
    private JList LResult;
    private JPanel panel1;
    Connection con;



    public lab8_GUI() {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField1.getText().isEmpty()) {
                    try {
                        con = DB.connect_DB_MY_SQL();
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM destinations WHERE CountryName LIKE '%" + textField1.getText() + "%'");
                        DefaultListModel listmodel = new DefaultListModel();
                            if (rs.next() == false){
                                System.out.println("rs.next is FALSE");
                                listmodel.addElement("No Results Found");
                                LResult.setModel(listmodel);
                            }
                            else {
                                System.out.println("rs.next is TRUE");
                                listmodel.addElement(rs.getString("CountryName"));
                                LResult.setModel(listmodel);
                            }


                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                }
                else{
                    DefaultListModel listmodel = new DefaultListModel();

                    listmodel.addElement("No Results Found");

                    LResult.setModel(listmodel);
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame jframe = new JFrame("Search Destination");
        jframe.setContentPane(new lab8_GUI().panel1);
        jframe.setSize(400,400);
        jframe.setVisible(true);
    }
}