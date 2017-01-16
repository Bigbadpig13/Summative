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
public class Paladin extends Character{
    private int strength;
    
    public Paladin(String inputName, int inputMaxHealth, int inputStrength){
        super(inputName, inputMaxHealth);
        strength = inputStrength + 5;
    }
    
    public int getStrength(){                  //Accessor for the max health
        return strength;
    }
    
    public void setStrength(int newStrength){       //Mutator for the health
        strength = newStrength; 
    }
    
    public void godsFavor(Character x){
        int favor = (int)(Math.random() * ((40 - 15) + 1) + 15);
        x.setCurrentHealth(x.getCurrentHealth() + favor);
        if (x.getCurrentHealth() > x.getMaxHealth()){
            x.setCurrentHealth(x.getMaxHealth());
        }
    }
    
    public void divineShield(Character x){
        x.setDefenseBuff(true);
        x.setDefenseBuffTick(5);
    }
    
    public void illuminate(Mob x){
        x.setDamageDebuff(true);
        x.setDamageDebuffTick(3);
    }
    
    public void godsWrath(Mob x){
        int dmg = strength;
        
        if (x.getDefenseDebuff()){
            dmg = (int)Math.ceil(dmg * 1.5);
        }
        dmg = (int)Math.ceil(dmg * (1.0 - x.getArmor() / 100));
        x.setCurrentHealth(x.getCurrentHealth() - dmg);
        
        this.setCurrentHealth(this.getCurrentHealth() + dmg);
        if (this.getCurrentHealth() > this.getMaxHealth()){
            this.setCurrentHealth(this.getMaxHealth());
        }
    }
            
}
