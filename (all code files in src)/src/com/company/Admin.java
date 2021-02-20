package com.company;

import java.sql.*;
import java.util.*;


public class Admin  {
    String connectionUrl="jdbc:postgresql://localhost:5432/Magauiya.inc";
    Connection connection=null;
    ResultSet resultSet=null;
    Statement statement=null;
    Scanner scanner=new Scanner(System.in);
    private int junior;//initialize junior with private modifier
    private int senior;//initialize senior with private modifier
    private int bonusforproject;//initialize bonusforproject with private modifier
    private int admin;//initialize admin with private modifier
    private int prmanager;//initialize prmanager with private modifier

    public Admin() {//empty constructor to set default values
        this.junior = 500000;
        this.senior = 800000;
        this.bonusforproject = 250000;
        this.admin = 980000;
        this.prmanager = 300000;
    }

    public int getJunior() {//to junior email
        return junior;
    }

    public void setJunior(int junior) {//to set junior
        this.junior = junior;
    }

    public int getSenior() { //to get senior
        return senior;
    }

    public void setSenior(int senior) {//to set senior
        this.senior = senior;
    }

    public int getBonusforproject() {//to get bonusforproject
        return bonusforproject;
    }

    public void setBonusforproject(int bonusforproject) {//to set bonusforproject
        this.bonusforproject = bonusforproject;
    }

    public int getAdmin() {//to get admin
        return admin;
    }

    public void setAdmin(int admin) {//to set admin
        this.admin = admin;
    }

    public int getPrmanager() { //to get prmanager
        return prmanager;
    }

    public void setPrmanager(int prmanager) {//to set prmanager
        this.prmanager = prmanager;
    }


    public void delete(){//this method to remove or delete row from table
        try {
            System.out.println("Please,enter the id of project which you want to delete");
            Class.forName("org.postgresql.Driver");
            connection=DriverManager.getConnection(connectionUrl,"postgres","magauiyainc");//Establishing connection
            statement=connection.createStatement();
            resultSet=statement.executeQuery("delete from project where id="+scanner.nextInt()+";");//to execute query
        }catch (Exception e){//to catch exceptions
            System.out.println(e);
        }
        System.out.println("============================================================================");
    }

    public void update(){//this method to update row from table
        try {
            System.out.println("Please enter new informations of:" +
                    "\nid\nname\nteam_members\ncost\ndate then enter" +
                    "the id of project which you want to change\nand" +
                    "in the end enter just done ");
            int id=scanner.nextInt();//why i add in this way because i want to
            // add description and i had some problems with nextLine
            String name=scanner.next();//input name
            String team_members=scanner.next();//input team_members
            int cost=scanner.nextInt();//input cost
            String date=scanner.next();//input date
            scanner.nextLine();//why i add this empty scanner because with help of this
            String description=scanner.nextLine();//input description why nextLine
            //to input with space
            Class.forName("org.postgresql.Driver");
            connection=DriverManager.getConnection(connectionUrl,"postgres","magauiyainc");//Establishing connection
            statement=connection.createStatement();
            resultSet=statement.executeQuery("update project set id="+id+",name='"+name+"', team_members='"
                    +team_members+"',cost="+cost+",date ='"+date+"',"+"description='"+description
                    +"'"+"where id="+scanner.nextInt());//execute query
        }catch (Exception e){//to catch exceptions
            System.out.println(e);
        }
        System.out.println("============================================================================");
    }}


