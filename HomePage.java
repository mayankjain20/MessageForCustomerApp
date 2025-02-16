package com.ShopKeeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;




public class HomePage extends JFrame implements ActionListener {
        JLabel lCustomer_name ,lCustomer_MNo,lAmount;
        JTextField tcustomer_name,tcustomer_mno,tamount;
        JButton Add_customer;

        HomePage(){

           ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
           Image i2 =i1.getImage().getScaledInstance(1000,600,Image.SCALE_DEFAULT);
           ImageIcon i3 =new ImageIcon(i2);
           JLabel image =new JLabel(i3);
           image.setBounds(0,0,1000,600);
           add(image);

           ImageIcon i11 =new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
           Image i21 =i11.getImage().getScaledInstance(1000,800,Image.SCALE_DEFAULT);
           ImageIcon i31 =new ImageIcon(i21);
           JLabel image1 =new JLabel(i31);
           image1.setBounds(650,0,1000,800);
           image.add(image1);

           Add_customer =new JButton("Submit ");
           Add_customer.setBounds(320,320,150,30);
           Add_customer.setBackground(Color.black);
           Add_customer.setForeground(Color.white);
           Add_customer.addActionListener(this);
           image.add(Add_customer);


           JLabel heading =new JLabel("APP FOR STORING CUSTOMERS DETAILS  ");
           heading.setBounds(120,50,600,30);
           heading.setFont(new Font("SAN SARIF",Font.BOLD,25));
           image.add(heading);

           lCustomer_name =new JLabel("Customer Name");
           lCustomer_name.setBounds(150,150,200,30);
           lCustomer_name.setFont(new Font("SAN SARIF",Font.BOLD,15));
           image.add(lCustomer_name);
           tcustomer_name =new JTextField();
           tcustomer_name.setBounds(300,150,200,30);
           tcustomer_name.setFont(new Font("SAN SARIF",Font.PLAIN,15));
           image.add(tcustomer_name);


           lCustomer_MNo =new JLabel("Mobile No");
           lCustomer_MNo.setBounds(150,200,200,30);
           lCustomer_MNo.setFont(new Font("SAN SARIF",Font.BOLD,15));
           image.add(lCustomer_MNo);
           tcustomer_mno =new JTextField();
           tcustomer_mno.setBounds(300,200,200,30);
           tcustomer_mno.setFont(new Font("SAN SARIF",Font.PLAIN,15));
           image.add(tcustomer_mno);

           lAmount =new JLabel("Amount");
           lAmount.setBounds(150,250,200,30);
           lAmount.setFont(new Font("SAN SARIF",Font.BOLD,15));
           image.add(lAmount);
           tamount =new JTextField();
           tamount.setBounds(300,250,200,30);
           tamount.setFont(new Font("SAN SARIF",Font.PLAIN,15));
           image.add(tamount);



           setSize(1000,600);
           setLocation(300,150);
           setLayout(null);
           setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
           if (e.getSource() == Add_customer) {
              String name = tcustomer_name.getText();
              String MNO = tcustomer_mno.getText();
              String money = tamount.getText();
              if (!MNO.matches("\\d{10}")) {
                 JOptionPane.showMessageDialog(null, "Phone number must be 10 digits!");
                 return;
              }

              try {
                 Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Ohdude@123");
                 String query = "INSERT INTO customerDetails (name,MNO,Amount)"+ "VALUES (?, ?, ?)";
                 PreparedStatement pstmt = con.prepareStatement(query);
                 pstmt.setString(1, name);
                 pstmt.setString(2, MNO);
                 pstmt.setString(3, money);
                 pstmt.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Data Inserted Successfully");

                 tcustomer_name.setText("");
                 tcustomer_mno.setText("");
                 tamount.setText("");

                 con.close();


              } catch (Exception ae) {
                 ae.printStackTrace();
              }


           }
        }
        public static void main(String[] args) {
           try {

              String url = "jdbc:mysql://localhost:3306/employee";
              String user = "root";
              String password = "Ohdude@123";
              Connection connection = DriverManager.getConnection(url, user, password);

              System.out.println("Connected to the database successfully!");
              connection.close();
           } catch (Exception e) {
              e.printStackTrace();
           }
            new HomePage();
        }
    }


