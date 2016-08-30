/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package V0_1;
/**
 *
 * @author Max
 */
public class DisplayMenu 
{
    public static void initialDisplay()
    {
        System.out.println("Welcome to Underdark Knight's Random Character Generator");
        System.out.println("[1] Login \n[2] Create \n[3] Exit");
    }
    
    public static void createAcctDisplay(String uN)
    {
        System.out.println("Account "+uN+" created.");
    }
    public static void userDisplay()
    {
        
        System.out.println("[1]Create Character [2]Load Character\n"
                +"[3]Erase Character  [4]Account Manager\n"
                +"[5]Exit");
    
    }
    public static void diceMethodDisplay()
    {
        System.out.println("[1] 3d6 [2] 5d6+1d3 [3] 5d6");
    }
    public static void loadCharDisplay()
    {
        System.out.println("[1]Alter Character \n[2]Back");        
    }
    public static void eraseCharDisplay()
    {
        
        System.out.println("WARNING: DELETING A CHARACTER IS PERMA-DEATH");
        System.out.println("[1]Erase Character \n[2]Back");
    }
    public static void noCharsDisplay()
    {
        System.out.println("No Characters Exist");
    }
        public static void noAcctsDisplay()
    {
        System.out.println("No Accounts Exist");
    }
    public static void characterDisplay(String chars)
    {
        
        System.out.println(chars);
    }
    public static void acctManagerDisplay()
    {
        System.out.println("[1] Change Password \n[2] Change Email \n[3] Main Menu");
    }
    public static void closeDisplay()
    {
        System.out.println("Thank you for using UnderDark Knight's Character Creator");
    }
    public static void passError()
    {
        System.out.println("You have entered an incorrect Password");
    }
        public static void userError()
    {
        System.out.println("You have entered an incorrect Username");
    }
        public static void emailError()
    {
        System.out.println("You have entered an incorrect Email");
    }
    public static void alignmentDisplay()
    {
          int count = 1;
        String temp = "";
        for(Alignment a : Alignment.values())
        {
            temp +="  ["+count+"]"+a.alignment;
            
            if (count%3 == 0)
                temp+="\n";
            count++;
        }
        System.out.println(temp);
    }
        public static void raceDisplay()
    {
          int count = 1;
        String temp = "";
        for(Race r : Race.values())
        {
            temp +=" ["+count+"]"+r.race;
            
            if (count%5 == 0)
                temp+="\n";
            count++;
        }
        System.out.println(temp);
    }
}
