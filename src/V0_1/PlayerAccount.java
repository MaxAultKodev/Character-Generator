/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package V0_1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Max
 */
public class PlayerAccount implements Serializable
{
    private String username;
    private String password;
    private String email;
    ArrayList<Character> characters;
    //constructor
    public PlayerAccount (String username, String password, String email)
    {
        setUser(username);
        setPassword(password);
        setEmail(email);
        characters = new ArrayList<>();
    }
    public PlayerAccount (String username, String password, String email, ArrayList<Character> characters )
    {
        setUser(username);
        setPassword(password);
        setEmail(email);
        this.characters = characters;
    }
    public void addCharacter(Character t)
    {
        characters.add(t);
    }
    //set methods
    private void setUser(String username)
    {
        this.username = username;
    }
    private void setPassword(String password)
    {
        this.password = password;
    }
    private void setEmail(String email)
    {
        this.email = email;
    }

    //get methods
    
    public String getUser()
    {
        return username;
    }
    public String getPassword()
    {
        return password;
    }
    public String getEmail()
    {
        return email;
    }
    public ArrayList<Character> getCharacters()
    {
    return characters;
    }
    //finders
    public String findCharacterS(Character chars)
    {
        chars = findLastCharacter();
        String charsS = chars.toString();
        return charsS;
    }
    public Character findLastCharacter()
    {
        if(characters.isEmpty())
        {
            return null;
        }
        characters.trimToSize();
        
        return characters.get(characters.size() -1 );
    }
    public String listCharacters()
    {
        String temp = "";
        int count =1;
        for (Character i : characters)
        {
            temp += " ["+count+"]"+i.getName();
            count ++;
        }
        return temp;
    }
    //Account Management
    public void changePassword()
    {
        String pass = HandleInput.getInputString("Enter Current Password");
        if (pass.equals(getPassword()))
        {
            String tempA = HandleInput.getInputString("Please enter new password: ");
            String tempB = HandleInput.getInputString("Please enter password again: ");
             if (tempA.equals(tempB))
             {
                 setPassword(tempA);
             }
        }
        else
            DisplayMenu.passError();
    }
    public void changeEmail()
    {
            String tempA = HandleInput.getInputString("Please enter new Email: ");
            String tempB = HandleInput.getInputString("Please enter Email again: ");
             if (tempA.equals(tempB))
             {
                 setEmail(tempA);
             }
             else
             {
                 DisplayMenu.emailError();
             }
    }
         
}
