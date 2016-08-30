package V0_1;

import java.io.Serializable;
/**
 *
 * @author Max
 */
public class Character implements Serializable
{
    //User input
    private String name;
    Gender gender;
    Alignment alignment;
    Race race;
    
    //Random
    private int[] AbilityScore; // [0]Str,[1]Dex,[2]Con,[3]Int,[4]Wis,[5]Cha
    private int age,weight,height;
    //Constructors 1: New Characters 2:Loading Characters
    public Character(String name, Gender gender, Alignment alignment, Race race, int method )
    {
        //inputs
        setName(name);
        setGender(gender);
        setAlign(alignment);
        setRace(race);
        //generators
        setAge(race.generateAge());
        setWeight(race.generateWeight());
        setHeight(race.generateHeight());
        this.AbilityScore = rollScores(method);
        for (int i=0;i<AbilityScore.length;i++)
        {
            int[] tempMod = race.getModTable();
            AbilityScore[i]+= tempMod[i];
        }
    }
    public Character (String name, Gender gender, Alignment alignment, Race race, int age, int weight, int height, int[] AbilityScore)
    {
        setName(name);
        setGender(gender);
        setAlign(alignment);
        setRace(race);
        setAge(age);
        setWeight(weight);
        setHeight(height);
        this.AbilityScore = AbilityScore;
    }

    private int[] rollScores(int m)
    {
        int[] as = new int [6];
        for (int i=0;i<=as.length-1;i++)
        {
            as[i] = Dice.rollType(m);
        }
               
        return as;
    }
    @Override
    public String toString()
    {
        String x ="Name:" +name+ "\n"+"Race:"+race.race + " Age:"+age+"yrs \n"
                +"Gender:"+ gender.gender+ " Alignment:"+alignment.alignment+ " \n"
                +"Weight:"+weight+ "lbs. Height:"+heightMod(height)+ " \n"
                +"Str:"+AbilityScore [0] +" Dex:"+AbilityScore [1] +" Con:"+AbilityScore [2] +"\n"
                +"Int:"+AbilityScore [3] +" Wis:"+AbilityScore [4] +" Cha:"+AbilityScore [5] +"\n";
    return x;
    }
    public String heightMod(int height)
    {
        int fTemp = height / 12;
        int iTemp = (height % 12)*12;
        String heightS = fTemp+"'"+iTemp+"\"";
        return heightS;
    }
    // Set methods
    private void setName(String name)
    {
        this.name = name;
    }
    private void setGender(Gender gender)
    {
        this.gender= gender;
    }
    private void setAlign(Alignment alignment)
    {
        this.alignment = alignment;
    }
    private void setRace(Race race)
    {
        this.race = race;
    }
    private void setAge(int age)
    {
        this.age = age;
    }
    private void setWeight(int weight)
    {
        this.weight = weight;
    }
    private void setHeight(int height)
    {
        this.height = height;
    }
    //get methods
    public String getName()
    {
        return name;
    }
    public Gender getGender()
    {
    return gender;
    }
    public int getAge()
    {
        return age;
    }
    public Alignment getAlign()
    {
        return alignment;
    }
    public int getWeight()
    {
        return weight;
    }
    public int getHeight()
    {
        return height;
    }
    public Race getRace()
    {
        return race;
    }
    public int getAbility(int i)
    {
    return this.AbilityScore[i];
    }
    
    public void changeRace(Race r)
    {
        setAge(r.generateAge());
        setWeight(r.generateWeight());
        setHeight(r.generateHeight());
        int[] tempScore = this.AbilityScore;
        int[] tempTable = race.getModTable();
        for(int i = 0; i<=AbilityScore.length-1;i++)
        {
            tempScore [i] -= tempTable[i];
        }
        tempTable = r.getModTable();
        for (int i = 0;i<=AbilityScore.length-1;i++)
        {
            tempScore[i] += tempTable[i];
        }
        race = r;
    } 
}
