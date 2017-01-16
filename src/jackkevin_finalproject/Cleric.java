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
public class Cleric extends Character{
    private int magic;
    
    public Cleric(String inputName, int inputMaxHealth, int inputMagic){
        super(inputName, inputMaxHealth);
        magic = inputMagic - 5;
    }
    
    public int getMagic(){                  //Accessor for the max health
        return magic;
    }
    
    public void setMagic(int newMagic){       //Mutator for the health
        magic = newMagic; 
    }
    public void revive(Character x){
        x.setCurrentHealth(x.getMaxHealth());
    }
    
    public void doubleHeal(Character x, Character y){
        x.setCurrentHealth(x.getCurrentHealth() + (magic + 5) * 2);
        if (x.getCurrentHealth() > x.getMaxHealth()){
            x.setCurrentHealth(x.getMaxHealth());
        }
        
        y.setCurrentHealth(y.getCurrentHealth() + (magic + 5) * 2);
        if (y.getCurrentHealth() > y.getMaxHealth()){
            y.setCurrentHealth(y.getMaxHealth());
        }
    }
    
    public void imbue(Character x){
        x.setCurrentHealth(x.getCurrentHealth() + (magic + 10) * 5);
        if (x.getCurrentHealth() > x.getMaxHealth()){
            x.setCurrentHealth(x.getMaxHealth());
        }
    }
    
    public void smite(Mob x){
        int dmg = magic;
        if (x.getDefenseDebuff()){
            dmg = (int)Math.ceil(dmg * 1.5);
        }
        dmg = (int)Math.ceil(dmg * (1.0 - x.getMagicRes() / 100));
        x.setCurrentHealth(x.getCurrentHealth() - dmg);
        x.setDefenseDebuff(true);
        x.setDefenseDebuffTick(1);
    }
}
