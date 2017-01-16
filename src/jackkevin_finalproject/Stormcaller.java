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
public class Stormcaller extends Character {
    private int magic;
    
    public Stormcaller(String inputName, int inputMaxHealth, int inputMagic){
        super(inputName, inputMaxHealth);
        magic = inputMagic;
    }
    
    public int getMagic(){                  //Accessor for the max health
        return magic;
    }
    
    public void setMagic(int newMagic){       //Mutator for the health
        magic = newMagic; 
    }
    
    public void tornado(Mob x){
        x.setDoT(true);
        if (x.getDefenseDebuff()){
            x.setDoTTick(5);
        } else {
            x.setDoTTick(3);
        }
    }
    
    public void thunderstrike(Mob x){
        int dmg = magic;
        if (x.getDefenseDebuff()){
            dmg = (int)Math.ceil(dmg * 1.5);
        }
        dmg = (int)Math.ceil(dmg * (1.0 - x.getMagicRes() / 100));
        x.setCurrentHealth(x.getCurrentHealth() - dmg);
        
        int doubleChance = (int)(Math.random() * ((4 - 1) + 1) + 1);
        if (doubleChance == 1){
            x.setCurrentHealth(x.getCurrentHealth() - dmg);
        }
    }
    
    public void heal(Character x){
        x.setCurrentHealth(x.getCurrentHealth() + magic);
        if (x.getCurrentHealth() > x.getMaxHealth()){
            x.setCurrentHealth(x.getMaxHealth());
        }
    }
    
    public void windwall(Character x){
        x.setDefenseBuff(true);
        x.setDefenseBuffTick(3);
    }
}
