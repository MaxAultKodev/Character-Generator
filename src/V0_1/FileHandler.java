/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package V0_1;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Max
 */
public class FileHandler 
{
    
    public static boolean saveAccts(AccountsManager x)
    {
        //COME BACK File IO.
        try (
           OutputStream file = new FileOutputStream("accounts.ser");
           OutputStream buffer = new BufferedOutputStream(file);
           ObjectOutput output = new ObjectOutputStream(buffer);)
        {
            output.writeObject(x);
        }  
        catch(IOException ex)
        {
            return false;
        }

    return true;
    }
    public static AccountsManager loadAccts()
    {
        //COME BACK: File IO.
        try(InputStream file = new FileInputStream("accounts.ser");
                InputStream buffer  = new BufferedInputStream(file);
                ObjectInput input = new ObjectInputStream(buffer);)
        {
            AccountsManager temp = (AccountsManager)input.readObject();
            return temp;
        }
        catch(IOException e)
        {
            return new AccountsManager();
        } catch (ClassNotFoundException ex) 
        {
            return new AccountsManager();
        }
    }
}
