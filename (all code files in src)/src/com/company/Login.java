package com.company;
import java.util.Scanner;

public class Login extends Worker {
    private int attempts=0;//initialize attempts and set default value 0
    Scanner scanner=new Scanner(System.in);
    public void adminorworker(){//this method to know this user admin or worker
        System.out.println("~Hello you are in database system of this company~ " +
                "\n *Please send 1 if you are worker \n *send 2 if you admin");
        System.out.println("==================================================");
        int a=scanner.nextInt();
        if(a==1){
            System.out.println("Hello,worker");
            worker();//call worker method
        }
        else if(a==2){
            System.out.println("Hello,admin");
            admin();//call admin method
        }
        else{
            System.out.println("Failed");
        }
   }
   public void admin(){
       String passwordad="adminbeka";//initialize the password for admin
       String enteredpassad;//initialize the entered password
       System.out.println("Please enter admin`s password");
       System.out.println("============================");
       enteredpassad=scanner.next();
       if(passwordad.equals(enteredpassad)==true){//check the similarity between two strings
           System.out.println("Password accepted");
           System.out.println("If you want to:\nread(enter 1)\nupdate(enter 2)" +
                   "\ndelete(enter 3)\nfind out the salary(enter 4)");
           int choose=scanner.nextInt();//initialize "choose" to know the need of users
           if(choose==1){
               super.read();//I use super to use method from parent class
           }
           else if(choose==3){
                super.delete();//I use super to use method from parent class
           }
           else if(choose==2){
               super.update();//I use super to use method from parent class
           }
           else if(choose==4){
               System.out.println("Your salary:"+super.salarycalculator()+"KZT");//I use super to use method from parent class
           }
           else{
               System.out.println("Failed");
           }
       }
       else{
           if(this.attempts<2){ //this if else statement for counting attempts of users
               int id=2;//this is id of admin why because i send this id like parameter
               this.attempts++;//increment of attempts to count
               System.out.println("Failed,please check CapsLock or Language");
               fail(id);//call method if user entered wrong password
           }
           else{
               System.out.println("You lost last attempt");
           }
       }
   }
   public void worker(){
       String password="userbeka";//initialize the password for admin
       String enteredpass;//initialize the entered password
       System.out.println("Please enter worker`s password");
       System.out.println("============================");
       enteredpass=scanner.next();
       if(password.equals(enteredpass)==true){//check the similarity between two strings
           System.out.println("Password accepted");
           System.out.println("If you want to:\nread(enter 1)\ncreate(enter 2)"+
                   "\nfind out the salary(enter 3)");
           int choose=scanner.nextInt();//initialize "choose" to know the need of users
           if(choose==1){
               super.read();//I use super to use method from parent class
           }
           else if(choose==2){
             super.create();//I use super to use method from parent class
           }
           else if(choose==3){
               System.out.println("Your salary:"+super.salarycalculator()+"KZT");//I use super to use method from parent class
           }
           else{
               System.out.println("Failed");
           }
       }
       else{
           if(this.attempts<2){//this if else statement for counting attempts of users
           int id=1;//this is id of admin why because i send this id like parameter
           this.attempts++;//increment of attempts to count
           System.out.println("Failed,please check CapsLock or Language");
           fail(id);//call method if user entered wrong password
           }
           else{
               System.out.println("You lost last attempt");
           }

       }
   }
   public void fail(int n){//this method to calculate the attempts
            if(n==1){//if n equals to 1 in calculate for worker
                System.out.println("You have "+(3-this.attempts)+" attempts");
                worker();//call method worker
            }
            else if(n==2){//if n equals to 2 in calculate for worker
                System.out.println("You have "+(3-this.attempts)+" attempts");
                admin();//call method admin
            }
   }
}
