/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package V0_1;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Max
 */
public class Dice 
{
    public static int rollType(int rollType) 
    {
        switch (rollType) 
        {
            case 1:
                return threeD6();
            case 2:
                return fiveD6plusOne3D();
            case 3:
                return fiveD6();
            default:
                return threeD6();
                
        }
    }
    public static int fiveD6plusOne3D() 
    {
        Random rand = new Random();
        int[] roll = new int[5];
        roll[0] = rand.nextInt(6) + 1;
        roll[1] = rand.nextInt(6) + 1;
        roll[2] = rand.nextInt(6) + 1;
        roll[3] = rand.nextInt(6) + 1;
        roll[4] = rand.nextInt(6) + 1;
        Arrays.sort(roll);
        int rolls = rand.nextInt(3) + 1;
        return roll[2] + roll[3] + roll[4] + rolls;

    }

    public static int threeD6() 
    {
        Random rand = new Random();
        int[] roll = new int[3];
        roll[0] = rand.nextInt(6) + 1;
        roll[1] = rand.nextInt(6) + 1;
        roll[2] = rand.nextInt(6) + 1;
        //Arrays.sort(roll);
        return roll[1] + roll[2] + roll[0];

    }

    public static int fiveD6() 
    {
        Random rand = new Random();
        int[] roll = new int[5];
        roll[0] = rand.nextInt(6) + 1;
        roll[1] = rand.nextInt(6) + 1;
        roll[2] = rand.nextInt(6) + 1;
        roll[3] = rand.nextInt(6) + 1;
        roll[4] = rand.nextInt(6) + 1;
        Arrays.sort(roll);
        return roll[2] + roll[3] + roll[4];

    }
}
