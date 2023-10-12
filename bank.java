import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class bank {
    public static void main(String[] args) {
        ArrayList<user>user1=new ArrayList<user>();
        // clearscreen();
        while(true){
        Scanner sc=new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("---------------------------WELCOME TO SHH NATIONAL BANK-----------------------------");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\t->Sign In(1)\t\t->Sign up(2)\t\t->Exit menu(3)");
        int ch1=sc.nextInt();
        switch(ch1){
            case 1:
            {
                System.out.println("Enter your login ID");
                int id=sc.nextInt();
                System.out.println("Enter password:");
                int pass=sc.nextInt();
                for (user userc : user1) {
                    if(id==userc.ID&&pass==userc.password){
                        userc.options();
                    }
                    else{System.out.println("Wrong credentials. Try Again");}
                }
            }
            break;
            case 2:
            user1.add(new user());
            break;
            case 3:
            System.out.println("Thank you for using shh national bank!");
            System.exit(0);
            }
            sc.close();
        }
    }
    static void clearscreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

class user{
    int ID,acbal,password;
    String name;
    Date d=new Date();
    Scanner sc=new Scanner(System.in);
    ArrayList<Date>transaction=new ArrayList<Date>();
    
    user(){
        acbal=0;
        System.out.println("Enter your details:");
        System.out.println("ID:");
        ID=sc.nextInt();
        for(int i=0;i<=5;i++){
        System.out.println("Enter a 4 digit password");
        password=sc.nextInt();
        if(password>999&&password<10000){break;}
        else{System.out.println("wrong password length. Try Again");}}
        System.out.println("NAME:");
        name=sc.next();
        System.out.println("ID sucessfully created on-"+d+"\nYour initial current balance="+acbal);
        writetotext();
    }
    
    public void getDetails(){
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Your bank details are:\nID:"+ID+"\nName:"+name+"\nBalance:"+acbal+"\nAccount creation date:"+d);
        System.out.println("------------------------------------------------------------------------------------");
    }

    public void writetotext(){
        try (FileWriter fw = new FileWriter("data.txt", true)) {
            fw.write("Account id-"+ID+"\nOwner Name-"+name+"\nCreated on-"+d+"\n\n");
        }
        
        catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void options(){
        // bank.clearscreen();
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\t\tWelcome to your account Mr. "+name+"\n\tChoose your preference : ");
        System.out.println("------------------------------------------------------------------------------------");
        while(true){
            System.out.println("\t-->Add money(1)\t\t-->Withdraw money(2)\t\t-->Check balance(3)\n-->Check account details(4)\t\t-->Transaction history(5)\t\t-->Exit(6)");
            int ch=sc.nextInt();
            switch(ch){
                case 1:
                System.out.println("Enter Amount to add :");
                acbal=acbal+sc.nextInt();
                Date t=new Date();
                transaction.add(t);
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("Amount sucessfully added\nAvailable balance is:"+acbal+"Rs");
                System.out.println("------------------------------------------------------------------------------------");
                break;
                case 2:
                System.out.println("Enter Amount to withdraw :");
                int amt=sc.nextInt();
                System.out.println("Enter password:");
                int p=sc.nextInt();
                if(p==password){
                    if(amt>=acbal){
                        System.out.println("Your account doesnot have sufficient balance");
                    }
                    else{
                        acbal=acbal-amt;
                        Date w=new Date();
                        transaction.add(w);
                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("Please collect your "+amt+" Rs\nAvailable balance is:"+acbal+"Rs");}
                        System.out.println("------------------------------------------------------------------------------------");
                    }
                    else{System.out.println("Wrong password! withdrawal failed. Try again");}
                    break;
            case 3:
            System.out.println("Available balance is:"+acbal+"Rs");
            break;
            case 4:
            System.out.println("------------------------------------------------------------------------------------");
            getDetails();
            System.out.println("------------------------------------------------------------------------------------");
            break;
            case 5:
            for (Date d1 : transaction) {
            System.out.println(d1);
            }
            break;
            case 6:
            System.out.println("Thank you for using shh national bank!");
            System.exit(0);
        }
    }
}

}


