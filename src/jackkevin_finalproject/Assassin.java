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
public class Assassin extends Character{
    private int strength;
    private boolean stealthed;
    
    public Assassin(String inputName, int inputMaxHealth, int inputStrength){
        super(inputName, inputMaxHealth);
        strength = inputStrength;
    }
    
    public int getStrength(){                  //Accessor for the max health
        return strength;
    }
    
    public void setStrength(int newStrength){       //Mutator for the health
        strength = newStrength; 
    }
        
    public boolean getStealthed(){
        return stealthed;
    } public void setStealthed(boolean newStealthed){ 
        stealthed = newStealthed; 
    } 
    
    public void stealth(){
        this.setDefenseBuff(true);
        this.setDefenseBuffTick(1);   
        this.setStealthed(true);
    }
    
    public void stab(Mob x){
        int dmg = strength;
        if (stealthed){
            dmg = dmg * 2;
        }
        if (x.getDefenseDebuff()){
            dmg = (int)Math.ceil(dmg * 1.5);
        }
        dmg = (int)Math.ceil(dmg * (1.0 - x.getArmor() / 100));
        x.setCurrentHealth(x.getCurrentHealth() - dmg);
        x.setDefenseDebuff(true);
        x.setDefenseDebuffTick(2);
    }
    
    public void assassinate(Mob x){
        int dmg = strength;
        int deathChance = 0;
        if (stealthed){
            if (x.getDefenseDebuff()){
                deathChance = (int)(Math.random() * ((10 - 1) + 1) + 1);
                dmg = (int)Math.ceil(dmg * 1.5);
            } else {
                deathChance = (int)(Math.random() * ((20 - 1) + 1) + 1);
            }
            dmg = dmg * 10;
        } else {
            if (x.getDefenseDebuff()){
                dmg = (int)Math.ceil(dmg * 1.5);
            }
        }
        
        dmg = (int)Math.ceil(dmg * (1.0 - x.getArmor() / 100));
        
        if (deathChance == 1){
            x.setCurrentHealth(0);
        } else {
            x.setCurrentHealth(x.getCurrentHealth() - dmg);
        }
    }
            
    public void smokescreen(Mob x){
        x.setDamageDebuff(true);
        x.setDamageDebuffTick(3);
    }
}
