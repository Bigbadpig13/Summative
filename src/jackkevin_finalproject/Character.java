/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jackkevin_finalproject;

/**
 *
 * @author Kevin
 */
public abstract class Character implements entityInterface{
    private final String NAME;
    private final int MAXHEALTH;
    private int currentHealth;
    private boolean alive;
    private boolean defenseBuff;
    private int defenseBuffTick;

    public Character(String inputName, int inputMaxHealth){
        NAME = inputName;
        currentHealth = inputMaxHealth;
        MAXHEALTH = inputMaxHealth;
        alive = true;
    }
            
    public String getName(){                    //Accessor for the name
        return NAME;
    }

    public int getCurrentHealth(){                     //Accessor for the health
        return currentHealth;
    }
    
    public void setCurrentHealth(int newHealth){       //Mutator for the health
        currentHealth = newHealth; 
    }
    
    public int getMaxHealth(){                  //Accessor for the max health
        return MAXHEALTH;
    }
    
    public boolean getDefenseBuff(){
        return defenseBuff;
    }
    public void setDefenseBuff(boolean newDefenseBuff){
        defenseBuff = newDefenseBuff;
    }
    
    public int getDefenseBuffTick(){
        return defenseBuffTick;
    }
    public void setDefenseBuffTick(int newDefenseBuffTick){
        defenseBuffTick = newDefenseBuffTick;
    }

    public String toString(){                   //toString method
        String output = "MOB: " + NAME
                
                
                + "\nHealth: " + currentHealth + "/" + MAXHEALTH
                + "\n";
        return output;
    }
}
