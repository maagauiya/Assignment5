package com.company;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Login login=new Login();//A Login object creation
        Information information=new Information();//A Information object creation
        Forcompany forcompany=new Forcompany();//A Forcompany object creation
        Forindividuals forindividuals=new Forindividuals();//A Forindividuals object creation
       System.out.println("Hello,you are in main page in Magauiya.inc(Cybersecurity)");//welcome words
        System.out.println("If you want to see our security packs enter 1" +
                "\nif you have any questions or information enter 2" +
                "\nif you worker in this company enter 3");
        int choose=scanner.nextInt();//initialize "choose" to know the need of users
        if(choose==1){
            System.out.println("Please,enter if you: want to buy for you(enter 1) or for company(enter 2)");
            int n=scanner.nextInt();
            if(n==1){
                forindividuals.inform();
            }
            else if(n==2){
                forcompany.inform();
            }
        }
        else if(choose==2){
            information.Contacts();
        }
        else if(choose==3){
            login.adminorworker();
        }
    }
}
