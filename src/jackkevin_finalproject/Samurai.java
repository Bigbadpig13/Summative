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
public class Samurai extends Character{
    private int strength;

    
    public Samurai(String inputName, int inputMaxHealth, int inputStrength){
        super(inputName, inputMaxHealth);
        strength = inputStrength;
    }
    
    public int getStrength(){                  //Accessor for the max health
        return strength;
    }
    
    public void setStrength(int newStrength){       //Mutator for the health
        strength = newStrength; 
    }

    
    public void slash(Mob x){
        int critChance = (int)(Math.random() * ((3 - 1) + 1) + 1);
        int dmg = strength;
        if (critChance == 1){
            dmg = dmg * 3;
        }
        if (x.getDefenseDebuff()){
            dmg = (int)Math.ceil(dmg * 1.5);
        }
        dmg = (int)Math.ceil(dmg * (1.0 - x.getArmor() / 100));
        x.setCurrentHealth(x.getCurrentHealth() - dmg);
    }
    
    public void comboStrike(Mob x){
        int dmg = (int)Math.ceil(strength / 2);
        if (x.getDefenseDebuff()){
            dmg = (int)Math.ceil(dmg * 1.5);
        }
        dmg = (int)Math.ceil(dmg * (1.0 - x.getArmor() / 100));
        int strikes = (int)(Math.random() * ((11 - 5) + 1) + 4);
        for (int i = 1; i <= strikes; i++){
            x.setCurrentHealth(x.getCurrentHealth() - dmg);
        }
    }
    
    public void cut(Mob x){
        int dmg = (int)Math.ceil(strength * 1.5);
        if (x.getDefenseDebuff()){
            dmg = (int)Math.ceil(dmg * 1.5);
        }
        dmg = (int)Math.ceil(dmg * (1.0 - x.getArmor() / 100));
        x.setCurrentHealth(x.getCurrentHealth() - dmg);
    }
    
    public void sidestep(){
        this.setDefenseBuff(true);
        this.setDefenseBuffTick(1);     
    }
}
