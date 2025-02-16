package com.ShopKeeper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {
     Connection connection;
     Statement statement ;
      public DatabaseConnection(){
          try{
              Class.forName("com.mysql.cj.jdbc.Driver");
              connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Ohdude@123");
              statement = connection.createStatement();//jdbc:mysql://localhost:3306/employee


          }catch(Exception e){
              e.printStackTrace();
          }



     }
}
