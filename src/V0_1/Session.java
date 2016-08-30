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
public class Session 
{   
    private static int sessionState = 0;
    private static PlayerAccount currentPlayer;
    private static AccountsManager accounts;
    
    public static void Session()
    {
        while (sessionState != -1)
        {
            switch (sessionState)
            {
                case 0: initialState();break;
                case 1: loginState();break;
                case 2: createAcctState();break;
                case 3: userMainState();break;
                case 4: createCharState();break;
                case 5: loadCharState();break;
                case 6: eraseCharState();break;
                case 7: acctManagerState();break;
            }
        }
        wrapUp();
        DisplayMenu.closeDisplay();
    }
    
    private static void initialState()
    {
        accounts = startUp();
        DisplayMenu.initialDisplay();
        int i = HandleInput.getInputInt("Select a valid option 1-3");
        switch(i)
        {
            case 1: sessionState = 1;break;
            case 2: sessionState = 2;break;
            case 3: sessionState = -1;break;
        }
    }
    private static void loginState()
    {
        String uN = HandleInput.getInputString("Enter Username: ");
        String pW = HandleInput.getInputString("Enter Password: ");
        try 
        {
            currentPlayer =  accounts.loadAcct(uN, pW);
            if (currentPlayer == null)
            {
                    DisplayMenu.noAcctsDisplay();
                    sessionState = 0;
            }
            else
            {
                sessionState = 3;
            }
        }
        catch (Exception ex)
        {
            DisplayMenu.userError();
            sessionState = 1;
        }
    }
    private static void createAcctState()
    {
        String uN = HandleInput.getInputString("Enter a Username: ");
        String pW = HandleInput.getInputString("Enter a Password: ");
        String eM = HandleInput.getInputString("Enter an Email Address");
        
        accounts.createNewAcct(uN, pW, eM);
        DisplayMenu.createAcctDisplay(uN);
                
        sessionState = 1;
    }
    private static void userMainState()
    {
        DisplayMenu.userDisplay();
        int i = HandleInput.getInputInt("Select a valid option 1-5: ");
        switch(i)
        {
            case 1: sessionState = 4;break;
            case 2: sessionState = 5;break;
            case 3: sessionState = 6;break;
            case 4: sessionState = 7;break;
            case 5: sessionState = -1;break;
        }
    }
    private static void createCharState()
    {
        
        String sTemp = HandleInput.getInputString("Enter Character Name: ");
        Gender gTemp = inputGender();
        DisplayMenu.alignmentDisplay();
        Alignment aTemp = inputAlign();
        DisplayMenu.raceDisplay();
        Race rTemp = inputRace();
        DisplayMenu.diceMethodDisplay();
        int dTemp = HandleInput.getInputInt("Select an Option");
        currentPlayer.addCharacter(new Character(sTemp,gTemp,aTemp,rTemp,dTemp));
        System.out.println(currentPlayer.findLastCharacter().toString());
        int qTemp = HandleInput.getInputInt("Do you like this Character?\n [1]Continue [2]Discard "+sTemp);
        if (qTemp ==1)
        {
            sessionState = 3;
        }
        else
        {
            eraseCharacter(currentPlayer.characters.size()-1);
            sessionState = 4;
        }
        
    }
    private static void loadCharState()
    {
        if (currentPlayer.characters.isEmpty())
        {
            DisplayMenu.noCharsDisplay();
            sessionState = 3;
        }
        else
        {
            DisplayMenu.characterDisplay(currentPlayer.listCharacters());
            int charSelection =HandleInput.getInputInt("Select an Option");
            DisplayMenu.characterDisplay(currentPlayer.characters.get(charSelection - 1).toString());
            DisplayMenu.loadCharDisplay();
            int lTemp = HandleInput.getInputInt("Select an Option");
            if (lTemp == 1)
            {
                changeRaces(charSelection - 1);
                DisplayMenu.characterDisplay(currentPlayer.characters.get(charSelection - 1).toString());
                sessionState = 3;
            }
            else
            {
                sessionState = 3;
            }
        }
    }
    private static void eraseCharState()
    {   
        if (currentPlayer.characters.isEmpty())
        {
            DisplayMenu.noCharsDisplay();
            sessionState = 3;
        }
        else
        {
            DisplayMenu.characterDisplay(currentPlayer.listCharacters());
            int charSelection =HandleInput.getInputInt("Select an Option");
            Character temp  = currentPlayer.characters.get(charSelection - 1);
            DisplayMenu.characterDisplay(temp.toString());
            DisplayMenu.eraseCharDisplay();
            int lTemp = HandleInput.getInputInt("Select an Option");
            if (lTemp == 1)
            {
                DisplayMenu.eraseCharDisplay();
                eraseCharacter(charSelection-1);
                sessionState = 3;
            }
            else
            {
                sessionState = 3;
            }
        }
    }
    private static void acctManagerState()
    {
        DisplayMenu.acctManagerDisplay();
        int temp = HandleInput.getInputInt("Select an Option");
        switch (temp)
        {
            case 1:currentPlayer.changePassword();break;
            case 2:currentPlayer.changeEmail();break;
            case 3:sessionState = 3;break;
        }
    }
    private static Gender inputGender()
    {
        int gTemp = HandleInput.getInputInt("Select Gender: [1]Male  [2]Female");
        if (gTemp == 1)
        {
            return Gender.MALE;
        }
            return Gender.FEMALE;
    
    }
    private static Alignment inputAlign()
    {
        Alignment alignmentChoice= Alignment.NN;
        int aTemp = HandleInput.getInputInt("Select Alignment: ");
            switch (aTemp)
            {
                case 1: alignmentChoice = Alignment.LG ; break;
                case 2: alignmentChoice = Alignment.LN ; break;
                case 3: alignmentChoice = Alignment.LE; break;
                case 4: alignmentChoice = Alignment.NG; break;
                case 5: alignmentChoice = Alignment.NN; break;
                case 6: alignmentChoice = Alignment.NE; break;
                case 7: alignmentChoice = Alignment.CG; break;
                case 8: alignmentChoice = Alignment.CN; break;
                case 9: alignmentChoice = Alignment.CE; break;
            }
        return alignmentChoice;
    }
    private static Race inputRace()
    {
        Race raceChoice = Race.HUMAN;
        int rTemp = HandleInput.getInputInt("Select Race: ");
            switch (rTemp)
            {
                case 1 :raceChoice = Race.HUMAN;break;
                case 2 :raceChoice = Race.ELF;break;
                case 3 :raceChoice = Race.DWARF;break;
                case 4 :raceChoice = Race.GNOME;break;
                case 5 :raceChoice = Race.HALFLING;break;
            }
        
    return raceChoice;
    }
    private static void changeRaces(int pos)
    {
        DisplayMenu.raceDisplay();
        Race rTemp = inputRace();
        Character temp = currentPlayer.characters.get(pos);
        temp.changeRace(rTemp);
        currentPlayer.characters.set(pos, temp);
    }
    private static void eraseCharacter(int pos)
    {
        currentPlayer.characters.remove(pos);
    }

    private static AccountsManager startUp()
    {
        
        return FileHandler.loadAccts();
    }
    private static void wrapUp()
    {
        FileHandler.saveAccts(accounts);
    }
}
