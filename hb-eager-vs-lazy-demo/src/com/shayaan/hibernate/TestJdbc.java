package com.shayaan.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String password = "hbstudent";
        try{
            System.out.println("Connecting to Databse " + jdbcUrl);
            Connection myconn = DriverManager.getConnection(jdbcUrl, user, password);

            System.out.println("Connected");
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
}}
