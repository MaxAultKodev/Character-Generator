package V0_1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Max
 */
public enum Gender 
{
    MALE("Male"),
    FEMALE("Female");
    
    public final String gender;
    
    private Gender(String gender)
    {
        this.gender = gender;
    }
    
}
