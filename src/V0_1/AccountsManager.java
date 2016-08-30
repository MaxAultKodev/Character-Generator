/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package V0_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 *
 * @author Max
 */
public class AccountsManager implements Serializable 
{
    private ArrayList<PlayerAccount> userAccounts = new ArrayList<>();
    
    public AccountsManager()
    {
        
    }
    public void createNewAcct(String username, String password, String email)
    {
        userAccounts.add(new PlayerAccount(username, password, email));
    }
    public PlayerAccount loadAcct(String username, String password) throws EmptyStackException
    {
        for (PlayerAccount p : userAccounts)
            if (p.getUser().equals(username))
            {
                if (p.getPassword().equals(password))
                {
                    return p;
                }
            }
        else
            {
                throw new EmptyStackException();
            }
            
    return null;
    }
    
}
