// package Part 2;

import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.AcceptPendingException;

public class BankingProject {

}
    
class Customer{
    public String FName;
    public String LName;

    public String getFirstName(){
        return FName;
    }

    public void setFirstName(String firstName){
        this.FName  = firstName;
    }

    public String getLastName(){
        return LName;
    }

    public void setLastName(String lastName){
        this.LName = lastName;
    }
}
    
    
class Account extends Customer{
    public int balance;
    public int accountNumber;

    public Account(String FName, String LName, int accNum, int accBal){
        setFirstName(FName);
        setLastName(LName);
        this.accountNumber = accNum;
        this.balance = accBal;
    }

    public int getBalance(){
        return balance;
    }

    public int getAccountNum(){
        return accountNumber;
    }

    public void deposit(int amount){
        balance += amount;
    }

    public void withdraw(int amount){
        balance -= amount;
    }


}

class Transaction{
    public void transfer(Account acc1, Account acc2, int amount){
        // System.out.println(acc1.FName);
        acc2.withdraw(amount);

        acc1.deposit(amount);
       
    }
}

class ReadAccounts{
    LinkedList<String> firstNames = new LinkedList<String>();
    LinkedList<String> lastNames = new LinkedList<String>();
    LinkedList<Integer> accNumber = new LinkedList<Integer>();
    LinkedList<Integer> accBalance = new LinkedList<Integer>();

    public void ReadAccount(String URL){

        try{
            BufferedReader reader = new BufferedReader(new FileReader(URL));
            String line;


            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");
                System.out.println(data.length);

                //First Column 
                for (int i = 0; i < data.length; i+=5){
                    if (data[i] != "FName"){
                        firstNames.add(data[i]);
                    }else{
                        System.out.println("Not a value");
                    }
                }

                // Second Column 
                for (int i = 1; i < data.length; i+=5){
                    if (data[i] != "LName"){
                        lastNames.add(data[i]);
                        
                        
                    }else{
                        System.out.println("Not a value");
                    }
                }

                // Third Column 
                for (int i = 2; i < data.length; i+=5){
                    // firstNames.add(data[i]);
                    // firstNames.add(data[i]);
                    try {
                        accNumber.add(Integer.parseInt(data[i]));

                    } catch(NumberFormatException b){
                        System.out.println(b);
                    }              
                }

                //Fourth Column 
                for (int i = 3; i < data.length; i+=5){
                    // firstNames.add(data[i]);
                    // firstNames.add(data[i]);
                    if (data[i].equals("Balance")){
                        System.out.println("This value is AccNum");
                    }else{
                        accBalance.add(Integer.parseInt(data[i]));
                        // System.out.println(accBalance);
                        // System.out.println("True");
                    }                  
                }
                
            }
            reader.close();
            
            
            System.out.println("CSV file read successfully!");
        } catch (java.io.IOException e){
            System.out.println("Error reading CSV file: " + e);
        }

    }

    public LinkedList<String> getFirstNames(){
        return firstNames;
    }

    public LinkedList<String> getLastNames(){
        return lastNames;
    }
    
    public LinkedList<Integer> getAccounts(){
        return accNumber;
    }

    public LinkedList<Integer> getBalances(){
        return accBalance;
    }   
}
