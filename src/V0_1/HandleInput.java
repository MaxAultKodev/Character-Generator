/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package V0_1;
import java.util.Scanner;
/**
 *
 * @author Max
 */
import java.util.InputMismatchException;
public class HandleInput 
{

    
    public static String getInputString(String prompt)
    {   Scanner in = new Scanner(System.in);
        System.out.println(prompt);
        String input = in.nextLine();
        
        return input;
    }
    
    public static int getInputInt(String prompt)
    {   Scanner in = new Scanner(System.in);
        System.out.println(prompt);
        try
        {
            int input = in.nextInt();
            return input;
        }
        catch(InputMismatchException ex)
        {
         System.out.println("Invalid Input. Try Again.");
         getInputInt(prompt);
        }
        return 0;
    }
}
