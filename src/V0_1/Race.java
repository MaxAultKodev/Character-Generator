/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package V0_1;

import java.util.Random;

/**
 *
 * @author Max
 */
public enum Race
{
    
    HUMAN("Human",15,30,90,260,54,89,new int[]{0,0,0,0,0,0}),
    ELF("Elf",80,180,70,130,48,66,new int[]{0,2,-2,2,0,0}),
    DWARF("Dwarf",40,70,150,230,48,58,new int[]{2,0,2,0,0,-2}),
    GNOME("Gnome",30,50,55,80,30,41,new int[]{-2,2,2,0,0,0}),
    HALFLING("Halfling",30,60,40,60,38,51,new int[]{-2,2,0,0,2,0});

    public final String race;
    private final int minAge,maxAge,minWeight,maxWeight,minHeight,maxHeight;
    private final int[] modTable;
    
    
    
    private Race(String race,int minAge, int maxAge,int minWeight, int maxWeight,int minHeight,int maxHeight,int[] modTable)
    {
        this.race = race;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.modTable = modTable;
    }
    
        //Age, Weight, Hight generators
    public int generateAge()
    {
        Random rand = new Random();
        return rand.nextInt((maxAge-minAge)+1)
                + minAge;
    }
    public int generateWeight()
    {
        Random rand = new Random();
        return rand.nextInt((maxWeight - minWeight)+1)
                + this.minWeight;
    }
    public int generateHeight()
    {
        Random rand = new Random();
        return rand.nextInt((maxHeight - minHeight)+1)
                + this.minHeight;
    }
    public int[] getModTable()
    {
        return modTable;
    }
      
}