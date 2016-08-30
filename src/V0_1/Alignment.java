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
public enum Alignment 
{
    LG ("Lawful Good"),
    LN ("Lawful Neutral"),
    LE ("Lawful Evil"),
    NG ("Neutral Good"),
    NN ("True Neutral"),
    NE ("Neutral Evil"),
    CG ("Chaotic Good"),
    CN ("Chaotic Neutral"),
    CE ("Chaotic Evil");
    
    public final String alignment;
    
    private Alignment(String alignment)
    {
        this.alignment = alignment;
    }
    
}
