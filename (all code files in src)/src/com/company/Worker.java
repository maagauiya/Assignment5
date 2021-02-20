package com.company;

import java.sql.*;
import java.util.Scanner;

public class Worker extends Admin {
    String connectionUrl = "jdbc:postgresql://localhost:5432/Magauiya.inc";
    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;
    Scanner scanner = new Scanner(System.in);

    public void read() {//method to read from table
        System.out.println("Please,enter the id of your project");
        int id = scanner.nextInt();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connectionUrl, "postgres", "magauiyainc");//Establishing connection
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from project");//to execute query
            while (resultSet.next()) {//it works while there are rows in the table
                if (resultSet.getInt("id") == id) {//if id will be find then program will output data from table
                    System.out.println(resultSet.getInt("id") + " || " + resultSet.getString("name") + " || "
                            + resultSet.getString("team_members") + " || " + resultSet.getInt("cost") +" || "+
                            resultSet.getString("date")+ " || "+resultSet.getString("description"));
                }
            }
        } catch (Exception e) {//to catch exceptions
            System.out.println(e);
        }
        System.out.println("Want to do one more operation raad or create if yes enter 1 otherwise enter 2");
        int chooseforonemore = scanner.nextInt();//initialize "chooseforonemore" to know the need of users
        if (chooseforonemore == 1) {
            System.out.println("Ok,if you want to read one more project enter 1 if want to crate enter 2");
            int chooseforreadorcreate = scanner.nextInt();//initialize "chooseforreadorcreate" to know the need of users
            if (chooseforreadorcreate == 1) {
                read();
            }
            else if (chooseforreadorcreate == 2) {
                   create();
            }
            else {
                System.out.println("Failed");
            }
        }
        else if (chooseforonemore == 2) {
            System.out.println("Thanks,good luck");
        }
        else {
            System.out.println("Operation failed");
        }
            System.out.println("============================================================================");
    }

    public void create() {//method to insert into the table
        System.out.println("Please,enter the" +
                "\nid\nname\nteam_members\ncost" +
                "\ndate\ndescription\n " +
                "after please write just something to check");
        System.out.println("================");

        try {
            int id=scanner.nextInt();//why i add in this way because i want to
            // add description and i had some problems with nextLine
            String name=scanner.next();//input name
            String team_members=scanner.next();//input team_members
            int cost=scanner.nextInt();//input cost
            String date=scanner.next();//input date
            scanner.nextLine();//why i add this empty scanner because with help of this
            // scanner i debug descripton`s problem
            String description=scanner.nextLine();//input description why nextLine
            //to input with space
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connectionUrl, "postgres", "magauiyainc");//Establishing connection
            statement = connection.createStatement();
            resultSet = statement.executeQuery("insert into project(id,name,team_members,cost,date,description)" +
                    "values (" + id + ",'" + name + "','" + team_members + "',"
                     + cost + ",'" +date + "','"+description +"');");//execute query
        } catch (Exception e) {//to catch exceptions
            System.out.println(e);
        }
        System.out.println("============================================================================");
    }
    public int salarycalculator() { //method for calculate the worker salary
        System.out.println("Please choose your position:" +
                "\njunior(enter 1)\nsenior(enter 2)" +
                "\nprmanager(enter 3)\nadmin(enter 4)");
        int u = scanner.nextInt();//initialize "u" to know the need of users
        if (u == 1) {
            System.out.println("Have you bonus for this month if yes enter 1 otherwise enter 2");
            int j = scanner.nextInt();//initialize "j" to know the need of users
            if (j == 1) {
                return getJunior() + getBonusforproject();//return salary with bonus
            }
            else if(j==2){
                return getJunior();//return salary without bonus
            }
        }
        else if (u == 2) {
                System.out.println("Have you bonus for this month if yes enter 1 otherwise enter 2");
                int s = scanner.nextInt();//initialize "s" to know the need of users
                if (s == 1) {
                    return getSenior() + getBonusforproject();//return salary with bonus
                }
                else if(s==2){
                    return getSenior();//return salary without bonus
                }
        }
                else if (u == 3) {
                System.out.println("Have you bonus for this month if yes enter 1 otherwise enter 2");
                int p = scanner.nextInt();//initialize "p" to know the need of users
                if (p == 1) {
                    return getPrmanager() + getBonusforproject();//return salary with bonus
                }
                else if(p==2){
                    return getPrmanager();//return salary without bonus
                }
        }
                else if(u==4){
                System.out.println("Have you bonus for this month if yes enter 1 otherwise enter 2");
                int a = scanner.nextInt();//initialize "a" to know the need of users
                if (a == 1) {
                    return getAdmin() + getBonusforproject();//return salary with bonus
                  }
                else if(a==2){
                    return getAdmin();//return salary without bonus
                }
                }
          return 0;//why i return 0 because my compiler give me error and to solve i add this return
                   //there is no any meaning of this return
    }
}

